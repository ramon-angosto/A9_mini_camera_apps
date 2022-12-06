package com.huawei.hms.hatool;

import android.util.Log;

/* renamed from: com.huawei.hms.hatool.z */
public class C0843z {

    /* renamed from: a */
    public boolean f775a = false;

    /* renamed from: b */
    public int f776b = 4;

    /* renamed from: a */
    public static String m1105a() {
        return "HiAnalyticsSDK_2.2.0.308" + C0803i1.m869a();
    }

    /* renamed from: a */
    public void mo14153a(int i) {
        Log.i("HiAnalyticsSDK", 10 + "=======================================\n " + m1105a() + "" + "\n=======================================");
        this.f776b = i;
        this.f775a = true;
    }

    /* renamed from: a */
    public void mo14154a(int i, String str, String str2) {
        if (i == 3) {
            Log.d(str, str2);
        } else if (i == 5) {
            Log.w(str, str2);
        } else if (i != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* renamed from: b */
    public void mo14155b(int i, String str, String str2) {
        mo14154a(i, "HiAnalyticsSDK", str + "=> " + str2);
    }

    /* renamed from: b */
    public boolean mo14156b(int i) {
        return this.f775a && i >= this.f776b;
    }
}
