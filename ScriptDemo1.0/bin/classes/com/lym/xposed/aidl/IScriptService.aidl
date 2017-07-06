package com.lym.xposed.aidl;
import com.lym.xposed.aidl.IActivity;
import com.lym.xposed.aidl.IDialog;
import com.lym.xposed.aidl.IToast;
import com.lym.xposed.aidl.IView;
interface IScriptService{
	void onToast(in IToast toast);
	void onActivity(in IActivity act);
	void onDialog(in IDialog dialog);
}