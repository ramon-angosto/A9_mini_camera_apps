package com.meizu.cloud.pushsdk.a.h;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class d implements Serializable, Comparable<d> {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final d b = a(new byte[0]);
    private static final long serialVersionUID = 1;
    final byte[] c;
    transient int d;
    transient String e;

    d(byte[] bArr) {
        this.c = bArr;
    }

    public static d a(byte... bArr) {
        if (bArr != null) {
            return new d((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static d a(String str) {
        if (str != null) {
            d dVar = new d(str.getBytes(n.a));
            dVar.e = str;
            return dVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, n.a);
        this.e = str2;
        return str2;
    }

    public d b() {
        return b("MD5");
    }

    private d b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public String c() {
        byte[] bArr = this.c;
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

    public static d a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new d(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
    }

    public byte a(int i) {
        return this.c[i];
    }

    public int d() {
        return this.c.length;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        byte[] bArr = this.c;
        aVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 <= bArr.length - i3 && n.a(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int d2 = dVar.d();
            byte[] bArr = this.c;
            return d2 == bArr.length && dVar.a(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.c);
        this.d = hashCode;
        return hashCode;
    }

    /* renamed from: a */
    public int compareTo(d dVar) {
        int d2 = d();
        int d3 = dVar.d();
        int min = Math.min(d2, d3);
        int i = 0;
        while (i < min) {
            byte a2 = a(i) & 255;
            byte a3 = dVar.a(i) & 255;
            if (a2 == a3) {
                i++;
            } else if (a2 < a3) {
                return -1;
            } else {
                return 1;
            }
        }
        if (d2 == d3) {
            return 0;
        }
        if (d2 < d3) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        byte[] bArr = this.c;
        if (bArr.length == 0) {
            return "ByteString[size=0]";
        }
        if (bArr.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(bArr.length), c()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(bArr.length), b().c()});
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        d a2 = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = d.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a2.c);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }
}
