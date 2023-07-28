/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package lineageos.weather;
public interface ILineageWeatherManager extends android.os.IInterface
{
  /** Default implementation for ILineageWeatherManager. */
  public static class Default implements lineageos.weather.ILineageWeatherManager
  {
    @Override public void updateWeather(lineageos.weather.RequestInfo info) throws android.os.RemoteException
    {
    }
    @Override public void lookupCity(lineageos.weather.RequestInfo info) throws android.os.RemoteException
    {
    }
    @Override public void registerWeatherServiceProviderChangeListener(lineageos.weather.IWeatherServiceProviderChangeListener listener) throws android.os.RemoteException
    {
    }
    @Override public void unregisterWeatherServiceProviderChangeListener(lineageos.weather.IWeatherServiceProviderChangeListener listener) throws android.os.RemoteException
    {
    }
    @Override public java.lang.String getActiveWeatherServiceProviderLabel() throws android.os.RemoteException
    {
      return null;
    }
    @Override public void cancelRequest(int requestId) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements lineageos.weather.ILineageWeatherManager
  {
    private static final java.lang.String DESCRIPTOR = "lineageos.weather.ILineageWeatherManager";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an lineageos.weather.ILineageWeatherManager interface,
     * generating a proxy if needed.
     */
    public static lineageos.weather.ILineageWeatherManager asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof lineageos.weather.ILineageWeatherManager))) {
        return ((lineageos.weather.ILineageWeatherManager)iin);
      }
      return new lineageos.weather.ILineageWeatherManager.Stub.Proxy(obj);
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
        case TRANSACTION_updateWeather:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.updateWeather(_arg0);
          return true;
        }
        case TRANSACTION_lookupCity:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.lookupCity(_arg0);
          return true;
        }
        case TRANSACTION_registerWeatherServiceProviderChangeListener:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.IWeatherServiceProviderChangeListener _arg0;
          _arg0 = lineageos.weather.IWeatherServiceProviderChangeListener.Stub.asInterface(data.readStrongBinder());
          this.registerWeatherServiceProviderChangeListener(_arg0);
          return true;
        }
        case TRANSACTION_unregisterWeatherServiceProviderChangeListener:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.IWeatherServiceProviderChangeListener _arg0;
          _arg0 = lineageos.weather.IWeatherServiceProviderChangeListener.Stub.asInterface(data.readStrongBinder());
          this.unregisterWeatherServiceProviderChangeListener(_arg0);
          return true;
        }
        case TRANSACTION_getActiveWeatherServiceProviderLabel:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.getActiveWeatherServiceProviderLabel();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_cancelRequest:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.cancelRequest(_arg0);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements lineageos.weather.ILineageWeatherManager
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
      @Override public void updateWeather(lineageos.weather.RequestInfo info) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((info!=null)) {
            _data.writeInt(1);
            info.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_updateWeather, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().updateWeather(info);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void lookupCity(lineageos.weather.RequestInfo info) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((info!=null)) {
            _data.writeInt(1);
            info.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_lookupCity, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().lookupCity(info);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void registerWeatherServiceProviderChangeListener(lineageos.weather.IWeatherServiceProviderChangeListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_registerWeatherServiceProviderChangeListener, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().registerWeatherServiceProviderChangeListener(listener);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public void unregisterWeatherServiceProviderChangeListener(lineageos.weather.IWeatherServiceProviderChangeListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_unregisterWeatherServiceProviderChangeListener, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().unregisterWeatherServiceProviderChangeListener(listener);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      @Override public java.lang.String getActiveWeatherServiceProviderLabel() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getActiveWeatherServiceProviderLabel, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getActiveWeatherServiceProviderLabel();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void cancelRequest(int requestId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(requestId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_cancelRequest, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().cancelRequest(requestId);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      public static lineageos.weather.ILineageWeatherManager sDefaultImpl;
    }
    static final int TRANSACTION_updateWeather = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_lookupCity = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_registerWeatherServiceProviderChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_unregisterWeatherServiceProviderChangeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getActiveWeatherServiceProviderLabel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_cancelRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    public static boolean setDefaultImpl(lineageos.weather.ILineageWeatherManager impl) {
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
    public static lineageos.weather.ILineageWeatherManager getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void updateWeather(lineageos.weather.RequestInfo info) throws android.os.RemoteException;
  public void lookupCity(lineageos.weather.RequestInfo info) throws android.os.RemoteException;
  public void registerWeatherServiceProviderChangeListener(lineageos.weather.IWeatherServiceProviderChangeListener listener) throws android.os.RemoteException;
  public void unregisterWeatherServiceProviderChangeListener(lineageos.weather.IWeatherServiceProviderChangeListener listener) throws android.os.RemoteException;
  public java.lang.String getActiveWeatherServiceProviderLabel() throws android.os.RemoteException;
  public void cancelRequest(int requestId) throws android.os.RemoteException;
}
