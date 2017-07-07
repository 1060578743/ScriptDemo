package com.lym.xposed.application;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.lym.xposed.R;

public class FloatView {
	// 悬浮按钮
	ImageButton mImageButton;
	// 定义浮动窗口布局
	LinearLayout mLinearLayout;
	// 创建浮动窗口设置布局参数的对象
	WindowManager mWindowManager;
	WindowManager.LayoutParams mLayoutParams;
	Handler mHandler = new Handler();
	Context mContext;

	public FloatView(Context context) {
		mContext = context;
	}

	public void createFloatView() {
		if (mLinearLayout != null) {
			return;
		}
		int w = mContext.getResources().getDisplayMetrics().widthPixels;
		int h = mContext.getResources().getDisplayMetrics().heightPixels;
		mLayoutParams = new WindowManager.LayoutParams();
		// 通过getApplication获取的是WindowManagerImpl.CompatModeWrapper
		mWindowManager = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);
		// 设置window type
		mLayoutParams.type = LayoutParams.TYPE_PHONE;
		// 设置图片格式，效果为背景透明
		mLayoutParams.format = PixelFormat.RGBA_8888;
		// 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
		mLayoutParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
		// 调整悬浮窗显示的停靠位置为左侧置顶
		mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
		// 以屏幕左上角为原点，设置x、y初始值，相对于gravity

		// 设置悬浮窗口长宽数据
		mLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		mLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

		LayoutInflater inflater = LayoutInflater.from(mContext);
		// 获取浮动窗口视图所在布局
		mLinearLayout = (LinearLayout) inflater.inflate(
				R.layout.alert_window_button, null);

		// 添加mFloatLayout
		mWindowManager.addView(mLinearLayout, mLayoutParams);

		// 浮动窗口按钮
		mImageButton = (ImageButton) mLinearLayout
				.findViewById(R.id.alert_window_imagebtn);

		// 测量布局
		mLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
				.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

		// 设置监听浮动窗口的触摸移动
		mImageButton.setOnTouchListener(new OnTouchListener() {
			float downX, downY;
			boolean isClick;
			float startX, startY;

			public boolean onTouch(View v, MotionEvent event) {
				float rx = event.getRawX();
				float ry = event.getRawY();

				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					isClick = true;
					downX = rx;
					downY = ry;
					startX = mLayoutParams.x;
					startY = mLayoutParams.y;
					break;
				case MotionEvent.ACTION_MOVE:
					if (Math.abs(rx - downX) > 10 || Math.abs(ry - downY) > 10) {
						isClick = false;
					}
					// getRawX是触摸位置相对于屏幕的坐标，getX是相对于按钮的坐标
					mLayoutParams.x = (int) (startX - downX + rx);
					// 减25为状态栏的高度
					mLayoutParams.y = (int) (startY - downY + ry);
					// 刷新
					mWindowManager.updateViewLayout(mLinearLayout,
							mLayoutParams);
					break;
				case MotionEvent.ACTION_UP:
					if (isClick) {
						// 启动或者关闭脚本
						App.instance.switchScript();
					}
					break;
				}
				return false;
			}

		});
		mLayoutParams.x = w - mImageButton.getWidth();
		mLayoutParams.y = h / 2;
		mWindowManager.updateViewLayout(mLinearLayout, mLayoutParams);
	}

	public void drawFloatView(final boolean isRunning) {
		mHandler.post(new Runnable() {
			@Override
			public void run() {
				createFloatView();
				if (isRunning) {
					mImageButton.setBackgroundResource(R.drawable.circle_red);
				} else {
					mImageButton.setBackgroundResource(R.drawable.circle_cyan);
				}
			}
		});

	}

	public void removeFloatView() {
		if (mLinearLayout != null) {
			// 移除悬浮窗口
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					mWindowManager.removeView(mLinearLayout);
					mLinearLayout = null;
				}
			});
		}
	}
}
