package com.lym.xposed;

import android.app.Dialog;
import android.os.RemoteException;

import com.lym.xposed.aidl.IDialog;
import com.lym.xposed.aidl.IView;
import com.lym.xposed.utils.ViewUtil;

public class XDialog extends IDialog.Stub {
	private Dialog dialog;

	public XDialog(Dialog dialog) {
		super();
		this.dialog = dialog;
	}

	@Override
	public IView getView() throws RemoteException {
		return new XView(dialog.getWindow().getDecorView());
	}

	@Override
	public void dismiss() throws RemoteException {
		dialog.dismiss();
	}

	@Override
	public String getText() throws RemoteException {
		return ViewUtil.getAllText(dialog.getWindow().getDecorView());
	}

}
