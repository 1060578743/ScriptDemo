package com.lym.xposed.aidl;
import com.lym.xposed.aidl.IView;
interface IToast{
	IView getView();
	String getText();
}
