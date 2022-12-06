package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1658bk;
import com.xiaomi.push.C1926jq;
import com.xiaomi.push.service.C2027bo;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/* renamed from: com.xiaomi.push.hg */
public class C1857hg {

    /* renamed from: a */
    private int f2631a;

    /* renamed from: a */
    private long f2632a;

    /* renamed from: a */
    private C1658bk f2633a = C1658bk.mo17259a();

    /* renamed from: a */
    private C1856hf f2634a;

    /* renamed from: a */
    private String f2635a;

    /* renamed from: a */
    private boolean f2636a = false;

    /* renamed from: com.xiaomi.push.hg$a */
    static class C1858a {

        /* renamed from: a */
        static final C1857hg f2637a = new C1857hg();
    }

    /* renamed from: a */
    private C1790fg m3847a(C1658bk.C1659a aVar) {
        if (aVar.f1878a != 0) {
            C1790fg a = mo17753a();
            a.mo17576a(C1789ff.CHANNEL_STATS_COUNTER.mo17573a());
            a.mo17586c(aVar.f1878a);
            a.mo17587c(aVar.f1880a);
            return a;
        } else if (aVar.f1879a instanceof C1790fg) {
            return (C1790fg) aVar.f1879a;
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private C1791fh mo17754a(int i) {
        ArrayList arrayList = new ArrayList();
        C1791fh fhVar = new C1791fh(this.f2635a, arrayList);
        if (!C1653bi.m2688e(this.f2634a.f2623a)) {
            fhVar.mo17607a(C1907j.m4582m(this.f2634a.f2623a));
        }
        C1929js jsVar = new C1929js(i);
        C1920jk a = new C1926jq.C1927a().mo18355a(jsVar);
        try {
            fhVar.mo17583b(a);
        } catch (C1913je unused) {
        }
        LinkedList a2 = this.f2633a.mo17259a();
        while (true) {
            try {
                if (a2.size() <= 0) {
                    break;
                }
                C1790fg a3 = m3847a((C1658bk.C1659a) a2.getLast());
                if (a3 != null) {
                    a3.mo17583b(a);
                }
                if (jsVar.mo18359a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                a2.removeLast();
            } catch (C1913je | NoSuchElementException unused2) {
            }
        }
        return fhVar;
    }

    /* renamed from: a */
    public static C1856hf mo17753a() {
        C1856hf hfVar;
        synchronized (C1858a.f2637a) {
            hfVar = C1858a.f2637a.f2634a;
        }
        return hfVar;
    }

    /* renamed from: a */
    public static C1857hg m3850a() {
        return C1858a.f2637a;
    }

    /* renamed from: a */
    private void m3851a() {
        if (this.f2636a && System.currentTimeMillis() - this.f2632a > ((long) this.f2631a)) {
            this.f2636a = false;
            this.f2632a = 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C1790fg m3852a() {
        C1790fg fgVar;
        fgVar = new C1790fg();
        fgVar.mo17577a(C1653bi.m2669a((Context) this.f2634a.f2623a));
        fgVar.f2363a = 0;
        fgVar.f2367b = 1;
        fgVar.mo17591d((int) (System.currentTimeMillis() / 1000));
        return fgVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C1791fh m3853a() {
        C1791fh fhVar;
        fhVar = null;
        if (mo17757b()) {
            int i = 750;
            if (!C1653bi.m2688e(this.f2634a.f2623a)) {
                i = 375;
            }
            fhVar = mo17754a(i);
        }
        return fhVar;
    }

    /* renamed from: a */
    public void m3854a(int i) {
        if (i > 0) {
            int i2 = i * 1000;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.f2631a != i2 || !this.f2636a) {
                this.f2636a = true;
                this.f2632a = System.currentTimeMillis();
                this.f2631a = i2;
                C1524b.m2159c("enable dot duration = " + i2 + " start = " + this.f2632a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo17755a(C1790fg fgVar) {
        this.f2633a.mo17260a(fgVar);
    }

    /* renamed from: a */
    public synchronized void mo17756a(XMPushService xMPushService) {
        this.f2634a = new C1856hf(xMPushService);
        this.f2635a = "";
        C2027bo.mo18506a().mo18508a((C2027bo.C2028a) new C1859hh(this));
    }

    /* renamed from: a */
    public boolean m3857a() {
        return this.f2636a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo17757b() {
        mo17753a();
        return this.f2636a && this.f2633a.mo17259a() > 0;
    }
}
