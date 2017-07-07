package com.lym.xposed.application;

import android.app.Application;

import com.lym.xposed.script.Baidu;
import com.lym.xposed.script.Script;

public class App extends Application {
	public static App instance;
	public FloatView floatView;
	public Script script;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		floatView = new FloatView(this);
	}

	public synchronized void startScript() {
		if (script == null) {
			script = new Baidu(this);
		}
		if (script.isStart()) {
			return;
		}
		script.start();
	}

	public synchronized void stopScript() {
		if (script == null) {
			return;
		}
		script.stop();
	}

	public synchronized void switchScript() {
		if (script == null || (!script.isStart())) {
			startScript();
			return;
		}
		script.stop();
	}
}
