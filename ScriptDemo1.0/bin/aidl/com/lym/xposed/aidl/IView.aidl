package com.lym.xposed.aidl;

interface IView{
	//�ӿؼ�
	IView child(int index);
	//���ؼ�
	IView parent();
	//����resourceid���ҿؼ�
	IView res(String res);
	//����id���ҿؼ�
	IView id(int id);
	//�����������ҿؼ�
	IView clssName(String clz);
	//�����ı����ҿؼ�
	IView text(String text);
	//����Ĭ��ֵ���ҿؼ�
	IView hint(String text);
	//���ݿؼ�˵�����ҿؼ�
	IView desc(String text);
	//�ӿؼ�����
	int childCount();
	//item����
	int getCount();
	//�ؼ�x
	int x();
	//�ؼ�y
	int y();
	//�ؼ���
	int w();
	//�ؼ���
	int h();
	void press(int keycode);
	//����ؼ�
	void click();
	void clickXY(int x,int y);
	//�����ؼ�
	void longClick();
	//˫���ؼ�
	void doubleClick();
	//������ˮƽ��������,��ֱ�������룬ʱ��
	void swipe(int w,int h,int time);
	//���ÿؼ��ı�
	void setText(String text);
	void scroll(int distance,int duration);
	//��ȡ�ؼ��ı�
	String getText();
	String dump();
	String getName();
	boolean showen();
	boolean exist();
}
