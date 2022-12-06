package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1656bj;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1907j;
import com.xiaomi.push.C1938m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: com.xiaomi.push.service.ar */
public class C1993ar {

    /* renamed from: a */
    private static Context f3702a;

    /* renamed from: a */
    private static Object f3703a;

    /* renamed from: a */
    private static WeakHashMap<Integer, C1993ar> f3704a = new WeakHashMap<>();

    /* renamed from: a */
    private static boolean f3705a;

    /* renamed from: a */
    private String f3706a;

    /* renamed from: b */
    private String f3707b;

    private C1993ar(String str) {
        this.f3706a = str;
    }

    /* renamed from: a */
    private static int mo18456a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f3702a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private static NotificationManager mo18457a() {
        return (NotificationManager) f3702a.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    /* renamed from: a */
    public static C1993ar m5005a(Context context, String str) {
        m5010a(context);
        int hashCode = str.hashCode();
        C1993ar arVar = f3704a.get(Integer.valueOf(hashCode));
        if (arVar != null) {
            return arVar;
        }
        C1993ar arVar2 = new C1993ar(str);
        f3704a.put(Integer.valueOf(hashCode), arVar2);
        return arVar2;
    }

    /* renamed from: a */
    private static <T> T m5006a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static Object m5007a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class}).newInstance(new Object[]{list});
    }

    /* renamed from: a */
    public static String m5008a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a = m5009a("mipush|%s|%s", str2, "");
        return str.startsWith(a) ? m5009a("mipush_%s_%s", str2, str.replace(a, "")) : str;
    }

    /* renamed from: a */
    private static String m5009a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, new Object[]{str2, str3});
    }

    /* renamed from: a */
    private static void m5010a(Context context) {
        if (f3702a == null) {
            f3702a = context.getApplicationContext();
            NotificationManager a = mo18457a();
            Boolean bool = (Boolean) C1656bj.m2697a((Object) a, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            mo18456a("fwk is support.init:" + bool);
            f3705a = bool != null ? bool.booleanValue() : false;
            if (f3705a) {
                f3703a = C1656bj.m2697a((Object) a, "getService", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    static void m5011a(String str) {
        C1524b.m2141a("NMHelper:" + str);
    }

    /* renamed from: a */
    private static boolean m5012a() {
        if (C1938m.m4713a() && C1995at.m5047a(f3702a).mo18472a(C1873ht.NotificationBelongToAppSwitch.mo17806a(), true)) {
            return f3705a;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m5013a(Context context) {
        m5010a(context);
        return mo18457a();
    }

    /* renamed from: a */
    private StatusBarNotification[] m5014a() {
        if (!C1938m.m4714a(mo18457a())) {
            return null;
        }
        try {
            String packageName = mo18457a().getPackageName();
            Object a = C1656bj.m2697a(f3703a, "getActiveNotifications", packageName);
            if (a instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) a;
            }
            return null;
        } catch (Throwable th) {
            mo18456a("getAllNotifications error " + th);
            return null;
        }
    }

    /* renamed from: b */
    private String m5015b(String str) {
        return m5009a(mo18457a() ? "mipush|%s|%s" : "mipush_%s_%s", this.f3706a, str);
    }

    /* renamed from: a */
    public NotificationChannel m5016a(String str) {
        try {
            if (!mo18457a()) {
                return mo18457a().getNotificationChannel(str);
            }
            List<NotificationChannel> a = mo18457a();
            if (a == null) {
                return null;
            }
            for (NotificationChannel notificationChannel : a) {
                if (str.equals(notificationChannel.getId())) {
                    return notificationChannel;
                }
            }
            return null;
        } catch (Exception e) {
            mo18456a("getNotificationChannel error" + e);
            return null;
        }
    }

    /* renamed from: a */
    public Context m5017a() {
        return f3702a;
    }

    /* renamed from: a */
    public String m5018a() {
        return this.f3706a;
    }

    /* renamed from: a */
    public String m5019a(String str) {
        return TextUtils.isEmpty(str) ? mo18462b() : C1938m.m4713a() ? m5015b(str) : str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<NotificationChannel> m5020a() {
        String str;
        String str2 = this.f3706a;
        List<NotificationChannel> list = null;
        try {
            if (mo18457a()) {
                int a = mo18456a(str2);
                if (a != -1) {
                    str = "mipush|%s|%s";
                    list = (List) m5006a(C1656bj.m2697a(f3703a, "getNotificationChannelsForPackage", str2, Integer.valueOf(a), false));
                } else {
                    str = null;
                }
            } else {
                list = mo18457a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!C1938m.m4713a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a2 = m5009a(str, str2, "");
            for (NotificationChannel next : list) {
                if (next.getId().startsWith(a2)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception e) {
            mo18456a("getNotificationChannels error " + e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo18458a(int i) {
        String str = this.f3706a;
        try {
            if (mo18457a()) {
                int a = C1907j.m4548a();
                String packageName = mo18457a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    C1656bj.m2706b(f3703a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i), Integer.valueOf(a));
                } else {
                    C1656bj.m2706b(f3703a, "cancelNotificationWithTag", str, null, Integer.valueOf(i), Integer.valueOf(a));
                }
                mo18456a("cancel succ:" + i);
                return;
            }
            mo18457a().cancel(i);
        } catch (Exception e) {
            mo18456a("cancel error" + e);
        }
    }

    /* renamed from: a */
    public void mo18459a(int i, Notification notification) {
        String str = this.f3706a;
        NotificationManager a = mo18457a();
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (mo18457a()) {
                if (i2 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i2 >= 29) {
                    a.notifyAsPackage(str, (String) null, i, notification);
                    return;
                }
            }
            a.notify(i, notification);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18460a(NotificationChannel notificationChannel) {
        String str = this.f3706a;
        try {
            if (mo18457a()) {
                int a = mo18456a(str);
                if (a != -1) {
                    Object a2 = m5007a(Arrays.asList(new NotificationChannel[]{notificationChannel}));
                    C1656bj.m2706b(f3703a, "createNotificationChannelsForPackage", str, Integer.valueOf(a), a2);
                    return;
                }
                return;
            }
            mo18457a().createNotificationChannel(notificationChannel);
        } catch (Exception e) {
            mo18456a("createNotificationChannel error" + e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18461a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f3706a;
        if (z) {
            try {
                int a = mo18456a(str);
                if (a != -1) {
                    C1656bj.m2706b(f3703a, "updateNotificationChannelForPackage", str, Integer.valueOf(a), notificationChannel);
                }
            } catch (Exception e) {
                mo18456a("updateNotificationChannel error " + e);
            }
        } else {
            mo18460a(notificationChannel);
        }
    }

    /* renamed from: a */
    public boolean m5025a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(m5015b(""));
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo18462b() {
        if (TextUtils.isEmpty(this.f3707b)) {
            this.f3707b = m5015b("default");
        }
        return this.f3707b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo18463b(String str, String str2) {
        return mo18457a() ? str : str2;
    }

    /* renamed from: b */
    public List<StatusBarNotification> m5028b() {
        ArrayList arrayList = null;
        if (Build.VERSION.SDK_INT < 18) {
            return null;
        }
        String str = this.f3706a;
        NotificationManager a = mo18457a();
        try {
            if (mo18457a()) {
                int a2 = C1907j.m4548a();
                if (a2 == -1) {
                    return null;
                }
                return (List) m5006a(C1656bj.m2697a(f3703a, "getAppActiveNotifications", str, Integer.valueOf(a2)));
            }
            StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? a.getActiveNotifications() : mo18457a();
            boolean a3 = C1938m.m4713a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!a3 || str.equals(C1994as.m5046c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                mo18456a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
            mo18456a("getActiveNotifications error " + th);
            return arrayList;
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f3706a + "}";
    }
}
