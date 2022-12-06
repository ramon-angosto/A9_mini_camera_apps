package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgbq implements Comparable {
    private final byte[] zza;

    /* synthetic */ zzgbq(byte[] bArr, zzgbp zzgbp) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzgbq zzgbq = (zzgbq) obj;
        int length = this.zza.length;
        int length2 = zzgbq.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = zzgbq.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgbq)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzgbq) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        return zzgoq.zza(this.zza);
    }
}
