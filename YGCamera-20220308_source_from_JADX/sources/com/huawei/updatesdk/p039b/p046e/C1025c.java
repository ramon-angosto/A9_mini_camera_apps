package com.huawei.updatesdk.p039b.p046e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.appgallery.serviceverifykit.api.ServiceVerifyKit;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p025a.p034b.p037c.C0989b;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0990a;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0993c;
import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d;
import com.huawei.updatesdk.p039b.p044c.C1008b;
import com.huawei.updatesdk.p039b.p044c.C1009c;
import com.huawei.updatesdk.p039b.p049h.C1041c;
import com.huawei.updatesdk.service.appmgr.bean.C1054a;
import com.huawei.updatesdk.service.appmgr.bean.C1055b;

/* renamed from: com.huawei.updatesdk.b.e.c */
public class C1025c extends C1023a {

    /* renamed from: a */
    private static String f1385a;

    /* renamed from: e */
    private String m1924e() {
        try {
            Context a = C0985a.m1757c().mo14892a();
            ServiceVerifyKit.Builder builder = new ServiceVerifyKit.Builder();
            builder.setContext(a).setTargetComponent(new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId"), ServiceVerifyKit.Builder.ComponentType.ACTIVITY);
            C1009c a2 = C1008b.m1856a();
            for (String addLegacyInfo : a2.mo14976g()) {
                builder.addLegacyInfo(a2.mo14972a(), addLegacyInfo);
            }
            String genVerifiedPackageName = builder.genVerifiedPackageName();
            C0964a.m1667b("DefaultTaskInit", "UpdateSDK get market packagename from verify kit is: " + genVerifiedPackageName);
            return genVerifiedPackageName;
        } catch (Throwable th) {
            C0964a.m1668c("DefaultTaskInit", "UpdateSDK genVerifiedPackageName error: " + th.toString());
            return null;
        }
    }

    /* renamed from: f */
    private void m1925f() {
        String str;
        C0993c.m1790c(mo14996a(C0985a.m1757c().mo14892a()));
        C0994d c = new C0989b(new C1054a((String) null), (C0990a) null).mo14909c();
        if (c.mo14936f()) {
            C1055b bVar = (C1055b) c;
            if (bVar.mo15134g() != null) {
                f1385a = bVar.mo15134g().mo15138d();
                str = "getPackageName from store: " + f1385a;
            } else {
                str = "getPackageName from store: error" + bVar.toString();
            }
            C0964a.m1667b("DefaultTaskInit", str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo14995a() {
        return "com.huawei.updatesdk";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo14996a(Context context) {
        return C1041c.m1971d(context, "upsdk_store_url");
    }

    /* renamed from: b */
    public String mo14997b() {
        return f1385a;
    }

    /* renamed from: d */
    public void mo15000d() {
        if (TextUtils.isEmpty(f1385a)) {
            f1385a = m1924e();
            if (TextUtils.isEmpty(f1385a)) {
                m1925f();
            }
            C0964a.m1667b("DefaultTaskInit", "UpdateSDK genVerifiedPackageName is: " + f1385a);
        }
    }
}
