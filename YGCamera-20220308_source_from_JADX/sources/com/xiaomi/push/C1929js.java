package com.xiaomi.push;

/* renamed from: com.xiaomi.push.js */
public class C1929js extends C1931ju {

    /* renamed from: a */
    private int f3547a;

    /* renamed from: a */
    private C1911jc f3548a;

    public C1929js(int i) {
        this.f3548a = new C1911jc(i);
    }

    /* renamed from: a */
    public int mo18358a(byte[] bArr, int i, int i2) {
        byte[] a = this.f3548a.mo18329a();
        if (i2 > this.f3548a.mo18329a() - this.f3547a) {
            i2 = this.f3548a.mo18329a() - this.f3547a;
        }
        if (i2 > 0) {
            System.arraycopy(a, this.f3547a, bArr, i, i2);
            this.f3547a += i2;
        }
        return i2;
    }

    /* renamed from: a */
    public void m4692a(byte[] bArr, int i, int i2) {
        this.f3548a.write(bArr, i, i2);
    }

    /* renamed from: a_ */
    public int mo18359a_() {
        return this.f3548a.size();
    }
}
