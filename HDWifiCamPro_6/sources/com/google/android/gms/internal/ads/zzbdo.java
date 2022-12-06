package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbdo extends zzarz implements zzbdq {
    zzbdo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final void zzb() throws RemoteException {
        zzbl(5, zza());
    }

    public final void zzc() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzd(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zze);
        zzbl(3, zza);
    }

    public final void zze() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzf() throws RemoteException {
        zzbl(1, zza());
    }
}
