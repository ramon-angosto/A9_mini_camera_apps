package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.dynamic.zzc$zza$zza  reason: collision with other inner class name */
        private static class C0012zza implements zzc {
            private IBinder zzpb;

            C0012zza(IBinder iBinder) {
                this.zzpb = iBinder;
            }

            public IBinder asBinder() {
                return this.zzpb;
            }

            public Bundle getArguments() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getRetainInstance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getTargetRequestCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getUserVisibleHint() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbz(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdded() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isDetached() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isHidden() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isInLayout() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isRemoving() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isResumed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isVisible() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    boolean z = false;
                    this.zzpb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setHasOptionsMenu(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMenuVisibility(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRetainInstance(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserVisibleHint(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivity(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzpb.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivityForResult(Intent intent, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzpb.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzv(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzw(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzxe() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbz(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzc zzxf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return zza.zzby(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzxg() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbz(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzc zzxh() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.zzpb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return zza.zzby(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static zzc zzby(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C0012zza(iBinder) : (zzc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v1, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r3v3, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r3v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r3v7, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r3v9, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r3v11, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r3v14, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r3v17 */
        /* JADX WARNING: type inference failed for: r3v18 */
        /* JADX WARNING: type inference failed for: r3v19 */
        /* JADX WARNING: type inference failed for: r3v20 */
        /* JADX WARNING: type inference failed for: r3v21 */
        /* JADX WARNING: type inference failed for: r3v22 */
        /* JADX WARNING: type inference failed for: r3v23 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                java.lang.String r1 = "com.google.android.gms.dynamic.IFragmentWrapper"
                r2 = 1
                if (r5 == r0) goto L_0x01d3
                r0 = 0
                r3 = 0
                switch(r5) {
                    case 2: goto L_0x01bf;
                    case 3: goto L_0x01a8;
                    case 4: goto L_0x019a;
                    case 5: goto L_0x0186;
                    case 6: goto L_0x0172;
                    case 7: goto L_0x0164;
                    case 8: goto L_0x0156;
                    case 9: goto L_0x0142;
                    case 10: goto L_0x0134;
                    case 11: goto L_0x0126;
                    case 12: goto L_0x0112;
                    case 13: goto L_0x0104;
                    case 14: goto L_0x00f6;
                    case 15: goto L_0x00e8;
                    case 16: goto L_0x00da;
                    case 17: goto L_0x00cc;
                    case 18: goto L_0x00be;
                    case 19: goto L_0x00b0;
                    case 20: goto L_0x009e;
                    case 21: goto L_0x008d;
                    case 22: goto L_0x007c;
                    case 23: goto L_0x006b;
                    case 24: goto L_0x005a;
                    case 25: goto L_0x0041;
                    case 26: goto L_0x0024;
                    case 27: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0012:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.google.android.gms.dynamic.zzd r5 = com.google.android.gms.dynamic.zzd.zza.zzbz(r5)
                r4.zzw(r5)
                r7.writeNoException()
                return r2
            L_0x0024:
                r6.enforceInterface(r1)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0036
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.content.Intent r3 = (android.content.Intent) r3
            L_0x0036:
                int r5 = r6.readInt()
                r4.startActivityForResult(r3, r5)
                r7.writeNoException()
                return r2
            L_0x0041:
                r6.enforceInterface(r1)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0053
                android.os.Parcelable$Creator r5 = android.content.Intent.CREATOR
                java.lang.Object r5 = r5.createFromParcel(r6)
                r3 = r5
                android.content.Intent r3 = (android.content.Intent) r3
            L_0x0053:
                r4.startActivity(r3)
                r7.writeNoException()
                return r2
            L_0x005a:
                r6.enforceInterface(r1)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0064
                r0 = 1
            L_0x0064:
                r4.setUserVisibleHint(r0)
                r7.writeNoException()
                return r2
            L_0x006b:
                r6.enforceInterface(r1)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0075
                r0 = 1
            L_0x0075:
                r4.setRetainInstance(r0)
                r7.writeNoException()
                return r2
            L_0x007c:
                r6.enforceInterface(r1)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0086
                r0 = 1
            L_0x0086:
                r4.setMenuVisibility(r0)
                r7.writeNoException()
                return r2
            L_0x008d:
                r6.enforceInterface(r1)
                int r5 = r6.readInt()
                if (r5 == 0) goto L_0x0097
                r0 = 1
            L_0x0097:
                r4.setHasOptionsMenu(r0)
                r7.writeNoException()
                return r2
            L_0x009e:
                r6.enforceInterface(r1)
                android.os.IBinder r5 = r6.readStrongBinder()
                com.google.android.gms.dynamic.zzd r5 = com.google.android.gms.dynamic.zzd.zza.zzbz(r5)
                r4.zzv(r5)
                r7.writeNoException()
                return r2
            L_0x00b0:
                r6.enforceInterface(r1)
                boolean r5 = r4.isVisible()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00be:
                r6.enforceInterface(r1)
                boolean r5 = r4.isResumed()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00cc:
                r6.enforceInterface(r1)
                boolean r5 = r4.isRemoving()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00da:
                r6.enforceInterface(r1)
                boolean r5 = r4.isInLayout()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00e8:
                r6.enforceInterface(r1)
                boolean r5 = r4.isHidden()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x00f6:
                r6.enforceInterface(r1)
                boolean r5 = r4.isDetached()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0104:
                r6.enforceInterface(r1)
                boolean r5 = r4.isAdded()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0112:
                r6.enforceInterface(r1)
                com.google.android.gms.dynamic.zzd r5 = r4.getView()
                r7.writeNoException()
                if (r5 == 0) goto L_0x0122
                android.os.IBinder r3 = r5.asBinder()
            L_0x0122:
                r7.writeStrongBinder(r3)
                return r2
            L_0x0126:
                r6.enforceInterface(r1)
                boolean r5 = r4.getUserVisibleHint()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0134:
                r6.enforceInterface(r1)
                int r5 = r4.getTargetRequestCode()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0142:
                r6.enforceInterface(r1)
                com.google.android.gms.dynamic.zzc r5 = r4.zzxh()
                r7.writeNoException()
                if (r5 == 0) goto L_0x0152
                android.os.IBinder r3 = r5.asBinder()
            L_0x0152:
                r7.writeStrongBinder(r3)
                return r2
            L_0x0156:
                r6.enforceInterface(r1)
                java.lang.String r5 = r4.getTag()
                r7.writeNoException()
                r7.writeString(r5)
                return r2
            L_0x0164:
                r6.enforceInterface(r1)
                boolean r5 = r4.getRetainInstance()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x0172:
                r6.enforceInterface(r1)
                com.google.android.gms.dynamic.zzd r5 = r4.zzxg()
                r7.writeNoException()
                if (r5 == 0) goto L_0x0182
                android.os.IBinder r3 = r5.asBinder()
            L_0x0182:
                r7.writeStrongBinder(r3)
                return r2
            L_0x0186:
                r6.enforceInterface(r1)
                com.google.android.gms.dynamic.zzc r5 = r4.zzxf()
                r7.writeNoException()
                if (r5 == 0) goto L_0x0196
                android.os.IBinder r3 = r5.asBinder()
            L_0x0196:
                r7.writeStrongBinder(r3)
                return r2
            L_0x019a:
                r6.enforceInterface(r1)
                int r5 = r4.getId()
                r7.writeNoException()
                r7.writeInt(r5)
                return r2
            L_0x01a8:
                r6.enforceInterface(r1)
                android.os.Bundle r5 = r4.getArguments()
                r7.writeNoException()
                if (r5 == 0) goto L_0x01bb
                r7.writeInt(r2)
                r5.writeToParcel(r7, r2)
                goto L_0x01be
            L_0x01bb:
                r7.writeInt(r0)
            L_0x01be:
                return r2
            L_0x01bf:
                r6.enforceInterface(r1)
                com.google.android.gms.dynamic.zzd r5 = r4.zzxe()
                r7.writeNoException()
                if (r5 == 0) goto L_0x01cf
                android.os.IBinder r3 = r5.asBinder()
            L_0x01cf:
                r7.writeStrongBinder(r3)
                return r2
            L_0x01d3:
                r7.writeString(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamic.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    zzd getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void zzv(zzd zzd) throws RemoteException;

    void zzw(zzd zzd) throws RemoteException;

    zzd zzxe() throws RemoteException;

    zzc zzxf() throws RemoteException;

    zzd zzxg() throws RemoteException;

    zzc zzxh() throws RemoteException;
}
