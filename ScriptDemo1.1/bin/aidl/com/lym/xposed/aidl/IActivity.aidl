package com.lym.xposed.aidl;
import com.lym.xposed.aidl.IView;
interface IActivity{
	String getName();
	void finish();
	void finishAll();
	IView getView();
	String getIntentData();
	void click(int x,int y);
	void sendKeycode(int keycode);
}
