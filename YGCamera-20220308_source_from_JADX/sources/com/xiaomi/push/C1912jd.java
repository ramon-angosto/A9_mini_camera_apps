package com.xiaomi.push;

import com.xiaomi.push.C1915jg;

/* renamed from: com.xiaomi.push.jd */
public class C1912jd {

    /* renamed from: a */
    private final C1920jk f3505a;

    /* renamed from: a */
    private final C1930jt f3506a;

    public C1912jd() {
        this(new C1915jg.C1916a());
    }

    public C1912jd(C1922jm jmVar) {
        this.f3506a = new C1930jt();
        this.f3505a = jmVar.mo18355a(this.f3506a);
    }

    /* renamed from: a */
    public void mo18330a(C1906iz izVar, byte[] bArr) {
        try {
            this.f3506a.mo18362a(bArr);
            izVar.mo17579a(this.f3505a);
        } finally {
            this.f3505a.mo18357k();
        }
    }
}
