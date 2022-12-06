package com.meizu.cloud.pushsdk.common.base;

public class b {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final char b = ((char) Integer.parseInt("00000011", 2));
    private static final char c = ((char) Integer.parseInt("00001111", 2));
    private static final char d = ((char) Integer.parseInt("00111111", 2));
    private String e;
    private char[] f;
    private int g = 0;

    public b(String str) {
        this.e = str;
        a();
    }

    public String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        int length = bArr.length;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            char c2 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(this.f[c2 >>> 2]);
                sb.append(this.f[(c2 & b) << 4]);
                sb.append("==");
                break;
            }
            int i3 = i2 + 1;
            char c3 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(this.f[c2 >>> 2]);
                sb.append(this.f[((c2 & b) << 4) | (c3 >>> 4)]);
                sb.append(this.f[(c & c3) << 2]);
                sb.append("=");
                break;
            }
            int i4 = i3 + 1;
            char c4 = bArr[i3] & 255;
            sb.append(this.f[c2 >>> 2]);
            sb.append(this.f[((c2 & b) << 4) | (c3 >>> 4)]);
            sb.append(this.f[((c3 & c) << 2) | (c4 >>> 6)]);
            sb.append(this.f[d & c4]);
            i = i4;
        }
        return sb.toString();
    }

    private void a() {
        char[] cArr = new char[a.length];
        int i = 0;
        this.g = this.e.charAt(0) % 13;
        while (true) {
            char[] cArr2 = a;
            if (i < cArr2.length) {
                cArr[i] = cArr2[(this.g + i) % cArr2.length];
                i++;
            } else {
                this.f = cArr;
                return;
            }
        }
    }
}
