package com.lym.xposed;

import java.util.ArrayList;

import android.os.RemoteException;
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

	// ��
	@Override
	public IView child(int index) throws RemoteException {
		View view = null;
		if (this.view instanceof ViewGroup) {
			view = ((ViewGroup) this.view).getChildAt(index);
		}
		return new XView(view);
	}

	// ��
	@Override
	public int childCount() throws RemoteException {
		int count = 0;
		if (this.view instanceof ViewGroup) {
			count = ((ViewGroup) this.view).getChildCount();
		}
		return count;
	}

	// ��
	@Override
	public IView parent() throws RemoteException {
		return new XView((View) view.getParent());
	}

	@Override
	public IView res(String res) throws RemoteException {
		int id = XActivity.getInstance().getActivity().getResources()
				.getIdentifier(res, null, null);
		View view = this.view.findViewById(id);
		return new XView(view);
	}

	// ��
	@Override
	public IView clssName(String clz, int index) throws RemoteException {
		ArrayList<View> results = new ArrayList<View>();
		try {
			ViewUtil.findViewsByClass(results, clz, view);
		} catch (ClassNotFoundException e) {
		}
		View v = null;
		if (results.size() > index) {
			v = results.get(index);
		}
		return new XView(v);
	}

	// ��
	@Override
	public IView text(String text, int index) throws RemoteException {
		ArrayList<View> results = new ArrayList<View>();
		ViewUtil.findViewsByText(results, text, false, view);
		View v = null;
		if (results.size() > index) {
			v = results.get(index);
		}
		return new XView(v);
	}

	@Override
	public IView hint(String text, int index) throws RemoteException {

		return null;
	}

	@Override
	public IView desc(String text, int index) throws RemoteException {

		return null;
	}

	@Override
	public int x() throws RemoteException {
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		return location[0];
	}

	// ��
	@Override
	public int y() throws RemoteException {
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		return location[1];
	}

	// ��
	@Override
	public int w() throws RemoteException {
		return view.getWidth();
	}

	// ��
	@Override
	public int h() throws RemoteException {
		return view.getHeight();
	}

	@Override
	public void click() throws RemoteException {
		XActivity.getInstance().getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				view.performClick();
			}
		});
	}

	@Override
	public void longClick() throws RemoteException {

	}

	@Override
	public void doubleClick() throws RemoteException {

	}

	// ��
	@Override
	public void setText(final String text) throws RemoteException {
		XActivity.getInstance().getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				EditText edit = (EditText) view;
				edit.setText(text);
			}
		});
	}

	// ��
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

	// ��
	@Override
	public boolean showen() throws RemoteException {
		return view.isShown();
	}

	// ��
	@Override
	public boolean exist() throws RemoteException {
		return view != null;
	}

	// ��
	@Override
	public String dump() throws RemoteException {
		return ViewUtil.dump(view);
	}

	// ��
	@Override
	public int getCount() throws RemoteException {
		if (view instanceof AbsListView) {
			return ((AbsListView) view).getCount();
		}
		return 0;
	}

	// ��
	@Override
	public void scroll(int distance, int duration) throws RemoteException {
		if (view instanceof AbsListView) {
			((AbsListView) view).smoothScrollBy(distance, duration);
		}
	}

	// ��
	@Override
	public String getName() throws RemoteException {
		return view.getClass().getName();
	}

}
