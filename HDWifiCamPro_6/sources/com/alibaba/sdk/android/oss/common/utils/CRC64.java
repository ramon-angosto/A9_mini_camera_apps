package com.alibaba.sdk.android.oss.common.utils;

import java.lang.reflect.Array;
import java.util.zip.Checksum;
import kotlin.UByte;

public class CRC64 implements Checksum {
    private static final int GF2_DIM = 64;
    private static final long POLY = -3932672073523589310L;
    private static final long[][] table = ((long[][]) Array.newInstance(long.class, new int[]{8, 256}));
    private long value = 0;

    static {
        for (int i = 0; i < 256; i++) {
            long j = (long) i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j & 1) == 1 ? (j >>> 1) ^ POLY : j >>> 1;
            }
            table[0][i] = j;
        }
        for (int i3 = 0; i3 < 256; i3++) {
            long j2 = table[0][i3];
            for (int i4 = 1; i4 < 8; i4++) {
                long[][] jArr = table;
                j2 = (j2 >>> 8) ^ jArr[0][(int) (255 & j2)];
                jArr[i4][i3] = j2;
            }
        }
    }

    private static long gf2MatrixTimes(long[] jArr, long j) {
        int i = 0;
        long j2 = 0;
        while (j != 0) {
            if ((j & 1) == 1) {
                j2 ^= jArr[i];
            }
            j >>>= 1;
            i++;
        }
        return j2;
    }

    private static void gf2MatrixSquare(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 64; i++) {
            jArr[i] = gf2MatrixTimes(jArr2, jArr2[i]);
        }
    }

    public static long combine(long j, long j2, long j3) {
        if (j3 == 0) {
            return j;
        }
        long[] jArr = new long[64];
        long[] jArr2 = new long[64];
        jArr2[0] = -3932672073523589310L;
        long j4 = 1;
        for (int i = 1; i < 64; i++) {
            jArr2[i] = j4;
            j4 <<= 1;
        }
        gf2MatrixSquare(jArr, jArr2);
        gf2MatrixSquare(jArr2, jArr);
        long j5 = j;
        long j6 = j3;
        do {
            gf2MatrixSquare(jArr, jArr2);
            if ((j6 & 1) == 1) {
                j5 = gf2MatrixTimes(jArr, j5);
            }
            long j7 = j6 >>> 1;
            if (j7 == 0) {
                break;
            }
            gf2MatrixSquare(jArr2, jArr);
            if ((j7 & 1) == 1) {
                j5 = gf2MatrixTimes(jArr2, j5);
            }
            j6 = j7 >>> 1;
        } while (j6 != 0);
        return j5 ^ j2;
    }

    public long getValue() {
        return this.value;
    }

    public void reset() {
        this.value = 0;
    }

    public void update(int i) {
        byte[] bArr = {(byte) (i & 255)};
        update(bArr, bArr.length);
    }

    public void update(byte[] bArr, int i) {
        update(bArr, 0, i);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.value = ~this.value;
        int i3 = i;
        int i4 = i2;
        while (i4 >= 8) {
            long[][] jArr = table;
            long[] jArr2 = jArr[7];
            long j = this.value;
            this.value = ((((((jArr[6][(int) (((long) (bArr[i3 + 1] & UByte.MAX_VALUE)) ^ ((j >>> 8) & 255))] ^ jArr2[(int) ((j & 255) ^ ((long) (bArr[i3] & UByte.MAX_VALUE)))]) ^ jArr[5][(int) (((j >>> 16) & 255) ^ ((long) (bArr[i3 + 2] & UByte.MAX_VALUE)))]) ^ jArr[4][(int) (((j >>> 24) & 255) ^ ((long) (bArr[i3 + 3] & UByte.MAX_VALUE)))]) ^ jArr[3][(int) (((j >>> 32) & 255) ^ ((long) (bArr[i3 + 4] & UByte.MAX_VALUE)))]) ^ jArr[2][(int) (((j >>> 40) & 255) ^ ((long) (bArr[i3 + 5] & UByte.MAX_VALUE)))]) ^ jArr[1][(int) ((255 & (j >>> 48)) ^ ((long) (bArr[i3 + 6] & UByte.MAX_VALUE)))]) ^ jArr[0][(int) ((j >>> 56) ^ ((long) (bArr[i3 + 7] & UByte.MAX_VALUE)))];
            i3 += 8;
            i4 -= 8;
        }
        while (i4 > 0) {
            long[] jArr3 = table[0];
            long j2 = this.value;
            this.value = (j2 >>> 8) ^ jArr3[(int) ((((long) bArr[i3]) ^ j2) & 255)];
            i3++;
            i4--;
        }
        this.value = ~this.value;
    }
}
