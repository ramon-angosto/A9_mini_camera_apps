package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
public final class zzd extends zza implements zzf {
    zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String zzc() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final boolean zzd() throws RemoteException {
        Parcel zzb = zzb(6, zza());
        boolean zzb2 = zzc.zzb(zzb);
        zzb.recycle();
        return zzb2;
    }

    public final boolean zze(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, true);
        Parcel zzb = zzb(2, zza);
        boolean zzb2 = zzc.zzb(zzb);
        zzb.recycle();
        return zzb2;
    }
}
