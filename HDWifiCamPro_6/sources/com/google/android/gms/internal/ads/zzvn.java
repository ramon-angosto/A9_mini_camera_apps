package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzvn {
    public final int zza;
    public final zzcp zzb;
    public final int zzc;
    public final zzaf zzd;

    public zzvn(int i, zzcp zzcp, int i2) {
        this.zza = i;
        this.zzb = zzcp;
        this.zzc = i2;
        this.zzd = zzcp.zzb(i2);
    }

    public abstract int zzb();

    public abstract boolean zzc(zzvn zzvn);
}
