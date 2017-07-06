/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\980008027\\workspace\\ScriptDemo\\src\\com\\lym\\xposed\\aidl\\IActivity.aidl
 */
package com.lym.xposed.aidl;
public interface IActivity extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.lym.xposed.aidl.IActivity
{
private static final java.lang.String DESCRIPTOR = "com.lym.xposed.aidl.IActivity";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.lym.xposed.aidl.IActivity interface,
 * generating a proxy if needed.
 */
public static com.lym.xposed.aidl.IActivity asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.lym.xposed.aidl.IActivity))) {
return ((com.lym.xposed.aidl.IActivity)iin);
}
return new com.lym.xposed.aidl.IActivity.Stub.Proxy(obj);
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
case TRANSACTION_getName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_finish:
{
data.enforceInterface(DESCRIPTOR);
this.finish();
reply.writeNoException();
return true;
}
case TRANSACTION_finishAll:
{
data.enforceInterface(DESCRIPTOR);
this.finishAll();
reply.writeNoException();
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
case TRANSACTION_getIntentData:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getIntentData();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.lym.xposed.aidl.IActivity
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
@Override public void finish() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finish, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void finishAll() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_finishAll, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
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
@Override public java.lang.String getIntentData() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getIntentData, _data, _reply, 0);
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
static final int TRANSACTION_getName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_finish = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_finishAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getView = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_getIntentData = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
}
public java.lang.String getName() throws android.os.RemoteException;
public void finish() throws android.os.RemoteException;
public void finishAll() throws android.os.RemoteException;
public com.lym.xposed.aidl.IView getView() throws android.os.RemoteException;
public java.lang.String getIntentData() throws android.os.RemoteException;
}
