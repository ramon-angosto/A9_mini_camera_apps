package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ju */
public abstract class C1931ju {
    /* renamed from: a */
    public int mo18360a() {
        return 0;
    }

    /* renamed from: a */
    public abstract int mo18358a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public void mo18361a(int i) {
    }

    /* renamed from: a */
    public abstract void m4705a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public byte[] m4706a() {
        return null;
    }

    /* renamed from: b */
    public int mo18363b() {
        return -1;
    }

    /* renamed from: b */
    public int mo18364b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = mo18358a(bArr, i + i3, i2 - i3);
            if (a > 0) {
                i3 += a;
            } else {
                throw new C1932jv("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
        }
        return i3;
    }
}
