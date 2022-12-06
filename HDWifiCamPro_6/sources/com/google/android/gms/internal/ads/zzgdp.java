package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgdp {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        long zzb = zzb(bArr3, 0, 0);
        int i = 3;
        long zzb2 = zzb(bArr3, 3, 2) & 67108611;
        long zzb3 = zzb(bArr3, 6, 4) & 67092735;
        long zzb4 = zzb(bArr3, 9, 6) & 66076671;
        long zzb5 = zzb(bArr3, 12, 8) & 1048575;
        long j = zzb2 * 5;
        long j2 = zzb3 * 5;
        long j3 = zzb4 * 5;
        long j4 = zzb5 * 5;
        byte[] bArr5 = new byte[17];
        long j5 = 0;
        int i2 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        while (true) {
            int length = bArr4.length;
            if (i2 < length) {
                int min = Math.min(16, length - i2);
                System.arraycopy(bArr4, i2, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, 17, (byte) 0);
                }
                long zzb6 = j9 + zzb(bArr5, 0, 0);
                long zzb7 = j6 + zzb(bArr5, i, 2);
                long zzb8 = j5 + zzb(bArr5, 6, 4);
                long zzb9 = j7 + zzb(bArr5, 9, 6);
                long zzb10 = j8 + (zzb(bArr5, 12, 8) | ((long) (bArr5[16] << 24)));
                long j10 = (zzb6 * zzb) + (zzb7 * j4) + (zzb8 * j3) + (zzb9 * j2) + (zzb10 * j);
                long j11 = (zzb6 * zzb2) + (zzb7 * zzb) + (zzb8 * j4) + (zzb9 * j3) + (zzb10 * j2) + (j10 >> 26);
                long j12 = (zzb6 * zzb3) + (zzb7 * zzb2) + (zzb8 * zzb) + (zzb9 * j4) + (zzb10 * j3) + (j11 >> 26);
                long j13 = (zzb6 * zzb4) + (zzb7 * zzb3) + (zzb8 * zzb2) + (zzb9 * zzb) + (zzb10 * j4) + (j12 >> 26);
                long j14 = (zzb6 * zzb5) + (zzb7 * zzb4) + (zzb8 * zzb3) + (zzb9 * zzb2) + (zzb10 * zzb) + (j13 >> 26);
                j8 = j14 & 67108863;
                long j15 = (j10 & 67108863) + ((j14 >> 26) * 5);
                j9 = j15 & 67108863;
                j6 = (j11 & 67108863) + (j15 >> 26);
                i2 += 16;
                j7 = j13 & 67108863;
                j5 = j12 & 67108863;
                i = 3;
            } else {
                long j16 = j5 + (j6 >> 26);
                long j17 = j16 & 67108863;
                long j18 = j7 + (j16 >> 26);
                long j19 = j18 & 67108863;
                long j20 = j8 + (j18 >> 26);
                long j21 = j20 & 67108863;
                long j22 = j9 + ((j20 >> 26) * 5);
                long j23 = j22 & 67108863;
                long j24 = (j6 & 67108863) + (j22 >> 26);
                long j25 = j23 + 5;
                long j26 = (j25 >> 26) + j24;
                long j27 = (j26 >> 26) + j17;
                long j28 = j19 + (j27 >> 26);
                long j29 = (j21 + (j28 >> 26)) - 67108864;
                long j30 = j29 >> 63;
                long j31 = j21;
                long j32 = ~j30;
                long j33 = (j24 & j30) | (j26 & 67108863 & j32);
                long j34 = (j17 & j30) | (j27 & 67108863 & j32);
                long j35 = (j19 & j30) | (j28 & 67108863 & j32);
                long zzc = (((j23 & j30) | (j25 & 67108863 & j32) | (j33 << 26)) & 4294967295L) + zzc(bArr3, 16);
                long zzc2 = (((j33 >> 6) | (j34 << 20)) & 4294967295L) + zzc(bArr3, 20) + (zzc >> 32);
                long zzc3 = (((j34 >> 12) | (j35 << 14)) & 4294967295L) + zzc(bArr3, 24) + (zzc2 >> 32);
                long zzc4 = zzc(bArr3, 28);
                byte[] bArr6 = new byte[16];
                zzd(bArr6, zzc & 4294967295L, 0);
                zzd(bArr6, zzc2 & 4294967295L, 4);
                zzd(bArr6, zzc3 & 4294967295L, 8);
                zzd(bArr6, ((((((j31 & j30) | (j29 & j32)) << 8) | (j35 >> 18)) & 4294967295L) + zzc4 + (zzc3 >> 32)) & 4294967295L, 12);
                return bArr6;
            }
        }
    }

    private static long zzb(byte[] bArr, int i, int i2) {
        return (zzc(bArr, i) >> i2) & 67108863;
    }

    private static long zzc(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }
}
