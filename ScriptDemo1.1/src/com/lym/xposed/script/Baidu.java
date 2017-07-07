package com.lym.xposed.script;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.content.Context;

import com.lym.xposed.UiDevice;
import com.lym.xposed.model.Tiezi;
import com.lym.xposed.utils.FileUtil;
import com.lym.xposed.utils.SU;

public class Baidu extends Script {
	class CodeException extends Exception {
		private static final long serialVersionUID = -7094483620894012408L;
	}

	class SendException extends Exception {
		private static final long serialVersionUID = 5933964534824866671L;

	}

	final String file = "/data/local/tmp/tiezi.txt";
	UiDevice device;
	public static int sleepTime = 5;

	Map<String, List<Tiezi>> maps;

	public Baidu(Context context) {
		super(context);
		device = UiDevice.getInstance();
	}

	private void readData() {
		maps = new HashMap<String, List<Tiezi>>();
		String data = FileUtil.read(file).trim();
		if (data == null) {
			return;
		}
		data = data.replace("\r", "");
		String lines[] = data.split("\n");
		boolean in = false;
		String ba = null;
		String title = null;
		for (String line : lines) {
			if (line == null || "".equals(line = line.trim())) {
				continue;
			}
			if (line.equals("{")) {
				in = true;
				title = null;
				continue;
			}
			if (line.equals("}")) {
				in = false;
				title = null;
				ba = null;
				continue;
			}
			if (in) {
				// 帖子列表
				if (ba == null) {
					continue;
				}
				if (title == null) {
					title = line;
					continue;
				}
				// 添加帖子
				maps.get(ba).add(new Tiezi(title, line));
				title = null;
			} else {
				ba = line;
				maps.put(ba, new ArrayList<Tiezi>());
			}
		}
	}

	private void saveData() {
		StringBuffer sb = new StringBuffer();
		for (String key : maps.keySet()) {
			List<Tiezi> tiezies = maps.get(key);
			sb.append(key + "\n");
			sb.append("{\n");
			for (Tiezi t : tiezies) {
				sb.append(t.title + "\n");
				sb.append(t.link + "\n");
			}
			sb.append("}\n");
		}
		FileUtil.write(file, sb.toString());
	}

	private void openTieba(String tieba) throws Exception {
		SU.stopPackage("com.baidu.tieba");
		sleep(2000);
		SU.startActivity("com.baidu.tieba/.frs.FrsActivity --es name " + tieba);
		device.waitActivity("FrsActivity");
		sleep();
	}

	private void send(String title, String link) throws Exception {

		device.res("com.baidu.tieba:id/normal_write_icon").click();
		sleep();
		device.res("com.baidu.tieba:id/home_write_url").click();
		sleep();
		device.res("com.baidu.tieba:id/url_input").setText(link);
		sleep();
		device.res("com.baidu.tieba:id/url_add").click();
		sleep();
		device.res("com.baidu.tieba:id/post_content").setText(title);
		sleep(sleepTime * 1000);
		// 发送
		device.res("com.baidu.tieba:id/right_textview").click();
		// 点击确定
		device.res("com.baidu.tieba:id/transmit_cofirm").click();
		try {
			device.waitActivity("FrsActivity", 4000);
			// 成功发布，保存进度
			return;
		} catch (Exception e) {
			if (e instanceof InterruptedException) {
				throw e;
			}
		}
		if (device.getActivity().getName().contains("NewVcodeActivity")) {
			// 出现验证码界面
			throw new CodeException();
		}
		// 未成功发布
		throw new SendException();
	}

	@Override
	public void scriptMain() throws InterruptedException {
		readData();
		do {
			boolean sendOk = true;
			// 检测是否发布完毕
			for (String key : maps.keySet()) {
				if (maps.get(key).size() > 0) {
					// 未发布完毕
					sendOk = false;
					break;
				}
			}
			if (sendOk) {
				// 发布完毕
				break;
			}
			String keys[] = new String[maps.keySet().size()];
			maps.keySet().toArray(keys);
			for (String key : keys) {
				if (maps.get(key) == null || maps.get(key).size() == 0) {
					maps.remove(key);
					continue;
				}
				// 打开贴吧
				try {
					openTieba(key);
				} catch (Exception e) {
					if (e instanceof InterruptedException) {
						throw (InterruptedException) e;
					}
					continue;
				}
				sleep(sleepTime * 1000);
				// 发帖子
				Iterator<Tiezi> it = maps.get(key).iterator();
				while (it.hasNext()) {
					Tiezi t = it.next();
					it.remove();
					saveData();
					try {
						send(t.title, t.link);
					} catch (Exception e) {
						if (e instanceof CodeException) {
							// 验证码界面，本贴吧不可以发帖子了,下一个贴吧
							break;
						}
						if (e instanceof SendException) {
							// 发表失败，下一个贴吧
							break;
						}
						if (e instanceof InterruptedException) {
							// 停止了
							throw (InterruptedException) e;
						}
					}

				}
			}
		} while (isStart());
	}
}
