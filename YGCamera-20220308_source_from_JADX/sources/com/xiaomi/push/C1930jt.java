package com.xiaomi.push;

/* renamed from: com.xiaomi.push.jt */
public final class C1930jt extends C1931ju {

    /* renamed from: a */
    private int f3549a;

    /* renamed from: a */
    private byte[] f3550a;

    /* renamed from: b */
    private int f3551b;

    /* renamed from: a */
    public int mo18360a() {
        return this.f3549a;
    }

    /* renamed from: a */
    public int mo18358a(byte[] bArr, int i, int i2) {
        int b = mo18363b();
        if (i2 > b) {
            i2 = b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f3550a, this.f3549a, bArr, i, i2);
            mo18361a(i2);
        }
        return i2;
    }

    /* renamed from: a */
    public void mo18361a(int i) {
        this.f3549a += i;
    }

    /* renamed from: a */
    public void mo18362a(byte[] bArr) {
        mo18364b(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m4698a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    /* renamed from: a */
    public byte[] m4699a() {
        return this.f3550a;
    }

    /* renamed from: b */
    public int mo18363b() {
        return this.f3551b - this.f3549a;
    }

    /* renamed from: b */
    public void mo18364b(byte[] bArr, int i, int i2) {
        this.f3550a = bArr;
        this.f3549a = i;
        this.f3551b = i + i2;
    }
}
