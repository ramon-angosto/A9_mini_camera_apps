package com.huawei.android.pushagent.plugin.tools.a;

public class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static int a(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c + " at index " + i);
    }

    public static byte[] a(char[] cArr) {
        int length = cArr.length;
        int i = 0;
        if ((length & 1) != 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(length >> 1)];
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            i = i3 + 1;
            bArr[i2] = (byte) (((a(cArr[i], i) << 4) | a(cArr[i3], i3)) & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, a);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
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

    public static String b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : new String(a(bArr));
    }
}
