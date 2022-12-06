package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.f;
import com.xiaomi.xmpush.thrift.i;
import com.xiaomi.xmpush.thrift.s;
import java.util.HashMap;
import java.util.Map;

final class r implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ boolean b;

    r(Context context, boolean z) {
        this.a = context;
        this.b = z;
    }

    public void run() {
        String str;
        String str2;
        Map<String, String> map;
        b.a("do sync info");
        s sVar = new s(MiPushClient.generatePacketID(), false);
        a a2 = a.a(this.a);
        sVar.c(f.SyncInfo.z);
        sVar.b(a2.c());
        sVar.d(this.a.getPackageName());
        sVar.h = new HashMap();
        Map<String, String> map2 = sVar.h;
        Context context = this.a;
        q.b(map2, Constants.EXTRA_KEY_APP_VERSION, com.xiaomi.channel.commonutils.android.b.a(context, context.getPackageName()));
        Map<String, String> map3 = sVar.h;
        Context context2 = this.a;
        q.b(map3, Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.channel.commonutils.android.b.b(context2, context2.getPackageName())));
        q.b(sVar.h, "push_sdk_vn", "3_1_2");
        q.b(sVar.h, "push_sdk_vc", Integer.toString(30102));
        q.b(sVar.h, Constants.EXTRA_KEY_TOKEN, a2.d());
        q.b(sVar.h, Constants.EXTRA_KEY_IMEI_MD5, d.a(e.c(this.a)));
        q.b(sVar.h, Constants.EXTRA_KEY_REG_ID, a2.e());
        q.b(sVar.h, Constants.EXTRA_KEY_REG_SECRET, a2.f());
        q.b(sVar.h, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.a).replace(Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.b) {
            q.b(sVar.h, Constants.EXTRA_KEY_ALIASES_MD5, q.c(MiPushClient.getAllAlias(this.a)));
            q.b(sVar.h, Constants.EXTRA_KEY_TOPICS_MD5, q.c(MiPushClient.getAllTopic(this.a)));
            map = sVar.h;
            str2 = q.c(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            q.b(sVar.h, Constants.EXTRA_KEY_ALIASES, q.d(MiPushClient.getAllAlias(this.a)));
            q.b(sVar.h, Constants.EXTRA_KEY_TOPICS, q.d(MiPushClient.getAllTopic(this.a)));
            map = sVar.h;
            str2 = q.d(MiPushClient.getAllUserAccount(this.a));
            str = Constants.EXTRA_KEY_ACCOUNTS;
        }
        q.b(map, str, str2);
        o.a(this.a).a(sVar, a.Notification, false, (i) null);
    }
}
