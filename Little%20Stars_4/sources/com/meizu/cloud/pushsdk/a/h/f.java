package com.meizu.cloud.pushsdk.a.h;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public final class f {
    private static final Logger a = Logger.getLogger(f.class.getName());

    private f() {
    }

    public static c a(l lVar) {
        if (lVar != null) {
            return new h(lVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static b a(k kVar) {
        if (kVar != null) {
            return new g(kVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static k a(OutputStream outputStream) {
        return a(outputStream, new m());
    }

    private static k a(final OutputStream outputStream, final m mVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (mVar != null) {
            return new k() {
                public void a(a aVar, long j) throws IOException {
                    n.a(aVar.b, 0, j);
                    while (j > 0) {
                        mVar.a();
                        i iVar = aVar.a;
                        int min = (int) Math.min(j, (long) (iVar.c - iVar.b));
                        outputStream.write(iVar.a, iVar.b, min);
                        iVar.b += min;
                        long j2 = (long) min;
                        j -= j2;
                        aVar.b -= j2;
                        if (iVar.b == iVar.c) {
                            aVar.a = iVar.a();
                            j.a(iVar);
                        }
                    }
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public void close() throws IOException {
                    outputStream.close();
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static l a(InputStream inputStream) {
        return a(inputStream, new m());
    }

    private static l a(final InputStream inputStream, final m mVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (mVar != null) {
            return new l() {
                public long b(a aVar, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    } else if (j == 0) {
                        return 0;
                    } else {
                        mVar.a();
                        i c = aVar.c(1);
                        int read = inputStream.read(c.a, c.c, (int) Math.min(j, (long) (2048 - c.c)));
                        if (read == -1) {
                            return -1;
                        }
                        c.c += read;
                        long j2 = (long) read;
                        aVar.b += j2;
                        return j2;
                    }
                }

                public void close() throws IOException {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static l a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }
}
