package com.lym.xposed.utils;

public class LogUtil {
	public static void log(Exception e) {
		e.printStackTrace();
	}

	public static void log(Object log) {
		System.out.println("hello log:" + log);
	}

	public static void log(Object... log) {
		String l = "";
		for (int i = 0; i < log.length; i++) {
			l += " " + log[i];
		}
		System.out.println("hello log:" + l.trim());
	}
}
