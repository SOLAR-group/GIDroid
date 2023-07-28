/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package lineageos.weatherservice;
public interface IWeatherProviderServiceClient extends android.os.IInterface
{
  /** Default implementation for IWeatherProviderServiceClient. */
  public static class Default implements lineageos.weatherservice.IWeatherProviderServiceClient
  {
    @Override public void setServiceRequestState(lineageos.weather.RequestInfo requestInfo, lineageos.weatherservice.ServiceRequestResult result, int state) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements lineageos.weatherservice.IWeatherProviderServiceClient
  {
    private static final java.lang.String DESCRIPTOR = "lineageos.weatherservice.IWeatherProviderServiceClient";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an lineageos.weatherservice.IWeatherProviderServiceClient interface,
     * generating a proxy if needed.
     */
    public static lineageos.weatherservice.IWeatherProviderServiceClient asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof lineageos.weatherservice.IWeatherProviderServiceClient))) {
        return ((lineageos.weatherservice.IWeatherProviderServiceClient)iin);
      }
      return new lineageos.weatherservice.IWeatherProviderServiceClient.Stub.Proxy(obj);
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
        case TRANSACTION_setServiceRequestState:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          lineageos.weatherservice.ServiceRequestResult _arg1;
          if ((0!=data.readInt())) {
            _arg1 = lineageos.weatherservice.ServiceRequestResult.CREATOR.createFromParcel(data);
          }
          else {
            _arg1 = null;
          }
          int _arg2;
          _arg2 = data.readInt();
          this.setServiceRequestState(_arg0, _arg1, _arg2);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements lineageos.weatherservice.IWeatherProviderServiceClient
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
      @Override public void setServiceRequestState(lineageos.weather.RequestInfo requestInfo, lineageos.weatherservice.ServiceRequestResult result, int state) throws android.os.RemoteException
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
          if ((result!=null)) {
            _data.writeInt(1);
            result.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeInt(state);
          boolean _status = mRemote.transact(Stub.TRANSACTION_setServiceRequestState, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().setServiceRequestState(requestInfo, result, state);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static lineageos.weatherservice.IWeatherProviderServiceClient sDefaultImpl;
    }
    static final int TRANSACTION_setServiceRequestState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(lineageos.weatherservice.IWeatherProviderServiceClient impl) {
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
    public static lineageos.weatherservice.IWeatherProviderServiceClient getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void setServiceRequestState(lineageos.weather.RequestInfo requestInfo, lineageos.weatherservice.ServiceRequestResult result, int state) throws android.os.RemoteException;
}
