package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1656bj;
import com.xiaomi.push.C1816g;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.as */
public class C1994as {

    /* renamed from: a */
    public static final Pair<String, String> f3708a = new Pair<>("canShowBadge", "canShowBadge");

    /* renamed from: a */
    private static String f3709a = null;

    /* renamed from: a */
    private static final String[] f3710a = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: b */
    public static final Pair<String, String> f3711b = new Pair<>("canFloat", "canShowFloat");

    /* renamed from: c */
    public static final Pair<String, String> f3712c = new Pair<>("canShowOnKeyguard", "canShowOnKeyguard");

    /* renamed from: d */
    public static final Pair<String, String> f3713d = new Pair<>("canSound", "canSound");

    /* renamed from: e */
    public static final Pair<String, String> f3714e = new Pair<>("canVibrate", "canVibrate");

    /* renamed from: f */
    public static final Pair<String, String> f3715f = new Pair<>("canLights", "canLights");

    /* renamed from: a */
    public static int m5029a(ContentResolver contentResolver) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
            } catch (Exception e) {
                C1524b.m2141a("get user aggregate failed, " + e);
            }
        }
        return 0;
    }

    /* renamed from: a */
    static int m5030a(Context context, String str) {
        return C1816g.m3669b(context, str);
    }

    /* renamed from: a */
    public static <T> T m5031a(Notification notification, String str) {
        if (Build.VERSION.SDK_INT < 19 || notification.extras == null) {
            return null;
        }
        try {
            return notification.extras.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m5032a(Object obj, String str, T t) {
        T t2 = null;
        try {
            if (obj instanceof Notification) {
                t2 = m5031a((Notification) obj, str);
            } else if (obj instanceof Map) {
                t2 = ((Map) obj).get(str);
            } else if (obj instanceof Bundle) {
                t2 = ((Bundle) obj).get(str);
            } else {
                C1524b.m2141a("not support get value from classType:" + obj);
            }
        } catch (Exception e) {
            C1524b.m2141a("get value error " + e);
        }
        return t2 == null ? t : t2;
    }

    /* renamed from: a */
    public static String m5033a(Notification notification) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 19 || notification.extras == null) {
            charSequence = null;
        } else {
            charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: a */
    public static String m5034a(Object obj) {
        return (String) m5032a(obj, "msg_busi_type", "");
    }

    /* renamed from: a */
    static void m5035a(Notification notification, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putInt("miui.messageCount", i);
            }
            Object a = C1656bj.m2696a((Object) notification, "extraNotification");
            if (a != null) {
                C1656bj.m2697a(a, "setMessageCount", Integer.valueOf(i));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static void m5036a(Notification notification, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object a = C1656bj.m2696a((Object) notification, "extraNotification");
            if (a != null) {
                C1656bj.m2697a(a, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static void m5037a(Notification notification, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putBoolean("miui.enableFloat", z);
            }
            Object a = C1656bj.m2696a((Object) notification, "extraNotification");
            if (a != null) {
                C1656bj.m2697a(a, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    static void m5038a(Context context, Intent intent) {
        String str;
        int i = -1;
        while (true) {
            str = i < 0 ? f3709a : f3710a[i];
            if (!TextUtils.isEmpty(str)) {
                intent.setPackage(str);
                try {
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        break;
                    }
                } catch (Exception e) {
                    C1524b.m2141a("not found xm browser:" + e);
                }
            }
            i++;
            if (i >= f3710a.length) {
                str = null;
                break;
            }
        }
        intent.setPackage(str);
        f3709a = str;
    }

    /* renamed from: a */
    public static void m5039a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            C1524b.m2141a("cp map to b fail:" + str);
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    /* renamed from: a */
    public static boolean m5040a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        C1524b.m2158b("not support setGroupAlertBehavior");
        return false;
    }

    /* renamed from: a */
    public static boolean m5041a(ContentResolver contentResolver) {
        int a = m5029a(contentResolver);
        return a == 1 || a == 2;
    }

    /* renamed from: a */
    public static boolean m5042a(Map<String, String> map) {
        return Boolean.parseBoolean((String) m5032a((Object) map, "not_suppress", "true"));
    }

    /* renamed from: a */
    public static Notification.Action[] m5043a(Notification notification) {
        Parcelable[] parcelableArray;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        if (notification.actions != null) {
            return notification.actions;
        }
        if (notification.extras == null || (parcelableArray = notification.extras.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    /* renamed from: b */
    public static String m5044b(Notification notification) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 19 || notification.extras == null) {
            charSequence = null;
        } else {
            charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    /* renamed from: b */
    public static void m5045b(Notification notification, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                notification.extras.putBoolean("miui.enableKeyguard", z);
            }
            Object a = C1656bj.m2696a((Object) notification, "extraNotification");
            if (a != null) {
                C1656bj.m2697a(a, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public static String m5046c(Notification notification) {
        Object a;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 19 && notification.extras != null) {
                str = notification.extras.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE);
            }
            if (TextUtils.isEmpty(str) && (a = C1656bj.m2696a((Object) notification, "extraNotification")) != null) {
                return (String) C1656bj.m2697a(a, "getTargetPkg", new Object[0]);
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
