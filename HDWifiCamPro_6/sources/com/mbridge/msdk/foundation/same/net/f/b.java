package com.mbridge.msdk.foundation.same.net.f;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse */
public final class b {
    private final int a;
    private final List<com.mbridge.msdk.foundation.same.net.c.b> b;
    private final InputStream c;

    public b(int i, List<com.mbridge.msdk.foundation.same.net.c.b> list, InputStream inputStream) {
        this.a = i;
        this.b = list;
        this.c = inputStream;
    }

    public final int a() {
        return this.a;
    }

    public final List<com.mbridge.msdk.foundation.same.net.c.b> b() {
        return Collections.unmodifiableList(this.b);
    }

    public final InputStream c() {
        return this.c;
    }
}
