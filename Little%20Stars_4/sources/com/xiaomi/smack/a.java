package com.xiaomi.smack;

import android.support.v4.os.EnvironmentCompat;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.y;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.f;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {
    public static boolean a;
    private static final AtomicInteger q = new AtomicInteger(0);
    protected int b = 0;
    protected long c = -1;
    protected volatile long d = 0;
    protected volatile long e = 0;
    protected int f;
    protected final Map<f, C0056a> g = new ConcurrentHashMap();
    protected final Map<f, C0056a> h = new ConcurrentHashMap();
    protected com.xiaomi.smack.debugger.a i = null;
    protected Reader j;
    protected Writer k;
    protected String l = "";
    protected String m = "";
    protected final int n = q.getAndIncrement();
    protected b o;
    protected XMPushService p;
    private LinkedList<Pair<Integer, Long>> r = new LinkedList<>();
    private final Collection<d> s = new CopyOnWriteArrayList();
    private int t = 2;
    private long u = 0;

    /* renamed from: com.xiaomi.smack.a$a  reason: collision with other inner class name */
    protected static class C0056a {
        private f a;
        private com.xiaomi.smack.filter.a b;

        public C0056a(f fVar, com.xiaomi.smack.filter.a aVar) {
            this.a = fVar;
            this.b = aVar;
        }

        public void a(d dVar) {
            com.xiaomi.smack.filter.a aVar = this.b;
            if (aVar == null || aVar.a(dVar)) {
                this.a.a(dVar);
            }
        }
    }

    static {
        a = false;
        try {
            a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        j.a();
    }

    protected a(XMPushService xMPushService, b bVar) {
        this.o = bVar;
        this.p = xMPushService;
    }

    private String a(int i2) {
        return i2 == 1 ? "connected" : i2 == 0 ? "connecting" : i2 == 2 ? "disconnected" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private void b(int i2) {
        synchronized (this.r) {
            if (i2 == 1) {
                this.r.clear();
            } else {
                this.r.add(new Pair(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())));
                if (this.r.size() > 6) {
                    this.r.remove(0);
                }
            }
        }
    }

    public b a() {
        return this.o;
    }

    public void a(int i2, int i3, Exception exc) {
        int i4 = this.t;
        if (i2 != i4) {
            b.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{a(i4), a(i2), aa.a(i3)}));
        }
        if (com.xiaomi.channel.commonutils.network.d.d(this.p)) {
            b(i2);
        }
        if (i2 == 1) {
            this.p.a(10);
            if (this.t != 0) {
                b.a("try set connected while not connecting.");
            }
            this.t = i2;
            for (d a2 : this.s) {
                a2.a(this);
            }
        } else if (i2 == 0) {
            if (this.t != 2) {
                b.a("try set connecting while not disconnected.");
            }
            this.t = i2;
            for (d b2 : this.s) {
                b2.b(this);
            }
        } else if (i2 == 2) {
            this.p.a(10);
            int i5 = this.t;
            if (i5 == 0) {
                for (d a3 : this.s) {
                    a3.a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i5 == 1) {
                for (d a4 : this.s) {
                    a4.a(this, i3, exc);
                }
            }
            this.t = i2;
        }
    }

    public abstract void a(y.b bVar);

    public void a(d dVar) {
        if (dVar != null && !this.s.contains(dVar)) {
            this.s.add(dVar);
        }
    }

    public void a(f fVar, com.xiaomi.smack.filter.a aVar) {
        if (fVar != null) {
            this.g.put(fVar, new C0056a(fVar, aVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    public abstract void a(d dVar);

    public abstract void a(f fVar, int i2, Exception exc);

    public synchronized void a(String str) {
        if (this.t == 0) {
            b.a("setChallenge hash = " + c.a(str).substring(0, 8));
            this.l = str;
            a(1, 0, (Exception) null);
        } else {
            b.a("ignore setChallenge because connection was disconnected");
        }
    }

    public abstract void a(String str, String str2);

    public abstract void a(d[] dVarArr);

    public synchronized boolean a(long j2) {
        return this.u >= j2;
    }

    public String b() {
        return this.o.c();
    }

    public void b(d dVar) {
        this.s.remove(dVar);
    }

    public void b(f fVar, com.xiaomi.smack.filter.a aVar) {
        if (fVar != null) {
            this.h.put(fVar, new C0056a(fVar, aVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* access modifiers changed from: protected */
    public void b(d dVar) {
        for (C0056a a2 : this.h.values()) {
            a2.a(dVar);
        }
    }

    public String c() {
        return this.o.f();
    }

    public String d() {
        return this.o.d();
    }

    public int e() {
        return this.f;
    }

    public long f() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public void g() {
        Writer writer;
        String str;
        if (this.j != null && this.k != null && this.o.g()) {
            com.xiaomi.smack.debugger.a aVar = this.i;
            if (aVar == null) {
                Class<?> cls = null;
                try {
                    str = System.getProperty("smack.debuggerClass");
                } catch (Throwable unused) {
                    str = null;
                }
                if (str != null) {
                    try {
                        cls = Class.forName(str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (cls == null) {
                    this.i = new com.xiaomi.measite.smack.a(this, this.k, this.j);
                } else {
                    try {
                        this.i = (com.xiaomi.smack.debugger.a) cls.getConstructor(new Class[]{a.class, Writer.class, Reader.class}).newInstance(new Object[]{this, this.k, this.j});
                    } catch (Exception e3) {
                        throw new IllegalArgumentException("Can't initialize the configured debugger!", e3);
                    }
                }
                this.j = this.i.a();
                writer = this.i.b();
            } else {
                this.j = aVar.a(this.j);
                writer = this.i.a(this.k);
            }
            this.k = writer;
        }
    }

    public boolean h() {
        return this.t == 0;
    }

    public boolean i() {
        return this.t == 1;
    }

    public int j() {
        return this.b;
    }

    public void k() {
        this.b = 0;
    }

    public long l() {
        return this.c;
    }

    public void m() {
        this.c = -1;
    }

    public abstract void n();

    public int o() {
        return this.t;
    }

    public synchronized void p() {
        this.u = System.currentTimeMillis();
    }

    public synchronized boolean q() {
        return System.currentTimeMillis() - this.u < ((long) j.b());
    }

    public void r() {
        synchronized (this.r) {
            this.r.clear();
        }
    }
}
