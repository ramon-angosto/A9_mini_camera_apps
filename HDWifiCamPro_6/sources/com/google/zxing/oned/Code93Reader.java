package com.google.zxing.oned;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.Map;
import ms.bd.o.Pgl.c;

public final class Code93Reader extends OneDReader {
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];
    static final int[] CHARACTER_ENCODINGS = {276, 328, 324, 322, 296, 292, c.COLLECT_MODE_ML_MINIMIZE, 336, 274, 266, 424, 420, 418, TTAdConstant.DEEPLINK_FALLBACK_CODE, TTAdConstant.AD_ID_IS_NULL_CODE, 394, 360, 356, 354, 308, 282, 344, 332, 326, c.COLLECT_MODE_FINANCE, 278, 436, 434, 428, 422, TTAdConstant.LANDING_PAGE_TYPE_CODE, TTAdConstant.IMAGE_LIST_SIZE_CODE, 364, 358, 310, 314, IronSourceConstants.OFFERWALL_AVAILABLE, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
    private final int[] counters = new int[6];
    private final StringBuilder decodeRowResult = new StringBuilder(20);

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] findAsteriskPattern = findAsteriskPattern(bitArray);
        int nextSet = bitArray.getNextSet(findAsteriskPattern[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern >= 0) {
                char patternToChar = patternToChar(pattern);
                sb.append(patternToChar);
                int i2 = nextSet;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int nextSet2 = bitArray.getNextSet(i2);
                if (patternToChar == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    if (nextSet2 == size || !bitArray.get(nextSet2)) {
                        throw NotFoundException.getNotFoundInstance();
                    } else if (sb.length() >= 2) {
                        checkChecksums(sb);
                        sb.setLength(sb.length() - 2);
                        float f = (float) i;
                        return new Result(decodeExtended(sb), (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (findAsteriskPattern[1] + findAsteriskPattern[0])) / 2.0f, f), new ResultPoint(((float) nextSet) + (((float) i4) / 2.0f), f)}, BarcodeFormat.CODE_93);
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

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else if (toPattern(iArr) == ASTERISK_ENCODING) {
                    return new int[]{i2, nextSet};
                } else {
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toPattern(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    private static char patternToChar(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i2 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            } else if (iArr[i2] == i) {
                return ALPHABET[i2];
            } else {
                i2++;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String decodeExtended(java.lang.CharSequence r9) throws com.google.zxing.FormatException {
        /*
            int r0 = r9.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        L_0x000b:
            if (r3 < r0) goto L_0x0012
            java.lang.String r9 = r1.toString()
            return r9
        L_0x0012:
            char r4 = r9.charAt(r3)
            r5 = 97
            if (r4 < r5) goto L_0x009d
            r5 = 100
            if (r4 > r5) goto L_0x009d
            int r5 = r0 + -1
            if (r3 >= r5) goto L_0x0098
            int r3 = r3 + 1
            char r5 = r9.charAt(r3)
            r6 = 79
            r7 = 90
            r8 = 65
            switch(r4) {
                case 97: goto L_0x0087;
                case 98: goto L_0x0051;
                case 99: goto L_0x0040;
                case 100: goto L_0x0034;
                default: goto L_0x0031;
            }
        L_0x0031:
            r4 = r2
            goto L_0x0094
        L_0x0034:
            if (r5 < r8) goto L_0x003b
            if (r5 > r7) goto L_0x003b
            int r5 = r5 + 32
            goto L_0x008d
        L_0x003b:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L_0x0040:
            if (r5 < r8) goto L_0x0047
            if (r5 > r6) goto L_0x0047
            int r5 = r5 + -32
            goto L_0x008d
        L_0x0047:
            if (r5 != r7) goto L_0x004c
            r4 = 58
            goto L_0x0094
        L_0x004c:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L_0x0051:
            if (r5 < r8) goto L_0x005a
            r4 = 69
            if (r5 > r4) goto L_0x005a
            int r5 = r5 + -38
            goto L_0x008d
        L_0x005a:
            r4 = 70
            if (r5 < r4) goto L_0x0065
            r4 = 74
            if (r5 > r4) goto L_0x0065
            int r5 = r5 + -11
            goto L_0x008d
        L_0x0065:
            r4 = 75
            if (r5 < r4) goto L_0x006e
            if (r5 > r6) goto L_0x006e
            int r5 = r5 + 16
            goto L_0x008d
        L_0x006e:
            r4 = 80
            if (r5 < r4) goto L_0x0079
            r4 = 83
            if (r5 > r4) goto L_0x0079
            int r5 = r5 + 43
            goto L_0x008d
        L_0x0079:
            r4 = 84
            if (r5 < r4) goto L_0x0082
            if (r5 > r7) goto L_0x0082
            r4 = 127(0x7f, float:1.78E-43)
            goto L_0x0094
        L_0x0082:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L_0x0087:
            if (r5 < r8) goto L_0x008f
            if (r5 > r7) goto L_0x008f
            int r5 = r5 + -64
        L_0x008d:
            char r4 = (char) r5
            goto L_0x0094
        L_0x008f:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L_0x0094:
            r1.append(r4)
            goto L_0x00a0
        L_0x0098:
            com.google.zxing.FormatException r9 = com.google.zxing.FormatException.getFormatInstance()
            throw r9
        L_0x009d:
            r1.append(r4)
        L_0x00a0:
            int r3 = r3 + 1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code93Reader.decodeExtended(java.lang.CharSequence):java.lang.String");
    }

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += ALPHABET_STRING.indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != ALPHABET[i3 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
