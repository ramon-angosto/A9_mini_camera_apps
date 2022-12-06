package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza  reason: collision with other inner class name */
    public static abstract class C0028zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$zza  reason: collision with other inner class name */
        private static class C0029zza implements zza {
            private IBinder zzpb;

            C0029zza(IBinder iBinder) {
                this.zzpb = iBinder;
            }

            public IBinder asBinder() {
                return this.zzpb;
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        obtain.writeInt(1);
                        logEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzpb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zzpb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzpb.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zza zzdQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0029zza(iBinder) : (zza) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.playlog.internal.LogEvent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.playlog.internal.PlayLoggerContext} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.playlog.internal.PlayLoggerContext} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: type inference failed for: r1v11 */
        /* JADX WARNING: type inference failed for: r1v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 2
                r1 = 0
                r2 = 1
                java.lang.String r3 = "com.google.android.gms.playlog.internal.IPlayLogService"
                if (r5 == r0) goto L_0x0059
                r0 = 3
                if (r5 == r0) goto L_0x0039
                r0 = 4
                if (r5 == r0) goto L_0x001b
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r5 == r0) goto L_0x0017
                boolean r5 = super.onTransact(r5, r6, r7, r8)
                return r5
            L_0x0017:
                r7.writeString(r3)
                return r2
            L_0x001b:
                r6.enforceInterface(r3)
                java.lang.String r5 = r6.readString()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x0031
                com.google.android.gms.playlog.internal.zze r7 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r6)
                r1 = r7
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = (com.google.android.gms.playlog.internal.PlayLoggerContext) r1
            L_0x0031:
                byte[] r6 = r6.createByteArray()
                r4.zza((java.lang.String) r5, (com.google.android.gms.playlog.internal.PlayLoggerContext) r1, (byte[]) r6)
                return r2
            L_0x0039:
                r6.enforceInterface(r3)
                java.lang.String r5 = r6.readString()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x004f
                com.google.android.gms.playlog.internal.zze r7 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r6)
                r1 = r7
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = (com.google.android.gms.playlog.internal.PlayLoggerContext) r1
            L_0x004f:
                com.google.android.gms.playlog.internal.zzc r7 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                java.util.ArrayList r6 = r6.createTypedArrayList(r7)
                r4.zza((java.lang.String) r5, (com.google.android.gms.playlog.internal.PlayLoggerContext) r1, (java.util.List<com.google.android.gms.playlog.internal.LogEvent>) r6)
                return r2
            L_0x0059:
                r6.enforceInterface(r3)
                java.lang.String r5 = r6.readString()
                int r7 = r6.readInt()
                if (r7 == 0) goto L_0x006f
                com.google.android.gms.playlog.internal.zze r7 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r6)
                com.google.android.gms.playlog.internal.PlayLoggerContext r7 = (com.google.android.gms.playlog.internal.PlayLoggerContext) r7
                goto L_0x0070
            L_0x006f:
                r7 = r1
            L_0x0070:
                int r8 = r6.readInt()
                if (r8 == 0) goto L_0x007f
                com.google.android.gms.playlog.internal.zzc r8 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                java.lang.Object r6 = r8.createFromParcel(r6)
                r1 = r6
                com.google.android.gms.playlog.internal.LogEvent r1 = (com.google.android.gms.playlog.internal.LogEvent) r1
            L_0x007f:
                r4.zza((java.lang.String) r5, (com.google.android.gms.playlog.internal.PlayLoggerContext) r7, (com.google.android.gms.playlog.internal.LogEvent) r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zza.C0028zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
