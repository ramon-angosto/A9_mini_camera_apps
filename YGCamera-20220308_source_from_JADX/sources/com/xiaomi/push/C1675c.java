package com.xiaomi.push;

import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.xiaomi.push.c */
public final class C1675c {

    /* renamed from: a */
    private final int f1906a;

    /* renamed from: a */
    private final OutputStream f1907a;

    /* renamed from: a */
    private final byte[] f1908a;

    /* renamed from: b */
    private int f1909b;

    /* renamed from: com.xiaomi.push.c$a */
    public static class C1676a extends IOException {
        C1676a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C1675c(OutputStream outputStream, byte[] bArr) {
        this.f1907a = outputStream;
        this.f1908a = bArr;
        this.f1909b = 0;
        this.f1906a = bArr.length;
    }

    private C1675c(byte[] bArr, int i, int i2) {
        this.f1907a = null;
        this.f1908a = bArr;
        this.f1909b = i;
        this.f1906a = i + i2;
    }

    /* renamed from: a */
    public static int mo17281a(int i) {
        if (i >= 0) {
            return mo17303d(i);
        }
        return 10;
    }

    /* renamed from: a */
    public static int mo17282a(int i, int i2) {
        return mo17300c(i) + mo17281a(i2);
    }

    /* renamed from: a */
    public static int mo17283a(int i, long j) {
        return mo17300c(i) + mo17288a(j);
    }

    /* renamed from: a */
    public static int mo17284a(int i, C1607a aVar) {
        return mo17300c(i) + mo17289a(aVar);
    }

    /* renamed from: a */
    public static int mo17285a(int i, C1742e eVar) {
        return mo17300c(i) + mo17290a(eVar);
    }

    /* renamed from: a */
    public static int mo17286a(int i, String str) {
        return mo17300c(i) + mo17291a(str);
    }

    /* renamed from: a */
    public static int mo17287a(int i, boolean z) {
        return mo17300c(i) + mo17292a(z);
    }

    /* renamed from: a */
    public static int mo17288a(long j) {
        return mo17302c(j);
    }

    /* renamed from: a */
    public static int mo17289a(C1607a aVar) {
        return mo17303d(aVar.mo17208a()) + aVar.mo17208a();
    }

    /* renamed from: a */
    public static int mo17290a(C1742e eVar) {
        int b = eVar.mo17413b();
        return mo17303d(b) + b;
    }

    /* renamed from: a */
    public static int mo17291a(String str) {
        try {
            byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
            return mo17303d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: a */
    public static int mo17292a(boolean z) {
        return 1;
    }

    /* renamed from: a */
    public static C1675c m2788a(OutputStream outputStream) {
        return m2789a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C1675c m2789a(OutputStream outputStream, int i) {
        return new C1675c(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static C1675c mo17294a(byte[] bArr, int i, int i2) {
        return new C1675c(bArr, i, i2);
    }

    /* renamed from: b */
    public static int mo17296b(int i) {
        return mo17303d(i);
    }

    /* renamed from: b */
    public static int mo17297b(int i, int i2) {
        return mo17300c(i) + mo17296b(i2);
    }

    /* renamed from: b */
    public static int mo17298b(int i, long j) {
        return mo17300c(i) + mo17299b(j);
    }

    /* renamed from: b */
    public static int mo17299b(long j) {
        return mo17302c(j);
    }

    /* renamed from: c */
    public static int mo17300c(int i) {
        return mo17303d(C1782f.m3469a(i, 0));
    }

    /* renamed from: c */
    public static int mo17302c(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: c */
    private void m2797c() {
        OutputStream outputStream = this.f1907a;
        if (outputStream != null) {
            outputStream.write(this.f1908a, 0, this.f1909b);
            this.f1909b = 0;
            return;
        }
        throw new C1676a();
    }

    /* renamed from: d */
    public static int mo17303d(int i) {
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

    /* renamed from: a */
    public int mo17279a() {
        if (this.f1907a == null) {
            return this.f1906a - this.f1909b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: a */
    public void m2800a() {
        if (this.f1907a != null) {
            m2797c();
        }
    }

    /* renamed from: a */
    public void mo17280a(byte b) {
        if (this.f1909b == this.f1906a) {
            m2797c();
        }
        byte[] bArr = this.f1908a;
        int i = this.f1909b;
        this.f1909b = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void m2802a(int i) {
        if (i >= 0) {
            mo17303d(i);
        } else {
            mo17302c((long) i);
        }
    }

    /* renamed from: a */
    public void m2803a(int i, int i2) {
        mo17301c(i, 0);
        mo17281a(i2);
    }

    /* renamed from: a */
    public void m2804a(int i, long j) {
        mo17301c(i, 0);
        mo17288a(j);
    }

    /* renamed from: a */
    public void m2805a(int i, C1607a aVar) {
        mo17301c(i, 2);
        mo17289a(aVar);
    }

    /* renamed from: a */
    public void m2806a(int i, C1742e eVar) {
        mo17301c(i, 2);
        mo17290a(eVar);
    }

    /* renamed from: a */
    public void m2807a(int i, String str) {
        mo17301c(i, 2);
        mo17291a(str);
    }

    /* renamed from: a */
    public void m2808a(int i, boolean z) {
        mo17301c(i, 0);
        mo17292a(z);
    }

    /* renamed from: a */
    public void m2809a(long j) {
        mo17302c(j);
    }

    /* renamed from: a */
    public void m2810a(C1607a aVar) {
        byte[] a = aVar.mo17208a();
        mo17303d(a.length);
        mo17293a(a);
    }

    /* renamed from: a */
    public void m2811a(C1742e eVar) {
        mo17303d(eVar.mo17407a());
        eVar.mo17411a(this);
    }

    /* renamed from: a */
    public void m2812a(String str) {
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        mo17303d(bytes.length);
        mo17293a(bytes);
    }

    /* renamed from: a */
    public void m2813a(boolean z) {
        mo17300c(z ? 1 : 0);
    }

    /* renamed from: a */
    public void mo17293a(byte[] bArr) {
        mo17294a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m2815a(byte[] bArr, int i, int i2) {
        int i3 = this.f1906a;
        int i4 = this.f1909b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f1908a, i4, i2);
            this.f1909b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f1908a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f1909b = this.f1906a;
        m2797c();
        if (i7 <= this.f1906a) {
            System.arraycopy(bArr, i6, this.f1908a, 0, i7);
            this.f1909b = i7;
            return;
        }
        this.f1907a.write(bArr, i6, i7);
    }

    /* renamed from: b */
    public void mo17295b() {
        if (mo17279a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: b */
    public void m2817b(int i) {
        mo17303d(i);
    }

    /* renamed from: b */
    public void m2818b(int i, int i2) {
        mo17301c(i, 0);
        mo17296b(i2);
    }

    /* renamed from: b */
    public void m2819b(int i, long j) {
        mo17301c(i, 0);
        mo17299b(j);
    }

    /* renamed from: b */
    public void m2820b(long j) {
        mo17302c(j);
    }

    /* renamed from: c */
    public void m2821c(int i) {
        mo17280a((byte) i);
    }

    /* renamed from: c */
    public void mo17301c(int i, int i2) {
        mo17303d(C1782f.m3469a(i, i2));
    }

    /* renamed from: c */
    public void m2823c(long j) {
        while ((-128 & j) != 0) {
            mo17300c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        mo17300c((int) j);
    }

    /* renamed from: d */
    public void m2824d(int i) {
        while ((i & -128) != 0) {
            mo17300c((i & 127) | 128);
            i >>>= 7;
        }
        mo17300c(i);
    }
}
