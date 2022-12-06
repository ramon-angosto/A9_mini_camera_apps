package com.xiaomi.push;

import java.io.IOException;

/* renamed from: com.xiaomi.push.e */
public abstract class C1742e {
    /* renamed from: a */
    public abstract int mo17407a();

    /* renamed from: a */
    public abstract C1742e mo17408a(C1641b bVar);

    /* renamed from: a */
    public C1742e mo17409a(byte[] bArr) {
        return mo17410a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public C1742e mo17410a(byte[] bArr, int i, int i2) {
        try {
            C1641b a = C1641b.m2609a(bArr, i, i2);
            mo17408a(a);
            a.mo17242a(0);
            return this;
        } catch (C1711d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: a */
    public abstract void mo17411a(C1675c cVar);

    /* renamed from: a */
    public void m3074a(byte[] bArr, int i, int i2) {
        try {
            C1675c a = C1675c.mo17294a(bArr, i, i2);
            mo17411a(a);
            a.mo17295b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo17412a(C1641b bVar, int i) {
        return bVar.mo17242a(i);
    }

    /* renamed from: a */
    public byte[] m3076a() {
        byte[] bArr = new byte[mo17413b()];
        mo17410a(bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: b */
    public abstract int mo17413b();
}
