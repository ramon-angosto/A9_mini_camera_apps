package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IDislikeClosedListener extends IInterface {

    public static class Default implements IDislikeClosedListener {
        public IBinder asBinder() {
            return null;
        }

        public void onItemClickClosed() throws RemoteException {
        }
    }

    void onItemClickClosed() throws RemoteException;

    public static abstract class Stub extends Binder implements IDislikeClosedListener {
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IDislikeClosedListener");
        }

        public static IDislikeClosedListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IDislikeClosedListener");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDislikeClosedListener)) {
                return new a(iBinder);
            }
            return (IDislikeClosedListener) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IDislikeClosedListener");
                onItemClickClosed();
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.bytedance.sdk.openadsdk.IDislikeClosedListener");
                return true;
            }
        }

        private static class a implements IDislikeClosedListener {
            public static IDislikeClosedListener a;
            private IBinder b;

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            public IBinder asBinder() {
                return this.b;
            }

            public void onItemClickClosed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IDislikeClosedListener");
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onItemClickClosed();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDislikeClosedListener iDislikeClosedListener) {
            if (a.a != null || iDislikeClosedListener == null) {
                return false;
            }
            a.a = iDislikeClosedListener;
            return true;
        }

        public static IDislikeClosedListener getDefaultImpl() {
            return a.a;
        }
    }
}
