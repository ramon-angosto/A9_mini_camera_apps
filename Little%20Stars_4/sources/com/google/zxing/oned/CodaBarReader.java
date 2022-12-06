package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class CodaBarReader extends OneDReader {
    static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCDTN";
    static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14, 26, 41};
    private static final char[] STARTEND_ENCODING = {'E', '*', 'A', 'B', 'C', 'D', 'T', 'N'};
    private static final int minCharacterLength = 6;

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i2;
        int[] findAsteriskPattern = findAsteriskPattern(bitArray);
        findAsteriskPattern[1] = 0;
        int nextSet = bitArray.getNextSet(findAsteriskPattern[1]);
        int size = bitArray.getSize();
        StringBuilder sb = new StringBuilder();
        int[] iArr = new int[7];
        while (true) {
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = 0;
            }
            recordPattern(bitArray, nextSet, iArr);
            char narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern != '!') {
                sb.append(narrowWidePattern);
                int i4 = nextSet;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int nextSet2 = bitArray.getNextSet(i4);
                if (nextSet2 >= size) {
                    int i6 = 0;
                    for (int i7 : iArr) {
                        i6 += i7;
                    }
                    int i8 = (nextSet2 - nextSet) - i6;
                    if (nextSet2 != size && i8 / 2 < i6) {
                        throw NotFoundException.getNotFoundInstance();
                    } else if (sb.length() >= 2) {
                        char charAt = sb.charAt(0);
                        if (arrayContains(STARTEND_ENCODING, charAt)) {
                            int i9 = 1;
                            while (true) {
                                if (i9 < sb.length()) {
                                    if (sb.charAt(i9) == charAt && (i2 = i9 + 1) != sb.length()) {
                                        sb.delete(i2, sb.length() - 1);
                                        break;
                                    }
                                    i9++;
                                } else {
                                    break;
                                }
                            }
                            if (sb.length() > 6) {
                                sb.deleteCharAt(sb.length() - 1);
                                sb.deleteCharAt(0);
                                float f = (float) i;
                                return new Result(sb.toString(), (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (findAsteriskPattern[1] + findAsteriskPattern[0])) / 2.0f, f), new ResultPoint(((float) (nextSet2 + nextSet)) / 2.0f, f)}, BarcodeFormat.CODABAR);
                            }
                            throw NotFoundException.getNotFoundInstance();
                        }
                        throw NotFoundException.getNotFoundInstance();
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    nextSet = nextSet2;
                }
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[7];
        int length = iArr.length;
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 == i3) {
                    try {
                        if (arrayContains(STARTEND_ENCODING, toNarrowWidePattern(iArr)) && bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                            return new int[]{i, nextSet};
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                    i += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static boolean arrayContains(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static char toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (iArr[i3] < i) {
                i = iArr[i3];
            }
            if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        do {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                if (iArr[i6] > i2) {
                    i5 |= 1 << ((length - 1) - i6);
                    i4++;
                }
            }
            if (i4 == 2 || i4 == 3) {
                int i7 = 0;
                while (true) {
                    int[] iArr2 = CHARACTER_ENCODINGS;
                    if (i7 >= iArr2.length) {
                        break;
                    } else if (iArr2[i7] == i5) {
                        return ALPHABET[i7];
                    } else {
                        i7++;
                    }
                }
            }
            i2--;
        } while (i2 > i);
        return '!';
    }
}
