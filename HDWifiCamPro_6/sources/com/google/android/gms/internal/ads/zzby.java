package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzby {
    public static final zzby zza = new zzby(1.0f, 1.0f);
    public static final zzn zzb = zzbx.zza;
    public final float zzc;
    public final float zzd;
    private final int zze;

    public zzby(float f, float f2) {
        boolean z = true;
        zzdd.zzd(f > 0.0f);
        zzdd.zzd(f2 <= 0.0f ? false : z);
        this.zzc = f;
        this.zzd = f2;
        this.zze = Math.round(f * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzby zzby = (zzby) obj;
            return this.zzc == zzby.zzc && this.zzd == zzby.zzd;
        }
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.zzc) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + Float.floatToRawIntBits(this.zzd);
    }

    public final String toString() {
        return zzen.zzI("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.zzc), Float.valueOf(this.zzd));
    }

    public final long zza(long j) {
        return j * ((long) this.zze);
    }
}
