package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzvz {
    private zzvy zza;
    private zzwh zzb;

    public void zzh() {
        this.zza = null;
        this.zzb = null;
    }

    public void zzi(zzk zzk) {
        throw null;
    }

    public boolean zzl() {
        throw null;
    }

    public abstract zzwa zzn(zzkb[] zzkbArr, zzuh zzuh, zzsi zzsi, zzcn zzcn) throws zzha;

    public abstract void zzo(Object obj);

    /* access modifiers changed from: protected */
    public final zzwh zzp() {
        zzwh zzwh = this.zzb;
        zzdd.zzb(zzwh);
        return zzwh;
    }

    public final void zzq(zzvy zzvy, zzwh zzwh) {
        this.zza = zzvy;
        this.zzb = zzwh;
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        zzvy zzvy = this.zza;
        if (zzvy != null) {
            zzvy.zzj();
        }
    }
}
