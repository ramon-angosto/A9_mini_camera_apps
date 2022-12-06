package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class L {
    ConcurrentHashMap<String, CopyOnWriteArrayList<J>> a = new ConcurrentHashMap<>();
    String b = "";
    J c;
    private String d = "";
    private final List<String> e;
    private final int f;
    private final Timer g = new Timer();

    public L(List<String> list, int i) {
        this.e = list;
        this.f = i;
    }

    private synchronized boolean c() {
        return this.c != null && this.c.b.equals(this.d);
    }

    private void d() {
        Iterator<J> it = a().iterator();
        while (it.hasNext()) {
            Y next = it.next();
            if (!next.equals(this.c)) {
                next.d();
            }
        }
    }

    public final CopyOnWriteArrayList<J> a() {
        CopyOnWriteArrayList<J> copyOnWriteArrayList = this.a.get(this.b);
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList<>() : copyOnWriteArrayList;
    }

    public final synchronized void a(J j) {
        IronLog.INTERNAL.verbose("");
        if (this.c != null && !this.c.equals(j)) {
            this.c.d();
        }
        this.c = j;
    }

    public final void a(CopyOnWriteArrayList<J> copyOnWriteArrayList, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("updating new waterfall with id " + str);
        d();
        this.a.put(str, copyOnWriteArrayList);
        if (!TextUtils.isEmpty(this.d)) {
            if (c()) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("ad from previous waterfall " + this.d + " is still showing - the current waterfall " + this.b + " will be deleted instead");
                String str2 = this.b;
                this.b = this.d;
                this.d = str2;
            }
            final String str3 = this.d;
            this.g.schedule(new TimerTask() {
                public final void run() {
                    try {
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.verbose("removing waterfall with id " + str3 + " from memory");
                        L.this.a.remove(str3);
                        IronLog ironLog2 = IronLog.INTERNAL;
                        ironLog2.verbose("waterfall size is currently " + L.this.a.size());
                    } finally {
                        cancel();
                    }
                }
            }, (long) this.f);
        }
        this.d = this.b;
        this.b = str;
    }

    public final boolean b() {
        return this.a.size() > 5;
    }

    public final synchronized boolean b(J j) {
        boolean z;
        IronLog.INTERNAL.verbose("");
        if (j != null) {
            if (this.c != null) {
                if (j.c() != LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_NETWORK || !this.c.k().equals(j.k())) {
                    if ((j.c() == LoadWhileShowSupportState.NONE || this.e.contains(j.l())) && this.c.l().equals(j.l())) {
                    }
                }
            }
            z = false;
            if (z && j != null) {
                IronLog.INTERNAL.verbose(j.k() + " does not support load while show and will not be added to the auction request");
            }
        }
        z = true;
        IronLog.INTERNAL.verbose(j.k() + " does not support load while show and will not be added to the auction request");
        return !z;
    }
}
