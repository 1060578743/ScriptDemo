package com.lym.xposed.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.lym.xposed.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void start(View v) {
	}
}
