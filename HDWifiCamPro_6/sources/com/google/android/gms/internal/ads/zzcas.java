package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcas extends zzarz implements zzcau {
    zzcas(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzcbc zzcbc, zzcay zzcay) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzcbc);
        zzasb.zzg(zza, zzcay);
        zzbl(6, zza);
    }

    public final void zzf(zzcbc zzcbc, zzcay zzcay) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzcbc);
        zzasb.zzg(zza, zzcay);
        zzbl(5, zza);
    }

    public final void zzg(zzcbc zzcbc, zzcay zzcay) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzcbc);
        zzasb.zzg(zza, zzcay);
        zzbl(4, zza);
    }

    public final void zzh(String str, zzcay zzcay) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzasb.zzg(zza, zzcay);
        zzbl(7, zza);
    }
}
