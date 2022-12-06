package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaxd implements zzaxa {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zzaxd(boolean z) {
        this.zza = z ? 1 : 0;
    }

    private final void zze() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    public final int zza() {
        zze();
        return this.zzb.length;
    }

    public final MediaCodecInfo zzb(int i) {
        zze();
        return this.zzb[i];
    }

    public final boolean zzc(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public final boolean zzd() {
        return true;
    }
}
