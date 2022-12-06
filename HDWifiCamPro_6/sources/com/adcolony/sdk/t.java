package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import com.adcolony.sdk.s;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class t implements s.a {
    private LinkedBlockingQueue<Runnable> a = new LinkedBlockingQueue<>();
    private int b = 4;
    private int c = 16;
    private double d = 1.0d;
    private ThreadPoolExecutor e = new ThreadPoolExecutor(this.b, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, this.a);

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            t tVar = t.this;
            tVar.a(new s(h0Var, tVar));
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            t tVar = t.this;
            tVar.a(new s(h0Var, tVar));
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            t tVar = t.this;
            tVar.a(new s(h0Var, tVar));
        }
    }

    t() {
    }

    private void b() {
        int corePoolSize = this.e.getCorePoolSize();
        int size = this.a.size();
        int i = this.b;
        if (((double) size) * this.d > ((double) ((corePoolSize - i) + 1)) && corePoolSize < this.c) {
            this.e.setCorePoolSize(corePoolSize + 1);
        } else if (size == 0 && corePoolSize > i) {
            this.e.setCorePoolSize(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.e.allowCoreThreadTimeOut(true);
        a.a("WebServices.download", (j0) new a());
        a.a("WebServices.get", (j0) new b());
        a.a("WebServices.post", (j0) new c());
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        this.e.setKeepAliveTime((long) i, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public void b(int i) {
        this.c = i;
        int corePoolSize = this.e.getCorePoolSize();
        int i2 = this.c;
        if (corePoolSize > i2) {
            this.e.setCorePoolSize(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(s sVar) {
        b();
        try {
            this.e.execute(sVar);
        } catch (RejectedExecutionException unused) {
            e0.a a2 = new e0.a().a("RejectedExecutionException: ThreadPoolExecutor unable to ");
            a2.a("execute download for url " + sVar.l).a(e0.i);
            a(sVar, sVar.b(), (Map<String, List<String>>) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.b = i;
        int corePoolSize = this.e.getCorePoolSize();
        int i2 = this.b;
        if (corePoolSize < i2) {
            this.e.setCorePoolSize(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(double d2) {
        this.d = d2;
    }

    public void a(s sVar, h0 h0Var, Map<String, List<String>> map) {
        f1 b2 = c0.b();
        c0.a(b2, "url", sVar.l);
        c0.b(b2, "success", sVar.n);
        c0.b(b2, "status", sVar.p);
        c0.a(b2, TtmlNode.TAG_BODY, sVar.m);
        c0.b(b2, "size", sVar.o);
        if (map != null) {
            f1 b3 = c0.b();
            for (Map.Entry next : map.entrySet()) {
                String obj = ((List) next.getValue()).toString();
                String substring = obj.substring(1, obj.length() - 1);
                if (next.getKey() != null) {
                    c0.a(b3, (String) next.getKey(), substring);
                }
            }
            c0.a(b2, "headers", b3);
        }
        h0Var.a(b2).c();
    }
}
