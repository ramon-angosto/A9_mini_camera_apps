package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        if (luminanceSource.getWidth() < 40 || luminanceSource.getHeight() < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int width = luminanceSource.getWidth();
            int height = luminanceSource.getHeight();
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
        int i7 = i3;
        int i8 = i4;
        int i9 = 0;
        while (i9 < i6) {
            int i10 = i9 << 3;
            if (i10 + 8 >= i8) {
                i10 = i8 - 8;
            }
            int i11 = i10;
            int i12 = 0;
            while (i12 < i5) {
                int i13 = i12 << 3;
                if (i13 + 8 >= i7) {
                    i13 = i7 - 8;
                }
                int i14 = i13;
                int i15 = i12 > 1 ? i12 : 2;
                if (i15 >= i5 - 2) {
                    i15 = i5 - 3;
                }
                int i16 = i9 > 1 ? i9 : 2;
                if (i16 >= i6 - 2) {
                    i16 = i6 - 3;
                }
                int i17 = 0;
                for (int i18 = -2; i18 <= 2; i18++) {
                    int[] iArr2 = iArr[i16 + i18];
                    i17 += iArr2[i15 - 2] + iArr2[i15 - 1] + iArr2[i15] + iArr2[i15 + 1] + iArr2[i15 + 2];
                }
                threshold8x8Block(bArr, i14, i11, i17 / 25, i3, bitMatrix);
                i12++;
            }
            i9++;
        }
    }

    private static void threshold8x8Block(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i6, i5});
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            if (i10 + 8 >= i8) {
                i10 = i8 - 8;
            }
            for (int i11 = 0; i11 < i5; i11++) {
                int i12 = i11 << 3;
                if (i12 + 8 >= i7) {
                    i12 = i7 - 8;
                }
                int i13 = (i10 * i7) + i12;
                int i14 = 0;
                int i15 = 0;
                byte b = 0;
                byte b2 = 255;
                while (true) {
                    if (i14 >= 8) {
                        break;
                    }
                    byte b3 = b;
                    int i16 = i15;
                    int i17 = 0;
                    for (int i18 = 8; i17 < i18; i18 = 8) {
                        byte b4 = bArr[i13 + i17] & 255;
                        i16 += b4;
                        if (b4 < b2) {
                            b2 = b4;
                        }
                        if (b4 > b3) {
                            b3 = b4;
                        }
                        i17++;
                    }
                    i14++;
                    i13 += i7;
                    i15 = i16;
                    b = b3;
                }
                int i19 = i15 >> 6;
                if (b - b2 <= 24) {
                    i19 = b2 >> 1;
                    if (i9 > 0 && i11 > 0) {
                        int i20 = i9 - 1;
                        int i21 = i11 - 1;
                        int i22 = ((iArr[i20][i11] + (iArr[i9][i21] * 2)) + iArr[i20][i21]) >> 2;
                        if (b2 < i22) {
                            i19 = i22;
                        }
                    }
                }
                iArr[i9][i11] = i19;
            }
        }
        return iArr;
    }
}
