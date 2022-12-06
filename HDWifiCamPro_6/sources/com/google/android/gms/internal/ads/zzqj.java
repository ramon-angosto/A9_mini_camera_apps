package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzqj {
    public final zzqn zza;
    public final MediaFormat zzb;
    public final zzaf zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;

    private zzqj(zzqn zzqn, MediaFormat mediaFormat, zzaf zzaf, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.zza = zzqn;
        this.zzb = mediaFormat;
        this.zzc = zzaf;
        this.zzd = surface;
    }

    public static zzqj zza(zzqn zzqn, MediaFormat mediaFormat, zzaf zzaf, MediaCrypto mediaCrypto) {
        return new zzqj(zzqn, mediaFormat, zzaf, (Surface) null, (MediaCrypto) null, 0);
    }

    public static zzqj zzb(zzqn zzqn, MediaFormat mediaFormat, zzaf zzaf, Surface surface, MediaCrypto mediaCrypto) {
        return new zzqj(zzqn, mediaFormat, zzaf, surface, (MediaCrypto) null, 0);
    }
}
