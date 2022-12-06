package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayt {
    public static final zzayt zza = new zzayt(new zzays[0]);
    public final int zzb;
    private final zzays[] zzc;
    private int zzd;

    public zzayt(zzays... zzaysArr) {
        this.zzc = zzaysArr;
        this.zzb = zzaysArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzayt zzayt = (zzayt) obj;
            return this.zzb == zzayt.zzb && Arrays.equals(this.zzc, zzayt.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    public final int zza(zzays zzays) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zzc[i] == zzays) {
                return i;
            }
        }
        return -1;
    }

    public final zzays zzb(int i) {
        return this.zzc[i];
    }
}
