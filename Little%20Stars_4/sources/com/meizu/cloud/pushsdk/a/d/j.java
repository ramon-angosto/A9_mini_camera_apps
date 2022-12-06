package com.meizu.cloud.pushsdk.a.d;

import com.meizu.cloud.pushsdk.a.h.b;
import com.meizu.cloud.pushsdk.a.h.f;
import com.meizu.cloud.pushsdk.a.h.l;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class j {
    public abstract g a();

    public abstract void a(b bVar) throws IOException;

    public long b() throws IOException {
        return -1;
    }

    public static j a(g gVar, String str) {
        Charset charset = m.c;
        if (gVar != null && (charset = gVar.b()) == null) {
            charset = m.c;
            gVar = g.a(gVar + "; charset=utf-8");
        }
        return a(gVar, str.getBytes(charset));
    }

    public static j a(g gVar, byte[] bArr) {
        return a(gVar, bArr, 0, bArr.length);
    }

    public static j a(final g gVar, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            m.a((long) bArr.length, (long) i, (long) i2);
            return new j() {
                public g a() {
                    return gVar;
                }

                public long b() {
                    return (long) i2;
                }

                public void a(b bVar) throws IOException {
                    bVar.c(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static j a(final g gVar, final File file) {
        if (file != null) {
            return new j() {
                public g a() {
                    return gVar;
                }

                public long b() {
                    return file.length();
                }

                public void a(b bVar) throws IOException {
                    l lVar = null;
                    try {
                        lVar = f.a(file);
                        bVar.a(lVar);
                    } finally {
                        m.a((Closeable) lVar);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
