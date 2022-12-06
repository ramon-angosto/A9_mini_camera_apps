package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

public class d {

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static class b {
        public String a;
        public boolean b;
        public boolean c;
        public String d;

        public b(String str, boolean z, boolean z2, String str2) {
            this.a = str;
            this.b = z;
            this.c = z2;
            this.d = str2;
        }
    }

    private static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void a(Context context) {
        new Thread(new e(context)).start();
    }

    private static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[]{activityInfo.name, boolArr[0]}));
        } else if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[]{activityInfo.name, boolArr[1]}));
        }
    }

    private static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            for (String equals : strArr) {
                if (TextUtils.equals(equals, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cd A[EDGE_INSN: B:38:0x00cd->B:31:0x00cd ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r9) {
        /*
            java.lang.String r0 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.String r1 = "com.xiaomi.push.service.receivers.PingReceiver"
            android.content.pm.PackageManager r2 = r9.getPackageManager()
            java.lang.String r3 = r9.getPackageName()
            android.content.Intent r4 = new android.content.Intent
            java.lang.String r5 = com.xiaomi.push.service.aa.o
            r4.<init>(r5)
            r4.setPackage(r3)
            r5 = 2
            r6 = 0
            r7 = 1
            java.lang.Class r8 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x005d }
            android.content.pm.ActivityInfo r4 = a(r2, r4, r8)     // Catch:{ ClassNotFoundException -> 0x005d }
            boolean r9 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r9)     // Catch:{ ClassNotFoundException -> 0x005d }
            if (r9 != 0) goto L_0x0049
            if (r4 == 0) goto L_0x003b
            java.lang.Boolean[] r9 = new java.lang.Boolean[r5]     // Catch:{ ClassNotFoundException -> 0x005d }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)     // Catch:{ ClassNotFoundException -> 0x005d }
            r9[r6] = r1     // Catch:{ ClassNotFoundException -> 0x005d }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch:{ ClassNotFoundException -> 0x005d }
            r9[r7] = r1     // Catch:{ ClassNotFoundException -> 0x005d }
            a((android.content.pm.ActivityInfo) r4, (java.lang.Boolean[]) r9)     // Catch:{ ClassNotFoundException -> 0x005d }
            goto L_0x0061
        L_0x003b:
            com.xiaomi.mipush.sdk.d$a r9 = new com.xiaomi.mipush.sdk.d$a     // Catch:{ ClassNotFoundException -> 0x005d }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ ClassNotFoundException -> 0x005d }
            r4[r6] = r1     // Catch:{ ClassNotFoundException -> 0x005d }
            java.lang.String r1 = java.lang.String.format(r0, r4)     // Catch:{ ClassNotFoundException -> 0x005d }
            r9.<init>(r1)     // Catch:{ ClassNotFoundException -> 0x005d }
            throw r9     // Catch:{ ClassNotFoundException -> 0x005d }
        L_0x0049:
            if (r4 == 0) goto L_0x0061
            java.lang.Boolean[] r9 = new java.lang.Boolean[r5]     // Catch:{ ClassNotFoundException -> 0x005d }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)     // Catch:{ ClassNotFoundException -> 0x005d }
            r9[r6] = r1     // Catch:{ ClassNotFoundException -> 0x005d }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)     // Catch:{ ClassNotFoundException -> 0x005d }
            r9[r7] = r1     // Catch:{ ClassNotFoundException -> 0x005d }
            a((android.content.pm.ActivityInfo) r4, (java.lang.Boolean[]) r9)     // Catch:{ ClassNotFoundException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r9 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r9)
        L_0x0061:
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
            r9.<init>(r1)
            r9.setPackage(r3)
            java.lang.Class<com.xiaomi.push.service.receivers.NetworkStatusReceiver> r1 = com.xiaomi.push.service.receivers.NetworkStatusReceiver.class
            android.content.pm.ActivityInfo r9 = a(r2, r9, r1)
            if (r9 == 0) goto L_0x00d8
            java.lang.Boolean[] r0 = new java.lang.Boolean[r5]
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            r0[r6] = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            r0[r7] = r1
            a((android.content.pm.ActivityInfo) r9, (java.lang.Boolean[]) r0)
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r9.<init>(r0)
            r9.setPackage(r3)
            r0 = 16384(0x4000, float:2.2959E-41)
            java.util.List r9 = r2.queryBroadcastReceivers(r9, r0)
            java.util.Iterator r9 = r9.iterator()
            r0 = 0
        L_0x0099:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x00cd
            java.lang.Object r1 = r9.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            if (r1 == 0) goto L_0x00ca
            java.lang.String r2 = r1.name     // Catch:{ ClassNotFoundException -> 0x00c5 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ ClassNotFoundException -> 0x00c5 }
            if (r2 != 0) goto L_0x00ca
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r2 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            java.lang.String r3 = r1.name     // Catch:{ ClassNotFoundException -> 0x00c5 }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x00c5 }
            boolean r2 = r2.isAssignableFrom(r3)     // Catch:{ ClassNotFoundException -> 0x00c5 }
            if (r2 == 0) goto L_0x00ca
            boolean r0 = r1.enabled     // Catch:{ ClassNotFoundException -> 0x00c5 }
            if (r0 == 0) goto L_0x00ca
            r0 = 1
            goto L_0x00cb
        L_0x00c5:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r1)
            goto L_0x0099
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            if (r0 == 0) goto L_0x0099
        L_0x00cd:
            if (r0 == 0) goto L_0x00d0
            return
        L_0x00d0:
            com.xiaomi.mipush.sdk.d$a r9 = new com.xiaomi.mipush.sdk.d$a
            java.lang.String r0 = "Receiver: none of the subclasses of PushMessageReceiver is enabled or defined."
            r9.<init>(r0)
            throw r9
        L_0x00d8:
            com.xiaomi.mipush.sdk.d$a r9 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Class<com.xiaomi.push.service.receivers.NetworkStatusReceiver> r2 = com.xiaomi.push.service.receivers.NetworkStatusReceiver.class
            java.lang.String r2 = r2.getCanonicalName()
            r1[r6] = r2
            java.lang.String r0 = java.lang.String.format(r0, r1)
            r9.<init>(r0)
            goto L_0x00ed
        L_0x00ec:
            throw r9
        L_0x00ed:
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.d.c(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public static void c(Context context, PackageInfo packageInfo) {
        boolean z;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList(new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.GET_TASKS", "android.permission.VIBRATE"}));
        if (packageInfo.permissions != null) {
            PermissionInfo[] permissionInfoArr = packageInfo.permissions;
            int length = permissionInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (str.equals(permissionInfoArr[i].name)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        z = false;
        if (z) {
            if (packageInfo.requestedPermissions != null) {
                for (String str2 : packageInfo.requestedPermissions) {
                    if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                        hashSet.remove(str2);
                        if (hashSet.isEmpty()) {
                            break;
                        }
                    }
                }
            }
            if (!hashSet.isEmpty()) {
                throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", new Object[]{hashSet.iterator().next()}));
            }
            return;
        }
        throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", new Object[]{str}));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x004b, code lost:
        if (a(r14, new java.lang.String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"}) != false) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(android.content.Context r13, android.content.pm.PackageInfo r14) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageHandler> r2 = com.xiaomi.mipush.sdk.PushMessageHandler.class
            java.lang.String r2 = r2.getCanonicalName()
            com.xiaomi.mipush.sdk.d$b r3 = new com.xiaomi.mipush.sdk.d$b
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageHandler> r4 = com.xiaomi.mipush.sdk.PushMessageHandler.class
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r5 = ""
            r6 = 1
            r3.<init>(r4, r6, r6, r5)
            r1.put(r2, r3)
            java.lang.Class<com.xiaomi.mipush.sdk.MessageHandleService> r2 = com.xiaomi.mipush.sdk.MessageHandleService.class
            java.lang.String r2 = r2.getCanonicalName()
            com.xiaomi.mipush.sdk.d$b r3 = new com.xiaomi.mipush.sdk.d$b
            java.lang.Class<com.xiaomi.mipush.sdk.MessageHandleService> r4 = com.xiaomi.mipush.sdk.MessageHandleService.class
            java.lang.String r4 = r4.getCanonicalName()
            r7 = 0
            r3.<init>(r4, r6, r7, r5)
            r1.put(r2, r3)
            boolean r13 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r13)
            r2 = 2
            java.lang.String r3 = "com.xiaomi.push.service.XMPushService"
            java.lang.String r4 = "com.xiaomi.push.service.XMJobService"
            if (r13 == 0) goto L_0x004d
            java.lang.String[] r13 = new java.lang.String[r2]
            r13[r7] = r4
            r13[r6] = r3
            boolean r13 = a((android.content.pm.PackageInfo) r14, (java.lang.String[]) r13)
            if (r13 == 0) goto L_0x005f
        L_0x004d:
            com.xiaomi.mipush.sdk.d$b r13 = new com.xiaomi.mipush.sdk.d$b
            java.lang.String r8 = "android.permission.BIND_JOB_SERVICE"
            r13.<init>(r4, r6, r7, r8)
            r1.put(r4, r13)
            com.xiaomi.mipush.sdk.d$b r13 = new com.xiaomi.mipush.sdk.d$b
            r13.<init>(r3, r6, r7, r5)
            r1.put(r3, r13)
        L_0x005f:
            android.content.pm.ServiceInfo[] r13 = r14.services
            if (r13 == 0) goto L_0x00f6
            android.content.pm.ServiceInfo[] r13 = r14.services
            int r14 = r13.length
            r5 = 0
        L_0x0067:
            if (r5 >= r14) goto L_0x00f6
            r8 = r13[r5]
            java.lang.String r9 = r8.name
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00f2
            java.lang.String r9 = r8.name
            boolean r9 = r1.containsKey(r9)
            if (r9 == 0) goto L_0x00f2
            java.lang.String r9 = r8.name
            java.lang.Object r9 = r1.remove(r9)
            com.xiaomi.mipush.sdk.d$b r9 = (com.xiaomi.mipush.sdk.d.b) r9
            boolean r10 = r9.b
            boolean r11 = r9.c
            java.lang.String r9 = r9.d
            boolean r12 = r8.enabled
            if (r10 != r12) goto L_0x00da
            boolean r10 = r8.exported
            if (r11 != r10) goto L_0x00c2
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 != 0) goto L_0x00b4
            java.lang.String r10 = r8.permission
            boolean r10 = android.text.TextUtils.equals(r9, r10)
            if (r10 == 0) goto L_0x00a0
            goto L_0x00b4
        L_0x00a0:
            com.xiaomi.mipush.sdk.d$a r13 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.String r0 = r8.name
            r14[r7] = r0
            r14[r6] = r9
            java.lang.String r0 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\"."
            java.lang.String r14 = java.lang.String.format(r0, r14)
            r13.<init>(r14)
            throw r13
        L_0x00b4:
            java.lang.String r9 = r8.name
            java.lang.String r8 = r8.processName
            r0.put(r9, r8)
            boolean r8 = r1.isEmpty()
            if (r8 == 0) goto L_0x00f2
            goto L_0x00f6
        L_0x00c2:
            com.xiaomi.mipush.sdk.d$a r13 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.String r0 = r8.name
            r14[r7] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            r14[r6] = r0
            java.lang.String r0 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b."
            java.lang.String r14 = java.lang.String.format(r0, r14)
            r13.<init>(r14)
            throw r13
        L_0x00da:
            com.xiaomi.mipush.sdk.d$a r13 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.String r0 = r8.name
            r14[r7] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            r14[r6] = r0
            java.lang.String r0 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b."
            java.lang.String r14 = java.lang.String.format(r0, r14)
            r13.<init>(r14)
            throw r13
        L_0x00f2:
            int r5 = r5 + 1
            goto L_0x0067
        L_0x00f6:
            boolean r13 = r1.isEmpty()
            if (r13 == 0) goto L_0x0168
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageHandler> r13 = com.xiaomi.mipush.sdk.PushMessageHandler.class
            java.lang.String r13 = r13.getCanonicalName()
            java.lang.Object r13 = r0.get(r13)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            java.lang.Class<com.xiaomi.mipush.sdk.MessageHandleService> r14 = com.xiaomi.mipush.sdk.MessageHandleService.class
            java.lang.String r14 = r14.getCanonicalName()
            java.lang.Object r14 = r0.get(r14)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r13 = android.text.TextUtils.equals(r13, r14)
            java.lang.String r14 = "\"%1$s\" and \"%2$s\" must be running in the same process."
            if (r13 == 0) goto L_0x014c
            boolean r13 = r0.containsKey(r4)
            if (r13 == 0) goto L_0x014b
            boolean r13 = r0.containsKey(r3)
            if (r13 == 0) goto L_0x014b
            java.lang.Object r13 = r0.get(r4)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            java.lang.Object r0 = r0.get(r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r13 = android.text.TextUtils.equals(r13, r0)
            if (r13 == 0) goto L_0x013b
            goto L_0x014b
        L_0x013b:
            com.xiaomi.mipush.sdk.d$a r13 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r0 = new java.lang.Object[r2]
            r0[r7] = r4
            r0[r6] = r3
            java.lang.String r14 = java.lang.String.format(r14, r0)
            r13.<init>(r14)
            throw r13
        L_0x014b:
            return
        L_0x014c:
            com.xiaomi.mipush.sdk.d$a r13 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageHandler> r1 = com.xiaomi.mipush.sdk.PushMessageHandler.class
            java.lang.String r1 = r1.getCanonicalName()
            r0[r7] = r1
            java.lang.Class<com.xiaomi.mipush.sdk.MessageHandleService> r1 = com.xiaomi.mipush.sdk.MessageHandleService.class
            java.lang.String r1 = r1.getCanonicalName()
            r0[r6] = r1
            java.lang.String r14 = java.lang.String.format(r14, r0)
            r13.<init>(r14)
            throw r13
        L_0x0168:
            com.xiaomi.mipush.sdk.d$a r13 = new com.xiaomi.mipush.sdk.d$a
            java.lang.Object[] r14 = new java.lang.Object[r6]
            java.util.Set r0 = r1.keySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            r14[r7] = r0
            java.lang.String r0 = "<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.String r14 = java.lang.String.format(r0, r14)
            r13.<init>(r14)
            goto L_0x0185
        L_0x0184:
            throw r13
        L_0x0185:
            goto L_0x0184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.d.d(android.content.Context, android.content.pm.PackageInfo):void");
    }
}
