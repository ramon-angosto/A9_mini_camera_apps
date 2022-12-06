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
    static final int[][] CODE_PATTERNS;
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final int MAX_AVG_VARIANCE = 64;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;

    static {
        int[][] iArr = new int[107][];
        iArr[0] = new int[]{2, 1, 2, 2, 2, 2};
        iArr[1] = new int[]{2, 2, 2, 1, 2, 2};
        iArr[2] = new int[]{2, 2, 2, 2, 2, 1};
        iArr[3] = new int[]{1, 2, 1, 2, 2, 3};
        iArr[4] = new int[]{1, 2, 1, 3, 2, 2};
        iArr[5] = new int[]{1, 3, 1, 2, 2, 2};
        iArr[6] = new int[]{1, 2, 2, 2, 1, 3};
        iArr[7] = new int[]{1, 2, 2, 3, 1, 2};
        iArr[8] = new int[]{1, 3, 2, 2, 1, 2};
        iArr[9] = new int[]{2, 2, 1, 2, 1, 3};
        iArr[10] = new int[]{2, 2, 1, 3, 1, 2};
        iArr[11] = new int[]{2, 3, 1, 2, 1, 2};
        iArr[12] = new int[]{1, 1, 2, 2, 3, 2};
        iArr[13] = new int[]{1, 2, 2, 1, 3, 2};
        iArr[14] = new int[]{1, 2, 2, 2, 3, 1};
        iArr[15] = new int[]{1, 1, 3, 2, 2, 2};
        iArr[16] = new int[]{1, 2, 3, 1, 2, 2};
        iArr[17] = new int[]{1, 2, 3, 2, 2, 1};
        iArr[18] = new int[]{2, 2, 3, 2, 1, 1};
        iArr[19] = new int[]{2, 2, 1, 1, 3, 2};
        iArr[20] = new int[]{2, 2, 1, 2, 3, 1};
        iArr[21] = new int[]{2, 1, 3, 2, 1, 2};
        iArr[22] = new int[]{2, 2, 3, 1, 1, 2};
        iArr[23] = new int[]{3, 1, 2, 1, 3, 1};
        iArr[24] = new int[]{3, 1, 1, 2, 2, 2};
        iArr[25] = new int[]{3, 2, 1, 1, 2, 2};
        iArr[26] = new int[]{3, 2, 1, 2, 2, 1};
        iArr[27] = new int[]{3, 1, 2, 2, 1, 2};
        iArr[28] = new int[]{3, 2, 2, 1, 1, 2};
        iArr[29] = new int[]{3, 2, 2, 2, 1, 1};
        iArr[30] = new int[]{2, 1, 2, 1, 2, 3};
        iArr[31] = new int[]{2, 1, 2, 3, 2, 1};
        iArr[32] = new int[]{2, 3, 2, 1, 2, 1};
        iArr[33] = new int[]{1, 1, 1, 3, 2, 3};
        iArr[34] = new int[]{1, 3, 1, 1, 2, 3};
        iArr[35] = new int[]{1, 3, 1, 3, 2, 1};
        iArr[36] = new int[]{1, 1, 2, 3, 1, 3};
        iArr[37] = new int[]{1, 3, 2, 1, 1, 3};
        iArr[38] = new int[]{1, 3, 2, 3, 1, 1};
        iArr[39] = new int[]{2, 1, 1, 3, 1, 3};
        iArr[40] = new int[]{2, 3, 1, 1, 1, 3};
        iArr[41] = new int[]{2, 3, 1, 3, 1, 1};
        iArr[42] = new int[]{1, 1, 2, 1, 3, 3};
        iArr[43] = new int[]{1, 1, 2, 3, 3, 1};
        iArr[44] = new int[]{1, 3, 2, 1, 3, 1};
        iArr[45] = new int[]{1, 1, 3, 1, 2, 3};
        iArr[46] = new int[]{1, 1, 3, 3, 2, 1};
        iArr[47] = new int[]{1, 3, 3, 1, 2, 1};
        iArr[48] = new int[]{3, 1, 3, 1, 2, 1};
        iArr[49] = new int[]{2, 1, 1, 3, 3, 1};
        iArr[50] = new int[]{2, 3, 1, 1, 3, 1};
        iArr[51] = new int[]{2, 1, 3, 1, 1, 3};
        iArr[52] = new int[]{2, 1, 3, 3, 1, 1};
        iArr[53] = new int[]{2, 1, 3, 1, 3, 1};
        iArr[54] = new int[]{3, 1, 1, 1, 2, 3};
        iArr[55] = new int[]{3, 1, 1, 3, 2, 1};
        iArr[56] = new int[]{3, 3, 1, 1, 2, 1};
        iArr[57] = new int[]{3, 1, 2, 1, 1, 3};
        iArr[58] = new int[]{3, 1, 2, 3, 1, 1};
        iArr[59] = new int[]{3, 3, 2, 1, 1, 1};
        iArr[60] = new int[]{3, 1, 4, 1, 1, 1};
        iArr[61] = new int[]{2, 2, 1, 4, 1, 1};
        iArr[62] = new int[]{4, 3, 1, 1, 1, 1};
        iArr[63] = new int[]{1, 1, 1, 2, 2, 4};
        iArr[64] = new int[]{1, 1, 1, 4, 2, 2};
        iArr[65] = new int[]{1, 2, 1, 1, 2, 4};
        iArr[66] = new int[]{1, 2, 1, 4, 2, 1};
        iArr[67] = new int[]{1, 4, 1, 1, 2, 2};
        iArr[68] = new int[]{1, 4, 1, 2, 2, 1};
        iArr[69] = new int[]{1, 1, 2, 2, 1, 4};
        iArr[70] = new int[]{1, 1, 2, 4, 1, 2};
        iArr[71] = new int[]{1, 2, 2, 1, 1, 4};
        iArr[72] = new int[]{1, 2, 2, 4, 1, 1};
        iArr[73] = new int[]{1, 4, 2, 1, 1, 2};
        iArr[74] = new int[]{1, 4, 2, 2, 1, 1};
        iArr[75] = new int[]{2, 4, 1, 2, 1, 1};
        iArr[76] = new int[]{2, 2, 1, 1, 1, 4};
        iArr[77] = new int[]{4, 1, 3, 1, 1, 1};
        iArr[78] = new int[]{2, 4, 1, 1, 1, 2};
        iArr[79] = new int[]{1, 3, 4, 1, 1, 1};
        iArr[80] = new int[]{1, 1, 1, 2, 4, 2};
        iArr[81] = new int[]{1, 2, 1, 1, 4, 2};
        iArr[82] = new int[]{1, 2, 1, 2, 4, 1};
        iArr[83] = new int[]{1, 1, 4, 2, 1, 2};
        iArr[84] = new int[]{1, 2, 4, 1, 1, 2};
        iArr[85] = new int[]{1, 2, 4, 2, 1, 1};
        iArr[86] = new int[]{4, 1, 1, 2, 1, 2};
        iArr[87] = new int[]{4, 2, 1, 1, 1, 2};
        iArr[88] = new int[]{4, 2, 1, 2, 1, 1};
        iArr[89] = new int[]{2, 1, 2, 1, 4, 1};
        iArr[90] = new int[]{2, 1, 4, 1, 2, 1};
        iArr[91] = new int[]{4, 1, 2, 1, 2, 1};
        iArr[92] = new int[]{1, 1, 1, 1, 4, 3};
        iArr[93] = new int[]{1, 1, 1, 3, 4, 1};
        iArr[94] = new int[]{1, 3, 1, 1, 4, 1};
        iArr[95] = new int[]{1, 1, 4, 1, 1, 3};
        iArr[CODE_FNC_3] = new int[]{1, 1, 4, 3, 1, 1};
        iArr[CODE_FNC_2] = new int[]{4, 1, 1, 1, 1, 3};
        iArr[CODE_SHIFT] = new int[]{4, 1, 1, 3, 1, 1};
        iArr[CODE_CODE_C] = new int[]{1, 1, 3, 1, 4, 1};
        iArr[100] = new int[]{1, 1, 4, 1, 3, 1};
        iArr[101] = new int[]{3, 1, 1, 1, 4, 1};
        iArr[CODE_FNC_1] = new int[]{4, 1, 1, 1, 3, 1};
        iArr[CODE_START_A] = new int[]{2, 1, 1, 4, 1, 2};
        iArr[CODE_START_B] = new int[]{2, 1, 1, 2, 1, 4};
        iArr[CODE_START_C] = new int[]{2, 1, 1, 2, 3, 2};
        iArr[CODE_STOP] = new int[]{2, 3, 3, 1, 1, 1, 2};
        CODE_PATTERNS = iArr;
    }

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
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
                    int i4 = 64;
                    int i5 = -1;
                    for (int i6 = CODE_START_A; i6 <= CODE_START_C; i6++) {
                        int patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i6], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < i4) {
                            i5 = i6;
                            i4 = patternMatchVariance;
                        }
                    }
                    if (i5 < 0 || !bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        int i7 = length - 2;
                        System.arraycopy(iArr, 2, iArr, 0, i7);
                        iArr[i7] = 0;
                        iArr[i3] = 0;
                        i2--;
                    } else {
                        return new int[]{i, nextSet, i5};
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
        int i2 = 64;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i4 >= iArr2.length) {
                break;
            }
            int patternMatchVariance = patternMatchVariance(iArr, iArr2[i4], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < i2) {
                i3 = i4;
                i2 = patternMatchVariance;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0095, code lost:
        r2 = false;
        r4 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c9, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ca, code lost:
        r4 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cd, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ce, code lost:
        r4 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d1, code lost:
        r2 = false;
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d4, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d5, code lost:
        if (r13 == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d7, code lost:
        if (r4 != 'e') goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d9, code lost:
        r4 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00dc, code lost:
        r4 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00de, code lost:
        r13 = r2;
        r12 = r15;
        r15 = r7;
        r7 = r11;
        r11 = r20;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r23, com.google.zxing.common.BitArray r24, java.util.Map<com.google.zxing.DecodeHintType, ?> r25) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            r22 = this;
            r0 = r24
            int[] r1 = findStartPattern(r24)
            r2 = 2
            r3 = r1[r2]
            r5 = 100
            r6 = 101(0x65, float:1.42E-43)
            switch(r3) {
                case 103: goto L_0x001b;
                case 104: goto L_0x0018;
                case 105: goto L_0x0015;
                default: goto L_0x0010;
            }
        L_0x0010:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0015:
            r7 = 99
            goto L_0x001d
        L_0x0018:
            r7 = 100
            goto L_0x001d
        L_0x001b:
            r7 = 101(0x65, float:1.42E-43)
        L_0x001d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r9 = 20
            r8.<init>(r9)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>(r9)
            r9 = 0
            r11 = r1[r9]
            r12 = 1
            r13 = r1[r12]
            r14 = 6
            int[] r14 = new int[r14]
            r16 = r3
            r4 = r7
            r7 = r11
            r11 = r13
            r3 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 1
        L_0x003f:
            if (r3 != 0) goto L_0x00e8
            int r7 = decodeCode(r0, r14, r11)
            byte r12 = (byte) r7
            java.lang.Byte r12 = java.lang.Byte.valueOf(r12)
            r10.add(r12)
            r12 = 106(0x6a, float:1.49E-43)
            if (r7 == r12) goto L_0x0053
            r18 = 1
        L_0x0053:
            if (r7 == r12) goto L_0x005b
            int r17 = r17 + 1
            int r19 = r17 * r7
            int r16 = r16 + r19
        L_0x005b:
            int r9 = r14.length
            r20 = r11
            r2 = 0
        L_0x005f:
            if (r2 >= r9) goto L_0x0068
            r21 = r14[r2]
            int r20 = r20 + r21
            int r2 = r2 + 1
            goto L_0x005f
        L_0x0068:
            switch(r7) {
                case 103: goto L_0x0072;
                case 104: goto L_0x0072;
                case 105: goto L_0x0072;
                default: goto L_0x006b;
            }
        L_0x006b:
            r2 = 96
            switch(r4) {
                case 99: goto L_0x00b0;
                case 100: goto L_0x009b;
                case 101: goto L_0x0077;
                default: goto L_0x0070;
            }
        L_0x0070:
            goto L_0x00d4
        L_0x0072:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0077:
            r9 = 64
            if (r7 >= r9) goto L_0x0082
            int r2 = r7 + 32
            char r2 = (char) r2
            r8.append(r2)
            goto L_0x00d4
        L_0x0082:
            if (r7 >= r2) goto L_0x008b
            int r2 = r7 + -64
            char r2 = (char) r2
            r8.append(r2)
            goto L_0x00d4
        L_0x008b:
            if (r7 == r12) goto L_0x008f
            r18 = 0
        L_0x008f:
            if (r7 == r12) goto L_0x00d1
            switch(r7) {
                case 96: goto L_0x00d4;
                case 97: goto L_0x00d4;
                case 98: goto L_0x0099;
                case 99: goto L_0x0095;
                case 100: goto L_0x00cd;
                case 101: goto L_0x00d4;
                case 102: goto L_0x00d4;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x00d4
        L_0x0095:
            r2 = 0
            r4 = 99
            goto L_0x00d5
        L_0x0099:
            r2 = 1
            goto L_0x00ce
        L_0x009b:
            if (r7 >= r2) goto L_0x00a4
            int r2 = r7 + 32
            char r2 = (char) r2
            r8.append(r2)
            goto L_0x00d4
        L_0x00a4:
            if (r7 == r12) goto L_0x00a8
            r18 = 0
        L_0x00a8:
            if (r7 == r12) goto L_0x00d1
            switch(r7) {
                case 96: goto L_0x00d4;
                case 97: goto L_0x00d4;
                case 98: goto L_0x00ae;
                case 99: goto L_0x0095;
                case 100: goto L_0x00d4;
                case 101: goto L_0x00c9;
                case 102: goto L_0x00d4;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            goto L_0x00d4
        L_0x00ae:
            r2 = 1
            goto L_0x00ca
        L_0x00b0:
            if (r7 >= r5) goto L_0x00bf
            r2 = 10
            if (r7 >= r2) goto L_0x00bb
            r2 = 48
            r8.append(r2)
        L_0x00bb:
            r8.append(r7)
            goto L_0x00d4
        L_0x00bf:
            if (r7 == r12) goto L_0x00c3
            r18 = 0
        L_0x00c3:
            if (r7 == r12) goto L_0x00d1
            switch(r7) {
                case 100: goto L_0x00cd;
                case 101: goto L_0x00c9;
                case 102: goto L_0x00c8;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x00d4
        L_0x00c9:
            r2 = 0
        L_0x00ca:
            r4 = 101(0x65, float:1.42E-43)
            goto L_0x00d5
        L_0x00cd:
            r2 = 0
        L_0x00ce:
            r4 = 100
            goto L_0x00d5
        L_0x00d1:
            r2 = 0
            r3 = 1
            goto L_0x00d5
        L_0x00d4:
            r2 = 0
        L_0x00d5:
            if (r13 == 0) goto L_0x00de
            if (r4 != r6) goto L_0x00dc
            r4 = 100
            goto L_0x00de
        L_0x00dc:
            r4 = 101(0x65, float:1.42E-43)
        L_0x00de:
            r13 = r2
            r12 = r15
            r2 = 2
            r9 = 0
            r15 = r7
            r7 = r11
            r11 = r20
            goto L_0x003f
        L_0x00e8:
            int r2 = r0.getNextUnset(r11)
            int r3 = r24.getSize()
            int r5 = r2 - r7
            r6 = 2
            int r5 = r5 / r6
            int r5 = r5 + r2
            int r3 = java.lang.Math.min(r3, r5)
            r5 = 0
            boolean r0 = r0.isRange(r2, r3, r5)
            if (r0 == 0) goto L_0x0173
            int r17 = r17 * r12
            int r16 = r16 - r17
            int r0 = r16 % 103
            if (r0 != r12) goto L_0x016e
            int r0 = r8.length()
            if (r0 == 0) goto L_0x0169
            if (r0 <= 0) goto L_0x0121
            if (r18 == 0) goto L_0x0121
            r3 = 99
            if (r4 != r3) goto L_0x011c
            int r3 = r0 + -2
            r8.delete(r3, r0)
            goto L_0x0121
        L_0x011c:
            int r3 = r0 + -1
            r8.delete(r3, r0)
        L_0x0121:
            r0 = 1
            r3 = r1[r0]
            r0 = 0
            r1 = r1[r0]
            int r3 = r3 + r1
            float r0 = (float) r3
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            int r2 = r2 + r7
            float r2 = (float) r2
            float r2 = r2 / r1
            int r1 = r10.size()
            byte[] r3 = new byte[r1]
            r4 = 0
        L_0x0136:
            if (r4 >= r1) goto L_0x0147
            java.lang.Object r5 = r10.get(r4)
            java.lang.Byte r5 = (java.lang.Byte) r5
            byte r5 = r5.byteValue()
            r3[r4] = r5
            int r4 = r4 + 1
            goto L_0x0136
        L_0x0147:
            com.google.zxing.Result r1 = new com.google.zxing.Result
            java.lang.String r4 = r8.toString()
            r5 = 2
            com.google.zxing.ResultPoint[] r5 = new com.google.zxing.ResultPoint[r5]
            com.google.zxing.ResultPoint r6 = new com.google.zxing.ResultPoint
            r7 = r23
            float r7 = (float) r7
            r6.<init>(r0, r7)
            r0 = 0
            r5[r0] = r6
            com.google.zxing.ResultPoint r0 = new com.google.zxing.ResultPoint
            r0.<init>(r2, r7)
            r2 = 1
            r5[r2] = r0
            com.google.zxing.BarcodeFormat r0 = com.google.zxing.BarcodeFormat.CODE_128
            r1.<init>(r4, r3, r5, r0)
            return r1
        L_0x0169:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x016e:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        L_0x0173:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            goto L_0x0179
        L_0x0178:
            throw r0
        L_0x0179:
            goto L_0x0178
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
