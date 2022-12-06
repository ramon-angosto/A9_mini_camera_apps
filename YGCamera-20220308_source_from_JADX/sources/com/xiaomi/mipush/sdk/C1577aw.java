package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1640az;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C1940o;
import com.xiaomi.push.service.C1999aw;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.aw */
final class C1577aw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f1692a;

    /* renamed from: a */
    final /* synthetic */ boolean f1693a;

    C1577aw(Context context, boolean z) {
        this.f1692a = context;
        this.f1693a = z;
    }

    public void run() {
        String str;
        String str2;
        Map<String, String> map;
        C1524b.m2141a("do sync info");
        C1894in inVar = new C1894in(C1999aw.m5064a(), false);
        C1578b a = C1578b.m2373a(this.f1692a);
        inVar.mo18087c(C1878hy.SyncInfo.f2959a);
        inVar.mo18084b(a.mo17163a());
        inVar.mo18091d(this.f1692a.getPackageName());
        inVar.f3224a = new HashMap();
        Map<String, String> map2 = inVar.f3224a;
        Context context = this.f1692a;
        C1940o.m4735a(map2, Constants.EXTRA_KEY_APP_VERSION, C1816g.m3659a(context, context.getPackageName()));
        Map<String, String> map3 = inVar.f3224a;
        Context context2 = this.f1692a;
        C1940o.m4735a(map3, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(C1816g.m3659a(context2, context2.getPackageName())));
        C1940o.m4735a(inVar.f3224a, "push_sdk_vn", "3_8_9");
        C1940o.m4735a(inVar.f3224a, "push_sdk_vc", Integer.toString(30809));
        C1940o.m4735a(inVar.f3224a, "token", a.mo17170b());
        C1907j.m4556a(this.f1692a, inVar.f3224a);
        if (!C1938m.m4731d()) {
            String a2 = C1663bo.m2727a(C1907j.m4575f(this.f1692a));
            String h = C1907j.m4577h(this.f1692a);
            if (!TextUtils.isEmpty(h)) {
                a2 = a2 + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
            }
            if (!TextUtils.isEmpty(a2)) {
                C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_IMEI_MD5, a2);
            }
        }
        C1640az.m2599a(this.f1692a).mo17240a(inVar.f3224a);
        C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_REG_ID, a.mo17173c());
        C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_REG_SECRET, a.mo17174d());
        C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f1692a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f1693a) {
            C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_ALIASES_MD5, C1576av.m2371c(MiPushClient.getAllAlias(this.f1692a)));
            C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_TOPICS_MD5, C1576av.m2371c(MiPushClient.getAllTopic(this.f1692a)));
            map = inVar.f3224a;
            str2 = C1576av.m2371c(MiPushClient.getAllUserAccount(this.f1692a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_ALIASES, C1576av.m2372d(MiPushClient.getAllAlias(this.f1692a)));
            C1940o.m4735a(inVar.f3224a, Constants.EXTRA_KEY_TOPICS, C1576av.m2372d(MiPushClient.getAllTopic(this.f1692a)));
            map = inVar.f3224a;
            str2 = C1576av.m2372d(MiPushClient.getAllUserAccount(this.f1692a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        C1940o.m4735a(map, str, str2);
        C1568ao.m2317a(this.f1692a).mo17143a(inVar, C1868ho.Notification, false, (C1882ib) null);
    }
}
