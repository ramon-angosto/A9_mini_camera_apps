package com.ironsource.mediationsdk.adunit.e;

import android.text.TextUtils;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.c.b.a;
import com.ironsource.mediationsdk.adunit.d.a.c;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a<Smash extends c<?>> {
    ConcurrentHashMap<String, CopyOnWriteArrayList<Smash>> a = new ConcurrentHashMap<>();
    public String b = "";
    private String c = "";
    private c<?> d;
    private final List<String> e;
    private final int f;
    private final Timer g = new Timer();
    private b h;
    private final int i = 5;

    public a(List<String> list, int i2, b bVar) {
        this.e = list;
        this.f = i2;
        this.h = bVar;
    }

    private synchronized void b() {
        if (this.d != null) {
            this.d.o();
        }
    }

    private synchronized boolean c() {
        return this.d != null && this.d.p() && this.d.n().equals(this.c);
    }

    private void d() {
        Iterator it = a().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!cVar.equals(this.d)) {
                cVar.o();
            }
        }
    }

    public final CopyOnWriteArrayList<Smash> a() {
        CopyOnWriteArrayList<Smash> copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public final void a(a.C0091a aVar, CopyOnWriteArrayList<Smash> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        d();
        if (aVar == a.C0091a.AUTOMATIC_LOAD_WHILE_SHOW) {
            this.a.put(str, copyOnWriteArrayList);
            if (!TextUtils.isEmpty(this.c)) {
                if (c()) {
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.verbose("ad from previous waterfall " + this.c + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                    String str2 = this.b;
                    this.b = this.c;
                    this.c = str2;
                }
                final String str3 = this.c;
                this.g.schedule(new TimerTask() {
                    public final void run() {
                        try {
                            IronLog ironLog = IronLog.INTERNAL;
                            ironLog.verbose("removing waterfall with id " + str3 + " from memory");
                            a.this.a.remove(str3);
                            IronLog ironLog2 = IronLog.INTERNAL;
                            ironLog2.verbose("waterfall size is currently " + a.this.a.size());
                        } finally {
                            cancel();
                        }
                    }
                }, (long) this.f);
            }
        } else {
            this.a.clear();
            this.a.put(str, copyOnWriteArrayList);
        }
        this.c = this.b;
        this.b = str;
        if (this.a.size() > 5) {
            this.h.a(this.a.size());
        }
    }

    public final synchronized void a(c<?> cVar) {
        IronLog.INTERNAL.verbose("");
        if (this.d != null && !this.d.equals(cVar)) {
            b();
        }
        this.d = cVar;
    }

    public final synchronized boolean a(a.C0091a aVar, String str, String str2, LoadWhileShowSupportState loadWhileShowSupportState) {
        boolean z;
        z = true;
        if (aVar == a.C0091a.AUTOMATIC_LOAD_WHILE_SHOW) {
            if (this.d != null) {
                if (this.d.p()) {
                    if (loadWhileShowSupportState != LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK || !this.d.k().equals(str)) {
                        if ((loadWhileShowSupportState == LoadWhileShowSupportState.NONE || this.e.contains(str2)) && this.d.m().equals(str2)) {
                        }
                    }
                    z = false;
                }
            }
        }
        if (!z) {
            IronLog.INTERNAL.verbose(str + " does not support load while show and will not be added to the auction request");
        }
        return z;
    }
}
