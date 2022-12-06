package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzccm extends zzarz implements zzcco {
    zzccm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        zzbl(7, zza());
    }

    public final void zzf() throws RemoteException {
        zzbl(6, zza());
    }

    public final void zzg() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzh(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbl(4, zza);
    }

    public final void zzi(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zze);
        zzbl(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbl(1, zza());
    }

    public final void zzk(zzcci zzcci) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzcci);
        zzbl(3, zza);
    }
}
