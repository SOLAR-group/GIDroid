/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package lineageos.weatherservice;
public interface IWeatherProviderService extends android.os.IInterface
{
  /** Default implementation for IWeatherProviderService. */
  public static class Default implements lineageos.weatherservice.IWeatherProviderService
  {
    @Override public void processWeatherUpdateRequest(lineageos.weather.RequestInfo request) throws android.os.RemoteException
    {
    }
    @Override public void processCityNameLookupRequest(lineageos.weather.RequestInfo request) throws android.os.RemoteException
    {
    }
    @Override public void setServiceClient(lineageos.weatherservice.IWeatherProviderServiceClient client) throws android.os.RemoteException
    {
    }
    @Override public void cancelOngoingRequests() throws android.os.RemoteException
    {
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
  public static abstract class Stub extends android.os.Binder implements lineageos.weatherservice.IWeatherProviderService
  {
    private static final java.lang.String DESCRIPTOR = "lineageos.weatherservice.IWeatherProviderService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an lineageos.weatherservice.IWeatherProviderService interface,
     * generating a proxy if needed.
     */
    public static lineageos.weatherservice.IWeatherProviderService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof lineageos.weatherservice.IWeatherProviderService))) {
        return ((lineageos.weatherservice.IWeatherProviderService)iin);
      }
      return new lineageos.weatherservice.IWeatherProviderService.Stub.Proxy(obj);
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
        case TRANSACTION_processWeatherUpdateRequest:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.processWeatherUpdateRequest(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_processCityNameLookupRequest:
        {
          data.enforceInterface(descriptor);
          lineageos.weather.RequestInfo _arg0;
          if ((0!=data.readInt())) {
            _arg0 = lineageos.weather.RequestInfo.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          this.processCityNameLookupRequest(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_setServiceClient:
        {
          data.enforceInterface(descriptor);
          lineageos.weatherservice.IWeatherProviderServiceClient _arg0;
          _arg0 = lineageos.weatherservice.IWeatherProviderServiceClient.Stub.asInterface(data.readStrongBinder());
          this.setServiceClient(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_cancelOngoingRequests:
        {
          data.enforceInterface(descriptor);
          this.cancelOngoingRequests();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_cancelRequest:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          this.cancelRequest(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements lineageos.weatherservice.IWeatherProviderService
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
      @Override public void processWeatherUpdateRequest(lineageos.weather.RequestInfo request) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((request!=null)) {
            _data.writeInt(1);
            request.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_processWeatherUpdateRequest, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().processWeatherUpdateRequest(request);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void processCityNameLookupRequest(lineageos.weather.RequestInfo request) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((request!=null)) {
            _data.writeInt(1);
            request.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_processCityNameLookupRequest, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().processCityNameLookupRequest(request);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void setServiceClient(lineageos.weatherservice.IWeatherProviderServiceClient client) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((client!=null))?(client.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_setServiceClient, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().setServiceClient(client);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void cancelOngoingRequests() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_cancelOngoingRequests, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().cancelOngoingRequests();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void cancelRequest(int requestId) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(requestId);
          boolean _status = mRemote.transact(Stub.TRANSACTION_cancelRequest, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().cancelRequest(requestId);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static lineageos.weatherservice.IWeatherProviderService sDefaultImpl;
    }
    static final int TRANSACTION_processWeatherUpdateRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_processCityNameLookupRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_setServiceClient = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_cancelOngoingRequests = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_cancelRequest = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    public static boolean setDefaultImpl(lineageos.weatherservice.IWeatherProviderService impl) {
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
    public static lineageos.weatherservice.IWeatherProviderService getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void processWeatherUpdateRequest(lineageos.weather.RequestInfo request) throws android.os.RemoteException;
  public void processCityNameLookupRequest(lineageos.weather.RequestInfo request) throws android.os.RemoteException;
  public void setServiceClient(lineageos.weatherservice.IWeatherProviderServiceClient client) throws android.os.RemoteException;
  public void cancelOngoingRequests() throws android.os.RemoteException;
  public void cancelRequest(int requestId) throws android.os.RemoteException;
}
