package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f.c;

/* compiled from: Response */
public final class k<T> {
    public T a = null;
    public a b = null;
    public c c = null;

    public static <T> k<T> a(T t, c cVar) {
        return new k<>(t, cVar);
    }

    public static <T> k<T> a(a aVar) {
        return new k<>(aVar);
    }

    private k(T t, c cVar) {
        this.a = t;
        this.c = cVar;
    }

    private k(a aVar) {
        this.b = aVar;
    }
}
