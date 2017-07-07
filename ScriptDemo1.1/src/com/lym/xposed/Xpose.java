package com.lym.xposed;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.Toast;

import com.lym.xposed.utils.ViewUtil;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Xpose implements IXposedHookLoadPackage {

	// 开机加载包的时候会调用
	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
		hookToast(lpparam);
		hookDialog(lpparam);
		hookActivity(lpparam);
	}

	public void onToastShow(Toast toast) {
		View view = toast.getView();
		// 如果包含root提示,则取消显示
		ArrayList<View> views = new ArrayList<View>();
		view.findViewsWithText(views, "超级用户", 1);
		if (views.size() > 0) {
			toast.cancel();
		}

		XActivity.getInstance().onToastgShow(toast);
	}

	public void onDialogShow(Dialog dialog) {
		XActivity.getInstance().onDialogShow(dialog);
	}

	public void onActivityonResume(Activity act) {
		XActivity.getInstance().onActivityResume(act);
	}

	public void onActivityPause(Activity act) {
		XActivity.getInstance().onActivityPause(act);
	}

	private void hookToast(LoadPackageParam lpparam) {
		XposedBridge.hookAllMethods(Toast.class, "show", new MH() {
			@Override
			protected void after(MethodHookParam param) throws Throwable {
				onToastShow((Toast) param.thisObject);
			}
		});
	}

	private void hookDialog(LoadPackageParam lpparam) {
		XposedBridge.hookAllMethods(Dialog.class, "show", new MH() {
			@Override
			protected void after(MethodHookParam param) throws Throwable {
				onDialogShow((Dialog) param.thisObject);
			}
		});
	}

	private void hookActivity(LoadPackageParam lpparam) {
		XposedBridge.hookAllMethods(Activity.class, "onResume", new MH() {

			@Override
			protected void after(MethodHookParam param) throws Throwable {
				onActivityonResume((Activity) param.thisObject);
			}

		});
		XposedBridge.hookAllMethods(Activity.class, "onPause", new MH() {

			@Override
			protected void after(MethodHookParam param) throws Throwable {
				onActivityPause((Activity) param.thisObject);
			}

		});
	}
}
