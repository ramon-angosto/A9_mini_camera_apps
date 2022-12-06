package com.bytedance.sdk.component.b.a.b;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

/* compiled from: ByteString */
public class d implements Serializable, Comparable<d> {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset b = Charset.forName("UTF-8");
    public static final d c = a(new byte[0]);
    final byte[] d;
    transient int e;
    transient String f;

    d(byte[] bArr) {
        this.d = bArr;
    }

    public static d a(byte... bArr) {
        if (bArr != null) {
            return new d((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String a() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.d, b);
        this.f = str2;
        return str2;
    }

    public String b() {
        byte[] bArr = this.d;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public d a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.d;
            if (i2 <= bArr.length) {
                int i3 = i2 - i;
                if (i3 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i == 0 && i2 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.d, i, bArr2, 0, i3);
                    return new d(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.d.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte a(int i) {
        return this.d[i];
    }

    public int c() {
        return this.d.length;
    }

    public byte[] d() {
        return (byte[]) this.d.clone();
    }

    public boolean a(int i, d dVar, int i2, int i3) {
        return dVar.a(i2, this.d, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.d;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && i.a(bArr2, i, bArr, i2, i3);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int c2 = dVar.c();
            byte[] bArr = this.d;
            if (c2 == bArr.length && dVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.e;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.d);
        this.e = hashCode;
        return hashCode;
    }

    /* renamed from: a */
    public int compareTo(d dVar) {
        int c2 = c();
        int c3 = dVar.c();
        int min = Math.min(c2, c3);
        int i = 0;
        while (i < min) {
            byte a2 = a(i) & UByte.MAX_VALUE;
            byte a3 = dVar.a(i) & UByte.MAX_VALUE;
            if (a2 == a3) {
                i++;
            } else if (a2 < a3) {
                return -1;
            } else {
                return 1;
            }
        }
        if (c2 == c3) {
            return 0;
        }
        if (c2 < c3) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        StringBuilder sb;
        if (this.d.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 != -1) {
            String replace = a2.substring(0, a3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a3 < a2.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(this.d.length);
                sb.append(" text=");
                sb.append(replace);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(replace);
                sb.append("]");
            }
            return sb.toString();
        } else if (this.d.length <= 64) {
            return "[hex=" + b() + "]";
        } else {
            return "[size=" + this.d.length + " hex=" + a(0, 64).b() + "…]";
        }
    }

    static int a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }
}
