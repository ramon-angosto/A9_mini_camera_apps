package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzctc implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzctc(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* synthetic */ Object zzb() {
        zzbuz zzbuz = new zzbuz();
        String str = (String) this.zzb.zzb();
        return ((Boolean) zzbkt.zza.zze()).booleanValue() ? new zzbuy(zzbuz, str) : new zzcgu(str);
    }
}
