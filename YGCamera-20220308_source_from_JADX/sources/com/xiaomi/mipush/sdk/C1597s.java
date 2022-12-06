package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1938m;
import java.util.HashMap;

/* renamed from: com.xiaomi.mipush.sdk.s */
public class C1597s {

    /* renamed from: a */
    private static volatile C1597s f1738a;

    /* renamed from: a */
    private final Context f1739a;

    private C1597s(Context context) {
        this.f1739a = context.getApplicationContext();
    }

    /* renamed from: a */
    private static C1597s m2465a(Context context) {
        if (f1738a == null) {
            synchronized (C1597s.class) {
                if (f1738a == null) {
                    f1738a = new C1597s(context);
                }
            }
        }
        return f1738a;
    }

    /* renamed from: a */
    public static void m2466a(Context context, C1891ik ikVar) {
        m2465a(context).m2468a(ikVar, 0, true);
    }

    /* renamed from: a */
    public static void m2467a(Context context, C1891ik ikVar, boolean z) {
        m2465a(context).m2468a(ikVar, 1, z);
    }

    /* renamed from: a */
    private void m2468a(C1891ik ikVar, int i, boolean z) {
        if (!C1938m.m4714a(this.f1739a) && C1938m.m4713a() && ikVar != null && ikVar.f3188a == C1868ho.SendMessage && ikVar.mo18043a() != null && z) {
            C1524b.m2141a("click to start activity result:" + String.valueOf(i));
            C1894in inVar = new C1894in(ikVar.mo18043a().mo17876a(), false);
            inVar.mo18087c(C1878hy.SDK_START_ACTIVITY.f2959a);
            inVar.mo18084b(ikVar.mo18043a());
            inVar.mo18091d(ikVar.f3195b);
            inVar.f3224a = new HashMap();
            inVar.f3224a.put("result", String.valueOf(i));
            C1568ao.m2317a(this.f1739a).mo17148a(inVar, C1868ho.Notification, false, false, (C1882ib) null, true, ikVar.f3195b, ikVar.f3191a, true, false);
        }
    }

    /* renamed from: b */
    public static void m2469b(Context context, C1891ik ikVar, boolean z) {
        m2465a(context).m2468a(ikVar, 2, z);
    }

    /* renamed from: c */
    public static void m2470c(Context context, C1891ik ikVar, boolean z) {
        m2465a(context).m2468a(ikVar, 3, z);
    }

    /* renamed from: d */
    public static void m2471d(Context context, C1891ik ikVar, boolean z) {
        m2465a(context).m2468a(ikVar, 4, z);
    }

    /* renamed from: e */
    public static void m2472e(Context context, C1891ik ikVar, boolean z) {
        C1597s sVar;
        int i;
        C1578b a = C1578b.m2373a(context);
        if (TextUtils.isEmpty(a.mo17173c()) || TextUtils.isEmpty(a.mo17174d())) {
            sVar = m2465a(context);
            i = 6;
        } else {
            boolean f = a.mo17176f();
            sVar = m2465a(context);
            i = f ? 7 : 5;
        }
        sVar.m2468a(ikVar, i, z);
    }
}
