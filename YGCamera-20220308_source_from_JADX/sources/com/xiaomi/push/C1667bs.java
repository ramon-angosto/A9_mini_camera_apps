package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.utils.SharedPreferencesUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.clientreport.manager.C1528a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.xiaomi.push.bs */
public class C1667bs {
    /* renamed from: a */
    public static String m2745a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    /* renamed from: a */
    public static String m2746a(Context context) {
        String a = C1670bv.m2754a(context).mo17269a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String a2 = C1663bo.m2726a(20);
        C1670bv.m2754a(context).mo17269a("sp_client_report_status", "sp_client_report_key", a2);
        return a2;
    }

    /* renamed from: a */
    public static void m2747a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra(SharedPreferencesUtils.USER_NAME, "quality_support");
        intent.putExtra(RemoteMessageConst.DATA, str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e6, code lost:
        if (r7 == null) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0104  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2748a(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            java.io.File r13 = r11.getExternalFilesDir(r13)
            if (r13 == 0) goto L_0x0124
            boolean r0 = r13.exists()
            if (r0 != 0) goto L_0x000f
            r13.mkdirs()
        L_0x000f:
            java.io.File r11 = r11.getExternalFilesDir(r12)
            if (r11 == 0) goto L_0x0124
            boolean r12 = r11.exists()
            if (r12 != 0) goto L_0x001f
            r11.mkdirs()
            return
        L_0x001f:
            com.xiaomi.push.bt r12 = new com.xiaomi.push.bt
            r12.<init>()
            java.io.File[] r11 = r11.listFiles(r12)
            if (r11 == 0) goto L_0x0124
            int r12 = r11.length
            if (r12 > 0) goto L_0x002f
            goto L_0x0124
        L_0x002f:
            long r0 = java.lang.System.currentTimeMillis()
            int r12 = r11.length
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0038:
            if (r2 >= r12) goto L_0x0124
            r6 = r11[r2]
            if (r6 == 0) goto L_0x0108
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            if (r7 == 0) goto L_0x004a
            goto L_0x0108
        L_0x004a:
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            r8.<init>()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            java.lang.String r9 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            r8.append(r9)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            java.lang.String r9 = ".lock"
            r8.append(r9)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
            com.xiaomi.push.C1608aa.m2490a((java.io.File) r7)     // Catch:{ Exception -> 0x00c3, all -> 0x00c1 }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00c3, all -> 0x00c1 }
            java.lang.String r8 = "rw"
            r5.<init>(r7, r8)     // Catch:{ Exception -> 0x00c3, all -> 0x00c1 }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x00bf }
            java.nio.channels.FileLock r3 = r4.lock()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = r13.getAbsolutePath()     // Catch:{ Exception -> 0x00bf }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bf }
            r8.<init>()     // Catch:{ Exception -> 0x00bf }
            r8.append(r4)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00bf }
            r8.append(r4)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = r6.getName()     // Catch:{ Exception -> 0x00bf }
            r8.append(r4)     // Catch:{ Exception -> 0x00bf }
            r8.append(r0)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x00bf }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00bf }
            r8.<init>(r4)     // Catch:{ Exception -> 0x00bf }
            com.xiaomi.push.C1608aa.m2498b(r6, r8)     // Catch:{ IOException -> 0x009e }
            goto L_0x00a8
        L_0x009e:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ Exception -> 0x00bf }
            r6.delete()     // Catch:{ Exception -> 0x00bf }
            r8.delete()     // Catch:{ Exception -> 0x00bf }
        L_0x00a8:
            r6.delete()     // Catch:{ Exception -> 0x00bf }
            if (r3 == 0) goto L_0x00bb
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00bb
            r3.release()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)
        L_0x00bb:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
            goto L_0x00e8
        L_0x00bf:
            r4 = move-exception
            goto L_0x00d0
        L_0x00c1:
            r11 = move-exception
            goto L_0x00ca
        L_0x00c3:
            r5 = move-exception
            r10 = r5
            r5 = r4
            r4 = r10
            goto L_0x00d0
        L_0x00c8:
            r11 = move-exception
            r7 = r5
        L_0x00ca:
            r5 = r4
            goto L_0x00ef
        L_0x00cc:
            r6 = move-exception
            r7 = r5
            r5 = r4
            r4 = r6
        L_0x00d0:
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)     // Catch:{ all -> 0x00ee }
            if (r3 == 0) goto L_0x00e3
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00e3
            r3.release()     // Catch:{ IOException -> 0x00df }
            goto L_0x00e3
        L_0x00df:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r4)
        L_0x00e3:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
            if (r7 == 0) goto L_0x00eb
        L_0x00e8:
            r7.delete()
        L_0x00eb:
            r4 = r5
            r5 = r7
            goto L_0x0120
        L_0x00ee:
            r11 = move-exception
        L_0x00ef:
            if (r3 == 0) goto L_0x00ff
            boolean r12 = r3.isValid()
            if (r12 == 0) goto L_0x00ff
            r3.release()     // Catch:{ IOException -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r12)
        L_0x00ff:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r5)
            if (r7 == 0) goto L_0x0107
            r7.delete()
        L_0x0107:
            throw r11
        L_0x0108:
            if (r3 == 0) goto L_0x0118
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0118
            r3.release()     // Catch:{ IOException -> 0x0114 }
            goto L_0x0118
        L_0x0114:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.C1524b.m2155a((java.lang.Throwable) r6)
        L_0x0118:
            com.xiaomi.push.C1608aa.m2491a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x0120
            r5.delete()
        L_0x0120:
            int r2 = r2 + 1
            goto L_0x0038
        L_0x0124:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1667bs.m2748a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    public static void m2749a(Context context, List<String> list) {
        if (list != null && list.size() > 0 && m2746a(context)) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    m2747a(context, next);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m2750a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m2751a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = C1528a.m2164a(context).mo16975a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e) {
                C1524b.m2155a((Throwable) e);
                return false;
            }
        } else {
            C1608aa.m2490a(file);
        }
        return true;
    }

    /* renamed from: a */
    public static byte[] m2752a(String str) {
        byte[] copyOf = Arrays.copyOf(C1660bl.m2714a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a */
    public static File[] m2753a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new C1669bu());
        }
        return null;
    }
}
