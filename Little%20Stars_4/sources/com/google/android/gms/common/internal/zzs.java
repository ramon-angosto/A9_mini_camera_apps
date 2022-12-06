package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzs extends IInterface {

    public static abstract class zza extends Binder implements zzs {
        public zza() {
            attachInterface(this, "com.google.android.gms.common.internal.ICertData");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                zzd zzqW = zzqW();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(zzqW != null ? zzqW.asBinder() : null);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.common.internal.ICertData");
                int zzqX = zzqX();
                parcel2.writeNoException();
                parcel2.writeInt(zzqX);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.common.internal.ICertData");
                return true;
            }
        }
    }

    zzd zzqW() throws RemoteException;

    int zzqX() throws RemoteException;
}
