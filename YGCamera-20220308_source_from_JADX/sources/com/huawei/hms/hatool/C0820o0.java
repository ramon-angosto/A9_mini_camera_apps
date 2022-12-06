package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.o0 */
public class C0820o0 {

    /* renamed from: a */
    public byte[] f724a = null;

    /* renamed from: b */
    public int f725b = 0;

    public C0820o0(int i) {
        this.f724a = new byte[i];
    }

    /* renamed from: a */
    public void mo14090a(byte[] bArr, int i) {
        if (i > 0) {
            byte[] bArr2 = this.f724a;
            int length = bArr2.length;
            int i2 = this.f725b;
            if (length - i2 >= i) {
                System.arraycopy(bArr, 0, bArr2, i2, i);
            } else {
                byte[] bArr3 = new byte[((bArr2.length + i) << 1)];
                System.arraycopy(bArr2, 0, bArr3, 0, i2);
                System.arraycopy(bArr, 0, bArr3, this.f725b, i);
                this.f724a = bArr3;
            }
            this.f725b += i;
        }
    }

    /* renamed from: a */
    public byte[] mo14091a() {
        int i = this.f725b;
        if (i <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f724a, 0, bArr, 0, i);
        return bArr;
    }

    /* renamed from: b */
    public int mo14092b() {
        return this.f725b;
    }
}
