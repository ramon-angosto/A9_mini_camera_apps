package com.google.zxing.qrcode.encoder;

final class MaskUtil {
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
            int i3 = i2;
            int i4 = 0;
            while (i4 < width - 1) {
                byte b = array[i][i4];
                int i5 = i4 + 1;
                if (b == array[i][i5]) {
                    int i6 = i + 1;
                    if (b == array[i6][i4] && b == array[i6][i5]) {
                        i3 += 3;
                    }
                }
                i4 = i5;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i5 = 0;
        int i6 = 0;
        while (i5 < height) {
            int i7 = i6;
            for (int i8 = 0; i8 < width; i8++) {
                int i9 = i8 + 6;
                if (i9 < width && array[i5][i8] == 1 && array[i5][i8 + 1] == 0 && array[i5][i8 + 2] == 1 && array[i5][i8 + 3] == 1 && array[i5][i8 + 4] == 1 && array[i5][i8 + 5] == 0 && array[i5][i9] == 1 && (((i3 = i8 + 10) < width && array[i5][i8 + 7] == 0 && array[i5][i8 + 8] == 0 && array[i5][i8 + 9] == 0 && array[i5][i3] == 0) || (i8 - 4 >= 0 && array[i5][i8 - 1] == 0 && array[i5][i8 - 2] == 0 && array[i5][i8 - 3] == 0 && array[i5][i4] == 0))) {
                    i7 += 40;
                }
                int i10 = i5 + 6;
                if (i10 < height && array[i5][i8] == 1 && array[i5 + 1][i8] == 0 && array[i5 + 2][i8] == 1 && array[i5 + 3][i8] == 1 && array[i5 + 4][i8] == 1 && array[i5 + 5][i8] == 0 && array[i10][i8] == 1 && (((i = i5 + 10) < height && array[i5 + 7][i8] == 0 && array[i5 + 8][i8] == 0 && array[i5 + 9][i8] == 0 && array[i][i8] == 0) || (i5 - 4 >= 0 && array[i5 - 1][i8] == 0 && array[i5 - 2][i8] == 0 && array[i5 - 3][i8] == 0 && array[i2][i8] == 0))) {
                    i7 += 40;
                }
            }
            i5++;
            i6 = i7;
        }
        return i6;
    }

    static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            for (int i4 = 0; i4 < width; i4++) {
                if (array[i][i4] == 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        double d = (double) i2;
        double height2 = (double) (byteMatrix.getHeight() * byteMatrix.getWidth());
        Double.isNaN(d);
        Double.isNaN(height2);
        return (Math.abs((int) (((d / height2) * 100.0d) - 50.0d)) / 5) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        r1 = r1 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r1 != 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean getDataMaskBit(int r1, int r2, int r3) {
        /*
            boolean r0 = com.google.zxing.qrcode.encoder.QRCode.isValidMaskPattern(r1)
            if (r0 == 0) goto L_0x004f
            r0 = 1
            switch(r1) {
                case 0: goto L_0x0047;
                case 1: goto L_0x0048;
                case 2: goto L_0x0044;
                case 3: goto L_0x0040;
                case 4: goto L_0x0039;
                case 5: goto L_0x0031;
                case 6: goto L_0x0029;
                case 7: goto L_0x0021;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0021:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            goto L_0x003d
        L_0x0029:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x003e
        L_0x0031:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x004a
        L_0x0039:
            int r1 = r3 >>> 1
            int r2 = r2 / 3
        L_0x003d:
            int r1 = r1 + r2
        L_0x003e:
            r1 = r1 & r0
            goto L_0x004a
        L_0x0040:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x004a
        L_0x0044:
            int r1 = r2 % 3
            goto L_0x004a
        L_0x0047:
            int r3 = r3 + r2
        L_0x0048:
            r1 = r3 & 1
        L_0x004a:
            if (r1 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            return r0
        L_0x004f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid mask pattern"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(int, int, int):boolean");
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i = 0;
        int i2 = 0;
        byte b = -1;
        while (i < height) {
            byte b2 = b;
            int i3 = 0;
            int i4 = i2;
            for (int i5 = 0; i5 < width; i5++) {
                byte b3 = z ? array[i][i5] : array[i5][i];
                if (b3 == b2) {
                    i3++;
                    if (i3 == 5) {
                        i4 += 3;
                    } else if (i3 > 5) {
                        i4++;
                    }
                } else {
                    b2 = b3;
                    i3 = 1;
                }
            }
            i++;
            i2 = i4;
            b = b2;
        }
        return i2;
    }
}
