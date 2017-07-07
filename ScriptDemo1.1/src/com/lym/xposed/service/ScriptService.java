package com.lym.xposed.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

import com.lym.xposed.UiDevice;
import com.lym.xposed.aidl.IActivity;
import com.lym.xposed.aidl.IDialog;
import com.lym.xposed.aidl.IScriptService;
import com.lym.xposed.aidl.IToast;

public class ScriptService extends Service {
	Handler ui = new Handler();

	@Override
	public IBinder onBind(Intent intent) {
		return new IScriptService.Stub() {
			@Override
			public void onToast(IToast toast) throws RemoteException {
				UiDevice.getInstance().setToast(toast);
			}

			@Override
			public void onDialog(IDialog dialog) throws RemoteException {
				UiDevice.getInstance().setDialog(dialog);
			}

			@Override
			public void onActivity(final IActivity act) throws RemoteException {
				UiDevice.getInstance().setActivity(act);
				//LogUtil.log(act.getIntentData());
			}

		};
	}
}
