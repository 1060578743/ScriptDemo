package com.lym.xposed.aidl;

interface IView{
	//子控件
	IView child(int index);
	//父控件
	IView parent();
	//工具resourceid查找控件
	IView res(String res);
	//根据id查找控件
	IView id(int id);
	//根据类名查找控件
	IView clssName(String clz);
	//根据文本查找控件
	IView text(String text);
	//根据默认值查找控件
	IView hint(String text);
	//根据控件说明查找控件
	IView desc(String text);
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
	void press(int keycode);
	//点击控件
	void click();
	void clickXY(int x,int y);
	//长按控件
	void longClick();
	//双击控件
	void doubleClick();
	//滚动，水平滚动距离,垂直滚动距离，时间
	void swipe(int w,int h,int time);
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
