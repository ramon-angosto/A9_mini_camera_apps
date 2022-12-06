package com.google.protobuf.micro;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class b {
    private final byte[] a;
    private final int b;
    private int c;
    private final OutputStream d;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private b(OutputStream outputStream, byte[] bArr) {
        this.d = outputStream;
        this.a = bArr;
        this.c = 0;
        this.b = bArr.length;
    }

    private b(byte[] bArr, int i, int i2) {
        this.d = null;
        this.a = bArr;
        this.c = i;
        this.b = i + i2;
    }

    public static b a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    public static b a(OutputStream outputStream, int i) {
        return new b(outputStream, new byte[i]);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static int b(int i, boolean z) {
        return f(i) + b(z);
    }

    public static int b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return h(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int c(int i) {
        if (i >= 0) {
            return h(i);
        }
        return 10;
    }

    public static int c(int i, int i2) {
        return f(i) + c(i2);
    }

    public static int d(int i) {
        return h(i);
    }

    public static int d(int i, int i2) {
        return f(i) + d(i2);
    }

    private void d() {
        OutputStream outputStream = this.d;
        if (outputStream != null) {
            outputStream.write(this.a, 0, this.c);
            this.c = 0;
            return;
        }
        throw new a();
    }

    public static int f(int i) {
        return h(e.a(i, 0));
    }

    public static int h(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public void a() {
        if (this.d != null) {
            d();
        }
    }

    public void a(byte b2) {
        if (this.c == this.b) {
            d();
        }
        byte[] bArr = this.a;
        int i = this.c;
        this.c = i + 1;
        bArr[i] = b2;
    }

    public void a(int i) {
        if (i >= 0) {
            g(i);
        } else {
            a((long) i);
        }
    }

    public void a(int i, int i2) {
        e(i, 0);
        a(i2);
    }

    public void a(int i, String str) {
        e(i, 2);
        a(str);
    }

    public void a(int i, boolean z) {
        e(i, 0);
        a(z);
    }

    public void a(long j) {
        while ((-128 & j) != 0) {
            e((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        e((int) j);
    }

    public void a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        g(bytes.length);
        a(bytes);
    }

    public void a(boolean z) {
        e(z ? 1 : 0);
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public int b() {
        if (this.d == null) {
            return this.b - this.c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void b(int i) {
        g(i);
    }

    public void b(int i, int i2) {
        e(i, 0);
        b(i2);
    }

    public void b(byte[] bArr, int i, int i2) {
        int i3 = this.b;
        int i4 = this.c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.a, i4, i2);
            this.c += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.c = this.b;
        d();
        if (i7 <= this.b) {
            System.arraycopy(bArr, i6, this.a, 0, i7);
            this.c = i7;
            return;
        }
        this.d.write(bArr, i6, i7);
    }

    public void c() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void e(int i) {
        a((byte) i);
    }

    public void e(int i, int i2) {
        g(e.a(i, i2));
    }

    public void g(int i) {
        while ((i & -128) != 0) {
            e((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        e(i);
    }
}
