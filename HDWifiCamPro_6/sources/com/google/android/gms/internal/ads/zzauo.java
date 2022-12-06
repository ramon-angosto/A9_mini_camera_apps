package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzauo {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* synthetic */ zzauo(MediaCodec.CryptoInfo cryptoInfo, zzaun zzaun) {
        this.zza = cryptoInfo;
    }

    static /* bridge */ /* synthetic */ void zza(zzauo zzauo, int i, int i2) {
        zzauo.zzb.set(0, 0);
        zzauo.zza.setPattern(zzauo.zzb);
    }
}
