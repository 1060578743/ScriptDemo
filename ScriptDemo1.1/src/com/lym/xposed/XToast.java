package com.lym.xposed;

import android.os.RemoteException;
import android.widget.Toast;

import com.lym.xposed.aidl.IToast;
import com.lym.xposed.aidl.IView;
import com.lym.xposed.utils.ViewUtil;

public class XToast extends IToast.Stub {
	private Toast toast;

	public XToast(Toast toast) {
		super();
		this.toast = toast;
	}

	@Override
	public IView getView() throws RemoteException {
		return new XView(toast.getView());
	}

	@Override
	public String getText() throws RemoteException {
		return ViewUtil.getAllText(toast.getView());
	}

}
