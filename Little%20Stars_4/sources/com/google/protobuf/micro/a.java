package com.google.protobuf.micro;

import java.io.InputStream;
import java.util.Vector;

public final class a {
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private final InputStream e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    private a(InputStream inputStream) {
        this.h = Integer.MAX_VALUE;
        this.i = 64;
        this.j = 67108864;
        this.a = new byte[4096];
        this.b = 0;
        this.d = 0;
        this.e = inputStream;
    }

    private a(byte[] bArr, int i2, int i3) {
        this.h = Integer.MAX_VALUE;
        this.i = 64;
        this.j = 67108864;
        this.a = bArr;
        this.b = i3 + i2;
        this.d = i2;
        this.e = null;
    }

    public static a a(InputStream inputStream) {
        return new a(inputStream);
    }

    public static a a(byte[] bArr, int i2, int i3) {
        return new a(bArr, i2, i3);
    }

    private boolean a(boolean z) {
        int i2 = this.d;
        int i3 = this.b;
        if (i2 >= i3) {
            int i4 = this.g;
            if (i4 + i3 != this.h) {
                this.g = i4 + i3;
                this.d = 0;
                InputStream inputStream = this.e;
                this.b = inputStream == null ? -1 : inputStream.read(this.a);
                int i5 = this.b;
                if (i5 == 0 || i5 < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
                } else if (i5 == -1) {
                    this.b = 0;
                    if (!z) {
                        return false;
                    }
                    throw c.a();
                } else {
                    l();
                    int i6 = this.g + this.b + this.c;
                    if (i6 <= this.j && i6 >= 0) {
                        return true;
                    }
                    throw c.g();
                }
            } else if (!z) {
                return false;
            } else {
                throw c.a();
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
    }

    private void l() {
        this.b += this.c;
        int i2 = this.g;
        int i3 = this.b;
        int i4 = i2 + i3;
        int i5 = this.h;
        if (i4 > i5) {
            this.c = i4 - i5;
            this.b = i3 - this.c;
            return;
        }
        this.c = 0;
    }

    public int a() {
        if (j()) {
            this.f = 0;
            return 0;
        }
        this.f = g();
        int i2 = this.f;
        if (i2 != 0) {
            return i2;
        }
        throw c.d();
    }

    public void a(int i2) {
        if (this.f != i2) {
            throw c.e();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void b() {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.a()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.b(r0)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.micro.a.b():void");
    }

    public boolean b(int i2) {
        int a2 = e.a(i2);
        if (a2 == 0) {
            c();
            return true;
        } else if (a2 == 1) {
            i();
            return true;
        } else if (a2 == 2) {
            d(g());
            return true;
        } else if (a2 == 3) {
            b();
            a(e.a(e.b(i2), 4));
            return true;
        } else if (a2 == 4) {
            return false;
        } else {
            if (a2 == 5) {
                h();
                return true;
            }
            throw c.f();
        }
    }

    public int c() {
        return g();
    }

    public byte[] c(int i2) {
        if (i2 >= 0) {
            int i3 = this.g;
            int i4 = this.d;
            int i5 = i3 + i4 + i2;
            int i6 = this.h;
            if (i5 <= i6) {
                int i7 = this.b;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a, i4, bArr, 0, i2);
                    this.d += i2;
                    return bArr;
                } else if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.a, i4, bArr2, 0, i8);
                    this.d = this.b;
                    while (true) {
                        a(true);
                        int i9 = i2 - i8;
                        int i10 = this.b;
                        if (i9 > i10) {
                            System.arraycopy(this.a, 0, bArr2, i8, i10);
                            int i11 = this.b;
                            i8 += i11;
                            this.d = i11;
                        } else {
                            System.arraycopy(this.a, 0, bArr2, i8, i9);
                            this.d = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.g = i3 + i7;
                    this.d = 0;
                    this.b = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    Vector vector = new Vector();
                    while (i13 > 0) {
                        byte[] bArr3 = new byte[Math.min(i13, 4096)];
                        int i14 = 0;
                        while (i14 < bArr3.length) {
                            InputStream inputStream = this.e;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, bArr3.length - i14);
                            if (read != -1) {
                                this.g += read;
                                i14 += read;
                            } else {
                                throw c.a();
                            }
                        }
                        i13 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.a, i4, bArr4, 0, i12);
                    for (int i15 = 0; i15 < vector.size(); i15++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i15);
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                d((i6 - i3) - i4);
                throw c.a();
            }
        } else {
            throw c.b();
        }
    }

    public void d(int i2) {
        if (i2 >= 0) {
            int i3 = this.g;
            int i4 = this.d;
            int i5 = i3 + i4 + i2;
            int i6 = this.h;
            if (i5 <= i6) {
                int i7 = this.b;
                if (i2 <= i7 - i4) {
                    this.d = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.g = i3 + i7;
                this.d = 0;
                this.b = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.e;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip((long) (i2 - i8));
                    if (skip > 0) {
                        i8 += skip;
                        this.g += skip;
                    } else {
                        throw c.a();
                    }
                }
                return;
            }
            d((i6 - i3) - i4);
            throw c.a();
        }
        throw c.b();
    }

    public boolean d() {
        return g() != 0;
    }

    public String e() {
        int g2 = g();
        int i2 = this.b;
        int i3 = this.d;
        if (g2 > i2 - i3 || g2 <= 0) {
            return new String(c(g2), "UTF-8");
        }
        String str = new String(this.a, i3, g2, "UTF-8");
        this.d += g2;
        return str;
    }

    public int f() {
        return g();
    }

    public int g() {
        int i2;
        byte k = k();
        if (k >= 0) {
            return k;
        }
        byte b2 = k & Byte.MAX_VALUE;
        byte k2 = k();
        if (k2 >= 0) {
            i2 = k2 << 7;
        } else {
            b2 |= (k2 & Byte.MAX_VALUE) << 7;
            byte k3 = k();
            if (k3 >= 0) {
                i2 = k3 << 14;
            } else {
                b2 |= (k3 & Byte.MAX_VALUE) << 14;
                byte k4 = k();
                if (k4 >= 0) {
                    i2 = k4 << 21;
                } else {
                    byte b3 = b2 | ((k4 & Byte.MAX_VALUE) << 21);
                    byte k5 = k();
                    byte b4 = b3 | (k5 << 28);
                    if (k5 >= 0) {
                        return b4;
                    }
                    for (int i3 = 0; i3 < 5; i3++) {
                        if (k() >= 0) {
                            return b4;
                        }
                    }
                    throw c.c();
                }
            }
        }
        return b2 | i2;
    }

    public int h() {
        return (k() & 255) | ((k() & 255) << 8) | ((k() & 255) << 16) | ((k() & 255) << 24);
    }

    public long i() {
        byte k = k();
        byte k2 = k();
        return ((((long) k2) & 255) << 8) | (((long) k) & 255) | ((((long) k()) & 255) << 16) | ((((long) k()) & 255) << 24) | ((((long) k()) & 255) << 32) | ((((long) k()) & 255) << 40) | ((((long) k()) & 255) << 48) | ((((long) k()) & 255) << 56);
    }

    public boolean j() {
        return this.d == this.b && !a(false);
    }

    public byte k() {
        if (this.d == this.b) {
            a(true);
        }
        byte[] bArr = this.a;
        int i2 = this.d;
        this.d = i2 + 1;
        return bArr[i2];
    }
}
