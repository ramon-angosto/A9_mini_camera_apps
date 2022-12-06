package com.huawei.android.pushselfshow.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.huawei.android.pushagent.c.a.a.g;
import com.huawei.android.pushagent.c.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class a {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static Typeface b = null;

    public static int a(int i, int i2) {
        StringBuilder sb;
        String str;
        e.a("PushSelfShowLog", "enter ctrlSockets(cmd:" + i + " param:" + i2 + ")");
        try {
            return ((Integer) Class.forName("dalvik.system.Zygote").getMethod("ctrlSockets", new Class[]{Integer.TYPE, Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        } catch (NoSuchMethodException e) {
            e = e;
            sb = new StringBuilder();
            str = "NoSuchMethodException:";
            sb.append(str);
            sb.append(e);
            e.d("PushSelfShowLog", sb.toString());
            return -2;
        } catch (ClassNotFoundException e2) {
            e = e2;
            sb = new StringBuilder();
            str = "ClassNotFoundException:";
            sb.append(str);
            sb.append(e);
            e.d("PushSelfShowLog", sb.toString());
            return -2;
        } catch (IllegalAccessException e3) {
            e = e3;
            sb = new StringBuilder();
            str = "IllegalAccessException:";
            sb.append(str);
            sb.append(e);
            e.d("PushSelfShowLog", sb.toString());
            return -2;
        } catch (InvocationTargetException e4) {
            e = e4;
            sb = new StringBuilder();
            str = "InvocationTargetException:";
            sb.append(str);
            sb.append(e);
            e.d("PushSelfShowLog", sb.toString());
            return -2;
        } catch (RuntimeException e5) {
            e = e5;
            sb = new StringBuilder();
            str = "RuntimeException:";
            sb.append(str);
            sb.append(e);
            e.d("PushSelfShowLog", sb.toString());
            return -2;
        } catch (Exception e6) {
            e = e6;
            sb = new StringBuilder();
            str = "Exception:";
            sb.append(str);
            sb.append(e);
            e.d("PushSelfShowLog", sb.toString());
            return -2;
        }
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static long a(Context context) {
        e.a("PushSelfShowLog", "enter getVersion()");
        long j = -1000;
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent("com.huawei.android.push.intent.REGISTER").setPackage(context.getPackageName()), 640);
            if (queryBroadcastReceivers != null) {
                if (queryBroadcastReceivers.size() != 0) {
                    j = a(queryBroadcastReceivers.get(0), "CS_cloud_version");
                    e.a("PushSelfShowLog", "get the version is :" + j);
                    return j;
                }
            }
            return -1000;
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
    }

    public static long a(ResolveInfo resolveInfo, String str) {
        if (resolveInfo == null) {
            return -1;
        }
        try {
            return Long.parseLong(b(resolveInfo, str));
        } catch (NumberFormatException unused) {
            e.b("PushSelfShowLog", str + " is not set in " + a(resolveInfo));
            return -1;
        }
    }

    public static Intent a(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
            e.b("PushSelfShowLog", e.toString(), (Throwable) e);
            return null;
        }
    }

    public static Boolean a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i = 0; i < size; i++) {
                    if (queryIntentActivities.get(i).activityInfo != null && str.equals(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
        return false;
    }

    public static String a(Context context, String str, String str2) {
        try {
            return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh") ? str : str2;
        } catch (Exception e) {
            e.c("PushSelfShowLog", "getStringByLanguage failed ", e);
        }
    }

    public static String a(ResolveInfo resolveInfo) {
        return resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.packageName : resolveInfo.activityInfo.packageName;
    }

    public static String a(String str) {
        try {
            return a(g.a(str.getBytes("UTF-8"), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDf5raDExuuXbsVNCWl48yuB89W\rfNOuuhPuS2Mptii/0UorpzypBkNTTGt11E7aorCc1lFwlB+4KDMIpFyQsdChSk+A\rt9UfhFKa95uiDpMe5rMfU+DAhoXGER6WQ2qGtrHmBWVv33i3lc76u9IgEfYuLwC6\r1mhQDHzAKPiViY6oeQIDAQAB\r"));
        } catch (Exception e) {
            e.d("PushSelfShowLog", "encrypter error ", e);
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(a[(bArr[i] >>> 4) & 15]);
            sb.append(a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static void a(Context context, Intent intent, long j) {
        try {
            e.a("PushSelfShowLog", "enter setAPDelayAlarm(intent:" + intent.toURI() + " interval:" + j + "ms, context:" + context);
            ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, new SecureRandom().nextInt(), intent, 0));
        } catch (Exception e) {
            e.a("PushSelfShowLog", "set DelayAlarm error", (Throwable) e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r2, android.widget.TextView r3) {
        /*
            java.lang.Class<com.huawei.android.pushselfshow.utils.a> r0 = com.huawei.android.pushselfshow.utils.a.class
            monitor-enter(r0)
            if (r2 == 0) goto L_0x0040
            if (r3 != 0) goto L_0x0008
            goto L_0x0040
        L_0x0008:
            int r2 = com.huawei.android.pushagent.c.a.b.a()     // Catch:{ all -> 0x0049 }
            r1 = 9
            if (r2 < r1) goto L_0x003e
            boolean r2 = e()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x003e
            android.graphics.Typeface r2 = b     // Catch:{ all -> 0x0049 }
            if (r2 != 0) goto L_0x002e
            java.lang.String r2 = "chnfzxh"
            r1 = 0
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r1)     // Catch:{ Exception -> 0x0024 }
            b = r2     // Catch:{ Exception -> 0x0024 }
            goto L_0x002e
        L_0x0024:
            r2 = move-exception
            java.lang.String r1 = "PushSelfShowLog"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0049 }
            com.huawei.android.pushagent.c.a.e.d(r1, r2)     // Catch:{ all -> 0x0049 }
        L_0x002e:
            android.graphics.Typeface r2 = b     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x003e
            java.lang.String r2 = "PushSelfShowLog"
            java.lang.String r1 = "setTypeFaceEx success"
            com.huawei.android.pushagent.c.a.e.a(r2, r1)     // Catch:{ all -> 0x0049 }
            android.graphics.Typeface r2 = b     // Catch:{ all -> 0x0049 }
            r3.setTypeface(r2)     // Catch:{ all -> 0x0049 }
        L_0x003e:
            monitor-exit(r0)
            return
        L_0x0040:
            java.lang.String r2 = "PushSelfShowLog"
            java.lang.String r3 = "context is null or textView is null"
            com.huawei.android.pushagent.c.a.e.b(r2, r3)     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)
            return
        L_0x0049:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.a(android.content.Context, android.widget.TextView):void");
    }

    public static void a(Context context, String str, com.huawei.android.pushselfshow.b.a aVar) {
        if (aVar != null) {
            a(context, str, aVar.l, aVar.o);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        new Thread(new b(context, str2, str, str3)).start();
    }

    public static void a(File file) {
        if (file != null) {
            e.a("PushSelfShowLog", "delete file " + file.getAbsolutePath());
            File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                if ((!file2.isFile() || !file2.delete()) && file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        for (File a2 : listFiles) {
                            a(a2);
                        }
                        if (!file2.delete()) {
                            e.a("PushSelfShowLog", "delete file unsuccess");
                        }
                    } else if (!file2.delete()) {
                        e.a("PushSelfShowLog", "delete file failed");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x00ff A[SYNTHETIC, Splitter:B:101:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0097 A[SYNTHETIC, Splitter:B:57:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a1 A[SYNTHETIC, Splitter:B:62:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00bb A[SYNTHETIC, Splitter:B:71:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c5 A[SYNTHETIC, Splitter:B:76:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00d1 A[SYNTHETIC, Splitter:B:82:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00db A[SYNTHETIC, Splitter:B:87:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f5 A[SYNTHETIC, Splitter:B:96:0x00f5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r10, java.io.File r11) {
        /*
            java.lang.String r0 = "input.close() "
            java.lang.String r1 = "output.close() "
            java.lang.String r2 = "inBuff.close() "
            java.lang.String r3 = "PushSelfShowLog"
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c, all -> 0x0087 }
            r5.<init>(r10)     // Catch:{ IOException -> 0x008c, all -> 0x0087 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0083, all -> 0x007f }
            r10.<init>(r5)     // Catch:{ IOException -> 0x0083, all -> 0x007f }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0079, all -> 0x0072 }
            r6.<init>(r11)     // Catch:{ IOException -> 0x0079, all -> 0x0072 }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x006c, all -> 0x0065 }
            r11.<init>(r6)     // Catch:{ IOException -> 0x006c, all -> 0x0065 }
            r4 = 5120(0x1400, float:7.175E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0060, all -> 0x005a }
        L_0x0021:
            int r7 = r10.read(r4)     // Catch:{ IOException -> 0x0060, all -> 0x005a }
            r8 = -1
            if (r7 == r8) goto L_0x002d
            r8 = 0
            r11.write(r4, r8, r7)     // Catch:{ IOException -> 0x0060, all -> 0x005a }
            goto L_0x0021
        L_0x002d:
            r10.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r10 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r2, r10)
        L_0x0035:
            r11.flush()     // Catch:{ Exception -> 0x0039 }
            goto L_0x0041
        L_0x0039:
            r10 = move-exception
            java.lang.String r2 = r10.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r2, r10)
        L_0x0041:
            r11.close()     // Catch:{ Exception -> 0x0045 }
            goto L_0x004d
        L_0x0045:
            r10 = move-exception
            java.lang.String r11 = r10.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r11, r10)
        L_0x004d:
            r6.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r10 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r1, r10)
        L_0x0055:
            r5.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00cd
        L_0x005a:
            r4 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto L_0x00cf
        L_0x0060:
            r4 = move-exception
            r9 = r4
            r4 = r10
            r10 = r9
            goto L_0x0090
        L_0x0065:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r11
            r11 = r9
            goto L_0x00cf
        L_0x006c:
            r11 = move-exception
            r9 = r4
            r4 = r10
            r10 = r11
            r11 = r9
            goto L_0x0090
        L_0x0072:
            r11 = move-exception
            r6 = r4
            r4 = r10
            r10 = r11
            r11 = r6
            goto L_0x00cf
        L_0x0079:
            r11 = move-exception
            r6 = r4
            r4 = r10
            r10 = r11
            r11 = r6
            goto L_0x0090
        L_0x007f:
            r10 = move-exception
            r11 = r4
            r6 = r11
            goto L_0x00cf
        L_0x0083:
            r10 = move-exception
            r11 = r4
            r6 = r11
            goto L_0x0090
        L_0x0087:
            r10 = move-exception
            r11 = r4
            r5 = r11
            r6 = r5
            goto L_0x00cf
        L_0x008c:
            r10 = move-exception
            r11 = r4
            r5 = r11
            r6 = r5
        L_0x0090:
            java.lang.String r7 = "copyFile "
            com.huawei.android.pushagent.c.a.e.d(r3, r7, r10)     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x009f
            r4.close()     // Catch:{ Exception -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r10 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r2, r10)
        L_0x009f:
            if (r11 == 0) goto L_0x00b9
            r11.flush()     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00ad
        L_0x00a5:
            r10 = move-exception
            java.lang.String r2 = r10.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r2, r10)
        L_0x00ad:
            r11.close()     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b9
        L_0x00b1:
            r10 = move-exception
            java.lang.String r11 = r10.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r11, r10)
        L_0x00b9:
            if (r6 == 0) goto L_0x00c3
            r6.close()     // Catch:{ Exception -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r10 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r1, r10)
        L_0x00c3:
            if (r5 == 0) goto L_0x00cd
            r5.close()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r10 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r0, r10)
        L_0x00cd:
            return
        L_0x00ce:
            r10 = move-exception
        L_0x00cf:
            if (r4 == 0) goto L_0x00d9
            r4.close()     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00d9
        L_0x00d5:
            r4 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r2, r4)
        L_0x00d9:
            if (r11 == 0) goto L_0x00f3
            r11.flush()     // Catch:{ Exception -> 0x00df }
            goto L_0x00e7
        L_0x00df:
            r2 = move-exception
            java.lang.String r4 = r2.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r4, r2)
        L_0x00e7:
            r11.close()     // Catch:{ Exception -> 0x00eb }
            goto L_0x00f3
        L_0x00eb:
            r11 = move-exception
            java.lang.String r2 = r11.toString()
            com.huawei.android.pushagent.c.a.e.c(r3, r2, r11)
        L_0x00f3:
            if (r6 == 0) goto L_0x00fd
            r6.close()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r11 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r1, r11)
        L_0x00fd:
            if (r5 == 0) goto L_0x0107
            r5.close()     // Catch:{ Exception -> 0x0103 }
            goto L_0x0107
        L_0x0103:
            r11 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r3, r0, r11)
        L_0x0107:
            goto L_0x0109
        L_0x0108:
            throw r10
        L_0x0109:
            goto L_0x0108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.a(java.io.File, java.io.File):void");
    }

    public static boolean a(String str, String str2) {
        try {
            e.a("PushSelfShowLog", "urlSrc is %s ,urlDest is %s,urlDest is already exist?%s ", str, str2, Boolean.valueOf(new File(str2).mkdirs()));
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isFile()) {
                        a(listFiles[i], new File(str2 + File.separator + listFiles[i].getName()));
                    }
                    if (listFiles[i].isDirectory()) {
                        b(str + File.separator + listFiles[i].getName(), str2 + File.separator + listFiles[i].getName());
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.d("PushSelfShowLog", "fileCopy error ", e);
            return false;
        }
    }

    public static long b(String str) {
        if (str == null) {
            str = "";
        }
        try {
            Date date = new Date();
            int hours = (date.getHours() * 2) + (date.getMinutes() / 30);
            String concat = str.concat(str);
            e.a("PushSelfShowLog", "startIndex is %s ,and ap is %s ,length is %s", Integer.valueOf(hours), concat, Integer.valueOf(concat.length()));
            for (int i = hours; i < concat.length(); i++) {
                if (concat.charAt(i) != '0') {
                    long minutes = 60000 * ((long) (((i - hours) * 30) - (date.getMinutes() % 30)));
                    e.a("PushSelfShowLog", "startIndex is %s i is %s delay %s", Integer.valueOf(hours), Integer.valueOf(i), Long.valueOf(minutes));
                    if (minutes >= 0) {
                        return minutes;
                    }
                    return 0;
                }
            }
        } catch (Exception e) {
            e.c("PushSelfShowLog", "error ", e);
        }
        return 0;
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getDeviceId() : "";
    }

    private static String b(ResolveInfo resolveInfo, String str) {
        Bundle bundle = resolveInfo.serviceInfo != null ? resolveInfo.serviceInfo.metaData : resolveInfo.activityInfo.metaData;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0059 A[SYNTHETIC, Splitter:B:37:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0063 A[SYNTHETIC, Splitter:B:42:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006a A[SYNTHETIC, Splitter:B:46:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0074 A[SYNTHETIC, Splitter:B:51:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "is.close() "
            java.lang.String r1 = "fos.close() "
            java.lang.String r2 = "PushSelfShowLog"
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            r4.<init>(r7)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            if (r4 != 0) goto L_0x0036
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0034 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x0031, all -> 0x002e }
        L_0x0023:
            int r3 = r5.read(r7)     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            if (r3 <= 0) goto L_0x0038
            r4 = 0
            r6.write(r7, r4, r3)     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            goto L_0x0023
        L_0x002e:
            r7 = move-exception
            r3 = r6
            goto L_0x0068
        L_0x0031:
            r7 = move-exception
            r3 = r6
            goto L_0x0052
        L_0x0034:
            r7 = move-exception
            goto L_0x0052
        L_0x0036:
            r5 = r3
            r6 = r5
        L_0x0038:
            if (r6 == 0) goto L_0x0042
            r6.close()     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r6 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r2, r1, r6)
        L_0x0042:
            if (r5 == 0) goto L_0x0066
            r5.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0066
        L_0x0048:
            r5 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r2, r0, r5)
            goto L_0x0066
        L_0x004d:
            r7 = move-exception
            r5 = r3
            goto L_0x0068
        L_0x0050:
            r7 = move-exception
            r5 = r3
        L_0x0052:
            java.lang.String r6 = "copyAsset "
            com.huawei.android.pushagent.c.a.e.d(r2, r6, r7)     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r6 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r2, r1, r6)
        L_0x0061:
            if (r5 == 0) goto L_0x0066
            r5.close()     // Catch:{ Exception -> 0x0048 }
        L_0x0066:
            return
        L_0x0067:
            r7 = move-exception
        L_0x0068:
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r6 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r2, r1, r6)
        L_0x0072:
            if (r5 == 0) goto L_0x007c
            r5.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r5 = move-exception
            com.huawei.android.pushagent.c.a.e.d(r2, r0, r5)
        L_0x007c:
            goto L_0x007e
        L_0x007d:
            throw r7
        L_0x007e:
            goto L_0x007d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.b(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void b(File file) {
        File[] listFiles;
        e.a("PushSelfShowLog", "delete file before ");
        if (file != null && file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < listFiles.length; i++) {
                try {
                    File file2 = listFiles[i];
                    if (currentTimeMillis - file2.lastModified() > 86400000) {
                        e.e("PushSelfShowLog", "delete file before " + file2.getAbsolutePath());
                        a(file2);
                    }
                } catch (Exception e) {
                    e.e("PushSelfShowLog", e.toString());
                }
            }
        }
    }

    private static void b(String str, String str2) throws IOException {
        if (new File(str2).mkdirs()) {
            e.e("PushSelfShowLog", "mkdir");
        }
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    a(listFiles[i], new File(new File(str2).getAbsolutePath() + File.separator + listFiles[i].getName()));
                }
                if (listFiles[i].isDirectory()) {
                    b(str + "/" + listFiles[i].getName(), str2 + "/" + listFiles[i].getName());
                }
            }
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean b(Context context, String str) {
        if (!(context == null || str == null || "".equals(str))) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                e.a("PushSelfShowLog", str + " is installed");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        try {
            String str2 = ((!Environment.getExternalStorageState().equals("mounted") ? context.getFilesDir() : Environment.getExternalStorageDirectory()).getPath() + File.separator + "PushService") + File.separator + str;
            e.a("PushSelfShowLog", "dbPath is " + str2);
            return str2;
        } catch (Exception e) {
            e.d("PushSelfShowLog", "getDbPath error", e);
            return "";
        }
    }

    public static ArrayList c(Context context) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id="));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!(queryIntentActivities == null || queryIntentActivities.size() == 0)) {
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                if (queryIntentActivities.get(i).activityInfo != null) {
                    arrayList.add(queryIntentActivities.get(i).activityInfo.applicationInfo.packageName);
                }
            }
        }
        return arrayList;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean d() {
        return b.a() >= 9;
    }

    public static boolean d(Context context) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setPackage("com.android.email");
        intent.setData(Uri.fromParts("mailto", "xxxx@xxxx.com", (String) null));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        return (queryIntentActivities == null || queryIntentActivities.size() == 0) ? false : true;
    }

    private static boolean e() {
        return "zh".equals(Locale.getDefault().getLanguage());
    }

    public static boolean e(Context context) {
        return "com.huawei.android.pushagent".equals(context.getPackageName());
    }

    public static boolean f(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo("com.huawei.android.pushagent", 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        if (r7 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (r7 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g(android.content.Context r8) {
        /*
            java.lang.String r0 = "PushSelfShowLog"
            android.content.ContentResolver r1 = r8.getContentResolver()
            r8 = 0
            r7 = 0
            android.net.Uri r2 = com.huawei.android.pushselfshow.richpush.provider.RichMediaProvider.a.a     // Catch:{ Exception -> 0x004a }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x004a }
            if (r7 == 0) goto L_0x0042
            boolean r1 = r7.moveToFirst()     // Catch:{ Exception -> 0x004a }
            if (r1 == 0) goto L_0x0042
            java.lang.String r1 = "isSupport"
            int r1 = r7.getColumnIndex(r1)     // Catch:{ Exception -> 0x004a }
            int r1 = r7.getInt(r1)     // Catch:{ Exception -> 0x004a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r2.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = "isExistProvider:"
            r2.append(r3)     // Catch:{ Exception -> 0x004a }
            r2.append(r1)     // Catch:{ Exception -> 0x004a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004a }
            com.huawei.android.pushagent.c.a.e.a(r0, r2)     // Catch:{ Exception -> 0x004a }
            r0 = 1
            if (r0 != r1) goto L_0x003c
            r8 = 1
        L_0x003c:
            if (r7 == 0) goto L_0x0041
            r7.close()
        L_0x0041:
            return r8
        L_0x0042:
            if (r7 == 0) goto L_0x0055
        L_0x0044:
            r7.close()
            goto L_0x0055
        L_0x0048:
            r8 = move-exception
            goto L_0x0056
        L_0x004a:
            r1 = move-exception
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0048 }
            com.huawei.android.pushagent.c.a.e.a((java.lang.String) r0, (java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x0055
            goto L_0x0044
        L_0x0055:
            return r8
        L_0x0056:
            if (r7 == 0) goto L_0x005b
            r7.close()
        L_0x005b:
            goto L_0x005d
        L_0x005c:
            throw r8
        L_0x005d:
            goto L_0x005c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.g(android.content.Context):boolean");
    }

    public static int h(Context context) {
        if (context == null) {
            return 3;
        }
        return (Build.VERSION.SDK_INT < 16 || context.getResources().getIdentifier("androidhwext:style/Theme.Emui", (String) null, (String) null) == 0) ? 3 : 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.IllegalArgumentException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.IllegalAccessException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.reflect.InvocationTargetException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: java.lang.SecurityException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int i(android.content.Context r7) {
        /*
            java.lang.String r0 = "PushSelfShowLog"
            r1 = 0
            java.lang.String r2 = "com.huawei.android.immersion.ImmersionStyle"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.String r3 = "getPrimaryColor"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r1] = r6     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r5)     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            r4[r1] = r7     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.Object r7 = r3.invoke(r2, r4)     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            int r7 = r7.intValue()     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            r2.<init>()     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.String r3 = "colorPrimary:"
            r2.append(r3)     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            r2.append(r7)     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            java.lang.String r2 = r2.toString()     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            com.huawei.android.pushagent.c.a.e.b(r0, r2)     // Catch:{ ClassNotFoundException -> 0x005a, SecurityException -> 0x0051, NoSuchMethodException -> 0x004b, IllegalArgumentException -> 0x0045, IllegalAccessException -> 0x003f, InvocationTargetException -> 0x0039 }
            return r7
        L_0x0039:
            r7 = move-exception
            java.lang.String r2 = r7.toString()
            goto L_0x0056
        L_0x003f:
            r7 = move-exception
            java.lang.String r2 = r7.toString()
            goto L_0x0056
        L_0x0045:
            r7 = move-exception
            java.lang.String r2 = r7.toString()
            goto L_0x0056
        L_0x004b:
            r7 = move-exception
            java.lang.String r2 = r7.toString()
            goto L_0x0056
        L_0x0051:
            r7 = move-exception
            java.lang.String r2 = r7.toString()
        L_0x0056:
            com.huawei.android.pushagent.c.a.e.c(r0, r2, r7)
            goto L_0x005f
        L_0x005a:
            java.lang.String r7 = "ImmersionStyle ClassNotFoundException"
            com.huawei.android.pushagent.c.a.e.d(r0, r7)
        L_0x005f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.i(android.content.Context):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.NoSuchMethodException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.IllegalArgumentException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.IllegalAccessException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.reflect.InvocationTargetException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: java.lang.SecurityException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: java.lang.SecurityException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int j(android.content.Context r8) {
        /*
            java.lang.String r0 = "PushSelfShowLog"
            r1 = -1
            java.lang.String r2 = "com.huawei.android.immersion.ImmersionStyle"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.String r3 = "getPrimaryColor"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r7 = 0
            r5[r7] = r6     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r5)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            r5[r7] = r8     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Object r8 = r3.invoke(r2, r5)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            int r8 = r8.intValue()     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.String r3 = "getSuggestionForgroundColorStyle"
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            r5[r7] = r6     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.reflect.Method r3 = r2.getDeclaredMethod(r3, r5)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            r4[r7] = r8     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Object r8 = r3.invoke(r2, r4)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            int r1 = r8.intValue()     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            r8.<init>()     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.String r2 = "getSuggestionForgroundColorStyle:"
            r8.append(r2)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            r8.append(r1)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            java.lang.String r8 = r8.toString()     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            com.huawei.android.pushagent.c.a.e.b(r0, r8)     // Catch:{ ClassNotFoundException -> 0x0079, SecurityException -> 0x0070, NoSuchMethodException -> 0x006a, IllegalArgumentException -> 0x0064, IllegalAccessException -> 0x005e, InvocationTargetException -> 0x0058 }
            goto L_0x007e
        L_0x0058:
            r8 = move-exception
            java.lang.String r2 = r8.toString()
            goto L_0x0075
        L_0x005e:
            r8 = move-exception
            java.lang.String r2 = r8.toString()
            goto L_0x0075
        L_0x0064:
            r8 = move-exception
            java.lang.String r2 = r8.toString()
            goto L_0x0075
        L_0x006a:
            r8 = move-exception
            java.lang.String r2 = r8.toString()
            goto L_0x0075
        L_0x0070:
            r8 = move-exception
            java.lang.String r2 = r8.toString()
        L_0x0075:
            com.huawei.android.pushagent.c.a.e.c(r0, r2, r8)
            goto L_0x007e
        L_0x0079:
            java.lang.String r8 = "ImmersionStyle ClassNotFoundException"
            com.huawei.android.pushagent.c.a.e.d(r0, r8)
        L_0x007e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushselfshow.utils.a.j(android.content.Context):int");
    }

    /* access modifiers changed from: private */
    public static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        int i = -1;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "user_experience_involved", -1);
            e.a("PushSelfShowLog", "settingMainSwitch:" + i);
        } catch (Exception e) {
            e.c("PushSelfShowLog", e.toString(), e);
        }
        return i == 1;
    }
}
