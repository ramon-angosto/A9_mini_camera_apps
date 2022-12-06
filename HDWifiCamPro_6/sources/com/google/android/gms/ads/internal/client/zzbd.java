package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbd extends zzarz implements zzbf {
    zzbd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzc() throws RemoteException {
        zzbl(6, zza());
    }

    public final void zzd() throws RemoteException {
        zzbl(1, zza());
    }

    public final void zze(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbl(2, zza);
    }

    public final void zzf(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zze);
        zzbl(8, zza);
    }

    public final void zzg() throws RemoteException {
        zzbl(7, zza());
    }

    public final void zzh() throws RemoteException {
        zzbl(3, zza());
    }

    public final void zzi() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzj() throws RemoteException {
        zzbl(5, zza());
    }
}
