package com.bytedance.sdk.component.d.c.a.a;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class a implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream c = new OutputStream() {
        public void write(int i) throws IOException {
        }
    };
    final ExecutorService b;
    /* access modifiers changed from: private */
    public final File d;
    private final File e;
    private final File f;
    private final File g;
    private final int h;
    private long i;
    /* access modifiers changed from: private */
    public final int j;
    private long k = 0;
    /* access modifiers changed from: private */
    public Writer l;
    private final LinkedHashMap<String, b> m = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int n;
    private long o = -1;
    private long p = 0;
    private final Callable<Void> q = new Callable<Void>() {
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                com.bytedance.sdk.component.d.c.a.a.a r0 = com.bytedance.sdk.component.d.c.a.a.a.this
                monitor-enter(r0)
                com.bytedance.sdk.component.d.c.a.a.a r1 = com.bytedance.sdk.component.d.c.a.a.a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.l     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                com.bytedance.sdk.component.d.c.a.a.a r1 = com.bytedance.sdk.component.d.c.a.a.a.this     // Catch:{ all -> 0x0028 }
                r1.h()     // Catch:{ all -> 0x0028 }
                com.bytedance.sdk.component.d.c.a.a.a r1 = com.bytedance.sdk.component.d.c.a.a.a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.f()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                com.bytedance.sdk.component.d.c.a.a.a r1 = com.bytedance.sdk.component.d.c.a.a.a.this     // Catch:{ all -> 0x0028 }
                r1.e()     // Catch:{ all -> 0x0028 }
                com.bytedance.sdk.component.d.c.a.a.a r1 = com.bytedance.sdk.component.d.c.a.a.a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.n = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.AnonymousClass1.call():java.lang.Void");
        }
    };

    private a(File file, int i2, int i3, long j2, ExecutorService executorService) {
        this.d = file;
        this.h = i2;
        this.e = new File(file, "journal");
        this.f = new File(file, "journal.tmp");
        this.g = new File(file, "journal.bkp");
        this.j = i3;
        this.i = j2;
        this.b = executorService;
    }

    public static a a(File file, int i2, int i3, long j2, ExecutorService executorService) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i2, i3, j2, executorService);
            if (aVar.e.exists()) {
                try {
                    aVar.c();
                    aVar.d();
                    return aVar;
                } catch (IOException e2) {
                    Log.w("DiskLruCache ", file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.b();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i2, i3, j2, executorService);
            aVar2.e();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.n = r0 - r9.m.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.l = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.e, true), com.bytedance.sdk.component.d.c.a.a.d.a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            com.bytedance.sdk.component.d.c.a.a.c r1 = new com.bytedance.sdk.component.d.c.a.a.c
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.e
            r2.<init>(r3)
            java.nio.charset.Charset r3 = com.bytedance.sdk.component.d.c.a.a.d.a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.a()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.h     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.j     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.a()     // Catch:{ EOFException -> 0x005f }
            r9.d((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r2 = r9.m     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.n = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.b()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.e()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.e     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = com.bytedance.sdk.component.d.c.a.a.d.a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.l = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            com.bytedance.sdk.component.d.c.c.b.a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            com.bytedance.sdk.component.d.c.c.b.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.c():void");
    }

    private void d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.m.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            b bVar = this.m.get(str2);
            if (bVar == null) {
                bVar = new b(str2);
                this.m.put(str2, bVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = bVar.d = true;
                C0030a unused2 = bVar.e = null;
                bVar.a(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                C0030a unused3 = bVar.e = new C0030a(bVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void d() throws IOException {
        a(this.f);
        Iterator<b> it = this.m.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.j) {
                    this.k += next.c[i2];
                    i2++;
                }
            } else {
                C0030a unused = next.e = null;
                while (i2 < this.j) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void e() throws IOException {
        if (this.l != null) {
            this.l.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f), d.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.h));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.j));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b next : this.m.values()) {
                if (next.e != null) {
                    bufferedWriter.write("DIRTY " + next.b + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.b + next.a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.e.exists()) {
                a(this.e, this.g, true);
            }
            a(this.f, this.e, false);
            this.g.delete();
            this.l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e, true), d.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.n++;
        r11.l.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (f() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r11.b.submit(r11.q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return new com.bytedance.sdk.component.d.c.a.a.a.c(r11, r12, com.bytedance.sdk.component.d.c.a.a.a.b.e(r0), r8, com.bytedance.sdk.component.d.c.a.a.a.b.b(r0), (com.bytedance.sdk.component.d.c.a.a.a.AnonymousClass1) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bytedance.sdk.component.d.c.a.a.a.c a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.g()     // Catch:{ all -> 0x0087 }
            r11.e((java.lang.String) r12)     // Catch:{ all -> 0x0087 }
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r0 = r11.m     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0087 }
            com.bytedance.sdk.component.d.c.a.a.a$b r0 = (com.bytedance.sdk.component.d.c.a.a.a.b) r0     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.d     // Catch:{ all -> 0x0087 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.j     // Catch:{ all -> 0x0087 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0087 }
            r2 = 0
            r3 = r2
        L_0x0022:
            int r4 = r11.j     // Catch:{ FileNotFoundException -> 0x0075 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0075 }
            java.io.File r5 = r0.a((int) r3)     // Catch:{ FileNotFoundException -> 0x0075 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0075 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0075 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.n     // Catch:{ all -> 0x0087 }
            int r1 = r1 + 1
            r11.n = r1     // Catch:{ all -> 0x0087 }
            java.io.Writer r1 = r11.l     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            r2.append(r12)     // Catch:{ all -> 0x0087 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            boolean r1 = r11.f()     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0062
            java.util.concurrent.ExecutorService r1 = r11.b     // Catch:{ all -> 0x0087 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.q     // Catch:{ all -> 0x0087 }
            r1.submit(r2)     // Catch:{ all -> 0x0087 }
        L_0x0062:
            com.bytedance.sdk.component.d.c.a.a.a$c r1 = new com.bytedance.sdk.component.d.c.a.a.a$c     // Catch:{ all -> 0x0087 }
            long r6 = r0.f     // Catch:{ all -> 0x0087 }
            long[] r9 = r0.c     // Catch:{ all -> 0x0087 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x0087 }
            monitor-exit(r11)
            return r1
        L_0x0075:
            int r12 = r11.j     // Catch:{ all -> 0x0087 }
            if (r2 >= r12) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0087 }
            if (r12 == 0) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0087 }
            com.bytedance.sdk.component.d.c.c.b.a(r12)     // Catch:{ all -> 0x0087 }
            int r2 = r2 + 1
            goto L_0x0075
        L_0x0085:
            monitor-exit(r11)
            return r1
        L_0x0087:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.a(java.lang.String):com.bytedance.sdk.component.d.c.a.a.a$c");
    }

    public C0030a b(String str) throws IOException {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.bytedance.sdk.component.d.c.a.a.a.C0030a a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.g()     // Catch:{ all -> 0x0061 }
            r5.e((java.lang.String) r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r0 = r5.m     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            com.bytedance.sdk.component.d.c.a.a.a$b r0 = (com.bytedance.sdk.component.d.c.a.a.a.b) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r3 = r0.f     // Catch:{ all -> 0x0061 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            com.bytedance.sdk.component.d.c.a.a.a$b r0 = new com.bytedance.sdk.component.d.c.a.a.a$b     // Catch:{ all -> 0x0061 }
            r0.<init>(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r7 = r5.m     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            com.bytedance.sdk.component.d.c.a.a.a$a r7 = r0.e     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            com.bytedance.sdk.component.d.c.a.a.a$a r7 = new com.bytedance.sdk.component.d.c.a.a.a$a     // Catch:{ all -> 0x0061 }
            r7.<init>(r0)     // Catch:{ all -> 0x0061 }
            com.bytedance.sdk.component.d.c.a.a.a.C0030a unused = r0.e = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.l     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.l     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.a(java.lang.String, long):com.bytedance.sdk.component.d.c.a.a.a$a");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bytedance.sdk.component.d.c.a.a.a.C0030a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bytedance.sdk.component.d.c.a.a.a$b r0 = r10.b     // Catch:{ all -> 0x0110 }
            com.bytedance.sdk.component.d.c.a.a.a$a r1 = r0.e     // Catch:{ all -> 0x0110 }
            if (r1 != r10) goto L_0x010a
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.d     // Catch:{ all -> 0x0110 }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r9.j     // Catch:{ all -> 0x0110 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.c     // Catch:{ all -> 0x0110 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.b((int) r2)     // Catch:{ all -> 0x0110 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0110 }
            if (r3 != 0) goto L_0x0030
            r10.b()     // Catch:{ all -> 0x0110 }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.b()     // Catch:{ all -> 0x0110 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.<init>(r11)     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x004d:
            int r10 = r9.j     // Catch:{ all -> 0x0110 }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.b((int) r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x0110 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.c     // Catch:{ all -> 0x0110 }
            r3 = r10[r1]     // Catch:{ all -> 0x0110 }
            long r5 = r2.length()     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.c     // Catch:{ all -> 0x0110 }
            r10[r1] = r5     // Catch:{ all -> 0x0110 }
            long r7 = r9.k     // Catch:{ all -> 0x0110 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.k = r7     // Catch:{ all -> 0x0110 }
            goto L_0x007e
        L_0x007b:
            a((java.io.File) r10)     // Catch:{ all -> 0x0110 }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.n     // Catch:{ all -> 0x0110 }
            r1 = 1
            int r10 = r10 + r1
            r9.n = r10     // Catch:{ all -> 0x0110 }
            r10 = 0
            com.bytedance.sdk.component.d.c.a.a.a.C0030a unused = r0.e = r10     // Catch:{ all -> 0x0110 }
            boolean r10 = r0.d     // Catch:{ all -> 0x0110 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00c8
            boolean unused = r0.d = r1     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.l     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r1.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.b     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x00ee
            long r10 = r9.p     // Catch:{ all -> 0x0110 }
            r1 = 1
            long r1 = r1 + r10
            r9.p = r1     // Catch:{ all -> 0x0110 }
            long unused = r0.f = r10     // Catch:{ all -> 0x0110 }
            goto L_0x00ee
        L_0x00c8:
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r10 = r9.m     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.b     // Catch:{ all -> 0x0110 }
            r10.remove(r11)     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.l     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = r0.b     // Catch:{ all -> 0x0110 }
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r11)     // Catch:{ all -> 0x0110 }
        L_0x00ee:
            java.io.Writer r10 = r9.l     // Catch:{ all -> 0x0110 }
            r10.flush()     // Catch:{ all -> 0x0110 }
            long r10 = r9.k     // Catch:{ all -> 0x0110 }
            long r0 = r9.i     // Catch:{ all -> 0x0110 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0101
            boolean r10 = r9.f()     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0108
        L_0x0101:
            java.util.concurrent.ExecutorService r10 = r9.b     // Catch:{ all -> 0x0110 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.q     // Catch:{ all -> 0x0110 }
            r10.submit(r11)     // Catch:{ all -> 0x0110 }
        L_0x0108:
            monitor-exit(r9)
            return
        L_0x010a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            r10.<init>()     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.a(com.bytedance.sdk.component.d.c.a.a.a$a, boolean):void");
    }

    /* access modifiers changed from: private */
    public boolean f() {
        int i2 = this.n;
        return i2 >= 2000 && i2 >= this.m.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.g()     // Catch:{ all -> 0x0093 }
            r7.e((java.lang.String) r8)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r0 = r7.m     // Catch:{ all -> 0x0093 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0093 }
            com.bytedance.sdk.component.d.c.a.a.a$b r0 = (com.bytedance.sdk.component.d.c.a.a.a.b) r0     // Catch:{ all -> 0x0093 }
            r1 = 0
            if (r0 == 0) goto L_0x0091
            com.bytedance.sdk.component.d.c.a.a.a$a r2 = r0.e     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0091
        L_0x001a:
            int r2 = r7.j     // Catch:{ all -> 0x0093 }
            if (r1 >= r2) goto L_0x005c
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x0093 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0046
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r0.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0093 }
            r0.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
            r8.<init>(r0)     // Catch:{ all -> 0x0093 }
            throw r8     // Catch:{ all -> 0x0093 }
        L_0x0046:
            long r2 = r7.k     // Catch:{ all -> 0x0093 }
            long[] r4 = r0.c     // Catch:{ all -> 0x0093 }
            r5 = r4[r1]     // Catch:{ all -> 0x0093 }
            long r2 = r2 - r5
            r7.k = r2     // Catch:{ all -> 0x0093 }
            long[] r2 = r0.c     // Catch:{ all -> 0x0093 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0093 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005c:
            int r0 = r7.n     // Catch:{ all -> 0x0093 }
            r1 = 1
            int r0 = r0 + r1
            r7.n = r0     // Catch:{ all -> 0x0093 }
            java.io.Writer r0 = r7.l     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r2.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            r2.append(r8)     // Catch:{ all -> 0x0093 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0093 }
            r0.append(r2)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, com.bytedance.sdk.component.d.c.a.a.a$b> r0 = r7.m     // Catch:{ all -> 0x0093 }
            r0.remove(r8)     // Catch:{ all -> 0x0093 }
            boolean r8 = r7.f()     // Catch:{ all -> 0x0093 }
            if (r8 == 0) goto L_0x008f
            java.util.concurrent.ExecutorService r8 = r7.b     // Catch:{ all -> 0x0093 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.q     // Catch:{ all -> 0x0093 }
            r8.submit(r0)     // Catch:{ all -> 0x0093 }
        L_0x008f:
            monitor-exit(r7)
            return r1
        L_0x0091:
            monitor-exit(r7)
            return r1
        L_0x0093:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.c(java.lang.String):boolean");
    }

    private void g() {
        if (this.l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void a() throws IOException {
        g();
        h();
        this.l.flush();
    }

    public synchronized void close() throws IOException {
        if (this.l != null) {
            Iterator it = new ArrayList(this.m.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.e != null) {
                    bVar.e.b();
                }
            }
            h();
            this.l.close();
            this.l = null;
        }
    }

    /* access modifiers changed from: private */
    public void h() throws IOException {
        long j2 = this.i;
        long j3 = this.o;
        if (j3 >= 0) {
            j2 = j3;
        }
        while (this.k > j2) {
            c((String) this.m.entrySet().iterator().next().getKey());
        }
        this.o = -1;
    }

    public void b() throws IOException {
        close();
        d.a(this.d);
    }

    private void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    /* compiled from: DiskLruCache */
    public final class c implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        private c(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        public InputStream a(int i) {
            return this.d[i];
        }

        public void close() {
            for (InputStream a2 : this.d) {
                com.bytedance.sdk.component.d.c.c.b.a(a2);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.component.d.c.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: DiskLruCache */
    public final class C0030a {
        /* access modifiers changed from: private */
        public final b b;
        /* access modifiers changed from: private */
        public final boolean[] c;
        /* access modifiers changed from: private */
        public boolean d;
        private boolean e;

        private C0030a(b bVar) {
            this.b = bVar;
            this.c = bVar.d ? null : new boolean[a.this.j];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream a(int r4) throws java.io.IOException {
            /*
                r3 = this;
                if (r4 < 0) goto L_0x0051
                com.bytedance.sdk.component.d.c.a.a.a r0 = com.bytedance.sdk.component.d.c.a.a.a.this
                int r0 = r0.j
                if (r4 >= r0) goto L_0x0051
                com.bytedance.sdk.component.d.c.a.a.a r0 = com.bytedance.sdk.component.d.c.a.a.a.this
                monitor-enter(r0)
                com.bytedance.sdk.component.d.c.a.a.a$b r1 = r3.b     // Catch:{ all -> 0x004e }
                com.bytedance.sdk.component.d.c.a.a.a$a r1 = r1.e     // Catch:{ all -> 0x004e }
                if (r1 != r3) goto L_0x0048
                com.bytedance.sdk.component.d.c.a.a.a$b r1 = r3.b     // Catch:{ all -> 0x004e }
                boolean r1 = r1.d     // Catch:{ all -> 0x004e }
                if (r1 != 0) goto L_0x0022
                boolean[] r1 = r3.c     // Catch:{ all -> 0x004e }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x004e }
            L_0x0022:
                com.bytedance.sdk.component.d.c.a.a.a$b r1 = r3.b     // Catch:{ all -> 0x004e }
                java.io.File r4 = r1.b((int) r4)     // Catch:{ all -> 0x004e }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002e }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x002e }
                goto L_0x003c
            L_0x002e:
                com.bytedance.sdk.component.d.c.a.a.a r1 = com.bytedance.sdk.component.d.c.a.a.a.this     // Catch:{ all -> 0x004e }
                java.io.File r1 = r1.d     // Catch:{ all -> 0x004e }
                r1.mkdirs()     // Catch:{ all -> 0x004e }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0044 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0044 }
            L_0x003c:
                com.bytedance.sdk.component.d.c.a.a.a$a$a r4 = new com.bytedance.sdk.component.d.c.a.a.a$a$a     // Catch:{ all -> 0x004e }
                r2 = 0
                r4.<init>(r1)     // Catch:{ all -> 0x004e }
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                return r4
            L_0x0044:
                java.io.OutputStream r4 = com.bytedance.sdk.component.d.c.a.a.a.c     // Catch:{ all -> 0x004e }
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                return r4
            L_0x0048:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004e }
                r4.<init>()     // Catch:{ all -> 0x004e }
                throw r4     // Catch:{ all -> 0x004e }
            L_0x004e:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004e }
                throw r4
            L_0x0051:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected index "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = " to be greater than 0 and less than the maximum value count of "
                r1.append(r4)
                com.bytedance.sdk.component.d.c.a.a.a r4 = com.bytedance.sdk.component.d.c.a.a.a.this
                int r4 = r4.j
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.d.c.a.a.a.C0030a.a(int):java.io.OutputStream");
        }

        public void a() throws IOException {
            if (this.d) {
                a.this.a(this, false);
                a.this.c(this.b.b);
            } else {
                a.this.a(this, true);
            }
            this.e = true;
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        /* renamed from: com.bytedance.sdk.component.d.c.a.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        private class C0031a extends FilterOutputStream {
            private C0031a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = C0030a.this.d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = C0030a.this.d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = C0030a.this.d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = C0030a.this.d = true;
                }
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class b {
        /* access modifiers changed from: private */
        public final String b;
        /* access modifiers changed from: private */
        public final long[] c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public C0030a e;
        /* access modifiers changed from: private */
        public long f;

        private b(String str) {
            this.b = str;
            this.c = new long[a.this.j];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public void a(String[] strArr) throws IOException {
            if (strArr.length == a.this.j) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.c[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw b(strArr);
                    }
                }
                return;
            }
            throw b(strArr);
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            File f2 = a.this.d;
            return new File(f2, this.b + "." + i);
        }

        public File b(int i) {
            File f2 = a.this.d;
            return new File(f2, this.b + "." + i + ".tmp");
        }
    }
}
