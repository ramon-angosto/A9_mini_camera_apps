package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdxb implements zzdfv, zzdeo, zzddd {
    private final zzdxl zza;
    private final zzdxv zzb;

    public zzdxb(zzdxl zzdxl, zzdxv zzdxv) {
        this.zza = zzdxl;
        this.zzb = zzdxv;
    }

    public final void zza(zze zze) {
        this.zza.zza().put("action", "ftl");
        this.zza.zza().put("ftl", String.valueOf(zze.zza));
        this.zza.zza().put("ed", zze.zzc);
        this.zzb.zze(this.zza.zza());
    }

    public final void zzb(zzfdw zzfdw) {
        this.zza.zzb(zzfdw);
    }

    public final void zzbE(zzcbc zzcbc) {
        this.zza.zzc(zzcbc.zza);
    }

    public final void zzn() {
        this.zza.zza().put("action", "loaded");
        this.zzb.zze(this.zza.zza());
    }
}
