package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.a.f;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;
import java.util.HashMap;
import java.util.Map;

public class PushManager {
    private static Map a(Context context, Map map) {
        HashMap hashMap = new HashMap();
        h hVar = new h(context, "tags_info");
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (hVar.e(str)) {
                String b = hVar.b(str);
                if (!TextUtils.isEmpty(str2) && str2.equals(b)) {
                    e.a("PushLogAC2705", "tag has reported:" + entry);
                }
            }
            hashMap.put(str, str2);
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0092, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void deleteTags(android.content.Context r7, java.util.List r8) throws com.huawei.android.pushagent.PushException {
        /*
            java.lang.Class<com.huawei.android.pushagent.PushManager> r0 = com.huawei.android.pushagent.PushManager.class
            monitor-enter(r0)
            if (r8 == 0) goto L_0x00a9
            int r1 = r8.size()     // Catch:{ Exception -> 0x0095 }
            if (r1 != 0) goto L_0x000d
            goto L_0x00a9
        L_0x000d:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x0095 }
            r1.<init>()     // Catch:{ Exception -> 0x0095 }
            com.huawei.android.pushagent.c.a.h r2 = new com.huawei.android.pushagent.c.a.h     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = "tags_info"
            r2.<init>(r7, r3)     // Catch:{ Exception -> 0x0095 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0095 }
        L_0x001d:
            boolean r3 = r8.hasNext()     // Catch:{ Exception -> 0x0095 }
            r4 = 2
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r8.next()     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0095 }
            boolean r5 = r2.e(r3)     // Catch:{ Exception -> 0x0095 }
            if (r5 == 0) goto L_0x0049
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0095 }
            r5.<init>()     // Catch:{ Exception -> 0x0095 }
            java.lang.String r6 = "tagKey"
            r5.put(r6, r3)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = "opType"
            r5.put(r3, r4)     // Catch:{ Exception -> 0x0095 }
            int r3 = r5.length()     // Catch:{ Exception -> 0x0095 }
            if (r3 <= 0) goto L_0x001d
            r1.put(r5)     // Catch:{ Exception -> 0x0095 }
            goto L_0x001d
        L_0x0049:
            java.lang.String r4 = "PushLogAC2705"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095 }
            r5.<init>()     // Catch:{ Exception -> 0x0095 }
            r5.append(r3)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = " not exist, need not to remove"
            r5.append(r3)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x0095 }
            com.huawei.android.pushagent.c.a.e.a(r4, r3)     // Catch:{ Exception -> 0x0095 }
            goto L_0x001d
        L_0x0060:
            int r8 = r1.length()     // Catch:{ Exception -> 0x0095 }
            if (r8 <= 0) goto L_0x008a
            java.lang.String r8 = "PushLogAC2705"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0095 }
            r2.<init>()     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = "begin to deleTags: "
            r2.append(r3)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r3 = r1.toString()     // Catch:{ Exception -> 0x0095 }
            r2.append(r3)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0095 }
            com.huawei.android.pushagent.c.a.e.a(r8, r2)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r8 = r1.toString()     // Catch:{ Exception -> 0x0095 }
            r1 = 0
            com.huawei.android.pushagent.c.e.a(r7, r8, r1, r4)     // Catch:{ Exception -> 0x0095 }
            goto L_0x0091
        L_0x008a:
            java.lang.String r7 = "PushLogAC2705"
            java.lang.String r8 = "no tag need to delete"
            com.huawei.android.pushagent.c.a.e.b(r7, r8)     // Catch:{ Exception -> 0x0095 }
        L_0x0091:
            monitor-exit(r0)
            return
        L_0x0093:
            r7 = move-exception
            goto L_0x00a7
        L_0x0095:
            r7 = move-exception
            java.lang.String r8 = "PushLogAC2705"
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0093 }
            com.huawei.android.pushagent.c.a.e.b(r8, r7)     // Catch:{ all -> 0x0093 }
            com.huawei.android.pushagent.PushException r7 = new com.huawei.android.pushagent.PushException     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = "delete tags failed"
            r7.<init>((java.lang.String) r8)     // Catch:{ all -> 0x0093 }
            throw r7     // Catch:{ all -> 0x0093 }
        L_0x00a7:
            monitor-exit(r0)
            throw r7
        L_0x00a9:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.PushManager.deleteTags(android.content.Context, java.util.List):void");
    }

    public static final void deregisterToken(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            e.a("PushLogAC2705", "token is null, can not deregister token");
            return;
        }
        String r = a.r(context);
        if (TextUtils.isEmpty(r)) {
            if (a.o(context)) {
                e.a("PushLogAC2705", "votedPackage is null, deregister token from frameworkPush");
                r = "android";
            } else {
                e.a("PushLogAC2705", "votedPackage is null and not exist frameworkPush, can not deregister token");
                return;
            }
        }
        String a = f.a(context, str);
        Intent intent = new Intent("com.huawei.android.push.intent.DEREGISTER");
        intent.putExtra("pkg_name", context.getPackageName());
        intent.putExtra("device_token", a);
        intent.putExtra("isTokenEncrypt", true);
        intent.setPackage(r);
        context.sendBroadcast(intent);
    }

    public static final void enableReceiveNormalMsg(Context context, boolean z) {
        if (context == null) {
            e.a("PushLogAC2705", "context is null");
        } else {
            new h(context, "push_switch").a("normal_msg_enable", !z);
        }
    }

    public static final void enableReceiveNotifyMsg(Context context, boolean z) {
        if (context == null) {
            e.a("PushLogAC2705", "context is null");
        } else {
            new h(context, "push_switch").a("notify_msg_enable", !z);
        }
    }

    public static synchronized Map getTags(Context context) throws PushException {
        Map b;
        synchronized (PushManager.class) {
            try {
                b = new h(context, "tags_info").b();
            } catch (Exception e) {
                e.b("PushLogAC2705", e.toString());
                throw new PushException("get tags failed");
            }
        }
        return b;
    }

    public static void requestPushState(Context context) {
        PushReceiver.getPushState(context);
    }

    public static void requestToken(Context context) {
        PushReceiver.getToken(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void setTags(android.content.Context r8, java.util.Map r9) throws com.huawei.android.pushagent.PushException {
        /*
            java.lang.Class<com.huawei.android.pushagent.PushManager> r0 = com.huawei.android.pushagent.PushManager.class
            monitor-enter(r0)
            if (r9 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            java.util.Map r9 = a(r8, r9)     // Catch:{ all -> 0x009f }
            com.huawei.android.pushagent.c.a.h r1 = new com.huawei.android.pushagent.c.a.h     // Catch:{ Exception -> 0x008d }
            java.lang.String r2 = "tags_info"
            r1.<init>(r8, r2)     // Catch:{ Exception -> 0x008d }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x008d }
            r2.<init>()     // Catch:{ Exception -> 0x008d }
            java.util.Set r9 = r9.entrySet()     // Catch:{ Exception -> 0x008d }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x008d }
        L_0x001f:
            boolean r3 = r9.hasNext()     // Catch:{ Exception -> 0x008d }
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r9.next()     // Catch:{ Exception -> 0x008d }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x008d }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x008d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x008d }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x008d }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x008d }
            r5.<init>()     // Catch:{ Exception -> 0x008d }
            java.lang.String r6 = "tagKey"
            r5.put(r6, r4)     // Catch:{ Exception -> 0x008d }
            java.lang.String r6 = "tagValue"
            r5.put(r6, r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r6 = "opType"
            r7 = 1
            r5.put(r6, r7)     // Catch:{ Exception -> 0x008d }
            int r6 = r5.length()     // Catch:{ Exception -> 0x008d }
            if (r6 <= 0) goto L_0x0055
            r2.put(r5)     // Catch:{ Exception -> 0x008d }
        L_0x0055:
            r1.a((java.lang.String) r4, (java.lang.Object) r3)     // Catch:{ Exception -> 0x008d }
            goto L_0x001f
        L_0x0059:
            int r9 = r2.length()     // Catch:{ Exception -> 0x008d }
            if (r9 <= 0) goto L_0x0084
            java.lang.String r9 = "PushLogAC2705"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008d }
            r1.<init>()     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = "begin to setTags: "
            r1.append(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x008d }
            r1.append(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x008d }
            com.huawei.android.pushagent.c.a.e.a(r9, r1)     // Catch:{ Exception -> 0x008d }
            java.lang.String r9 = r2.toString()     // Catch:{ Exception -> 0x008d }
            r1 = 0
            r3 = 2
            com.huawei.android.pushagent.c.e.a(r8, r9, r1, r3)     // Catch:{ Exception -> 0x008d }
            goto L_0x008b
        L_0x0084:
            java.lang.String r8 = "PushLogAC2705"
            java.lang.String r9 = "no tag need to upload"
            com.huawei.android.pushagent.c.a.e.b(r8, r9)     // Catch:{ Exception -> 0x008d }
        L_0x008b:
            monitor-exit(r0)
            return
        L_0x008d:
            r8 = move-exception
            java.lang.String r9 = "PushLogAC2705"
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x009f }
            com.huawei.android.pushagent.c.a.e.b(r9, r8)     // Catch:{ all -> 0x009f }
            com.huawei.android.pushagent.PushException r8 = new com.huawei.android.pushagent.PushException     // Catch:{ all -> 0x009f }
            java.lang.String r9 = "set tags failed"
            r8.<init>((java.lang.String) r9)     // Catch:{ all -> 0x009f }
            throw r8     // Catch:{ all -> 0x009f }
        L_0x009f:
            r8 = move-exception
            monitor-exit(r0)
            goto L_0x00a3
        L_0x00a2:
            throw r8
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.PushManager.setTags(android.content.Context, java.util.Map):void");
    }
}
