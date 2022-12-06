package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbwm extends zzbvp {
    private final Adapter zza;
    private final zzccd zzb;

    zzbwm(Adapter adapter, zzccd zzccd) {
        this.zza = adapter;
        this.zzb = zzccd;
    }

    public final void zze() throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzh(zze zze) throws RemoteException {
    }

    public final void zzi(int i, String str) throws RemoteException {
    }

    public final void zzj(int i) throws RemoteException {
    }

    public final void zzk(zze zze) {
    }

    public final void zzl(String str) {
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbmy zzbmy, String str) throws RemoteException {
    }

    public final void zzs(zzcce zzcce) throws RemoteException {
    }

    public final void zzt(zzcci zzcci) throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzm(ObjectWrapper.wrap(this.zza), new zzcce(zzcci.zzf(), zzcci.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzy() throws RemoteException {
        zzccd zzccd = this.zzb;
        if (zzccd != null) {
            zzccd.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
