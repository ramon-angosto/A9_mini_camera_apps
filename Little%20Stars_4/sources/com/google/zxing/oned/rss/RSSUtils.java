package com.google.zxing.oned.rss;

public final class RSSUtils {
    private RSSUtils() {
    }

    static int[] getRSSwidths(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int combins;
        int i6 = i3;
        int i7 = i4;
        int[] iArr = new int[i6];
        int i8 = i;
        int i9 = i2;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i6 - 1;
            if (i10 < i12) {
                int i13 = 1 << i10;
                int i14 = i8;
                int i15 = i11 | i13;
                int i16 = 1;
                while (true) {
                    i5 = i9 - i16;
                    int i17 = i6 - i10;
                    int i18 = i17 - 2;
                    combins = combins(i5 - 1, i18);
                    if (z && i15 == 0) {
                        int i19 = i17 - 1;
                        if (i5 - i19 >= i19) {
                            combins -= combins(i5 - i17, i18);
                        }
                    }
                    if (i17 - 1 > 1) {
                        int i20 = i5 - i18;
                        int i21 = 0;
                        while (i20 > i7) {
                            i21 += combins((i5 - i20) - 1, i17 - 3);
                            i20--;
                            int i22 = i3;
                        }
                        combins -= i21 * (i12 - i10);
                    } else if (i5 > i7) {
                        combins--;
                    }
                    i14 -= combins;
                    if (i14 < 0) {
                        break;
                    }
                    i16++;
                    i15 &= i13 ^ -1;
                    i6 = i3;
                }
                iArr[i10] = i16;
                i10++;
                i11 = i15;
                i9 = i5;
                i8 = i14 + combins;
                i6 = i3;
            } else {
                iArr[i10] = i9;
                return iArr;
            }
        }
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int[] iArr2 = iArr;
        int i2 = i;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int i5 = i3;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = r2 - 1;
            if (i6 >= i9) {
                return i7;
            }
            int i10 = 1 << i6;
            int i11 = i8 | i10;
            int i12 = i7;
            int i13 = 1;
            while (i13 < iArr2[i6]) {
                int i14 = i5 - i13;
                int i15 = r2 - i6;
                int i16 = i15 - 2;
                int combins = combins(i14 - 1, i16);
                if (z && i11 == 0) {
                    int i17 = i15 - 1;
                    if (i14 - i17 >= i17) {
                        combins -= combins(i14 - i15, i16);
                    }
                }
                if (i15 - 1 > 1) {
                    int i18 = i14 - i16;
                    int i19 = 0;
                    while (i18 > i2) {
                        i19 += combins((i14 - i18) - 1, i15 - 3);
                        i18--;
                        int[] iArr3 = iArr;
                    }
                    combins -= i19 * (i9 - i6);
                } else if (i14 > i2) {
                    combins--;
                }
                i12 += combins;
                i13++;
                i11 &= i10 ^ -1;
                iArr2 = iArr;
            }
            i5 -= i13;
            i6++;
            iArr2 = iArr;
            i7 = i12;
            i8 = i11;
        }
    }

    private static int combins(int i, int i2) {
        int i3 = i - i2;
        if (i3 > i2) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i > i2) {
            i5 *= i;
            if (i6 <= i3) {
                i5 /= i6;
                i6++;
            }
            i--;
        }
        while (i6 <= i3) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }

    static int[] elements(int[] iArr, int i, int i2) {
        int[] iArr2 = new int[(iArr.length + 2)];
        int i3 = i2 << 1;
        iArr2[0] = 1;
        int i4 = 1;
        int i5 = 10;
        for (int i6 = 1; i6 < i3 - 2; i6 += 2) {
            int i7 = i6 - 1;
            iArr2[i6] = iArr[i7] - iArr2[i7];
            int i8 = i6 + 1;
            iArr2[i8] = iArr[i6] - iArr2[i6];
            i4 += iArr2[i6] + iArr2[i8];
            if (iArr2[i6] < i5) {
                i5 = iArr2[i6];
            }
        }
        int i9 = i3 - 1;
        iArr2[i9] = i - i4;
        if (iArr2[i9] < i5) {
            i5 = iArr2[i9];
        }
        if (i5 > 1) {
            for (int i10 = 0; i10 < i3; i10 += 2) {
                int i11 = i5 - 1;
                iArr2[i10] = iArr2[i10] + i11;
                int i12 = i10 + 1;
                iArr2[i12] = iArr2[i12] - i11;
            }
        }
        return iArr2;
    }
}
