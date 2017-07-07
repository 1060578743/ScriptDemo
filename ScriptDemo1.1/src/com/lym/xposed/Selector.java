package com.lym.xposed;

public class Selector {
	public static final int TYPE_CLASS = 1;
	public static final int TYPE_CHILD = 2;
	public static final int TYPE_TEXT = 3;
	public static final int TYPE_ID = 4;
	private int index;
	private Selector next;
	private Selector root;
	private String content;
	private int type;

	public Selector() {
		root = this;
	}

	public Selector clz(Class<?> clz) {
		Selector child = new Selector();
		child.setType(TYPE_CLASS);
		child.setRoot(root);
		child.setContent(clz.getName());
		setNext(child);
		return next;
	}

	public Selector text(String text) {
		Selector child = new Selector();
		child.setType(TYPE_TEXT);
		child.setRoot(root);
		child.setContent(text);
		setNext(child);
		return next;
	}

	public Selector id(String id) {
		Selector child = new Selector();
		child.setType(TYPE_ID);
		child.setRoot(root);
		child.setContent(id);
		setNext(child);
		return next;
	}

	public Selector child(int index) {
		Selector child = new Selector();
		child.setType(TYPE_CHILD);
		child.setRoot(root);
		child.setContent(String.valueOf(index));
		setNext(child);
		return next;
	}

	public Selector index(int index) {
		setIndex(index);
		return this;
	}

	public int getIndex() {
		return index;
	}

	public Selector getNext() {
		return next;
	}

	public Selector getRoot() {
		return root;
	}

	public String getContent() {
		return content;
	}

	public int getType() {
		return type;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setNext(Selector next) {
		this.next = next;
	}

	public void setRoot(Selector root) {
		this.root = root;
	}

	public void setContent(String text) {
		this.content = text;
	}

	public void setType(int type) {
		this.type = type;
	}
}
