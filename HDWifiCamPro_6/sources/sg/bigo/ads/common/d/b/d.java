package sg.bigo.ads.common.d.b;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.download.core.IDownloadTask;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.common.l.c;
import sg.bigo.ads.common.l.c.b;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.utils.e;
import sg.bigo.ads.common.utils.f;

public final class d implements Runnable {
    private final a a;
    private InputStream b;
    private final File c = new File(this.a.b.c, e.c(this.a.b.d));

    public d(a aVar) {
        this.a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "the download task error and download state is not loading."
            java.lang.String r3 = "the download stream has not been read completely."
            java.lang.String r4 = "the download file has a invalid size."
            java.lang.String r5 = "Failed to download due to: "
            java.lang.String r0 = "startDownloadTask"
            r1.a(r0)
            java.io.InputStream r0 = r1.b
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "downloadStream is null"
            r1.b(r0)
            return
        L_0x0019:
            sg.bigo.ads.common.d.b.a r0 = r1.a
            int r6 = sg.bigo.ads.common.d.b.h.d
            r0.e = r6
            sg.bigo.ads.common.d.b.f r0 = sg.bigo.ads.common.d.b.f.a()
            sg.bigo.ads.common.d.b.a r6 = r1.a
            java.lang.String r6 = r6.a
            r0.a(r6)
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream
            java.io.InputStream r0 = r1.b
            r7.<init>(r0)
            r0 = 1048576(0x100000, float:1.469368E-39)
            byte[] r8 = new byte[r0]
            java.lang.String r9 = ""
            r11 = 0
            java.io.RandomAccessFile r14 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x013e, all -> 0x0138 }
            java.io.File r15 = r1.c     // Catch:{ Exception -> 0x013e, all -> 0x0138 }
            java.lang.String r6 = "rwd"
            r14.<init>(r15, r6)     // Catch:{ Exception -> 0x013e, all -> 0x0138 }
            sg.bigo.ads.common.d.b.a r6 = r1.a     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            sg.bigo.ads.common.d.a r6 = r6.b     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            long r12 = r6.f     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            r14.seek(r12)     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            java.lang.String r6 = "DownloadTask"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            r15.<init>()     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            sg.bigo.ads.common.d.b.a r10 = r1.a     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            java.lang.String r10 = r10.a     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            r15.append(r10)     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            java.lang.String r10 = " startDownloadTask."
            r15.append(r10)     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            java.lang.String r10 = r15.toString()     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            r15 = 3
            sg.bigo.ads.common.k.a.a(r11, r15, r6, r10)     // Catch:{ Exception -> 0x0133, all -> 0x012e }
        L_0x0065:
            sg.bigo.ads.common.d.b.a r6 = r1.a     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            int r6 = r6.e     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            int r10 = sg.bigo.ads.common.d.b.h.d     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            if (r6 != r10) goto L_0x0092
            int r6 = r7.read(r8, r11, r0)     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            r10 = -1
            if (r6 != r10) goto L_0x0078
            r10 = r2
            r15 = r3
            r0 = 1
            goto L_0x0095
        L_0x0078:
            r14.write(r8, r11, r6)     // Catch:{ Exception -> 0x0133, all -> 0x012e }
            r10 = r2
            r15 = r3
            long r2 = (long) r6
            long r12 = r12 + r2
            sg.bigo.ads.common.d.b.a r2 = r1.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            r2.b(r12)     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.b.f r2 = sg.bigo.ads.common.d.b.f.a()     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.b.a r3 = r1.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            java.lang.String r3 = r3.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            r2.a(r3)     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            r2 = r10
            r3 = r15
            goto L_0x0065
        L_0x0092:
            r10 = r2
            r15 = r3
            r0 = r11
        L_0x0095:
            if (r0 == 0) goto L_0x00ed
            r2 = 0
            int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ed
            java.io.File r0 = r1.c     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            long r2 = r0.length()     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x00ed
            sg.bigo.ads.common.d.b.a r0 = r1.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            int r0 = r0.e     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            int r2 = sg.bigo.ads.common.d.b.h.d     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            if (r0 != r2) goto L_0x00ed
            java.io.File r0 = r1.c     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.b.a r3 = r1.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.a r3 = r3.b     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            java.lang.String r3 = r3.c     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.b.a r6 = r1.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.a r6 = r6.b     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            java.lang.String r6 = r6.d     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            r2.<init>(r3, r6)     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            r0.renameTo(r2)     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.b.a r0 = r1.a     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            int r2 = sg.bigo.ads.common.d.b.h.f     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            r0.e = r2     // Catch:{ Exception -> 0x00eb, all -> 0x00e8 }
            sg.bigo.ads.common.d.b.f r0 = sg.bigo.ads.common.d.b.f.a()     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            sg.bigo.ads.common.d.b.a r2 = r1.a     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            java.lang.String r2 = r2.a     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            r0.a(r2)     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            java.lang.String r0 = "download is over."
            r1.a(r0)     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            r16 = 1
            goto L_0x00ef
        L_0x00de:
            r0 = move-exception
            r2 = r9
            r11 = 1
            goto L_0x0192
        L_0x00e3:
            r0 = move-exception
            r6 = r14
            r11 = 1
            goto L_0x0142
        L_0x00e8:
            r0 = move-exception
            goto L_0x0191
        L_0x00eb:
            r0 = move-exception
            goto L_0x0136
        L_0x00ed:
            r16 = r11
        L_0x00ef:
            if (r16 != 0) goto L_0x0122
            boolean r0 = sg.bigo.ads.common.utils.o.b(r9)
            if (r0 == 0) goto L_0x011a
            sg.bigo.ads.common.d.b.a r0 = r1.a
            sg.bigo.ads.common.d.a r0 = r0.b
            long r2 = r0.f
            r8 = 0
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0118
            java.io.File r0 = r1.c
            long r2 = r0.length()
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x010e
            goto L_0x0118
        L_0x010e:
            sg.bigo.ads.common.d.b.a r0 = r1.a
            int r0 = r0.e
            int r2 = sg.bigo.ads.common.d.b.h.d
            if (r0 == r2) goto L_0x011b
            r15 = r10
            goto L_0x011b
        L_0x0118:
            r15 = r4
            goto L_0x011b
        L_0x011a:
            r15 = r9
        L_0x011b:
            java.lang.String r0 = r5.concat(r15)
            r1.b(r0)
        L_0x0122:
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r14)
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            java.io.InputStream r0 = r1.b
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r0)
            return
        L_0x012e:
            r0 = move-exception
            r10 = r2
            r15 = r3
            goto L_0x0191
        L_0x0133:
            r0 = move-exception
            r10 = r2
            r15 = r3
        L_0x0136:
            r6 = r14
            goto L_0x0142
        L_0x0138:
            r0 = move-exception
            r10 = r2
            r15 = r3
            r2 = r9
            r14 = 0
            goto L_0x0192
        L_0x013e:
            r0 = move-exception
            r10 = r2
            r15 = r3
            r6 = 0
        L_0x0142:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x018f }
            r0.printStackTrace()     // Catch:{ all -> 0x018c }
            if (r11 != 0) goto L_0x0180
            boolean r0 = sg.bigo.ads.common.utils.o.b(r2)
            if (r0 == 0) goto L_0x0174
            sg.bigo.ads.common.d.b.a r0 = r1.a
            sg.bigo.ads.common.d.a r0 = r0.b
            long r2 = r0.f
            r8 = 0
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0172
            java.io.File r0 = r1.c
            long r2 = r0.length()
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0168
            goto L_0x0172
        L_0x0168:
            sg.bigo.ads.common.d.b.a r0 = r1.a
            int r0 = r0.e
            int r2 = sg.bigo.ads.common.d.b.h.d
            if (r0 == r2) goto L_0x0175
            r15 = r10
            goto L_0x0175
        L_0x0172:
            r15 = r4
            goto L_0x0175
        L_0x0174:
            r15 = r2
        L_0x0175:
            java.lang.String r0 = java.lang.String.valueOf(r15)
            java.lang.String r0 = r5.concat(r0)
            r1.b(r0)
        L_0x0180:
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r6)
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            java.io.InputStream r0 = r1.b
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r0)
            return
        L_0x018c:
            r0 = move-exception
            r14 = r6
            goto L_0x0192
        L_0x018f:
            r0 = move-exception
            r14 = r6
        L_0x0191:
            r2 = r9
        L_0x0192:
            if (r11 != 0) goto L_0x01c8
            boolean r3 = sg.bigo.ads.common.utils.o.b(r2)
            if (r3 == 0) goto L_0x01bc
            sg.bigo.ads.common.d.b.a r2 = r1.a
            sg.bigo.ads.common.d.a r2 = r2.b
            long r2 = r2.f
            r8 = 0
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x01ba
            java.io.File r2 = r1.c
            long r2 = r2.length()
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x01ba
            sg.bigo.ads.common.d.b.a r2 = r1.a
            int r2 = r2.e
            int r3 = sg.bigo.ads.common.d.b.h.d
            if (r2 == r3) goto L_0x01bd
            r15 = r10
            goto L_0x01bd
        L_0x01ba:
            r15 = r4
            goto L_0x01bd
        L_0x01bc:
            r15 = r2
        L_0x01bd:
            java.lang.String r2 = java.lang.String.valueOf(r15)
            java.lang.String r2 = r5.concat(r2)
            r1.b(r2)
        L_0x01c8:
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r14)
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r7)
            java.io.InputStream r2 = r1.b
            sg.bigo.ads.common.utils.f.a((java.io.Closeable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.d.b.d.a():void");
    }

    private void a(String str) {
        a.a(0, 3, IDownloadTask.TAG, str + ",taskId=" + this.a.a + ", downloadinfo = " + this.a.toString());
    }

    private void b(String str) {
        a.a(0, IDownloadTask.TAG, str + " , " + this.a.a + " has a error ! " + this.a.toString());
        a aVar = this.a;
        aVar.f = str;
        aVar.e = h.g;
        f.a().a(this.a.a);
    }

    public final void run() {
        boolean z;
        while (true) {
            sg.bigo.ads.common.l.b.a aVar = new sg.bigo.ads.common.l.b.a(this.a.b.b);
            String str = "bytes=" + this.a.b.f + "-";
            aVar.a("Range", str);
            a("Range = ".concat(String.valueOf(str)));
            c<sg.bigo.ads.common.l.c.a> a2 = g.a(aVar);
            if (a2.a != null) {
                b a3 = b.a(((sg.bigo.ads.common.l.c.a) a2.a).a("Content-Range"));
                long j = a3 != null ? a3.b : 0;
                if (j <= 0) {
                    j = ((sg.bigo.ads.common.l.c.a) a2.a).a();
                }
                this.a.a(j);
                this.b = ((sg.bigo.ads.common.l.c.a) a2.a).b;
                this.a.b.o = ((sg.bigo.ads.common.l.c.a) a2.a).a(HttpHeaders.CONTENT_TYPE);
                if (!this.c.exists()) {
                    break;
                }
                long j2 = this.a.b.f;
                long j3 = a3 != null ? a3.a : 0;
                if (j2 > 0 && j2 == j3) {
                    z = false;
                    this.a.b.n = true;
                    break;
                }
                a("Delete tmp file.");
                if (e.a(this.c)) {
                    this.a.b(0);
                    if (j3 <= 0) {
                        break;
                    }
                    f.a((Closeable) this.b);
                    this.b = null;
                } else {
                    b("Failed to delete temp file.");
                    return;
                }
            } else {
                String str2 = "Failed to request url.";
                if (a2.b != null) {
                    str2 = str2 + " Error code: " + a2.b.a + ", error msg: " + a2.b.getMessage();
                }
                b(str2);
                return;
            }
        }
        z = true;
        if (!z || e.c(this.c)) {
            this.a.e = h.c;
            f.a().a(this.a.a);
            a();
            return;
        }
        b("Failed to create temp file.");
    }
}
