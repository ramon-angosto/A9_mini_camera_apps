package com.xiaomi.push;

import com.xiaomi.push.C1915jg;
import java.io.ByteArrayOutputStream;

/* renamed from: com.xiaomi.push.jf */
public class C1914jf {

    /* renamed from: a */
    private C1920jk f3507a;

    /* renamed from: a */
    private final C1928jr f3508a;

    /* renamed from: a */
    private final ByteArrayOutputStream f3509a;

    public C1914jf() {
        this(new C1915jg.C1916a());
    }

    public C1914jf(C1922jm jmVar) {
        this.f3509a = new ByteArrayOutputStream();
        this.f3508a = new C1928jr(this.f3509a);
        this.f3507a = jmVar.mo18355a(this.f3508a);
    }

    /* renamed from: a */
    public byte[] mo18331a(C1906iz izVar) {
        this.f3509a.reset();
        izVar.mo17583b(this.f3507a);
        return this.f3509a.toByteArray();
    }
}
