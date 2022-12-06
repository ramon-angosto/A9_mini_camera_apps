package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C2033bs;
import com.xiaomi.push.service.C2034bt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.et */
public class C1774et {

    /* renamed from: a */
    private static C1775a f2240a;

    /* renamed from: a */
    private static Map<String, C1878hy> f2241a;

    /* renamed from: com.xiaomi.push.et$a */
    public interface C1775a {
        void uploader(Context context, C1872hs hsVar);
    }

    /* renamed from: a */
    public static int m3389a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    /* renamed from: a */
    public static int m3390a(Enum enumR) {
        if (enumR != null) {
            if (enumR instanceof C1868ho) {
                return enumR.ordinal() + 1001;
            }
            if (enumR instanceof C1878hy) {
                return enumR.ordinal() + 2001;
            }
            if (enumR instanceof C1788fe) {
                return enumR.ordinal() + 3001;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static Config m3391a(Context context) {
        boolean a = C1995at.m5047a(context).mo18472a(C1873ht.PerfUploadSwitch.mo17806a(), false);
        boolean a2 = C1995at.m5047a(context).mo18472a(C1873ht.EventUploadNewSwitch.mo17806a(), false);
        int a3 = C1995at.m5047a(context).mo18465a(C1873ht.PerfUploadFrequency.mo17806a(), (int) RemoteMessageConst.DEFAULT_TTL);
        return Config.getBuilder().setEventUploadSwitchOpen(a2).setEventUploadFrequency((long) C1995at.m5047a(context).mo18465a(C1873ht.EventUploadFrequency.mo17806a(), (int) RemoteMessageConst.DEFAULT_TTL)).setPerfUploadSwitchOpen(a).setPerfUploadFrequency((long) a3).build(context);
    }

    /* renamed from: a */
    public static EventClientReport m3392a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport a = m3393a(str);
        a.eventId = str2;
        a.eventType = i;
        a.eventTime = j;
        a.eventContent = str3;
        return a;
    }

    /* renamed from: a */
    public static EventClientReport m3393a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    /* renamed from: a */
    public static PerfClientReport m3394a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    /* renamed from: a */
    public static PerfClientReport m3395a(Context context, int i, long j, long j2) {
        PerfClientReport a = m3394a();
        a.code = i;
        a.perfCounts = j;
        a.perfLatencies = j2;
        return a;
    }

    /* renamed from: a */
    public static C1872hs m3396a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C1872hs hsVar = new C1872hs();
        hsVar.mo17791d("category_client_report_data");
        hsVar.mo17779a("push_sdk_channel");
        hsVar.mo17778a(1);
        hsVar.mo17784b(str);
        hsVar.mo17781a(true);
        hsVar.mo17783b(System.currentTimeMillis());
        hsVar.mo17798g(context.getPackageName());
        hsVar.mo17793e("com.xiaomi.xmsf");
        hsVar.mo17796f(C2033bs.m5177a());
        hsVar.mo17787c("quality_support");
        return hsVar;
    }

    /* renamed from: a */
    public static C1878hy m3397a(String str) {
        if (f2241a == null) {
            synchronized (C1878hy.class) {
                if (f2241a == null) {
                    f2241a = new HashMap();
                    for (C1878hy hyVar : C1878hy.values()) {
                        f2241a.put(hyVar.f2959a.toLowerCase(), hyVar);
                    }
                }
            }
        }
        C1878hy hyVar2 = f2241a.get(str.toLowerCase());
        return hyVar2 != null ? hyVar2 : C1878hy.Invalid;
    }

    /* renamed from: a */
    public static String m3398a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    /* renamed from: a */
    public static void m3399a(Context context) {
        ClientReportClient.updateConfig(context, m3391a(context));
    }

    /* renamed from: a */
    public static void m3400a(Context context, Config config) {
        ClientReportClient.init(context, config, new C1772er(context), new C1773es(context));
    }

    /* renamed from: a */
    private static void m3401a(Context context, C1872hs hsVar) {
        if (m3391a(context.getApplicationContext())) {
            C2034bt.m5182a(context.getApplicationContext(), hsVar);
            return;
        }
        C1775a aVar = f2240a;
        if (aVar != null) {
            aVar.uploader(context, hsVar);
        }
    }

    /* renamed from: a */
    public static void m3402a(Context context, List<String> list) {
        if (list != null) {
            try {
                for (String a : list) {
                    C1872hs a2 = m3396a(context, a);
                    if (!C2033bs.m5180a(a2, false)) {
                        m3401a(context, a2);
                    }
                }
            } catch (Throwable th) {
                C1524b.m2160d(th.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static void m3403a(C1775a aVar) {
        f2240a = aVar;
    }

    /* renamed from: a */
    public static boolean m3404a(Context context) {
        return context != null && !TextUtils.isEmpty(context.getPackageName()) && "com.xiaomi.xmsf".equals(context.getPackageName());
    }
}
