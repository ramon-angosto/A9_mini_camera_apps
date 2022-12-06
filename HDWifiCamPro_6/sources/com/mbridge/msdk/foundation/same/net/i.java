package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.a.a;
import com.mbridge.msdk.foundation.same.net.f.b;
import com.mbridge.msdk.foundation.same.net.f.c;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Request */
public abstract class i<T> implements Comparable<i<T>> {
    private static final String c = i.class.getSimpleName();
    protected ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    protected e<T> b = null;
    private final int d;
    private final String e;
    private Integer f;
    private j g;
    private boolean h = false;
    private l i;
    private int j = 2;

    /* access modifiers changed from: protected */
    public abstract k<T> a(c cVar);

    public byte[] e() {
        return null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int g2 = g();
        int g3 = iVar.g();
        return g2 == g3 ? this.f.intValue() - iVar.f.intValue() : g3 - g2;
    }

    public i(int i2, String str, e<T> eVar) {
        this.e = str;
        this.d = i2;
        this.b = eVar;
        this.i = new b();
    }

    public i(int i2, String str) {
        this.e = str;
        this.d = i2;
        this.i = new b();
    }

    public final int a() {
        return this.d;
    }

    public final void a(e<T> eVar) {
        this.b = eVar;
    }

    public final i<?> a(l lVar) {
        this.i = lVar;
        return this;
    }

    public final void a(String str) {
        j jVar = this.g;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    public final i<?> a(j jVar) {
        this.g = jVar;
        return this;
    }

    public final i<?> a(int i2) {
        this.f = Integer.valueOf(i2);
        return this;
    }

    public final String b() {
        return this.e;
    }

    public final boolean c() {
        return this.h;
    }

    public final Map<String, String> d() {
        return this.a;
    }

    public final void f() {
        a("Charset", "UTF-8");
        a("Connection", "close");
    }

    public byte[] a(b bVar, c cVar) throws IOException, a {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0063 A[SYNTHETIC, Splitter:B:39:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006b A[Catch:{ IOException -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(com.mbridge.msdk.foundation.same.net.f.b r6) throws java.io.IOException, com.mbridge.msdk.foundation.same.net.a.a {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStream r1 = r6.c()     // Catch:{ all -> 0x005f }
            java.util.List r6 = r6.b()     // Catch:{ all -> 0x005d }
            boolean r6 = com.mbridge.msdk.foundation.same.net.g.b.b(r6)     // Catch:{ all -> 0x005d }
            if (r6 == 0) goto L_0x0019
            boolean r6 = r1 instanceof java.util.zip.GZIPInputStream     // Catch:{ all -> 0x005d }
            if (r6 != 0) goto L_0x0019
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x005d }
            r6.<init>(r1)     // Catch:{ all -> 0x005d }
            goto L_0x001a
        L_0x0019:
            r6 = r1
        L_0x001a:
            if (r6 == 0) goto L_0x0056
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x004b }
        L_0x0025:
            int r2 = r6.read(r0)     // Catch:{ all -> 0x004b }
            r3 = -1
            if (r2 == r3) goto L_0x0031
            r3 = 0
            r1.write(r0, r3, r2)     // Catch:{ all -> 0x004b }
            goto L_0x0025
        L_0x0031:
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x004b }
            if (r6 == 0) goto L_0x003d
            r6.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003d
        L_0x003b:
            r6 = move-exception
            goto L_0x0041
        L_0x003d:
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x004a
        L_0x0041:
            java.lang.String r1 = c
            java.lang.String r6 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r1, r6)
        L_0x004a:
            return r0
        L_0x004b:
            r0 = move-exception
            r4 = r1
            r1 = r6
            r6 = r0
            r0 = r4
            goto L_0x0061
        L_0x0051:
            r1 = move-exception
            r4 = r1
            r1 = r6
            r6 = r4
            goto L_0x0061
        L_0x0056:
            com.mbridge.msdk.foundation.same.net.a.a r1 = new com.mbridge.msdk.foundation.same.net.a.a     // Catch:{ all -> 0x0051 }
            r2 = 7
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0051 }
            throw r1     // Catch:{ all -> 0x0051 }
        L_0x005d:
            r6 = move-exception
            goto L_0x0061
        L_0x005f:
            r6 = move-exception
            r1 = r0
        L_0x0061:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0069
        L_0x0067:
            r0 = move-exception
            goto L_0x006f
        L_0x0069:
            if (r0 == 0) goto L_0x0078
            r0.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0078
        L_0x006f:
            java.lang.String r1 = c
            java.lang.String r0 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.q.d(r1, r0)
        L_0x0078:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.i.a(com.mbridge.msdk.foundation.same.net.f.b):byte[]");
    }

    public int g() {
        return this.j;
    }

    public final void b(int i2) {
        if (i2 >= 1 && i2 <= 4) {
            this.j = i2;
        }
    }

    public final int h() {
        try {
            return this.i.b();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int i() {
        try {
            return this.i.d();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int j() {
        try {
            return this.i.e();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int k() {
        try {
            return this.i.f();
        } catch (Exception unused) {
            return 10;
        }
    }

    public final int l() {
        try {
            return this.i.g();
        } catch (Exception unused) {
            return 0;
        }
    }

    public final l m() {
        return this.i;
    }

    public final void a(k<T> kVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(kVar);
        }
    }

    public final void a(a aVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public final void n() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final void o() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void p() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void q() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.e();
        }
    }

    public final void r() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.d();
        }
    }

    public final void a(long j2, long j3) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(j2, j3);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h ? "[X] " : "[ ] ");
        sb.append(this.e);
        sb.append(" ");
        sb.append(g());
        sb.append(" ");
        sb.append(this.f);
        return sb.toString();
    }

    public final void a(String str, String str2) {
        this.a.remove(str);
        this.a.put(str, str2);
    }
}
