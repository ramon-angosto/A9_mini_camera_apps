package com.meizu.cloud.pushsdk.a.h;

final class i {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    i f;
    i g;

    i() {
        this.a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    i(i iVar) {
        this(iVar.a, iVar.b, iVar.c);
        iVar.d = true;
    }

    i(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public i a() {
        i iVar = this.f;
        if (iVar == this) {
            iVar = null;
        }
        i iVar2 = this.g;
        iVar2.f = this.f;
        this.f.g = iVar2;
        this.f = null;
        this.g = null;
        return iVar;
    }

    public i a(i iVar) {
        iVar.g = this;
        iVar.f = this.f;
        this.f.g = iVar;
        this.f = iVar;
        return iVar;
    }

    public i a(int i) {
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        i iVar = new i(this);
        iVar.c = iVar.b + i;
        this.b += i;
        this.g.a(iVar);
        return iVar;
    }

    public void b() {
        i iVar = this.g;
        if (iVar == this) {
            throw new IllegalStateException();
        } else if (iVar.e) {
            int i = this.c - this.b;
            if (i <= (2048 - iVar.c) + (iVar.d ? 0 : iVar.b)) {
                a(this.g, i);
                a();
                j.a(this);
            }
        }
    }

    public void a(i iVar, int i) {
        if (iVar.e) {
            int i2 = iVar.c;
            if (i2 + i > 2048) {
                if (!iVar.d) {
                    int i3 = iVar.b;
                    if ((i2 + i) - i3 <= 2048) {
                        byte[] bArr = iVar.a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        iVar.c -= iVar.b;
                        iVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, iVar.a, iVar.c, i);
            iVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
