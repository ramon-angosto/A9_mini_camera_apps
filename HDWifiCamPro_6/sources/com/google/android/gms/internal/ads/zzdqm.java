package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdqm implements zzddu {
    private final zzdoq zza;
    private final zzdov zzb;

    public zzdqm(zzdoq zzdoq, zzdov zzdov) {
        this.zza = zzdoq;
        this.zzb = zzdov;
    }

    public final void zzl() {
        zzdoq zzdoq = this.zza;
        if (zzdoq.zzu() != null) {
            zzcmp zzq = zzdoq.zzq();
            zzcmp zzr = zzdoq.zzr();
            if (zzq == null) {
                zzq = zzr == null ? null : zzr;
            }
            if (this.zzb.zzd() && zzq != null) {
                zzq.zzd("onSdkImpression", new ArrayMap());
            }
        }
    }
}
