package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzoz implements zznv {
    final /* synthetic */ zzpa zza;

    /* synthetic */ zzoz(zzpa zzpa, zzoy zzoy) {
        this.zza = zzpa;
    }

    public final void zza(Exception exc) {
        zzdw.zzc("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    public final void zzb() {
        zzpa zzpa = this.zza;
        if (zzpa.zzl != null) {
            zzpa.zzl.zzb();
        }
    }
}
