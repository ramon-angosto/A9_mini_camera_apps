package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyw {
    private final zzdfp zza;
    private final zzdhv zzb;

    public zzcyw(zzdfp zzdfp, zzdhv zzdhv) {
        this.zza = zzdfp;
        this.zzb = zzdhv;
    }

    public final zzdfp zza() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final zzdhv zzb() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzdkg zzc() {
        zzdhv zzdhv = this.zzb;
        if (zzdhv != null) {
            return new zzdkg(zzdhv, zzchc.zzf);
        }
        return new zzdkg(new zzcyv(this), zzchc.zzf);
    }
}
