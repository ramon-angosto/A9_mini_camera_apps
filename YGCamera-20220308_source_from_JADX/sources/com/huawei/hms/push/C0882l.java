package com.huawei.hms.push;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.l */
/* compiled from: NotificationIconUtil */
public class C0882l {
    /* renamed from: a */
    public static int m1276a(Context context) {
        int i = context.getApplicationInfo().icon;
        if (i != 0) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("btn_star_big_on", "drawable", "android");
        HMSLog.m1374d("PushSelfShowLog", "icon is btn_star_big_on ");
        if (identifier != 0) {
            return identifier;
        }
        HMSLog.m1374d("PushSelfShowLog", "icon is sym_def_app_icon ");
        return 17301651;
    }

    /* renamed from: b */
    public static int m1279b(Context context, C0881k kVar) {
        int i = 0;
        if (context == null || kVar == null) {
            HMSLog.m1379i("PushSelfShowLog", "enter getSmallIconId, context or msg is null");
            return 0;
        }
        if (!TextUtils.isEmpty(kVar.mo14316m())) {
            String[] split = kVar.mo14316m().split("/");
            if (split.length == 3) {
                i = C0888r.m1314a(context, split[1], split[2]);
            }
        }
        if (i == 0) {
            i = C0888r.m1313a(context, "com.huawei.messaging.default_notification_icon");
        }
        return i != 0 ? i : m1276a(context);
    }

    /* renamed from: a */
    public static Bitmap m1277a(Context context, C0881k kVar) {
        if (context == null || kVar == null) {
            return null;
        }
        try {
            if (HwBuildEx.VERSION.EMUI_SDK_INT >= 11) {
                HMSLog.m1379i("PushSelfShowLog", "huawei phone, and emui5.0, need not show large icon.");
                return null;
            } else if ("com.huawei.android.pushagent".equals(kVar.mo14313k())) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("get left bitmap from ");
                sb.append(kVar.mo14313k());
                HMSLog.m1379i("PushSelfShowLog", sb.toString());
                return ((BitmapDrawable) context.getPackageManager().getApplicationIcon(kVar.mo14313k())).getBitmap();
            }
        } catch (PackageManager.NameNotFoundException e) {
            HMSLog.m1378e("PushSelfShowLog", "" + e.toString(), (Throwable) e);
            return null;
        } catch (Exception e2) {
            HMSLog.m1378e("PushSelfShowLog", "" + e2.toString(), (Throwable) e2);
            return null;
        }
    }

    /* renamed from: a */
    public static void m1278a(Context context, Notification.Builder builder, C0881k kVar) {
        if (context == null || builder == null || kVar == null) {
            HMSLog.m1377e("PushSelfShowLog", "msg is null");
        } else {
            builder.setSmallIcon(m1279b(context, kVar));
        }
    }
}
