package com.huawei.appgallery.serviceverifykit.p009b;

/* renamed from: com.huawei.appgallery.serviceverifykit.b.b */
public final class C0574b {

    /* renamed from: a */
    private static final char[] f167a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final char[] f168b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static char[] m120a(byte[] bArr, boolean z) {
        return m121a(bArr, z ? f168b : f167a);
    }

    /* renamed from: a */
    private static char[] m121a(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    /* renamed from: b */
    public static String m122b(byte[] bArr, boolean z) {
        return new String(m120a(bArr, z));
    }
}
