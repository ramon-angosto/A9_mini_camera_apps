package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzakj {
    public final Object zza;
    public final zzajm zzb;
    public final zzakm zzc;
    public boolean zzd;

    private zzakj(zzakm zzakm) {
        this.zzd = false;
        this.zza = null;
        this.zzb = null;
        this.zzc = zzakm;
    }

    private zzakj(Object obj, zzajm zzajm) {
        this.zzd = false;
        this.zza = obj;
        this.zzb = zzajm;
        this.zzc = null;
    }

    public static zzakj zza(zzakm zzakm) {
        return new zzakj(zzakm);
    }

    public static zzakj zzb(Object obj, zzajm zzajm) {
        return new zzakj(obj, zzajm);
    }

    public final boolean zzc() {
        return this.zzc == null;
    }
}
