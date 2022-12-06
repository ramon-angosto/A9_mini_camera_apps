package com.google.zxing.oned;

public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD = START_END_CHARS[0];
    private static final char[] START_END_CHARS = {'A', 'B', 'C', 'D'};

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0113 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] encode(java.lang.String r11) {
        /*
            r10 = this;
            int r0 = r11.length()
            r1 = 0
            r2 = 1
            r3 = 2
            if (r0 >= r3) goto L_0x0023
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            char r3 = DEFAULT_GUARD
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.<init>(r3)
            r0.append(r11)
            char r11 = DEFAULT_GUARD
            r0.append(r11)
            java.lang.String r11 = r0.toString()
        L_0x0020:
            r0 = r11
            goto L_0x009c
        L_0x0023:
            char r0 = r11.charAt(r1)
            char r0 = java.lang.Character.toUpperCase(r0)
            int r3 = r11.length()
            int r3 = r3 - r2
            char r3 = r11.charAt(r3)
            char r3 = java.lang.Character.toUpperCase(r3)
            char[] r4 = START_END_CHARS
            boolean r4 = com.google.zxing.oned.CodaBarReader.arrayContains(r4, r0)
            char[] r5 = START_END_CHARS
            boolean r5 = com.google.zxing.oned.CodaBarReader.arrayContains(r5, r3)
            char[] r6 = ALT_START_END_CHARS
            boolean r0 = com.google.zxing.oned.CodaBarReader.arrayContains(r6, r0)
            char[] r6 = ALT_START_END_CHARS
            boolean r3 = com.google.zxing.oned.CodaBarReader.arrayContains(r6, r3)
            java.lang.String r6 = "Invalid start/end guards: "
            if (r4 == 0) goto L_0x0069
            if (r5 == 0) goto L_0x0057
            goto L_0x006d
        L_0x0057:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r6)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        L_0x0069:
            if (r0 == 0) goto L_0x0080
            if (r3 == 0) goto L_0x006e
        L_0x006d:
            goto L_0x0020
        L_0x006e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r6)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        L_0x0080:
            if (r5 != 0) goto L_0x017c
            if (r3 != 0) goto L_0x017c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            char r3 = DEFAULT_GUARD
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r0.<init>(r3)
            r0.append(r11)
            char r11 = DEFAULT_GUARD
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            goto L_0x0020
        L_0x009c:
            r11 = 20
            r11 = 1
            r3 = 20
        L_0x00a1:
            int r4 = r0.length()
            int r4 = r4 - r2
            if (r11 < r4) goto L_0x012f
            int r11 = r0.length()
            int r11 = r11 - r2
            int r3 = r3 + r11
            boolean[] r4 = new boolean[r3]
            r5 = 0
            r6 = 0
        L_0x00b2:
            int r11 = r0.length()
            if (r5 < r11) goto L_0x00b9
            return r4
        L_0x00b9:
            char r11 = r0.charAt(r5)
            char r11 = java.lang.Character.toUpperCase(r11)
            if (r5 == 0) goto L_0x00ca
            int r3 = r0.length()
            int r3 = r3 - r2
            if (r5 != r3) goto L_0x00da
        L_0x00ca:
            r3 = 42
            if (r11 == r3) goto L_0x00eb
            r3 = 69
            if (r11 == r3) goto L_0x00e6
            r3 = 78
            if (r11 == r3) goto L_0x00e1
            r3 = 84
            if (r11 == r3) goto L_0x00dc
        L_0x00da:
            r7 = r11
            goto L_0x00ef
        L_0x00dc:
            r11 = 65
            r7 = 65
            goto L_0x00ef
        L_0x00e1:
            r11 = 66
            r7 = 66
            goto L_0x00ef
        L_0x00e6:
            r11 = 68
            r7 = 68
            goto L_0x00ef
        L_0x00eb:
            r11 = 67
            r7 = 67
        L_0x00ef:
            r11 = 0
        L_0x00f0:
            char[] r3 = com.google.zxing.oned.CodaBarReader.ALPHABET
            int r3 = r3.length
            if (r11 < r3) goto L_0x00f7
            r3 = 0
            goto L_0x0102
        L_0x00f7:
            char[] r3 = com.google.zxing.oned.CodaBarReader.ALPHABET
            char r3 = r3[r11]
            if (r7 != r3) goto L_0x012c
            int[] r3 = com.google.zxing.oned.CodaBarReader.CHARACTER_ENCODINGS
            r11 = r3[r11]
            r3 = r11
        L_0x0102:
            r11 = 0
            r7 = 1
        L_0x0104:
            r8 = 0
        L_0x0105:
            r9 = 7
            if (r11 < r9) goto L_0x0116
            int r11 = r0.length()
            int r11 = r11 - r2
            if (r5 >= r11) goto L_0x0113
            r4[r6] = r1
            int r6 = r6 + 1
        L_0x0113:
            int r5 = r5 + 1
            goto L_0x00b2
        L_0x0116:
            r4[r6] = r7
            int r6 = r6 + 1
            int r9 = 6 - r11
            int r9 = r3 >> r9
            r9 = r9 & r2
            if (r9 == 0) goto L_0x0127
            if (r8 != r2) goto L_0x0124
            goto L_0x0127
        L_0x0124:
            int r8 = r8 + 1
            goto L_0x0105
        L_0x0127:
            r7 = r7 ^ 1
            int r11 = r11 + 1
            goto L_0x0104
        L_0x012c:
            int r11 = r11 + 1
            goto L_0x00f0
        L_0x012f:
            char r4 = r0.charAt(r11)
            boolean r4 = java.lang.Character.isDigit(r4)
            if (r4 != 0) goto L_0x0176
            char r4 = r0.charAt(r11)
            r5 = 45
            if (r4 == r5) goto L_0x0176
            char r4 = r0.charAt(r11)
            r5 = 36
            if (r4 != r5) goto L_0x014a
            goto L_0x0176
        L_0x014a:
            char[] r4 = CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED
            char r5 = r0.charAt(r11)
            boolean r4 = com.google.zxing.oned.CodaBarReader.arrayContains(r4, r5)
            if (r4 == 0) goto L_0x0159
            int r3 = r3 + 10
            goto L_0x0178
        L_0x0159:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Cannot encode : '"
            r2.<init>(r3)
            char r11 = r0.charAt(r11)
            r2.append(r11)
            r11 = 39
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.<init>(r11)
            throw r1
        L_0x0176:
            int r3 = r3 + 9
        L_0x0178:
            int r11 = r11 + 1
            goto L_0x00a1
        L_0x017c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r6)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            goto L_0x018f
        L_0x018e:
            throw r0
        L_0x018f:
            goto L_0x018e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.CodaBarWriter.encode(java.lang.String):boolean[]");
    }
}
