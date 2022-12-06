package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzega implements zzfii {
    private final zzefo zza;
    private final zzefs zzb;

    zzega(zzefo zzefo, zzefs zzefs) {
        this.zza = zzefo;
        this.zzb = zzefs;
    }

    public final void zzbF(zzfib zzfib, String str) {
    }

    public final void zzbG(zzfib zzfib, String str, Throwable th) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue() && zzfib.RENDERER == zzfib && this.zza.zzc() != 0) {
            this.zza.zzf(zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzc(zzfib zzfib, String str) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue()) {
            if (zzfib.RENDERER == zzfib) {
                this.zza.zzg(zzt.zzB().elapsedRealtime());
            } else if (zzfib.PRELOADED_LOADER == zzfib || zzfib.SERVER_TRANSACTION == zzfib) {
                this.zza.zzh(zzt.zzB().elapsedRealtime());
                zzefs zzefs = this.zzb;
                zzefs.zza.zza(new zzefr(zzefs, this.zza.zzd()));
            }
        }
    }

    public final void zzd(zzfib zzfib, String str) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfm)).booleanValue() && zzfib.RENDERER == zzfib && this.zza.zzc() != 0) {
            this.zza.zzf(zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }
}
