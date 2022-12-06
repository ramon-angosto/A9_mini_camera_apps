package com.meizu.cloud.pushsdk.b.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.b.a.b;
import com.meizu.cloud.pushsdk.b.f.c;
import com.meizu.cloud.pushsdk.b.f.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {
    private static String a = "a";
    private String b;
    private String c = null;
    private String d;
    private int e = 0;
    private String f = "SQLITE";
    private AtomicBoolean g = new AtomicBoolean(false);
    private long h;
    private long i;
    private long j;
    private Context k;

    public a(long j2, long j3, TimeUnit timeUnit, Context context) {
        this.i = timeUnit.toMillis(j2);
        this.j = timeUnit.toMillis(j3);
        this.k = context;
        Map f2 = f();
        if (f2 == null) {
            this.b = e.b();
        } else {
            try {
                String obj = f2.get("userId").toString();
                String obj2 = f2.get("sessionId").toString();
                int intValue = ((Integer) f2.get("sessionIndex")).intValue();
                this.b = obj;
                this.e = intValue;
                this.c = obj2;
            } catch (Exception e2) {
                c.a(a, "Exception occurred retrieving session info from file: %s", e2.getMessage());
                this.b = e.b();
            }
        }
        d();
        g();
        c.c(a, "Tracker Session Object created.", new Object[0]);
    }

    public b a() {
        c.c(a, "Getting session context...", new Object[0]);
        g();
        return new b("client_session", c());
    }

    public void b() {
        long j2;
        c.b(a, "Checking and updating session information.", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.g.get()) {
            j2 = this.j;
        } else {
            j2 = this.i;
        }
        if (!e.a(this.h, currentTimeMillis, j2)) {
            d();
            g();
        }
    }

    public Map c() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.b);
        hashMap.put("sessionId", this.c);
        hashMap.put("previousSessionId", this.d);
        hashMap.put("sessionIndex", Integer.valueOf(this.e));
        hashMap.put("storageMechanism", this.f);
        return hashMap;
    }

    private void d() {
        this.d = this.c;
        this.c = e.b();
        this.e++;
        c.b(a, "Session information is updated:", new Object[0]);
        c.b(a, " + Session ID: %s", this.c);
        c.b(a, " + Previous Session ID: %s", this.d);
        c.b(a, " + Session Index: %s", Integer.valueOf(this.e));
        e();
    }

    private boolean e() {
        return com.meizu.cloud.pushsdk.b.f.a.a("snowplow_session_vars", c(), this.k);
    }

    private Map f() {
        return com.meizu.cloud.pushsdk.b.f.a.a("snowplow_session_vars", this.k);
    }

    private void g() {
        this.h = System.currentTimeMillis();
    }
}
