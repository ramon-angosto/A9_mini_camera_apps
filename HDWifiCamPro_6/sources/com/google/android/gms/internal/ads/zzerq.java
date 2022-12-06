package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzerq implements zzeve {
    private final zzfzq zza;
    private final zzdvq zzb;
    private final String zzc;
    private final zzfef zzd;

    public zzerq(zzfzq zzfzq, zzdvq zzdvq, zzfef zzfef, String str) {
        this.zza = zzfzq;
        this.zzb = zzdvq;
        this.zzd = zzfef;
        this.zzc = str;
    }

    public final int zza() {
        return 17;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzerp(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzerr zzc() throws Exception {
        return new zzerr(this.zzb.zzb(this.zzd.zzf, this.zzc), this.zzb.zza());
    }
}
