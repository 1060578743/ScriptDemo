package com.lym.xposed;

public class By {
	public static Selector clz(Class<?> clz) {
		return new Selector().clz(clz);
	}

	public static Selector id(String id) {
		return new Selector().id(id);
	}

	public static Selector text(String text) {
		return new Selector().id(text);
	}

	public static Selector child(int i) {
		return new Selector().child(i);
	}

}
