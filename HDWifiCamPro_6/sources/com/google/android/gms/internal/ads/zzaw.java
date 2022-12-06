package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaw {
    public static final zzaw zza = new zzaw(new zzau());
    public static final zzn zzb = zzat.zza;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final float zzf;
    public final float zzg;

    private zzaw(zzau zzau) {
        this.zzc = C.TIME_UNSET;
        this.zzd = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzaw = (zzaw) obj;
        long j = zzaw.zzc;
        long j2 = zzaw.zzd;
        long j3 = zzaw.zze;
        float f = zzaw.zzf;
        float f2 = zzaw.zzg;
        return true;
    }

    public final int hashCode() {
        int i = (int) -9223372034707292159L;
        return (((((((i * 31) + i) * 31) + i) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
