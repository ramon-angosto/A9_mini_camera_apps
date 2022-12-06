package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzqj extends IInterface {

    public static abstract class zza extends Binder implements zzqj {

        /* renamed from: com.google.android.gms.internal.zzqj$zza$zza  reason: collision with other inner class name */
        private static class C0025zza implements zzqj {
            private IBinder zzpb;

            C0025zza(IBinder iBinder) {
                this.zzpb = iBinder;
            }

            public IBinder asBinder() {
                return this.zzpb;
            }

            public int zza(zzd zzd, String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.zzpb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zza(zzd zzd, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zzpb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbz(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int zzb(zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzpb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzqj zzbA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzqj)) ? new C0025zza(iBinder) : (zzqj) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int zzb;
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                zzb = zzb(zzd.zza.zzbz(parcel.readStrongBinder()), parcel.readString());
            } else if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                zzd zza = zza(zzd.zza.zzbz(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeStrongBinder(zza != null ? zza.asBinder() : null);
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                zzb = zza(zzd.zza.zzbz(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0);
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoader");
                return true;
            }
            parcel2.writeNoException();
            parcel2.writeInt(zzb);
            return true;
        }
    }

    int zza(zzd zzd, String str, boolean z) throws RemoteException;

    zzd zza(zzd zzd, String str, int i) throws RemoteException;

    int zzb(zzd zzd, String str) throws RemoteException;
}
