package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1747ed;
import com.xiaomi.push.C1809fu;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.C2021bi;
import com.xiaomi.push.service.C2027bo;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.fq */
public class C1804fq extends C1819gb {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1795fl f2414a;

    /* renamed from: a */
    private C1796fm f2415a;

    /* renamed from: a */
    private Thread f2416a;

    /* renamed from: a */
    private byte[] f2417a;

    public C1804fq(XMPushService xMPushService, C1811fv fvVar) {
        super(xMPushService, fvVar);
    }

    /* renamed from: a */
    private C1793fj mo17645a(boolean z) {
        C1803fp fpVar = new C1803fp();
        if (z) {
            fpVar.mo17619a("1");
        }
        byte[] a = C1860hi.m3860a();
        if (a != null) {
            C1747ed.C1757j jVar = new C1747ed.C1757j();
            jVar.mo17498a(C1607a.m2486a(a));
            fpVar.mo17622a(jVar.mo17407a(), (String) null);
        }
        return fpVar;
    }

    /* renamed from: h */
    private void m3586h() {
        try {
            this.f2414a = new C1795fl(this.f2472a.getInputStream(), this);
            this.f2415a = new C1796fm(this.f2472a.getOutputStream(), this);
            this.f2416a = new C1805fr(this, "Blob Reader (" + this.f2441b + ")");
            this.f2416a.start();
        } catch (Exception e) {
            throw new C1823gf("Error to init reader and writer", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo17639a() {
        m3586h();
        this.f2415a.mo17634a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo17640a(int i, Exception exc) {
        if (this.f2414a != null) {
            this.f2414a.mo17632b();
            this.f2414a = null;
        }
        if (this.f2415a != null) {
            try {
                this.f2415a.mo17635b();
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
            }
            this.f2415a = null;
        }
        this.f2417a = null;
        super.mo17640a(i, exc);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo17641a(C1793fj fjVar) {
        if (fjVar != null) {
            if (fjVar.mo17615a()) {
                C1524b.m2141a("[Slim] RCV blob chid=" + fjVar.mo17615a() + "; id=" + fjVar.mo17627e() + "; errCode=" + fjVar.mo17623b() + "; err=" + fjVar.mo17625c());
            }
            if (fjVar.mo17615a() == 0) {
                if ("PING".equals(fjVar.mo17615a())) {
                    C1524b.m2141a("[Slim] RCV ping id=" + fjVar.mo17627e());
                    mo17682g();
                } else if ("CLOSE".equals(fjVar.mo17615a())) {
                    mo17679c(13, (Exception) null);
                }
            }
            for (C1809fu.C1810a a : this.f2440a.values()) {
                a.mo17668a(fjVar);
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public void mo17642a(C1830gl glVar) {
        mo17647b(C1793fj.m3532a(glVar, (String) null));
    }

    /* renamed from: a */
    public synchronized void mo17643a(C2003az.C2005b bVar) {
        C1792fi.m3530a(bVar, mo17666c(), (C1809fu) this);
    }

    /* renamed from: a */
    public synchronized void mo17644a(String str, String str2) {
        C1792fi.m3531a(str, str2, (C1809fu) this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void m3593a(boolean z) {
        if (this.f2415a != null) {
            C1793fj a = mo17645a(z);
            C1524b.m2141a("[Slim] SND ping id=" + a.mo17627e());
            mo17647b(a);
            mo17681f();
            return;
        }
        throw new C1823gf("The BlobWriter is null.");
    }

    /* renamed from: a */
    public void mo17646a(C1793fj[] fjVarArr) {
        for (C1793fj b : fjVarArr) {
            mo17647b(b);
        }
    }

    /* renamed from: a */
    public boolean m3595a() {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized byte[] m3596a() {
        if (this.f2417a == null && !TextUtils.isEmpty(this.f2437a)) {
            String a = C2027bo.mo18506a();
            this.f2417a = C2021bi.m5135a(this.f2437a.getBytes(), (this.f2437a.substring(this.f2437a.length() / 2) + a.substring(a.length() / 2)).getBytes());
        }
        return this.f2417a;
    }

    /* renamed from: b */
    public void mo17647b(C1793fj fjVar) {
        if (C1614ag.f1764a) {
            C1938m.m4728b((Context) this.f2473b);
        }
        C1796fm fmVar = this.f2415a;
        if (fmVar != null) {
            try {
                int a = fmVar.mo17633a(fjVar);
                this.f2447d = System.currentTimeMillis();
                String f = fjVar.mo17628f();
                if (!TextUtils.isEmpty(f)) {
                    C1847gz.m3818a(this.f2436a, f, (long) a, false, true, System.currentTimeMillis());
                }
                for (C1809fu.C1810a a2 : this.f2444b.values()) {
                    a2.mo17668a(fjVar);
                }
            } catch (Exception e) {
                throw new C1823gf((Throwable) e);
            }
        } else {
            throw new C1823gf("the writer is null.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo17648b(C1830gl glVar) {
        if (glVar != null) {
            for (C1809fu.C1810a a : this.f2440a.values()) {
                a.mo17669a(glVar);
            }
        }
    }
}
