package com.huawei.updatesdk.p025a.p026a.p031d;

import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.updatesdk.a.a.d.b */
public class C0970b {

    /* renamed from: a */
    private byte[] f1305a;

    /* renamed from: b */
    private int f1306b;

    /* renamed from: c */
    private int f1307c;

    public C0970b() {
        this.f1305a = null;
        this.f1306b = 1024;
        this.f1307c = 0;
        this.f1305a = new byte[this.f1306b];
    }

    /* renamed from: a */
    public static String m1687a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return String.valueOf(cArr2);
    }

    /* renamed from: a */
    public String mo14883a() {
        int i = this.f1307c;
        if (i <= 0) {
            return null;
        }
        try {
            return new String(this.f1305a, 0, i, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo14884a(byte[] bArr, int i) {
        if (i > 0) {
            byte[] bArr2 = this.f1305a;
            int length = bArr2.length;
            int i2 = this.f1307c;
            if (length - i2 >= i) {
                System.arraycopy(bArr, 0, bArr2, i2, i);
            } else {
                byte[] bArr3 = new byte[((bArr2.length + i) << 1)];
                System.arraycopy(bArr2, 0, bArr3, 0, i2);
                System.arraycopy(bArr, 0, bArr3, this.f1307c, i);
                this.f1305a = bArr3;
            }
            this.f1307c += i;
        }
    }
}
