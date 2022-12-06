package com.huawei.android.pushagent.a.b;

public class a {
    private String a;
    private byte[] b;
    private byte[] c;

    public a(String str, byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            this.a = str;
            this.b = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.b, 0, bArr.length);
            this.c = new byte[bArr2.length];
            System.arraycopy(bArr2, 0, this.c, 0, bArr2.length);
        }
    }

    public String a() {
        return this.a;
    }

    public byte[] b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }
}
