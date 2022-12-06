package com.ironsource.mediationsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class h implements Runnable {
    private final String A = "mnc";
    private final String B = "icc";
    private final String C = "tz";
    private final String D = "auid";
    private Context E;
    private final String a = getClass().getSimpleName();
    private final String b = "bundleId";
    private final String c = "advertisingId";
    private final String d = "isLimitAdTrackingEnabled";
    private final String e = "appKey";
    private final String f = "deviceOS";
    private final String g = "osVersion";
    private final String h = "connectionType";
    private final String i = "language";
    private final String j = "deviceOEM";
    private final String k = "deviceModel";
    private final String l = "mobileCarrier";
    private final String m = "externalFreeMemory";
    private final String n = "internalFreeMemory";
    private final String o = "battery";
    private final String p = "gmtMinutesOffset";
    private final String q = "appVersion";
    private final String r = "sessionId";
    private final String s = "pluginType";
    private final String t = "pluginVersion";
    private final String u = "plugin_fw_v";
    private final String v = "jb";
    private final String w = "advertisingIdType";
    private final String x = "mt";
    private final String y = "firstSession";
    private final String z = "mcc";

    private h() {
    }

    public h(Context context) {
        this.E = context.getApplicationContext();
    }

    private static String a() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e2);
            return "";
        }
    }

    private static String b() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e2);
            return "";
        }
    }

    private static String c() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e2);
            return "";
        }
    }

    private String d() {
        try {
            return this.E.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String e() {
        try {
            String str = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            return i2 + "(" + str + ")";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String f() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String h() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private String i() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            return !networkOperatorName.equals("") ? networkOperatorName : "";
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getMobileCarrier()", e2);
            return "";
        }
    }

    private static boolean j() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    private static long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
        } catch (Exception unused) {
            return -1;
        }
    }

    private int l() {
        try {
            Intent registerReceiver = this.E.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i2 = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            if (registerReceiver != null) {
                i2 = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i2 == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i2)) * 100.0f);
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getBatteryLevel()", e2);
            return -1;
        }
    }

    private int m() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round((float) (((timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15)) * 15;
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getGmtMinutesOffset()", e2);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b8 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00df A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ee A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fd A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0115 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0132 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x015a A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x015b A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015e A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0171 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0180 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x018f A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a2 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b3 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c8 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01d9 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0208 A[Catch:{ Exception -> 0x0244 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0217 A[Catch:{ Exception -> 0x0244 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0244 }
            r0.<init>()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSessionId()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r2 = "sessionId"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = r9.d()     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x002e
            java.lang.String r2 = "bundleId"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
            android.content.Context r2 = r9.E     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = com.ironsource.environment.c.c(r2, r1)     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x002e
            java.lang.String r2 = "appVersion"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x002e:
            java.lang.String r1 = "appKey"
            com.ironsource.mediationsdk.H r2 = com.ironsource.mediationsdk.H.a()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r2 = r2.j     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0244 }
            android.content.Context r1 = r9.E     // Catch:{ Exception -> 0x0244 }
            java.lang.String[] r1 = com.ironsource.environment.h.C(r1)     // Catch:{ Exception -> 0x0244 }
            r2 = 1
            java.lang.String r3 = ""
            r4 = 0
            if (r1 == 0) goto L_0x0060
            int r5 = r1.length     // Catch:{ Exception -> 0x0244 }
            r6 = 2
            if (r5 != r6) goto L_0x0060
            r5 = r1[r4]     // Catch:{ Exception -> 0x0244 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0244 }
            if (r5 != 0) goto L_0x0054
            r5 = r1[r4]     // Catch:{ Exception -> 0x0244 }
            goto L_0x0055
        L_0x0054:
            r5 = r3
        L_0x0055:
            r1 = r1[r2]     // Catch:{ Exception -> 0x0244 }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0244 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0244 }
            goto L_0x0062
        L_0x0060:
            r5 = r3
            r1 = r4
        L_0x0062:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0244 }
            if (r6 != 0) goto L_0x006b
            java.lang.String r3 = "GAID"
            goto L_0x0079
        L_0x006b:
            android.content.Context r5 = r9.E     // Catch:{ Exception -> 0x0244 }
            java.lang.String r5 = com.ironsource.environment.h.x(r5)     // Catch:{ Exception -> 0x0244 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0244 }
            if (r6 != 0) goto L_0x0079
            java.lang.String r3 = "UUID"
        L_0x0079:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0244 }
            if (r6 != 0) goto L_0x0092
            java.lang.String r6 = "advertisingId"
            r0.put(r6, r5)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r5 = "advertisingIdType"
            r0.put(r5, r3)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r3 = "isLimitAdTrackingEnabled"
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0244 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x0092:
            java.lang.String r1 = "deviceOS"
            java.lang.String r3 = "Android"
            r0.put(r1, r3)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = e()     // Catch:{ Exception -> 0x0244 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r1 != 0) goto L_0x00ac
            java.lang.String r1 = "osVersion"
            java.lang.String r3 = e()     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x0244 }
        L_0x00ac:
            android.content.Context r1 = r9.E     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.getConnectionType(r1)     // Catch:{ Exception -> 0x0244 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r3 != 0) goto L_0x00bd
            java.lang.String r3 = "connectionType"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x00bd:
            java.lang.String r1 = "sdkVersion"
            java.lang.String r3 = com.ironsource.mediationsdk.utils.IronSourceUtils.getSDKVersion()     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = f()     // Catch:{ Exception -> 0x0244 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r3 != 0) goto L_0x00d5
            java.lang.String r3 = "language"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x00d5:
            java.lang.String r1 = g()     // Catch:{ Exception -> 0x0244 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r3 != 0) goto L_0x00e4
            java.lang.String r3 = "deviceOEM"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x00e4:
            java.lang.String r1 = h()     // Catch:{ Exception -> 0x0244 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r3 != 0) goto L_0x00f3
            java.lang.String r3 = "deviceModel"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x00f3:
            java.lang.String r1 = r9.i()     // Catch:{ Exception -> 0x0244 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r3 != 0) goto L_0x0102
            java.lang.String r3 = "mobileCarrier"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x0102:
            long r5 = k()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = "internalFreeMemory"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x0244 }
            boolean r1 = j()     // Catch:{ Exception -> 0x0244 }
            if (r1 == 0) goto L_0x0132
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0244 }
            android.os.StatFs r3 = new android.os.StatFs     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = r1.getPath()     // Catch:{ Exception -> 0x0244 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0244 }
            int r1 = r3.getBlockSize()     // Catch:{ Exception -> 0x0244 }
            long r5 = (long) r1     // Catch:{ Exception -> 0x0244 }
            int r1 = r3.getAvailableBlocks()     // Catch:{ Exception -> 0x0244 }
            long r7 = (long) r1     // Catch:{ Exception -> 0x0244 }
            long r7 = r7 * r5
            r5 = 1048576(0x100000, double:5.180654E-318)
            long r7 = r7 / r5
            goto L_0x0134
        L_0x0132:
            r7 = -1
        L_0x0134:
            java.lang.String r1 = "externalFreeMemory"
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x0244 }
            int r1 = r9.l()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r3 = "battery"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0244 }
            r0.put(r3, r1)     // Catch:{ Exception -> 0x0244 }
            int r1 = r9.m()     // Catch:{ Exception -> 0x0244 }
            r3 = 840(0x348, float:1.177E-42)
            if (r1 > r3) goto L_0x015b
            r3 = -720(0xfffffffffffffd30, float:NaN)
            if (r1 < r3) goto L_0x015b
            int r3 = r1 % 15
            if (r3 != 0) goto L_0x015b
            goto L_0x015c
        L_0x015b:
            r2 = r4
        L_0x015c:
            if (r2 == 0) goto L_0x0167
            java.lang.String r2 = "gmtMinutesOffset"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0244 }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x0167:
            java.lang.String r1 = a()     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x0176
            java.lang.String r2 = "pluginType"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x0176:
            java.lang.String r1 = b()     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x0185
            java.lang.String r2 = "pluginVersion"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x0185:
            java.lang.String r1 = c()     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x0194
            java.lang.String r2 = "plugin_fw_v"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x0194:
            boolean r1 = com.ironsource.environment.h.j()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x01a7
            java.lang.String r2 = "jb"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x01a7:
            com.ironsource.mediationsdk.H r1 = com.ironsource.mediationsdk.H.a()     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = r1.o     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x01b8
            java.lang.String r2 = "mt"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x01b8:
            android.content.Context r1 = r9.E     // Catch:{ Exception -> 0x0244 }
            boolean r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.getFirstSession(r1)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x01cd
            java.lang.String r2 = "firstSession"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x01cd:
            android.content.Context r1 = r9.E     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = com.ironsource.environment.h.y(r1)     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x01de
            java.lang.String r2 = "auid"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x01de:
            java.lang.String r1 = "mcc"
            android.content.Context r2 = r9.E     // Catch:{ Exception -> 0x0244 }
            int r2 = com.ironsource.environment.a.AnonymousClass1.c((android.content.Context) r2)     // Catch:{ Exception -> 0x0244 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = "mnc"
            android.content.Context r2 = r9.E     // Catch:{ Exception -> 0x0244 }
            int r2 = com.ironsource.environment.a.AnonymousClass1.d(r2)     // Catch:{ Exception -> 0x0244 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0244 }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x0244 }
            android.content.Context r1 = r9.E     // Catch:{ Exception -> 0x0244 }
            java.lang.String r1 = com.ironsource.environment.h.j(r1)     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x020d
            java.lang.String r2 = "icc"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x020d:
            java.lang.String r1 = com.ironsource.environment.h.c()     // Catch:{ Exception -> 0x0244 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0244 }
            if (r2 != 0) goto L_0x021c
            java.lang.String r2 = "tz"
            r0.put(r2, r1)     // Catch:{ Exception -> 0x0244 }
        L_0x021c:
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0244 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0244 }
            java.lang.String r3 = "collecting data for events: "
            r2.<init>(r3)     // Catch:{ Exception -> 0x0244 }
            r2.append(r0)     // Catch:{ Exception -> 0x0244 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0244 }
            r1.verbose(r2)     // Catch:{ Exception -> 0x0244 }
            com.ironsource.mediationsdk.sdk.e r1 = com.ironsource.mediationsdk.sdk.e.a()     // Catch:{ Exception -> 0x0244 }
            r1.a((java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x0244 }
            android.content.Context r0 = r9.E     // Catch:{ Exception -> 0x0244 }
            com.ironsource.mediationsdk.sdk.e r1 = com.ironsource.mediationsdk.sdk.e.a()     // Catch:{ Exception -> 0x0244 }
            org.json.JSONObject r1 = r1.b()     // Catch:{ Exception -> 0x0244 }
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveGeneralProperties(r0, r1)     // Catch:{ Exception -> 0x0244 }
            return
        L_0x0244:
            r0 = move-exception
            com.ironsource.mediationsdk.logger.IronSourceLoggerManager r1 = com.ironsource.mediationsdk.logger.IronSourceLoggerManager.getLogger()
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r2 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.NATIVE
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Thread name = "
            r3.<init>(r4)
            java.lang.Class r4 = r9.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.logException(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.h.run():void");
    }
}
