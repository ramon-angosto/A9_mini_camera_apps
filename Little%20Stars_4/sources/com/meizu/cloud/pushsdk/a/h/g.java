package com.meizu.cloud.pushsdk.a.h;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

final class g implements b {
    public final a a;
    public final k b;
    private boolean c;

    public g(k kVar, a aVar) {
        if (kVar != null) {
            this.a = aVar;
            this.b = kVar;
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public g(k kVar) {
        this(kVar, new a());
    }

    public a b() {
        return this.a;
    }

    public void a(a aVar, long j) throws IOException {
        if (!this.c) {
            this.a.a(aVar, j);
            a();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public b b(d dVar) throws IOException {
        if (!this.c) {
            this.a.b(dVar);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    public b b(String str) throws IOException {
        if (!this.c) {
            this.a.b(str);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    public b c(byte[] bArr) throws IOException {
        if (!this.c) {
            this.a.c(bArr);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    public b c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.c) {
            this.a.c(bArr, i, i2);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    public long a(l lVar) throws IOException {
        if (lVar != null) {
            long j = 0;
            while (true) {
                long b2 = lVar.b(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
                if (b2 == -1) {
                    return j;
                }
                j += b2;
                a();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public b e(long j) throws IOException {
        if (!this.c) {
            this.a.e(j);
            return a();
        }
        throw new IllegalStateException("closed");
    }

    public b a() throws IOException {
        if (!this.c) {
            long e = this.a.e();
            if (e > 0) {
                this.b.a(this.a, e);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public void flush() throws IOException {
        if (!this.c) {
            if (this.a.b > 0) {
                k kVar = this.b;
                a aVar = this.a;
                kVar.a(aVar, aVar.b);
            }
            this.b.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                n.a(th);
            }
        }
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
