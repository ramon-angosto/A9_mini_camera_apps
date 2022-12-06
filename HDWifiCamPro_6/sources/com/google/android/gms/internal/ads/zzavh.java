package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzavh {
    public final int zza = 1;
    public final byte[] zzb;

    public zzavh(int i, byte[] bArr) {
        this.zzb = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.zzb, ((zzavh) obj).zzb);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzb) + 31;
    }
}
