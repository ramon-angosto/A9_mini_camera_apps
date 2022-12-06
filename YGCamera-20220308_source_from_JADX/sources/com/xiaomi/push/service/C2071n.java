package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.opendevice.C0848c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C2087u;
import com.xiaomi.push.service.C2003az;
import java.util.Locale;

/* renamed from: com.xiaomi.push.service.n */
public class C2071n {

    /* renamed from: a */
    public final int f3925a;

    /* renamed from: a */
    public final String f3926a;

    /* renamed from: b */
    public final String f3927b;

    /* renamed from: c */
    public final String f3928c;

    /* renamed from: d */
    public final String f3929d;

    /* renamed from: e */
    public final String f3930e;

    /* renamed from: f */
    public final String f3931f;

    public C2071n(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f3926a = str;
        this.f3927b = str2;
        this.f3928c = str3;
        this.f3929d = str4;
        this.f3930e = str5;
        this.f3931f = str6;
        this.f3925a = i;
    }

    /* renamed from: a */
    public static boolean m5296a() {
        try {
            return C2087u.m5373a((Context) null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean((Object) null);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m5297a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && m5296a();
    }

    /* renamed from: b */
    private static boolean m5298b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    public C2003az.C2005b mo18554a(XMPushService xMPushService) {
        C2003az.C2005b bVar = new C2003az.C2005b(xMPushService);
        mo18555a(bVar, xMPushService, xMPushService.mo18421b(), C0848c.f780a);
        return bVar;
    }

    /* renamed from: a */
    public C2003az.C2005b mo18555a(C2003az.C2005b bVar, Context context, C2058f fVar, String str) {
        bVar.f3738a = context.getPackageName();
        bVar.f3742b = this.f3926a;
        bVar.f3749h = this.f3928c;
        bVar.f3744c = this.f3927b;
        bVar.f3748g = "5";
        bVar.f3745d = "XMPUSH-PASS";
        bVar.f3740a = false;
        bVar.f3746e = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s,%13$s:%14$s,%15$s:%16$s,%17$s:%18$s,%19$s:%20$s", new Object[]{HiAnalyticsConstant.BI_KEY_SDK_VER, 46, "cpvn", "3_8_9", "cpvc", 30809, "aapn", m5298b(context) ? C1816g.m3670b(context) : "", "country_code", C1966a.m4862a(context).mo18438b(), "region", C1966a.m4862a(context).mo18436a(), "miui_vn", C1938m.m4729c(), "miui_vc", Integer.valueOf(C1938m.m4714a(context)), "xmsf_vc", Integer.valueOf(C1816g.m3659a(context, "com.xiaomi.xmsf")), "android_ver", Integer.valueOf(Build.VERSION.SDK_INT)});
        bVar.f3747f = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", new Object[]{HiAnalyticsConstant.HaKey.BI_KEY_APPID, m5298b(context) ? "1000271" : this.f3929d, "locale", Locale.getDefault().toString(), Constants.EXTRA_KEY_MIID, C2087u.m5375a(context)});
        if (m5297a(context)) {
            bVar.f3747f += String.format(",%1$s:%2$s", new Object[]{"ab", str});
        }
        bVar.f3737a = fVar;
        return bVar;
    }
}
