package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int totalBitsInLayer(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private Encoder() {
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    public static AztecCode encode(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        BitArray bitArray;
        int i6;
        BitArray bitArray2;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i7 = 32;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            int abs = Math.abs(i2);
            if (z2) {
                i7 = 4;
            }
            if (abs <= i7) {
                int i8 = totalBitsInLayer(abs, z2);
                i5 = WORD_SIZE[abs];
                int i9 = i8 - (i8 % i5);
                bitArray = stuffBits(encode, i5);
                if (bitArray.getSize() + size > i9) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                } else if (!z2 || bitArray.getSize() <= i5 * 64) {
                    z = z2;
                    i3 = i8;
                    i4 = abs;
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
            }
        } else {
            BitArray bitArray3 = null;
            int i10 = 0;
            int i11 = 0;
            while (i10 <= 32) {
                z = i10 <= 3;
                i4 = z ? i10 + 1 : i10;
                i3 = totalBitsInLayer(i4, z);
                if (size2 <= i3) {
                    if (bitArray3 == null || i11 != WORD_SIZE[i4]) {
                        i5 = WORD_SIZE[i4];
                        bitArray2 = stuffBits(encode, i5);
                    } else {
                        int i12 = i11;
                        bitArray2 = bitArray3;
                        i5 = i12;
                    }
                    int i13 = i3 - (i3 % i5);
                    if ((!z || bitArray2.getSize() <= i5 * 64) && bitArray2.getSize() + size <= i13) {
                        bitArray = bitArray2;
                    } else {
                        BitArray bitArray4 = bitArray2;
                        i11 = i5;
                        bitArray3 = bitArray4;
                    }
                }
                i10++;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i3, i5);
        int size3 = bitArray.getSize() / i5;
        BitArray generateModeMessage = generateModeMessage(z, i4, size3);
        int i14 = (z ? 11 : 14) + (i4 * 4);
        int[] iArr = new int[i14];
        int i15 = 2;
        if (z) {
            for (int i16 = 0; i16 < iArr.length; i16++) {
                iArr[i16] = i16;
            }
            i6 = i14;
        } else {
            int i17 = i14 / 2;
            int i18 = i14 + 1 + (((i17 - 1) / 15) * 2);
            int i19 = i18 / 2;
            int i20 = 0;
            while (i20 < i17) {
                int i21 = (i20 / 15) + i20;
                iArr[(i17 - i20) - 1] = (i19 - i21) - 1;
                iArr[i17 + i20] = i19 + i21 + 1;
                i20++;
                i15 = 2;
            }
            i6 = i18;
        }
        BitMatrix bitMatrix = new BitMatrix(i6);
        int i22 = 0;
        for (int i23 = 0; i23 < i4; i23++) {
            int i24 = ((i4 - i23) * 4) + (z ? 9 : 12);
            for (int i25 = 0; i25 < i24; i25++) {
                int i26 = i25 * 2;
                int i27 = 0;
                while (i27 < i15) {
                    if (generateCheckWords.get(i22 + i26 + i27)) {
                        int i28 = i23 * 2;
                        bitMatrix.set(iArr[i28 + i27], iArr[i28 + i25]);
                    }
                    if (generateCheckWords.get(i22 + (i24 * 2) + i26 + i27)) {
                        int i29 = i23 * 2;
                        bitMatrix.set(iArr[i29 + i25], iArr[((i14 - 1) - i29) - i27]);
                    }
                    if (generateCheckWords.get(i22 + (i24 * 4) + i26 + i27)) {
                        int i30 = (i14 - 1) - (i23 * 2);
                        bitMatrix.set(iArr[i30 - i27], iArr[i30 - i25]);
                    }
                    if (generateCheckWords.get(i22 + (i24 * 6) + i26 + i27)) {
                        int i31 = i23 * 2;
                        bitMatrix.set(iArr[((i14 - 1) - i31) - i25], iArr[i31 + i27]);
                    }
                    i27++;
                    i15 = 2;
                }
            }
            i22 += i24 * 8;
        }
        drawModeMessage(bitMatrix, z, i6, generateModeMessage);
        if (z) {
            drawBullsEye(bitMatrix, i6 / 2, 5);
        } else {
            int i32 = i6 / 2;
            drawBullsEye(bitMatrix, i32, 7);
            int i33 = 0;
            int i34 = 0;
            while (i33 < (i14 / 2) - 1) {
                for (int i35 = i32 & 1; i35 < i6; i35 += 2) {
                    int i36 = i32 - i34;
                    bitMatrix.set(i36, i35);
                    int i37 = i32 + i34;
                    bitMatrix.set(i37, i35);
                    bitMatrix.set(i35, i36);
                    bitMatrix.set(i35, i37);
                }
                i33 += 15;
                i34 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z);
        aztecCode.setSize(i6);
        aztecCode.setLayers(i4);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 > i6) {
                    break;
                }
                bitMatrix.set(i5, i4);
                bitMatrix.set(i5, i6);
                bitMatrix.set(i4, i5);
                bitMatrix.set(i6, i5);
                i5++;
            }
        }
        int i7 = i - i2;
        bitMatrix.set(i7, i7);
        int i8 = i7 + 1;
        bitMatrix.set(i8, i7);
        bitMatrix.set(i7, i8);
        int i9 = i + i2;
        bitMatrix.set(i9, i7);
        bitMatrix.set(i9, i8);
        bitMatrix.set(i9, i9 - 1);
    }

    static BitArray generateModeMessage(boolean z, int i, int i2) {
        BitArray bitArray = new BitArray();
        if (z) {
            bitArray.appendBits(i - 1, 2);
            bitArray.appendBits(i2 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i - 1, 5);
        bitArray.appendBits(i2 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z, int i, BitArray bitArray) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (bitArray.get(i3)) {
                    bitMatrix.set(i4, i2 - 5);
                }
                if (bitArray.get(i3 + 7)) {
                    bitMatrix.set(i2 + 5, i4);
                }
                if (bitArray.get(20 - i3)) {
                    bitMatrix.set(i4, i2 + 5);
                }
                if (bitArray.get(27 - i3)) {
                    bitMatrix.set(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (bitArray.get(i3)) {
                bitMatrix.set(i5, i2 - 7);
            }
            if (bitArray.get(i3 + 10)) {
                bitMatrix.set(i2 + 7, i5);
            }
            if (bitArray.get(29 - i3)) {
                bitMatrix.set(i5, i2 + 7);
            }
            if (bitArray.get(39 - i3)) {
                bitMatrix.set(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i, int i2) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i2));
        int i3 = i / i2;
        int[] bitsToWords = bitsToWords(bitArray, i2, i3);
        reedSolomonEncoder.encode(bitsToWords, i3 - (bitArray.getSize() / i2));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i % i2);
        for (int appendBits : bitsToWords) {
            bitArray2.appendBits(appendBits, i2);
        }
        return bitArray2;
    }

    private static int[] bitsToWords(BitArray bitArray, int i, int i2) {
        int[] iArr = new int[i2];
        int size = bitArray.getSize() / i;
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= bitArray.get((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static GenericGF getGF(int i) {
        if (i == 4) {
            return GenericGF.AZTEC_PARAM;
        }
        if (i == 6) {
            return GenericGF.AZTEC_DATA_6;
        }
        if (i == 8) {
            return GenericGF.AZTEC_DATA_8;
        }
        if (i == 10) {
            return GenericGF.AZTEC_DATA_10;
        }
        if (i == 12) {
            return GenericGF.AZTEC_DATA_12;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    static BitArray stuffBits(BitArray bitArray, int i) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < size) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= size || bitArray.get(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                bitArray2.appendBits(i7, i);
            } else if (i7 == 0) {
                bitArray2.appendBits(i4 | 1, i);
            } else {
                bitArray2.appendBits(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return bitArray2;
    }
}
