package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzcbw extends zzarz implements zzcby {
    zzcbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void zze(zzcbs zzcbs) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzcbs);
        zzbl(5, zza);
    }

    public final void zzf() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbl(7, zza);
    }

    public final void zzh() throws RemoteException {
        zzbl(6, zza());
    }

    public final void zzi() throws RemoteException {
        zzbl(1, zza());
    }

    public final void zzj() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzk() throws RemoteException {
        zzbl(8, zza());
    }

    public final void zzl() throws RemoteException {
        zzbl(3, zza());
    }
}
