package com.meizu.cloud.pushsdk.a.h;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;

final class h implements c {
    public final a a;
    public final l b;
    /* access modifiers changed from: private */
    public boolean c;

    public h(l lVar, a aVar) {
        if (lVar != null) {
            this.a = aVar;
            this.b = lVar;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public h(l lVar) {
        this(lVar, new a());
    }

    public long b(a aVar, long j) throws IOException {
        if (aVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.b(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
            return -1;
        } else {
            return this.a.b(aVar, Math.min(j, this.a.b));
        }
    }

    public byte[] i() throws IOException {
        this.a.a(this.b);
        return this.a.i();
    }

    public String h() throws IOException {
        this.a.a(this.b);
        return this.a.h();
    }

    public InputStream d() {
        return new InputStream() {
            public int read() throws IOException {
                if (h.this.c) {
                    throw new IOException("closed");
                } else if (h.this.a.b == 0 && h.this.b.b(h.this.a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                    return -1;
                } else {
                    return h.this.a.f() & 255;
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!h.this.c) {
                    n.a((long) bArr.length, (long) i, (long) i2);
                    if (h.this.a.b == 0 && h.this.b.b(h.this.a, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) == -1) {
                        return -1;
                    }
                    return h.this.a.a(bArr, i, i2);
                }
                throw new IOException("closed");
            }

            public int available() throws IOException {
                if (!h.this.c) {
                    return (int) Math.min(h.this.a.b, 2147483647L);
                }
                throw new IOException("closed");
            }

            public void close() throws IOException {
                h.this.close();
            }

            public String toString() {
                return h.this + ".inputStream()";
            }
        };
    }

    public void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.j();
        }
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
