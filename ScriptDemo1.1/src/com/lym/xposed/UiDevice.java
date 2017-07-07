package com.lym.xposed;

import com.lym.xposed.aidl.IActivity;
import com.lym.xposed.aidl.IDialog;
import com.lym.xposed.aidl.IToast;
import com.lym.xposed.aidl.IView;

public class UiDevice {
	private static UiDevice instance;

	public static synchronized UiDevice getInstance() {
		if (instance == null) {
			instance = new UiDevice();
		}
		return instance;
	}

	private IActivity activity;
	private IDialog dialog;

	private IToast toast;

	private UiDevice() {
	}

	public IView clz(Class<?> clz) throws Exception {
		return clz(clz, 6000);
	}

	public IView clz(Class<?> clz, int timeout) throws Exception {
		long end = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < end) {
			IView view = getActivity().getView().clssName(clz.getName(), 0);
			if (view.exist()) {
				return view;
			}
			Thread.sleep(1000);
		}
		throw new Exception("time out");
	}

	public IActivity getActivity() {
		return activity;
	}

	public IDialog getDialog() {
		return dialog;
	}

	public IToast getToast() {
		return toast;
	}

	public IView res(String id) throws Exception {
		return res(id, 6000);
	}

	public IView res(String id, int timeout) throws Exception {
		long end = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < end) {
			IView view = getActivity().getView().res(id);
			if (view.exist()) {
				return view;
			}
			Thread.sleep(1000);
		}
		throw new Exception("time out");
	}

	public IView select(Selector selector) throws Exception {
		Selector next = selector.getRoot();
		IView view = getActivity().getView();

		while ((next = next.getNext()) != null) {
			switch (next.getType()) {
			case Selector.TYPE_TEXT: {
				view = view.text(next.getContent(), next.getIndex());
				break;
			}
			case Selector.TYPE_CHILD: {
				view = view.child(Integer.parseInt(next.getContent()));
				break;
			}
			case Selector.TYPE_CLASS: {
				view = view.clssName(next.getContent(), next.getIndex());
				break;
			}
			case Selector.TYPE_ID: {
				view = view.res(next.getContent());
				break;
			}
			}
			if (!view.exist()) {
				return view;
			}
		}
		return view;
	}

	public void setActivity(IActivity activity) {
		this.activity = activity;
	}

	public void setDialog(IDialog dialog) {
		this.dialog = dialog;
	}

	public void setToast(IToast toast) {
		this.toast = toast;
	}

	public IView text(String text, int timeout) throws Exception {
		long end = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < end) {
			IView r = activity.getView().text(text, 0);
			if (r.exist()) {
				return r;
			}
			Thread.sleep(1000);
		}
		throw new Exception("time out");
	}

	public IActivity waitActivity(String name) throws Exception {
		return waitActivity(name, 6000);
	}

	public IActivity waitActivity(String name, int timeout) throws Exception {
		long end = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < end) {
			if (getActivity().getName().contains(name)) {
				return getActivity();
			}
			Thread.sleep(1000);
		}
		throw new Exception("time out");
	}

	public IView waitView(Selector selector) throws Exception {
		return waitView(selector, 6000);
	}

	public IView waitView(Selector selector, int timeout) throws Exception {
		long end = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < end) {
			IView view = select(selector);
			if (view.exist()) {
				return view;
			}
			Thread.sleep(1000);
		}
		throw new Exception("time out");
	}

	public void click(int x, int y) throws Exception {
		activity.click(x, y);
	}

	public void sendKeycode(int keycode) throws Exception {
		activity.sendKeycode(keycode);
	}

}
