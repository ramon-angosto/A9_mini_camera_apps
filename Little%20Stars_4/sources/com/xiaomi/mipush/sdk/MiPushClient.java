package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.channel.commonutils.android.b;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.android.i;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.push.service.v;
import com.xiaomi.xmpush.thrift.a;
import com.xiaomi.xmpush.thrift.aa;
import com.xiaomi.xmpush.thrift.ac;
import com.xiaomi.xmpush.thrift.j;
import com.xiaomi.xmpush.thrift.n;
import com.xiaomi.xmpush.thrift.s;
import com.xiaomi.xmpush.thrift.t;
import com.xiaomi.xmpush.thrift.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    /* access modifiers changed from: private */
    public static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        /* access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        /* access modifiers changed from: protected */
        public void setCategory(String str) {
            this.category = str;
        }
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_EXTRA, 0);
        return sharedPreferences.getLong("account_" + str, -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2).commit();
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
    }

    private static void addRegRequestTime(Context context) {
        context.getSharedPreferences(PREF_EXTRA, 0).edit().putLong("last_reg_request", System.currentTimeMillis()).commit();
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_EXTRA, 0);
        return sharedPreferences.getLong("alias_" + str, -1);
    }

    public static void awakeApps(Context context, String[] strArr) {
        new Thread(new i(strArr, context)).start();
    }

    /* access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            int length = serviceInfoArr.length;
            int i = 0;
            while (i < length) {
                ServiceInfo serviceInfo = serviceInfoArr[i];
                if (!serviceInfo.exported || !serviceInfo.enabled || !"com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) || context.getPackageName().equals(serviceInfo.packageName)) {
                    i++;
                } else {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        context.startService(intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    protected static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        o.a(context).e();
    }

    public static void clearNotification(Context context) {
        o.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        o.a(context).a(i);
    }

    protected static synchronized String generatePacketID() {
        String str;
        synchronized (MiPushClient.class) {
            str = d.a(4) + sCurMsgId;
            sCurMsgId++;
        }
        return str;
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences(PREF_EXTRA, 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (next.startsWith("alias_")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (next.startsWith("topic_") && !next.contains("**ALL**")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences(PREF_EXTRA, 0).getAll().keySet()) {
            if (next.startsWith("account_")) {
                arrayList.add(next.substring(8));
            }
        }
        return arrayList;
    }

    private static boolean getDefaultSwitch() {
        return f.b();
    }

    public static String getRegId(Context context) {
        if (a.a(context).i()) {
            return a.a(context).e();
        }
        return null;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        try {
            sContext = context.getApplicationContext();
            if (sContext == null) {
                sContext = context;
            }
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (i.b(context)) {
                d.a(context);
            }
            boolean z = a.a(sContext).m() != Constants.a();
            if (z || shouldSendRegRequest(sContext)) {
                if (!z) {
                    if (a.a(sContext).a(str, str2) && !a.a(sContext).n()) {
                        if (1 == PushMessageHelper.getPushMode(context)) {
                            checkNotNull(miPushClientCallback, "callback");
                            miPushClientCallback.onInitializeResult(0, (String) null, a.a(context).e());
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(a.a(context).e());
                            PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(COMMAND_REGISTER, arrayList, 0, (String) null, (String) null));
                        }
                        o.a(context).a();
                        if (a.a(sContext).a()) {
                            s sVar = new s();
                            sVar.b(a.a(context).c());
                            sVar.c("client_info_update");
                            sVar.a(generatePacketID());
                            sVar.h = new HashMap();
                            sVar.h.put(Constants.EXTRA_KEY_APP_VERSION, b.a(sContext, sContext.getPackageName()));
                            sVar.h.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(b.b(sContext, sContext.getPackageName())));
                            sVar.h.put("push_sdk_vn", "3_1_2");
                            sVar.h.put("push_sdk_vc", Integer.toString(30102));
                            String g = a.a(sContext).g();
                            if (!TextUtils.isEmpty(g)) {
                                sVar.h.put("deviceid", g);
                            }
                            o.a(context).a(sVar, a.Notification, false, (com.xiaomi.xmpush.thrift.i) null);
                        }
                        if (!g.a(sContext, "update_devId", false)) {
                            updateIMEI();
                            g.b(sContext, "update_devId", true);
                        }
                        if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                            s sVar2 = new s();
                            sVar2.b(a.a(sContext).c());
                            sVar2.c("pull");
                            sVar2.a(generatePacketID());
                            sVar2.a(false);
                            o.a(sContext).a(sVar2, a.Notification, false, (com.xiaomi.xmpush.thrift.i) null, false);
                            addPullNotificationTime(sContext);
                        }
                        addRegRequestTime(sContext);
                        scheduleOcVersionCheckJob();
                        loadPlugin();
                        q.a(sContext);
                        return;
                    }
                }
                String a = d.a(6);
                a.a(sContext).h();
                a.a(sContext).a(Constants.a());
                a.a(sContext).a(str, str2, a);
                clearExtras(sContext);
                t tVar = new t();
                tVar.a(generatePacketID());
                tVar.b(str);
                tVar.e(str2);
                tVar.d(context.getPackageName());
                tVar.f(a);
                tVar.c(b.a(context, context.getPackageName()));
                tVar.b(b.b(context, context.getPackageName()));
                tVar.g("3_1_2");
                tVar.a(30102);
                tVar.h(e.b(sContext));
                tVar.a(j.Init);
                String d = e.d(sContext);
                if (!TextUtils.isEmpty(d)) {
                    if (f.b()) {
                        tVar.i(d);
                    }
                    tVar.k(d.a(d));
                }
                tVar.j(e.a());
                int b = e.b();
                if (b >= 0) {
                    tVar.c(b);
                }
                o.a(sContext).a(tVar, z);
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                loadPlugin();
                q.a(sContext);
                return;
            }
            o.a(context).a();
            com.xiaomi.channel.commonutils.logger.b.a("Could not send  register message within 5s repeatly .");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    private static void loadPlugin() {
        if (v.a(sContext).a(com.xiaomi.xmpush.thrift.b.DataCollectionSwitch.a(), getDefaultSwitch())) {
            com.xiaomi.channel.commonutils.misc.d.a(sContext).a(new g(), 10);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, j jVar) {
        if (a.a(context).i()) {
            String a = d.a(6);
            String c = a.a(context).c();
            String d = a.a(context).d();
            a.a(context).h();
            a.a(context).a(c, d, a);
            t tVar = new t();
            tVar.a(generatePacketID());
            tVar.b(c);
            tVar.e(d);
            tVar.f(a);
            tVar.d(context.getPackageName());
            tVar.c(b.a(context, context.getPackageName()));
            tVar.a(jVar);
            o.a(context).a(tVar, false);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        new Thread(new f(context, str, str2)).start();
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences(PREF_EXTRA, 0).edit().remove(Constants.EXTRA_KEY_ACCEPT_TIME).commit();
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAccount : getAllUserAccount(context)) {
                removeAccount(context, removeAccount);
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAlias : getAllAlias(context)) {
                removeAlias(context, removeAlias);
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeTopic : getAllTopic(context)) {
                removeTopic(context, removeTopic);
            }
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREF_EXTRA, 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, com.xiaomi.xmpush.thrift.i iVar, String str2, String str3) {
        s sVar = new s();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        sVar.b(str3);
        sVar.c("bar:click");
        sVar.a(str);
        sVar.a(false);
        o.a(context).a(sVar, a.Notification, false, true, iVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        com.xiaomi.xmpush.thrift.i iVar = new com.xiaomi.xmpush.thrift.i();
        iVar.a(miPushMessage.getMessageId());
        iVar.b(miPushMessage.getTopic());
        iVar.d(miPushMessage.getDescription());
        iVar.c(miPushMessage.getTitle());
        iVar.c(miPushMessage.getNotifyId());
        iVar.a(miPushMessage.getNotifyType());
        iVar.b(miPushMessage.getPassThrough());
        iVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), iVar, (String) null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, (com.xiaomi.xmpush.thrift.i) null, (String) null);
    }

    static void reportMessageClicked(Context context, String str, com.xiaomi.xmpush.thrift.i iVar, String str2) {
        s sVar = new s();
        if (TextUtils.isEmpty(str2)) {
            if (a.a(context).b()) {
                str2 = a.a(context).c();
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
        }
        sVar.b(str2);
        sVar.c("bar:click");
        sVar.a(str);
        sVar.a(false);
        o.a(context).a(sVar, a.Notification, false, iVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.channel.commonutils.misc.d.a(sContext).a(new j(sContext), v.a(sContext).a(com.xiaomi.xmpush.thrift.b.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        Context context2 = context;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (i5 < 0 || i5 >= 24 || i7 < 0 || i7 >= 24 || i6 < 0 || i6 >= 60 || i8 < 0 || i8 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / PushConstants.PUSHSERVICE_INFO_SENDMESSAGE_BY_NOTIFICATIONSERVICE) / 60);
        long j = ((((long) ((i5 * 60) + i6)) + rawOffset) + 1440) % 1440;
        long j2 = ((((long) ((i7 * 60) + i8)) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)}));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}));
        if (!acceptTimeSet(context2, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context2, COMMAND_SET_ACCEPT_TIME, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, COMMAND_SET_ACCEPT_TIME, 0, (String) null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCEPT_TIME, arrayList2, 0, (String) null, (String) null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ALIAS, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        long j;
        String str5;
        String str6;
        String str7;
        Context context2 = context;
        String str8 = str;
        String str9 = str2;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str9);
        }
        if (!COMMAND_SET_ALIAS.equalsIgnoreCase(str8) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str9)) >= 3600000) {
            if (COMMAND_UNSET_ALIAS.equalsIgnoreCase(str8) && aliasSetTime(context, str9) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (!COMMAND_SET_ACCOUNT.equalsIgnoreCase(str8) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str9)) >= 3600000) {
                if (!COMMAND_UNSET_ACCOUNT.equalsIgnoreCase(str8) || accountSetTime(context, str9) >= 0) {
                    setCommand(context, str8, (ArrayList<String>) arrayList, str3);
                    return;
                } else {
                    sb = new StringBuilder();
                    str4 = "Don't cancel account for ";
                }
            } else if (1 != PushMessageHelper.getPushMode(context)) {
                j = 0;
                str5 = null;
                str6 = null;
                str7 = COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(str7, arrayList, j, str5, str6));
                return;
            }
            sb.append(str4);
            sb.append(arrayList);
            sb.append(" is unseted");
            com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
            return;
        } else if (1 != PushMessageHelper.getPushMode(context)) {
            j = 0;
            str5 = null;
            str6 = null;
            str7 = COMMAND_SET_ALIAS;
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(str7, arrayList, j, str5, str6));
            return;
        }
        PushMessageHandler.a(context, str3, str, 0, (String) null, arrayList);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(a.a(context).c())) {
            n nVar = new n();
            nVar.a(generatePacketID());
            nVar.b(a.a(context).c());
            nVar.c(str);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                nVar.d(it.next());
            }
            nVar.f(str2);
            nVar.e(context.getPackageName());
            o.a(context).a(nVar, a.Command, (com.xiaomi.xmpush.thrift.i) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        o.a(context).b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ACCOUNT, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences(PREF_EXTRA, 0).getLong("last_pull_notification", -1)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences(PREF_EXTRA, 0).getLong("last_reg_request", -1)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return o.a(context).b();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(a.a(context).c()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                y yVar = new y();
                yVar.a(generatePacketID());
                yVar.b(a.a(context).c());
                yVar.c(str);
                yVar.d(context.getPackageName());
                yVar.e(str2);
                o.a(context).a(yVar, a.Subscription, (com.xiaomi.xmpush.thrift.i) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, (String) null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SUBSCRIBE_TOPIC, arrayList, 0, (String) null, (String) null));
            }
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_EXTRA, 0);
        return sharedPreferences.getLong("topic_" + str, -1);
    }

    public static void unregisterPush(Context context) {
        if (a.a(context).b()) {
            aa aaVar = new aa();
            aaVar.a(generatePacketID());
            aaVar.b(a.a(context).c());
            aaVar.c(a.a(context).e());
            aaVar.e(a.a(context).d());
            aaVar.d(context.getPackageName());
            o.a(context).a(aaVar);
            PushMessageHandler.a();
            a.a(context).k();
            clearExtras(context);
            clearLocalNotificationType(context);
            clearNotification(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ALIAS, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ACCOUNT, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (a.a(context).b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            ac acVar = new ac();
            acVar.a(generatePacketID());
            acVar.b(a.a(context).c());
            acVar.c(str);
            acVar.d(context.getPackageName());
            acVar.e(str2);
            o.a(context).a(acVar, a.UnSubscription, (com.xiaomi.xmpush.thrift.i) null);
        }
    }

    private static void updateIMEI() {
        new Thread(new h()).start();
    }
}
