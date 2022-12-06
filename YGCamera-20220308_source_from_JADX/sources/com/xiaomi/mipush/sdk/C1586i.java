package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1653bi;
import com.xiaomi.push.C1945s;
import com.xiaomi.push.service.C1995at;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mipush.sdk.i */
public class C1586i {

    /* renamed from: a */
    private static HashMap<String, String> f1724a = new HashMap<>();

    /* renamed from: a */
    public static MiPushMessage m2429a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "extra";
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.CONTENT)) {
                    miPushMessage.setContent(jSONObject.getString(RemoteMessageConst.Notification.CONTENT));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                String str3 = str2;
                if (jSONObject.has(str3)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e) {
                C1524b.m2160d(e.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[Catch:{ Exception -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.xiaomi.mipush.sdk.PushMessageReceiver m2430a(android.content.Context r5) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r1)
            java.lang.String r1 = r5.getPackageName()
            r0.setPackage(r1)
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            r2 = 32
            r3 = 0
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)     // Catch:{ Exception -> 0x0051 }
            if (r0 == 0) goto L_0x003e
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x001f:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0051 }
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1     // Catch:{ Exception -> 0x0051 }
            android.content.pm.ActivityInfo r2 = r1.activityInfo     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x001f
            android.content.pm.ActivityInfo r2 = r1.activityInfo     // Catch:{ Exception -> 0x0051 }
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x0051 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x0051 }
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x001f
            goto L_0x003f
        L_0x003e:
            r1 = r3
        L_0x003f:
            if (r1 == 0) goto L_0x0050
            android.content.pm.ActivityInfo r0 = r1.activityInfo     // Catch:{ Exception -> 0x0051 }
            java.lang.String r0 = r0.name     // Catch:{ Exception -> 0x0051 }
            java.lang.Class r5 = com.xiaomi.push.C2087u.m5373a(r5, r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.Object r5 = r5.newInstance()     // Catch:{ Exception -> 0x0051 }
            com.xiaomi.mipush.sdk.PushMessageReceiver r5 = (com.xiaomi.mipush.sdk.PushMessageReceiver) r5     // Catch:{ Exception -> 0x0051 }
            return r5
        L_0x0050:
            return r3
        L_0x0051:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.C1586i.m2430a(android.content.Context):com.xiaomi.mipush.sdk.PushMessageReceiver");
    }

    /* renamed from: a */
    protected static synchronized String m2431a(Context context, String str) {
        String str2;
        synchronized (C1586i.class) {
            str2 = f1724a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static String m2432a(C1582e eVar) {
        int i = C1588k.f1728a[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> m2433a(android.content.Context r10, com.xiaomi.mipush.sdk.C1582e r11) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = m2432a((com.xiaomi.mipush.sdk.C1582e) r11)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int[] r2 = com.xiaomi.mipush.sdk.C1588k.f1728a
            int r11 = r11.ordinal()
            r11 = r2[r11]
            r2 = 1
            r3 = 0
            java.lang.String r4 = "package_name"
            java.lang.String r5 = "token"
            java.lang.String r6 = "brand:"
            java.lang.String r7 = ":"
            java.lang.String r8 = "~"
            if (r11 == r2) goto L_0x007d
            r2 = 2
            if (r11 == r2) goto L_0x0047
            r2 = 3
            if (r11 == r2) goto L_0x003c
            r2 = 4
            if (r11 == r2) goto L_0x0031
            goto L_0x00e4
        L_0x0031:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.C1560ag.f1655e
            goto L_0x0051
        L_0x003c:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.C1560ag.f1654d
            goto L_0x0051
        L_0x0047:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r6)
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.C1560ag.f1653c
        L_0x0051:
            java.lang.String r2 = r2.name()
            r11.append(r2)
            r11.append(r8)
            r11.append(r5)
            r11.append(r7)
            java.lang.String r1 = m2431a((android.content.Context) r10, (java.lang.String) r1)
            r11.append(r1)
            r11.append(r8)
            r11.append(r4)
            r11.append(r7)
            java.lang.String r10 = r10.getPackageName()
            r11.append(r10)
            java.lang.String r3 = r11.toString()
            goto L_0x00e4
        L_0x007d:
            android.content.pm.PackageManager r11 = r10.getPackageManager()     // Catch:{ Exception -> 0x008c }
            java.lang.String r2 = r10.getPackageName()     // Catch:{ Exception -> 0x008c }
            r9 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r3 = r11.getApplicationInfo(r2, r9)     // Catch:{ Exception -> 0x008c }
            goto L_0x0094
        L_0x008c:
            r11 = move-exception
            java.lang.String r11 = r11.toString()
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r11)
        L_0x0094:
            r11 = -1
            if (r3 == 0) goto L_0x009f
            android.os.Bundle r11 = r3.metaData
            java.lang.String r2 = "com.huawei.hms.client.appid"
            int r11 = r11.getInt(r2)
        L_0x009f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            com.xiaomi.mipush.sdk.ag r3 = com.xiaomi.mipush.sdk.C1592n.m2452a((android.content.Context) r10)
            java.lang.String r3 = r3.name()
            r2.append(r3)
            r2.append(r8)
            r2.append(r5)
            r2.append(r7)
            java.lang.String r1 = m2431a((android.content.Context) r10, (java.lang.String) r1)
            r2.append(r1)
            r2.append(r8)
            r2.append(r4)
            r2.append(r7)
            java.lang.String r10 = r10.getPackageName()
            r2.append(r10)
            r2.append(r8)
            java.lang.String r10 = "app_id"
            r2.append(r10)
            r2.append(r7)
            r2.append(r11)
            java.lang.String r3 = r2.toString()
        L_0x00e4:
            java.lang.String r10 = "RegInfo"
            r0.put(r10, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.C1586i.m2433a(android.content.Context, com.xiaomi.mipush.sdk.e):java.util.HashMap");
    }

    /* renamed from: a */
    static void m2434a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a = m2432a(C1582e.ASSEMBLE_PUSH_HUAWEI);
        String a2 = m2432a(C1582e.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a, "")) && TextUtils.isEmpty(sharedPreferences.getString(a2, ""))) {
            z = true;
        }
        if (z) {
            C1568ao.m2317a(context).mo17136a(2, a);
        }
    }

    /* renamed from: a */
    public static void m2435a(Context context, C1582e eVar) {
        String a = m2432a(eVar);
        if (!TextUtils.isEmpty(a)) {
            C1945s.m4744a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a, ""));
        }
    }

    /* renamed from: a */
    public static void m2436a(Context context, C1582e eVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
            String a = m2432a(eVar);
            if (TextUtils.isEmpty(a)) {
                C1524b.m2141a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            String string = sharedPreferences.getString(a, "");
            if (TextUtils.isEmpty(string) || !str.equals(string)) {
                C1524b.m2141a("ASSEMBLE_PUSH : send token upload");
                m2438a(eVar, str);
                C1575au a2 = C1589l.m2448a(eVar);
                if (a2 != null) {
                    C1568ao.m2317a(context).mo17149a((String) null, a2, eVar);
                    return;
                }
                return;
            }
            C1524b.m2141a("ASSEMBLE_PUSH : do not need to send token");
        }
    }

    /* renamed from: a */
    public static void m2437a(Intent intent) {
        Bundle extras;
        if (intent != null && (extras = intent.getExtras()) != null && extras.containsKey("pushMsg")) {
            intent.putExtra(PushMessageHelper.KEY_MESSAGE, m2429a(extras.getString("pushMsg")));
        }
    }

    /* renamed from: a */
    private static synchronized void m2438a(C1582e eVar, String str) {
        synchronized (C1586i.class) {
            String a = m2432a(eVar);
            if (TextUtils.isEmpty(a)) {
                C1524b.m2141a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                C1524b.m2141a("ASSEMBLE_PUSH : token is null");
            } else {
                f1724a.put(a, str);
            }
        }
    }

    /* renamed from: a */
    public static void m2439a(String str, int i) {
        MiTinyDataClient.upload("hms_push_error", str, 1, "error code = " + i);
    }

    /* renamed from: a */
    public static boolean m2440a(Context context) {
        if (context == null) {
            return false;
        }
        return C1653bi.m2685b(context);
    }

    /* renamed from: a */
    public static boolean m2441a(Context context, C1582e eVar) {
        if (C1589l.m2448a(eVar) != null) {
            return C1995at.m5047a(context).mo18472a(C1589l.m2448a(eVar).mo17806a(), true);
        }
        return false;
    }

    /* renamed from: b */
    public static String m2442b(C1582e eVar) {
        int i = C1588k.f1728a[eVar.ordinal()];
        if (i == 1) {
            return "hms_push_error";
        }
        if (i == 2) {
            return "fcm_push_error";
        }
        if (i == 3) {
            return "cos_push_error";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_error";
    }

    /* renamed from: b */
    public static void m2443b(Context context) {
        C1583f.m2419a(context).register();
    }

    /* renamed from: b */
    public static void m2444b(Context context, C1582e eVar, String str) {
        C1618ak.m2518a(context).mo17212a((Runnable) new C1587j(str, context, eVar));
    }

    /* renamed from: c */
    public static void m2445c(Context context) {
        C1583f.m2419a(context).unregister();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static synchronized void m2447d(Context context, C1582e eVar, String str) {
        synchronized (C1586i.class) {
            String a = m2432a(eVar);
            if (TextUtils.isEmpty(a)) {
                C1524b.m2141a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            C1945s.m4744a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a, str));
            C1524b.m2141a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
