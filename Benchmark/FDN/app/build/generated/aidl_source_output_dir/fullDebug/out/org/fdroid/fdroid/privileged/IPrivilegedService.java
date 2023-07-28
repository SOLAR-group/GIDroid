/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package org.fdroid.fdroid.privileged;
public interface IPrivilegedService extends android.os.IInterface
{
  /** Default implementation for IPrivilegedService. */
  public static class Default implements org.fdroid.fdroid.privileged.IPrivilegedService
  {
    @Override public boolean hasPrivilegedPermissions() throws android.os.RemoteException
    {
      return false;
    }
    /**
         * - Docs based on PackageManager.installPackage()
         * - Asynchronous (oneway) IPC calls!
         *
         * Install a package. Since this may take a little while, the result will
         * be posted back to the given callback. An installation will fail if the
         * package named in the package file's manifest is already installed, or if there's no space
         * available on the device.
         *
         * @param packageURI The location of the package file to install.  This can be a 'file:' or a
         * 'content:' URI.
         * @param flags - possible values: {@link #INSTALL_FORWARD_LOCK},
         * {@link #INSTALL_REPLACE_EXISTING}, {@link #INSTALL_ALLOW_TEST}.
         * @param installerPackageName Optional package name of the application that is performing the
         * installation. This identifies which market the package came from.
         * @param callback An callback to get notified when the package installation is
         * complete.
         */
    @Override public void installPackage(android.net.Uri packageURI, int flags, java.lang.String installerPackageName, org.fdroid.fdroid.privileged.IPrivilegedCallback callback) throws android.os.RemoteException
    {
    }
    /**
         * - Docs based on PackageManager.deletePackage()
         * - Asynchronous (oneway) IPC calls!
         *
         * Attempts to delete a package.  Since this may take a little while, the result will
         * be posted back to the given observer.  A deletion will fail if the
         * named package cannot be found, or if the named package is a "system package".
         *
         * @param packageName The name of the package to delete
         * @param flags - possible values: {@link #DELETE_KEEP_DATA},
         * {@link #DELETE_ALL_USERS}.
         * @param callback An callback to get notified when the package deletion is
         * complete.
         */
    @Override public void deletePackage(java.lang.String packageName, int flags, org.fdroid.fdroid.privileged.IPrivilegedCallback callback) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements org.fdroid.fdroid.privileged.IPrivilegedService
  {
    private static final java.lang.String DESCRIPTOR = "org.fdroid.fdroid.privileged.IPrivilegedService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an org.fdroid.fdroid.privileged.IPrivilegedService interface,
     * generating a proxy if needed.
     */
    public static org.fdroid.fdroid.privileged.IPrivilegedService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof org.fdroid.fdroid.privileged.IPrivilegedService))) {
        return ((org.fdroid.fdroid.privileged.IPrivilegedService)iin);
      }
      return new org.fdroid.fdroid.privileged.IPrivilegedService.Stub.Proxy(obj);
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
        case TRANSACTION_hasPrivilegedPermissions:
        {
          data.enforceInterface(descriptor);
          boolean _result = this.hasPrivilegedPermissions();
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_installPackage:
        {
          data.enforceInterface(descriptor);
          android.net.Uri _arg0;
          if ((0!=data.readInt())) {
            _arg0 = android.net.Uri.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          int _arg1;
          _arg1 = data.readInt();
          java.lang.String _arg2;
          _arg2 = data.readString();
          org.fdroid.fdroid.privileged.IPrivilegedCallback _arg3;
          _arg3 = org.fdroid.fdroid.privileged.IPrivilegedCallback.Stub.asInterface(data.readStrongBinder());
          this.installPackage(_arg0, _arg1, _arg2, _arg3);
          return true;
        }
        case TRANSACTION_deletePackage:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          int _arg1;
          _arg1 = data.readInt();
          org.fdroid.fdroid.privileged.IPrivilegedCallback _arg2;
          _arg2 = org.fdroid.fdroid.privileged.IPrivilegedCallback.Stub.asInterface(data.readStrongBinder());
          this.deletePackage(_arg0, _arg1, _arg2);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements org.fdroid.fdroid.privileged.IPrivilegedService
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
      @Override public boolean hasPrivilegedPermissions() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_hasPrivilegedPermissions, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().hasPrivilegedPermissions();
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      /**
           * - Docs based on PackageManager.installPackage()
           * - Asynchronous (oneway) IPC calls!
           *
           * Install a package. Since this may take a little while, the result will
           * be posted back to the given callback. An installation will fail if the
           * package named in the package file's manifest is already installed, or if there's no space
           * available on the device.
           *
           * @param packageURI The location of the package file to install.  This can be a 'file:' or a
           * 'content:' URI.
           * @param flags - possible values: {@link #INSTALL_FORWARD_LOCK},
           * {@link #INSTALL_REPLACE_EXISTING}, {@link #INSTALL_ALLOW_TEST}.
           * @param installerPackageName Optional package name of the application that is performing the
           * installation. This identifies which market the package came from.
           * @param callback An callback to get notified when the package installation is
           * complete.
           */
      @Override public void installPackage(android.net.Uri packageURI, int flags, java.lang.String installerPackageName, org.fdroid.fdroid.privileged.IPrivilegedCallback callback) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((packageURI!=null)) {
            _data.writeInt(1);
            packageURI.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          _data.writeInt(flags);
          _data.writeString(installerPackageName);
          _data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_installPackage, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().installPackage(packageURI, flags, installerPackageName, callback);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      /**
           * - Docs based on PackageManager.deletePackage()
           * - Asynchronous (oneway) IPC calls!
           *
           * Attempts to delete a package.  Since this may take a little while, the result will
           * be posted back to the given observer.  A deletion will fail if the
           * named package cannot be found, or if the named package is a "system package".
           *
           * @param packageName The name of the package to delete
           * @param flags - possible values: {@link #DELETE_KEEP_DATA},
           * {@link #DELETE_ALL_USERS}.
           * @param callback An callback to get notified when the package deletion is
           * complete.
           */
      @Override public void deletePackage(java.lang.String packageName, int flags, org.fdroid.fdroid.privileged.IPrivilegedCallback callback) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(packageName);
          _data.writeInt(flags);
          _data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_deletePackage, _data, null, android.os.IBinder.FLAG_ONEWAY);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().deletePackage(packageName, flags, callback);
            return;
          }
        }
        finally {
          _data.recycle();
        }
      }
      public static org.fdroid.fdroid.privileged.IPrivilegedService sDefaultImpl;
    }
    static final int TRANSACTION_hasPrivilegedPermissions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_installPackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_deletePackage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    public static boolean setDefaultImpl(org.fdroid.fdroid.privileged.IPrivilegedService impl) {
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
    public static org.fdroid.fdroid.privileged.IPrivilegedService getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public boolean hasPrivilegedPermissions() throws android.os.RemoteException;
  /**
       * - Docs based on PackageManager.installPackage()
       * - Asynchronous (oneway) IPC calls!
       *
       * Install a package. Since this may take a little while, the result will
       * be posted back to the given callback. An installation will fail if the
       * package named in the package file's manifest is already installed, or if there's no space
       * available on the device.
       *
       * @param packageURI The location of the package file to install.  This can be a 'file:' or a
       * 'content:' URI.
       * @param flags - possible values: {@link #INSTALL_FORWARD_LOCK},
       * {@link #INSTALL_REPLACE_EXISTING}, {@link #INSTALL_ALLOW_TEST}.
       * @param installerPackageName Optional package name of the application that is performing the
       * installation. This identifies which market the package came from.
       * @param callback An callback to get notified when the package installation is
       * complete.
       */
  public void installPackage(android.net.Uri packageURI, int flags, java.lang.String installerPackageName, org.fdroid.fdroid.privileged.IPrivilegedCallback callback) throws android.os.RemoteException;
  /**
       * - Docs based on PackageManager.deletePackage()
       * - Asynchronous (oneway) IPC calls!
       *
       * Attempts to delete a package.  Since this may take a little while, the result will
       * be posted back to the given observer.  A deletion will fail if the
       * named package cannot be found, or if the named package is a "system package".
       *
       * @param packageName The name of the package to delete
       * @param flags - possible values: {@link #DELETE_KEEP_DATA},
       * {@link #DELETE_ALL_USERS}.
       * @param callback An callback to get notified when the package deletion is
       * complete.
       */
  public void deletePackage(java.lang.String packageName, int flags, org.fdroid.fdroid.privileged.IPrivilegedCallback callback) throws android.os.RemoteException;
}
