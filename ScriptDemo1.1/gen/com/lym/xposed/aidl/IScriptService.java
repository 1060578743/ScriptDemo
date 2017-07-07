/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\980008027\\workspace\\tiebaSend\\src\\com\\lym\\xposed\\aidl\\IScriptService.aidl
 */
package com.lym.xposed.aidl;
public interface IScriptService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.lym.xposed.aidl.IScriptService
{
private static final java.lang.String DESCRIPTOR = "com.lym.xposed.aidl.IScriptService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.lym.xposed.aidl.IScriptService interface,
 * generating a proxy if needed.
 */
public static com.lym.xposed.aidl.IScriptService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.lym.xposed.aidl.IScriptService))) {
return ((com.lym.xposed.aidl.IScriptService)iin);
}
return new com.lym.xposed.aidl.IScriptService.Stub.Proxy(obj);
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
case TRANSACTION_onToast:
{
data.enforceInterface(DESCRIPTOR);
com.lym.xposed.aidl.IToast _arg0;
_arg0 = com.lym.xposed.aidl.IToast.Stub.asInterface(data.readStrongBinder());
this.onToast(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onActivity:
{
data.enforceInterface(DESCRIPTOR);
com.lym.xposed.aidl.IActivity _arg0;
_arg0 = com.lym.xposed.aidl.IActivity.Stub.asInterface(data.readStrongBinder());
this.onActivity(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onDialog:
{
data.enforceInterface(DESCRIPTOR);
com.lym.xposed.aidl.IDialog _arg0;
_arg0 = com.lym.xposed.aidl.IDialog.Stub.asInterface(data.readStrongBinder());
this.onDialog(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.lym.xposed.aidl.IScriptService
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
@Override public void onToast(com.lym.xposed.aidl.IToast toast) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((toast!=null))?(toast.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onToast, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onActivity(com.lym.xposed.aidl.IActivity act) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((act!=null))?(act.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onActivity, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDialog(com.lym.xposed.aidl.IDialog dialog) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((dialog!=null))?(dialog.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_onDialog, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onToast = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onActivity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onDialog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void onToast(com.lym.xposed.aidl.IToast toast) throws android.os.RemoteException;
public void onActivity(com.lym.xposed.aidl.IActivity act) throws android.os.RemoteException;
public void onDialog(com.lym.xposed.aidl.IDialog dialog) throws android.os.RemoteException;
}
