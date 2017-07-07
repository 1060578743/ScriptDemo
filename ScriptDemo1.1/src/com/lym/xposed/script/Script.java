package com.lym.xposed.script;

import android.content.Context;
import android.widget.Toast;

import com.lym.xposed.UiDevice;
import com.lym.xposed.application.App;
import com.lym.xposed.utils.LogUtil;

public class Script implements Runnable {
	private Context mContext;
	private boolean mIsStart;
	private Thread mScriptThread;
	public Script(Context context) {
		mContext = context;
	}

	public boolean isStart() {
		return mIsStart;
	}

	@Override
	public void run() {
		try {
			scriptMain();
		} catch (InterruptedException e) {
		}
		stop();
	}

	public void scriptMain() throws InterruptedException {
	}

	void sleep() throws InterruptedException {
		sleep(1000);
	}

	public void sleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void start() {
		if (mIsStart) {
			return;
		}
		mIsStart = true;
		App.instance.floatView.drawFloatView(true);
		mScriptThread = new Thread(this);
		mScriptThread.start();
	}

	public void stop() {
		if (!mIsStart) {
			return;
		}
		mIsStart = false;
		App.instance.floatView.drawFloatView(false);
		mScriptThread.interrupt();

	}

	public void toast(String msg) {
		try {
			Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			LogUtil.log(e);
		}
	}

}
