package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdwx implements zzfii {
    private final Map zza;
    private final zzbep zzb;

    zzdwx(zzbep zzbep, Map map) {
        this.zza = map;
        this.zzb = zzbep;
    }

    public final void zzbF(zzfib zzfib, String str) {
    }

    public final void zzbG(zzfib zzfib, String str, Throwable th) {
        if (this.zza.containsKey(zzfib)) {
            this.zzb.zzc(((zzdww) this.zza.get(zzfib)).zzc);
        }
    }

    public final void zzc(zzfib zzfib, String str) {
        if (this.zza.containsKey(zzfib)) {
            this.zzb.zzc(((zzdww) this.zza.get(zzfib)).zza);
        }
    }

    public final void zzd(zzfib zzfib, String str) {
        if (this.zza.containsKey(zzfib)) {
            this.zzb.zzc(((zzdww) this.zza.get(zzfib)).zzb);
        }
    }
}
