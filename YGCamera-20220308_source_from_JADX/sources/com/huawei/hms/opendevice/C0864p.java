package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.opendevice.p */
/* compiled from: CommFun */
public class C0864p {
    /* renamed from: a */
    public static boolean m1177a() {
        int i = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.m1374d("CommFun", "Emui Api Level:" + i);
        return i > 0;
    }

    /* renamed from: b */
    public static long m1178b(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 0).versionCode;
        } catch (Exception unused) {
            HMSLog.m1377e("CommFun", "get nc versionCode error");
            return -1;
        }
    }

    /* renamed from: c */
    public static boolean m1179c(Context context) {
        return m1177a() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && m1178b(context) < 110001400;
    }

    /* renamed from: a */
    public static String m1176a(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 24) {
            str = context.createDeviceProtectedStorageContext().getDataDir() + "";
        } else {
            str = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(str)) {
            HMSLog.m1377e("CommFun", "get storage root path of the current user failed.");
        }
        return str;
    }
}
