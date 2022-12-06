package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.a.b;
import com.meizu.cloud.pushsdk.a.a.d;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class a {
    private static final String a = "a";
    private static a d;
    private final Set<b> b = new HashSet();
    private AtomicInteger c = new AtomicInteger();

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public int b() {
        return this.c.incrementAndGet();
    }

    public b a(b bVar) {
        synchronized (this.b) {
            try {
                this.b.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            bVar.a(b());
            if (bVar.d() == d.IMMEDIATE) {
                bVar.a((Future) com.meizu.cloud.pushsdk.a.b.b.a().b().b().submit(new c(bVar)));
            } else {
                bVar.a((Future) com.meizu.cloud.pushsdk.a.b.b.a().b().a().submit(new c(bVar)));
            }
            com.meizu.cloud.pushsdk.a.a.a.a("addRequest: after addition - mCurrentRequests size: " + this.b.size());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bVar;
    }

    public void b(b bVar) {
        synchronized (this.b) {
            try {
                this.b.remove(bVar);
                com.meizu.cloud.pushsdk.a.a.a.a("finish: after removal - mCurrentRequests size: " + this.b.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
