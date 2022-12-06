package com.bytedance.sdk.openadsdk.l;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.b;

/* compiled from: OpenUtils */
public class m {
    public static void a(Activity activity, String str) {
        if (c(activity, str)) {
            b.a(activity, new Intent("android.intent.action.VIEW", Uri.parse(str)), (b.a) null);
        }
    }

    public static boolean b(Activity activity, String str) {
        if (!c(activity, str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        try {
            activity.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean c(Activity activity, String str) {
        return a(activity) && !TextUtils.isEmpty(str);
    }

    public static boolean a(Activity activity) {
        return activity != null && !activity.isDestroyed() && !activity.isFinishing();
    }
}
