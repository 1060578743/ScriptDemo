package com.lym.xposed.utils;

import java.util.ArrayList;

import android.view.View;
import android.widget.Toast;

import com.lym.xposed.MH;

import de.robv.android.xposed.XposedBridge;

public class XposedUtil {
	public static void removeToast(final String contains) throws Throwable {
		XposedBridge.hookAllMethods(Toast.class, "show", new MH() {

			@Override
			protected void before(MethodHookParam param) throws Throwable {

			}

			@Override
			protected void after(MethodHookParam param) throws Throwable {
				Toast toast = (Toast) param.thisObject;
				View view = toast.getView();
				ArrayList<View> views = new ArrayList<View>();
				view.findViewsWithText(views, contains, 1);
				toast.cancel();
			}
		});
	}
}
