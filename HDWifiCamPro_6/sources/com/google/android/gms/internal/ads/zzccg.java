package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzccg extends zzarz implements zzcci {
    zzccg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final int zze() throws RemoteException {
        Parcel zzbk = zzbk(2, zza());
        int readInt = zzbk.readInt();
        zzbk.recycle();
        return readInt;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbk = zzbk(1, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }
}
