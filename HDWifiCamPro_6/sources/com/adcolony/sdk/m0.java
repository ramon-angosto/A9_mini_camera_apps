package com.adcolony.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.adcolony.sdk.e0;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class m0 {
    private ScheduledExecutorService a;
    private ScheduledFuture<?> b;
    private String c;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            m0.this.c();
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            m0.this.f();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            m0.this.d();
        }
    }

    m0() {
    }

    /* access modifiers changed from: private */
    public void d() {
        String e = e();
        if (!e.equals(this.c)) {
            this.c = e;
            f1 b2 = c0.b();
            c0.a(b2, "network_type", e);
            new h0("Network.on_status_change", 1, b2).c();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        ScheduledFuture<?> scheduledFuture = this.b;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isCancelled()) {
                this.b.cancel(false);
            }
            this.b = null;
        }
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return a();
    }

    private String a() {
        NetworkInfo networkInfo;
        Context a2 = a.a();
        if (a2 == null) {
            return "none";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) a2.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                networkInfo = null;
            } else {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo == null) {
                return "none";
            }
            int type = networkInfo.getType();
            if (type == 1) {
                return "wifi";
            }
            if (type == 0) {
                return "cell";
            }
            if (type >= 2) {
                return "cell";
            }
            return "none";
        } catch (SecurityException e) {
            new e0.a().a("SecurityException - please ensure you added the ").a("ACCESS_NETWORK_STATE permission: ").a(e.toString()).a(e0.h);
            return "none";
        } catch (Exception e2) {
            new e0.a().a("Exception occurred when retrieving activeNetworkInfo in ").a("ADCNetwork.getConnectivityStatus(): ").a(e2.toString()).a(e0.i);
            return "none";
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.a == null) {
            this.a = Executors.newSingleThreadScheduledExecutor();
        }
        if (this.b == null) {
            try {
                this.b = this.a.scheduleAtFixedRate(new c(), 0, 1000, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                new e0.a().a("Error when scheduling network checks: ").a(e.toString()).a(e0.i);
            }
            d();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.c = e();
        a.a("Network.start_notifications", (j0) new a());
        a.a("Network.stop_notifications", (j0) new b());
    }
}
