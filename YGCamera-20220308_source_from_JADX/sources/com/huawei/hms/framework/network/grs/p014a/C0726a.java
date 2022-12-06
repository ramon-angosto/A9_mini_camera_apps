package com.huawei.hms.framework.network.grs.p014a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.network.grs.C0723a;
import com.huawei.hms.framework.network.grs.C0729b;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p016c.C0748f;
import com.huawei.hms.framework.network.grs.p016c.C0755m;
import com.huawei.hms.framework.network.grs.p016c.p018b.C0743c;
import com.huawei.hms.framework.network.grs.p019d.C0765e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.a.a */
public class C0726a {

    /* renamed from: a */
    private static final String f464a = "a";

    /* renamed from: b */
    private Map<String, Map<String, Map<String, String>>> f465b = new ConcurrentHashMap(16);

    /* renamed from: c */
    private Map<String, Long> f466c = new ConcurrentHashMap(16);

    /* renamed from: d */
    private C0728c f467d;

    /* renamed from: e */
    private C0728c f468e;

    /* renamed from: f */
    private C0755m f469f;

    public C0726a(C0728c cVar, C0728c cVar2, C0755m mVar) {
        this.f468e = cVar2;
        this.f467d = cVar;
        this.f469f = mVar;
        this.f469f.mo13884a(this);
    }

    /* renamed from: a */
    private void m499a(GrsBaseInfo grsBaseInfo, C0727b bVar, Context context, String str) {
        Long l = this.f466c.get(grsBaseInfo.getGrsParasKey(false, true, context));
        if (C0765e.m677a(l)) {
            bVar.mo13803a(2);
            return;
        }
        if (C0765e.m678a(l, Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL)) {
            this.f469f.mo13885a(new C0743c(grsBaseInfo, context), (C0729b) null, str, this.f468e);
        }
        bVar.mo13803a(1);
    }

    /* renamed from: a */
    private void m500a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (C0765e.m678a(this.f466c.get(str), Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL)) {
            this.f469f.mo13885a(new C0743c(grsBaseInfo, context), (C0729b) null, (String) null, this.f468e);
        }
    }

    /* renamed from: a */
    public C0728c mo13795a() {
        return this.f467d;
    }

    /* renamed from: a */
    public String mo13796a(GrsBaseInfo grsBaseInfo, String str, String str2, C0727b bVar, Context context) {
        Map<String, String> a = mo13797a(grsBaseInfo, str, bVar, context);
        if (a == null) {
            return null;
        }
        return a.get(str2);
    }

    /* renamed from: a */
    public Map<String, String> mo13797a(GrsBaseInfo grsBaseInfo, String str, C0727b bVar, Context context) {
        Map map = this.f465b.get(grsBaseInfo.getGrsParasKey(false, true, context));
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        m499a(grsBaseInfo, bVar, context, str);
        return (Map) map.get(str);
    }

    /* renamed from: a */
    public void mo13798a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
        C0728c cVar = this.f467d;
        cVar.mo13809b(grsParasKey + CrashHianalyticsData.TIME, "0");
        Map<String, Long> map = this.f466c;
        map.remove(grsParasKey + CrashHianalyticsData.TIME);
        this.f465b.remove(grsParasKey);
        this.f469f.mo13886a(grsParasKey);
    }

    /* renamed from: a */
    public void mo13799a(GrsBaseInfo grsBaseInfo, C0748f fVar, Context context, C0743c cVar) {
        if (fVar.mo13869e() == 2) {
            Logger.m478w(f464a, "update cache from server failed");
        } else if (cVar.mo13847d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
            this.f467d.mo13809b(grsParasKey, fVar.mo13873i());
            C0728c cVar2 = this.f467d;
            cVar2.mo13809b(grsParasKey + CrashHianalyticsData.TIME, fVar.mo13861a());
            this.f465b.put(grsParasKey, C0723a.m485a(fVar.mo13873i()));
            this.f466c.put(grsParasKey, Long.valueOf(Long.parseLong(fVar.mo13861a())));
        } else {
            this.f467d.mo13809b("geoipCountryCode", fVar.mo13873i());
            this.f467d.mo13809b("geoipCountryCodetime", fVar.mo13861a());
        }
    }

    /* renamed from: b */
    public C0755m mo13800b() {
        return this.f469f;
    }

    /* renamed from: b */
    public void mo13801b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
        String a = this.f467d.mo13805a(grsParasKey, "");
        C0728c cVar = this.f467d;
        String a2 = cVar.mo13805a(grsParasKey + CrashHianalyticsData.TIME, "0");
        long j = 0;
        if (!TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
            try {
                j = Long.parseLong(a2);
            } catch (NumberFormatException e) {
                Logger.m479w(f464a, "convert urlParamKey from String to Long catch NumberFormatException.", (Throwable) e);
            }
        }
        this.f465b.put(grsParasKey, C0723a.m485a(a));
        this.f466c.put(grsParasKey, Long.valueOf(j));
        m500a(grsBaseInfo, grsParasKey, context);
    }

    /* renamed from: c */
    public C0728c mo13802c() {
        return this.f468e;
    }
}
