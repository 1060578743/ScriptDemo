package com.lym.xposed.activity;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lym.xposed.R;
import com.lym.xposed.application.App;
import com.lym.xposed.script.Baidu;
import com.lym.xposed.utils.FileUtil;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		readData();
		int start = getIntent().getIntExtra("start", 0);
		if (start == 1) {
			start(null);
		}
	}

	private String getPath() {
		return new File(getDir("option", 0), "option.txt").toString();
	}

	private void readData() {
		EditText tv = (android.widget.EditText) findViewById(R.id.editWaitTime);
		try {
			String data = FileUtil.read(getPath());
			if (data == null) {
				data = "5";
			}
			tv.setText(data);
		} catch (Exception e) {
			tv.setText("5");
		}

	}

	private void saveData() {
		try {
			EditText tv = (android.widget.EditText) findViewById(R.id.editWaitTime);
			FileUtil.write(getPath(), tv.getText().toString());
		} catch (Exception e) {
		}
	}

	public void start(View v) {
		saveData();
		String text = ((android.widget.EditText) findViewById(R.id.editWaitTime))
				.getText().toString();
		Baidu.sleepTime = Integer.parseInt(text);
		App.instance.startScript();
	}
}
