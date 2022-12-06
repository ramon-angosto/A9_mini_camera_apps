package com.huawei.updatesdk.p025a.p026a.p031d;

/* renamed from: com.huawei.updatesdk.a.a.d.a */
public class C0969a {

    /* renamed from: a */
    private static char[] f1304a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};

    /* renamed from: a */
    public static String m1685a(byte[] bArr) {
        return m1686a(bArr, bArr.length);
    }

    /* renamed from: a */
    public static String m1686a(byte[] bArr, int i) {
        boolean z;
        char[] cArr = new char[(((i + 2) / 3) * 4)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = (bArr[i2] & 255) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < i) {
                i4 |= bArr[i5] & 255;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < i) {
                i6 |= bArr[i7] & 255;
            } else {
                z2 = false;
            }
            int i8 = 64;
            cArr[i3 + 3] = f1304a[z2 ? i6 & 63 : 64];
            int i9 = i6 >> 6;
            int i10 = i3 + 2;
            char[] cArr2 = f1304a;
            if (z) {
                i8 = i9 & 63;
            }
            cArr[i10] = cArr2[i8];
            int i11 = i9 >> 6;
            char[] cArr3 = f1304a;
            cArr[i3 + 1] = cArr3[i11 & 63];
            cArr[i3 + 0] = cArr3[(i11 >> 6) & 63];
            i2 += 3;
            i3 += 4;
        }
        return String.valueOf(cArr);
    }
}
