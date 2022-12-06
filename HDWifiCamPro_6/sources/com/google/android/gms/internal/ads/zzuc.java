package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzuc {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzuc(int i) {
        this(0, new Random());
    }

    public final int zza() {
        int[] iArr = this.zzb;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final int zzb() {
        int[] iArr = this.zzb;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int zzc() {
        return this.zzb.length;
    }

    public final int zzd(int i) {
        int i2 = this.zzc[i] + 1;
        int[] iArr = this.zzb;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public final int zze(int i) {
        int i2 = this.zzc[i] - 1;
        if (i2 >= 0) {
            return this.zzb[i2];
        }
        return -1;
    }

    public final zzuc zzf() {
        return new zzuc(0, new Random(this.zza.nextLong()));
    }

    public final zzuc zzg(int i, int i2) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            iArr[i4] = this.zza.nextInt(this.zzb.length + 1);
            int i5 = i4 + 1;
            int nextInt = this.zza.nextInt(i5);
            iArr2[i4] = iArr2[nextInt];
            iArr2[nextInt] = i4;
            i4 = i5;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[(this.zzb.length + i2)];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr4 = this.zzb;
            if (i3 >= iArr4.length + i2) {
                return new zzuc(iArr3, new Random(this.zza.nextLong()));
            }
            if (i6 >= i2 || i7 != iArr[i6]) {
                int i8 = i7 + 1;
                int i9 = iArr4[i7];
                iArr3[i3] = i9;
                if (i9 >= 0) {
                    iArr3[i3] = i9 + i2;
                }
                i7 = i8;
            } else {
                iArr3[i3] = iArr2[i6];
                i6++;
            }
            i3++;
        }
    }

    public final zzuc zzh(int i, int i2) {
        int[] iArr = new int[(this.zzb.length - i2)];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr2 = this.zzb;
            if (i3 >= iArr2.length) {
                return new zzuc(iArr, new Random(this.zza.nextLong()));
            }
            int i5 = iArr2[i3];
            if (i5 < 0 || i5 >= i2) {
                int i6 = i3 - i4;
                if (i5 >= 0) {
                    i5 -= i2;
                }
                iArr[i6] = i5;
            } else {
                i4++;
            }
            i3++;
        }
    }

    private zzuc(int i, Random random) {
        this(new int[0], random);
    }

    private zzuc(int[] iArr, Random random) {
        this.zzb = iArr;
        this.zza = random;
        this.zzc = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.zzc[iArr[i]] = i;
        }
    }
}
