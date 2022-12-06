package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITrustedWebActivityService extends IInterface {

    public static class Default implements ITrustedWebActivityService {
        public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
            return null;
        }

        public IBinder asBinder() {
            return null;
        }

        public void cancelNotification(Bundle bundle) throws RemoteException {
        }

        public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
            return null;
        }

        public Bundle getActiveNotifications() throws RemoteException {
            return null;
        }

        public Bundle getSmallIconBitmap() throws RemoteException {
            return null;
        }

        public int getSmallIconId() throws RemoteException {
            return 0;
        }

        public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
            return null;
        }
    }

    Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException;

    void cancelNotification(Bundle bundle) throws RemoteException;

    Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException;

    Bundle getActiveNotifications() throws RemoteException;

    Bundle getSmallIconBitmap() throws RemoteException;

    int getSmallIconId() throws RemoteException;

    Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException;

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {
        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";
        static final int TRANSACTION_areNotificationsEnabled = 6;
        static final int TRANSACTION_cancelNotification = 3;
        static final int TRANSACTION_extraCommand = 9;
        static final int TRANSACTION_getActiveNotifications = 5;
        static final int TRANSACTION_getSmallIconBitmap = 7;
        static final int TRANSACTION_getSmallIconId = 4;
        static final int TRANSACTION_notifyNotificationWithChannel = 2;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITrustedWebActivityService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITrustedWebActivityService)) {
                return new Proxy(iBinder);
            }
            return (ITrustedWebActivityService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 9
                r1 = 0
                r2 = 0
                r3 = 1
                java.lang.String r4 = "android.support.customtabs.trusted.ITrustedWebActivityService"
                if (r6 == r0) goto L_0x00bb
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r6 == r0) goto L_0x00b7
                switch(r6) {
                    case 2: goto L_0x0091;
                    case 3: goto L_0x0078;
                    case 4: goto L_0x006a;
                    case 5: goto L_0x0053;
                    case 6: goto L_0x002d;
                    case 7: goto L_0x0016;
                    default: goto L_0x0011;
                }
            L_0x0011:
                boolean r6 = super.onTransact(r6, r7, r8, r9)
                return r6
            L_0x0016:
                r7.enforceInterface(r4)
                android.os.Bundle r6 = r5.getSmallIconBitmap()
                r8.writeNoException()
                if (r6 == 0) goto L_0x0029
                r8.writeInt(r3)
                r6.writeToParcel(r8, r3)
                goto L_0x002c
            L_0x0029:
                r8.writeInt(r2)
            L_0x002c:
                return r3
            L_0x002d:
                r7.enforceInterface(r4)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x003f
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x003f:
                android.os.Bundle r6 = r5.areNotificationsEnabled(r1)
                r8.writeNoException()
                if (r6 == 0) goto L_0x004f
                r8.writeInt(r3)
                r6.writeToParcel(r8, r3)
                goto L_0x0052
            L_0x004f:
                r8.writeInt(r2)
            L_0x0052:
                return r3
            L_0x0053:
                r7.enforceInterface(r4)
                android.os.Bundle r6 = r5.getActiveNotifications()
                r8.writeNoException()
                if (r6 == 0) goto L_0x0066
                r8.writeInt(r3)
                r6.writeToParcel(r8, r3)
                goto L_0x0069
            L_0x0066:
                r8.writeInt(r2)
            L_0x0069:
                return r3
            L_0x006a:
                r7.enforceInterface(r4)
                int r6 = r5.getSmallIconId()
                r8.writeNoException()
                r8.writeInt(r6)
                return r3
            L_0x0078:
                r7.enforceInterface(r4)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x008a
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x008a:
                r5.cancelNotification(r1)
                r8.writeNoException()
                return r3
            L_0x0091:
                r7.enforceInterface(r4)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x00a3
                android.os.Parcelable$Creator r6 = android.os.Bundle.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x00a3:
                android.os.Bundle r6 = r5.notifyNotificationWithChannel(r1)
                r8.writeNoException()
                if (r6 == 0) goto L_0x00b3
                r8.writeInt(r3)
                r6.writeToParcel(r8, r3)
                goto L_0x00b6
            L_0x00b3:
                r8.writeInt(r2)
            L_0x00b6:
                return r3
            L_0x00b7:
                r8.writeString(r4)
                return r3
            L_0x00bb:
                r7.enforceInterface(r4)
                java.lang.String r6 = r7.readString()
                int r9 = r7.readInt()
                if (r9 == 0) goto L_0x00d1
                android.os.Parcelable$Creator r9 = android.os.Bundle.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r7)
                r1 = r9
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x00d1:
                android.os.IBinder r7 = r7.readStrongBinder()
                android.os.Bundle r6 = r5.extraCommand(r6, r1, r7)
                r8.writeNoException()
                if (r6 == 0) goto L_0x00e5
                r8.writeInt(r3)
                r6.writeToParcel(r8, r3)
                goto L_0x00e8
            L_0x00e5:
                r8.writeInt(r2)
            L_0x00e8:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.customtabs.trusted.ITrustedWebActivityService.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        private static class Proxy implements ITrustedWebActivityService {
            public static ITrustedWebActivityService sDefaultImpl;
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

            public Bundle areNotificationsEnabled(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().areNotificationsEnabled(bundle);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle notifyNotificationWithChannel(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyNotificationWithChannel(bundle);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancelNotification(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().cancelNotification(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getActiveNotifications() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveNotifications();
                    }
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSmallIconId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSmallIconId();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSmallIconBitmap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSmallIconBitmap();
                    }
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) throws RemoteException {
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
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().extraCommand(str, bundle, iBinder);
                    }
                    obtain2.readException();
                    Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(ITrustedWebActivityService iTrustedWebActivityService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iTrustedWebActivityService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iTrustedWebActivityService;
                return true;
            }
        }

        public static ITrustedWebActivityService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
