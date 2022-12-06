package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzayx {
    protected final zzays zza;
    protected final int[] zzb;
    private final zzasw[] zzc;
    private int zzd;

    public zzayx(zzays zzays, int... iArr) {
        if (zzays != null) {
            this.zza = zzays;
            this.zzc = new zzasw[1];
            for (int i = 0; i <= 0; i++) {
                this.zzc[i] = zzays.zzb(iArr[i]);
            }
            Arrays.sort(this.zzc, new zzayw((zzayv) null));
            this.zzb = new int[1];
            for (int i2 = 0; i2 <= 0; i2++) {
                this.zzb[i2] = zzays.zza(this.zzc[i2]);
            }
            return;
        }
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzayx zzayx = (zzayx) obj;
            return this.zza == zzayx.zza && Arrays.equals(this.zzb, zzayx.zzb);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int identityHashCode = (System.identityHashCode(this.zza) * 31) + Arrays.hashCode(this.zzb);
        this.zzd = identityHashCode;
        return identityHashCode;
    }

    public final int zza(int i) {
        return this.zzb[0];
    }

    public final int zzb() {
        int length = this.zzb.length;
        return 1;
    }

    public final zzasw zzc(int i) {
        return this.zzc[i];
    }

    public final zzays zzd() {
        return this.zza;
    }
}
