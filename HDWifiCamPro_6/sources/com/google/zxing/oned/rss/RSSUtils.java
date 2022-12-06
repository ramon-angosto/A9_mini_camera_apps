package com.google.zxing.oned.rss;

public final class RSSUtils {
    private RSSUtils() {
    }

    public static int getRSSvalue(int[] iArr, int i, boolean z) {
        int i2;
        int[] iArr2 = iArr;
        int i3 = i;
        int i4 = 0;
        for (int i5 : iArr2) {
            i4 += i5;
        }
        int length = iArr2.length;
        int i6 = i4;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = length - 1;
            if (i9 >= i10) {
                return i8;
            }
            int i11 = 1 << i9;
            int i12 = i7 | i11;
            int i13 = 1;
            while (i13 < iArr2[i9]) {
                int i14 = i6 - i13;
                int i15 = length - i9;
                int i16 = i15 - 2;
                int combins = combins(i14 - 1, i16);
                if (z && i12 == 0) {
                    int i17 = i15 - 1;
                    if (i14 - i17 >= i17) {
                        combins -= combins(i14 - i15, i16);
                    }
                }
                if (i15 - 1 > 1) {
                    int i18 = i14 - i16;
                    int i19 = 0;
                    while (i18 > i3) {
                        i19 += combins((i14 - i18) - 1, i15 - 3);
                        i18--;
                        length = length;
                    }
                    combins -= i19 * (i10 - i9);
                    i2 = length;
                } else {
                    i2 = length;
                    if (i14 > i3) {
                        combins--;
                    }
                }
                i8 += combins;
                i13++;
                i12 &= ~i11;
                length = i2;
            }
            i6 -= i13;
            i9++;
            i7 = i12;
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
}
