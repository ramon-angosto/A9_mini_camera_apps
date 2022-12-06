package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzee {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzee() {
        this.zza = zzen.zzf;
    }

    public zzee(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzd = i;
    }

    private final void zzm() {
        int i;
        int i2 = this.zzb;
        boolean z = false;
        if (i2 >= 0 && (i2 < (i = this.zzd) || (i2 == i && this.zzc == 0))) {
            z = true;
        }
        zzdd.zzf(z);
    }

    public final int zza() {
        return ((this.zzd - this.zzb) * 8) - this.zzc;
    }

    public final int zzb() {
        return (this.zzb * 8) + this.zzc;
    }

    public final int zzc(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.zzc += i;
        int i3 = 0;
        while (true) {
            i2 = this.zzc;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.zzc = i4;
            byte[] bArr = this.zza;
            int i5 = this.zzb;
            this.zzb = i5 + 1;
            i3 |= (bArr[i5] & UByte.MAX_VALUE) << i4;
        }
        byte[] bArr2 = this.zza;
        int i6 = this.zzb;
        int i7 = (-1 >>> (32 - i)) & (i3 | ((bArr2[i6] & UByte.MAX_VALUE) >> (8 - i2)));
        if (i2 == 8) {
            this.zzc = 0;
            this.zzb = i6 + 1;
        }
        zzm();
        return i7;
    }

    public final void zzd() {
        if (this.zzc != 0) {
            this.zzc = 0;
            this.zzb++;
            zzm();
        }
    }

    public final void zze(int i, int i2) {
        int i3 = i & 16383;
        int min = Math.min(8 - this.zzc, 14);
        int i4 = this.zzc;
        int i5 = (8 - i4) - min;
        byte[] bArr = this.zza;
        int i6 = this.zzb;
        byte b = (byte) (((MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i4) | ((1 << i5) - 1)) & bArr[i6]);
        bArr[i6] = b;
        int i7 = 14 - min;
        bArr[i6] = (byte) (b | ((i3 >>> i7) << i5));
        int i8 = i6 + 1;
        while (i7 > 8) {
            i7 -= 8;
            this.zza[i8] = (byte) (i3 >>> i7);
            i8++;
        }
        int i9 = 8 - i7;
        byte[] bArr2 = this.zza;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i3 & ((1 << i7) - 1)) << i9) | b2);
        zzj(14);
        zzm();
    }

    public final void zzf(byte[] bArr, int i, int i2) {
        int i3 = i2 >> 3;
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.zza;
            int i5 = this.zzb;
            int i6 = i5 + 1;
            this.zzb = i6;
            byte b = bArr2[i5];
            int i7 = this.zzc;
            byte b2 = (byte) (b << i7);
            bArr[i4] = b2;
            bArr[i4] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | b2);
        }
        int i8 = i2 & 7;
        if (i8 != 0) {
            byte b3 = (byte) (bArr[i3] & (255 >> i8));
            bArr[i3] = b3;
            int i9 = this.zzc;
            if (i9 + i8 > 8) {
                byte[] bArr3 = this.zza;
                int i10 = this.zzb;
                this.zzb = i10 + 1;
                b3 = (byte) (b3 | ((bArr3[i10] & UByte.MAX_VALUE) << i9));
                bArr[i3] = b3;
                i9 -= 8;
            }
            int i11 = i9 + i8;
            this.zzc = i11;
            byte[] bArr4 = this.zza;
            int i12 = this.zzb;
            bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | b3);
            if (i11 == 8) {
                this.zzc = 0;
                this.zzb = i12 + 1;
            }
            zzm();
        }
    }

    public final void zzg(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = i;
    }

    public final void zzh(int i) {
        int i2 = i / 8;
        this.zzb = i2;
        this.zzc = i - (i2 * 8);
        zzm();
    }

    public final void zzi() {
        int i = this.zzc + 1;
        this.zzc = i;
        if (i == 8) {
            this.zzc = 0;
            this.zzb++;
        }
        zzm();
    }

    public final void zzj(int i) {
        int i2 = i / 8;
        int i3 = this.zzb + i2;
        this.zzb = i3;
        int i4 = this.zzc + (i - (i2 * 8));
        this.zzc = i4;
        if (i4 > 7) {
            this.zzb = i3 + 1;
            this.zzc = i4 - 8;
        }
        zzm();
    }

    public final void zzk(int i) {
        zzdd.zzf(this.zzc == 0);
        this.zzb += i;
        zzm();
    }

    public final boolean zzl() {
        boolean z = (this.zza[this.zzb] & (128 >> this.zzc)) != 0;
        zzi();
        return z;
    }
}
