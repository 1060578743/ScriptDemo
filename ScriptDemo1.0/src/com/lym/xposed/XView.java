package com.lym.xposed;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;

import com.lym.xposed.aidl.IView;
import com.lym.xposed.utils.ViewUtil;

public class XView extends IView.Stub {
	private View view;

	public XView(View view) {
		super();
		this.view = view;
	}
	// ¡Ì
	@Override
	public IView child(int index) throws RemoteException {
		View view = null;
		if (this.view instanceof ViewGroup) {
			view = ((ViewGroup) this.view).getChildAt(index);
		}
		return new XView(view);
	}
	// ¡Ì
	@Override
	public int childCount() throws RemoteException {
		int count = 0;
		if (this.view instanceof ViewGroup) {
			count = ((ViewGroup) this.view).getChildCount();
		}
		return count;
	}
	// ¡Ì
	@Override
	public IView parent() throws RemoteException {
		return new XView((View) view.getParent());
	}

	@Override
	public IView res(String res) throws RemoteException {
		int id = XConnection.getInstance().getActivity().getResources()
				.getIdentifier(res, null, null);
		View view = this.view.findViewById(id);
		return new XView(view);
	}
	// ¡Ì
	@Override
	public IView id(int id) throws RemoteException {
		return new XView(view.findViewById(id));
	}
	// ¡Ì
	@Override
	public IView clssName(String clz) throws RemoteException {
		ArrayList<View> results = new ArrayList<View>();
		try {
			ViewUtil.findViewsByClass(results, clz, view);
		} catch (ClassNotFoundException e) {
		}
		View v = null;
		if (results.size() > 0) {
			v = results.get(0);
		}
		return new XView(v);
	}
	// ¡Ì
	@Override
	public IView text(String text) throws RemoteException {
		ArrayList<View> results = new ArrayList<View>();
		ViewUtil.findViewsByText(results, text, false, view);
		View v = null;
		if (results.size() > 0) {
			v = results.get(0);
		}
		return new XView(v);
	}

	@Override
	public IView hint(String text) throws RemoteException {

		return null;
	}

	@Override
	public IView desc(String text) throws RemoteException {

		return null;
	}

	@Override
	public int x() throws RemoteException {
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		return location[0];
	}
	// ¡Ì
	@Override
	public int y() throws RemoteException {
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		return location[1];
	}
	// ¡Ì
	@Override
	public int w() throws RemoteException {
		return view.getWidth();
	}
	// ¡Ì
	@Override
	public int h() throws RemoteException {
		return view.getHeight();
	}

	@SuppressLint("Recycle")
	@Override
	public void click() throws RemoteException {
		MotionEvent event1 = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, x() + w()
						/ 2, y() + h() / 2, 0);
		MotionEvent event2 = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, x() + w()
						/ 2, y() + h() / 2, 0);
		view.dispatchTouchEvent(event1);
		view.dispatchTouchEvent(event2);
	}

	@SuppressLint("Recycle")
	@Override
	public void clickXY(int x, int y) throws RemoteException {
		MotionEvent event1 = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, x, y, 0);
		MotionEvent event2 = MotionEvent.obtain(SystemClock.uptimeMillis(),
				SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, x, y, 0);
		view.dispatchTouchEvent(event1);
		view.dispatchTouchEvent(event2);
	}

	@Override
	public void longClick() throws RemoteException {

	}

	@Override
	public void doubleClick() throws RemoteException {

	}

	@Override
	public void swipe(int w, int h, int step) throws RemoteException {

	}

	// ¡Ì
	@Override
	public void setText(final String text) throws RemoteException {
		XConnection.getInstance().getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				EditText edit = (EditText) view;
				edit.setText(text);
			}
		});
	}

	// ¡Ì
	@Override
	public String getText() throws RemoteException {
		String txt = null;
		try {
			txt = ViewUtil.getAllText(view);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}

	// ¡Ì
	@Override
	public boolean showen() throws RemoteException {
		return view.isShown();
	}

	// ¡Ì
	@Override
	public boolean exist() throws RemoteException {
		return view != null;
	}

	// ¡Ì
	@Override
	public String dump() throws RemoteException {
		return ViewUtil.dump(view);
	}

	// ¡Ì
	@Override
	public int getCount() throws RemoteException {
		if (view instanceof AbsListView) {
			return ((AbsListView) view).getCount();
		}
		return 0;
	}

	// ¡Ì
	@Override
	public void scroll(int distance, int duration) throws RemoteException {
		if (view instanceof AbsListView) {
			((AbsListView) view).smoothScrollBy(distance, duration);
		}
	}

	// ¡Ì
	@Override
	public String getName() throws RemoteException {
		return view.getClass().getName();
	}

	// ¡Ì
	@Override
	public void press(int keycode) throws RemoteException {
		new Instrumentation().sendKeyDownUpSync(keycode);
	}

}
