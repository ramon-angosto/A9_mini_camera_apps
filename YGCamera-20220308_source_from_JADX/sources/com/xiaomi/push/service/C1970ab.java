package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.C1712da;
import com.xiaomi.push.C1793fj;
import com.xiaomi.push.C1809fu;
import com.xiaomi.push.C1823gf;
import com.xiaomi.push.C1830gl;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1884id;
import com.xiaomi.push.C1891ik;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1906iz;
import com.xiaomi.push.C1913je;
import com.xiaomi.push.service.C2003az;
import com.xiaomi.push.service.C2030bq;
import java.nio.ByteBuffer;

/* renamed from: com.xiaomi.push.service.ab */
final class C1970ab {
    /* renamed from: a */
    static C1793fj m4877a(XMPushService xMPushService, byte[] bArr) {
        C1891ik ikVar = new C1891ik();
        try {
            C1905iy.m4542a(ikVar, bArr);
            return m4878a(C2072o.m5301a((Context) xMPushService), (Context) xMPushService, ikVar);
        } catch (C1913je e) {
            C1524b.m2155a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    static C1793fj m4878a(C2071n nVar, Context context, C1891ik ikVar) {
        try {
            C1793fj fjVar = new C1793fj();
            fjVar.mo17617a(5);
            fjVar.mo17626c(nVar.f3926a);
            fjVar.mo17624b(m4882a(ikVar));
            fjVar.mo17620a("SECMSG", CrashHianalyticsData.MESSAGE);
            String str = nVar.f3926a;
            ikVar.f3190a.f3056a = str.substring(0, str.indexOf("@"));
            ikVar.f3190a.f3060c = str.substring(str.indexOf("/") + 1);
            fjVar.mo17622a(C1905iy.m4543a(ikVar), nVar.f3928c);
            fjVar.mo17621a(1);
            C1524b.m2141a("try send mi push message. packagename:" + ikVar.f3195b + " action:" + ikVar.f3188a);
            return fjVar;
        } catch (NullPointerException e) {
            C1524b.m2155a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    static C1891ik m4879a(String str, String str2) {
        C1894in inVar = new C1894in();
        inVar.mo18084b(str2);
        inVar.mo18087c("package uninstalled");
        inVar.mo18078a(C1830gl.m3747i());
        inVar.mo18081a(false);
        return m4880a(str, str2, inVar, C1868ho.Notification);
    }

    /* renamed from: a */
    static <T extends C1906iz<T, ?>> C1891ik m4880a(String str, String str2, T t, C1868ho hoVar) {
        return m4881a(str, str2, t, hoVar, true);
    }

    /* renamed from: a */
    private static <T extends C1906iz<T, ?>> C1891ik m4881a(String str, String str2, T t, C1868ho hoVar, boolean z) {
        byte[] a = C1905iy.m4543a(t);
        C1891ik ikVar = new C1891ik();
        C1884id idVar = new C1884id();
        idVar.f3055a = 5;
        idVar.f3056a = "fakeid";
        ikVar.mo18046a(idVar);
        ikVar.mo18048a(ByteBuffer.wrap(a));
        ikVar.mo18044a(hoVar);
        ikVar.mo18051b(z);
        ikVar.mo18050b(str);
        ikVar.mo18049a(false);
        ikVar.mo18047a(str2);
        return ikVar;
    }

    /* renamed from: a */
    private static String m4882a(C1891ik ikVar) {
        if (!(ikVar.f3189a == null || ikVar.f3189a.f3037b == null)) {
            String str = ikVar.f3189a.f3037b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ikVar.f3195b;
    }

    /* renamed from: a */
    static String m4883a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* renamed from: a */
    static void m4884a(XMPushService xMPushService) {
        C2071n a = C2072o.m5301a(xMPushService.getApplicationContext());
        if (a != null) {
            C2003az.C2005b a2 = C2072o.m5301a(xMPushService.getApplicationContext()).mo18554a(xMPushService);
            m4886a(xMPushService, a2);
            C2003az.mo18481a().mo18487a(a2);
            C2030bq.m5168a((Context) xMPushService).mo18510a((C2030bq.C2031a) new C1971ac("GAID", 172800, xMPushService, a));
            m4887a(xMPushService, a, 172800);
        }
    }

    /* renamed from: a */
    static void m4885a(XMPushService xMPushService, C1891ik ikVar) {
        C1712da.m2970a(ikVar.mo18052b(), xMPushService.getApplicationContext(), ikVar, -1);
        C1809fu a = xMPushService.mo18408a();
        if (a == null) {
            throw new C1823gf("try send msg while connection is null.");
        } else if (a.mo17639a()) {
            C1793fj a2 = m4878a(C2072o.m5301a((Context) xMPushService), (Context) xMPushService, ikVar);
            if (a2 != null) {
                a.mo17647b(a2);
            }
        } else {
            throw new C1823gf("Don't support XMPP connection.");
        }
    }

    /* renamed from: a */
    static void m4886a(XMPushService xMPushService, C2003az.C2005b bVar) {
        bVar.mo18492a((Messenger) null);
        bVar.mo18493a((C2003az.C2005b.C2006a) new C1973ae(xMPushService));
    }

    /* renamed from: a */
    private static void m4887a(XMPushService xMPushService, C2071n nVar, int i) {
        C2030bq.m5168a((Context) xMPushService).mo18510a((C2030bq.C2031a) new C1972ad("MSAID", (long) i, xMPushService, nVar));
    }

    /* renamed from: a */
    static void m4888a(XMPushService xMPushService, String str, byte[] bArr) {
        C1712da.m2972a(str, xMPushService.getApplicationContext(), bArr);
        C1809fu a = xMPushService.mo18408a();
        if (a == null) {
            throw new C1823gf("try send msg while connection is null.");
        } else if (a.mo17639a()) {
            C1793fj a2 = m4877a(xMPushService, bArr);
            if (a2 != null) {
                a.mo17647b(a2);
            } else {
                C2076r.m5325a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        } else {
            throw new C1823gf("Don't support XMPP connection.");
        }
    }

    /* renamed from: b */
    static C1891ik m4889b(String str, String str2) {
        C1894in inVar = new C1894in();
        inVar.mo18084b(str2);
        inVar.mo18087c(C1878hy.AppDataCleared.f2959a);
        inVar.mo18078a(C1999aw.m5064a());
        inVar.mo18081a(false);
        return m4880a(str, str2, inVar, C1868ho.Notification);
    }

    /* renamed from: b */
    static <T extends C1906iz<T, ?>> C1891ik m4890b(String str, String str2, T t, C1868ho hoVar) {
        return m4881a(str, str2, t, hoVar, false);
    }
}
