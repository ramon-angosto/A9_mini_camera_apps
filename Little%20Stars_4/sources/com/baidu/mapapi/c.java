package com.baidu.mapapi;

public class c {
    private static char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] b = new byte[256];

    static {
        for (int i = 0; i < 256; i++) {
            b[i] = -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            b[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            b[i3] = (byte) ((i3 + 26) - 97);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            b[i4] = (byte) ((i4 + 52) - 48);
        }
        byte[] bArr = b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static char[] a(char[] cArr) {
        boolean z;
        char[] cArr2 = new char[(((cArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = 0;
        while (i < cArr.length) {
            int i3 = (cArr[i] & 255) << 8;
            int i4 = i + 1;
            boolean z2 = true;
            if (i4 < cArr.length) {
                i3 |= cArr[i4] & 255;
                z = true;
            } else {
                z = false;
            }
            int i5 = i3 << 8;
            int i6 = i + 2;
            if (i6 < cArr.length) {
                i5 |= cArr[i6] & 255;
            } else {
                z2 = false;
            }
            int i7 = 64;
            cArr2[i2 + 3] = a[z2 ? i5 & 63 : 64];
            int i8 = i5 >> 6;
            int i9 = i2 + 2;
            char[] cArr3 = a;
            if (z) {
                i7 = i8 & 63;
            }
            cArr2[i9] = cArr3[i7];
            int i10 = i8 >> 6;
            char[] cArr4 = a;
            cArr2[i2 + 1] = cArr4[i10 & 63];
            cArr2[i2 + 0] = cArr4[(i10 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return cArr2;
    }

    public static char[] b(char[] cArr) {
        int length = ((cArr.length + 3) / 4) * 3;
        if (cArr.length > 0 && cArr[cArr.length - 1] == '=') {
            length--;
        }
        if (cArr.length > 1 && cArr[cArr.length - 2] == '=') {
            length--;
        }
        char[] cArr2 = new char[length];
        int i = 0;
        byte b2 = 0;
        int i2 = 0;
        for (char c : cArr) {
            byte b3 = b[c & 255];
            if (b3 >= 0) {
                i2 += 6;
                b2 = (b2 << 6) | b3;
                if (i2 >= 8) {
                    i2 -= 8;
                    cArr2[i] = (char) ((b2 >> i2) & 255);
                    i++;
                }
            }
        }
        if (i == cArr2.length) {
            return cArr2;
        }
        throw new Error("miscalculated data length!");
    }
}
