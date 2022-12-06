package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzel {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzel(long j) {
        zzf(0);
    }

    public final synchronized long zza(long j) {
        if (this.zzb == C.TIME_UNSET) {
            long j2 = this.zza;
            if (j2 == 9223372036854775806L) {
                Long l = (Long) this.zzd.get();
                if (l != null) {
                    j2 = l.longValue();
                } else {
                    throw null;
                }
            }
            this.zzb = j2 - j;
            notifyAll();
        }
        this.zzc = j;
        return j + this.zzb;
    }

    public final synchronized long zzb(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            long j3 = (j2 * 90000) / 1000000;
            long j4 = (4294967296L + j3) / 8589934592L;
            long j5 = ((-1 + j4) * 8589934592L) + j;
            j += j4 * 8589934592L;
            if (Math.abs(j5 - j3) < Math.abs(j - j3)) {
                j = j5;
            }
        }
        return zza((j * 1000000) / 90000);
    }

    public final synchronized long zzc() {
        long j = this.zza;
        return (j == Long.MAX_VALUE || j == 9223372036854775806L) ? C.TIME_UNSET : j;
    }

    public final synchronized long zzd() {
        long j;
        j = this.zzc;
        return j != C.TIME_UNSET ? j + this.zzb : zzc();
    }

    public final synchronized long zze() {
        return this.zzb;
    }

    public final synchronized void zzf(long j) {
        this.zza = j;
        this.zzb = j == Long.MAX_VALUE ? 0 : -9223372036854775807L;
        this.zzc = C.TIME_UNSET;
    }
}
