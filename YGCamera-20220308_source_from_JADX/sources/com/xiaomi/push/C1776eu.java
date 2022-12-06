package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.C1526a;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;

/* renamed from: com.xiaomi.push.eu */
public class C1776eu {

    /* renamed from: a */
    private static volatile C1776eu f2242a;

    /* renamed from: a */
    private Context f2243a;

    private C1776eu(Context context) {
        this.f2243a = context;
    }

    /* renamed from: a */
    public static C1776eu m3405a(Context context) {
        if (f2242a == null) {
            synchronized (C1776eu.class) {
                if (f2242a == null) {
                    f2242a = new C1776eu(context);
                }
            }
        }
        return f2242a;
    }

    /* renamed from: a */
    private void m3406a(C1526a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f2243a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f2243a, (EventClientReport) aVar);
        }
    }

    /* renamed from: a */
    public void mo17533a(String str, int i, long j, long j2) {
        if (i >= 0 && j2 >= 0 && j > 0) {
            PerfClientReport a = C1774et.m3395a(this.f2243a, i, j, j2);
            a.setAppPackageName(str);
            a.setSdkVersion("3_8_9");
            m3406a((C1526a) a);
        }
    }

    /* renamed from: a */
    public void mo17534a(String str, Intent intent, int i, String str2) {
        if (intent != null) {
            String str3 = str;
            mo17536a(str3, C1774et.m3389a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), str2);
        }
    }

    /* renamed from: a */
    public void mo17535a(String str, Intent intent, String str2) {
        if (intent != null) {
            String str3 = str;
            mo17536a(str3, C1774et.m3389a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
        }
    }

    /* renamed from: a */
    public void mo17536a(String str, String str2, String str3, int i, long j, String str4) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            EventClientReport a = C1774et.m3392a(this.f2243a, str2, str3, i, j, str4);
            a.setAppPackageName(str);
            a.setSdkVersion("3_8_9");
            m3406a((C1526a) a);
        }
    }

    /* renamed from: a */
    public void mo17537a(String str, String str2, String str3, int i, String str4) {
        mo17536a(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void mo17538a(String str, String str2, String str3, String str4) {
        mo17536a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    /* renamed from: b */
    public void mo17539b(String str, String str2, String str3, String str4) {
        mo17536a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    /* renamed from: c */
    public void mo17540c(String str, String str2, String str3, String str4) {
        mo17536a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
