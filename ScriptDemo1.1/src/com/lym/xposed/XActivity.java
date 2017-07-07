package com.lym.xposed;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lym.xposed.aidl.IActivity;
import com.lym.xposed.aidl.IScriptService;
import com.lym.xposed.aidl.IView;
import com.lym.xposed.utils.LogUtil;
import com.robotium.solo.Solo;

public class XActivity extends IActivity.Stub {
	private static XActivity instance;

	public synchronized static XActivity getInstance() {
		if (instance == null) {
			instance = new XActivity();
		}
		return instance;
	}

	private Activity activity;
	private IScriptService scriptService;
	private ServiceConnection mServiceConnection;
	private Solo solo;

	private XActivity() {
		mServiceConnection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				scriptService = IScriptService.Stub.asInterface(service);
				try {
					scriptService.onActivity(XActivity.this);
				} catch (RemoteException e) {
				}
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
			}
		};
	}

	@Override
	public void click(int x, int y) throws RemoteException {
		solo.clickOnScreen(x, y);
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

	public Activity getActivity() {
		return activity;
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

	@Override
	public String getName() throws RemoteException {
		return activity.getClass().getName();
	}

	@Override
	public IView getView() throws RemoteException {
		return new XView(((ViewGroup) activity.getWindow().getDecorView()
				.findViewById(android.R.id.content)).getChildAt(0));
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
		solo = new Solo(new Instrumentation(), act);
	}

	public void onDialogShow(Dialog dialog) {
		if (scriptService != null) {
			try {
				scriptService.onDialog(new XDialog(dialog));
			} catch (RemoteException e) {
			}
		}
	}

	public void onToastgShow(Toast toast) {
		if (scriptService != null) {
			try {
				scriptService.onToast(new XToast(toast));
			} catch (RemoteException e) {
			}
		}
	}

	@Override
	public void sendKeycode(int keycode) throws RemoteException {
		solo.sendKey(keycode);
	}

	public void clickWeb(){
		//solo.clickOnWebElement(solo.)
	}
}
