package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IAppOpenAdInteractionListener extends IInterface {

    public static class Default implements IAppOpenAdInteractionListener {
        public IBinder asBinder() {
            return null;
        }

        public void onAdClicked() throws RemoteException {
        }

        public void onAdShow() throws RemoteException {
        }

        public void onAdSkip() throws RemoteException {
        }

        public void onAdTimeOver() throws RemoteException {
        }

        public void onDestroy() throws RemoteException {
        }
    }

    void onAdClicked() throws RemoteException;

    void onAdShow() throws RemoteException;

    void onAdSkip() throws RemoteException;

    void onAdTimeOver() throws RemoteException;

    void onDestroy() throws RemoteException;

    public static abstract class Stub extends Binder implements IAppOpenAdInteractionListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
        }

        public static IAppOpenAdInteractionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IAppOpenAdInteractionListener)) {
                return new a(iBinder);
            }
            return (IAppOpenAdInteractionListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                onDestroy();
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                onAdShow();
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                onAdClicked();
                parcel2.writeNoException();
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                onAdSkip();
                parcel2.writeNoException();
                return true;
            } else if (i == 5) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                onAdTimeOver();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                return true;
            }
        }

        private static class a implements IAppOpenAdInteractionListener {
            public static IAppOpenAdInteractionListener a;
            private IBinder b;

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            public IBinder asBinder() {
                return this.b;
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onDestroy();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAdShow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                    if (this.b.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAdShow();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAdClicked() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                    if (this.b.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAdClicked();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAdSkip() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                    if (this.b.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAdSkip();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onAdTimeOver() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener");
                    if (this.b.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onAdTimeOver();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IAppOpenAdInteractionListener iAppOpenAdInteractionListener) {
            if (a.a != null || iAppOpenAdInteractionListener == null) {
                return false;
            }
            a.a = iAppOpenAdInteractionListener;
            return true;
        }

        public static IAppOpenAdInteractionListener getDefaultImpl() {
            return a.a;
        }
    }
}
