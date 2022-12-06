package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzays {
    public final int zza = 1;
    private final zzasw[] zzb;
    private int zzc;

    public zzays(zzasw... zzaswArr) {
        this.zzb = zzaswArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.zzb, ((zzays) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        this.zzc = hashCode;
        return hashCode;
    }

    public final int zza(zzasw zzasw) {
        for (int i = 0; i <= 0; i++) {
            if (zzasw == this.zzb[i]) {
                return i;
            }
        }
        return -1;
    }

    public final zzasw zzb(int i) {
        return this.zzb[i];
    }
}
