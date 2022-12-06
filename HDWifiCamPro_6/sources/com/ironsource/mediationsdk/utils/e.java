package com.ironsource.mediationsdk.utils;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0149b;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public final class e {
    public Map<String, Integer> a;
    d b;
    public IronSourceLoggerManager c;
    private Map<String, Integer> d;
    private Map<String, String> e;
    private String f;
    private Timer g = null;

    public e(String str, d dVar) {
        this.f = str;
        this.b = dVar;
        this.a = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.c = IronSourceLoggerManager.getLogger();
        a();
    }

    private void a(String str, int i) {
        this.d.put(str, Integer.valueOf(i));
        this.e.put(str, c());
        IronSourceUtils.saveIntToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), e(str), i);
        IronSourceUtils.saveStringToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), f(str), c());
    }

    private int b(String str) {
        if (!c().equalsIgnoreCase(c(str))) {
            a(str);
        }
        return d(str);
    }

    private static Date b() {
        Random random = new Random();
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"), Locale.US);
        gregorianCalendar.set(11, 0);
        gregorianCalendar.set(12, random.nextInt(10));
        gregorianCalendar.set(13, random.nextInt(60));
        gregorianCalendar.set(14, random.nextInt(1000));
        gregorianCalendar.add(5, 1);
        return gregorianCalendar.getTime();
    }

    private static String c() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    private String c(String str) {
        if (this.e.containsKey(str)) {
            return this.e.get(str);
        }
        String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(ContextProvider.getInstance().getApplicationContext(), f(str), c());
        this.e.put(str, stringFromSharedPrefs);
        return stringFromSharedPrefs;
    }

    private int d(String str) {
        if (this.d.containsKey(str)) {
            return this.d.get(str).intValue();
        }
        int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(ContextProvider.getInstance().getApplicationContext(), e(str), 0);
        this.d.put(str, Integer.valueOf(intFromSharedPrefs));
        return intFromSharedPrefs;
    }

    private static String e(String str) {
        return str + "_counter";
    }

    private static String f(String str) {
        return str + "_day";
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Timer timer = this.g;
        if (timer != null) {
            timer.cancel();
        }
        this.g = new Timer();
        this.g.schedule(new TimerTask() {
            public final void run() {
                e eVar = e.this;
                synchronized (eVar) {
                    try {
                        for (String a2 : eVar.a.keySet()) {
                            eVar.a(a2);
                        }
                        eVar.b.g();
                        eVar.a();
                    } catch (Exception e) {
                        eVar.c.logException(IronSourceLogger.IronSourceTag.INTERNAL, "onTimerTick", e);
                    }
                }
            }
        }, b());
    }

    public final void a(C0149b bVar) {
        synchronized (this) {
            try {
                String d2 = d(bVar);
                if (this.a.containsKey(d2)) {
                    a(d2, b(d2) + 1);
                }
            } catch (Exception e2) {
                this.c.logException(IronSourceLogger.IronSourceTag.INTERNAL, "increaseShowCounter", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.d.put(str, 0);
        this.e.put(str, c());
        IronSourceUtils.saveIntToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), e(str), 0);
        IronSourceUtils.saveStringToSharedPrefs(ContextProvider.getInstance().getApplicationContext(), f(str), c());
    }

    public final boolean b(C0149b bVar) {
        synchronized (this) {
            boolean z = false;
            try {
                String d2 = d(bVar);
                if (!this.a.containsKey(d2)) {
                    return false;
                }
                if (c().equalsIgnoreCase(c(d2))) {
                    return false;
                }
                if (this.a.get(d2).intValue() <= d(d2)) {
                    z = true;
                }
                return z;
            } catch (Exception e2) {
                this.c.logException(IronSourceLogger.IronSourceTag.INTERNAL, "shouldSendCapReleasedEvent", e2);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(C0149b bVar) {
        synchronized (this) {
            boolean z = false;
            try {
                String d2 = d(bVar);
                if (!this.a.containsKey(d2)) {
                    return false;
                }
                if (this.a.get(d2).intValue() <= b(d2)) {
                    z = true;
                }
                return z;
            } catch (Exception e2) {
                this.c.logException(IronSourceLogger.IronSourceTag.INTERNAL, "isCapped", e2);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String d(C0149b bVar) {
        return this.f + "_" + bVar.f + "_" + bVar.j();
    }
}
