package com.huawei.hms.push;

import android.app.Notification;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.push.m */
/* compiled from: NotificationUtils */
public class C0883m {
    /* renamed from: a */
    public static C0884n m1280a(C0881k kVar) {
        C0884n nVar = C0884n.STYLE_DEFAULT;
        return (kVar.mo14326w() < 0 || kVar.mo14326w() >= C0884n.values().length) ? nVar : C0884n.values()[kVar.mo14326w()];
    }

    /* renamed from: a */
    public static void m1281a(Notification.Builder builder, String str, C0881k kVar) {
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        if (!TextUtils.isEmpty(kVar.mo14307h())) {
            bigTextStyle.setBigContentTitle(kVar.mo14307h());
        }
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
