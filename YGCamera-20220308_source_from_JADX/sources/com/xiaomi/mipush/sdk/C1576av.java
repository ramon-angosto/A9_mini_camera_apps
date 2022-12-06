package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1613af;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.service.C1995at;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* renamed from: com.xiaomi.mipush.sdk.av */
public class C1576av {
    /* renamed from: a */
    public static void m2367a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("last_sync_info", -1);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a = (long) C1995at.m5047a(context).mo18465a(C1873ht.SyncInfoFrequency.mo17806a(), 1209600);
        if (j != -1) {
            if (Math.abs(currentTimeMillis - j) > a) {
                m2369a(context, true);
            } else {
                return;
            }
        }
        sharedPreferences.edit().putLong("last_sync_info", currentTimeMillis).commit();
    }

    /* renamed from: a */
    public static void m2368a(Context context, C1894in inVar) {
        C1524b.m2141a("need to update local info with: " + inVar.mo18077a());
        String str = (String) inVar.mo18077a().get(Constants.EXTRA_KEY_ACCEPT_TIME);
        if (str != null) {
            MiPushClient.removeAcceptTime(context);
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                MiPushClient.addAcceptTime(context, split[0], split[1]);
                if (!"00:00".equals(split[0]) || !"00:00".equals(split[1])) {
                    C1578b.m2373a(context).mo17168a(false);
                } else {
                    C1578b.m2373a(context).mo17168a(true);
                }
            }
        }
        String str2 = (String) inVar.mo18077a().get(Constants.EXTRA_KEY_ALIASES);
        if (str2 != null) {
            MiPushClient.removeAllAliases(context);
            if (!"".equals(str2)) {
                for (String addAlias : str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAlias(context, addAlias);
                }
            }
        }
        String str3 = (String) inVar.mo18077a().get(Constants.EXTRA_KEY_TOPICS);
        if (str3 != null) {
            MiPushClient.removeAllTopics(context);
            if (!"".equals(str3)) {
                for (String addTopic : str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addTopic(context, addTopic);
                }
            }
        }
        String str4 = (String) inVar.mo18077a().get(Constants.EXTRA_KEY_ACCOUNTS);
        if (str4 != null) {
            MiPushClient.removeAllAccounts(context);
            if (!"".equals(str4)) {
                for (String addAccount : str4.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    MiPushClient.addAccount(context, addAccount);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m2369a(Context context, boolean z) {
        C1618ak.m2518a(context).mo17212a((Runnable) new C1577aw(context, z));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m2371c(List<String> list) {
        String a = C1663bo.m2727a(m2372d(list));
        return (TextUtils.isEmpty(a) || a.length() <= 4) ? "" : a.substring(0, 4).toLowerCase();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static String m2372d(List<String> list) {
        String str = "";
        if (C1613af.m2510a(list)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            str = str + str2;
        }
        return str;
    }
}
