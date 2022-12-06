package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1611ad;
import com.xiaomi.push.C1614ag;
import com.xiaomi.push.C1811fv;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.C1941p;
import com.xiaomi.push.C2086t;

/* renamed from: com.xiaomi.push.service.o */
public class C2072o {

    /* renamed from: a */
    private static C2071n f3932a;

    /* renamed from: a */
    private static C2073a f3933a;

    /* renamed from: com.xiaomi.push.service.o$a */
    public interface C2073a {
        /* renamed from: a */
        void mo18519a();
    }

    /* renamed from: a */
    private static int m5301a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a7, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.C2071n m5302a(android.content.Context r12) {
        /*
            java.lang.Class<com.xiaomi.push.service.o> r0 = com.xiaomi.push.service.C2072o.class
            monitor-enter(r0)
            com.xiaomi.push.service.n r1 = f3932a     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x000b
            com.xiaomi.push.service.n r12 = f3932a     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)
            return r12
        L_0x000b:
            java.lang.String r1 = "mipush_account"
            r2 = 0
            android.content.SharedPreferences r1 = r12.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "uuid"
            r3 = 0
            java.lang.String r5 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "token"
            java.lang.String r6 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "security"
            java.lang.String r7 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "app_id"
            java.lang.String r8 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "app_token"
            java.lang.String r9 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "package_name"
            java.lang.String r10 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "device_id"
            java.lang.String r2 = r1.getString(r2, r3)     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = "env_type"
            r11 = 1
            int r11 = r1.getInt(r4, r11)     // Catch:{ all -> 0x00a8 }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a8 }
            if (r4 != 0) goto L_0x0061
            boolean r4 = com.xiaomi.push.C1907j.m4549a((java.lang.String) r2)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x0061
            java.lang.String r2 = com.xiaomi.push.C1907j.m4580k(r12)     // Catch:{ all -> 0x00a8 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = "device_id"
            android.content.SharedPreferences$Editor r1 = r1.putString(r4, r2)     // Catch:{ all -> 0x00a8 }
            r1.commit()     // Catch:{ all -> 0x00a8 }
        L_0x0061:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00a6
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00a6
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00a6
            java.lang.String r1 = com.xiaomi.push.C1907j.m4580k(r12)     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = "com.xiaomi.xmsf"
            java.lang.String r12 = r12.getPackageName()     // Catch:{ all -> 0x00a8 }
            boolean r12 = r3.equals(r12)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009a
            boolean r12 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009a
            boolean r12 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009a
            boolean r12 = r2.equals(r1)     // Catch:{ all -> 0x00a8 }
            if (r12 != 0) goto L_0x009a
            java.lang.String r12 = "read_phone_state permission changes."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r12)     // Catch:{ all -> 0x00a8 }
        L_0x009a:
            com.xiaomi.push.service.n r12 = new com.xiaomi.push.service.n     // Catch:{ all -> 0x00a8 }
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a8 }
            f3932a = r12     // Catch:{ all -> 0x00a8 }
            com.xiaomi.push.service.n r12 = f3932a     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)
            return r12
        L_0x00a6:
            monitor-exit(r0)
            return r3
        L_0x00a8:
            r12 = move-exception
            monitor-exit(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2072o.m5302a(android.content.Context):com.xiaomi.push.service.n");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014d A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0193 A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fa A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x024d A[SYNTHETIC, Splitter:B:85:0x024d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.C2071n m5303a(android.content.Context r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r1 = r16
            java.lang.Class<com.xiaomi.push.service.o> r2 = com.xiaomi.push.service.C2072o.class
            monitor-enter(r2)
            java.util.TreeMap r3 = new java.util.TreeMap     // Catch:{ all -> 0x0345 }
            r3.<init>()     // Catch:{ all -> 0x0345 }
            r4 = 0
            java.lang.String r0 = com.xiaomi.push.C1907j.m4554a((android.content.Context) r1, (boolean) r4)     // Catch:{ all -> 0x0345 }
            java.lang.String r5 = "devid"
            r3.put(r5, r0)     // Catch:{ all -> 0x0345 }
            com.xiaomi.push.service.n r0 = f3932a     // Catch:{ all -> 0x0345 }
            r5 = 1
            if (r0 == 0) goto L_0x0044
            com.xiaomi.push.service.n r0 = f3932a     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r0.f3926a     // Catch:{ all -> 0x0345 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = "uuid"
            com.xiaomi.push.service.n r7 = f3932a     // Catch:{ all -> 0x0345 }
            java.lang.String r7 = r7.f3926a     // Catch:{ all -> 0x0345 }
            r3.put(r0, r7)     // Catch:{ all -> 0x0345 }
            com.xiaomi.push.service.n r0 = f3932a     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r0.f3926a     // Catch:{ all -> 0x0345 }
            java.lang.String r7 = "/"
            int r0 = r0.lastIndexOf(r7)     // Catch:{ all -> 0x0345 }
            r7 = -1
            if (r0 == r7) goto L_0x0044
            com.xiaomi.push.service.n r7 = f3932a     // Catch:{ all -> 0x0345 }
            java.lang.String r7 = r7.f3926a     // Catch:{ all -> 0x0345 }
            int r0 = r0 + r5
            java.lang.String r0 = r7.substring(r0)     // Catch:{ all -> 0x0345 }
            r7 = r0
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            com.xiaomi.push.az r0 = com.xiaomi.push.C1640az.m2599a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            r0.mo17240a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = com.xiaomi.push.C1907j.m4562b((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r8 != 0) goto L_0x005b
            java.lang.String r8 = "vdevid"
            r3.put(r8, r0)     // Catch:{ all -> 0x0345 }
        L_0x005b:
            java.lang.String r0 = com.xiaomi.push.C1907j.m4553a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r8 != 0) goto L_0x006a
            java.lang.String r8 = "gaid"
            r3.put(r8, r0)     // Catch:{ all -> 0x0345 }
        L_0x006a:
            boolean r0 = m5301a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            if (r0 == 0) goto L_0x0074
            java.lang.String r0 = "1000271"
            r12 = r0
            goto L_0x0076
        L_0x0074:
            r12 = r18
        L_0x0076:
            boolean r0 = m5301a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            if (r0 == 0) goto L_0x0080
            java.lang.String r0 = "420100086271"
            r13 = r0
            goto L_0x0082
        L_0x0080:
            r13 = r19
        L_0x0082:
            boolean r0 = m5301a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            if (r0 == 0) goto L_0x008c
            java.lang.String r0 = "com.xiaomi.xmsf"
            r14 = r0
            goto L_0x008e
        L_0x008c:
            r14 = r17
        L_0x008e:
            java.lang.String r0 = "appid"
            r3.put(r0, r12)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "apptoken"
            r3.put(r0, r13)     // Catch:{ all -> 0x0345 }
            android.content.pm.PackageManager r0 = r16.getPackageManager()     // Catch:{ Exception -> 0x00a3 }
            r8 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r14, r8)     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a8
        L_0x00a3:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0345 }
            r0 = 0
        L_0x00a8:
            java.lang.String r8 = "appversion"
            if (r0 == 0) goto L_0x00b3
            int r0 = r0.versionCode     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0345 }
            goto L_0x00b5
        L_0x00b3:
            java.lang.String r0 = "0"
        L_0x00b5:
            r3.put(r8, r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "sdkversion"
            r8 = 30809(0x7859, float:4.3173E-41)
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "packagename"
            r3.put(r0, r14)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "model"
            java.lang.String r8 = android.os.Build.MODEL     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "board"
            java.lang.String r8 = android.os.Build.BOARD     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            boolean r0 = com.xiaomi.push.C1938m.m4731d()     // Catch:{ all -> 0x0345 }
            if (r0 != 0) goto L_0x012a
            java.lang.String r0 = ""
            java.lang.String r8 = com.xiaomi.push.C1907j.m4575f(r16)     // Catch:{ all -> 0x0345 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0345 }
            if (r9 != 0) goto L_0x00fb
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r9.<init>()     // Catch:{ all -> 0x0345 }
            r9.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = com.xiaomi.push.C1663bo.m2727a((java.lang.String) r8)     // Catch:{ all -> 0x0345 }
            r9.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0345 }
        L_0x00fb:
            java.lang.String r8 = com.xiaomi.push.C1907j.m4577h(r16)     // Catch:{ all -> 0x0345 }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r9 != 0) goto L_0x011f
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0345 }
            if (r9 != 0) goto L_0x011f
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r9.<init>()     // Catch:{ all -> 0x0345 }
            r9.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = ","
            r9.append(r0)     // Catch:{ all -> 0x0345 }
            r9.append(r8)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0345 }
        L_0x011f:
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r8 != 0) goto L_0x012a
            java.lang.String r8 = "imei_md5"
            r3.put(r8, r0)     // Catch:{ all -> 0x0345 }
        L_0x012a:
            java.lang.String r0 = "os"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r8.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0345 }
            r8.append(r9)     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = "-"
            r8.append(r9)     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0345 }
            r8.append(r9)     // Catch:{ all -> 0x0345 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            int r0 = com.xiaomi.push.C1907j.m4548a()     // Catch:{ all -> 0x0345 }
            if (r0 < 0) goto L_0x0156
            java.lang.String r8 = "space_id"
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x0345 }
            r3.put(r8, r0)     // Catch:{ all -> 0x0345 }
        L_0x0156:
            java.lang.String r0 = "brand"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r8.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = android.os.Build.BRAND     // Catch:{ all -> 0x0345 }
            r8.append(r9)     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = ""
            r8.append(r9)     // Catch:{ all -> 0x0345 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "ram"
            java.lang.String r8 = com.xiaomi.push.C1907j.m4548a()     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = "rom"
            java.lang.String r8 = com.xiaomi.push.C1907j.m4560b()     // Catch:{ all -> 0x0345 }
            r3.put(r0, r8)     // Catch:{ all -> 0x0345 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0345 }
            r8.<init>()     // Catch:{ all -> 0x0345 }
            java.util.Set r0 = r3.entrySet()     // Catch:{ all -> 0x0345 }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x0345 }
        L_0x018d:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x0345 }
            if (r0 == 0) goto L_0x01da
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x0345 }
            r10 = r0
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0345 }
            java.lang.Object r0 = r10.getKey()     // Catch:{ JSONException -> 0x01a8 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x01a8 }
            java.lang.Object r11 = r10.getValue()     // Catch:{ JSONException -> 0x01a8 }
            r8.put(r0, r11)     // Catch:{ JSONException -> 0x01a8 }
            goto L_0x018d
        L_0x01a8:
            r0 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r11.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r15 = "failed to add data in json format: k="
            r11.append(r15)     // Catch:{ all -> 0x0345 }
            java.lang.Object r15 = r10.getKey()     // Catch:{ all -> 0x0345 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0345 }
            r11.append(r15)     // Catch:{ all -> 0x0345 }
            java.lang.String r15 = ",v="
            r11.append(r15)     // Catch:{ all -> 0x0345 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0345 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0345 }
            r11.append(r10)     // Catch:{ all -> 0x0345 }
            java.lang.String r10 = ". "
            r11.append(r10)     // Catch:{ all -> 0x0345 }
            r11.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x0345 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)     // Catch:{ all -> 0x0345 }
            goto L_0x018d
        L_0x01da:
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = com.xiaomi.push.service.C2024bl.m5142a(r0)     // Catch:{ all -> 0x0345 }
            java.util.TreeMap r8 = new java.util.TreeMap     // Catch:{ all -> 0x0345 }
            r8.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = "requestData"
            r8.put(r9, r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r9 = "keyPairVer"
            java.lang.String r10 = "1"
            r8.put(r9, r10)     // Catch:{ all -> 0x0345 }
            int r9 = m5301a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            r10 = 2
            if (r9 >= r10) goto L_0x0217
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r9 == 0) goto L_0x0201
            goto L_0x0217
        L_0x0201:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r9.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r10 = "r.data = "
            r9.append(r10)     // Catch:{ all -> 0x0345 }
            r9.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0345 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ all -> 0x0345 }
            r15 = 1
            goto L_0x0218
        L_0x0217:
            r15 = 0
        L_0x0218:
            java.lang.String r0 = m5304a((android.content.Context) r1, (boolean) r15)     // Catch:{ all -> 0x0345 }
            if (r15 == 0) goto L_0x021f
            r3 = r8
        L_0x021f:
            com.xiaomi.push.bg r0 = com.xiaomi.push.C1653bi.m2672a(r1, r0, r3)     // Catch:{ IOException -> 0x0224 }
            goto L_0x023b
        L_0x0224:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r0.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r8 = "device registration request failed. "
            r0.append(r8)     // Catch:{ all -> 0x0345 }
            r0.append(r3)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0345 }
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)     // Catch:{ all -> 0x0345 }
            r0 = 0
        L_0x023b:
            if (r0 == 0) goto L_0x032b
            int r3 = r0.f1864a     // Catch:{ all -> 0x0345 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r3 != r8) goto L_0x032b
            java.lang.String r0 = r0.mo17255a()     // Catch:{ all -> 0x0345 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0345 }
            if (r3 != 0) goto L_0x032b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r8 = "code"
            int r8 = r3.getInt(r8)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            if (r8 != 0) goto L_0x02d7
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r3 = "ssecurity"
            java.lang.String r11 = r0.getString(r3)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r3 = "token"
            java.lang.String r10 = r0.getString(r3)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r3 = "userId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            if (r8 == 0) goto L_0x028e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r7.<init>()     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r8 = "an"
            r7.append(r8)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r8 = 6
            java.lang.String r8 = com.xiaomi.push.C1663bo.m2726a((int) r8)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r7.append(r8)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
        L_0x028e:
            com.xiaomi.push.service.n r9 = new com.xiaomi.push.service.n     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r8.<init>()     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r8.append(r3)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r6 = "@xiaomi.com/"
            r8.append(r6)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r8.append(r7)     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            java.lang.String r6 = r8.toString()     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            int r7 = com.xiaomi.push.C1611ad.m2504a()     // Catch:{ JSONException -> 0x0317, all -> 0x0300 }
            r8 = r9
            r5 = r9
            r9 = r6
            r6 = r15
            r15 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            m5308a((android.content.Context) r1, (com.xiaomi.push.service.C2071n) r5)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.String r7 = "vdevid"
            java.lang.String r0 = r0.optString(r7)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            com.xiaomi.push.C1907j.m4555a((android.content.Context) r1, (java.lang.String) r0)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            f3932a = r5     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            m5307a((android.content.Context) r1, (int) r4)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            r0.<init>()     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.String r4 = "device registration is successful. "
            r0.append(r4)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            r0.append(r3)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            monitor-exit(r2)
            return r5
        L_0x02d7:
            r6 = r15
            java.lang.String r4 = "code"
            int r4 = r3.getInt(r4)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.String r5 = "description"
            java.lang.String r3 = r3.optString(r5)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            com.xiaomi.push.service.C2076r.m5324a(r1, r4, r3)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            r3.<init>()     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.String r4 = "device registration resp: "
            r3.append(r4)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            r3.append(r0)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ JSONException -> 0x02fe, all -> 0x02fc }
            goto L_0x032c
        L_0x02fc:
            r0 = move-exception
            goto L_0x0302
        L_0x02fe:
            r0 = move-exception
            goto L_0x0319
        L_0x0300:
            r0 = move-exception
            r6 = r15
        L_0x0302:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r3.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r4 = "unknow throwable. "
            r3.append(r4)     // Catch:{ all -> 0x0345 }
            r3.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0345 }
        L_0x0313:
            com.xiaomi.channel.commonutils.logger.C1524b.m2160d(r0)     // Catch:{ all -> 0x0345 }
            goto L_0x032c
        L_0x0317:
            r0 = move-exception
            r6 = r15
        L_0x0319:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0345 }
            r3.<init>()     // Catch:{ all -> 0x0345 }
            java.lang.String r4 = "failed to parse respone json data. "
            r3.append(r4)     // Catch:{ all -> 0x0345 }
            r3.append(r0)     // Catch:{ all -> 0x0345 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0345 }
            goto L_0x0313
        L_0x032b:
            r6 = r15
        L_0x032c:
            if (r6 == 0) goto L_0x033d
            boolean r0 = com.xiaomi.push.C1653bi.m2686c(r16)     // Catch:{ all -> 0x0345 }
            if (r0 == 0) goto L_0x033d
            int r0 = m5301a((android.content.Context) r16)     // Catch:{ all -> 0x0345 }
            r3 = 1
            int r0 = r0 + r3
            m5307a((android.content.Context) r1, (int) r0)     // Catch:{ all -> 0x0345 }
        L_0x033d:
            java.lang.String r0 = "fail to register push account. meet error."
            com.xiaomi.channel.commonutils.logger.C1524b.m2141a((java.lang.String) r0)     // Catch:{ all -> 0x0345 }
            monitor-exit(r2)
            r1 = 0
            return r1
        L_0x0345:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0349
        L_0x0348:
            throw r0
        L_0x0349:
            goto L_0x0348
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C2072o.m5303a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.n");
    }

    /* renamed from: a */
    private static String m5304a(Context context, boolean z) {
        StringBuilder sb;
        String str;
        if (C1614ag.f1764a && C1938m.m4728b(context)) {
            String a = C2086t.m5370a("log.tag.debug.xmsf.dr", "");
            if (!TextUtils.isEmpty(a)) {
                C1524b.m2141a("[debug] device register url：" + a);
                return a;
            }
        }
        String a2 = C1966a.m4862a(context).mo18436a();
        String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (C1611ad.m2507b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(C1811fv.f2452b);
            str = ":9085";
        } else if (C1941p.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (C1941p.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (C1941p.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (C1941p.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (C1941p.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = C1611ad.m2504a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m5305a() {
        C2073a aVar = f3933a;
        if (aVar != null) {
            aVar.mo18519a();
        }
    }

    /* renamed from: a */
    public static void m5306a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f3932a = null;
        m5305a();
    }

    /* renamed from: a */
    private static void m5307a(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i);
        edit.commit();
    }

    /* renamed from: a */
    public static void m5308a(Context context, C2071n nVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", nVar.f3926a);
        edit.putString("security", nVar.f3928c);
        edit.putString("token", nVar.f3927b);
        edit.putString("app_id", nVar.f3929d);
        edit.putString(Constants.PACKAGE_NAME, nVar.f3931f);
        edit.putString("app_token", nVar.f3930e);
        edit.putString("device_id", C1907j.m4580k(context));
        edit.putInt("env_type", nVar.f3925a);
        edit.commit();
        m5305a();
    }

    /* renamed from: a */
    public static void m5309a(C2073a aVar) {
        f3933a = aVar;
    }

    /* renamed from: a */
    private static boolean m5310a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
