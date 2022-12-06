package com.bytedance.sdk.component.d.c.a.b;

import com.bytedance.sdk.component.d.r;

/* compiled from: LruCountRawCache */
public class c implements r {
    private int a;
    private int b;
    private int c;
    private com.bytedance.sdk.component.d.c.a.c<String, byte[]> d;

    public c(int i, int i2) {
        this.c = i;
        this.a = i2;
        this.d = new com.bytedance.sdk.component.d.c.a.c<String, byte[]>(i) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int b(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    public boolean a(String str, byte[] bArr) {
        int i = this.b;
        int i2 = this.a;
        if (str == null || bArr == null) {
            return false;
        }
        this.d.a(str, bArr);
        return true;
    }

    public byte[] a(String str) {
        return this.d.a(str);
    }

    public boolean b(String str) {
        return this.d.a(str) != null;
    }
}
