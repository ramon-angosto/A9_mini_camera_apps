package com.adcolony.sdk;

import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class g0 {
    static boolean f = false;
    static int g = 3;
    static int h = 1;
    /* access modifiers changed from: private */
    public f1 a = c0.b();
    private e1 b = null;
    private ExecutorService c = null;
    private final Queue<Runnable> d = new ConcurrentLinkedQueue();
    s0 e;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 0, c0.h(h0Var.a(), "message"), true);
        }
    }

    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;

        b(int i, String str, int i2, boolean z) {
            this.a = i;
            this.b = str;
            this.c = i2;
            this.d = z;
        }

        public void run() {
            g0.this.a(this.a, this.b, this.c);
            int i = 0;
            while (i <= this.b.length() / PAGSdk.INIT_LOCAL_FAIL_CODE) {
                int i2 = i * PAGSdk.INIT_LOCAL_FAIL_CODE;
                i++;
                int min = Math.min(i * PAGSdk.INIT_LOCAL_FAIL_CODE, this.b.length());
                if (this.c == 3) {
                    g0 g0Var = g0.this;
                    if (g0Var.a(c0.f(g0Var.a, Integer.toString(this.a)), 3, this.d)) {
                        Log.d("AdColony [TRACE]", this.b.substring(i2, min));
                    }
                }
                if (this.c == 2) {
                    g0 g0Var2 = g0.this;
                    if (g0Var2.a(c0.f(g0Var2.a, Integer.toString(this.a)), 2, this.d)) {
                        Log.i("AdColony [INFO]", this.b.substring(i2, min));
                    }
                }
                if (this.c == 1) {
                    g0 g0Var3 = g0.this;
                    if (g0Var3.a(c0.f(g0Var3.a, Integer.toString(this.a)), 1, this.d)) {
                        Log.w("AdColony [WARNING]", this.b.substring(i2, min));
                    }
                }
                if (this.c == 0) {
                    g0 g0Var4 = g0.this;
                    if (g0Var4.a(c0.f(g0Var4.a, Integer.toString(this.a)), 0, this.d)) {
                        Log.e("AdColony [ERROR]", this.b.substring(i2, min));
                    }
                }
                if (this.c == -1 && g0.g >= -1) {
                    Log.e("AdColony [FATAL]", this.b.substring(i2, min));
                }
            }
        }
    }

    class c implements j0 {
        c(g0 g0Var) {
        }

        public void a(h0 h0Var) {
            g0.g = c0.d(h0Var.a(), "level");
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 3, c0.h(h0Var.a(), "message"), false);
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 3, c0.h(h0Var.a(), "message"), true);
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 2, c0.h(h0Var.a(), "message"), false);
        }
    }

    class g implements j0 {
        g() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 2, c0.h(h0Var.a(), "message"), true);
        }
    }

    class h implements j0 {
        h() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 1, c0.h(h0Var.a(), "message"), false);
        }
    }

    class i implements j0 {
        i() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 1, c0.h(h0Var.a(), "message"), true);
        }
    }

    class j implements j0 {
        j() {
        }

        public void a(h0 h0Var) {
            g0.this.b(c0.d(h0Var.a(), "module"), 0, c0.h(h0Var.a(), "message"), false);
        }
    }

    g0() {
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3, String str, boolean z) {
        if (!a(a(i2, i3, str, z))) {
            synchronized (this.d) {
                this.d.add(a(i2, i3, str, z));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        a.a("Log.set_log_level", (j0) new c(this));
        a.a("Log.public.trace", (j0) new d());
        a.a("Log.private.trace", (j0) new e());
        a.a("Log.public.info", (j0) new f());
        a.a("Log.private.info", (j0) new g());
        a.a("Log.public.warning", (j0) new h());
        a.a("Log.private.warning", (j0) new i());
        a.a("Log.public.error", (j0) new j());
        a.a("Log.private.error", (j0) new a());
    }

    /* access modifiers changed from: package-private */
    public void d() {
        ExecutorService executorService = this.c;
        if (executorService == null || executorService.isShutdown() || this.c.isTerminated()) {
            this.c = Executors.newSingleThreadExecutor();
        }
        synchronized (this.d) {
            while (!this.d.isEmpty()) {
                a(this.d.poll());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, boolean z) {
        b(0, i2, str, z);
    }

    private Runnable a(int i2, int i3, String str, boolean z) {
        return new b(i2, str, i3, z);
    }

    /* access modifiers changed from: package-private */
    public boolean a(f1 f1Var, int i2, boolean z) {
        int d2 = c0.d(f1Var, "print_level");
        boolean b2 = c0.b(f1Var, "log_private");
        if (f1Var.b()) {
            d2 = g;
            b2 = f;
        }
        return (!z || b2) && d2 != 4 && d2 >= i2;
    }

    /* access modifiers changed from: package-private */
    public void b(e1 e1Var) {
        this.a = a(e1Var);
    }

    /* access modifiers changed from: package-private */
    public e1 b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public boolean a(f1 f1Var, int i2) {
        int d2 = c0.d(f1Var, "send_level");
        if (f1Var.b()) {
            d2 = h;
        }
        return d2 >= i2 && d2 != 4;
    }

    /* access modifiers changed from: package-private */
    public void a(HashMap<String, Object> hashMap) {
        try {
            s0 s0Var = new s0(new d0(new URL("https://wd.adcolony.com/logs")), Executors.newSingleThreadScheduledExecutor(), hashMap);
            this.e = s0Var;
            s0Var.a(5, TimeUnit.SECONDS);
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, int i3) {
        if (this.e != null) {
            if (i3 == 3 && a(c0.f(this.a, Integer.toString(i2)), 3)) {
                this.e.a(str);
            } else if (i3 == 2 && a(c0.f(this.a, Integer.toString(i2)), 2)) {
                this.e.c(str);
            } else if (i3 == 1 && a(c0.f(this.a, Integer.toString(i2)), 1)) {
                this.e.d(str);
            } else if (i3 == 0 && a(c0.f(this.a, Integer.toString(i2)), 0)) {
                this.e.b(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public f1 a(e1 e1Var) {
        f1 b2 = c0.b();
        for (int i2 = 0; i2 < e1Var.b(); i2++) {
            f1 a2 = c0.a(e1Var, i2);
            c0.a(b2, Integer.toString(c0.d(a2, "id")), a2);
        }
        return b2;
    }

    private boolean a(Runnable runnable) {
        try {
            ExecutorService executorService = this.c;
            if (executorService == null || executorService.isShutdown() || this.c.isTerminated()) {
                return false;
            }
            this.c.submit(runnable);
            return true;
        } catch (RejectedExecutionException unused) {
            Log.e("ADCLogError", "Internal error when submitting log to executor service.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(e1 e1Var) {
        if (e1Var != null) {
            e1Var.b("level");
            e1Var.b("message");
        }
        this.b = e1Var;
    }

    /* access modifiers changed from: package-private */
    public s0 a() {
        return this.e;
    }
}
