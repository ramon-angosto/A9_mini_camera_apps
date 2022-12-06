package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzoi {
    final zzoh zza = zzoh.zza;
    /* access modifiers changed from: private */
    public zznd zzb = zznd.zza;
    /* access modifiers changed from: private */
    public zzok zzc;

    public final zzoi zzb(zznd zznd) {
        this.zzb = zznd;
        return this;
    }

    public final zzoi zzc(zzng[] zzngArr) {
        this.zzc = new zzok(zzngArr);
        return this;
    }

    public final zzou zzd() {
        if (this.zzc == null) {
            this.zzc = new zzok(new zzng[0]);
        }
        return new zzou(this, (zzot) null);
    }
}
