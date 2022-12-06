package com.huawei.android.pushagent.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.android.microkernel.MKService;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.c.b.b;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class a {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static int b = -1;

    private static boolean A(Context context) {
        String z = z(context);
        e.a("PushLogAC2705", "signStr hashCode is :" + z.hashCode());
        return -735404696 == z.hashCode();
    }

    public static int a(int i, int i2) {
        e.a("PushLogAC2705", "enter ctrlSockets(cmd:" + i + " param:" + i2 + ")");
        try {
            return ((Integer) Class.forName("dalvik.system.Zygote").getMethod("ctrlSockets", new Class[]{Integer.TYPE, Integer.TYPE}).invoke((Object) null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            e.a("PushLogAC2705", "There is no method of ctrlSockets.");
            return -2;
        }
    }

    public static int a(Socket socket) throws ClassNotFoundException {
        try {
            return ((Integer) FileDescriptor.class.getMethod("getInt$", new Class[0]).invoke((FileDescriptor) Socket.class.getMethod("getFileDescriptor$", new Class[0]).invoke(socket, new Object[0]), new Object[0])).intValue();
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            e.a("PushLogAC2705", "There is no method of ctrlSockets.");
            return 0;
        }
    }

    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return -1;
        } catch (ParseException e) {
            e.d("PushLogAC2705", "ParseException,timeStr:" + str + " e:" + e.toString());
            return -1;
        }
    }

    public static ResolveInfo a(Context context, Intent intent) {
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 640);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return null;
        }
        return queryBroadcastReceivers.get(0);
    }

    public static String a() {
        StringBuilder sb;
        String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        if (replace.length() > 15) {
            sb = new StringBuilder();
            sb.append("_");
            replace = replace.substring(0, 15);
        } else {
            sb = new StringBuilder();
            sb.append("_");
            sb.append("000000000000000".substring(15 - replace.length()));
        }
        sb.append(replace);
        return sb.toString();
    }

    public static String a(byte b2) {
        char[] cArr = a;
        return new String(new char[]{cArr[(b2 & 240) >> 4], cArr[b2 & 15]});
    }

    public static String a(long j, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(j));
        } catch (Exception e) {
            e.d("PushLogAC2705", "getTimeString,milliseconds:" + j + " e:" + e.toString());
            return "";
        }
    }

    public static String a(Context context) {
        String d = d(context);
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        String b2 = b(context);
        f.a(context, "device_info", "deviceId", b2);
        return b2;
    }

    public static String a(Context context, String str, String str2) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 640);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    Object obj = applicationInfo.metaData.get(str2);
                    if (obj == null) {
                        e.b("PushLogAC2705", "could not read meta-data from AndroidManifest.xml.");
                        return null;
                    }
                    String valueOf = String.valueOf(obj);
                    e.a("PushLogAC2705", "read meta-data from AndroidManifest.xml,name is:" + str2 + ",value is:" + valueOf);
                    return valueOf;
                }
            }
            e.a("PushLogAC2705", "could not read Applicationinfo from AndroidManifest.xml.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e.c("PushLogAC2705", e.toString(), e);
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(b2 & 240) >> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static ArrayList a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        int size = queryBroadcastReceivers == null ? 0 : queryBroadcastReceivers.size();
        ArrayList arrayList = new ArrayList();
        if (size <= 0) {
            return arrayList;
        }
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo = queryBroadcastReceivers.get(i);
            arrayList.add((resolveInfo.activityInfo != null ? resolveInfo.activityInfo : resolveInfo.serviceInfo).packageName);
        }
        return arrayList;
    }

    public static void a(Context context, int i) {
        if (i == 1) {
            x(context);
            l(context);
        } else if (i == 2) {
            k(context);
            x(context);
            y(context);
        } else if (i == 3) {
            x(context);
            y(context);
            c.a(context).a();
            c.a(context).b();
            return;
        } else {
            return;
        }
        c.a(context).a();
        c.a(context).b();
        com.huawei.android.pushagent.b.b.a.b(context);
    }

    public static void a(Context context, long j) {
        e.a("PushLogAC2705", "enter wakeSystem");
        ((PowerManager) context.getSystemService("power")).newWakeLock(1, "pushagent").acquire(j);
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            a(context, MKService.getAppContext() == null ? "com.huawei.android.pushagent.PushBootReceiver" : "com.huawei.deviceCloud.microKernel.push.PushBootReceiver", z);
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            e.a("PushLogAC2705", "setReceiverState:" + context.getPackageName() + ",isEnable:" + z);
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, str), !z ? 2 : 1, 1);
                return true;
            } catch (Exception e) {
                e.c("PushLogAC2705", e.toString(), e);
            }
        }
        return false;
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr[length] = (byte) ((int) j);
            j >>= 8;
        }
        return bArr;
    }

    public static int b(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] << 24) & 255) | ((bArr[1] << 16) & 255) | ((bArr[2] << 8) & 255);
    }

    public static String b(Context context) {
        String c = c(context);
        return TextUtils.isEmpty(c) ? a() : c;
    }

    public static List b(Context context, String str) {
        return context.getPackageManager().queryBroadcastReceivers(new Intent(str), 640);
    }

    public static void b() {
        e.a("PushLogAC2705", "enter powerLow");
        try {
            Class.forName("android.util.LogPower").getMethod("push", new Class[]{Integer.TYPE}).invoke((Object) null, new Object[]{119});
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            e.a("PushLogAC2705", "need not support LogPower");
        }
    }

    private static boolean b(Context context, boolean z) {
        String str;
        e.a("PushLogAC2705", "existFrameworkPush:" + b + ",realCheck:" + z);
        if (!z) {
            return 1 == b;
        }
        try {
            if (new File("/system/framework/" + "hwpush.jar").isFile()) {
                str = "push jarFile is exist";
            } else {
                e.b("PushLogAC2705", "push jarFile is not exist");
                if (!SystemProperties.getBoolean("ro.config.push_enable", "CN".equals(SystemProperties.get("ro.product.locale.region")))) {
                    e.a("PushLogAC2705", "framework not support push");
                    return false;
                }
                String str2 = SystemProperties.get("ro.build.version.emui", "-1");
                if (TextUtils.isEmpty(str2) || (!str2.contains("2.0") && !str2.contains("2.3"))) {
                    e.a("PushLogAC2705", "can not use framework push");
                    return false;
                }
                str = "emui is 2.0 or 2.3";
            }
            e.a("PushLogAC2705", str);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent().setClassName("android", "com.huawei.android.pushagentproxy.PushService"), 128);
            if (queryIntentServices != null) {
                if (queryIntentServices.size() != 0) {
                    e.b("PushLogAC2705", "framework push exist, use framework push first");
                    return true;
                }
            }
            e.b("PushLogAC2705", "framework push not exist, need vote apk or sdk to support pushservice");
            return false;
        } catch (Exception e) {
            e.d("PushLogAC2705", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static int c(byte[] bArr) {
        return (bArr[1] & 255) | ((bArr[0] & 255) << 8);
    }

    public static String c() {
        String str;
        Class[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
            String str2 = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            e.a("PushLogAC2705", "get EMUI version is:" + str2);
            return !TextUtils.isEmpty(str2) ? str2 : "";
        } catch (ClassNotFoundException unused) {
            str = " getEmuiVersion wrong, ClassNotFoundException";
            e.d("PushLogAC2705", str);
            return "";
        } catch (LinkageError unused2) {
            str = " getEmuiVersion wrong, LinkageError";
            e.d("PushLogAC2705", str);
            return "";
        } catch (NoSuchMethodException unused3) {
            str = " getEmuiVersion wrong, NoSuchMethodException";
            e.d("PushLogAC2705", str);
            return "";
        } catch (NullPointerException unused4) {
            str = " getEmuiVersion wrong, NullPointerException";
            e.d("PushLogAC2705", str);
            return "";
        } catch (IllegalAccessException unused5) {
            str = " getEmuiVersion wrong, IllegalAccessException";
            e.d("PushLogAC2705", str);
            return "";
        } catch (IllegalArgumentException unused6) {
            str = " getEmuiVersion wrong, IllegalArgumentException";
            e.d("PushLogAC2705", str);
            return "";
        } catch (InvocationTargetException unused7) {
            str = " getEmuiVersion wrong, InvocationTargetException";
            e.d("PushLogAC2705", str);
            return "";
        }
    }

    public static String c(Context context) {
        String str;
        boolean ae = com.huawei.android.pushagent.b.b.a.a(context).ae();
        e.a("PushLogAC2705", "isMultiSimEnabledFromServer:" + ae);
        if (!b.b() || !ae) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getDeviceId() : "";
        } else {
            e.a("PushLogAC2705", "multicard device");
            str = b.a().a(0);
        }
        if (TextUtils.isEmpty(str) || str.matches("[0]+")) {
            e.b("PushLogAC2705", "get uniqueId from device is empty or all 0");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() >= 16) {
            return str.substring(str.length() - 16);
        }
        stringBuffer.append(PushConstants.PUSH_TYPE_NOTIFY);
        stringBuffer.append(str);
        if (stringBuffer.length() < 16) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i = 0; i < 16 - stringBuffer.length(); i++) {
                stringBuffer2.append(PushConstants.PUSH_TYPE_NOTIFY);
            }
            stringBuffer.append(stringBuffer2);
        }
        return stringBuffer.toString();
    }

    public static boolean c(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (a(context, new Intent("com.huawei.android.push.intent.REGISTRATION").setPackage(str)) != null) {
            z = true;
        }
        e.a("PushLogAC2705", "isPushClient:" + z);
        return z;
    }

    public static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 56) | 0 | ((((long) bArr[1]) & 255) << 48) | ((((long) bArr[2]) & 255) << 40) | ((((long) bArr[3]) & 255) << 32) | ((((long) bArr[4]) & 255) << 24) | ((((long) bArr[5]) & 255) << 16) | ((((long) bArr[6]) & 255) << 8) | (255 & ((long) bArr[7]));
    }

    public static String d(Context context) {
        e.a("PushLogAC2705", "enter getImeiFromLocalFile()");
        String a2 = f.a(context, "device_info", "deviceId");
        if (TextUtils.isEmpty(a2) || 16 != a2.length()) {
            e.c("PushLogAC2705", "no deviceId in device_info");
            return a2;
        }
        e.a("PushLogAC2705", "get imei from localFile success");
        return a2;
    }

    public static boolean d(Context context, String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (a(context, new Intent("com.huawei.android.push.intent.REGISTER").setPackage(str)) != null) {
            z = true;
        }
        e.a("PushLogAC2705", "hasPushRegister:" + z);
        return z;
    }

    public static boolean e(Context context) {
        String str;
        String d = d(context);
        e.a("PushLogAC2705", "imei from localfile is " + com.huawei.android.pushagent.c.a.a.e.a(d));
        String c = c(context);
        e.a("PushLogAC2705", "deviceId from device is " + com.huawei.android.pushagent.c.a.a.e.a(c));
        String m = m(context);
        String n = n(context);
        e.a("PushLogAC2705", "mac from localfile is " + com.huawei.android.pushagent.c.a.a.e.a(m));
        e.a("PushLogAC2705", "mac from device is " + com.huawei.android.pushagent.c.a.a.e.a(n));
        if (TextUtils.isEmpty(d) || TextUtils.isEmpty(c)) {
            if (TextUtils.isEmpty(d)) {
                f.a(context, "device_info", "deviceId", b(context));
            }
            if (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) {
                if (TextUtils.isEmpty(m) && !TextUtils.isEmpty(n)) {
                    f.a(context, "device_info", "macAddress", n);
                }
                return false;
            } else if (m.equals(n)) {
                return false;
            } else {
                str = "After check mac, it is cloned, need reset files";
            }
        } else if (d.equals(c)) {
            return false;
        } else {
            str = "After check imei, it is cloned, need reset files";
        }
        e.c("PushLogAC2705", str);
        return true;
    }

    public static boolean e(Context context, String str) {
        String str2 = context.getCacheDir().getParent() + "/shared_prefs/" + str + ".xml";
        File file = new File(str2);
        if (file.exists() && file.isFile() && file.canWrite()) {
            e.a("PushLogAC2705", "enter deletePrefrence(fileName:" + str + ".xml)");
            return file.delete();
        } else if (!file.exists()) {
            return false;
        } else {
            e.d("PushLogAC2705", "delete File:" + str2 + " failed!!");
            return false;
        }
    }

    public static String f(Context context, String str) {
        String a2 = a(context, str, "CHANNEL");
        if (a2 == null) {
            return str;
        }
        String str2 = str + "#" + a2;
        e.a("PushLogAC2705", "after add downloadChannel, the new packageName is:" + str2);
        return str2;
    }

    public static void f(Context context) {
        if (e(context)) {
            new Thread(new b(context)).start();
        }
    }

    public static String g(Context context) {
        return String.valueOf(2705);
    }

    public static boolean g(Context context, String str) {
        if (!(context == null || str == null || "".equals(str))) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 0) == null) {
                    return false;
                }
                e.a("PushLogAC2705", str + " is installed");
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static String h(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null) {
            return "";
        }
        char[] charArray = simOperator.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                return simOperator.substring(0, i);
            }
        }
        return simOperator;
    }

    public static String i(Context context) {
        return a(context) + "0000000000000000";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r2 = r2.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 != 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r1 = "connectivity"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2
            if (r2 == 0) goto L_0x001a
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = r2.getExtraInfo()
            goto L_0x001b
        L_0x001a:
            r2 = r0
        L_0x001b:
            if (r2 != 0) goto L_0x001e
            r2 = r0
        L_0x001e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "push apn is "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PushLogAC2705"
            com.huawei.android.pushagent.c.a.e.a(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.a.j(android.content.Context):java.lang.String");
    }

    public static void k(Context context) {
        try {
            com.huawei.android.pushagent.b.b.a.a(context).c.clear();
            com.huawei.android.pushagent.b.e.b.a(context).a.clear();
            com.huawei.android.pushagent.b.d.a.b(context).a();
        } catch (Exception unused) {
            e.d("PushLogAC2705", "clearMemory failed!");
        }
    }

    public static void l(Context context) {
        h hVar = new h(context, "pclient_info_v2");
        for (String str : hVar.b().keySet()) {
            if (!g(context, str)) {
                hVar.f(str);
            }
        }
    }

    public static String m(Context context) {
        e.a("PushLogAC2705", "enter getMacFromLocalFile()");
        String a2 = f.a(context, "device_info", "macAddress");
        if (!TextUtils.isEmpty(a2)) {
            e.a("PushLogAC2705", "get macAddress from LocalFile success");
            return a2;
        }
        e.c("PushLogAC2705", "no macAddress in device_info");
        return a2;
    }

    public static String n(Context context) {
        e.a("PushLogAC2705", "enter getMacAddress()");
        String str = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                e.c("PushLogAC2705", "info = null");
                return str;
            }
            str = connectionInfo.getMacAddress();
            if (!TextUtils.isEmpty(str)) {
                e.a("PushLogAC2705", "get Mac from device success");
            } else {
                e.c("PushLogAC2705", "Mac is empty");
            }
            return str;
        } catch (Exception e) {
            e.c("PushLogAC2705", "getLocalMacAddress() exception,e=" + e.toString(), e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean o(android.content.Context r5) {
        /*
            java.lang.Class<com.huawei.android.pushagent.c.a> r0 = com.huawei.android.pushagent.c.a.class
            monitor-enter(r0)
            java.lang.String r1 = "PushLogAC2705"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x003b }
            r2.<init>()     // Catch:{ all -> 0x003b }
            java.lang.String r3 = "existFrameworkPush:"
            r2.append(r3)     // Catch:{ all -> 0x003b }
            int r3 = b     // Catch:{ all -> 0x003b }
            r2.append(r3)     // Catch:{ all -> 0x003b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003b }
            com.huawei.android.pushagent.c.a.e.a(r1, r2)     // Catch:{ all -> 0x003b }
            r1 = -1
            int r2 = b     // Catch:{ all -> 0x003b }
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L_0x0029
            int r5 = b     // Catch:{ all -> 0x003b }
            if (r4 != r5) goto L_0x0027
            r3 = 1
        L_0x0027:
            monitor-exit(r0)
            return r3
        L_0x0029:
            boolean r5 = b((android.content.Context) r5, (boolean) r4)     // Catch:{ all -> 0x003b }
            if (r5 == 0) goto L_0x0032
            b = r4     // Catch:{ all -> 0x003b }
            goto L_0x0034
        L_0x0032:
            b = r3     // Catch:{ all -> 0x003b }
        L_0x0034:
            int r5 = b     // Catch:{ all -> 0x003b }
            if (r4 != r5) goto L_0x0039
            r3 = 1
        L_0x0039:
            monitor-exit(r0)
            return r3
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.pushagent.c.a.o(android.content.Context):boolean");
    }

    public static void p(Context context) {
        try {
            if ("com.huawei.android.pushagent".equals(context.getPackageName()) && !A(context)) {
                e.d("PushLogAC2705", "signature of apk HwPushService is not test");
                Toast.makeText(context, "Signature of HwPushService is not correct", 1).show();
            }
        } catch (Exception e) {
            e.a("PushLogAC2705", "checkAPKSignature error", (Throwable) e);
        }
    }

    public static int q(Context context) {
        int c = new h(context, "pushConfig").c("NeedMyServiceRun");
        if (c < 0 || c > 2) {
            c = 0;
        }
        e.a("PushLogAC2705", "in file needMyServiceRun is : " + c);
        return c;
    }

    public static String r(Context context) {
        return new h(context, "pushConfig").b("votedPackageName");
    }

    /* access modifiers changed from: private */
    public static void v(Context context) {
        e.a("PushLogAC2705", "update deviceInfo File");
        new h(context, "device_info").c();
        String b2 = b(context);
        String n = n(context);
        f.a(context, "device_info", "deviceId", b2);
        f.a(context, "device_info", "macAddress", n);
    }

    /* access modifiers changed from: private */
    public static void w(Context context) {
        h hVar = new h(context, "pclient_request_info");
        h hVar2 = new h(context, "pclient_info_v2");
        for (String str : hVar2.b().keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hVar.a(str, "true");
                e.a("PushLogAC2705", "pkg : " + str + " need register again");
            }
        }
        hVar2.c();
    }

    /* access modifiers changed from: private */
    public static void x(Context context) {
        e(context, "PushConnectControl");
        e(context, "PushRouteInfo");
        e(context, "RouteInfo");
        e(context, "HeartBeatCfg");
        for (String e : com.huawei.android.pushagent.b.a.a.a(context).a()) {
            e(context, e);
        }
        e(context, "socket_info");
        e(context, "update_remind");
    }

    private static void y(Context context) {
        e(context, "pclient_request_info");
        e(context, "pclient_unRegist_info_v2");
        e(context, "pclient_info_v2");
        e(context, "pclient_info");
    }

    private static String z(Context context) {
        if (context == null) {
            return "";
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            StringBuffer stringBuffer = new StringBuffer();
            if (signatureArr != null) {
                for (Signature charsString : signatureArr) {
                    stringBuffer.append(charsString.toCharsString());
                }
                e.a("PushLogAC2705", "Signature len is :" + signatureArr.length);
            }
            return stringBuffer.toString();
        } catch (PackageManager.NameNotFoundException unused) {
            e.d("PushLogAC2705", "package with the given name can not be found");
            return "";
        }
    }
}
