package com.lym.xposed.aidl;
import com.lym.xposed.aidl.IView;
interface IDialog{
	IView getView();
	void dismiss();
	String getText();
}
