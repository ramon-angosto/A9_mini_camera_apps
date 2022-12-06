package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzabu {
    protected final zzaap zza;

    protected zzabu(zzaap zzaap) {
        this.zza = zzaap;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzef zzef) throws zzbu;

    /* access modifiers changed from: protected */
    public abstract boolean zzb(zzef zzef, long j) throws zzbu;

    public final boolean zzf(zzef zzef, long j) throws zzbu {
        return zza(zzef) && zzb(zzef, j);
    }
}
