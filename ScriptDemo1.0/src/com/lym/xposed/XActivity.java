package com.lym.xposed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import android.view.ViewGroup;

import com.lym.xposed.aidl.IActivity;
import com.lym.xposed.aidl.IView;

public class XActivity extends IActivity.Stub {
	private Activity activity;

	public XActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String getName() throws RemoteException {
		return activity.getClass().getName();
	}

	@Override
	public void finish() throws RemoteException {
		activity.finish();
	}

	@SuppressLint("NewApi")
	@Override
	public void finishAll() throws RemoteException {
		activity.finishAffinity();
	}

	@Override
	public IView getView() throws RemoteException {
		return new XView(((ViewGroup) activity.getWindow().getDecorView()
				.findViewById(android.R.id.content)).getChildAt(0));
	}

	@Override
	public String getIntentData() throws RemoteException {
		Intent i = activity.getIntent();
		if (i == null || i.getExtras() == null) {
			return "";
		}
		String str = "";
		for (String key : i.getExtras().keySet()) {
			Object obj = i.getExtras().get(key);
			str += obj.getClass().getName() + " " + key + " = " + obj + "\n";
		}
		return str.trim();
	}
}
