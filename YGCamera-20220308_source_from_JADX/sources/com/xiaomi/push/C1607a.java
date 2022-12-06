package com.xiaomi.push;

/* renamed from: com.xiaomi.push.a */
public final class C1607a {

    /* renamed from: a */
    public static final C1607a f1750a = new C1607a(new byte[0]);

    /* renamed from: a */
    private volatile int f1751a = 0;

    /* renamed from: a */
    private final byte[] f1752a;

    private C1607a(byte[] bArr) {
        this.f1752a = bArr;
    }

    /* renamed from: a */
    public static C1607a m2486a(byte[] bArr) {
        return m2487a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static C1607a m2487a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C1607a(bArr2);
    }

    /* renamed from: a */
    public int mo17208a() {
        return this.f1752a.length;
    }

    /* renamed from: a */
    public byte[] m2489a() {
        byte[] bArr = this.f1752a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1607a)) {
            return false;
        }
        byte[] bArr = this.f1752a;
        int length = bArr.length;
        byte[] bArr2 = ((C1607a) obj).f1752a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f1751a;
        if (i == 0) {
            int i2 = r1;
            for (byte b : this.f1752a) {
                i2 = (i2 * 31) + b;
            }
            i = i2 == 0 ? 1 : i2;
            this.f1751a = i;
        }
        return i;
    }
}
