/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package lineageos.weather;
/** @hide */
public interface IWeatherServiceProviderChangeListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements lineageos.weather.IWeatherServiceProviderChangeListener
{
private static final java.lang.String DESCRIPTOR = "lineageos.weather.IWeatherServiceProviderChangeListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an lineageos.weather.IWeatherServiceProviderChangeListener interface,
 * generating a proxy if needed.
 */
public static lineageos.weather.IWeatherServiceProviderChangeListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof lineageos.weather.IWeatherServiceProviderChangeListener))) {
return ((lineageos.weather.IWeatherServiceProviderChangeListener)iin);
}
return new lineageos.weather.IWeatherServiceProviderChangeListener.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_onWeatherServiceProviderChanged:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
this.onWeatherServiceProviderChanged(_arg0);
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements lineageos.weather.IWeatherServiceProviderChangeListener
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
@Override public void onWeatherServiceProviderChanged(java.lang.String providerLabel) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(providerLabel);
mRemote.transact(Stub.TRANSACTION_onWeatherServiceProviderChanged, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_onWeatherServiceProviderChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void onWeatherServiceProviderChanged(java.lang.String providerLabel) throws android.os.RemoteException;
}
