package com.lym.xposed.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.widget.EditText;

import com.lym.xposed.aidl.IActivity;
import com.lym.xposed.aidl.IDialog;
import com.lym.xposed.aidl.IScriptService;
import com.lym.xposed.aidl.IToast;
import com.lym.xposed.aidl.IView;
import com.lym.xposed.utils.LogUtil;
import com.lym.xposed.utils.SU;

public class ScriptService extends Service {
	Handler ui = new Handler();

	@Override
	public IBinder onBind(Intent intent) {
		return new IScriptService.Stub() {

			@Override
			public void onToast(IToast toast) throws RemoteException {
				LogUtil.log(toast.getText());
				LogUtil.log(toast.getView().dump());
			}

			@Override
			public void onDialog(IDialog dialog) throws RemoteException {
				LogUtil.log("dialog");
			}

			@Override
			public void onActivity(final IActivity act) throws RemoteException {
				LogUtil.log(act.getIntentData());
			}

		};
	}
}
