package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgpc {
    private final byte[] zza;

    private zzgpc(byte[] bArr, int i, int i2) {
        this.zza = new byte[i2];
        System.arraycopy(bArr, 0, this.zza, 0, i2);
    }

    public static zzgpc zza(byte[] bArr) {
        if (bArr != null) {
            return new zzgpc(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpc)) {
            return false;
        }
        return Arrays.equals(((zzgpc) obj).zza, this.zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String zza2 = zzgoq.zza(this.zza);
        return "Bytes(" + zza2 + ")";
    }

    public final byte[] zzb() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
