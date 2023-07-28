/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package lineageos.weather;
public interface IRequestInfoListener extends android.os.IInterface
{
  /** Default implementation for IRequestInfoListener. */
  public static class Default implements lineageos.weather.IRequestInfoListener
  {
    @Override public void onWeatherRequestCompleted(lineageos.weather.RequestInfo requestInfo, int status, lineageos.weather.WeatherInfo weatherInfo) throws android.os.RemoteException
    {
    }
    @Override public void onLookupCityRequestCompleted(lineageos.weather.RequestInfo requestInfo, int status, java.util.List<lineageos.weather.WeatherLocation> weatherLocation) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements lineageos.weather.IRequestInfoListener
  {
    private static final java.lang.String DESCRIPTOR = "lineageos.weather.IRequestInfoListener";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an lineageos.weather.IRequestInfoListener interface,
     * generating a proxy if needed.
     */
    public static lineageos.weather.IRequestInfoListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof lineageos.weather.IRequestInfoListener))) {
        return ((lineageos.weather.IRequestInfoListener)iin);
      }
      return new lineageos.weather.IRequestInfoListener.Stub.Proxy(obj);
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
        case TRANSACTION_onWeatherRequestCompleted:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          int _arg1;
          _arg1 = data.readInt();
          lineageos.weather.WeatherInfo _arg2;
          if ((0!=data.readInt())) {
            _arg2 = lineageos.weather.WeatherInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg2 = null;
          }
          this.onWeatherRequestCompleted(_arg0, _arg1, _arg2);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_onLookupCityRequestCompleted:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          int _arg1;
          _arg1 = data.readInt();
          java.util.List<lineageos.weather.WeatherLocation> _arg2;
          _arg2 = data.createTypedArrayList(lineageos.weather.WeatherLocation.CREATOR);
          this.onLookupCityRequestCompleted(_arg0, _arg1, _arg2);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements lineageos.weather.IRequestInfoListener
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
      @Override public void onWeatherRequestCompleted(lineageos.weather.RequestInfo requestInfo, int status, lineageos.weather.WeatherInfo weatherInfo) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((requestInfo!=null)) {
            _data.writeInt(1);
            requestInfo.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeInt(status);
          if ((weatherInfo!=null)) {
            _data.writeInt(1);
            weatherInfo.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_onWeatherRequestCompleted, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onWeatherRequestCompleted(requestInfo, status, weatherInfo);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void onLookupCityRequestCompleted(lineageos.weather.RequestInfo requestInfo, int status, java.util.List<lineageos.weather.WeatherLocation> weatherLocation) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((requestInfo!=null)) {
            _data.writeInt(1);
            requestInfo.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeInt(status);
          _data.writeTypedList(weatherLocation);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onLookupCityRequestCompleted, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onLookupCityRequestCompleted(requestInfo, status, weatherLocation);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static lineageos.weather.IRequestInfoListener sDefaultImpl;
    }
    static final int TRANSACTION_onWeatherRequestCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_onLookupCityRequestCompleted = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static boolean setDefaultImpl(lineageos.weather.IRequestInfoListener impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Stub.Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static lineageos.weather.IRequestInfoListener getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void onWeatherRequestCompleted(lineageos.weather.RequestInfo requestInfo, int status, lineageos.weather.WeatherInfo weatherInfo) throws android.os.RemoteException;
  public void onLookupCityRequestCompleted(lineageos.weather.RequestInfo requestInfo, int status, java.util.List<lineageos.weather.WeatherLocation> weatherLocation) throws android.os.RemoteException;
}
