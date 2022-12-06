package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafp {
    public final zzafv zza;
    public final zzafy zzb;
    public final zzaap zzc;
    public final zzaaq zzd;
    public int zze;

    public zzafp(zzafv zzafv, zzafy zzafy, zzaap zzaap) {
        this.zza = zzafv;
        this.zzb = zzafy;
        this.zzc = zzaap;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzafv.zzf.zzm) ? new zzaaq() : null;
    }
}
