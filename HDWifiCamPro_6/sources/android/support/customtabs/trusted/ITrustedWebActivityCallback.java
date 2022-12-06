package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITrustedWebActivityCallback extends IInterface {

    public static class Default implements ITrustedWebActivityCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
        }
    }

    void onExtraCallback(String str, Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {
        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityCallback";
        static final int TRANSACTION_onExtraCallback = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITrustedWebActivityCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITrustedWebActivityCallback)) {
                return new Proxy(iBinder);
            }
            return (ITrustedWebActivityCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onExtraCallback(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements ITrustedWebActivityCallback {
            public static ITrustedWebActivityCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().onExtraCallback(str, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iTrustedWebActivityCallback == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iTrustedWebActivityCallback;
                return true;
            }
        }

        public static ITrustedWebActivityCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
