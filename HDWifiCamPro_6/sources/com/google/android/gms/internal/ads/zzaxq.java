package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaxq implements zzayq {
    private final zzayq[] zza;

    public zzaxq(zzayq[] zzayqArr) {
        this.zza = zzayqArr;
    }

    public final long zza() {
        long j = Long.MAX_VALUE;
        for (zzayq zza2 : this.zza) {
            long zza3 = zza2.zza();
            if (zza3 != Long.MIN_VALUE) {
                j = Math.min(j, zza3);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzbj(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zza2 = zza();
            if (zza2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzayq zzayq : this.zza) {
                if (zzayq.zza() == zza2) {
                    z |= zzayq.zzbj(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
