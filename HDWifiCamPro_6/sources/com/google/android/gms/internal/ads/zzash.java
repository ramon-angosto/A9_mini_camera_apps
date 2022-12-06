package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzash {
    public static final int zza = (zzbar.zza < 23 ? 1020 : 6396);
    public static final UUID zzb = new UUID(0, 0);
    public static final UUID zzc = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID zzd = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID zze = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long zza(long j) {
        return j == C.TIME_UNSET ? C.TIME_UNSET : j * 1000;
    }

    public static long zzb(long j) {
        return j == C.TIME_UNSET ? C.TIME_UNSET : j / 1000;
    }
}
