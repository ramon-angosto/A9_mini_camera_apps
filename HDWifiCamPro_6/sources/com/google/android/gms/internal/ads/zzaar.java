package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaar {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzaar(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final int zza() {
        return (this.zzc * 8) + this.zzd;
    }

    public final int zzb(int i) {
        int i2 = this.zzc;
        int min = Math.min(i, 8 - this.zzd);
        int i3 = i2 + 1;
        int i4 = ((this.zza[i2] & UByte.MAX_VALUE) >> this.zzd) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.zza[i3] & UByte.MAX_VALUE) << min;
            min += 8;
            i3++;
        }
        zzc(i);
        return (-1 >>> (32 - i)) & i4;
    }

    public final void zzc(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.zzc + i3;
        this.zzc = i4;
        int i5 = this.zzd + (i - (i3 * 8));
        this.zzd = i5;
        if (i5 > 7) {
            i4++;
            this.zzc = i4;
            i5 -= 8;
            this.zzd = i5;
        }
        boolean z = false;
        if (i4 >= 0 && (i4 < (i2 = this.zzb) || (i4 == i2 && i5 == 0))) {
            z = true;
        }
        zzdd.zzf(z);
    }

    public final boolean zzd() {
        byte b = this.zza[this.zzc];
        int i = this.zzd;
        zzc(1);
        if (1 != (((b & UByte.MAX_VALUE) >> i) & 1)) {
            return false;
        }
        return true;
    }
}
