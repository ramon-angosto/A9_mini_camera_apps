package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ae */
public class C1612ae {
    /* renamed from: a */
    public static int m2508a(byte[] bArr) {
        if (bArr.length == 4) {
            return (bArr[3] & 255) | 0 | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
        }
        throw new IllegalArgumentException("the length of bytes must be 4");
    }

    /* renamed from: a */
    public static byte[] m2509a(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }
}
