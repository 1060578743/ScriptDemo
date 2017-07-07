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
	// ������ť
	ImageButton mImageButton;
	// ���帡�����ڲ���
	LinearLayout mLinearLayout;
	// ���������������ò��ֲ����Ķ���
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
		// ͨ��getApplication��ȡ����WindowManagerImpl.CompatModeWrapper
		mWindowManager = (WindowManager) mContext
				.getSystemService(Context.WINDOW_SERVICE);
		// ����window type
		mLayoutParams.type = LayoutParams.TYPE_PHONE;
		// ����ͼƬ��ʽ��Ч��Ϊ����͸��
		mLayoutParams.format = PixelFormat.RGBA_8888;
		// ���ø������ڲ��ɾ۽���ʵ�ֲ���������������������ɼ����ڵĲ�����
		mLayoutParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;
		// ������������ʾ��ͣ��λ��Ϊ����ö�
		mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
		// ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ�������gravity

		// �����������ڳ�������
		mLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		mLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

		LayoutInflater inflater = LayoutInflater.from(mContext);
		// ��ȡ����������ͼ���ڲ���
		mLinearLayout = (LinearLayout) inflater.inflate(
				R.layout.alert_window_button, null);

		// ���mFloatLayout
		mWindowManager.addView(mLinearLayout, mLayoutParams);

		// �������ڰ�ť
		mImageButton = (ImageButton) mLinearLayout
				.findViewById(R.id.alert_window_imagebtn);

		// ��������
		mLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
				.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

		// ���ü����������ڵĴ����ƶ�
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
					// getRawX�Ǵ���λ���������Ļ�����꣬getX������ڰ�ť������
					mLayoutParams.x = (int) (startX - downX + rx);
					// ��25Ϊ״̬���ĸ߶�
					mLayoutParams.y = (int) (startY - downY + ry);
					// ˢ��
					mWindowManager.updateViewLayout(mLinearLayout,
							mLayoutParams);
					break;
				case MotionEvent.ACTION_UP:
					if (isClick) {
						// �������߹رսű�
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
			// �Ƴ���������
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
