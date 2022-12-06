package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;
import kotlin.UByte;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = height >> 3;
            if ((height & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i2, i4, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i2, i4, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i;
        int i6 = i2;
        int i7 = i4 - 8;
        int i8 = i3 - 8;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int cap = cap(i9, 2, i6 - 3);
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = i12 << 3;
                int i14 = i13 > i8 ? i8 : i13;
                int cap2 = cap(i12, 2, i5 - 3);
                int i15 = 0;
                for (int i16 = -2; i16 <= 2; i16++) {
                    int[] iArr2 = iArr[cap + i16];
                    i15 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i14, i11, i15 / 25, i3, bitMatrix);
            }
        }
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & UByte.MAX_VALUE) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i;
        int i7 = i2;
        int i8 = 8;
        int i9 = i4 - 8;
        int i10 = i3 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i7, i6});
        for (int i11 = 0; i11 < i7; i11++) {
            int i12 = i11 << 3;
            if (i12 > i9) {
                i12 = i9;
            }
            for (int i13 = 0; i13 < i6; i13++) {
                int i14 = i13 << 3;
                if (i14 > i10) {
                    i14 = i10;
                }
                int i15 = (i12 * i3) + i14;
                int i16 = 0;
                int i17 = 0;
                byte b = 0;
                byte b2 = UByte.MAX_VALUE;
                while (true) {
                    int i18 = 24;
                    if (i16 >= i8) {
                        break;
                    }
                    byte b3 = b;
                    int i19 = i17;
                    int i20 = 0;
                    while (i20 < i8) {
                        byte b4 = bArr[i15 + i20] & UByte.MAX_VALUE;
                        i19 += b4;
                        if (b4 < b2) {
                            b2 = b4;
                        }
                        if (b4 > b3) {
                            b3 = b4;
                        }
                        i20++;
                        i8 = 8;
                        i18 = 24;
                    }
                    if (b3 - b2 > i18) {
                        int i21 = i16 + 1;
                        i5 = i15 + i3;
                        while (i21 < i8) {
                            int i22 = 0;
                            while (i22 < i8) {
                                i19 += bArr[i5 + i22] & UByte.MAX_VALUE;
                                i22++;
                                i8 = 8;
                            }
                            i21++;
                            i5 += i3;
                        }
                        i16 = i21;
                    } else {
                        i5 = i15;
                    }
                    i16++;
                    i15 = i5 + i3;
                    i17 = i19;
                    i8 = 8;
                    b = b3;
                }
                int i23 = i17 >> 6;
                if (b - b2 <= 24) {
                    i23 = b2 / 2;
                    if (i11 > 0 && i13 > 0) {
                        int i24 = i11 - 1;
                        int i25 = i13 - 1;
                        int i26 = ((iArr[i24][i13] + (iArr[i11][i25] * 2)) + iArr[i24][i25]) / 4;
                        if (b2 < i26) {
                            i23 = i26;
                        }
                    }
                }
                iArr[i11][i13] = i23;
            }
        }
        return iArr;
    }
}
