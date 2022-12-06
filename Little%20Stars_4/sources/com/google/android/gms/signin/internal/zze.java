package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzv;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.android.gms.signin.internal.zze$zza$zza  reason: collision with other inner class name */
        private static class C0031zza implements zze {
            private IBinder zzpb;

            C0031zza(IBinder iBinder) {
                this.zzpb = iBinder;
            }

            public IBinder asBinder() {
                return this.zzpb;
            }

            public void zza(int i, Account account, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ResolveAccountRequest resolveAccountRequest, zzv zzv) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzv != null ? zzv.asBinder() : null);
                    this.zzpb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzq zzq, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzpb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        obtain.writeInt(1);
                        recordConsentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest != null) {
                        obtain.writeInt(1);
                        signInRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaC(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzkJ(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zzpb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzee(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C0031zza(iBinder) : (zze) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.common.internal.AuthAccountRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.signin.internal.CheckServerAuthResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.common.internal.ResolveAccountRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.google.android.gms.signin.internal.RecordConsentRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.google.android.gms.signin.internal.SignInRequest} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v19 */
        /* JADX WARNING: type inference failed for: r1v20 */
        /* JADX WARNING: type inference failed for: r1v21 */
        /* JADX WARNING: type inference failed for: r1v22 */
        /* JADX WARNING: type inference failed for: r1v23 */
        /* JADX WARNING: type inference failed for: r1v24 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 2
                r1 = 0
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r3 = 1
                if (r6 == r0) goto L_0x00fc
                r0 = 3
                if (r6 == r0) goto L_0x00e5
                r0 = 4
                r4 = 0
                if (r6 == r0) goto L_0x00d6
                r0 = 5
                if (r6 == r0) goto L_0x00b7
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r6 == r0) goto L_0x00b3
                switch(r6) {
                    case 7: goto L_0x00a8;
                    case 8: goto L_0x0086;
                    case 9: goto L_0x006c;
                    case 10: goto L_0x004e;
                    case 11: goto L_0x003f;
                    case 12: goto L_0x001e;
                    default: goto L_0x0019;
                }
            L_0x0019:
                boolean r6 = super.onTransact(r6, r7, r8, r9)
                return r6
            L_0x001e:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x0030
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.SignInRequest> r6 = com.google.android.gms.signin.internal.SignInRequest.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                com.google.android.gms.signin.internal.SignInRequest r1 = (com.google.android.gms.signin.internal.SignInRequest) r1
            L_0x0030:
                android.os.IBinder r6 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r6 = com.google.android.gms.signin.internal.zzd.zza.zzed(r6)
                r5.zza((com.google.android.gms.signin.internal.SignInRequest) r1, (com.google.android.gms.signin.internal.zzd) r6)
            L_0x003b:
                r8.writeNoException()
                return r3
            L_0x003f:
                r7.enforceInterface(r2)
                android.os.IBinder r6 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r6 = com.google.android.gms.signin.internal.zzd.zza.zzed(r6)
                r5.zzb(r6)
                goto L_0x003b
            L_0x004e:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x0060
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.RecordConsentRequest> r6 = com.google.android.gms.signin.internal.RecordConsentRequest.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                com.google.android.gms.signin.internal.RecordConsentRequest r1 = (com.google.android.gms.signin.internal.RecordConsentRequest) r1
            L_0x0060:
                android.os.IBinder r6 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r6 = com.google.android.gms.signin.internal.zzd.zza.zzed(r6)
                r5.zza((com.google.android.gms.signin.internal.RecordConsentRequest) r1, (com.google.android.gms.signin.internal.zzd) r6)
                goto L_0x003b
            L_0x006c:
                r7.enforceInterface(r2)
                android.os.IBinder r6 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzq r6 = com.google.android.gms.common.internal.zzq.zza.zzaT(r6)
                int r9 = r7.readInt()
                int r7 = r7.readInt()
                if (r7 == 0) goto L_0x0082
                r4 = 1
            L_0x0082:
                r5.zza((com.google.android.gms.common.internal.zzq) r6, (int) r9, (boolean) r4)
                goto L_0x003b
            L_0x0086:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                int r9 = r7.readInt()
                if (r9 == 0) goto L_0x009c
                android.os.Parcelable$Creator r9 = android.accounts.Account.CREATOR
                java.lang.Object r9 = r9.createFromParcel(r7)
                r1 = r9
                android.accounts.Account r1 = (android.accounts.Account) r1
            L_0x009c:
                android.os.IBinder r7 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r7 = com.google.android.gms.signin.internal.zzd.zza.zzed(r7)
                r5.zza((int) r6, (android.accounts.Account) r1, (com.google.android.gms.signin.internal.zzd) r7)
                goto L_0x003b
            L_0x00a8:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                r5.zzkJ(r6)
                goto L_0x003b
            L_0x00b3:
                r8.writeString(r2)
                return r3
            L_0x00b7:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x00c9
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.ResolveAccountRequest> r6 = com.google.android.gms.common.internal.ResolveAccountRequest.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                com.google.android.gms.common.internal.ResolveAccountRequest r1 = (com.google.android.gms.common.internal.ResolveAccountRequest) r1
            L_0x00c9:
                android.os.IBinder r6 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzv r6 = com.google.android.gms.common.internal.zzv.zza.zzaX(r6)
                r5.zza((com.google.android.gms.common.internal.ResolveAccountRequest) r1, (com.google.android.gms.common.internal.zzv) r6)
                goto L_0x003b
            L_0x00d6:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x00e0
                r4 = 1
            L_0x00e0:
                r5.zzaC(r4)
                goto L_0x003b
            L_0x00e5:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x00f7
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.CheckServerAuthResult> r6 = com.google.android.gms.signin.internal.CheckServerAuthResult.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                com.google.android.gms.signin.internal.CheckServerAuthResult r1 = (com.google.android.gms.signin.internal.CheckServerAuthResult) r1
            L_0x00f7:
                r5.zza(r1)
                goto L_0x003b
            L_0x00fc:
                r7.enforceInterface(r2)
                int r6 = r7.readInt()
                if (r6 == 0) goto L_0x010e
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.AuthAccountRequest> r6 = com.google.android.gms.common.internal.AuthAccountRequest.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r7)
                r1 = r6
                com.google.android.gms.common.internal.AuthAccountRequest r1 = (com.google.android.gms.common.internal.AuthAccountRequest) r1
            L_0x010e:
                android.os.IBinder r6 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r6 = com.google.android.gms.signin.internal.zzd.zza.zzed(r6)
                r5.zza((com.google.android.gms.common.internal.AuthAccountRequest) r1, (com.google.android.gms.signin.internal.zzd) r6)
                goto L_0x003b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.zze.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, Account account, zzd zzd) throws RemoteException;

    void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException;

    void zza(ResolveAccountRequest resolveAccountRequest, zzv zzv) throws RemoteException;

    void zza(zzq zzq, int i, boolean z) throws RemoteException;

    void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException;

    void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException;

    void zzaC(boolean z) throws RemoteException;

    void zzb(zzd zzd) throws RemoteException;

    void zzkJ(int i) throws RemoteException;
}
