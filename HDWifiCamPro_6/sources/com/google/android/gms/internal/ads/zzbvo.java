package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbvo extends zzarz implements zzbvq {
    zzbvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        zzbl(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbl(2, zza());
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbl(3, zza);
    }

    public final void zzh(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zze);
        zzbl(23, zza);
    }

    public final void zzi(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        zzbl(22, zza);
    }

    public final void zzj(int i) throws RemoteException {
        throw null;
    }

    public final void zzk(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zze);
        zzbl(24, zza);
    }

    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbl(21, zza);
    }

    public final void zzm() throws RemoteException {
        zzbl(8, zza());
    }

    public final void zzn() throws RemoteException {
        zzbl(4, zza());
    }

    public final void zzo() throws RemoteException {
        zzbl(6, zza());
    }

    public final void zzp() throws RemoteException {
        zzbl(5, zza());
    }

    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbl(9, zza);
    }

    public final void zzr(zzbmy zzbmy, String str) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbmy);
        zza.writeString(str);
        zzbl(10, zza);
    }

    public final void zzs(zzcce zzcce) throws RemoteException {
        throw null;
    }

    public final void zzt(zzcci zzcci) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzcci);
        zzbl(16, zza);
    }

    public final void zzu() throws RemoteException {
        zzbl(18, zza());
    }

    public final void zzv() throws RemoteException {
        zzbl(11, zza());
    }

    public final void zzw() throws RemoteException {
        zzbl(15, zza());
    }

    public final void zzx() throws RemoteException {
        zzbl(20, zza());
    }

    public final void zzy() throws RemoteException {
        zzbl(13, zza());
    }
}
