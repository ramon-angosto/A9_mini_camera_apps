package com.huawei.updatesdk.p039b.p046e;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import com.huawei.updatesdk.p039b.p043b.C1003a;
import com.huawei.updatesdk.p039b.p049h.C1037b;
import com.huawei.updatesdk.service.otaupdate.C1085f;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.updatesdk.b.e.a */
public abstract class C1023a {
    /* renamed from: a */
    private String m1911a(Context context, String str) {
        String str2;
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            grsBaseInfo.setSerCountry(str);
            str2 = new GrsClient(context, grsBaseInfo).synGetGrsUrl(mo14995a(), "ROOT");
        } catch (Throwable th) {
            C0964a.m1668c("AbstractTaskInit", "UpdateSDK Get url from GRS_SDK error: " + th.toString());
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            C0964a.m1667b("AbstractTaskInit", "UpdateSDK Get url is default url");
            return mo14996a(context);
        }
        C0964a.m1667b("AbstractTaskInit", "UpdateSDK Get url from GRS_SDK Success!" + m1912a(str2));
        return str2;
    }

    /* renamed from: a */
    private String m1912a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.substring(0, str.indexOf(46));
        } catch (Exception e) {
            C0968a.m1682b("AbstractTaskInit", e.toString());
            return null;
        }
    }

    /* renamed from: b */
    private boolean m1913b(Context context, String str) {
        if (!C1037b.m1964d(context, str)) {
            return false;
        }
        if (Math.abs(System.currentTimeMillis() - C1003a.m1831d().mo14960b(str)) >= 86400000) {
            return true;
        }
        C1085f.m2106f().mo15202a(C1003a.m1831d().mo14955a(str));
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo14995a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo14996a(Context context);

    /* renamed from: b */
    public abstract String mo14997b();

    /* renamed from: b */
    public String mo14998b(Context context) {
        String a = C1085f.m2106f().mo15201a();
        if (!TextUtils.isEmpty(a)) {
            return m1911a(context, a);
        }
        C0964a.m1667b("AbstractTaskInit", "UpdateSDK accoutZone is empty, so url is default");
        return mo14996a(context);
    }

    /* renamed from: c */
    public void mo14999c() {
        Context a = C0985a.m1757c().mo14892a();
        String b = mo14997b();
        if (m1913b(a, b)) {
            C1026d dVar = new C1026d(String.format(Locale.ROOT, "content://%s.commondata/item/1", new Object[]{b}), b);
            dVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
            try {
                dVar.get(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                C0964a.m1666a("AbstractTaskInit", "init AccountZone error: " + e.toString());
            }
        }
    }

    /* renamed from: d */
    public abstract void mo15000d();
}
