package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbaj {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzbaj() {
    }

    public zzbaj(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzd = i;
    }

    public final int zza(int i) {
        int i2;
        int i3;
        byte b;
        byte b2;
        int i4 = i >> 3;
        boolean z = false;
        int i5 = i;
        byte b3 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = this.zzc;
            if (i7 != 0) {
                byte[] bArr = this.zza;
                int i8 = this.zzb;
                b2 = ((bArr[i8 + 1] & UByte.MAX_VALUE) >>> (8 - i7)) | ((bArr[i8] & UByte.MAX_VALUE) << i7);
            } else {
                b2 = this.zza[this.zzb];
            }
            i5 -= 8;
            b3 |= (b2 & UByte.MAX_VALUE) << i5;
            this.zzb++;
        }
        if (i5 > 0) {
            int i9 = this.zzc + i5;
            byte b4 = (byte) (255 >> (8 - i5));
            if (i9 > 8) {
                byte[] bArr2 = this.zza;
                int i10 = this.zzb;
                int i11 = i10 + 1;
                b = (b4 & (((bArr2[i11] & UByte.MAX_VALUE) >> (16 - i9)) | ((bArr2[i10] & UByte.MAX_VALUE) << (i9 - 8)))) | b3;
                this.zzb = i11;
            } else {
                byte[] bArr3 = this.zza;
                int i12 = this.zzb;
                b = (b4 & ((bArr3[i12] & UByte.MAX_VALUE) >> (8 - i9))) | b3;
                if (i9 == 8) {
                    this.zzb = i12 + 1;
                }
            }
            b3 = b;
            this.zzc = i9 % 8;
        }
        int i13 = this.zzb;
        if (i13 >= 0 && (i2 = this.zzc) >= 0 && (i13 < (i3 = this.zzd) || (i13 == i3 && i2 == 0))) {
            z = true;
        }
        zzbac.zze(z);
        return b3;
    }
}
