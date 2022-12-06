package com.meizu.cloud.pushsdk.notification.b;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class d {
    private final File a;
    private final File b;
    private String c = this.b.getAbsolutePath();

    public d(String str, String str2) {
        this.a = new File(str);
        this.b = new File(str2);
        DebugLogger.i("ZipExtractTask", "Extract mInput file = " + this.a.toString());
        DebugLogger.i("ZipExtractTask", "Extract mOutput file = " + this.b.toString());
    }

    private void b() {
        File file = this.a;
        if (file != null && file.exists()) {
            if (this.a.delete()) {
                DebugLogger.i("ZipExtractTask", "Delete file:" + this.a.toString() + " after extracted.");
                return;
            }
            DebugLogger.i("ZipExtractTask", "Can't delete file:" + this.a.toString() + " after extracted.");
        }
    }

    public boolean a() {
        return c() > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r7v4, types: [java.util.zip.ZipFile] */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0132 A[SYNTHETIC, Splitter:B:43:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x016b A[SYNTHETIC, Splitter:B:53:0x016b] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01bd A[SYNTHETIC, Splitter:B:63:0x01bd] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x0151=Splitter:B:50:0x0151, B:40:0x011a=Splitter:B:40:0x011a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long c() {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "/"
            java.lang.String r3 = "Extracted IOException:"
            java.lang.String r4 = "ZipExtractTask"
            long r5 = android.os.SystemClock.currentThreadTimeMillis()
            r7 = 0
            r8 = 0
            r9 = 0
            java.util.zip.ZipFile r11 = new java.util.zip.ZipFile     // Catch:{ ZipException -> 0x014f, IOException -> 0x0118 }
            java.io.File r0 = r1.a     // Catch:{ ZipException -> 0x014f, IOException -> 0x0118 }
            r11.<init>(r0)     // Catch:{ ZipException -> 0x014f, IOException -> 0x0118 }
            java.util.Enumeration r0 = r11.entries()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
        L_0x001b:
            boolean r12 = r0.hasMoreElements()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            if (r12 == 0) goto L_0x00c0
            java.lang.Object r12 = r0.nextElement()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.util.zip.ZipEntry r12 = (java.util.zip.ZipEntry) r12     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            boolean r13 = r12.isDirectory()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            if (r13 == 0) goto L_0x002e
            goto L_0x001b
        L_0x002e:
            java.lang.String r13 = r12.getName()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            if (r7 != 0) goto L_0x0058
            if (r13 == 0) goto L_0x0058
            java.lang.String[] r14 = r13.split(r2)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r7 = r14[r8]     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r14.<init>()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r15 = "Extract temp directory="
            r14.append(r15)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.File r15 = r1.b     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r14.append(r15)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r14.append(r2)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r14.append(r7)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r14 = r14.toString()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            com.meizu.cloud.pushinternal.DebugLogger.i(r4, r14)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
        L_0x0058:
            java.io.File r14 = new java.io.File     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.File r15 = r1.b     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r14.<init>(r15, r13)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.File r13 = r14.getParentFile()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            boolean r13 = r13.exists()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            if (r13 != 0) goto L_0x00ac
            java.io.File r13 = r14.getParentFile()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            boolean r13 = r13.mkdirs()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            if (r13 == 0) goto L_0x0090
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r13.<init>()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r15 = "Make Destination directory="
            r13.append(r15)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.File r15 = r14.getParentFile()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r15 = r15.getAbsolutePath()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r13.append(r15)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r13 = r13.toString()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            com.meizu.cloud.pushinternal.DebugLogger.i(r4, r13)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            goto L_0x00ac
        L_0x0090:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r13.<init>()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r15 = "Can't make destination directory="
            r13.append(r15)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.File r15 = r14.getParentFile()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r15 = r15.getAbsolutePath()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r13.append(r15)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r13 = r13.toString()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            com.meizu.cloud.pushinternal.DebugLogger.i(r4, r13)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
        L_0x00ac:
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r13.<init>(r14)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.InputStream r12 = r11.getInputStream(r12)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            int r12 = r1.a(r12, r13)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            long r14 = (long) r12     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            long r9 = r9 + r14
            r13.close()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            goto L_0x001b
        L_0x00c0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r0.<init>()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.io.File r12 = r1.b     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r0.append(r12)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r0.append(r2)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r0.append(r7)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r0 = r0.toString()     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            java.lang.String r12 = r1.c     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            boolean r12 = r12.equals(r0)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            if (r12 != 0) goto L_0x00e2
            java.lang.String r12 = r1.c     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            com.meizu.cloud.pushsdk.notification.b.a.a(r0, r12)     // Catch:{ ZipException -> 0x010c, IOException -> 0x0105, all -> 0x0101 }
            r8 = 1
        L_0x00e2:
            r11.close()     // Catch:{ IOException -> 0x00e6 }
            goto L_0x00fe
        L_0x00e6:
            r0 = move-exception
            r11 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = r11.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.meizu.cloud.pushinternal.DebugLogger.e(r4, r0)
        L_0x00fe:
            r11 = r7
            goto L_0x0177
        L_0x0101:
            r0 = move-exception
            r2 = r0
            goto L_0x01bb
        L_0x0105:
            r0 = move-exception
            r16 = r11
            r11 = r7
            r7 = r16
            goto L_0x011a
        L_0x010c:
            r0 = move-exception
            r16 = r11
            r11 = r7
            r7 = r16
            goto L_0x0151
        L_0x0113:
            r0 = move-exception
            r2 = r0
            r11 = r7
            goto L_0x01bb
        L_0x0118:
            r0 = move-exception
            r11 = r7
        L_0x011a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r12.<init>()     // Catch:{ all -> 0x0113 }
            r12.append(r3)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0113 }
            r12.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x0113 }
            com.meizu.cloud.pushinternal.DebugLogger.e(r4, r0)     // Catch:{ all -> 0x0113 }
            if (r7 == 0) goto L_0x0177
            r7.close()     // Catch:{ IOException -> 0x0136 }
            goto L_0x0177
        L_0x0136:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x013d:
            r0.append(r3)
            java.lang.String r3 = r7.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.meizu.cloud.pushinternal.DebugLogger.e(r4, r0)
            goto L_0x0177
        L_0x014f:
            r0 = move-exception
            r11 = r7
        L_0x0151:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r12.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r13 = "ZipException :"
            r12.append(r13)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0113 }
            r12.append(r0)     // Catch:{ all -> 0x0113 }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x0113 }
            com.meizu.cloud.pushinternal.DebugLogger.e(r4, r0)     // Catch:{ all -> 0x0113 }
            if (r7 == 0) goto L_0x0177
            r7.close()     // Catch:{ IOException -> 0x016f }
            goto L_0x0177
        L_0x016f:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x013d
        L_0x0177:
            long r12 = android.os.SystemClock.currentThreadTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Extract file "
            r0.append(r3)
            java.io.File r3 = r1.a
            r0.append(r3)
            java.lang.String r3 = ", UseTime ="
            r0.append(r3)
            long r12 = r12 - r5
            java.lang.String r3 = java.lang.String.valueOf(r12)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.meizu.cloud.pushinternal.DebugLogger.i(r4, r0)
            if (r8 == 0) goto L_0x01b7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r3 = r1.b
            r0.append(r3)
            r0.append(r2)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            com.meizu.cloud.pushsdk.notification.b.a.b(r0)
        L_0x01b7:
            r17.b()
            return r9
        L_0x01bb:
            if (r11 == 0) goto L_0x01d9
            r11.close()     // Catch:{ IOException -> 0x01c1 }
            goto L_0x01d9
        L_0x01c1:
            r0 = move-exception
            r5 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = r5.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.meizu.cloud.pushinternal.DebugLogger.e(r4, r0)
        L_0x01d9:
            goto L_0x01db
        L_0x01da:
            throw r2
        L_0x01db:
            goto L_0x01da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.notification.b.d.c():long");
    }

    private int a(InputStream inputStream, OutputStream outputStream) {
        StringBuilder sb;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
        int i = 0;
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
            } catch (IOException e) {
                DebugLogger.e("ZipExtractTask", "Extracted IOException:" + e.toString());
                try {
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e2.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    sb = new StringBuilder();
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e4) {
                    DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e4.toString());
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    DebugLogger.e("ZipExtractTask", "in.close() IOException e=" + e5.toString());
                }
                throw th;
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException e6) {
            DebugLogger.e("ZipExtractTask", "out.close() IOException e=" + e6.toString());
        }
        try {
            bufferedInputStream.close();
        } catch (IOException e7) {
            e = e7;
            sb = new StringBuilder();
        }
        return i;
        sb.append("in.close() IOException e=");
        sb.append(e.toString());
        DebugLogger.e("ZipExtractTask", sb.toString());
        return i;
    }
}
