package com.xiaomi.push;

import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.fp */
public final class C1803fp extends C1793fj {
    public C1803fp() {
        mo17620a("PING", (String) null);
        mo17619a("0");
        mo17617a(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ByteBuffer mo17616a(ByteBuffer byteBuffer) {
        return mo17615a().length == 0 ? byteBuffer : super.mo17616a(byteBuffer);
    }

    /* renamed from: c */
    public int mo17625c() {
        if (mo17615a().length == 0) {
            return 0;
        }
        return super.mo17625c();
    }
}
