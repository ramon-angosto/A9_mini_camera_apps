package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzbzf;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzaa extends zzav {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzau zzb;

    zzaa(zzau zzau, Activity activity) {
        this.zzb = zzau;
        this.zza = activity;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzl(ObjectWrapper.wrap(this.zza));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbjc.zzc(this.zza);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzis)).booleanValue()) {
            return this.zzb.zzf.zza(this.zza);
        }
        try {
            return zzbzb.zzF(((zzbzf) zzcgt.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzz.zza)).zze(ObjectWrapper.wrap(this.zza)));
        } catch (RemoteException | zzcgs | NullPointerException e) {
            this.zzb.zzh = zzcaf.zza(this.zza.getApplicationContext());
            this.zzb.zzh.zzd(e, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
