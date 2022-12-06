package com.xiaomi.push;

import android.util.Pair;
import androidx.core.p003os.EnvironmentCompat;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.C2014bd;
import com.xiaomi.push.service.XMPushService;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.push.fu */
public abstract class C1809fu {

    /* renamed from: a */
    private static final AtomicInteger f2430a = new AtomicInteger(0);

    /* renamed from: a */
    public static boolean f2431a;

    /* renamed from: a */
    protected int f2432a = 0;

    /* renamed from: a */
    protected long f2433a = -1;

    /* renamed from: a */
    protected C1811fv f2434a;

    /* renamed from: a */
    protected C1824gg f2435a = null;

    /* renamed from: a */
    protected XMPushService f2436a;

    /* renamed from: a */
    protected String f2437a = "";

    /* renamed from: a */
    private final Collection<C1813fx> f2438a = new CopyOnWriteArrayList();

    /* renamed from: a */
    private LinkedList<Pair<Integer, Long>> f2439a = new LinkedList<>();

    /* renamed from: a */
    protected final Map<C1815fz, C1810a> f2440a = new ConcurrentHashMap();

    /* renamed from: b */
    protected final int f2441b = f2430a.getAndIncrement();

    /* renamed from: b */
    protected volatile long f2442b = 0;

    /* renamed from: b */
    protected String f2443b = "";

    /* renamed from: b */
    protected final Map<C1815fz, C1810a> f2444b = new ConcurrentHashMap();

    /* renamed from: c */
    private int f2445c = 2;

    /* renamed from: c */
    protected volatile long f2446c = 0;

    /* renamed from: d */
    protected long f2447d = 0;

    /* renamed from: e */
    private long f2448e = 0;

    /* renamed from: com.xiaomi.push.fu$a */
    public static class C1810a {

        /* renamed from: a */
        private C1815fz f2449a;

        /* renamed from: a */
        private C1825gh f2450a;

        public C1810a(C1815fz fzVar, C1825gh ghVar) {
            this.f2449a = fzVar;
            this.f2450a = ghVar;
        }

        /* renamed from: a */
        public void mo17668a(C1793fj fjVar) {
            this.f2449a.mo17650a(fjVar);
        }

        /* renamed from: a */
        public void mo17669a(C1830gl glVar) {
            C1825gh ghVar = this.f2450a;
            if (ghVar == null || ghVar.mo17651a(glVar)) {
                this.f2449a.mo17651a(glVar);
            }
        }
    }

    static {
        f2431a = false;
        try {
            f2431a = Boolean.getBoolean("smack.debugEnabled");
        } catch (Exception unused) {
        }
        C1818ga.m3676a();
    }

    protected C1809fu(XMPushService xMPushService, C1811fv fvVar) {
        this.f2434a = fvVar;
        this.f2436a = xMPushService;
        mo17661b();
    }

    /* renamed from: a */
    private String m3610a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    /* renamed from: a */
    private void m3611a(int i) {
        synchronized (this.f2439a) {
            if (i == 1) {
                this.f2439a.clear();
            } else {
                this.f2439a.add(new Pair(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.f2439a.size() > 6) {
                    this.f2439a.remove(0);
                }
            }
        }
    }

    /* renamed from: a */
    public int mo17639a() {
        return this.f2432a;
    }

    /* renamed from: a */
    public long m3613a() {
        return this.f2446c;
    }

    /* renamed from: a */
    public C1811fv m3614a() {
        return this.f2434a;
    }

    /* renamed from: a */
    public String m3615a() {
        return this.f2434a.mo17674c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Map<C1815fz, C1810a> m3616a() {
        return this.f2440a;
    }

    /* renamed from: a */
    public void mo17656a(int i, int i2, Exception exc) {
        int i3 = this.f2445c;
        if (i != i3) {
            C1524b.m2141a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{m3610a(i3), m3610a(i), C2014bd.m5114a(i2)}));
        }
        if (C1653bi.m2685b(this.f2436a)) {
            m3610a(i);
        }
        if (i == 1) {
            this.f2436a.mo18409a(10);
            if (this.f2445c != 0) {
                C1524b.m2141a("try set connected while not connecting.");
            }
            this.f2445c = i;
            for (C1813fx b : this.f2438a) {
                b.mo17655b(this);
            }
        } else if (i == 0) {
            if (this.f2445c != 2) {
                C1524b.m2141a("try set connecting while not disconnected.");
            }
            this.f2445c = i;
            for (C1813fx a : this.f2438a) {
                a.mo17652a(this);
            }
        } else if (i == 2) {
            this.f2436a.mo18409a(10);
            int i4 = this.f2445c;
            if (i4 == 0) {
                for (C1813fx a2 : this.f2438a) {
                    a2.mo17654a(this, exc == null ? new CancellationException("disconnect while connecting") : exc);
                }
            } else if (i4 == 1) {
                for (C1813fx a3 : this.f2438a) {
                    a3.mo17653a(this, i2, exc);
                }
            }
            this.f2445c = i;
        }
    }

    /* renamed from: a */
    public void mo17657a(C1813fx fxVar) {
        if (fxVar != null && !this.f2438a.contains(fxVar)) {
            this.f2438a.add(fxVar);
        }
    }

    /* renamed from: a */
    public void mo17658a(C1815fz fzVar, C1825gh ghVar) {
        if (fzVar != null) {
            this.f2440a.put(fzVar, new C1810a(fzVar, ghVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* renamed from: a */
    public abstract void mo17642a(C1830gl glVar);

    /* renamed from: a */
    public abstract void mo17643a(C2003az.C2005b bVar);

    /* renamed from: a */
    public synchronized void mo17659a(String str) {
        if (this.f2445c == 0) {
            C1524b.m2141a("setChallenge hash = " + C1662bn.m2724a(str).substring(0, 8));
            this.f2437a = str;
            mo17656a(1, 0, (Exception) null);
        } else {
            C1524b.m2141a("ignore setChallenge because connection was disconnected");
        }
    }

    /* renamed from: a */
    public abstract void mo17644a(String str, String str2);

    /* renamed from: a */
    public abstract void mo17646a(C1793fj[] fjVarArr);

    /* renamed from: a */
    public boolean m3625a() {
        return false;
    }

    /* renamed from: a */
    public synchronized boolean mo17660a(long j) {
        return this.f2448e >= j;
    }

    /* renamed from: b */
    public int mo17661b() {
        return this.f2445c;
    }

    /* renamed from: b */
    public String m3628b() {
        return this.f2434a.mo17672b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void m3629b() {
        String str;
        if (this.f2434a.mo17670a() && this.f2435a == null) {
            Class<?> cls = null;
            try {
                str = System.getProperty("smack.debuggerClass");
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                try {
                    cls = Class.forName(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (cls == null) {
                this.f2435a = new C1806fs(this);
                return;
            }
            try {
                this.f2435a = (C1824gg) cls.getConstructor(new Class[]{C1809fu.class, Writer.class, Reader.class}).newInstance(new Object[]{this});
            } catch (Exception e2) {
                throw new IllegalArgumentException("Can't initialize the configured debugger!", e2);
            }
        }
    }

    /* renamed from: b */
    public abstract void mo17662b(int i, Exception exc);

    /* renamed from: b */
    public abstract void mo17647b(C1793fj fjVar);

    /* renamed from: b */
    public void mo17663b(C1813fx fxVar) {
        this.f2438a.remove(fxVar);
    }

    /* renamed from: b */
    public void mo17664b(C1815fz fzVar, C1825gh ghVar) {
        if (fzVar != null) {
            this.f2444b.put(fzVar, new C1810a(fzVar, ghVar));
            return;
        }
        throw new NullPointerException("Packet listener is null.");
    }

    /* renamed from: b */
    public abstract void mo17665b(boolean z);

    /* renamed from: b */
    public boolean m3635b() {
        return this.f2445c == 0;
    }

    /* renamed from: c */
    public synchronized void mo17666c() {
        this.f2448e = System.currentTimeMillis();
    }

    /* renamed from: c */
    public boolean m3637c() {
        return this.f2445c == 1;
    }

    /* renamed from: d */
    public void mo17667d() {
        synchronized (this.f2439a) {
            this.f2439a.clear();
        }
    }
}
