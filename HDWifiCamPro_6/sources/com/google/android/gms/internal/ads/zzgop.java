package com.google.android.gms.internal.ads;

import java.util.Arrays;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgop {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zzc(jArr4, jArr);
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zzb(long[] r18, long[] r19, long[] r20) {
        /*
            r0 = 0
            r1 = r19[r0]
            r3 = r20[r0]
            long r1 = r1 * r3
            r18[r0] = r1
            r1 = r19[r0]
            r3 = 1
            r4 = r20[r3]
            long r1 = r1 * r4
            r4 = r19[r3]
            r6 = r20[r0]
            long r4 = r4 * r6
            long r1 = r1 + r4
            r18[r3] = r1
            r1 = r19[r3]
            long r1 = r1 + r1
            r4 = r20[r3]
            long r1 = r1 * r4
            r4 = r19[r0]
            r6 = 2
            r7 = r20[r6]
            long r4 = r4 * r7
            long r1 = r1 + r4
            r4 = r19[r6]
            r7 = r20[r0]
            long r4 = r4 * r7
            long r1 = r1 + r4
            r18[r6] = r1
            r1 = r19[r3]
            r4 = r20[r6]
            long r1 = r1 * r4
            r4 = r19[r6]
            r7 = r20[r3]
            long r4 = r4 * r7
            long r1 = r1 + r4
            r4 = r19[r0]
            r7 = 3
            r8 = r20[r7]
            long r4 = r4 * r8
            long r1 = r1 + r4
            r4 = r19[r7]
            r8 = r20[r0]
            long r4 = r4 * r8
            long r1 = r1 + r4
            r18[r7] = r1
            r1 = r19[r6]
            r4 = r20[r6]
            r8 = r19[r3]
            r10 = r20[r7]
            long r8 = r8 * r10
            r10 = r19[r7]
            r12 = r20[r3]
            long r10 = r10 * r12
            long r8 = r8 + r10
            long r1 = r1 * r4
            long r8 = r8 + r8
            long r1 = r1 + r8
            r4 = r19[r0]
            r8 = 4
            r9 = r20[r8]
            long r4 = r4 * r9
            long r1 = r1 + r4
            r4 = r19[r8]
            r9 = r20[r0]
            long r4 = r4 * r9
            long r1 = r1 + r4
            r18[r8] = r1
            r1 = r19[r6]
            r4 = r20[r7]
            long r1 = r1 * r4
            r4 = r19[r7]
            r9 = r20[r6]
            long r4 = r4 * r9
            long r1 = r1 + r4
            r4 = r19[r3]
            r9 = r20[r8]
            long r4 = r4 * r9
            long r1 = r1 + r4
            r4 = r19[r8]
            r9 = r20[r3]
            long r4 = r4 * r9
            long r1 = r1 + r4
            r4 = r19[r0]
            r9 = 5
            r10 = r20[r9]
            long r4 = r4 * r10
            long r1 = r1 + r4
            r4 = r19[r9]
            r10 = r20[r0]
            long r4 = r4 * r10
            long r1 = r1 + r4
            r18[r9] = r1
            r1 = r19[r7]
            r4 = r20[r7]
            long r1 = r1 * r4
            r4 = r19[r3]
            r10 = r20[r9]
            long r4 = r4 * r10
            long r1 = r1 + r4
            r4 = r19[r9]
            r10 = r20[r3]
            long r4 = r4 * r10
            long r1 = r1 + r4
            long r1 = r1 + r1
            r4 = r19[r6]
            r10 = r20[r8]
            long r4 = r4 * r10
            long r1 = r1 + r4
            r4 = r19[r8]
            r10 = r20[r6]
            long r4 = r4 * r10
            long r1 = r1 + r4
            r4 = r19[r0]
            r10 = 6
            r11 = r20[r10]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r4 = r19[r10]
            r11 = r20[r0]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r18[r10] = r1
            r1 = r19[r7]
            r4 = r20[r8]
            long r1 = r1 * r4
            r4 = r19[r8]
            r11 = r20[r7]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r4 = r19[r6]
            r11 = r20[r9]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r4 = r19[r9]
            r11 = r20[r6]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r4 = r19[r3]
            r11 = r20[r10]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r4 = r19[r10]
            r11 = r20[r3]
            long r4 = r4 * r11
            long r1 = r1 + r4
            r4 = r19[r0]
            r11 = 7
            r12 = r20[r11]
            long r4 = r4 * r12
            long r1 = r1 + r4
            r4 = r19[r11]
            r12 = r20[r0]
            long r4 = r4 * r12
            long r1 = r1 + r4
            r18[r11] = r1
            r1 = r19[r8]
            r4 = r20[r8]
            r12 = r19[r7]
            r14 = r20[r9]
            long r12 = r12 * r14
            r14 = r19[r9]
            r16 = r20[r7]
            long r14 = r14 * r16
            long r12 = r12 + r14
            r14 = r19[r3]
            r16 = r20[r11]
            long r14 = r14 * r16
            long r12 = r12 + r14
            r14 = r19[r11]
            r16 = r20[r3]
            long r14 = r14 * r16
            long r12 = r12 + r14
            long r1 = r1 * r4
            long r12 = r12 + r12
            long r1 = r1 + r12
            r4 = r19[r6]
            r12 = r20[r10]
            long r4 = r4 * r12
            long r1 = r1 + r4
            r4 = r19[r10]
            r12 = r20[r6]
            long r4 = r4 * r12
            long r1 = r1 + r4
            r4 = r19[r0]
            r12 = 8
            r13 = r20[r12]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r12]
            r13 = r20[r0]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r18[r12] = r1
            r1 = r19[r8]
            r4 = r20[r9]
            long r1 = r1 * r4
            r4 = r19[r9]
            r13 = r20[r8]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r7]
            r13 = r20[r10]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r10]
            r13 = r20[r7]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r6]
            r13 = r20[r11]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r11]
            r13 = r20[r6]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r3]
            r13 = r20[r12]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r12]
            r13 = r20[r3]
            long r4 = r4 * r13
            long r1 = r1 + r4
            r4 = r19[r0]
            r13 = 9
            r14 = r20[r13]
            long r4 = r4 * r14
            long r1 = r1 + r4
            r4 = r19[r13]
            r14 = r20[r0]
            long r4 = r4 * r14
            long r1 = r1 + r4
            r18[r13] = r1
            r0 = r19[r9]
            r4 = r20[r9]
            long r0 = r0 * r4
            r4 = r19[r7]
            r14 = r20[r11]
            long r4 = r4 * r14
            long r0 = r0 + r4
            r4 = r19[r11]
            r14 = r20[r7]
            long r4 = r4 * r14
            long r0 = r0 + r4
            r4 = r19[r3]
            r14 = r20[r13]
            long r4 = r4 * r14
            long r0 = r0 + r4
            r4 = r19[r13]
            r2 = r20[r3]
            long r4 = r4 * r2
            long r0 = r0 + r4
            long r0 = r0 + r0
            r2 = r19[r8]
            r4 = r20[r10]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r10]
            r4 = r20[r8]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r6]
            r4 = r20[r12]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r12]
            r4 = r20[r6]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 10
            r18[r2] = r0
            r0 = r19[r9]
            r2 = r20[r10]
            long r0 = r0 * r2
            r2 = r19[r10]
            r4 = r20[r9]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r8]
            r4 = r20[r11]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r11]
            r4 = r20[r8]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r7]
            r4 = r20[r12]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r12]
            r4 = r20[r7]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r6]
            r4 = r20[r13]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r13]
            r4 = r20[r6]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 11
            r18[r2] = r0
            r0 = r19[r10]
            r2 = r20[r10]
            r4 = r19[r9]
            r14 = r20[r11]
            long r4 = r4 * r14
            r14 = r19[r11]
            r16 = r20[r9]
            long r14 = r14 * r16
            long r4 = r4 + r14
            r14 = r19[r7]
            r16 = r20[r13]
            long r14 = r14 * r16
            long r4 = r4 + r14
            r14 = r19[r13]
            r6 = r20[r7]
            long r14 = r14 * r6
            long r4 = r4 + r14
            long r0 = r0 * r2
            long r4 = r4 + r4
            long r0 = r0 + r4
            r2 = r19[r8]
            r4 = r20[r12]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r12]
            r4 = r20[r8]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 12
            r18[r2] = r0
            r0 = r19[r10]
            r2 = r20[r11]
            long r0 = r0 * r2
            r2 = r19[r11]
            r4 = r20[r10]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r9]
            r4 = r20[r12]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r12]
            r4 = r20[r9]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r8]
            r4 = r20[r13]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r13]
            r4 = r20[r8]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 13
            r18[r2] = r0
            r0 = r19[r11]
            r2 = r20[r11]
            long r0 = r0 * r2
            r2 = r19[r9]
            r4 = r20[r13]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r13]
            r4 = r20[r9]
            long r2 = r2 * r4
            long r0 = r0 + r2
            long r0 = r0 + r0
            r2 = r19[r10]
            r4 = r20[r12]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r12]
            r4 = r20[r10]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 14
            r18[r2] = r0
            r0 = r19[r11]
            r2 = r20[r12]
            long r0 = r0 * r2
            r2 = r19[r12]
            r4 = r20[r11]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r10]
            r4 = r20[r13]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = r19[r13]
            r4 = r20[r10]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 15
            r18[r2] = r0
            r0 = r19[r12]
            r2 = r20[r12]
            long r0 = r0 * r2
            r2 = r19[r11]
            r4 = r20[r13]
            long r2 = r2 * r4
            r4 = r19[r13]
            r6 = r20[r11]
            long r4 = r4 * r6
            long r2 = r2 + r4
            long r2 = r2 + r2
            long r0 = r0 + r2
            r2 = 16
            r18[r2] = r0
            r0 = r19[r12]
            r2 = r20[r13]
            long r0 = r0 * r2
            r2 = r19[r13]
            r4 = r20[r12]
            long r2 = r2 * r4
            long r0 = r0 + r2
            r2 = 17
            r18[r2] = r0
            r0 = r19[r13]
            long r0 = r0 + r0
            r2 = r20[r13]
            long r0 = r0 * r2
            r2 = 18
            r18[r2] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgop.zzb(long[], long[], long[]):void");
    }

    static void zzc(long[] jArr, long[] jArr2) {
        zze(jArr);
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr[i];
            long j2 = j / 67108864;
            jArr[i] = j - (j2 << 26);
            int i2 = i + 1;
            long j3 = jArr[i2] + j2;
            jArr[i2] = j3;
            long j4 = j3 / 33554432;
            jArr[i2] = j3 - (j4 << 25);
            i += 2;
            jArr[i] = jArr[i] + j4;
        }
        long j5 = jArr[0] + (jArr[10] << 4);
        jArr[0] = j5;
        long j6 = jArr[10];
        long j7 = j5 + j6 + j6;
        jArr[0] = j7;
        jArr[0] = j7 + jArr[10];
        jArr[10] = 0;
        long j8 = jArr[0];
        long j9 = j8 / 67108864;
        jArr[0] = j8 - (j9 << 26);
        jArr[1] = jArr[1] + j9;
    }

    static void zze(long[] jArr) {
        long j = jArr[8] + (jArr[18] << 4);
        jArr[8] = j;
        long j2 = jArr[18];
        long j3 = j + j2 + j2;
        jArr[8] = j3;
        jArr[8] = j3 + jArr[18];
        long j4 = jArr[7] + (jArr[17] << 4);
        jArr[7] = j4;
        long j5 = jArr[17];
        long j6 = j4 + j5 + j5;
        jArr[7] = j6;
        jArr[7] = j6 + jArr[17];
        long j7 = jArr[6] + (jArr[16] << 4);
        jArr[6] = j7;
        long j8 = jArr[16];
        long j9 = j7 + j8 + j8;
        jArr[6] = j9;
        jArr[6] = j9 + jArr[16];
        long j10 = jArr[5] + (jArr[15] << 4);
        jArr[5] = j10;
        long j11 = jArr[15];
        long j12 = j10 + j11 + j11;
        jArr[5] = j12;
        jArr[5] = j12 + jArr[15];
        long j13 = jArr[4] + (jArr[14] << 4);
        jArr[4] = j13;
        long j14 = jArr[14];
        long j15 = j13 + j14 + j14;
        jArr[4] = j15;
        jArr[4] = j15 + jArr[14];
        long j16 = jArr[3] + (jArr[13] << 4);
        jArr[3] = j16;
        long j17 = jArr[13];
        long j18 = j16 + j17 + j17;
        jArr[3] = j18;
        jArr[3] = j18 + jArr[13];
        long j19 = jArr[2] + (jArr[12] << 4);
        jArr[2] = j19;
        long j20 = jArr[12];
        long j21 = j19 + j20 + j20;
        jArr[2] = j21;
        jArr[2] = j21 + jArr[12];
        long j22 = jArr[1] + (jArr[11] << 4);
        jArr[1] = j22;
        long j23 = jArr[11];
        long j24 = j22 + j23 + j23;
        jArr[1] = j24;
        jArr[1] = j24 + jArr[11];
        long j25 = jArr[0] + (jArr[10] << 4);
        jArr[0] = j25;
        long j26 = jArr[10];
        long j27 = j25 + j26 + j26;
        jArr[0] = j27;
        jArr[0] = j27 + jArr[10];
    }

    static void zzf(long[] jArr, long[] jArr2, long j) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] * j;
        }
    }

    static void zzg(long[] jArr, long[] jArr2) {
        long j = jArr2[0];
        long j2 = jArr2[0];
        long j3 = jArr2[1];
        long j4 = (j3 * j3) + (jArr2[0] * jArr2[2]);
        long j5 = (jArr2[1] * jArr2[2]) + (jArr2[0] * jArr2[3]);
        long j6 = jArr2[2];
        long j7 = jArr2[1];
        long j8 = jArr2[3];
        long j9 = jArr2[0];
        long j10 = (jArr2[2] * jArr2[3]) + (jArr2[1] * jArr2[4]) + (jArr2[0] * jArr2[5]);
        long j11 = jArr2[3];
        long j12 = jArr2[2];
        long j13 = jArr2[4];
        long j14 = jArr2[0];
        long j15 = jArr2[6];
        long j16 = jArr2[1];
        long j17 = (j11 * j11) + (j12 * j13) + (j14 * j15) + ((j16 + j16) * jArr2[5]);
        long j18 = (jArr2[3] * jArr2[4]) + (jArr2[2] * jArr2[5]) + (jArr2[1] * jArr2[6]) + (jArr2[0] * jArr2[7]);
        long j19 = jArr2[4];
        long j20 = jArr2[2];
        long j21 = jArr2[6];
        long j22 = jArr2[0];
        long j23 = jArr2[8];
        long j24 = (jArr2[1] * jArr2[7]) + (jArr2[3] * jArr2[5]);
        long j25 = (j20 * j21) + (j22 * j23) + j24 + j24;
        long j26 = (jArr2[4] * jArr2[5]) + (jArr2[3] * jArr2[6]) + (jArr2[2] * jArr2[7]) + (jArr2[1] * jArr2[8]) + (jArr2[0] * jArr2[9]);
        long j27 = jArr2[5];
        long j28 = jArr2[4];
        long j29 = jArr2[6];
        long j30 = jArr2[2];
        long j31 = jArr2[8];
        long j32 = (jArr2[3] * jArr2[7]) + (jArr2[1] * jArr2[9]);
        long j33 = (j27 * j27) + (j28 * j29) + (j30 * j31) + j32 + j32;
        long j34 = (jArr2[5] * jArr2[6]) + (jArr2[4] * jArr2[7]) + (jArr2[3] * jArr2[8]) + (jArr2[2] * jArr2[9]);
        long j35 = jArr2[6];
        long j36 = jArr2[4];
        long j37 = jArr2[8];
        long j38 = (jArr2[5] * jArr2[7]) + (jArr2[3] * jArr2[9]);
        long j39 = (j36 * j37) + j38 + j38;
        long j40 = (jArr2[6] * jArr2[7]) + (jArr2[5] * jArr2[8]) + (jArr2[4] * jArr2[9]);
        long j41 = jArr2[7];
        long j42 = jArr2[6];
        long j43 = jArr2[8];
        long j44 = jArr2[5];
        long j45 = (j41 * j41) + (j42 * j43) + ((j44 + j44) * jArr2[9]);
        long j46 = (jArr2[7] * jArr2[8]) + (jArr2[6] * jArr2[9]);
        long j47 = jArr2[8];
        long j48 = jArr2[8];
        long j49 = jArr2[9];
        zzc(new long[]{j * j, (j2 + j2) * jArr2[1], j4 + j4, j5 + j5, (j6 * j6) + (j7 * 4 * j8) + ((j9 + j9) * jArr2[4]), j10 + j10, j17 + j17, j18 + j18, (j19 * j19) + j25 + j25, j26 + j26, j33 + j33, j34 + j34, (j35 * j35) + j39 + j39, j40 + j40, j45 + j45, j46 + j46, (j47 * j47) + (jArr2[7] * 4 * jArr2[9]), (j48 + j48) * jArr2[9], (j49 + j49) * j49}, jArr);
    }

    static void zzh(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    static void zzi(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }

    static byte[] zzj(long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, 10);
        for (int i = 0; i < 2; i++) {
            int i2 = 0;
            while (i2 < 9) {
                long j = copyOf[i2];
                int i3 = zzd[i2 & 1];
                int i4 = -((int) (((j >> 31) & j) >> i3));
                copyOf[i2] = j + ((long) (i4 << i3));
                i2++;
                copyOf[i2] = copyOf[i2] - ((long) i4);
            }
            long j2 = copyOf[9];
            int i5 = -((int) (((j2 >> 31) & j2) >> 25));
            copyOf[9] = j2 + ((long) (i5 << 25));
            copyOf[0] = copyOf[0] - ((long) (i5 * 19));
        }
        long j3 = copyOf[0];
        int i6 = -((int) (((j3 >> 31) & j3) >> 26));
        copyOf[0] = j3 + ((long) (i6 << 26));
        copyOf[1] = copyOf[1] - ((long) i6);
        for (int i7 = 0; i7 < 2; i7++) {
            int i8 = 0;
            while (i8 < 9) {
                long j4 = copyOf[i8];
                int i9 = i8 & 1;
                int i10 = zzd[i9];
                copyOf[i8] = ((long) zzc[i9]) & j4;
                i8++;
                copyOf[i8] = copyOf[i8] + ((long) ((int) (j4 >> i10)));
            }
        }
        long j5 = copyOf[9];
        copyOf[9] = 33554431 & j5;
        long j6 = copyOf[0] + ((long) (((int) (j5 >> 25)) * 19));
        copyOf[0] = j6;
        int i11 = ~((((int) j6) - 67108845) >> 31);
        for (int i12 = 1; i12 < 10; i12++) {
            int i13 = ~(((int) copyOf[i12]) ^ zzc[i12 & 1]);
            int i14 = i13 & (i13 << 16);
            int i15 = i14 & (i14 << 8);
            int i16 = i15 & (i15 << 4);
            int i17 = i16 & (i16 << 2);
            i11 &= (i17 & (i17 + i17)) >> 31;
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & i11));
        long j7 = (long) (33554431 & i11);
        copyOf[1] = copyOf[1] - j7;
        for (int i18 = 2; i18 < 10; i18 += 2) {
            copyOf[i18] = copyOf[i18] - ((long) (67108863 & i11));
            int i19 = i18 + 1;
            copyOf[i19] = copyOf[i19] - j7;
        }
        for (int i20 = 0; i20 < 10; i20++) {
            copyOf[i20] = copyOf[i20] << zzb[i20];
        }
        byte[] bArr = new byte[32];
        for (int i21 = 0; i21 < 10; i21++) {
            int[] iArr = zza;
            int i22 = iArr[i21];
            byte b = bArr[i22];
            long j8 = copyOf[i21];
            bArr[i22] = (byte) ((int) (((long) b) | (j8 & 255)));
            int i23 = iArr[i21] + 1;
            bArr[i23] = (byte) ((int) (((long) bArr[i23]) | ((j8 >> 8) & 255)));
            int i24 = iArr[i21] + 2;
            bArr[i24] = (byte) ((int) (((long) bArr[i24]) | ((j8 >> 16) & 255)));
            int i25 = iArr[i21] + 3;
            bArr[i25] = (byte) ((int) (((long) bArr[i25]) | ((j8 >> 24) & 255)));
        }
        return bArr;
    }

    static long[] zzk(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int i2 = zza[i];
            jArr[i] = ((((((long) (bArr[i2] & UByte.MAX_VALUE)) | (((long) (bArr[i2 + 1] & UByte.MAX_VALUE)) << 8)) | (((long) (bArr[i2 + 2] & UByte.MAX_VALUE)) << 16)) | (((long) (bArr[i2 + 3] & UByte.MAX_VALUE)) << 24)) >> zzb[i]) & ((long) zzc[i & 1]);
        }
        return jArr;
    }
}
