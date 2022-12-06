package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzsc extends zzcn {
    private final zzbg zzc;

    public zzsc(zzbg zzbg) {
        this.zzc = zzbg;
    }

    public final int zza(Object obj) {
        return obj == zzsb.zzd ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzck zzd(int i, zzck zzck, boolean z) {
        Object obj = null;
        Integer num = z ? 0 : null;
        if (z) {
            obj = zzsb.zzd;
        }
        zzck.zzk(num, obj, 0, C.TIME_UNSET, 0, zzd.zza, true);
        return zzck;
    }

    public final zzcm zze(int i, zzcm zzcm, long j) {
        zzcm zzcm2 = zzcm;
        zzcm.zza(zzcm.zza, this.zzc, (Object) null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, (zzaw) null, 0, C.TIME_UNSET, 0, 0, 0);
        zzcm zzcm3 = zzcm;
        zzcm3.zzl = true;
        return zzcm3;
    }

    public final Object zzf(int i) {
        return zzsb.zzd;
    }
}
