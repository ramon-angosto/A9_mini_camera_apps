package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public abstract class RequestBody {
    public long contentLength() throws IOException {
        return -1;
    }

    @Nullable
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = StandardCharsets.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            @Nullable
            public MediaType contentType() {
                return MediaType.this;
            }

            public long contentLength() throws IOException {
                return (long) byteString.size();
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return (long) i2;
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.write(bArr, i, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(@Nullable final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return file.length();
                }

                /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
                    r0.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
                    r3.addSuppressed(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x001c, code lost:
                    throw r1;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
                    if (r0 != null) goto L_0x0014;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void writeTo(okio.BufferedSink r3) throws java.io.IOException {
                    /*
                        r2 = this;
                        java.io.File r0 = r2
                        okio.Source r0 = okio.Okio.source((java.io.File) r0)
                        r3.writeAll(r0)     // Catch:{ all -> 0x000f }
                        if (r0 == 0) goto L_0x000e
                        r0.close()
                    L_0x000e:
                        return
                    L_0x000f:
                        r3 = move-exception
                        throw r3     // Catch:{ all -> 0x0011 }
                    L_0x0011:
                        r1 = move-exception
                        if (r0 == 0) goto L_0x001c
                        r0.close()     // Catch:{ all -> 0x0018 }
                        goto L_0x001c
                    L_0x0018:
                        r0 = move-exception
                        r3.addSuppressed(r0)
                    L_0x001c:
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okhttp3.RequestBody.AnonymousClass3.writeTo(okio.BufferedSink):void");
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
