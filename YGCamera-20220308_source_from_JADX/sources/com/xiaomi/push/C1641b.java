package com.xiaomi.push;

import com.bumptech.glide.load.Key;
import java.io.InputStream;
import java.util.Vector;

/* renamed from: com.xiaomi.push.b */
public final class C1641b {

    /* renamed from: a */
    private int f1830a;

    /* renamed from: a */
    private final InputStream f1831a;

    /* renamed from: a */
    private final byte[] f1832a;

    /* renamed from: b */
    private int f1833b;

    /* renamed from: c */
    private int f1834c;

    /* renamed from: d */
    private int f1835d;

    /* renamed from: e */
    private int f1836e;

    /* renamed from: f */
    private int f1837f;

    /* renamed from: g */
    private int f1838g;

    /* renamed from: h */
    private int f1839h;

    /* renamed from: i */
    private int f1840i;

    private C1641b(InputStream inputStream) {
        this.f1837f = Integer.MAX_VALUE;
        this.f1839h = 64;
        this.f1840i = 67108864;
        this.f1832a = new byte[4096];
        this.f1830a = 0;
        this.f1834c = 0;
        this.f1831a = inputStream;
    }

    private C1641b(byte[] bArr, int i, int i2) {
        this.f1837f = Integer.MAX_VALUE;
        this.f1839h = 64;
        this.f1840i = 67108864;
        this.f1832a = bArr;
        this.f1830a = i2 + i;
        this.f1834c = i;
        this.f1831a = null;
    }

    /* renamed from: a */
    public static C1641b m2608a(InputStream inputStream) {
        return new C1641b(inputStream);
    }

    /* renamed from: a */
    public static C1641b m2609a(byte[] bArr, int i, int i2) {
        return new C1641b(bArr, i, i2);
    }

    /* renamed from: a */
    private boolean m2610a(boolean z) {
        int i = this.f1834c;
        int i2 = this.f1830a;
        if (i >= i2) {
            int i3 = this.f1836e;
            if (i3 + i2 != this.f1837f) {
                this.f1836e = i3 + i2;
                this.f1834c = 0;
                InputStream inputStream = this.f1831a;
                this.f1830a = inputStream == null ? -1 : inputStream.read(this.f1832a);
                int i4 = this.f1830a;
                if (i4 == 0 || i4 < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f1830a + "\nThe InputStream implementation is buggy.");
                } else if (i4 == -1) {
                    this.f1830a = 0;
                    if (!z) {
                        return false;
                    }
                    throw C1711d.m2958a();
                } else {
                    mo17244b();
                    int i5 = this.f1836e + this.f1830a + this.f1833b;
                    if (i5 <= this.f1840i && i5 >= 0) {
                        return true;
                    }
                    throw C1711d.m2965h();
                }
            } else if (!z) {
                return false;
            } else {
                throw C1711d.m2958a();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    /* renamed from: b */
    private void mo17244b() {
        this.f1830a += this.f1833b;
        int i = this.f1836e;
        int i2 = this.f1830a;
        int i3 = i + i2;
        int i4 = this.f1837f;
        if (i3 > i4) {
            this.f1833b = i3 - i4;
            this.f1830a = i2 - this.f1833b;
            return;
        }
        this.f1833b = 0;
    }

    /* renamed from: a */
    public byte mo17241a() {
        if (this.f1834c == this.f1830a) {
            m2610a(true);
        }
        byte[] bArr = this.f1832a;
        int i = this.f1834c;
        this.f1834c = i + 1;
        return bArr[i];
    }

    /* renamed from: a */
    public int m2613a() {
        if (mo17244b()) {
            this.f1835d = 0;
            return 0;
        }
        this.f1835d = mo17248d();
        int i = this.f1835d;
        if (i != 0) {
            return i;
        }
        throw C1711d.m2961d();
    }

    /* renamed from: a */
    public int mo17242a(int i) {
        if (i >= 0) {
            int i2 = i + this.f1836e + this.f1834c;
            int i3 = this.f1837f;
            if (i2 <= i3) {
                this.f1837f = i2;
                mo17244b();
                return i3;
            }
            throw C1711d.m2958a();
        }
        throw C1711d.m2959b();
    }

    /* renamed from: a */
    public long m2615a() {
        return mo17246c();
    }

    /* renamed from: a */
    public C1607a m2616a() {
        int d = mo17248d();
        int i = this.f1830a;
        int i2 = this.f1834c;
        if (d > i - i2 || d <= 0) {
            return C1607a.m2486a(mo17242a(d));
        }
        C1607a a = C1607a.m2487a(this.f1832a, i2, d);
        this.f1834c += d;
        return a;
    }

    /* renamed from: a */
    public String m2617a() {
        int d = mo17248d();
        int i = this.f1830a;
        int i2 = this.f1834c;
        if (d > i - i2 || d <= 0) {
            return new String(mo17242a(d), Key.STRING_CHARSET_NAME);
        }
        String str = new String(this.f1832a, i2, d, Key.STRING_CHARSET_NAME);
        this.f1834c += d;
        return str;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    public void m2618a() {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.mo17241a()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.mo17242a((int) r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1641b.m2618a():void");
    }

    /* renamed from: a */
    public void m2619a(int i) {
        if (this.f1835d != i) {
            throw C1711d.m2962e();
        }
    }

    /* renamed from: a */
    public void mo17243a(C1742e eVar) {
        int d = mo17248d();
        if (this.f1838g < this.f1839h) {
            int a = mo17242a(d);
            this.f1838g++;
            eVar.mo17408a(this);
            mo17242a(0);
            this.f1838g--;
            mo17245b(a);
            return;
        }
        throw C1711d.m2964g();
    }

    /* renamed from: a */
    public boolean m2621a() {
        return mo17248d() != 0;
    }

    /* renamed from: a */
    public boolean m2622a(int i) {
        int a = C1782f.m3468a(i);
        if (a == 0) {
            mo17244b();
            return true;
        } else if (a == 1) {
            mo17248d();
            return true;
        } else if (a == 2) {
            mo17247c(mo17248d());
            return true;
        } else if (a == 3) {
            mo17241a();
            mo17242a(C1782f.m3469a(C1782f.m3470b(i), 4));
            return true;
        } else if (a == 4) {
            return false;
        } else {
            if (a == 5) {
                mo17249e();
                return true;
            }
            throw C1711d.m2963f();
        }
    }

    /* renamed from: a */
    public byte[] m2623a(int i) {
        if (i >= 0) {
            int i2 = this.f1836e;
            int i3 = this.f1834c;
            int i4 = i2 + i3 + i;
            int i5 = this.f1837f;
            if (i4 <= i5) {
                int i6 = this.f1830a;
                if (i <= i6 - i3) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f1832a, i3, bArr, 0, i);
                    this.f1834c += i;
                    return bArr;
                } else if (i < 4096) {
                    byte[] bArr2 = new byte[i];
                    int i7 = i6 - i3;
                    System.arraycopy(this.f1832a, i3, bArr2, 0, i7);
                    this.f1834c = this.f1830a;
                    while (true) {
                        m2610a(true);
                        int i8 = i - i7;
                        int i9 = this.f1830a;
                        if (i8 > i9) {
                            System.arraycopy(this.f1832a, 0, bArr2, i7, i9);
                            int i10 = this.f1830a;
                            i7 += i10;
                            this.f1834c = i10;
                        } else {
                            System.arraycopy(this.f1832a, 0, bArr2, i7, i8);
                            this.f1834c = i8;
                            return bArr2;
                        }
                    }
                } else {
                    this.f1836e = i2 + i6;
                    this.f1834c = 0;
                    this.f1830a = 0;
                    int i11 = i6 - i3;
                    int i12 = i - i11;
                    Vector vector = new Vector();
                    while (i12 > 0) {
                        byte[] bArr3 = new byte[Math.min(i12, 4096)];
                        int i13 = 0;
                        while (i13 < bArr3.length) {
                            InputStream inputStream = this.f1831a;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i13, bArr3.length - i13);
                            if (read != -1) {
                                this.f1836e += read;
                                i13 += read;
                            } else {
                                throw C1711d.m2958a();
                            }
                        }
                        i12 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(this.f1832a, i3, bArr4, 0, i11);
                    for (int i14 = 0; i14 < vector.size(); i14++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i14);
                        System.arraycopy(bArr5, 0, bArr4, i11, bArr5.length);
                        i11 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                mo17247c((i5 - i2) - i3);
                throw C1711d.m2958a();
            }
        } else {
            throw C1711d.m2959b();
        }
    }

    /* renamed from: b */
    public int m2624b() {
        return mo17248d();
    }

    /* renamed from: b */
    public long m2625b() {
        return mo17246c();
    }

    /* renamed from: b */
    public void mo17245b(int i) {
        this.f1837f = i;
        mo17244b();
    }

    /* renamed from: b */
    public boolean m2627b() {
        return this.f1834c == this.f1830a && !m2610a(false);
    }

    /* renamed from: c */
    public int mo17246c() {
        return mo17248d();
    }

    /* renamed from: c */
    public long m2629c() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte a = mo17241a();
            j |= ((long) (a & Byte.MAX_VALUE)) << i;
            if ((a & 128) == 0) {
                return j;
            }
        }
        throw C1711d.m2960c();
    }

    /* renamed from: c */
    public void mo17247c(int i) {
        if (i >= 0) {
            int i2 = this.f1836e;
            int i3 = this.f1834c;
            int i4 = i2 + i3 + i;
            int i5 = this.f1837f;
            if (i4 <= i5) {
                int i6 = this.f1830a;
                if (i <= i6 - i3) {
                    this.f1834c = i3 + i;
                    return;
                }
                int i7 = i6 - i3;
                this.f1836e = i2 + i6;
                this.f1834c = 0;
                this.f1830a = 0;
                while (i7 < i) {
                    InputStream inputStream = this.f1831a;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i - i7));
                    if (skip > 0) {
                        i7 += skip;
                        this.f1836e += skip;
                    } else {
                        throw C1711d.m2958a();
                    }
                }
                return;
            }
            mo17247c((i5 - i2) - i3);
            throw C1711d.m2958a();
        }
        throw C1711d.m2959b();
    }

    /* renamed from: d */
    public int mo17248d() {
        int i;
        byte a = mo17241a();
        if (a >= 0) {
            return a;
        }
        byte b = a & Byte.MAX_VALUE;
        byte a2 = mo17241a();
        if (a2 >= 0) {
            i = a2 << 7;
        } else {
            b |= (a2 & Byte.MAX_VALUE) << 7;
            byte a3 = mo17241a();
            if (a3 >= 0) {
                i = a3 << 14;
            } else {
                b |= (a3 & Byte.MAX_VALUE) << 14;
                byte a4 = mo17241a();
                if (a4 >= 0) {
                    i = a4 << 21;
                } else {
                    byte b2 = b | ((a4 & Byte.MAX_VALUE) << 21);
                    byte a5 = mo17241a();
                    byte b3 = b2 | (a5 << 28);
                    if (a5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        if (mo17241a() >= 0) {
                            return b3;
                        }
                    }
                    throw C1711d.m2960c();
                }
            }
        }
        return b | i;
    }

    /* renamed from: d */
    public long m2632d() {
        byte a = mo17241a();
        byte a2 = mo17241a();
        return ((((long) a2) & 255) << 8) | (((long) a) & 255) | ((((long) mo17241a()) & 255) << 16) | ((((long) mo17241a()) & 255) << 24) | ((((long) mo17241a()) & 255) << 32) | ((((long) mo17241a()) & 255) << 40) | ((((long) mo17241a()) & 255) << 48) | ((((long) mo17241a()) & 255) << 56);
    }

    /* renamed from: e */
    public int mo17249e() {
        return (mo17241a() & 255) | ((mo17241a() & 255) << 8) | ((mo17241a() & 255) << 16) | ((mo17241a() & 255) << 24);
    }
}
