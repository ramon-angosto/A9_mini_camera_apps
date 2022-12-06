package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzge {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    /* synthetic */ zzge(MediaCodec.CryptoInfo cryptoInfo, zzgd zzgd) {
        this.zza = cryptoInfo;
    }

    static /* bridge */ /* synthetic */ void zza(zzge zzge, int i, int i2) {
        zzge.zzb.set(i, i2);
        zzge.zza.setPattern(zzge.zzb);
    }
}
