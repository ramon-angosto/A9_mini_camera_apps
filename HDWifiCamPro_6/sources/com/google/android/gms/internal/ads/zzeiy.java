package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeiy extends zzccc implements zzdek {
    private zzccd zza;
    private zzdej zzb;
    private zzdky zzc;

    public final synchronized void zza(zzdej zzdej) {
        this.zzb = zzdej;
    }

    public final synchronized void zzc(zzccd zzccd) {
        this.zza = zzccd;
    }

    public final synchronized void zzd(zzdky zzdky) {
        this.zzc = zzdky;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            ((zzelr) zzccd).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            zzccd.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdej zzdej = this.zzb;
        if (zzdej != null) {
            zzdej.zza(i);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            ((zzelr) zzccd).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdej zzdej = this.zzb;
        if (zzdej != null) {
            zzdej.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            ((zzelr) zzccd).zza.zzb();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdky zzdky = this.zzc;
        if (zzdky != null) {
            zze.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzelq) zzdky).zzc.zza)));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdky zzdky = this.zzc;
        if (zzdky != null) {
            ((zzelq) zzdky).zzd.zzb.execute(new zzelp((zzelq) zzdky, ((zzelq) zzdky).zza, ((zzelq) zzdky).zzb, ((zzelq) zzdky).zzc));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzcce zzcce) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            ((zzelr) zzccd).zzd.zza(zzcce);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            ((zzelr) zzccd).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzccd zzccd = this.zza;
        if (zzccd != null) {
            ((zzelr) zzccd).zzd.zzc();
        }
    }
}
