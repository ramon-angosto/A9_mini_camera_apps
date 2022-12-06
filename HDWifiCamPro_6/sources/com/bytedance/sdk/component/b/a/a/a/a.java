package com.bytedance.sdk.component.b.a.a.a;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bytedance.sdk.component.b.a.b;
import com.bytedance.sdk.component.b.a.c;
import com.bytedance.sdk.component.b.a.d;
import com.bytedance.sdk.component.b.a.g;
import com.bytedance.sdk.component.b.a.k;
import com.bytedance.sdk.component.b.a.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NetCall */
public class a implements b {
    private static AtomicBoolean c = new AtomicBoolean(false);
    k a;
    d b;

    a(k kVar, d dVar) {
        this.a = kVar;
        this.b = dVar;
    }

    public m a() throws IOException {
        this.b.c().remove(this);
        this.b.d().add(this);
        if (this.b.c().size() + this.b.d().size() > this.b.a() || c.get()) {
            this.b.d().remove(this);
            return null;
        }
        try {
            if (this.a.a == null || this.a.a.a == null || this.a.a.a.size() <= 0) {
                return a(this.a);
            }
            ArrayList arrayList = new ArrayList(this.a.a.a);
            arrayList.add(new g() {
                public m a(g.a aVar) throws IOException {
                    return a.this.a(aVar.a());
                }
            });
            return ((g) arrayList.get(0)).a(new b(arrayList, this.a));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011d, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0124, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0125, code lost:
        r6.b.d().remove(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012e, code lost:
        throw r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x011f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.bytedance.sdk.component.b.a.m a(com.bytedance.sdk.component.b.a.k r7) throws java.io.IOException {
        /*
            r6 = this;
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.f r1 = r7.b()     // Catch:{ Exception -> 0x011f }
            java.net.URL r1 = r1.a()     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x011f }
            r0.<init>(r1)     // Catch:{ Exception -> 0x011f }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x011f }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ Exception -> 0x011f }
            java.util.Map r1 = r7.d()     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x005f
            java.util.Map r1 = r7.d()     // Catch:{ Exception -> 0x011f }
            int r1 = r1.size()     // Catch:{ Exception -> 0x011f }
            if (r1 <= 0) goto L_0x005f
            java.util.Map r1 = r7.d()     // Catch:{ Exception -> 0x011f }
            java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x011f }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x011f }
        L_0x0033:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x011f }
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x011f }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ Exception -> 0x011f }
            java.lang.Object r3 = r2.getValue()     // Catch:{ Exception -> 0x011f }
            java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x011f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x011f }
        L_0x0049:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x011f }
            if (r4 == 0) goto L_0x0033
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x011f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x011f }
            java.lang.Object r5 = r2.getKey()     // Catch:{ Exception -> 0x011f }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x011f }
            r0.addRequestProperty(r5, r4)     // Catch:{ Exception -> 0x011f }
            goto L_0x0049
        L_0x005f:
            com.bytedance.sdk.component.b.a.l r1 = r7.f()     // Catch:{ Exception -> 0x011f }
            if (r1 != 0) goto L_0x006b
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x011f }
            goto L_0x00c2
        L_0x006b:
            boolean r1 = r6.c()     // Catch:{ Exception -> 0x011f }
            if (r1 != 0) goto L_0x0098
            com.bytedance.sdk.component.b.a.l r1 = r7.f()     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.h r1 = r1.a     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x0098
            com.bytedance.sdk.component.b.a.l r1 = r7.f()     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.h r1 = r1.a     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = r1.a()     // Catch:{ Exception -> 0x011f }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x011f }
            if (r1 != 0) goto L_0x0098
            java.lang.String r1 = "Content-Type"
            com.bytedance.sdk.component.b.a.l r2 = r7.f()     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.h r2 = r2.a     // Catch:{ Exception -> 0x011f }
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x011f }
            r0.addRequestProperty(r1, r2)     // Catch:{ Exception -> 0x011f }
        L_0x0098:
            java.lang.String r1 = r7.c()     // Catch:{ Exception -> 0x011f }
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x011f }
            java.lang.String r1 = "POST"
            java.lang.String r2 = r7.c()     // Catch:{ Exception -> 0x011f }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x00c2
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.l r2 = r7.f()     // Catch:{ Exception -> 0x011f }
            java.lang.String r2 = r2.b     // Catch:{ Exception -> 0x011f }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x011f }
            r1.write(r2)     // Catch:{ Exception -> 0x011f }
            r1.flush()     // Catch:{ Exception -> 0x011f }
            r1.close()     // Catch:{ Exception -> 0x011f }
        L_0x00c2:
            com.bytedance.sdk.component.b.a.i r1 = r7.a     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x00f2
            com.bytedance.sdk.component.b.a.i r1 = r7.a     // Catch:{ Exception -> 0x011f }
            java.util.concurrent.TimeUnit r1 = r1.c     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x00dc
            com.bytedance.sdk.component.b.a.i r1 = r7.a     // Catch:{ Exception -> 0x011f }
            java.util.concurrent.TimeUnit r1 = r1.c     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.i r2 = r7.a     // Catch:{ Exception -> 0x011f }
            long r2 = r2.b     // Catch:{ Exception -> 0x011f }
            long r1 = r1.toMillis(r2)     // Catch:{ Exception -> 0x011f }
            int r1 = (int) r1     // Catch:{ Exception -> 0x011f }
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x011f }
        L_0x00dc:
            com.bytedance.sdk.component.b.a.i r1 = r7.a     // Catch:{ Exception -> 0x011f }
            java.util.concurrent.TimeUnit r1 = r1.c     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x00f2
            com.bytedance.sdk.component.b.a.i r1 = r7.a     // Catch:{ Exception -> 0x011f }
            java.util.concurrent.TimeUnit r1 = r1.e     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.i r2 = r7.a     // Catch:{ Exception -> 0x011f }
            long r2 = r2.d     // Catch:{ Exception -> 0x011f }
            long r1 = r1.toMillis(r2)     // Catch:{ Exception -> 0x011f }
            int r1 = (int) r1     // Catch:{ Exception -> 0x011f }
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x011f }
        L_0x00f2:
            r0.connect()     // Catch:{ Exception -> 0x011f }
            r0.getResponseCode()     // Catch:{ Exception -> 0x011f }
            java.util.concurrent.atomic.AtomicBoolean r1 = c     // Catch:{ Exception -> 0x011f }
            boolean r1 = r1.get()     // Catch:{ Exception -> 0x011f }
            if (r1 == 0) goto L_0x010e
            r0.disconnect()     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.d r7 = r6.b
            java.util.List r7 = r7.d()
            r7.remove(r6)
            r7 = 0
            return r7
        L_0x010e:
            com.bytedance.sdk.component.b.a.a.a.f r1 = new com.bytedance.sdk.component.b.a.a.a.f     // Catch:{ Exception -> 0x011f }
            r1.<init>(r0, r7)     // Catch:{ Exception -> 0x011f }
            com.bytedance.sdk.component.b.a.d r7 = r6.b
            java.util.List r7 = r7.d()
            r7.remove(r6)
            return r1
        L_0x011d:
            r7 = move-exception
            goto L_0x0125
        L_0x011f:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x011d }
            r7.<init>()     // Catch:{ all -> 0x011d }
            throw r7     // Catch:{ all -> 0x011d }
        L_0x0125:
            com.bytedance.sdk.component.b.a.d r0 = r6.b
            java.util.List r0 = r0.d()
            r0.remove(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.a.a.a.a.a(com.bytedance.sdk.component.b.a.k):com.bytedance.sdk.component.b.a.m");
    }

    private boolean c() {
        if (this.a.d() == null) {
            return false;
        }
        return this.a.d().containsKey(HttpHeaders.CONTENT_TYPE);
    }

    public void a(final c cVar) {
        this.b.b().submit(new Runnable() {
            public void run() {
                try {
                    m a2 = a.this.a();
                    if (a2 == null) {
                        cVar.a((b) a.this, new IOException("response is null"));
                    } else {
                        cVar.a((b) a.this, a2);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    cVar.a((b) a.this, e);
                }
            }
        });
    }

    /* renamed from: b */
    public b clone() {
        return new a(this.a, this.b);
    }
}
