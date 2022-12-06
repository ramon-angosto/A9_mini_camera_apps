package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.processor.C1539c;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* renamed from: com.xiaomi.push.br */
public class C1666br implements Runnable {

    /* renamed from: a */
    private Context f1886a;

    /* renamed from: a */
    private C1539c f1887a;

    /* renamed from: a */
    public void mo17263a(Context context) {
        this.f1886a = context;
    }

    /* renamed from: a */
    public void mo17264a(C1539c cVar) {
        this.f1887a = cVar;
    }

    public void run() {
        C1670bv a;
        String str;
        long currentTimeMillis;
        try {
            if (this.f1887a != null) {
                this.f1887a.mo16997a();
            }
            C1524b.m2159c("begin read and send perf / event");
            if (this.f1887a instanceof IEventProcessor) {
                a = C1670bv.m2754a(this.f1886a);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (this.f1887a instanceof IPerfProcessor) {
                a = C1670bv.m2754a(this.f1886a);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else {
                return;
            }
            a.mo17268a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }
}
