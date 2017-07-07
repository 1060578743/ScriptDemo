/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\980008027\\workspace\\tiebaSend\\src\\com\\lym\\xposed\\aidl\\IToast.aidl
 */
package com.lym.xposed.aidl;
public interface IToast extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.lym.xposed.aidl.IToast
{
private static final java.lang.String DESCRIPTOR = "com.lym.xposed.aidl.IToast";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.lym.xposed.aidl.IToast interface,
 * generating a proxy if needed.
 */
public static com.lym.xposed.aidl.IToast asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.lym.xposed.aidl.IToast))) {
return ((com.lym.xposed.aidl.IToast)iin);
}
return new com.lym.xposed.aidl.IToast.Stub.Proxy(obj);
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
case TRANSACTION_getView:
{
data.enforceInterface(DESCRIPTOR);
com.lym.xposed.aidl.IView _result = this.getView();
reply.writeNoException();
reply.writeStrongBinder((((_result!=null))?(_result.asBinder()):(null)));
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
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.lym.xposed.aidl.IToast
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
@Override public com.lym.xposed.aidl.IView getView() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.lym.xposed.aidl.IView _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getView, _data, _reply, 0);
_reply.readException();
_result = com.lym.xposed.aidl.IView.Stub.asInterface(_reply.readStrongBinder());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
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
}
static final int TRANSACTION_getView = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_getText = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public com.lym.xposed.aidl.IView getView() throws android.os.RemoteException;
public java.lang.String getText() throws android.os.RemoteException;
}
