package com.bytedance.sdk.component.d.c.a.a;

import android.util.Log;
import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.d.c.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* compiled from: LruCountDiskCache */
public class b implements c {
    private long a;
    private a b;

    public b(File file, long j, ExecutorService executorService) {
        this.a = j;
        try {
            this.b = a.a(file, 20210302, 1, j, executorService);
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.toString());
        }
    }

    public InputStream a(String str) {
        a aVar = this.b;
        if (aVar == null) {
            return null;
        }
        try {
            a.c a2 = aVar.a(str);
            if (a2 != null) {
                return a2.a(0);
            }
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.bytedance.sdk.component.d.c.a.a.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.bytedance.sdk.component.d.c.a.a.a$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.bytedance.sdk.component.d.c.a.a.a$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072 A[SYNTHETIC, Splitter:B:30:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r7, byte[] r8) {
        /*
            r6 = this;
            java.lang.String r0 = "LruCountDiskCache"
            com.bytedance.sdk.component.d.c.a.a.a r1 = r6.b
            r2 = 0
            if (r1 == 0) goto L_0x007d
            if (r8 == 0) goto L_0x007d
            if (r7 != 0) goto L_0x000c
            goto L_0x007d
        L_0x000c:
            r3 = 0
            com.bytedance.sdk.component.d.c.a.a.a$a r1 = r1.b((java.lang.String) r7)     // Catch:{ IOException -> 0x0067 }
            java.lang.String r4 = "save "
            if (r1 != 0) goto L_0x0030
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0063 }
            r8.<init>()     // Catch:{ IOException -> 0x0063 }
            r8.append(r4)     // Catch:{ IOException -> 0x0063 }
            r8.append(r7)     // Catch:{ IOException -> 0x0063 }
            java.lang.String r7 = " failed for edit null"
            r8.append(r7)     // Catch:{ IOException -> 0x0063 }
            java.lang.String r7 = r8.toString()     // Catch:{ IOException -> 0x0063 }
            android.util.Log.w(r0, r7)     // Catch:{ IOException -> 0x0063 }
            com.bytedance.sdk.component.d.c.c.b.a(r3)
            return r2
        L_0x0030:
            java.io.OutputStream r3 = r1.a((int) r2)     // Catch:{ IOException -> 0x0063 }
            java.io.OutputStream r5 = com.bytedance.sdk.component.d.c.a.a.a.c     // Catch:{ IOException -> 0x0063 }
            if (r3 != r5) goto L_0x0053
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0063 }
            r8.<init>()     // Catch:{ IOException -> 0x0063 }
            r8.append(r4)     // Catch:{ IOException -> 0x0063 }
            r8.append(r7)     // Catch:{ IOException -> 0x0063 }
            java.lang.String r7 = " failed for null OutputStream"
            r8.append(r7)     // Catch:{ IOException -> 0x0063 }
            java.lang.String r7 = r8.toString()     // Catch:{ IOException -> 0x0063 }
            android.util.Log.w(r0, r7)     // Catch:{ IOException -> 0x0063 }
            com.bytedance.sdk.component.d.c.c.b.a(r3)
            return r2
        L_0x0053:
            r3.write(r8)     // Catch:{ IOException -> 0x0063 }
            r1.a()     // Catch:{ IOException -> 0x0063 }
            com.bytedance.sdk.component.d.c.a.a.a r7 = r6.b     // Catch:{ IOException -> 0x0063 }
            r7.a()     // Catch:{ IOException -> 0x0063 }
            com.bytedance.sdk.component.d.c.c.b.a(r3)
            r7 = 1
            return r7
        L_0x0063:
            r7 = move-exception
            goto L_0x0069
        L_0x0065:
            r7 = move-exception
            goto L_0x0079
        L_0x0067:
            r7 = move-exception
            r1 = r3
        L_0x0069:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0065 }
            android.util.Log.w(r0, r7)     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0075
            r1.b()     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            com.bytedance.sdk.component.d.c.c.b.a(r3)
            return r2
        L_0x0079:
            com.bytedance.sdk.component.d.c.c.b.a(r3)
            throw r7
        L_0x007d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.b.a(java.lang.String, byte[]):boolean");
    }

    /* renamed from: b */
    public byte[] a(String str) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar = this.b;
        if (aVar == null || str == null) {
            return null;
        }
        try {
            a.c a2 = aVar.a(str);
            if (a2 == null) {
                com.bytedance.sdk.component.d.c.c.b.a((Closeable) null);
                com.bytedance.sdk.component.d.c.c.b.a((Closeable) null);
                return null;
            }
            inputStream = a2.a(0);
            if (inputStream != null) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        com.bytedance.sdk.component.d.c.c.b.a(inputStream);
                        com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        com.bytedance.sdk.component.d.c.c.b.a(inputStream);
                        com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                    com.bytedance.sdk.component.d.c.c.b.a(inputStream);
                    com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.d.c.c.b.a(inputStream);
                    com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
                    return null;
                }
            } else {
                byteArrayOutputStream = null;
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            com.bytedance.sdk.component.d.c.c.b.a(inputStream);
            com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
            return byteArray;
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            byteArrayOutputStream = null;
            Log.w("LruCountDiskCache", e.toString());
            com.bytedance.sdk.component.d.c.c.b.a(inputStream);
            com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            byteArrayOutputStream = null;
            com.bytedance.sdk.component.d.c.c.b.a(inputStream);
            com.bytedance.sdk.component.d.c.c.b.a(byteArrayOutputStream);
            throw th;
        }
    }

    /* renamed from: c */
    public boolean b(String str) {
        boolean z = false;
        a.c cVar = null;
        try {
            cVar = this.b.a(str);
            if (cVar != null) {
                z = true;
            }
            return z;
        } catch (IOException e) {
            Log.w("LruCountDiskCache", e.getMessage());
            return false;
        } finally {
            com.bytedance.sdk.component.d.c.c.b.a(cVar);
        }
    }
}
