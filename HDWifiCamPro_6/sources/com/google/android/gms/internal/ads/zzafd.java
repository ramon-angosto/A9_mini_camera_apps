package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafd implements zzafa {
    private final zzef zza;
    private final int zzb = this.zza.zzn();
    private final int zzc = (this.zza.zzn() & 255);
    private int zzd;
    private int zze;

    public zzafd(zzaew zzaew) {
        this.zza = zzaew.zza;
        this.zza.zzF(12);
    }

    public final int zza() {
        return -1;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzk();
        }
        if (i == 16) {
            return this.zza.zzo();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzk = this.zza.zzk();
        this.zze = zzk;
        return (zzk & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }
}
