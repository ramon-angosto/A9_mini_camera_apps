package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdrk implements zzcoa {
    public final /* synthetic */ zzchg zza;

    public /* synthetic */ zzdrk(zzchg zzchg) {
        this.zza = zzchg;
    }

    public final void zza(boolean z) {
        zzchg zzchg = this.zza;
        if (z) {
            zzchg.zzb();
        } else {
            zzchg.zze(new zzekr(1, "Image Web View failed to load."));
        }
    }
}
