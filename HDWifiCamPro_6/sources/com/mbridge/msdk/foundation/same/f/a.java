package com.mbridge.msdk.foundation.same.f;

import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.tools.q;

/* compiled from: ReportTask */
public final class a implements Runnable {
    private String a;
    private String b;

    public a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        try {
            new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.e().g()).c(0, d.c().a, com.mbridge.msdk.foundation.same.report.d.a(this.a, com.mbridge.msdk.foundation.controller.a.e().g(), this.b), new b() {
                public final void a(String str) {
                    q.d("ReportTask", str);
                }

                public final void b(String str) {
                    q.d("ReportTask", str);
                }
            });
        } catch (Throwable th) {
            q.d("ReportTask", th.getMessage());
        }
    }
}
