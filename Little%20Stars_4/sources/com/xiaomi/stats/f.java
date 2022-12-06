package com.xiaomi.stats;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.android.i;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.channel.commonutils.stats.a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.thrift.b;
import com.xiaomi.push.thrift.c;
import com.xiaomi.smack.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.apache.thrift.protocol.k;

public class f {
    private String a;
    private boolean b = false;
    private int c;
    private long d;
    private e e;
    private com.xiaomi.channel.commonutils.stats.a f = com.xiaomi.channel.commonutils.stats.a.a();

    static class a {
        static final f a = new f();
    }

    private b a(a.C0049a aVar) {
        if (aVar.a != 0) {
            b f2 = f();
            f2.a(com.xiaomi.push.thrift.a.CHANNEL_STATS_COUNTER.a());
            f2.c(aVar.a);
            f2.c(aVar.b);
            return f2;
        } else if (aVar.c instanceof b) {
            return (b) aVar.c;
        } else {
            return null;
        }
    }

    public static f a() {
        return a.a;
    }

    private c b(int i) {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this.a, arrayList);
        if (!d.f(this.e.a)) {
            cVar.a(e.f(this.e.a));
        }
        org.apache.thrift.transport.b bVar = new org.apache.thrift.transport.b(i);
        org.apache.thrift.protocol.e a2 = new k.a().a(bVar);
        try {
            cVar.b(a2);
        } catch (org.apache.thrift.f unused) {
        }
        LinkedList<a.C0049a> c2 = this.f.c();
        while (true) {
            try {
                if (c2.size() <= 0) {
                    break;
                }
                b a3 = a(c2.getLast());
                if (a3 != null) {
                    a3.b(a2);
                }
                if (bVar.a_() > i) {
                    break;
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                c2.removeLast();
            } catch (NoSuchElementException | org.apache.thrift.f unused2) {
            }
        }
        return cVar;
    }

    public static e b() {
        return a.a.e;
    }

    private void g() {
        if (this.d == 0) {
            this.d = System.currentTimeMillis();
        }
    }

    private void h() {
        if (this.b && System.currentTimeMillis() - this.d > ((long) this.c)) {
            this.b = false;
            this.d = 0;
        }
    }

    public void a(int i) {
        if (i > 0) {
            this.b = true;
            int i2 = i * PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE;
            if (i2 > 604800000) {
                i2 = 604800000;
            }
            if (this.c != i2) {
                this.c = i2;
                g();
            }
        }
    }

    public synchronized void a(XMPushService xMPushService, l lVar) {
        this.e = new e(xMPushService);
        this.a = "";
        if (lVar != null) {
            lVar.a((com.xiaomi.smack.d) this.e);
        }
        ah.a().a((ah.a) new g(this));
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(b bVar) {
        this.f.a(bVar);
    }

    public boolean c() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        h();
        return this.b && this.f.b() > 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized c e() {
        c cVar;
        cVar = null;
        if (d()) {
            int i = 750;
            if (!d.f(i.a())) {
                i = 375;
            }
            cVar = b(i);
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public b f() {
        b bVar = new b();
        bVar.a = 0;
        bVar.c = 1;
        bVar.a("");
        bVar.d((int) (System.currentTimeMillis() / 1000));
        e eVar = this.e;
        if (eVar == null || eVar.a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("createStatsEvent err: context is null");
            a(14400000);
            b bVar2 = new b(bVar);
            bVar2.a(com.xiaomi.push.thrift.a.CHANNEL_STATS_COUNTER.a());
            bVar2.c((int) PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE);
            a(bVar2);
        } else {
            bVar.a(d.g(this.e.a));
            if (this.e.b != null) {
                bVar.e(this.e.b.e());
            }
        }
        return bVar;
    }
}
