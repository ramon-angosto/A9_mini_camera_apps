package com.xiaomi.push;

import com.bumptech.glide.load.Key;
import com.xiaomi.push.C1915jg;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.jq */
public class C1926jq extends C1915jg {

    /* renamed from: b */
    private static int f3540b = 10000;

    /* renamed from: c */
    private static int f3541c = 10000;

    /* renamed from: d */
    private static int f3542d = 10000;

    /* renamed from: e */
    private static int f3543e = 10485760;

    /* renamed from: f */
    private static int f3544f = 104857600;

    /* renamed from: com.xiaomi.push.jq$a */
    public static class C1927a extends C1915jg.C1916a {
        public C1927a() {
            super(false, true);
        }

        public C1927a(boolean z, boolean z2, int i) {
            super(z, z2, i);
        }

        /* renamed from: a */
        public C1920jk mo18355a(C1931ju juVar) {
            C1926jq jqVar = new C1926jq(juVar, this.f3524a, this.f3525b);
            if (this.f3523a != 0) {
                jqVar.mo18345b(this.f3523a);
            }
            return jqVar;
        }
    }

    public C1926jq(C1931ju juVar, boolean z, boolean z2) {
        super(juVar, z, z2);
    }

    /* renamed from: a */
    public C1918ji mo18332a() {
        byte a = mo18332a();
        int a2 = mo18332a();
        if (a2 <= f3541c) {
            return new C1918ji(a, a2);
        }
        throw new C1921jl(3, "Thrift list size " + a2 + " out of range!");
    }

    /* renamed from: a */
    public C1919jj m4684a() {
        byte a = mo18332a();
        byte a2 = mo18332a();
        int a3 = mo18332a();
        if (a3 <= f3540b) {
            return new C1919jj(a, a2, a3);
        }
        throw new C1921jl(3, "Thrift map size " + a3 + " out of range!");
    }

    /* renamed from: a */
    public C1924jo m4685a() {
        byte a = mo18332a();
        int a2 = mo18332a();
        if (a2 <= f3542d) {
            return new C1924jo(a, a2);
        }
        throw new C1921jl(3, "Thrift set size " + a2 + " out of range!");
    }

    /* renamed from: a */
    public String m4686a() {
        int a = mo18332a();
        if (a > f3543e) {
            throw new C1921jl(3, "Thrift string size " + a + " out of range!");
        } else if (this.f3534a.mo18363b() < a) {
            return mo18333a(a);
        } else {
            try {
                String str = new String(this.f3534a.mo18360a(), this.f3534a.mo18360a(), a, Key.STRING_CHARSET_NAME);
                this.f3534a.mo18361a(a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new C1913je("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    /* renamed from: a */
    public ByteBuffer m4687a() {
        int a = mo18332a();
        if (a <= f3544f) {
            mo18347c(a);
            if (this.f3534a.mo18363b() >= a) {
                ByteBuffer wrap = ByteBuffer.wrap(this.f3534a.mo18360a(), this.f3534a.mo18360a(), a);
                this.f3534a.mo18361a(a);
                return wrap;
            }
            byte[] bArr = new byte[a];
            this.f3534a.mo18364b(bArr, 0, a);
            return ByteBuffer.wrap(bArr);
        }
        throw new C1921jl(3, "Thrift binary size " + a + " out of range!");
    }
}
