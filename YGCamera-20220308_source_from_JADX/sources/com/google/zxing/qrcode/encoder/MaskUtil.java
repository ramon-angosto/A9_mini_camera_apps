package com.google.zxing.qrcode.encoder;

final class MaskUtil {

    /* renamed from: N1 */
    private static final int f91N1 = 3;

    /* renamed from: N2 */
    private static final int f92N2 = 3;

    /* renamed from: N3 */
    private static final int f93N3 = 40;

    /* renamed from: N4 */
    private static final int f94N4 = 10;

    private MaskUtil() {
    }

    static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height - 1) {
            byte[] bArr = array[i];
            int i3 = i2;
            int i4 = 0;
            while (i4 < width - 1) {
                byte b = bArr[i4];
                int i5 = i4 + 1;
                if (b == bArr[i5]) {
                    int i6 = i + 1;
                    if (b == array[i6][i4] && b == array[i6][i5]) {
                        i3++;
                    }
                }
                i4 = i5;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            for (int i4 = 0; i4 < width; i4++) {
                byte[] bArr = array[i];
                int i5 = i4 + 6;
                if (i5 < width && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (isWhiteHorizontal(bArr, i4 - 4, i4) || isWhiteHorizontal(bArr, i4 + 7, i4 + 11))) {
                    i3++;
                }
                int i6 = i + 6;
                if (i6 < height && array[i][i4] == 1 && array[i + 1][i4] == 0 && array[i + 2][i4] == 1 && array[i + 3][i4] == 1 && array[i + 4][i4] == 1 && array[i + 5][i4] == 0 && array[i6][i4] == 1 && (isWhiteVertical(array, i4, i - 4, i) || isWhiteVertical(array, i4, i + 7, i + 11))) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            byte[] bArr = array[i];
            int i3 = i2;
            for (int i4 = 0; i4 < width; i4++) {
                if (bArr[i4] == 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i2 * 2) - height2) * 10) / height2) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        r3 = r3 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r1 != 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean getDataMaskBit(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L_0x003e;
                case 1: goto L_0x003f;
                case 2: goto L_0x003b;
                case 3: goto L_0x0037;
                case 4: goto L_0x0032;
                case 5: goto L_0x002a;
                case 6: goto L_0x0021;
                case 7: goto L_0x0018;
                default: goto L_0x0004;
            }
        L_0x0004:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid mask pattern: "
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0018:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L_0x0028
        L_0x0021:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L_0x0028:
            r1 = r1 & r0
            goto L_0x0041
        L_0x002a:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x0041
        L_0x0032:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L_0x003e
        L_0x0037:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x0041
        L_0x003b:
            int r1 = r2 % 3
            goto L_0x0041
        L_0x003e:
            int r3 = r3 + r2
        L_0x003f:
            r1 = r3 & 1
        L_0x0041:
            if (r1 != 0) goto L_0x0044
            return r0
        L_0x0044:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(int, int, int):boolean");
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i = 0;
        for (int i2 = 0; i2 < height; i2++) {
            int i3 = i;
            int i4 = 0;
            byte b = -1;
            for (int i5 = 0; i5 < width; i5++) {
                byte b2 = z ? array[i2][i5] : array[i5][i2];
                if (b2 == b) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b = b2;
                }
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i = i3;
        }
        return i;
    }
}
