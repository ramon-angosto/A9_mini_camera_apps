package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.C1578b;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1788fe;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1883ic;
import com.xiaomi.push.C1885ie;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1895io;
import com.xiaomi.push.C1896ip;
import com.xiaomi.push.C1901iu;
import com.xiaomi.push.C1902iv;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.service.C1974af;
import com.xiaomi.push.service.C1999aw;
import com.xiaomi.push.service.C2023bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MiPushClient4Hybrid {
    private static Map<String, C1578b.C1579a> dataMap = new HashMap();
    private static MiPushCallback sCallback;
    private static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    private static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong("last_pull_notification_" + str, System.currentTimeMillis()).commit();
    }

    private static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            i = Integer.valueOf(str).intValue();
        }
        if (!z) {
            i = (i & -4) + C1816g.C1817a.NOT_ALLOWED.mo17676a();
        }
        return (short) i;
    }

    public static boolean isRegistered(Context context, String str) {
        return C1578b.m2373a(context).mo17164a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, C1896ip ipVar) {
        C1578b.C1579a aVar;
        String b = ipVar.mo18165b();
        if (ipVar.mo18163a() == 0 && (aVar = dataMap.get(b)) != null) {
            aVar.mo17179a(ipVar.f3325e, ipVar.f3326f);
            C1578b.m2373a(context).mo17166a(b, aVar);
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(ipVar.f3325e)) {
            arrayList = new ArrayList();
            arrayList.add(ipVar.f3325e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_REGISTER.f2292a, arrayList, ipVar.f3315a, ipVar.f3324d, (String) null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(b, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, C1902iv ivVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_UNREGISTER.f2292a, (List<String>) null, ivVar.f3448a, ivVar.f3456d, (String) null);
        String a = ivVar.mo18279a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (C1578b.m2373a(context).mo17167a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            C1578b.C1579a a = C1578b.m2373a(context).mo17164a(str);
            if (a != null) {
                arrayList.add(a.f1705c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_REGISTER.f2292a, arrayList, 0, (String) null, (String) null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                C1894in inVar = new C1894in();
                inVar.mo18084b(str2);
                inVar.mo18087c(C1878hy.PullOfflineMessage.f2959a);
                inVar.mo18078a(C1999aw.m5064a());
                inVar.mo18081a(false);
                C1568ao.m2317a(context).mo17146a(inVar, C1868ho.Notification, false, true, (C1882ib) null, false, str, str2);
                C1524b.m2158b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0)) < 5000) {
            C1524b.m2141a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
        String a2 = C1663bo.m2726a(6);
        C1578b.C1579a aVar = new C1578b.C1579a(context);
        aVar.mo17184c(str2, str3, a2);
        dataMap.put(str, aVar);
        C1895io ioVar = new C1895io();
        ioVar.mo18113a(C1999aw.m5064a());
        ioVar.mo18117b(str2);
        ioVar.mo18128e(str3);
        ioVar.mo18125d(str);
        ioVar.mo18132f(a2);
        ioVar.mo18121c(C1816g.m3659a(context, context.getPackageName()));
        ioVar.mo18116b(C1816g.m3659a(context, context.getPackageName()));
        ioVar.mo18138h("3_8_9");
        ioVar.mo18111a(30809);
        ioVar.mo18112a(C1883ic.Init);
        if (!C1938m.m4731d()) {
            String g = C1907j.m4576g(context);
            if (!TextUtils.isEmpty(g)) {
                ioVar.mo18142i(C1663bo.m2727a(g));
            }
        }
        int a3 = C1907j.m4548a();
        if (a3 >= 0) {
            ioVar.mo18120c(a3);
        }
        C1894in inVar2 = new C1894in();
        inVar2.mo18087c(C1878hy.HybridRegister.f2959a);
        inVar2.mo18084b(C1578b.m2373a(context).mo17163a());
        inVar2.mo18091d(context.getPackageName());
        inVar2.mo18082a(C1905iy.m4543a(ioVar));
        inVar2.mo18078a(C1999aw.m5064a());
        C1568ao.m2317a(context).mo17141a(inVar2, C1868ho.Notification, (C1882ib) null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        C1566am.m2299a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            C1524b.m2141a("do not ack message, message is null");
            return;
        }
        try {
            C1885ie ieVar = new C1885ie();
            ieVar.mo17930b(C1578b.m2373a(context).mo17163a());
            ieVar.mo17926a(miPushMessage.getMessageId());
            ieVar.mo17925a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            ieVar.mo17927a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                ieVar.mo17933c(miPushMessage.getTopic());
            }
            C1568ao.m2317a(context).mo17143a(ieVar, C1868ho.AckMessage, false, C2023bk.m5141a(PushMessageHelper.generateMessage(miPushMessage)));
            C1524b.m2158b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th) {
            miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
            miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            throw th;
        }
        miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
        miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    private static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1)) > Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        C1578b.C1579a a = C1578b.m2373a(context).mo17164a(str);
        if (a != null) {
            C1901iu iuVar = new C1901iu();
            iuVar.mo18255a(C1999aw.m5064a());
            iuVar.mo18264d(str);
            iuVar.mo18258b(a.f1701a);
            iuVar.mo18261c(a.f1705c);
            iuVar.mo18266e(a.f1703b);
            C1894in inVar = new C1894in();
            inVar.mo18087c(C1878hy.HybridUnregister.f2959a);
            inVar.mo18084b(C1578b.m2373a(context).mo17163a());
            inVar.mo18091d(context.getPackageName());
            inVar.mo18082a(C1905iy.m4543a(iuVar));
            inVar.mo18078a(C1999aw.m5064a());
            C1568ao.m2317a(context).mo17141a(inVar, C1868ho.Notification, (C1882ib) null);
            C1578b.m2373a(context).mo17171b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        C1974af.m4924a(context, linkedList);
    }
}
