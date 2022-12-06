package com.bytedance.sdk.openadsdk.l;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;

/* compiled from: TestHelperUtils */
public class v {
    private static String a;

    public static boolean c() {
        return false;
    }

    public static boolean a() {
        if (l.d() && h.d().s() && h.d().t()) {
            return true;
        }
        return false;
    }

    public static String a(String str) {
        try {
            if (!a()) {
                return str;
            }
            String u = h.d().u();
            if (TextUtils.isEmpty(u)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=" + u);
            return Uri.parse(str).buildUpon().appendQueryParameter(b(), u).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(a)) {
            a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return a;
    }
}
