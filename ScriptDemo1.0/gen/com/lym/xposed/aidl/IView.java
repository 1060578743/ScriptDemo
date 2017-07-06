/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\980008027\\workspace\\ScriptDemo\\src\\com\\lym\\xposed\\aidl\\IView.aidl
 */
package com.lym.xposed.aidl;
public interface IView extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.lym.xposed.aidl.IView
{
private static final java.lang.String DESCRIPTOR = "com.lym.xposed.aidl.IView";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.lym.xposed.aidl.IView interface,
 * generating a proxy if needed.
 */
public static com.lym.xposed.aidl.IView asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.lym.xposed.aidl.IView))) {
return ((com.lym.xposed.aidl.IView)iin);
}
return new com.lym.xposed.aidl.IView.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_child:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.lym.xposed.aidl.IView _result = this.child(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_parent:
{
data.enforceInterface(DESCRIPTOR);
com.lym.xposed.aidl.IView _result = this.parent();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_res:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.lym.xposed.aidl.IView _result = this.res(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_id:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.lym.xposed.aidl.IView _result = this.id(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_clssName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.lym.xposed.aidl.IView _result = this.clssName(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_text:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.lym.xposed.aidl.IView _result = this.text(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_hint:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.lym.xposed.aidl.IView _result = this.hint(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_desc:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
com.lym.xposed.aidl.IView _result = this.desc(_arg0);
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
return true;
}
case TRANSACTION_childCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.childCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getCount:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCount();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_x:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.x();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_y:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.y();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_w:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.w();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_h:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.h();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_press:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.press(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_click:
{
data.enforceInterface(DESCRIPTOR);
this.click();
reply.writeNoException();
return true;
}
case TRANSACTION_clickXY:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.clickXY(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_longClick:
{
data.enforceInterface(DESCRIPTOR);
this.longClick();
reply.writeNoException();
return true;
}
case TRANSACTION_doubleClick:
{
data.enforceInterface(DESCRIPTOR);
this.doubleClick();
reply.writeNoException();
return true;
}
case TRANSACTION_swipe:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.swipe(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_setText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setText(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_scroll:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.scroll(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_getText:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getText();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_dump:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.dump();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_getName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_showen:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.showen();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_exist:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.exist();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.lym.xposed.aidl.IView
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
//子控件

@Override public com.lym.xposed.aidl.IView child(int index) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(index);
mRemote.transact(Stub.TRANSACTION_child, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//父控件

@Override public com.lym.xposed.aidl.IView parent() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_parent, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//工具resourceid查找控件

@Override public com.lym.xposed.aidl.IView res(java.lang.String res) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(res);
mRemote.transact(Stub.TRANSACTION_res, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//根据id查找控件

@Override public com.lym.xposed.aidl.IView id(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_id, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//根据类名查找控件

@Override public com.lym.xposed.aidl.IView clssName(java.lang.String clz) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(clz);
mRemote.transact(Stub.TRANSACTION_clssName, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//根据文本查找控件

@Override public com.lym.xposed.aidl.IView text(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_text, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//根据默认值查找控件

@Override public com.lym.xposed.aidl.IView hint(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_hint, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//根据控件说明查找控件

@Override public com.lym.xposed.aidl.IView desc(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_desc, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//子控件数量

@Override public int childCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_childCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//item数量

@Override public int getCount() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCount, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//控件x

@Override public int x() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_x, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//控件y

@Override public int y() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_y, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//控件宽

@Override public int w() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_w, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
//控件高

@Override public int h() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_h, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void press(int keycode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(keycode);
mRemote.transact(Stub.TRANSACTION_press, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//点击控件

@Override public void click() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_click, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void clickXY(int x, int y) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(x);
_data.writeInt(y);
mRemote.transact(Stub.TRANSACTION_clickXY, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//长按控件

@Override public void longClick() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_longClick, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//双击控件

@Override public void doubleClick() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_doubleClick, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//滚动，水平滚动距离,垂直滚动距离，时间

@Override public void swipe(int w, int h, int time) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(w);
_data.writeInt(h);
_data.writeInt(time);
mRemote.transact(Stub.TRANSACTION_swipe, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//设置控件文本

@Override public void setText(java.lang.String text) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(text);
mRemote.transact(Stub.TRANSACTION_setText, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void scroll(int distance, int duration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(distance);
_data.writeInt(duration);
mRemote.transact(Stub.TRANSACTION_scroll, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
//获取控件文本

@Override public java.lang.String getText() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getText, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String dump() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_dump, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean showen() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_showen, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public boolean exist() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_exist, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_child = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_parent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_res = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_id = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_clssName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_text = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_hint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_desc = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_childCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getCount = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_x = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_y = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_w = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_h = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
static final int TRANSACTION_press = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
static final int TRANSACTION_click = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
static final int TRANSACTION_clickXY = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
static final int TRANSACTION_longClick = (android.os.IBinder.FIRST_CALL_TRANSACTION + 17);
static final int TRANSACTION_doubleClick = (android.os.IBinder.FIRST_CALL_TRANSACTION + 18);
static final int TRANSACTION_swipe = (android.os.IBinder.FIRST_CALL_TRANSACTION + 19);
static final int TRANSACTION_setText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 20);
static final int TRANSACTION_scroll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 21);
static final int TRANSACTION_getText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 22);
static final int TRANSACTION_dump = (android.os.IBinder.FIRST_CALL_TRANSACTION + 23);
static final int TRANSACTION_getName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 24);
static final int TRANSACTION_showen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 25);
static final int TRANSACTION_exist = (android.os.IBinder.FIRST_CALL_TRANSACTION + 26);
}
//子控件

public com.lym.xposed.aidl.IView child(int index) throws android.os.RemoteException;
//父控件

public com.lym.xposed.aidl.IView parent() throws android.os.RemoteException;
//工具resourceid查找控件

public com.lym.xposed.aidl.IView res(java.lang.String res) throws android.os.RemoteException;
//根据id查找控件

public com.lym.xposed.aidl.IView id(int id) throws android.os.RemoteException;
//根据类名查找控件

public com.lym.xposed.aidl.IView clssName(java.lang.String clz) throws android.os.RemoteException;
//根据文本查找控件

public com.lym.xposed.aidl.IView text(java.lang.String text) throws android.os.RemoteException;
//根据默认值查找控件

public com.lym.xposed.aidl.IView hint(java.lang.String text) throws android.os.RemoteException;
//根据控件说明查找控件

public com.lym.xposed.aidl.IView desc(java.lang.String text) throws android.os.RemoteException;
//子控件数量

public int childCount() throws android.os.RemoteException;
//item数量

public int getCount() throws android.os.RemoteException;
//控件x

public int x() throws android.os.RemoteException;
//控件y

public int y() throws android.os.RemoteException;
//控件宽

public int w() throws android.os.RemoteException;
//控件高

public int h() throws android.os.RemoteException;
public void press(int keycode) throws android.os.RemoteException;
//点击控件

public void click() throws android.os.RemoteException;
public void clickXY(int x, int y) throws android.os.RemoteException;
//长按控件

public void longClick() throws android.os.RemoteException;
//双击控件

public void doubleClick() throws android.os.RemoteException;
//滚动，水平滚动距离,垂直滚动距离，时间

public void swipe(int w, int h, int time) throws android.os.RemoteException;
//设置控件文本

public void setText(java.lang.String text) throws android.os.RemoteException;
public void scroll(int distance, int duration) throws android.os.RemoteException;
//获取控件文本

public java.lang.String getText() throws android.os.RemoteException;
public java.lang.String dump() throws android.os.RemoteException;
public java.lang.String getName() throws android.os.RemoteException;
public boolean showen() throws android.os.RemoteException;
public boolean exist() throws android.os.RemoteException;
}
