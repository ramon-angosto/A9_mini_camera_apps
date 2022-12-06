package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == length - 1) {
                    float f = MAX_AVG_VARIANCE;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < f) {
                            i3 = i4;
                            f = patternMatchVariance;
                        }
                    }
                    if (i3 < 0 || !bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        int i5 = i2 - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i5);
                        iArr[i5] = 0;
                        iArr[i2] = 0;
                        i2--;
                    } else {
                        return new int[]{i, nextSet, i3};
                    }
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

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01e5, code lost:
        r19 = r5;
        r20 = r9;
        r0 = false;
        r2 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0226, code lost:
        r19 = r5;
        r20 = r9;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022b, code lost:
        r2 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x022e, code lost:
        r19 = r5;
        r20 = r9;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0233, code lost:
        r2 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x023d, code lost:
        r19 = r5;
        r20 = r9;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0242, code lost:
        if (r8 == false) goto L_0x024d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0246, code lost:
        if (r2 != 'e') goto L_0x024b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0248, code lost:
        r2 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x024b, code lost:
        r2 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x024d, code lost:
        r8 = r0;
        r10 = r12;
        r11 = r14;
        r14 = r22;
        r5 = 2;
        r9 = 'c';
        r0 = r26;
        r12 = r3;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017a, code lost:
        if (r5 != false) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0184, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a0, code lost:
        r20 = r9;
        r0 = false;
        r19 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01cc, code lost:
        r0 = false;
        r19 = false;
        r20 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01d5, code lost:
        if (r5 != false) goto L_0x01d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01d7, code lost:
        r0 = false;
        r19 = false;
        r20 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01de, code lost:
        r20 = r9;
        r0 = false;
        r19 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r25, com.google.zxing.common.BitArray r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            r24 = this;
            r0 = r26
            r1 = r27
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.zxing.DecodeHintType r4 = com.google.zxing.DecodeHintType.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            int[] r4 = findStartPattern(r26)
            r5 = 2
            r6 = r4[r5]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r6
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            r9 = 99
            switch(r6) {
                case 103: goto L_0x0039;
                case 104: goto L_0x0036;
                case 105: goto L_0x0033;
                default: goto L_0x002e;
            }
        L_0x002e:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0033:
            r12 = 99
            goto L_0x003b
        L_0x0036:
            r12 = 100
            goto L_0x003b
        L_0x0039:
            r12 = 101(0x65, float:1.42E-43)
        L_0x003b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            r8 = r4[r3]
            r14 = r4[r2]
            r15 = 6
            int[] r15 = new int[r15]
            r16 = r6
            r11 = r8
            r2 = r12
            r6 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            r20 = 0
        L_0x0057:
            if (r6 == 0) goto L_0x00e8
            int r1 = r14 - r11
            int r6 = r0.getNextUnset(r14)
            int r8 = r26.getSize()
            int r12 = r6 - r11
            int r12 = r12 / r5
            int r12 = r12 + r6
            int r8 = java.lang.Math.min(r8, r12)
            boolean r0 = r0.isRange(r6, r8, r3)
            if (r0 == 0) goto L_0x00e3
            int r17 = r17 * r10
            int r16 = r16 - r17
            int r0 = r16 % 103
            if (r0 != r10) goto L_0x00de
            int r0 = r13.length()
            if (r0 == 0) goto L_0x00d9
            if (r0 <= 0) goto L_0x0090
            if (r18 == 0) goto L_0x0090
            if (r2 != r9) goto L_0x008b
            int r2 = r0 + -2
            r13.delete(r2, r0)
            goto L_0x0090
        L_0x008b:
            int r2 = r0 + -1
            r13.delete(r2, r0)
        L_0x0090:
            r0 = 1
            r2 = r4[r0]
            r0 = r4[r3]
            int r2 = r2 + r0
            float r0 = (float) r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r4 = (float) r11
            float r1 = (float) r1
            float r1 = r1 / r2
            float r4 = r4 + r1
            int r1 = r7.size()
            byte[] r2 = new byte[r1]
            r6 = 0
        L_0x00a5:
            if (r6 < r1) goto L_0x00c7
            com.google.zxing.Result r1 = new com.google.zxing.Result
            java.lang.String r6 = r13.toString()
            com.google.zxing.ResultPoint[] r5 = new com.google.zxing.ResultPoint[r5]
            com.google.zxing.ResultPoint r7 = new com.google.zxing.ResultPoint
            r10 = r25
            float r8 = (float) r10
            r7.<init>(r0, r8)
            r5[r3] = r7
            com.google.zxing.ResultPoint r0 = new com.google.zxing.ResultPoint
            r0.<init>(r4, r8)
            r11 = 1
            r5[r11] = r0
            com.google.zxing.BarcodeFormat r0 = com.google.zxing.BarcodeFormat.CODE_128
            r1.<init>(r6, r2, r5, r0)
            return r1
        L_0x00c7:
            r10 = r25
            r11 = 1
            java.lang.Object r8 = r7.get(r6)
            java.lang.Byte r8 = (java.lang.Byte) r8
            byte r8 = r8.byteValue()
            r2[r6] = r8
            int r6 = r6 + 1
            goto L_0x00a5
        L_0x00d9:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x00de:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        L_0x00e3:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x00e8:
            r10 = r25
            r11 = 1
            int r3 = decodeCode(r0, r15, r14)
            byte r5 = (byte) r3
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)
            r7.add(r5)
            r5 = 106(0x6a, float:1.49E-43)
            if (r3 == r5) goto L_0x00fd
            r18 = 1
        L_0x00fd:
            if (r3 == r5) goto L_0x0105
            int r17 = r17 + 1
            int r21 = r17 * r3
            int r16 = r16 + r21
        L_0x0105:
            int r9 = r15.length
            r22 = r14
            r11 = 0
        L_0x0109:
            if (r11 < r9) goto L_0x025b
            switch(r3) {
                case 103: goto L_0x0119;
                case 104: goto L_0x0119;
                case 105: goto L_0x0119;
                default: goto L_0x010e;
            }
        L_0x010e:
            java.lang.String r11 = "]C1"
            switch(r2) {
                case 99: goto L_0x01f3;
                case 100: goto L_0x0187;
                case 101: goto L_0x011e;
                default: goto L_0x0113;
            }
        L_0x0113:
            r5 = r19
            r9 = r20
            goto L_0x023d
        L_0x0119:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x011e:
            r5 = 64
            if (r3 >= r5) goto L_0x013a
            r5 = r19
            r9 = r20
            if (r5 != r9) goto L_0x0130
            int r5 = r3 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x01a0
        L_0x0130:
            int r5 = r3 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x01a0
        L_0x013a:
            r5 = r19
            r9 = r20
            r0 = 96
            if (r3 >= r0) goto L_0x0152
            if (r5 != r9) goto L_0x014b
            int r0 = r3 + -64
            char r0 = (char) r0
            r13.append(r0)
            goto L_0x01a0
        L_0x014b:
            int r0 = r3 + 64
            char r0 = (char) r0
            r13.append(r0)
            goto L_0x01a0
        L_0x0152:
            r0 = 106(0x6a, float:1.49E-43)
            if (r3 == r0) goto L_0x0158
            r18 = 0
        L_0x0158:
            if (r3 == r0) goto L_0x0184
            switch(r3) {
                case 96: goto L_0x023d;
                case 97: goto L_0x023d;
                case 98: goto L_0x017d;
                case 99: goto L_0x01e5;
                case 100: goto L_0x022e;
                case 101: goto L_0x0173;
                case 102: goto L_0x015f;
                default: goto L_0x015d;
            }
        L_0x015d:
            goto L_0x023d
        L_0x015f:
            if (r1 == 0) goto L_0x023d
            int r0 = r13.length()
            if (r0 != 0) goto L_0x016c
            r13.append(r11)
            goto L_0x023d
        L_0x016c:
            r0 = 29
            r13.append(r0)
            goto L_0x023d
        L_0x0173:
            if (r9 != 0) goto L_0x0178
            if (r5 == 0) goto L_0x0178
            goto L_0x01cc
        L_0x0178:
            if (r9 == 0) goto L_0x01de
            if (r5 == 0) goto L_0x01de
            goto L_0x01d7
        L_0x017d:
            r19 = r5
            r20 = r9
            r0 = 1
            goto L_0x0233
        L_0x0184:
            r6 = 1
            goto L_0x023d
        L_0x0187:
            r5 = r19
            r9 = r20
            r0 = 96
            if (r3 >= r0) goto L_0x01a7
            if (r5 != r9) goto L_0x0198
            int r0 = r3 + 32
            char r0 = (char) r0
            r13.append(r0)
            goto L_0x01a0
        L_0x0198:
            int r0 = r3 + 32
            int r0 = r0 + 128
            char r0 = (char) r0
            r13.append(r0)
        L_0x01a0:
            r20 = r9
            r0 = 0
            r19 = 0
            goto L_0x0242
        L_0x01a7:
            r0 = 106(0x6a, float:1.49E-43)
            if (r3 == r0) goto L_0x01ad
            r18 = 0
        L_0x01ad:
            if (r3 == r0) goto L_0x0184
            switch(r3) {
                case 96: goto L_0x023d;
                case 97: goto L_0x023d;
                case 98: goto L_0x01ed;
                case 99: goto L_0x01e5;
                case 100: goto L_0x01c8;
                case 101: goto L_0x0226;
                case 102: goto L_0x01b4;
                default: goto L_0x01b2;
            }
        L_0x01b2:
            goto L_0x023d
        L_0x01b4:
            if (r1 == 0) goto L_0x023d
            int r0 = r13.length()
            if (r0 != 0) goto L_0x01c1
            r13.append(r11)
            goto L_0x023d
        L_0x01c1:
            r0 = 29
            r13.append(r0)
            goto L_0x023d
        L_0x01c8:
            if (r9 != 0) goto L_0x01d3
            if (r5 == 0) goto L_0x01d3
        L_0x01cc:
            r0 = 0
            r19 = 0
            r20 = 1
            goto L_0x0242
        L_0x01d3:
            if (r9 == 0) goto L_0x01de
            if (r5 == 0) goto L_0x01de
        L_0x01d7:
            r0 = 0
            r19 = 0
            r20 = 0
            goto L_0x0242
        L_0x01de:
            r20 = r9
            r0 = 0
            r19 = 1
            goto L_0x0242
        L_0x01e5:
            r19 = r5
            r20 = r9
            r0 = 0
            r2 = 99
            goto L_0x0242
        L_0x01ed:
            r19 = r5
            r20 = r9
            r0 = 1
            goto L_0x022b
        L_0x01f3:
            r5 = r19
            r9 = r20
            r0 = 100
            if (r3 >= r0) goto L_0x0208
            r11 = 10
            if (r3 >= r11) goto L_0x0204
            r11 = 48
            r13.append(r11)
        L_0x0204:
            r13.append(r3)
            goto L_0x023d
        L_0x0208:
            r0 = 106(0x6a, float:1.49E-43)
            if (r3 == r0) goto L_0x020e
            r18 = 0
        L_0x020e:
            if (r3 == r0) goto L_0x0236
            switch(r3) {
                case 100: goto L_0x022e;
                case 101: goto L_0x0226;
                case 102: goto L_0x0214;
                default: goto L_0x0213;
            }
        L_0x0213:
            goto L_0x023d
        L_0x0214:
            if (r1 == 0) goto L_0x023d
            int r0 = r13.length()
            if (r0 != 0) goto L_0x0220
            r13.append(r11)
            goto L_0x023d
        L_0x0220:
            r0 = 29
            r13.append(r0)
            goto L_0x023d
        L_0x0226:
            r19 = r5
            r20 = r9
            r0 = 0
        L_0x022b:
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x0242
        L_0x022e:
            r19 = r5
            r20 = r9
            r0 = 0
        L_0x0233:
            r2 = 100
            goto L_0x0242
        L_0x0236:
            r19 = r5
            r20 = r9
            r0 = 0
            r6 = 1
            goto L_0x0242
        L_0x023d:
            r19 = r5
            r20 = r9
            r0 = 0
        L_0x0242:
            if (r8 == 0) goto L_0x024d
            r5 = 101(0x65, float:1.42E-43)
            if (r2 != r5) goto L_0x024b
            r2 = 100
            goto L_0x024d
        L_0x024b:
            r2 = 101(0x65, float:1.42E-43)
        L_0x024d:
            r8 = r0
            r10 = r12
            r11 = r14
            r14 = r22
            r5 = 2
            r9 = 99
            r0 = r26
            r12 = r3
            r3 = 0
            goto L_0x0057
        L_0x025b:
            r5 = r19
            r0 = 106(0x6a, float:1.49E-43)
            r19 = r9
            r9 = r20
            r20 = 101(0x65, float:1.42E-43)
            r23 = r15[r11]
            int r22 = r22 + r23
            int r11 = r11 + 1
            r0 = r26
            r20 = r9
            r9 = r19
            r19 = r5
            r5 = 106(0x6a, float:1.49E-43)
            goto L_0x0109
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
