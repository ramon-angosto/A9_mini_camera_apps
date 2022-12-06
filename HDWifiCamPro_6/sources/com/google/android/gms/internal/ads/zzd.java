package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzd {
    public static final zzd zza = new zzd((Object) null, new zzc[0], 0, C.TIME_UNSET, 0);
    public static final zzn zzb = zza.zza;
    private static final zzc zze = new zzc(0).zzb(0);
    public final int zzc = 0;
    public final long zzd = 0;
    private final zzc[] zzf;

    private zzd(Object obj, zzc[] zzcArr, long j, long j2, int i) {
        this.zzf = zzcArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzen.zzT((Object) null, (Object) null) && Arrays.equals(this.zzf, ((zzd) obj).zzf);
        }
    }

    public final int hashCode() {
        return (((int) C.TIME_UNSET) * 961) + Arrays.hashCode(this.zzf);
    }

    public final String toString() {
        return "AdPlaybackState(adsId=" + null + ", adResumePositionUs=0, adGroups=[" + "])";
    }

    public final zzc zza(int i) {
        return i < 0 ? zze : this.zzf[i];
    }
}
