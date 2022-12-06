package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.push.s */
/* compiled from: CommFun */
public abstract class C0889s {

    /* renamed from: a */
    public static final Object f925a = new Object();

    /* renamed from: b */
    public static int f926b = -1;

    /* renamed from: a */
    public static boolean m1316a(Context context) {
        HMSLog.m1374d("CommFun", "existFrameworkPush:" + f926b);
        try {
            File file = new File("/system/framework/" + "hwpush.jar");
            if (m1315a()) {
                HMSLog.m1374d("CommFun", "push jarFile is exist");
                return true;
            } else if (!file.isFile()) {
                return false;
            } else {
                HMSLog.m1374d("CommFun", "push jarFile is exist");
                return true;
            }
        } catch (Exception e) {
            HMSLog.m1377e("CommFun", "get Apk version faild ,Exception e= " + e.toString());
            return false;
        }
    }

    /* renamed from: b */
    public static long m1318b(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 0).versionCode;
        } catch (Exception unused) {
            HMSLog.m1377e("CommFun", "get nc versionCode error");
            return -1;
        }
    }

    /* renamed from: c */
    public static boolean m1321c() {
        return HwBuildEx.VERSION.EMUI_SDK_INT < 19;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (1 != f926b) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        return r2;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m1322d(android.content.Context r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "existFrameworkPush:"
            r0.append(r1)
            int r1 = f926b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CommFun"
            com.huawei.hms.support.log.HMSLog.m1374d(r1, r0)
            java.lang.Object r0 = f925a
            monitor-enter(r0)
            int r1 = f926b     // Catch:{ all -> 0x003b }
            r2 = 0
            r3 = 1
            r4 = -1
            if (r4 == r1) goto L_0x0029
            int r5 = f926b     // Catch:{ all -> 0x003b }
            if (r3 != r5) goto L_0x0027
            r2 = 1
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return r2
        L_0x0029:
            boolean r5 = m1316a(r5)     // Catch:{ all -> 0x003b }
            if (r5 == 0) goto L_0x0032
            f926b = r3     // Catch:{ all -> 0x003b }
            goto L_0x0034
        L_0x0032:
            f926b = r2     // Catch:{ all -> 0x003b }
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            int r5 = f926b
            if (r3 != r5) goto L_0x003a
            r2 = 1
        L_0x003a:
            return r2
        L_0x003b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.C0889s.m1322d(android.content.Context):boolean");
    }

    /* renamed from: c */
    public static String m1320c(Context context) {
        return AGConnectServicesConfig.fromContext(context).getString("client/project_id");
    }

    /* renamed from: b */
    public static boolean m1319b() {
        return HwBuildEx.VERSION.EMUI_SDK_INT >= 21;
    }

    /* renamed from: a */
    public static boolean m1315a() {
        try {
            Class<?> cls = Class.forName("huawei.cust.HwCfgFilePolicy");
            int intValue = ((Integer) cls.getDeclaredField("CUST_TYPE_CONFIG").get(cls)).intValue();
            Method declaredMethod = cls.getDeclaredMethod("getCfgFile", new Class[]{String.class, Integer.TYPE});
            Object[] objArr = new Object[2];
            objArr[0] = "jars/hwpush.jar";
            objArr[1] = Integer.valueOf(intValue);
            File file = (File) declaredMethod.invoke(cls, objArr);
            if (file != null && file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("get push cust File path is ");
                sb.append(file.getCanonicalPath());
                HMSLog.m1374d("CommFun", sb.toString());
                return true;
            }
        } catch (ClassNotFoundException unused) {
            HMSLog.m1377e("CommFun", "HwCfgFilePolicy ClassNotFoundException");
        } catch (SecurityException unused2) {
            HMSLog.m1377e("CommFun", "check cust exist push SecurityException.");
        } catch (NoSuchFieldException unused3) {
            HMSLog.m1377e("CommFun", "check cust exist push NoSuchFieldException.");
        } catch (NoSuchMethodException unused4) {
            HMSLog.m1377e("CommFun", "check cust exist push NoSuchMethodException.");
        } catch (IllegalArgumentException unused5) {
            HMSLog.m1377e("CommFun", "check cust exist push IllegalArgumentException.");
        } catch (IllegalAccessException unused6) {
            HMSLog.m1377e("CommFun", "check cust exist push IllegalAccessException.");
        } catch (InvocationTargetException unused7) {
            HMSLog.m1377e("CommFun", "check cust exist push InvocationTargetException.");
        } catch (IOException unused8) {
            HMSLog.m1377e("CommFun", "check jarFile exist but get not path");
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1317a(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
