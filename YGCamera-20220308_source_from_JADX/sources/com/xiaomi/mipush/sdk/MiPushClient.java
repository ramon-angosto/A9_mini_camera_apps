package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.manager.C1528a;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1640az;
import com.xiaomi.push.C1663bo;
import com.xiaomi.push.C1733ds;
import com.xiaomi.push.C1734dt;
import com.xiaomi.push.C1772er;
import com.xiaomi.push.C1773es;
import com.xiaomi.push.C1774et;
import com.xiaomi.push.C1788fe;
import com.xiaomi.push.C1816g;
import com.xiaomi.push.C1868ho;
import com.xiaomi.push.C1872hs;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1883ic;
import com.xiaomi.push.C1889ii;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1895io;
import com.xiaomi.push.C1899is;
import com.xiaomi.push.C1901iu;
import com.xiaomi.push.C1903iw;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C1945s;
import com.xiaomi.push.C2087u;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C1999aw;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    /* access modifiers changed from: private */
    public static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        /* access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

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

    public static class TokenResult {
        private long resultCode = -1;
        private String token = null;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        /* access modifiers changed from: protected */
        public void setResultCode(long j) {
            this.resultCode = j;
        }

        /* access modifiers changed from: protected */
        public void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            C1945s.m4744a(edit);
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        C1945s.m4744a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        C1945s.m4744a(edit);
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        C1618ak.m2518a(context).mo17212a((Runnable) new Runnable() {
            public void run() {
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str)) {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4);
                            if (packageInfo != null) {
                                MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                            }
                        }
                    }
                } catch (Throwable th) {
                    C1524b.m2155a(th);
                }
            }
        });
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
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.m2258a(context, intent);
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
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        C1568ao.m2317a(context).mo17157e();
    }

    public static void clearNotification(Context context) {
        C1568ao.m2317a(context).mo17134a(-1);
    }

    public static void clearNotification(Context context, int i) {
        C1568ao.m2317a(context).mo17134a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        C1568ao.m2317a(context).mo17150a(str, str2);
    }

    public static void disablePush(Context context) {
        C1568ao.m2317a(context).mo17151a(true);
    }

    public static void enablePush(Context context) {
        C1568ao.m2317a(context).mo17151a(false);
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("alias_")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("topic_") && !next.contains("**ALL**")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("account_")) {
                arrayList.add(next.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (C1578b.m2373a(context).mo17173c()) {
            return C1578b.m2373a(context).mo17176f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return C1938m.m4725b();
    }

    protected static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return C1583f.m2419a(context).mo17191b(C1582e.ASSEMBLE_PUSH_FCM);
    }

    protected static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return C1583f.m2419a(context).mo17191b(C1582e.ASSEMBLE_PUSH_HUAWEI);
    }

    protected static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return C1583f.m2419a(context).mo17191b(C1582e.ASSEMBLE_PUSH_COS);
    }

    protected static boolean getOpenVIVOPush(Context context) {
        return C1583f.m2419a(context).mo17191b(C1582e.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (C1578b.m2373a(context).mo17173c()) {
            return C1578b.m2373a(context).mo17173c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        C1774et.m3403a((C1774et.C1775a) new C1774et.C1775a() {
            public void uploader(Context context, C1872hs hsVar) {
                MiTinyDataClient.upload(context, hsVar);
            }
        });
        Config a = C1774et.m3391a(context);
        C1528a.m2164a(context).mo16980a("3_8_9");
        ClientReportClient.init(context, a, new C1772er(context), new C1773es(context));
        C1553a.m2276a(context);
        C1598t.m2473a(context, a);
        C1995at.m5047a(context).mo18469a((C1995at.C1996a) new C1995at.C1996a(100, "perf event job update") {
            /* access modifiers changed from: protected */
            public void onCallback() {
                C1774et.m3391a(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, (String) null, (ICallbackResult) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x031c A[Catch:{ all -> 0x0333 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initialize(android.content.Context r17, java.lang.String r18, java.lang.String r19, com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback r20, java.lang.String r21, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult r22) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "update_devId"
            android.content.Context r4 = r17.getApplicationContext()     // Catch:{ all -> 0x0333 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2149a((android.content.Context) r4)     // Catch:{ all -> 0x0333 }
            java.lang.String r4 = "sdk_version = 3_8_9"
            com.xiaomi.channel.commonutils.logger.C1524b.m2161e(r4)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.az r4 = com.xiaomi.push.C1640az.m2599a((android.content.Context) r17)     // Catch:{ all -> 0x0333 }
            r4.mo17232a()     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.C1715dd.m2973a((android.content.Context) r17)     // Catch:{ all -> 0x0333 }
            if (r2 == 0) goto L_0x0023
            com.xiaomi.mipush.sdk.PushMessageHandler.m2266a((com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback) r20)     // Catch:{ all -> 0x0333 }
        L_0x0023:
            if (r22 == 0) goto L_0x0028
            com.xiaomi.mipush.sdk.PushMessageHandler.m2265a((com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult) r22)     // Catch:{ all -> 0x0333 }
        L_0x0028:
            android.content.Context r4 = sContext     // Catch:{ all -> 0x0333 }
            boolean r4 = com.xiaomi.push.C2087u.m5375a((android.content.Context) r4)     // Catch:{ all -> 0x0333 }
            if (r4 == 0) goto L_0x0035
            android.content.Context r4 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.C1600v.m2475a(r4)     // Catch:{ all -> 0x0333 }
        L_0x0035:
            android.content.Context r4 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r4 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r4)     // Catch:{ all -> 0x0333 }
            int r4 = r4.mo17163a()     // Catch:{ all -> 0x0333 }
            int r5 = com.xiaomi.mipush.sdk.Constants.m2226a()     // Catch:{ all -> 0x0333 }
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L_0x0049
            r4 = 1
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            if (r4 != 0) goto L_0x0063
            android.content.Context r5 = sContext     // Catch:{ all -> 0x0333 }
            boolean r5 = shouldSendRegRequest(r5)     // Catch:{ all -> 0x0333 }
            if (r5 != 0) goto L_0x0063
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.ao r0 = com.xiaomi.mipush.sdk.C1568ao.m2317a((android.content.Context) r0)     // Catch:{ all -> 0x0333 }
            r0.mo17133a()     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = "Could not send  register message within 5s repeatly ."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            return
        L_0x0063:
            r5 = 30809(0x7859, float:4.3173E-41)
            java.lang.String r8 = "3_8_9"
            if (r4 != 0) goto L_0x021d
            android.content.Context r9 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r9 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r9)     // Catch:{ all -> 0x0333 }
            boolean r9 = r9.mo17169a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0333 }
            if (r9 == 0) goto L_0x021d
            android.content.Context r9 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r9 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r9)     // Catch:{ all -> 0x0333 }
            boolean r9 = r9.mo17176f()     // Catch:{ all -> 0x0333 }
            if (r9 != 0) goto L_0x021d
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            int r1 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r1)     // Catch:{ all -> 0x0333 }
            r4 = 0
            if (r6 != r1) goto L_0x009f
            java.lang.String r1 = "callback"
            checkNotNull(r2, r1)     // Catch:{ all -> 0x0333 }
            r9 = 0
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r1 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r1)     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = r1.mo17173c()     // Catch:{ all -> 0x0333 }
            r2.onInitializeResult(r9, r4, r1)     // Catch:{ all -> 0x0333 }
            goto L_0x00c3
        L_0x009f:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x0333 }
            r12.<init>()     // Catch:{ all -> 0x0333 }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r1 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r1)     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = r1.mo17173c()     // Catch:{ all -> 0x0333 }
            r12.add(r1)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.fe r1 = com.xiaomi.push.C1788fe.COMMAND_REGISTER     // Catch:{ all -> 0x0333 }
            java.lang.String r11 = r1.f2292a     // Catch:{ all -> 0x0333 }
            r13 = 0
            r15 = 0
            r16 = 0
            com.xiaomi.mipush.sdk.MiPushCommandMessage r1 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r11, r12, r13, r15, r16)     // Catch:{ all -> 0x0333 }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r2, r1)     // Catch:{ all -> 0x0333 }
        L_0x00c3:
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.ao r1 = com.xiaomi.mipush.sdk.C1568ao.m2317a((android.content.Context) r1)     // Catch:{ all -> 0x0333 }
            r1.mo17133a()     // Catch:{ all -> 0x0333 }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r1 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r1)     // Catch:{ all -> 0x0333 }
            boolean r1 = r1.mo17163a()     // Catch:{ all -> 0x0333 }
            if (r1 == 0) goto L_0x0164
            com.xiaomi.push.in r1 = new com.xiaomi.push.in     // Catch:{ all -> 0x0333 }
            r1.<init>()     // Catch:{ all -> 0x0333 }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r2 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r2)     // Catch:{ all -> 0x0333 }
            java.lang.String r2 = r2.mo17163a()     // Catch:{ all -> 0x0333 }
            r1.mo18084b((java.lang.String) r2)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.hy r2 = com.xiaomi.push.C1878hy.ClientInfoUpdate     // Catch:{ all -> 0x0333 }
            java.lang.String r2 = r2.f2959a     // Catch:{ all -> 0x0333 }
            r1.mo18087c((java.lang.String) r2)     // Catch:{ all -> 0x0333 }
            java.lang.String r2 = com.xiaomi.push.service.C1999aw.m5064a()     // Catch:{ all -> 0x0333 }
            r1.mo18078a((java.lang.String) r2)     // Catch:{ all -> 0x0333 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0333 }
            r2.<init>()     // Catch:{ all -> 0x0333 }
            r1.f3224a = r2     // Catch:{ all -> 0x0333 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f3224a     // Catch:{ all -> 0x0333 }
            java.lang.String r9 = "app_version"
            android.content.Context r10 = sContext     // Catch:{ all -> 0x0333 }
            android.content.Context r11 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ all -> 0x0333 }
            java.lang.String r10 = com.xiaomi.push.C1816g.m3659a((android.content.Context) r10, (java.lang.String) r11)     // Catch:{ all -> 0x0333 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0333 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f3224a     // Catch:{ all -> 0x0333 }
            java.lang.String r9 = "app_version_code"
            android.content.Context r10 = sContext     // Catch:{ all -> 0x0333 }
            android.content.Context r11 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ all -> 0x0333 }
            int r10 = com.xiaomi.push.C1816g.m3659a((android.content.Context) r10, (java.lang.String) r11)     // Catch:{ all -> 0x0333 }
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ all -> 0x0333 }
            r2.put(r9, r10)     // Catch:{ all -> 0x0333 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f3224a     // Catch:{ all -> 0x0333 }
            java.lang.String r9 = "push_sdk_vn"
            r2.put(r9, r8)     // Catch:{ all -> 0x0333 }
            java.util.Map<java.lang.String, java.lang.String> r2 = r1.f3224a     // Catch:{ all -> 0x0333 }
            java.lang.String r8 = "push_sdk_vc"
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0333 }
            r2.put(r8, r5)     // Catch:{ all -> 0x0333 }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x0333 }
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f3224a     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.C1907j.m4556a((android.content.Context) r2, (java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ all -> 0x0333 }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r2 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r2)     // Catch:{ all -> 0x0333 }
            java.lang.String r2 = r2.mo17175e()     // Catch:{ all -> 0x0333 }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0333 }
            if (r5 != 0) goto L_0x0159
            java.util.Map<java.lang.String, java.lang.String> r5 = r1.f3224a     // Catch:{ all -> 0x0333 }
            java.lang.String r8 = "deviceid"
            r5.put(r8, r2)     // Catch:{ all -> 0x0333 }
        L_0x0159:
            android.content.Context r2 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.ao r2 = com.xiaomi.mipush.sdk.C1568ao.m2317a((android.content.Context) r2)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.ho r5 = com.xiaomi.push.C1868ho.Notification     // Catch:{ all -> 0x0333 }
            r2.mo17143a(r1, (com.xiaomi.push.C1868ho) r5, (boolean) r7, (com.xiaomi.push.C1882ib) r4)     // Catch:{ all -> 0x0333 }
        L_0x0164:
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            boolean r1 = com.xiaomi.push.C1940o.m4734a((android.content.Context) r1, (java.lang.String) r3, (boolean) r7)     // Catch:{ all -> 0x0333 }
            if (r1 != 0) goto L_0x0174
            updateImeiOrOaid()     // Catch:{ all -> 0x0333 }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.C1940o.m4734a((android.content.Context) r1, (java.lang.String) r3, (boolean) r6)     // Catch:{ all -> 0x0333 }
        L_0x0174:
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = com.xiaomi.push.C1907j.m4568c((android.content.Context) r1)     // Catch:{ all -> 0x0333 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0333 }
            if (r2 != 0) goto L_0x01d5
            com.xiaomi.push.ii r2 = new com.xiaomi.push.ii     // Catch:{ all -> 0x0333 }
            r2.<init>()     // Catch:{ all -> 0x0333 }
            java.lang.String r3 = com.xiaomi.push.service.C1999aw.m5064a()     // Catch:{ all -> 0x0333 }
            r2.mo18002a((java.lang.String) r3)     // Catch:{ all -> 0x0333 }
            r2.mo18006b((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.fe r0 = com.xiaomi.push.C1788fe.COMMAND_CHK_VDEVID     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = r0.f2292a     // Catch:{ all -> 0x0333 }
            r2.mo18009c((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0333 }
            r0.<init>()     // Catch:{ all -> 0x0333 }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r3 = com.xiaomi.push.C1907j.m4562b((android.content.Context) r3)     // Catch:{ all -> 0x0333 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0333 }
            if (r5 != 0) goto L_0x01aa
            r0.add(r3)     // Catch:{ all -> 0x0333 }
        L_0x01aa:
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x01af
            goto L_0x01b0
        L_0x01af:
            r1 = r3
        L_0x01b0:
            r0.add(r1)     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x0333 }
            if (r1 == 0) goto L_0x01ba
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x0333 }
            goto L_0x01bb
        L_0x01ba:
            r1 = r3
        L_0x01bb:
            r0.add(r1)     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = android.os.Build.BOARD     // Catch:{ all -> 0x0333 }
            if (r1 == 0) goto L_0x01c4
            java.lang.String r3 = android.os.Build.BOARD     // Catch:{ all -> 0x0333 }
        L_0x01c4:
            r0.add(r3)     // Catch:{ all -> 0x0333 }
            r2.mo18003a((java.util.List<java.lang.String>) r0)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.ao r0 = com.xiaomi.mipush.sdk.C1568ao.m2317a((android.content.Context) r0)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.ho r1 = com.xiaomi.push.C1868ho.Command     // Catch:{ all -> 0x0333 }
            r0.mo17143a(r2, (com.xiaomi.push.C1868ho) r1, (boolean) r7, (com.xiaomi.push.C1882ib) r4)     // Catch:{ all -> 0x0333 }
        L_0x01d5:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            boolean r0 = shouldUseMIUIPush(r0)     // Catch:{ all -> 0x0333 }
            if (r0 == 0) goto L_0x02f7
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            boolean r0 = shouldPullNotification(r0)     // Catch:{ all -> 0x0333 }
            if (r0 == 0) goto L_0x02f7
            com.xiaomi.push.in r2 = new com.xiaomi.push.in     // Catch:{ all -> 0x0333 }
            r2.<init>()     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r0 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r0)     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = r0.mo17163a()     // Catch:{ all -> 0x0333 }
            r2.mo18084b((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.hy r0 = com.xiaomi.push.C1878hy.PullOfflineMessage     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = r0.f2959a     // Catch:{ all -> 0x0333 }
            r2.mo18087c((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = com.xiaomi.push.service.C1999aw.m5064a()     // Catch:{ all -> 0x0333 }
            r2.mo18078a((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            r2.mo18081a((boolean) r7)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.ao r1 = com.xiaomi.mipush.sdk.C1568ao.m2317a((android.content.Context) r0)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.ho r3 = com.xiaomi.push.C1868ho.Notification     // Catch:{ all -> 0x0333 }
            r4 = 0
            r5 = 0
            r6 = 0
            r1.mo17144a(r2, (com.xiaomi.push.C1868ho) r3, (boolean) r4, (com.xiaomi.push.C1882ib) r5, (boolean) r6)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            addPullNotificationTime(r0)     // Catch:{ all -> 0x0333 }
            goto L_0x02f7
        L_0x021d:
            r2 = 6
            java.lang.String r2 = com.xiaomi.push.C1663bo.m2726a((int) r2)     // Catch:{ all -> 0x0333 }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r3 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r3)     // Catch:{ all -> 0x0333 }
            r3.mo17163a()     // Catch:{ all -> 0x0333 }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r3 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r3)     // Catch:{ all -> 0x0333 }
            int r7 = com.xiaomi.mipush.sdk.Constants.m2226a()     // Catch:{ all -> 0x0333 }
            r3.mo17165a((int) r7)     // Catch:{ all -> 0x0333 }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.b r3 = com.xiaomi.mipush.sdk.C1578b.m2373a((android.content.Context) r3)     // Catch:{ all -> 0x0333 }
            r3.mo17167a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.MiTinyDataClient$a r3 = com.xiaomi.mipush.sdk.MiTinyDataClient.C1550a.mo17085a()     // Catch:{ all -> 0x0333 }
            java.lang.String r7 = "com.xiaomi.xmpushsdk.tinydataPending.appId"
            r3.mo17087b((java.lang.String) r7)     // Catch:{ all -> 0x0333 }
            android.content.Context r3 = sContext     // Catch:{ all -> 0x0333 }
            clearExtras(r3)     // Catch:{ all -> 0x0333 }
            clearNotification(r17)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.io r3 = new com.xiaomi.push.io     // Catch:{ all -> 0x0333 }
            r3.<init>()     // Catch:{ all -> 0x0333 }
            java.lang.String r7 = com.xiaomi.push.service.C1999aw.m5064a()     // Catch:{ all -> 0x0333 }
            r3.mo18113a((java.lang.String) r7)     // Catch:{ all -> 0x0333 }
            r3.mo18117b((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            r3.mo18128e((java.lang.String) r1)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0333 }
            r3.mo18125d((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            r3.mo18132f((java.lang.String) r2)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = com.xiaomi.push.C1816g.m3659a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0333 }
            r3.mo18121c((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0333 }
            int r0 = com.xiaomi.push.C1816g.m3659a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0333 }
            r3.mo18116b((int) r0)     // Catch:{ all -> 0x0333 }
            r3.mo18138h((java.lang.String) r8)     // Catch:{ all -> 0x0333 }
            r3.mo18111a((int) r5)     // Catch:{ all -> 0x0333 }
            com.xiaomi.push.ic r0 = com.xiaomi.push.C1883ic.Init     // Catch:{ all -> 0x0333 }
            r3.mo18112a((com.xiaomi.push.C1883ic) r0)     // Catch:{ all -> 0x0333 }
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ all -> 0x0333 }
            if (r0 != 0) goto L_0x02a4
            r0 = r21
            r3.mo18135g((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
        L_0x02a4:
            boolean r0 = com.xiaomi.push.C1938m.m4731d()     // Catch:{ all -> 0x0333 }
            if (r0 != 0) goto L_0x02d7
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = com.xiaomi.push.C1907j.m4576g(r0)     // Catch:{ all -> 0x0333 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0333 }
            if (r1 != 0) goto L_0x02d7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0333 }
            r1.<init>()     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = com.xiaomi.push.C1663bo.m2727a((java.lang.String) r0)     // Catch:{ all -> 0x0333 }
            r1.append(r0)     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = ","
            r1.append(r0)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = com.xiaomi.push.C1907j.m4579j(r0)     // Catch:{ all -> 0x0333 }
            r1.append(r0)     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x0333 }
            r3.mo18142i(r0)     // Catch:{ all -> 0x0333 }
        L_0x02d7:
            int r0 = com.xiaomi.push.C1907j.m4548a()     // Catch:{ all -> 0x0333 }
            if (r0 < 0) goto L_0x02e0
            r3.mo18120c((int) r0)     // Catch:{ all -> 0x0333 }
        L_0x02e0:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.ao r0 = com.xiaomi.mipush.sdk.C1568ao.m2317a((android.content.Context) r0)     // Catch:{ all -> 0x0333 }
            r0.mo17139a((com.xiaomi.push.C1895io) r3, (boolean) r4)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = "mipush_extra"
            r2 = 4
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = "mipush_registed"
            r0.getBoolean(r1, r6)     // Catch:{ all -> 0x0333 }
        L_0x02f7:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            addRegRequestTime(r0)     // Catch:{ all -> 0x0333 }
            scheduleOcVersionCheckJob()     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            scheduleDataCollectionJobs(r0)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            initEventPerfLogic(r0)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.C1576av.m2367a((android.content.Context) r0)     // Catch:{ all -> 0x0333 }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x0333 }
            java.lang.String r1 = "com.xiaomi.xmsf"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0333 }
            if (r0 != 0) goto L_0x032f
            com.xiaomi.channel.commonutils.logger.LoggerInterface r0 = com.xiaomi.mipush.sdk.Logger.getUserLogger()     // Catch:{ all -> 0x0333 }
            if (r0 == 0) goto L_0x032b
            android.content.Context r0 = sContext     // Catch:{ all -> 0x0333 }
            com.xiaomi.channel.commonutils.logger.LoggerInterface r1 = com.xiaomi.mipush.sdk.Logger.getUserLogger()     // Catch:{ all -> 0x0333 }
            com.xiaomi.mipush.sdk.Logger.setLogger(r0, r1)     // Catch:{ all -> 0x0333 }
        L_0x032b:
            r0 = 2
            com.xiaomi.channel.commonutils.logger.C1524b.m2145a((int) r0)     // Catch:{ all -> 0x0333 }
        L_0x032f:
            operateSyncAction(r17)     // Catch:{ all -> 0x0333 }
            goto L_0x0337
        L_0x0333:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r0)
        L_0x0337:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.initialize(android.content.Context, java.lang.String, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$MiPushClientCallback, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult):void");
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(C1559af.m2278a(sContext).mo17126a(C1575au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(C1559af.m2278a(sContext).mo17126a(C1575au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(C1559af.m2278a(sContext).mo17126a(C1575au.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(C1559af.m2278a(sContext).mo17126a(C1575au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(C1559af.m2278a(sContext).mo17126a(C1575au.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(C1559af.m2278a(sContext).mo17126a(C1575au.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, C1883ic icVar) {
        C1524b.m2161e("re-register reason: " + icVar);
        String a = C1663bo.m2726a(6);
        String a2 = C1578b.m2373a(context).mo17163a();
        String b = C1578b.m2373a(context).mo17170b();
        C1578b.m2373a(context).mo17163a();
        clearNotification(context);
        C1578b.m2373a(context).mo17165a(Constants.m2226a());
        C1578b.m2373a(context).mo17167a(a2, b, a);
        C1895io ioVar = new C1895io();
        ioVar.mo18113a(C1999aw.m5064a());
        ioVar.mo18117b(a2);
        ioVar.mo18128e(b);
        ioVar.mo18132f(a);
        ioVar.mo18125d(context.getPackageName());
        ioVar.mo18121c(C1816g.m3659a(context, context.getPackageName()));
        ioVar.mo18116b(C1816g.m3659a(context, context.getPackageName()));
        ioVar.mo18138h("3_8_9");
        ioVar.mo18111a(30809);
        ioVar.mo18112a(icVar);
        int a3 = C1907j.m4548a();
        if (a3 >= 0) {
            ioVar.mo18120c(a3);
        }
        C1568ao.m2317a(context).mo17139a(ioVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver((Object) null), intentFilter);
        } catch (Throwable th) {
            C1524b.m2155a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, (String) null, (ICallbackResult) null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        sContext = context.getApplicationContext();
        if (sContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        C2087u.m5375a(context2);
        if (!NetworkStatusReceiver.m5332a()) {
            registerNetworkReceiver(sContext);
        }
        C1583f.m2419a(sContext).mo17189a(pushConfiguration);
        C1618ak.m2518a(context2).mo17212a((Runnable) new Runnable() {
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, (MiPushClientCallback) null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, (ICallbackResult) null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), (String) null, uPSRegisterCallBack);
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            C1945s.m4744a(edit);
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
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
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (C1578b.m2373a(context).mo17170b()) {
            C1878hy hyVar = z ? C1878hy.APP_SLEEP : C1878hy.APP_WAKEUP;
            C1894in inVar = new C1894in();
            inVar.mo18084b(C1578b.m2373a(context).mo17163a());
            inVar.mo18087c(hyVar.f2959a);
            inVar.mo18091d(context.getPackageName());
            inVar.mo18078a(C1999aw.m5064a());
            inVar.mo18081a(false);
            C1568ao.m2317a(context).mo17144a(inVar, C1868ho.Notification, false, (C1882ib) null, false);
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, C1882ib ibVar, String str2, String str3) {
        C1894in inVar = new C1894in();
        if (TextUtils.isEmpty(str3)) {
            C1524b.m2160d("do not report clicked message");
            return;
        }
        inVar.mo18084b(str3);
        inVar.mo18087c("bar:click");
        inVar.mo18078a(str);
        inVar.mo18081a(false);
        C1568ao.m2317a(context).mo17146a(inVar, C1868ho.Notification, false, true, ibVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        C1882ib ibVar = new C1882ib();
        ibVar.mo17879a(miPushMessage.getMessageId());
        ibVar.mo17885b(miPushMessage.getTopic());
        ibVar.mo17893d(miPushMessage.getDescription());
        ibVar.mo17890c(miPushMessage.getTitle());
        ibVar.mo17889c(miPushMessage.getNotifyId());
        ibVar.mo17878a(miPushMessage.getNotifyType());
        ibVar.mo17884b(miPushMessage.getPassThrough());
        ibVar.mo17880a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), ibVar, (String) null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, (C1882ib) null, (String) null);
    }

    static void reportMessageClicked(Context context, String str, C1882ib ibVar, String str2) {
        C1894in inVar = new C1894in();
        if (TextUtils.isEmpty(str2)) {
            if (C1578b.m2373a(context).mo17170b()) {
                str2 = C1578b.m2373a(context).mo17163a();
            } else {
                C1524b.m2160d("do not report clicked message");
                return;
            }
        }
        inVar.mo18084b(str2);
        inVar.mo18087c("bar:click");
        inVar.mo18078a(str);
        inVar.mo18081a(false);
        C1568ao.m2317a(context).mo17143a(inVar, C1868ho.Notification, false, ibVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (C1995at.m5047a(sContext).mo18472a(C1873ht.DataCollectionSwitch.mo17806a(), getDefaultSwitch())) {
            C1733ds.mo17399a().mo17400a(new C1596r(context));
            C1618ak.m2518a(sContext).mo17213a((Runnable) new Runnable() {
                public void run() {
                    C1734dt.m3043a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        C1618ak.m2518a(sContext).mo17216a(new C1558ae(sContext), C1995at.m5047a(sContext).mo18465a(C1873ht.OcVersionCheckFrequency.mo17806a(), (int) RemoteMessageConst.DEFAULT_TTL), 5);
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
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
        long j = ((((long) ((i5 * 60) + i6)) + rawOffset) + 1440) % 1440;
        long j2 = ((((long) ((i7 * 60) + i8)) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)}));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}));
        if (!acceptTimeSet(context2, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context2, C1788fe.COMMAND_SET_ACCEPT_TIME.f2292a, (ArrayList<String>) arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m2264a(context, str, C1788fe.COMMAND_SET_ACCEPT_TIME.f2292a, 0, (String) null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_SET_ACCEPT_TIME.f2292a, arrayList2, 0, (String) null, (String) null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, C1788fe.COMMAND_SET_ALIAS.f2292a, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        C1788fe feVar;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!C1788fe.COMMAND_SET_ALIAS.f2292a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= 86400000) {
            if (C1788fe.COMMAND_UNSET_ALIAS.f2292a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (!C1788fe.COMMAND_SET_ACCOUNT.f2292a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= 3600000) {
                if (!C1788fe.COMMAND_UNSET_ACCOUNT.f2292a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                    setCommand(context, str, (ArrayList<String>) arrayList, str3);
                    return;
                } else {
                    sb = new StringBuilder();
                    str4 = "Don't cancel account for ";
                }
            } else if (1 != PushMessageHelper.getPushMode(context)) {
                feVar = C1788fe.COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(feVar.f2292a, arrayList, 0, (String) null, str3));
                return;
            }
            sb.append(str4);
            sb.append(C1663bo.m2728a(arrayList.toString(), 3));
            sb.append(" is unseted");
            C1524b.m2141a(sb.toString());
            return;
        } else if (1 != PushMessageHelper.getPushMode(context)) {
            feVar = C1788fe.COMMAND_SET_ALIAS;
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(feVar.f2292a, arrayList, 0, (String) null, str3));
            return;
        }
        PushMessageHandler.m2264a(context, str3, str, 0, (String) null, arrayList);
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(C1578b.m2373a(context).mo17163a())) {
            C1889ii iiVar = new C1889ii();
            String a = C1999aw.m5064a();
            iiVar.mo18002a(a);
            iiVar.mo18006b(C1578b.m2373a(context).mo17163a());
            iiVar.mo18009c(str);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                iiVar.mo18002a(it.next());
            }
            iiVar.mo18015e(str2);
            iiVar.mo18013d(context.getPackageName());
            C1524b.m2161e("cmd:" + str + ", " + a);
            C1568ao.m2317a(context).mo17141a(iiVar, C1868ho.Command, (C1882ib) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        C1568ao.m2317a(context).mo17154b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, C1788fe.COMMAND_SET_ACCOUNT.f2292a, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return C1568ao.m2317a(context).mo17133a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(C1578b.m2373a(context).mo17163a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                C1899is isVar = new C1899is();
                String a = C1999aw.m5064a();
                isVar.mo18222a(a);
                isVar.mo18224b(C1578b.m2373a(context).mo17163a());
                isVar.mo18226c(str);
                isVar.mo18229d(context.getPackageName());
                isVar.mo18231e(str2);
                C1524b.m2161e("cmd:" + C1788fe.COMMAND_SUBSCRIBE_TOPIC + ", " + a);
                C1568ao.m2317a(context).mo17141a(isVar, C1868ho.Subscription, (C1882ib) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m2263a(context, str2, 0, (String) null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(C1788fe.COMMAND_SUBSCRIBE_TOPIC.f2292a, arrayList, 0, (String) null, (String) null));
            }
        }
    }

    public static void syncAssembleCOSPushToken(Context context) {
        C1568ao.m2317a(context).mo17149a((String) null, C1575au.UPLOAD_COS_TOKEN, C1582e.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        C1568ao.m2317a(context).mo17149a((String) null, C1575au.UPLOAD_FCM_TOKEN, C1582e.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        C1568ao.m2317a(context).mo17149a((String) null, C1575au.UPLOAD_FTOS_TOKEN, C1582e.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        C1568ao.m2317a(context).mo17149a((String) null, C1575au.UPLOAD_HUAWEI_TOKEN, C1582e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken((String) null);
            tokenResult.getToken();
            tokenResult.setResultCode(0);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        C1586i.m2445c(context);
        C1995at.m5047a(context).mo18468a();
        if (C1578b.m2373a(context).mo17170b()) {
            C1901iu iuVar = new C1901iu();
            iuVar.mo18255a(C1999aw.m5064a());
            iuVar.mo18258b(C1578b.m2373a(context).mo17163a());
            iuVar.mo18261c(C1578b.m2373a(context).mo17173c());
            iuVar.mo18266e(C1578b.m2373a(context).mo17170b());
            iuVar.mo18264d(context.getPackageName());
            C1568ao.m2317a(context).mo17140a(iuVar);
            PushMessageHandler.mo17007a();
            PushMessageHandler.m2268b();
            C1578b.m2373a(context).mo17170b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, C1788fe.COMMAND_UNSET_ALIAS.f2292a, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, C1788fe.COMMAND_UNSET_ACCOUNT.f2292a, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (C1578b.m2373a(context).mo17170b()) {
            if (topicSubscribedTime(context, str) < 0) {
                C1524b.m2141a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            C1903iw iwVar = new C1903iw();
            String a = C1999aw.m5064a();
            iwVar.mo18296a(a);
            iwVar.mo18298b(C1578b.m2373a(context).mo17163a());
            iwVar.mo18300c(str);
            iwVar.mo18303d(context.getPackageName());
            iwVar.mo18305e(str2);
            C1524b.m2161e("cmd:" + C1788fe.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a);
            C1568ao.m2317a(context).mo17141a(iwVar, C1868ho.UnSubscription, (C1882ib) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() {
            public void run() {
                if (C1938m.m4731d()) {
                    return;
                }
                if (C1907j.m4575f(MiPushClient.sContext) != null || C1640az.m2599a(MiPushClient.sContext).mo17232a()) {
                    C1894in inVar = new C1894in();
                    inVar.mo18084b(C1578b.m2373a(MiPushClient.sContext).mo17163a());
                    inVar.mo18087c(C1878hy.ClientInfoUpdate.f2959a);
                    inVar.mo18078a(C1999aw.m5064a());
                    inVar.mo18080a((Map<String, String>) new HashMap());
                    String str = "";
                    String f = C1907j.m4575f(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(f)) {
                        str = str + C1663bo.m2727a(f);
                    }
                    String h = C1907j.m4577h(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(h)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + h;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        inVar.mo18077a().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    C1640az.m2599a(MiPushClient.sContext).mo17240a((Map<String, String>) inVar.mo18077a());
                    C1907j.m4556a(MiPushClient.sContext, inVar.f3224a);
                    int a = C1907j.m4548a();
                    if (a >= 0) {
                        inVar.mo18077a().put("space_id", Integer.toString(a));
                    }
                    C1568ao.m2317a(MiPushClient.sContext).mo17143a(inVar, C1868ho.Notification, false, (C1882ib) null);
                }
            }
        }).start();
    }
}
