package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzafc implements zzafa {
    private final int zza;
    private final int zzb;
    private final zzef zzc;

    public zzafc(zzaew zzaew, zzaf zzaf) {
        this.zzc = zzaew.zza;
        this.zzc.zzF(12);
        int zzn = this.zzc.zzn();
        if (MimeTypes.AUDIO_RAW.equals(zzaf.zzm)) {
            int zzo = zzen.zzo(zzaf.zzB, zzaf.zzz);
            if (zzn == 0 || zzn % zzo != 0) {
                zzdw.zze("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzo + ", stsz sample size: " + zzn);
                zzn = zzo;
            }
        }
        this.zza = zzn == 0 ? -1 : zzn;
        this.zzb = this.zzc.zzn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzn() : i;
    }
}
