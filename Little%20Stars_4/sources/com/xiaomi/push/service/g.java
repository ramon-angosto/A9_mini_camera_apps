package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.mipush.sdk.Constants;

public class g {
    private static f a;
    private static a b;

    public interface a {
        void a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ae, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.f a(android.content.Context r13) {
        /*
            java.lang.Class<com.xiaomi.push.service.g> r0 = com.xiaomi.push.service.g.class
            monitor-enter(r0)
            com.xiaomi.push.service.f r1 = a     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x000b
            com.xiaomi.push.service.f r13 = a     // Catch:{ all -> 0x00af }
            monitor-exit(r0)
            return r13
        L_0x000b:
            java.lang.String r1 = "mipush_account"
            r2 = 0
            android.content.SharedPreferences r1 = r13.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "uuid"
            r3 = 0
            java.lang.String r5 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "token"
            java.lang.String r6 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "security"
            java.lang.String r7 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "app_id"
            java.lang.String r8 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "app_token"
            java.lang.String r9 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "package_name"
            java.lang.String r10 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "device_id"
            java.lang.String r2 = r1.getString(r2, r3)     // Catch:{ all -> 0x00af }
            java.lang.String r4 = "env_type"
            r11 = 1
            int r11 = r1.getInt(r4, r11)     // Catch:{ all -> 0x00af }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x0063
            java.lang.String r4 = "a-"
            boolean r4 = r2.startsWith(r4)     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x0063
            java.lang.String r2 = com.xiaomi.channel.commonutils.android.e.e(r13)     // Catch:{ all -> 0x00af }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x00af }
            java.lang.String r4 = "device_id"
            android.content.SharedPreferences$Editor r1 = r1.putString(r4, r2)     // Catch:{ all -> 0x00af }
            r1.commit()     // Catch:{ all -> 0x00af }
        L_0x0063:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x00ad
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x00ad
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x00ad
            java.lang.String r1 = com.xiaomi.channel.commonutils.android.e.e(r13)     // Catch:{ all -> 0x00af }
            java.lang.String r4 = "com.xiaomi.xmsf"
            java.lang.String r12 = r13.getPackageName()     // Catch:{ all -> 0x00af }
            boolean r4 = r4.equals(r12)     // Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x00a1
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x00a1
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x00a1
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x00a1
            java.lang.String r1 = "erase the old account."
            com.xiaomi.channel.commonutils.logger.b.d(r1)     // Catch:{ all -> 0x00af }
            b(r13)     // Catch:{ all -> 0x00af }
            monitor-exit(r0)
            return r3
        L_0x00a1:
            com.xiaomi.push.service.f r13 = new com.xiaomi.push.service.f     // Catch:{ all -> 0x00af }
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00af }
            a = r13     // Catch:{ all -> 0x00af }
            com.xiaomi.push.service.f r13 = a     // Catch:{ all -> 0x00af }
            monitor-exit(r0)
            return r13
        L_0x00ad:
            monitor-exit(r0)
            return r3
        L_0x00af:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.g.a(android.content.Context):com.xiaomi.push.service.f");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.f a(android.content.Context r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.Class<com.xiaomi.push.service.g> r0 = com.xiaomi.push.service.g.class
            monitor-enter(r0)
            java.util.TreeMap r1 = new java.util.TreeMap     // Catch:{ all -> 0x013c }
            r1.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r2 = "devid"
            java.lang.String r3 = com.xiaomi.channel.commonutils.android.e.a(r9)     // Catch:{ all -> 0x013c }
            r1.put(r2, r3)     // Catch:{ all -> 0x013c }
            boolean r2 = c(r9)     // Catch:{ all -> 0x013c }
            if (r2 == 0) goto L_0x0019
            java.lang.String r11 = "1000271"
        L_0x0019:
            r5 = r11
            boolean r11 = c(r9)     // Catch:{ all -> 0x013c }
            if (r11 == 0) goto L_0x0022
            java.lang.String r12 = "420100086271"
        L_0x0022:
            r6 = r12
            boolean r11 = c(r9)     // Catch:{ all -> 0x013c }
            if (r11 == 0) goto L_0x002b
            java.lang.String r10 = "com.xiaomi.xmsf"
        L_0x002b:
            r7 = r10
            java.lang.String r10 = "appid"
            r1.put(r10, r5)     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "apptoken"
            r1.put(r10, r6)     // Catch:{ all -> 0x013c }
            r10 = 0
            android.content.pm.PackageManager r11 = r9.getPackageManager()     // Catch:{ Exception -> 0x0042 }
            r12 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r11 = r11.getPackageInfo(r7, r12)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0047
        L_0x0042:
            r11 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r11)     // Catch:{ all -> 0x013c }
            r11 = r10
        L_0x0047:
            java.lang.String r12 = "appversion"
            if (r11 == 0) goto L_0x0052
            int r11 = r11.versionCode     // Catch:{ all -> 0x013c }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x013c }
            goto L_0x0054
        L_0x0052:
            java.lang.String r11 = "0"
        L_0x0054:
            r1.put(r12, r11)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "sdkversion"
            r12 = 21
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ all -> 0x013c }
            r1.put(r11, r12)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "packagename"
            r1.put(r11, r7)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "model"
            java.lang.String r12 = android.os.Build.MODEL     // Catch:{ all -> 0x013c }
            r1.put(r11, r12)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "imei_md5"
            java.lang.String r12 = com.xiaomi.channel.commonutils.android.e.c(r9)     // Catch:{ all -> 0x013c }
            java.lang.String r12 = com.xiaomi.channel.commonutils.string.d.a((java.lang.String) r12)     // Catch:{ all -> 0x013c }
            r1.put(r11, r12)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "os"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r12.<init>()     // Catch:{ all -> 0x013c }
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x013c }
            r12.append(r2)     // Catch:{ all -> 0x013c }
            java.lang.String r2 = "-"
            r12.append(r2)     // Catch:{ all -> 0x013c }
            java.lang.String r2 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x013c }
            r12.append(r2)     // Catch:{ all -> 0x013c }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x013c }
            r1.put(r11, r12)     // Catch:{ all -> 0x013c }
            int r11 = com.xiaomi.channel.commonutils.android.e.b()     // Catch:{ all -> 0x013c }
            if (r11 < 0) goto L_0x00a7
            java.lang.String r12 = "space_id"
            java.lang.String r11 = java.lang.Integer.toString(r11)     // Catch:{ all -> 0x013c }
            r1.put(r12, r11)     // Catch:{ all -> 0x013c }
        L_0x00a7:
            java.lang.String r11 = com.xiaomi.channel.commonutils.android.e.g(r9)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = com.xiaomi.channel.commonutils.string.d.a((java.lang.String) r11)     // Catch:{ all -> 0x013c }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x013c }
            if (r12 != 0) goto L_0x00ba
            java.lang.String r12 = "mac_address"
            r1.put(r12, r11)     // Catch:{ all -> 0x013c }
        L_0x00ba:
            java.lang.String r11 = "android_id"
            java.lang.String r12 = com.xiaomi.channel.commonutils.android.e.b(r9)     // Catch:{ all -> 0x013c }
            r1.put(r11, r12)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = a()     // Catch:{ all -> 0x013c }
            com.xiaomi.channel.commonutils.network.b r11 = com.xiaomi.channel.commonutils.network.d.a(r9, r11, r1)     // Catch:{ all -> 0x013c }
            java.lang.String r12 = ""
            if (r11 == 0) goto L_0x00d3
            java.lang.String r12 = r11.a()     // Catch:{ all -> 0x013c }
        L_0x00d3:
            boolean r11 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x013c }
            if (r11 != 0) goto L_0x013a
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x013c }
            r11.<init>(r12)     // Catch:{ all -> 0x013c }
            java.lang.String r1 = "code"
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x013c }
            if (r1 != 0) goto L_0x0128
            java.lang.String r10 = "data"
            org.json.JSONObject r10 = r11.getJSONObject(r10)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "ssecurity"
            java.lang.String r4 = r10.getString(r11)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "token"
            java.lang.String r3 = r10.getString(r11)     // Catch:{ all -> 0x013c }
            java.lang.String r11 = "userId"
            java.lang.String r10 = r10.getString(r11)     // Catch:{ all -> 0x013c }
            com.xiaomi.push.service.f r11 = new com.xiaomi.push.service.f     // Catch:{ all -> 0x013c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r12.<init>()     // Catch:{ all -> 0x013c }
            r12.append(r10)     // Catch:{ all -> 0x013c }
            java.lang.String r10 = "@xiaomi.com/an"
            r12.append(r10)     // Catch:{ all -> 0x013c }
            r10 = 6
            java.lang.String r10 = com.xiaomi.channel.commonutils.string.d.a((int) r10)     // Catch:{ all -> 0x013c }
            r12.append(r10)     // Catch:{ all -> 0x013c }
            java.lang.String r2 = r12.toString()     // Catch:{ all -> 0x013c }
            int r8 = com.xiaomi.channel.commonutils.misc.a.c()     // Catch:{ all -> 0x013c }
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x013c }
            a(r9, r11)     // Catch:{ all -> 0x013c }
            a = r11     // Catch:{ all -> 0x013c }
            monitor-exit(r0)
            return r11
        L_0x0128:
            java.lang.String r1 = "code"
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x013c }
            java.lang.String r2 = "description"
            java.lang.String r11 = r11.optString(r2)     // Catch:{ all -> 0x013c }
            com.xiaomi.push.service.j.a(r9, r1, r11)     // Catch:{ all -> 0x013c }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r12)     // Catch:{ all -> 0x013c }
        L_0x013a:
            monitor-exit(r0)
            return r10
        L_0x013c:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.g.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.f");
    }

    public static String a() {
        if (com.xiaomi.channel.commonutils.misc.a.b()) {
            return "http://10.237.14.141:9085/pass/register";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(com.xiaomi.channel.commonutils.misc.a.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com");
        sb.append("/pass/register");
        return sb.toString();
    }

    public static void a(Context context, f fVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", fVar.a);
        edit.putString("security", fVar.c);
        edit.putString(Constants.EXTRA_KEY_TOKEN, fVar.b);
        edit.putString("app_id", fVar.d);
        edit.putString("package_name", fVar.f);
        edit.putString("app_token", fVar.e);
        edit.putString("device_id", e.e(context));
        edit.putInt("env_type", fVar.g);
        edit.commit();
        b();
    }

    public static void b() {
        a aVar = b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static void b(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        b();
    }

    private static boolean c(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
