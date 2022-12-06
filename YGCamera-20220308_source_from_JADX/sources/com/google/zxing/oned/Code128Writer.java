package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: int[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r13) {
        /*
            r12 = this;
            int r0 = r13.length()
            r1 = 1
            if (r0 < r1) goto L_0x00f1
            r2 = 80
            if (r0 > r2) goto L_0x00f1
            r2 = 0
            r3 = 0
        L_0x000d:
            if (r3 < r0) goto L_0x00ce
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 1
        L_0x0018:
            r8 = 103(0x67, float:1.44E-43)
            if (r3 < r0) goto L_0x0065
            int r6 = r6 % r8
            int[][] r13 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r13 = r13[r6]
            r4.add(r13)
            int[][] r13 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r0 = 106(0x6a, float:1.49E-43)
            r13 = r13[r0]
            r4.add(r13)
            java.util.Iterator r9 = r4.iterator()
            r13 = 0
        L_0x0032:
            boolean r0 = r9.hasNext()
            if (r0 != 0) goto L_0x0051
            boolean[] r0 = new boolean[r13]
            java.util.Iterator r3 = r4.iterator()
        L_0x003e:
            boolean r13 = r3.hasNext()
            if (r13 != 0) goto L_0x0045
            return r0
        L_0x0045:
            java.lang.Object r13 = r3.next()
            int[] r13 = (int[]) r13
            int r13 = appendPattern(r0, r2, r13, r1)
            int r2 = r2 + r13
            goto L_0x003e
        L_0x0051:
            java.lang.Object r0 = r9.next()
            r10 = r0
            int[] r10 = (int[]) r10
            int r11 = r10.length
            r0 = r13
            r13 = 0
        L_0x005b:
            if (r13 < r11) goto L_0x005f
            r13 = r0
            goto L_0x0032
        L_0x005f:
            r3 = r10[r13]
            int r0 = r0 + r3
            int r13 = r13 + 1
            goto L_0x005b
        L_0x0065:
            int r9 = chooseCode(r13, r3, r5)
            r10 = 100
            r11 = 101(0x65, float:1.42E-43)
            if (r9 != r5) goto L_0x00a9
            char r8 = r13.charAt(r3)
            switch(r8) {
                case 241: goto L_0x0082;
                case 242: goto L_0x007f;
                case 243: goto L_0x007c;
                case 244: goto L_0x0077;
                default: goto L_0x0076;
            }
        L_0x0076:
            goto L_0x0085
        L_0x0077:
            if (r5 != r11) goto L_0x00a7
            r10 = 101(0x65, float:1.42E-43)
            goto L_0x00a7
        L_0x007c:
            r10 = 96
            goto L_0x00a7
        L_0x007f:
            r10 = 97
            goto L_0x00a7
        L_0x0082:
            r10 = 102(0x66, float:1.43E-43)
            goto L_0x00a7
        L_0x0085:
            if (r5 == r10) goto L_0x00a1
            if (r5 == r11) goto L_0x0096
            int r8 = r3 + 2
            java.lang.String r8 = r13.substring(r3, r8)
            int r10 = java.lang.Integer.parseInt(r8)
            int r3 = r3 + 1
            goto L_0x00a7
        L_0x0096:
            char r8 = r13.charAt(r3)
            int r10 = r8 + -32
            if (r10 >= 0) goto L_0x00a7
            int r10 = r10 + 96
            goto L_0x00a7
        L_0x00a1:
            char r8 = r13.charAt(r3)
            int r10 = r8 + -32
        L_0x00a7:
            int r3 = r3 + r1
            goto L_0x00be
        L_0x00a9:
            if (r5 != 0) goto L_0x00bc
            if (r9 == r10) goto L_0x00b7
            if (r9 == r11) goto L_0x00b4
            r8 = 105(0x69, float:1.47E-43)
            r10 = 105(0x69, float:1.47E-43)
            goto L_0x00bd
        L_0x00b4:
            r10 = 103(0x67, float:1.44E-43)
            goto L_0x00bd
        L_0x00b7:
            r8 = 104(0x68, float:1.46E-43)
            r10 = 104(0x68, float:1.46E-43)
            goto L_0x00bd
        L_0x00bc:
            r10 = r9
        L_0x00bd:
            r5 = r9
        L_0x00be:
            int[][] r8 = com.google.zxing.oned.Code128Reader.CODE_PATTERNS
            r8 = r8[r10]
            r4.add(r8)
            int r10 = r10 * r7
            int r6 = r6 + r10
            if (r3 == 0) goto L_0x0018
            int r7 = r7 + 1
            goto L_0x0018
        L_0x00ce:
            char r4 = r13.charAt(r3)
            switch(r4) {
                case 241: goto L_0x00d9;
                case 242: goto L_0x00d9;
                case 243: goto L_0x00d9;
                case 244: goto L_0x00d9;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 > r5) goto L_0x00dd
        L_0x00d9:
            int r3 = r3 + 1
            goto L_0x000d
        L_0x00dd:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Bad character in input: "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        L_0x00f1:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Contents length should be between 1 and 80 characters, but got "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r13.<init>(r0)
            goto L_0x0106
        L_0x0105:
            throw r13
        L_0x0106:
            goto L_0x0105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.encode(java.lang.String):boolean[]");
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType;
        CType findCType2;
        char charAt;
        CType findCType3 = findCType(charSequence, i);
        if (findCType3 == CType.ONE_DIGIT) {
            return 100;
        }
        if (findCType3 == CType.UNCODABLE) {
            if (i >= charSequence.length() || ((charAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || charAt >= '`'))) {
                return 100;
            }
            return 101;
        } else if (i2 == 99) {
            return 99;
        } else {
            if (i2 != 100) {
                if (findCType3 == CType.FNC_1) {
                    findCType3 = findCType(charSequence, i + 1);
                }
                if (findCType3 == CType.TWO_DIGITS) {
                    return 99;
                }
                return 100;
            } else if (findCType3 == CType.FNC_1 || (findCType = findCType(charSequence, i + 2)) == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                return 100;
            } else {
                if (findCType != CType.FNC_1) {
                    int i3 = i + 4;
                    while (true) {
                        findCType2 = findCType(charSequence, i3);
                        if (findCType2 != CType.TWO_DIGITS) {
                            break;
                        }
                        i3 += 2;
                    }
                    if (findCType2 == CType.ONE_DIGIT) {
                        return 100;
                    }
                    return 99;
                } else if (findCType(charSequence, i + 3) == CType.TWO_DIGITS) {
                    return 99;
                } else {
                    return 100;
                }
            }
        }
    }
}
