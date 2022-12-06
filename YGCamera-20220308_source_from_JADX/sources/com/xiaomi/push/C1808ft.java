package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.C1524b;
import java.util.Date;

/* renamed from: com.xiaomi.push.ft */
class C1808ft implements C1813fx {

    /* renamed from: a */
    final /* synthetic */ C1806fs f2429a;

    C1808ft(C1806fs fsVar) {
        this.f2429a = fsVar;
    }

    /* renamed from: a */
    public void mo17652a(C1809fu fuVar) {
        C1524b.m2159c("[Slim] " + C1806fs.m3599a(this.f2429a).format(new Date()) + " Connection started (" + C1806fs.m3599a(this.f2429a).hashCode() + ")");
    }

    /* renamed from: a */
    public void mo17653a(C1809fu fuVar, int i, Exception exc) {
        C1524b.m2159c("[Slim] " + C1806fs.m3599a(this.f2429a).format(new Date()) + " Connection closed (" + C1806fs.m3599a(this.f2429a).hashCode() + ")");
    }

    /* renamed from: a */
    public void mo17654a(C1809fu fuVar, Exception exc) {
        C1524b.m2159c("[Slim] " + C1806fs.m3599a(this.f2429a).format(new Date()) + " Reconnection failed due to an exception (" + C1806fs.m3599a(this.f2429a).hashCode() + ")");
        exc.printStackTrace();
    }

    /* renamed from: b */
    public void mo17655b(C1809fu fuVar) {
        C1524b.m2159c("[Slim] " + C1806fs.m3599a(this.f2429a).format(new Date()) + " Connection reconnected (" + C1806fs.m3599a(this.f2429a).hashCode() + ")");
    }
}
