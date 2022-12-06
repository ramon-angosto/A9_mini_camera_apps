package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.ak */
public class C1618ak {

    /* renamed from: a */
    private static volatile C1618ak f1767a;

    /* renamed from: a */
    private SharedPreferences f1768a;

    /* renamed from: a */
    private Object f1769a = new Object();

    /* renamed from: a */
    private Map<String, ScheduledFuture> f1770a = new HashMap();

    /* renamed from: a */
    private ScheduledThreadPoolExecutor f1771a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: com.xiaomi.push.ak$a */
    public static abstract class C1619a implements Runnable {
        /* renamed from: a */
        public abstract String mo16986a();
    }

    /* renamed from: com.xiaomi.push.ak$b */
    private static class C1620b implements Runnable {

        /* renamed from: a */
        C1619a f1772a;

        public C1620b(C1619a aVar) {
            this.f1772a = aVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo17220a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo17221b() {
        }

        public void run() {
            mo17220a();
            this.f1772a.run();
            mo17221b();
        }
    }

    private C1618ak(Context context) {
        this.f1768a = context.getSharedPreferences("mipush_extra", 0);
    }

    /* renamed from: a */
    public static C1618ak m2518a(Context context) {
        if (f1767a == null) {
            synchronized (C1618ak.class) {
                if (f1767a == null) {
                    f1767a = new C1618ak(context);
                }
            }
        }
        return f1767a;
    }

    /* renamed from: a */
    private static String mo17218a(String str) {
        return "last_job_time" + str;
    }

    /* renamed from: a */
    private ScheduledFuture mo17214a(C1619a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f1769a) {
            scheduledFuture = this.f1770a.get(aVar.mo16986a());
        }
        return scheduledFuture;
    }

    /* renamed from: a */
    public void mo17212a(Runnable runnable) {
        mo17213a(runnable, 0);
    }

    /* renamed from: a */
    public void mo17213a(Runnable runnable, int i) {
        this.f1771a.schedule(runnable, (long) i, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public boolean m2525a(C1619a aVar) {
        return mo17219b(aVar, 0);
    }

    /* renamed from: a */
    public boolean mo17215a(C1619a aVar, int i) {
        return mo17216a(aVar, i, 0);
    }

    /* renamed from: a */
    public boolean mo17216a(C1619a aVar, int i, int i2) {
        return mo17217a(aVar, i, i2, false);
    }

    /* renamed from: a */
    public boolean mo17217a(C1619a aVar, int i, int i2, boolean z) {
        if (aVar == null || mo17214a(aVar) != null) {
            return false;
        }
        String a = mo17218a(aVar.mo16986a());
        C1621al alVar = new C1621al(this, aVar, z, a);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f1768a.getLong(a, 0)) / 1000;
            if (abs < ((long) (i - i2))) {
                i2 = (int) (((long) i) - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f1771a.scheduleAtFixedRate(alVar, (long) i2, (long) i, TimeUnit.SECONDS);
            synchronized (this.f1769a) {
                this.f1770a.put(aVar.mo16986a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
            return true;
        }
    }

    /* renamed from: a */
    public boolean m2529a(String str) {
        synchronized (this.f1769a) {
            ScheduledFuture scheduledFuture = this.f1770a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f1770a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: b */
    public boolean mo17219b(C1619a aVar, int i) {
        if (aVar == null || mo17214a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f1771a.schedule(new C1622am(this, aVar), (long) i, TimeUnit.SECONDS);
        synchronized (this.f1769a) {
            this.f1770a.put(aVar.mo16986a(), schedule);
        }
        return true;
    }
}
