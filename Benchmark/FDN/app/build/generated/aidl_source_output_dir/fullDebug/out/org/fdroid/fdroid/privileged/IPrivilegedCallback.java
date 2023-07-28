/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.fdroid.fdroid.privileged;
public interface IPrivilegedCallback extends android.os.IInterface
{
  /** Default implementation for IPrivilegedCallback. */
  public static class Default implements org.fdroid.fdroid.privileged.IPrivilegedCallback
  {
    @Override public void handleResult(java.lang.String packageName, int returnCode) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.fdroid.fdroid.privileged.IPrivilegedCallback
  {
    private static final java.lang.String DESCRIPTOR = "org.fdroid.fdroid.privileged.IPrivilegedCallback";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.fdroid.fdroid.privileged.IPrivilegedCallback interface,
     * generating a proxy if needed.
     */
    public static org.fdroid.fdroid.privileged.IPrivilegedCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.fdroid.fdroid.privileged.IPrivilegedCallback))) {
        return ((org.fdroid.fdroid.privileged.IPrivilegedCallback)iin);
      }
      return new org.fdroid.fdroid.privileged.IPrivilegedCallback.Stub.Proxy(obj);
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
        case TRANSACTION_handleResult:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          this.handleResult(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements org.fdroid.fdroid.privileged.IPrivilegedCallback
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
      @Override public void handleResult(java.lang.String packageName, int returnCode) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(packageName);
          _data.writeInt(returnCode);
          boolean _status = mRemote.transact(Stub.TRANSACTION_handleResult, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().handleResult(packageName, returnCode);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static org.fdroid.fdroid.privileged.IPrivilegedCallback sDefaultImpl;
    }
    static final int TRANSACTION_handleResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(org.fdroid.fdroid.privileged.IPrivilegedCallback impl) {
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
    public static org.fdroid.fdroid.privileged.IPrivilegedCallback getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void handleResult(java.lang.String packageName, int returnCode) throws android.os.RemoteException;
}
