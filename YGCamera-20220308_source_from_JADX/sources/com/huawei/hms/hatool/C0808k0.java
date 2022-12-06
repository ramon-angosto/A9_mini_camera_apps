package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.k0 */
public class C0808k0 implements C0814m0 {

    /* renamed from: a */
    public Context f681a = C0777b.m729f();

    /* renamed from: b */
    public String f682b;

    /* renamed from: c */
    public String f683c;

    /* renamed from: d */
    public String f684d;

    public C0808k0(String str, String str2, String str3) {
        this.f682b = str;
        this.f683c = str2;
        this.f684d = str3;
    }

    /* renamed from: a */
    public final void mo14032a(String str, List<C0823q> list) {
        Pair<String, String> a = C0828s0.m1022a(str);
        new C0829t(list, (String) a.first, (String) a.second, this.f684d).mo14113a();
    }

    public void run() {
        C0841y.m1087c("hmsSdk", "eventReportTask is running");
        boolean a = C0822p0.m987a(this.f681a);
        if (a) {
            C0841y.m1087c("hmsSdk", "workKey is refresh,begin report all data");
            this.f683c = "alltype";
        }
        try {
            Map<String, List<C0823q>> a2 = C0835w.m1049a(this.f681a, this.f682b, this.f683c);
            if (a2.size() == 0) {
                C0841y.m1085b("hmsSdk", "no have events to report: tag:%s : type:%s", this.f682b, this.f683c);
                if ("alltype".equals(this.f683c)) {
                    C0796g0.m831a(this.f681a, "stat_v2_1", new String[0]);
                    C0796g0.m831a(this.f681a, "cached_v2_1", new String[0]);
                    return;
                }
                String a3 = C0828s0.m1024a(this.f682b, this.f683c);
                C0796g0.m831a(this.f681a, "stat_v2_1", a3);
                C0796g0.m831a(this.f681a, "cached_v2_1", a3);
                return;
            }
            for (Map.Entry next : a2.entrySet()) {
                mo14032a((String) next.getKey(), (List) next.getValue());
            }
            if ("alltype".equals(this.f683c)) {
                C0796g0.m831a(this.f681a, "stat_v2_1", new String[0]);
                C0796g0.m831a(this.f681a, "cached_v2_1", new String[0]);
            } else {
                String a4 = C0828s0.m1024a(this.f682b, this.f683c);
                C0796g0.m831a(this.f681a, "stat_v2_1", a4);
                C0796g0.m831a(this.f681a, "cached_v2_1", a4);
            }
            if (a) {
                C0841y.m1087c("hmsSdk", "refresh local key");
                C0785d0.m776f().mo13941b();
            }
        } catch (IllegalArgumentException e) {
            C0841y.m1091e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e.getMessage());
            if ("alltype".equals(this.f683c)) {
                C0796g0.m831a(this.f681a, "stat_v2_1", new String[0]);
                C0796g0.m831a(this.f681a, "cached_v2_1", new String[0]);
            } else {
                String a5 = C0828s0.m1024a(this.f682b, this.f683c);
                C0796g0.m831a(this.f681a, "stat_v2_1", a5);
                C0796g0.m831a(this.f681a, "cached_v2_1", a5);
            }
        } catch (Exception e2) {
            C0841y.m1091e("hmsSdk", "readEventRecords handData Exception:" + e2.getMessage());
            if ("alltype".equals(this.f683c)) {
                C0796g0.m831a(this.f681a, "stat_v2_1", new String[0]);
                C0796g0.m831a(this.f681a, "cached_v2_1", new String[0]);
            } else {
                String a6 = C0828s0.m1024a(this.f682b, this.f683c);
                C0796g0.m831a(this.f681a, "stat_v2_1", a6);
                C0796g0.m831a(this.f681a, "cached_v2_1", a6);
            }
        } catch (Throwable th) {
            if ("alltype".equals(this.f683c)) {
                C0796g0.m831a(this.f681a, "stat_v2_1", new String[0]);
                C0796g0.m831a(this.f681a, "cached_v2_1", new String[0]);
            } else {
                String a7 = C0828s0.m1024a(this.f682b, this.f683c);
                C0796g0.m831a(this.f681a, "stat_v2_1", a7);
                C0796g0.m831a(this.f681a, "cached_v2_1", a7);
            }
            throw th;
        }
    }
}
