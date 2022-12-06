package com.huawei.hms.push;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.o */
/* compiled from: PushNotification */
public class C0885o {

    /* renamed from: a */
    public static int f922a;

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01a6, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01ab, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m1287a(android.content.Context r9, com.huawei.hms.push.C0881k r10) {
        /*
            java.lang.Class<com.huawei.hms.push.o> r0 = com.huawei.hms.push.C0885o.class
            monitor-enter(r0)
            if (r9 == 0) goto L_0x01aa
            if (r10 != 0) goto L_0x0009
            goto L_0x01aa
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r1.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r2 = "showNotification, the msg id = "
            r1.append(r2)     // Catch:{ all -> 0x01a7 }
            java.lang.String r2 = r10.mo14319p()     // Catch:{ all -> 0x01a7 }
            r1.append(r2)     // Catch:{ all -> 0x01a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a7 }
            java.lang.String r2 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.m1374d(r2, r1)     // Catch:{ all -> 0x01a7 }
            int r1 = f922a     // Catch:{ all -> 0x01a7 }
            if (r1 != 0) goto L_0x0044
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r1.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r2 = r9.getPackageName()     // Catch:{ all -> 0x01a7 }
            r1.append(r2)     // Catch:{ all -> 0x01a7 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a7 }
            r1.append(r2)     // Catch:{ all -> 0x01a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a7 }
            int r1 = r1.hashCode()     // Catch:{ all -> 0x01a7 }
            f922a = r1     // Catch:{ all -> 0x01a7 }
        L_0x0044:
            java.lang.String r1 = r10.mo14315l()     // Catch:{ all -> 0x01a7 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01a7 }
            r2 = 1
            if (r1 == 0) goto L_0x00d6
            java.lang.String r1 = r10.mo14320q()     // Catch:{ all -> 0x01a7 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x01a7 }
            if (r3 != 0) goto L_0x0076
            int r1 = r1.hashCode()     // Catch:{ all -> 0x01a7 }
            r10.mo14294a((int) r1)     // Catch:{ all -> 0x01a7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r3.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r4 = "notification msgTag = "
            r3.append(r4)     // Catch:{ all -> 0x01a7 }
            r3.append(r1)     // Catch:{ all -> 0x01a7 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.m1374d(r3, r1)     // Catch:{ all -> 0x01a7 }
        L_0x0076:
            int r1 = r10.mo14322s()     // Catch:{ all -> 0x01a7 }
            r3 = -1
            if (r1 == r3) goto L_0x00c1
            int r1 = r10.mo14322s()     // Catch:{ all -> 0x01a7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r3.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r4 = r10.mo14313k()     // Catch:{ all -> 0x01a7 }
            r3.append(r4)     // Catch:{ all -> 0x01a7 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01a7 }
            r3.append(r4)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01a7 }
            int r3 = r3.hashCode()     // Catch:{ all -> 0x01a7 }
            int r4 = r3 + 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r5.<init>()     // Catch:{ all -> 0x01a7 }
            int r6 = r10.mo14322s()     // Catch:{ all -> 0x01a7 }
            r5.append(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r10.mo14313k()     // Catch:{ all -> 0x01a7 }
            r5.append(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r9.getPackageName()     // Catch:{ all -> 0x01a7 }
            r5.append(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01a7 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x01a7 }
            goto L_0x011d
        L_0x00c1:
            int r1 = f922a     // Catch:{ all -> 0x01a7 }
            int r1 = r1 + r2
            f922a = r1     // Catch:{ all -> 0x01a7 }
            int r3 = f922a     // Catch:{ all -> 0x01a7 }
            int r3 = r3 + r2
            f922a = r3     // Catch:{ all -> 0x01a7 }
            int r4 = f922a     // Catch:{ all -> 0x01a7 }
            int r4 = r4 + r2
            f922a = r4     // Catch:{ all -> 0x01a7 }
            int r5 = f922a     // Catch:{ all -> 0x01a7 }
            int r5 = r5 + r2
            f922a = r5     // Catch:{ all -> 0x01a7 }
            goto L_0x011d
        L_0x00d6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r1.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r10.mo14315l()     // Catch:{ all -> 0x01a7 }
            r1.append(r3)     // Catch:{ all -> 0x01a7 }
            java.lang.String r3 = r10.mo14313k()     // Catch:{ all -> 0x01a7 }
            r1.append(r3)     // Catch:{ all -> 0x01a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01a7 }
            int r1 = r1.hashCode()     // Catch:{ all -> 0x01a7 }
            int r3 = f922a     // Catch:{ all -> 0x01a7 }
            int r3 = r3 + r2
            f922a = r3     // Catch:{ all -> 0x01a7 }
            int r4 = f922a     // Catch:{ all -> 0x01a7 }
            int r4 = r4 + r2
            f922a = r4     // Catch:{ all -> 0x01a7 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r5.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r10.mo14315l()     // Catch:{ all -> 0x01a7 }
            r5.append(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r10.mo14313k()     // Catch:{ all -> 0x01a7 }
            r5.append(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r9.getPackageName()     // Catch:{ all -> 0x01a7 }
            r5.append(r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01a7 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x01a7 }
        L_0x011d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01a7 }
            r6.<init>()     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = "notifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a7 }
            r6.append(r1)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = ",openNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a7 }
            r6.append(r3)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = ",delNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a7 }
            r6.append(r4)     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = ",alarmNotifyId:"
            r6.append(r7)     // Catch:{ all -> 0x01a7 }
            r6.append(r5)     // Catch:{ all -> 0x01a7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01a7 }
            java.lang.String r7 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.m1374d(r7, r6)     // Catch:{ all -> 0x01a7 }
            r6 = 4
            int[] r6 = new int[r6]     // Catch:{ all -> 0x01a7 }
            r7 = 0
            r6[r7] = r1     // Catch:{ all -> 0x01a7 }
            r6[r2] = r3     // Catch:{ all -> 0x01a7 }
            r2 = 2
            r6[r2] = r4     // Catch:{ all -> 0x01a7 }
            int r2 = r10.mo14303f()     // Catch:{ all -> 0x01a7 }
            if (r2 <= 0) goto L_0x015d
            goto L_0x015e
        L_0x015d:
            r5 = 0
        L_0x015e:
            r2 = 3
            r6[r2] = r5     // Catch:{ all -> 0x01a7 }
            r3 = 0
            boolean r4 = com.huawei.hms.push.C0887q.m1307a()     // Catch:{ all -> 0x01a7 }
            if (r4 == 0) goto L_0x016c
            android.app.Notification r3 = m1282a((android.content.Context) r9, (com.huawei.hms.push.C0881k) r10, (int[]) r6)     // Catch:{ all -> 0x01a7 }
        L_0x016c:
            java.lang.String r4 = "notification"
            java.lang.Object r4 = r9.getSystemService(r4)     // Catch:{ all -> 0x01a7 }
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4     // Catch:{ all -> 0x01a7 }
            if (r4 == 0) goto L_0x01a5
            if (r3 == 0) goto L_0x01a5
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01a7 }
            r7 = 26
            if (r5 < r7) goto L_0x0192
            java.lang.String r5 = "hms_push_channel"
            int r5 = com.huawei.hms.utils.ResourceLoaderUtil.getStringId(r5)     // Catch:{ all -> 0x01a7 }
            java.lang.String r5 = r9.getString(r5)     // Catch:{ all -> 0x01a7 }
            android.app.NotificationChannel r7 = new android.app.NotificationChannel     // Catch:{ all -> 0x01a7 }
            java.lang.String r8 = "HwPushChannelID"
            r7.<init>(r8, r5, r2)     // Catch:{ all -> 0x01a7 }
            r4.createNotificationChannel(r7)     // Catch:{ all -> 0x01a7 }
        L_0x0192:
            r4.notify(r1, r3)     // Catch:{ all -> 0x01a7 }
            m1296d(r9, r10, r6)     // Catch:{ all -> 0x01a7 }
            java.lang.String r1 = r10.mo14319p()     // Catch:{ all -> 0x01a7 }
            java.lang.String r10 = r10.mo14295b()     // Catch:{ all -> 0x01a7 }
            java.lang.String r2 = "100"
            com.huawei.hms.push.C0875e.m1221a(r9, r1, r10, r2)     // Catch:{ all -> 0x01a7 }
        L_0x01a5:
            monitor-exit(r0)
            return
        L_0x01a7:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        L_0x01aa:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.C0885o.m1287a(android.content.Context, com.huawei.hms.push.k):void");
    }

    /* renamed from: b */
    public static PendingIntent m1290b(Context context, C0881k kVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], m1283a(context, kVar, iArr, "2", 268435456), 134217728);
    }

    /* renamed from: c */
    public static PendingIntent m1294c(Context context, C0881k kVar, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[1], m1283a(context, kVar, iArr, "1", 268435456), 134217728);
    }

    /* renamed from: d */
    public static void m1296d(Context context, C0881k kVar, int[] iArr) {
        HMSLog.m1379i("PushSelfShowLog", "setAutoClear time is: " + kVar.mo14303f());
        if (kVar.mo14303f() > 0) {
            m1286a(context, m1283a(context, kVar, iArr, "-1", 32), (long) kVar.mo14303f(), iArr[3]);
        }
    }

    /* renamed from: b */
    public static void m1291b(Context context, Notification.Builder builder, C0881k kVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String k = kVar.mo14313k();
            if (!TextUtils.isEmpty(k)) {
                bundle.putString("hw_origin_sender_package_name", k);
                builder.setExtras(bundle);
            }
        }
    }

    /* renamed from: c */
    public static void m1295c(C0881k kVar, Notification.Builder builder) {
        builder.setTicker(kVar.mo14327x());
    }

    /* renamed from: b */
    public static void m1293b(C0881k kVar, Notification.Builder builder) {
        String t = kVar.mo14323t();
        if (!TextUtils.isEmpty(t)) {
            builder.setSubText(t);
        }
    }

    /* renamed from: b */
    public static void m1292b(Context context, C0881k kVar, Notification.Builder builder) {
        String str;
        if (TextUtils.isEmpty(kVar.mo14324u())) {
            str = context.getResources().getString(context.getApplicationInfo().labelRes);
        } else {
            str = kVar.mo14324u();
        }
        String j = kVar.mo14311j();
        builder.setContentTitle(str);
        builder.setContentText(j);
    }

    /* renamed from: a */
    public static Intent m1283a(Context context, C0881k kVar, int[] iArr, String str, int i) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", kVar.mo14318o()).putExtra("selfshow_token", kVar.mo14328y()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i);
        return intent;
    }

    /* renamed from: a */
    public static Notification m1282a(Context context, C0881k kVar, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (C0883m.m1280a(kVar) == C0884n.STYLE_BIGTEXT) {
            C0883m.m1281a(builder, kVar.mo14305g(), kVar);
        }
        C0882l.m1278a(context, builder, kVar);
        m1293b(kVar, builder);
        m1292b(context, kVar, builder);
        m1288a(context, kVar, builder);
        m1284a(builder);
        m1289a(kVar, builder);
        m1295c(kVar, builder);
        builder.setContentIntent(m1294c(context, kVar, iArr));
        builder.setDeleteIntent(m1290b(context, kVar, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        m1291b(context, builder, kVar);
        m1285a(context, builder, kVar);
        return builder.build();
    }

    /* renamed from: a */
    public static void m1285a(Context context, Notification.Builder builder, C0881k kVar) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11 && C0887q.m1308a(context)) {
            Bundle bundle = new Bundle();
            String k = kVar.mo14313k();
            HMSLog.m1379i("PushSelfShowLog", "the package name of notification is:" + k);
            if (!TextUtils.isEmpty(k)) {
                String a = C0887q.m1303a(context, k);
                HMSLog.m1379i("PushSelfShowLog", "the app name is:" + a);
                if (a != null) {
                    bundle.putCharSequence("android.extraAppName", a);
                }
            }
            builder.setExtras(bundle);
        }
    }

    /* renamed from: a */
    public static void m1286a(Context context, Intent intent, long j, int i) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("enter setDelayAlarm(intent:");
            sb.append(intent.toURI());
            sb.append(" interval:");
            sb.append(j);
            sb.append("ms, context:");
            sb.append(context);
            HMSLog.m1374d("PushSelfShowLog", sb.toString());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, i, intent, 134217728));
            }
        } catch (Exception e) {
            HMSLog.m1380w("PushSelfShowLog", "set DelayAlarm error." + e.toString());
        }
    }

    /* renamed from: a */
    public static void m1288a(Context context, C0881k kVar, Notification.Builder builder) {
        Bitmap a = C0882l.m1277a(context, kVar);
        if (a != null) {
            builder.setLargeIcon(a);
        }
    }

    /* renamed from: a */
    public static void m1284a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    /* renamed from: a */
    public static void m1289a(C0881k kVar, Notification.Builder builder) {
        boolean z = true;
        if (kVar.mo14301e() != 1) {
            z = false;
        }
        builder.setAutoCancel(z);
        builder.setOngoing(false);
    }
}
