package com.lym.xposed.aidl;

interface IView{
	//子控件
	IView child(int index);
	//父控件
	IView parent();
	//工具resourceid查找控件
	IView res(String res);
	//根据类名查找控件
	IView clssName(String clz,int index);
	//根据文本查找控件
	IView text(String text,int index);
	//根据默认值查找控件
	IView hint(String text,int index);
	//根据控件说明查找控件
	IView desc(String text,int index);
	//子控件数量
	int childCount();
	//item数量
	int getCount();
	//控件x
	int x();
	//控件y
	int y();
	//控件宽
	int w();
	//控件高
	int h();
	//点击控件
	void click();
	//长按控件
	void longClick();
	//双击控件
	void doubleClick();
	//设置控件文本
	void setText(String text);
	void scroll(int distance,int duration);
	//获取控件文本
	String getText();
	String dump();
	String getName();
	boolean showen();
	boolean exist();
	
}
