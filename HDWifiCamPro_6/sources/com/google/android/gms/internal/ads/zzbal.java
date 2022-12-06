package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbal {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd = 0;

    public zzbal(byte[] bArr, int i, int i2) {
        this.zza = bArr;
        this.zzc = i;
        this.zzb = i2;
        zzg();
    }

    private final int zzf() {
        int i = 0;
        int i2 = 0;
        while (!zze()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zza(i2);
        }
        return i3 + i;
    }

    private final void zzg() {
        int i;
        int i2;
        int i3 = this.zzc;
        boolean z = false;
        if (i3 >= 0 && (i = this.zzd) >= 0 && i < 8 && (i3 < (i2 = this.zzb) || (i3 == i2 && i == 0))) {
            z = true;
        }
        zzbac.zze(z);
    }

    private final boolean zzh(int i) {
        if (i < 2 || i >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i + -1] == 0;
    }

    public final int zza(int i) {
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4 = i >> 3;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            if (zzh(this.zzc + 1)) {
                i3 = this.zzc + 2;
            } else {
                i3 = this.zzc + 1;
            }
            int i6 = this.zzd;
            if (i6 != 0) {
                byte[] bArr = this.zza;
                b2 = ((bArr[i3] & UByte.MAX_VALUE) >>> (8 - i6)) | ((bArr[this.zzc] & UByte.MAX_VALUE) << i6);
            } else {
                b2 = this.zza[this.zzc];
            }
            i -= 8;
            b3 |= (b2 & UByte.MAX_VALUE) << i;
            this.zzc = i3;
        }
        if (i > 0) {
            int i7 = this.zzd + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (zzh(this.zzc + 1)) {
                i2 = this.zzc + 2;
            } else {
                i2 = this.zzc + 1;
            }
            if (i7 > 8) {
                byte[] bArr2 = this.zza;
                b = (b4 & (((255 & bArr2[i2]) >> (16 - i7)) | ((bArr2[this.zzc] & UByte.MAX_VALUE) << (i7 - 8)))) | b3;
                this.zzc = i2;
            } else {
                b = (b4 & ((255 & this.zza[this.zzc]) >> (8 - i7))) | b3;
                if (i7 == 8) {
                    this.zzc = i2;
                }
            }
            b3 = b;
            this.zzd = i7 % 8;
        }
        zzg();
        return b3;
    }

    public final int zzb() {
        int zzf = zzf();
        return (zzf % 2 == 0 ? -1 : 1) * ((zzf + 1) / 2);
    }

    public final int zzc() {
        return zzf();
    }

    public final void zzd(int i) {
        int i2 = this.zzc;
        int i3 = (i >> 3) + i2;
        this.zzc = i3;
        int i4 = this.zzd + (i & 7);
        this.zzd = i4;
        if (i4 > 7) {
            this.zzc = i3 + 1;
            this.zzd = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzc) {
                zzg();
                return;
            } else if (zzh(i2)) {
                this.zzc++;
                i2 += 2;
            }
        }
    }

    public final boolean zze() {
        return zza(1) == 1;
    }
}
