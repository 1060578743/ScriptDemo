package com.lym.xposed.aidl;

interface IView{
	//�ӿؼ�
	IView child(int index);
	//���ؼ�
	IView parent();
	//����resourceid���ҿؼ�
	IView res(String res);
	//�����������ҿؼ�
	IView clssName(String clz,int index);
	//�����ı����ҿؼ�
	IView text(String text,int index);
	//����Ĭ��ֵ���ҿؼ�
	IView hint(String text,int index);
	//���ݿؼ�˵�����ҿؼ�
	IView desc(String text,int index);
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
	//����ؼ�
	void click();
	//�����ؼ�
	void longClick();
	//˫���ؼ�
	void doubleClick();
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
