package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeil extends zzbwq {
    final /* synthetic */ zzeim zza;
    private final zzehf zzb;

    /* synthetic */ zzeil(zzeim zzeim, zzehf zzehf, zzeik zzeik) {
        this.zza = zzeim;
        this.zzb = zzehf;
    }

    public final void zze(String str) throws RemoteException {
        ((zzeix) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzeix) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzeix) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbvt zzbvt) throws RemoteException {
        this.zza.zzd = zzbvt;
        ((zzeix) this.zzb.zzc).zzo();
    }
}
