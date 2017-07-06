package com.lym.xposed.application;

import android.app.Application;

public class App extends Application {
	public static App instance;
	public FloatView floatView;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		floatView = new FloatView(this);
	}
}
