package com.lym.xposed;

import android.app.Activity;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import com.lym.xposed.aidl.IScriptService;
import com.robotium.solo.Solo;

public class XConnection {
	private static XConnection xConnection;

	public static synchronized XConnection getInstance() {
		if (xConnection == null) {
			xConnection = new XConnection();
		}
		return xConnection;
	}

	private Activity activity;
	private IScriptService iScriptService;
	private Object mLock = new Object();
	private ServiceConnection mServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			iScriptService = IScriptService.Stub.asInterface(service);
			try {
				iScriptService.onActivity(new XActivity(activity));
			} catch (RemoteException e) {
			}
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
		}
	};

	private Solo solo;

	private XConnection() {

	}

	public Activity getActivity() {
		return activity;
	}

	public Solo getSolo() {
		synchronized (mLock) {
			return solo;
		}
	}

	public void onActivityPause(Activity act) {
		// 解除绑定
		act.unbindService(mServiceConnection);
	}

	public void onActivityResume(Activity act) {
		activity = act;
		// 绑定服务器
		Intent intent = new Intent();
		intent.setComponent(new ComponentName("com.lym.xposed",
				"com.lym.xposed.service.ScriptService"));
		act.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
		synchronized (mLock) {
			solo = new Solo(new Instrumentation(), act);
		}
	}

	public void onDialogShow(Dialog dialog) {
		if (iScriptService != null) {
			try {
				iScriptService.onDialog(new XDialog(dialog));
			} catch (RemoteException e) {
			}
		}
	}

	public void onToastgShow(Toast toast) {
		if (iScriptService != null) {
			try {
				iScriptService.onToast(new XToast(toast));
			} catch (RemoteException e) {
			}
		}
	}

}
