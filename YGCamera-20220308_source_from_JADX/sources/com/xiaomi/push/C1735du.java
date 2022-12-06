package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.push.service.C1995at;

/* renamed from: com.xiaomi.push.du */
public class C1735du {
    /* renamed from: a */
    private static void m3044a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    /* renamed from: a */
    public static boolean m3045a(Context context, String str, long j) {
        if (C1995at.m5047a(context).mo18472a(C1873ht.DCJobMutualSwitch.mo17806a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !C1616ai.m2513a(context, str, j);
        }
        return false;
    }

    /* renamed from: a */
    public static byte[] m3046a(String str, byte[] bArr) {
        byte[] a = C1660bl.m2714a(str);
        try {
            m3044a(a);
            return C1880i.m3999a(a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m3047b(String str, byte[] bArr) {
        byte[] a = C1660bl.m2714a(str);
        try {
            m3044a(a);
            return C1880i.m4000b(a, bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
