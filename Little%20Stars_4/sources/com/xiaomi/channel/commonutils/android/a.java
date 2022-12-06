package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static int a(List<String> list, String str) {
        int i = 0;
        while (list != null && i < list.size()) {
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.split("/");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0012
            java.lang.String r0 = "/"
            java.lang.String[] r0 = r2.split(r0)
            if (r0 == 0) goto L_0x0012
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0012
            int r2 = r0.length
            int r2 = r2 + -1
            r2 = r0[r2]
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.a.a(java.lang.String):java.lang.String");
    }

    public static List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        String b = b(context);
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(b);
        }
        String a = h.a("ro.product.cpu.abi", "");
        if (!TextUtils.isEmpty(a)) {
            arrayList.add(a);
        }
        String a2 = h.a("ro.product.cpu.abi2", "");
        if (!TextUtils.isEmpty(a2)) {
            arrayList.add(a2);
        }
        String a3 = h.a("ro.product.cpu.abilist", "");
        if (!TextUtils.isEmpty(a3)) {
            String[] split = a3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            int i = 0;
            while (split != null && i < split.length) {
                if (!TextUtils.isEmpty(split[i])) {
                    arrayList.add(split[i]);
                }
                i++;
            }
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0118 A[SYNTHETIC, Splitter:B:47:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0123 A[SYNTHETIC, Splitter:B:52:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r9, java.lang.String r10, java.lang.String r11) {
        /*
            r0 = 0
            if (r10 == 0) goto L_0x0024
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0021 }
            boolean r1 = r10.endsWith(r1)     // Catch:{ Exception -> 0x0021 }
            if (r1 != 0) goto L_0x0024
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0021 }
            r1.<init>()     // Catch:{ Exception -> 0x0021 }
            r1.append(r10)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ Exception -> 0x0021 }
            r1.append(r10)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x0021 }
            goto L_0x0024
        L_0x001d:
            r9 = move-exception
            r2 = r0
            goto L_0x0121
        L_0x0021:
            r9 = move-exception
            goto L_0x0113
        L_0x0024:
            if (r11 == 0) goto L_0x003f
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0021 }
            boolean r1 = r11.endsWith(r1)     // Catch:{ Exception -> 0x0021 }
            if (r1 != 0) goto L_0x003f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0021 }
            r1.<init>()     // Catch:{ Exception -> 0x0021 }
            r1.append(r11)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r11 = java.io.File.separator     // Catch:{ Exception -> 0x0021 }
            r1.append(r11)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x0021 }
        L_0x003f:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x0021 }
            r1.<init>()     // Catch:{ Exception -> 0x0021 }
            java.util.List r9 = a((android.content.Context) r9)     // Catch:{ Exception -> 0x0021 }
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x0021 }
            r2.<init>(r10)     // Catch:{ Exception -> 0x0021 }
            java.util.Enumeration r10 = r2.entries()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r0]     // Catch:{ Exception -> 0x0111, all -> 0x010f }
        L_0x0055:
            boolean r4 = r10.hasMoreElements()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r4 == 0) goto L_0x010b
            java.lang.Object r4 = r10.nextElement()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.util.zip.ZipEntry r4 = (java.util.zip.ZipEntry) r4     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r5.<init>()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r6 = "ze.getName() = "
            r5.append(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r6 = r4.getName()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r5.append(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            com.xiaomi.channel.commonutils.logger.b.b(r5)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r5 = r4.getName()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r6 = "lib/"
            boolean r5 = r5.startsWith(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r5 != 0) goto L_0x0086
            goto L_0x0055
        L_0x0086:
            boolean r5 = r4.isDirectory()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r5 != 0) goto L_0x0055
            java.lang.String r5 = r4.getName()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r5 = a((java.lang.String) r5)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r6 = r4.getName()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r6 = b((java.lang.String) r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.Object r7 = r1.get(r5)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r8 != 0) goto L_0x00b5
            int r8 = a(r9, r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r8 < 0) goto L_0x0055
            int r7 = a(r9, r7)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r8 < r7) goto L_0x00b5
            goto L_0x0055
        L_0x00b5:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r7.<init>()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r8 = "use abi "
            r7.append(r8)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r7.append(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            com.xiaomi.channel.commonutils.logger.b.b(r7)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r7.<init>()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r7.append(r11)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r7.append(r5)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            boolean r5 = r6.exists()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            if (r5 == 0) goto L_0x00e9
            r6.delete()     // Catch:{ Exception -> 0x0111, all -> 0x010f }
        L_0x00e9:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            java.io.InputStream r4 = r2.getInputStream(r4)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
        L_0x00f7:
            r4 = 0
            int r7 = r6.read(r3, r4, r0)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            r8 = -1
            if (r7 == r8) goto L_0x0103
            r5.write(r3, r4, r7)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            goto L_0x00f7
        L_0x0103:
            com.xiaomi.channel.commonutils.file.a.a((java.io.InputStream) r6)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            com.xiaomi.channel.commonutils.file.a.a((java.io.OutputStream) r5)     // Catch:{ Exception -> 0x0111, all -> 0x010f }
            goto L_0x0055
        L_0x010b:
            r2.close()     // Catch:{ Exception -> 0x011c }
            goto L_0x0120
        L_0x010f:
            r9 = move-exception
            goto L_0x0121
        L_0x0111:
            r9 = move-exception
            r0 = r2
        L_0x0113:
            r9.printStackTrace()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0120
            r0.close()     // Catch:{ Exception -> 0x011c }
            goto L_0x0120
        L_0x011c:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0120:
            return
        L_0x0121:
            if (r2 == 0) goto L_0x012b
            r2.close()     // Catch:{ Exception -> 0x0127 }
            goto L_0x012b
        L_0x0127:
            r10 = move-exception
            r10.printStackTrace()
        L_0x012b:
            goto L_0x012d
        L_0x012c:
            throw r9
        L_0x012d:
            goto L_0x012c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.a.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static String b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field declaredField = Class.forName("android.content.pm.ApplicationInfo").getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.split("/");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0014
            java.lang.String r0 = "/"
            java.lang.String[] r2 = r2.split(r0)
            if (r2 == 0) goto L_0x0014
            int r0 = r2.length
            r1 = 1
            if (r0 <= r1) goto L_0x0014
            int r0 = r2.length
            int r0 = r0 + -2
            r2 = r2[r0]
            return r2
        L_0x0014:
            java.lang.String r2 = "armeabi"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.a.b(java.lang.String):java.lang.String");
    }
}
