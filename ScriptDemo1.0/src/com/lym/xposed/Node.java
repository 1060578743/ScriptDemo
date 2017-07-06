package com.lym.xposed;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.AccessibilityNodeInfo;

public class Node implements Parcelable {
	AccessibilityNodeInfo node;

	public Node() {
		super();
	}

	public Node(AccessibilityNodeInfo node) {
		super();
		this.node = node;
	}

	public AccessibilityNodeInfo getNode() {
		return node;
	}

	public void setNode(AccessibilityNodeInfo node) {
		this.node = node;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub

	}

}
