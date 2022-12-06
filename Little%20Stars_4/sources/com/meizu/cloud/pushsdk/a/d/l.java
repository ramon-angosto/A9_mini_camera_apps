package com.meizu.cloud.pushsdk.a.d;

import com.meizu.cloud.pushsdk.a.h.c;
import java.io.Closeable;
import java.io.InputStream;

public abstract class l implements Closeable {
    public abstract c a();

    public final InputStream b() {
        return a().d();
    }

    public void close() {
        m.a((Closeable) a());
    }
}
