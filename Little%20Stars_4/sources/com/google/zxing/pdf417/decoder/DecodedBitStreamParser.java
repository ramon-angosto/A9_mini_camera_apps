package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import java.math.BigInteger;
import java.util.List;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final BigInteger[] EXP900 = new BigInteger[16];
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', 13, 9, ',', ':', '#', '-', '.', '$', '/', '+', '%', '*', '=', '^'};
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = {';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', '!', 13, 9, ',', ':', 10, '-', '.', '$', '/', '\"', '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        EXP900[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr = EXP900;
            if (i < bigIntegerArr.length) {
                bigIntegerArr[i] = bigIntegerArr[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr) throws FormatException {
        int i;
        StringBuilder sb = new StringBuilder(100);
        int i2 = iArr[1];
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                i = byteCompaction(i2, iArr, i3, sb);
            } else if (i2 != BYTE_COMPACTION_MODE_LATCH_6) {
                switch (i2) {
                    case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        i = textCompaction(iArr, i3, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        i = byteCompaction(i2, iArr, i3, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                        i = numericCompaction(iArr, i3, sb);
                        break;
                    default:
                        i = textCompaction(iArr, i3 - 1, sb);
                        break;
                }
            } else {
                i = byteCompaction(i2, iArr, i3, sb);
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        return new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, (String) null);
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] << 1)];
        int[] iArr3 = new int[(iArr[0] << 1)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != BYTE_COMPACTION_MODE_LATCH_6) {
                    switch (i4) {
                        case TEXT_COMPACTION_MODE_LATCH /*900*/:
                        case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                            break;
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
        r6 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0098, code lost:
        r6 = 0;
        r14 = r5;
        r5 = r4;
        r4 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b4, code lost:
        r6 = (char) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b8, code lost:
        r6 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d3, code lost:
        if (r6 == 0) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00d5, code lost:
        r0.append(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00d8, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r15, int[] r16, int r17, java.lang.StringBuilder r18) {
        /*
            r0 = r18
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r3 = 0
            r4 = r1
            r5 = r2
            r2 = 0
            r1 = r17
        L_0x000c:
            if (r2 >= r1) goto L_0x00dc
            r6 = r15[r2]
            int[] r7 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode
            int r8 = r4.ordinal()
            r7 = r7[r8]
            r8 = 28
            r9 = 27
            r10 = 913(0x391, float:1.28E-42)
            r11 = 32
            r12 = 29
            r13 = 26
            switch(r7) {
                case 1: goto L_0x00b0;
                case 2: goto L_0x008c;
                case 3: goto L_0x005f;
                case 4: goto L_0x0047;
                case 5: goto L_0x0036;
                case 6: goto L_0x0029;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x00d2
        L_0x0029:
            if (r6 >= r12) goto L_0x0030
            char[] r4 = PUNCT_CHARS
            char r4 = r4[r6]
            goto L_0x003b
        L_0x0030:
            if (r6 != r12) goto L_0x0044
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d2
        L_0x0036:
            if (r6 >= r13) goto L_0x003f
            int r6 = r6 + 65
            char r4 = (char) r6
        L_0x003b:
            r6 = r4
            r4 = r5
            goto L_0x00d3
        L_0x003f:
            if (r6 != r13) goto L_0x0044
            r4 = r5
            goto L_0x00b8
        L_0x0044:
            r4 = r5
            goto L_0x00d2
        L_0x0047:
            if (r6 >= r12) goto L_0x004f
            char[] r7 = PUNCT_CHARS
            char r6 = r7[r6]
            goto L_0x00d3
        L_0x004f:
            if (r6 != r12) goto L_0x0055
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d2
        L_0x0055:
            if (r6 != r10) goto L_0x00d2
            r6 = r16[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00d2
        L_0x005f:
            r7 = 25
            if (r6 >= r7) goto L_0x0069
            char[] r7 = MIXED_CHARS
            char r6 = r7[r6]
            goto L_0x00d3
        L_0x0069:
            if (r6 != r7) goto L_0x006f
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x00d2
        L_0x006f:
            if (r6 != r13) goto L_0x0072
            goto L_0x00b8
        L_0x0072:
            if (r6 != r9) goto L_0x0078
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00d2
        L_0x0078:
            if (r6 != r8) goto L_0x007e
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x00d2
        L_0x007e:
            if (r6 != r12) goto L_0x0083
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x0098
        L_0x0083:
            if (r6 != r10) goto L_0x00d2
            r6 = r16[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00d2
        L_0x008c:
            if (r6 >= r13) goto L_0x0091
            int r6 = r6 + 97
            goto L_0x00b4
        L_0x0091:
            if (r6 != r13) goto L_0x0094
            goto L_0x00b8
        L_0x0094:
            if (r6 != r9) goto L_0x009d
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
        L_0x0098:
            r6 = 0
            r14 = r5
            r5 = r4
            r4 = r14
            goto L_0x00d3
        L_0x009d:
            if (r6 != r8) goto L_0x00a2
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00d2
        L_0x00a2:
            if (r6 != r12) goto L_0x00a7
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x0098
        L_0x00a7:
            if (r6 != r10) goto L_0x00d2
            r6 = r16[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x00d2
        L_0x00b0:
            if (r6 >= r13) goto L_0x00b6
            int r6 = r6 + 65
        L_0x00b4:
            char r6 = (char) r6
            goto L_0x00d3
        L_0x00b6:
            if (r6 != r13) goto L_0x00bb
        L_0x00b8:
            r6 = 32
            goto L_0x00d3
        L_0x00bb:
            if (r6 != r9) goto L_0x00c0
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x00d2
        L_0x00c0:
            if (r6 != r8) goto L_0x00c5
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x00d2
        L_0x00c5:
            if (r6 != r12) goto L_0x00ca
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x0098
        L_0x00ca:
            if (r6 != r10) goto L_0x00d2
            r6 = r16[r2]
            char r6 = (char) r6
            r0.append(r6)
        L_0x00d2:
            r6 = 0
        L_0x00d3:
            if (r6 == 0) goto L_0x00d8
            r0.append(r6)
        L_0x00d8:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0057 A[LOOP:1: B:22:0x0055->B:23:0x0057, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int byteCompaction(int r23, int[] r24, int r25, java.lang.StringBuilder r26) {
        /*
            r0 = r23
            r1 = r26
            r2 = 922(0x39a, float:1.292E-42)
            r4 = 923(0x39b, float:1.293E-42)
            r5 = 928(0x3a0, float:1.3E-42)
            r6 = 902(0x386, float:1.264E-42)
            r7 = 900(0x384, double:4.447E-321)
            r11 = 924(0x39c, float:1.295E-42)
            r12 = 901(0x385, float:1.263E-42)
            r13 = 900(0x384, float:1.261E-42)
            r14 = 6
            r16 = 0
            if (r0 != r12) goto L_0x0083
            char[] r0 = new char[r14]
            int[] r9 = new int[r14]
            r10 = r25
            r15 = 0
            r17 = 0
            r19 = 0
        L_0x0024:
            r3 = r24[r16]
            if (r10 >= r3) goto L_0x0071
            if (r17 != 0) goto L_0x0071
            int r3 = r10 + 1
            r10 = r24[r10]
            if (r10 >= r13) goto L_0x003b
            r9[r15] = r10
            int r15 = r15 + 1
            long r19 = r19 * r7
            long r7 = (long) r10
            long r19 = r19 + r7
        L_0x0039:
            r10 = r3
            goto L_0x004e
        L_0x003b:
            if (r10 == r13) goto L_0x0049
            if (r10 == r12) goto L_0x0049
            if (r10 == r6) goto L_0x0049
            if (r10 == r11) goto L_0x0049
            if (r10 == r5) goto L_0x0049
            if (r10 == r4) goto L_0x0049
            if (r10 != r2) goto L_0x0039
        L_0x0049:
            int r3 = r3 + -1
            r10 = r3
            r17 = 1
        L_0x004e:
            int r3 = r15 % 5
            if (r3 != 0) goto L_0x006d
            if (r15 <= 0) goto L_0x006d
            r3 = 0
        L_0x0055:
            if (r3 >= r14) goto L_0x0069
            int r7 = 5 - r3
            r21 = 256(0x100, double:1.265E-321)
            long r14 = r19 % r21
            int r15 = (int) r14
            char r14 = (char) r15
            r0[r7] = r14
            r7 = 8
            long r19 = r19 >> r7
            int r3 = r3 + 1
            r14 = 6
            goto L_0x0055
        L_0x0069:
            r1.append(r0)
            r15 = 0
        L_0x006d:
            r7 = 900(0x384, double:4.447E-321)
            r14 = 6
            goto L_0x0024
        L_0x0071:
            int r0 = r15 / 5
            int r0 = r0 * 5
        L_0x0075:
            if (r0 >= r15) goto L_0x0080
            r2 = r9[r0]
            char r2 = (char) r2
            r1.append(r2)
            int r0 = r0 + 1
            goto L_0x0075
        L_0x0080:
            r0 = r10
            goto L_0x00eb
        L_0x0083:
            if (r0 != r11) goto L_0x00e9
            r0 = r25
            r3 = 0
            r15 = 0
            r17 = 0
        L_0x008b:
            r7 = r24[r16]
            if (r0 >= r7) goto L_0x00eb
            if (r15 != 0) goto L_0x00eb
            int r7 = r0 + 1
            r0 = r24[r0]
            if (r0 >= r13) goto L_0x00a2
            int r3 = r3 + 1
            r9 = 900(0x384, double:4.447E-321)
            long r17 = r17 * r9
            long r8 = (long) r0
            long r17 = r17 + r8
        L_0x00a0:
            r0 = r7
            goto L_0x00b4
        L_0x00a2:
            if (r0 == r13) goto L_0x00b0
            if (r0 == r12) goto L_0x00b0
            if (r0 == r6) goto L_0x00b0
            if (r0 == r11) goto L_0x00b0
            if (r0 == r5) goto L_0x00b0
            if (r0 == r4) goto L_0x00b0
            if (r0 != r2) goto L_0x00a0
        L_0x00b0:
            int r7 = r7 + -1
            r0 = r7
            r15 = 1
        L_0x00b4:
            int r7 = r3 % 5
            if (r7 != 0) goto L_0x00df
            if (r3 <= 0) goto L_0x00df
            r7 = 6
            char[] r8 = new char[r7]
            r9 = 0
        L_0x00be:
            if (r9 >= r7) goto L_0x00d7
            int r10 = 5 - r9
            r19 = 255(0xff, double:1.26E-321)
            r23 = r3
            long r2 = r17 & r19
            int r3 = (int) r2
            char r2 = (char) r3
            r8[r10] = r2
            r2 = 8
            long r17 = r17 >> r2
            int r9 = r9 + 1
            r2 = 922(0x39a, float:1.292E-42)
            r3 = r23
            goto L_0x00be
        L_0x00d7:
            r23 = r3
            r2 = 8
            r1.append(r8)
            goto L_0x00e4
        L_0x00df:
            r23 = r3
            r2 = 8
            r7 = 6
        L_0x00e4:
            r3 = r23
            r2 = 922(0x39a, float:1.292E-42)
            goto L_0x008b
        L_0x00e9:
            r0 = r25
        L_0x00eb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.byteCompaction(int, int[], int, java.lang.StringBuilder):int");
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < TEXT_COMPACTION_MODE_LATCH) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == TEXT_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == BEGIN_MACRO_PDF417_CONTROL_BLOCK || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                i3--;
                z = true;
            }
            if (i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
