package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.f.c;
import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import java.io.File;

/* compiled from: FileDownloadRequest */
public class a extends i<Void> {
    private static final String c = a.class.getSimpleName();
    private File d;
    private File e;

    public final int g() {
        return 1;
    }

    public a(File file, String str) {
        super(0, str);
        this.d = file;
        this.e = new File(file + ".tmp");
    }

    /* access modifiers changed from: protected */
    public final k<Void> a(c cVar) {
        if (c()) {
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(-2, cVar));
        }
        if (!this.e.canRead() || this.e.length() <= 0) {
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(4, cVar));
        }
        if (this.e.renameTo(this.d)) {
            return k.a(null, cVar);
        }
        return k.a(new com.mbridge.msdk.foundation.same.net.a.a(4, cVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ab A[SYNTHETIC, Splitter:B:44:0x00ab] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(com.mbridge.msdk.foundation.same.net.f.b r14, com.mbridge.msdk.foundation.same.net.c r15) throws java.io.IOException {
        /*
            r13 = this;
            java.util.List r0 = r14.b()
            java.lang.String r1 = "Content-Length"
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.g.b.a(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L_0x001b
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r0 = r0.longValue()
            goto L_0x001c
        L_0x001b:
            r0 = r2
        L_0x001c:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x0027
            java.lang.String r5 = c
            java.lang.String r6 = "Response doesn't present Content-Length!"
            com.mbridge.msdk.foundation.tools.q.b(r5, r6)
        L_0x0027:
            r10 = 0
            if (r4 <= 0) goto L_0x0043
            java.io.File r4 = r13.d
            long r4 = r4.length()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x0043
            java.io.File r14 = r13.d
            java.io.File r2 = r13.e
            r14.renameTo(r2)
            r4 = r15
            r5 = r13
            r6 = r0
            r8 = r0
            r4.a(r5, r6, r8)
            return r10
        L_0x0043:
            java.io.RandomAccessFile r11 = new java.io.RandomAccessFile
            java.io.File r4 = r13.e
            java.lang.String r4 = r4.getAbsolutePath()
            java.lang.String r5 = "rw"
            r11.<init>(r4, r5)
            r11.setLength(r2)
            java.io.InputStream r4 = r14.c()     // Catch:{ all -> 0x00a7 }
            java.util.List r14 = r14.b()     // Catch:{ all -> 0x00a5 }
            boolean r14 = com.mbridge.msdk.foundation.same.net.g.b.b(r14)     // Catch:{ all -> 0x00a5 }
            if (r14 == 0) goto L_0x006b
            boolean r14 = r4 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x00a5 }
            if (r14 != 0) goto L_0x006b
            java.util.zip.GZIPInputStream r14 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x00a5 }
            r14.<init>(r4)     // Catch:{ all -> 0x00a5 }
            goto L_0x006c
        L_0x006b:
            r14 = r4
        L_0x006c:
            r4 = 6144(0x1800, float:8.61E-42)
            byte[] r12 = new byte[r4]     // Catch:{ all -> 0x00a1 }
        L_0x0070:
            int r4 = r14.read(r12)     // Catch:{ all -> 0x00a1 }
            r5 = -1
            if (r4 == r5) goto L_0x008d
            r5 = 0
            r11.write(r12, r5, r4)     // Catch:{ all -> 0x00a1 }
            long r4 = (long) r4     // Catch:{ all -> 0x00a1 }
            long r2 = r2 + r4
            r4 = r15
            r5 = r13
            r6 = r0
            r8 = r2
            r4.a(r5, r6, r8)     // Catch:{ all -> 0x00a1 }
            boolean r4 = r13.c()     // Catch:{ all -> 0x00a1 }
            if (r4 == 0) goto L_0x0070
            r15.b(r13)     // Catch:{ all -> 0x00a1 }
        L_0x008d:
            if (r14 == 0) goto L_0x009d
            r14.close()     // Catch:{ Exception -> 0x0093 }
            goto L_0x009d
        L_0x0093:
            r14 = move-exception
            java.lang.String r15 = c
            java.lang.String r14 = r14.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r15, r14)
        L_0x009d:
            r11.close()
            return r10
        L_0x00a1:
            r15 = move-exception
            r4 = r14
            r14 = r15
            goto L_0x00a9
        L_0x00a5:
            r14 = move-exception
            goto L_0x00a9
        L_0x00a7:
            r14 = move-exception
            r4 = r10
        L_0x00a9:
            if (r4 == 0) goto L_0x00b9
            r4.close()     // Catch:{ Exception -> 0x00af }
            goto L_0x00b9
        L_0x00af:
            r15 = move-exception
            java.lang.String r0 = c
            java.lang.String r15 = r15.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r0, r15)
        L_0x00b9:
            r11.close()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.d.a.a(com.mbridge.msdk.foundation.same.net.f.b, com.mbridge.msdk.foundation.same.net.c):byte[]");
    }
}
