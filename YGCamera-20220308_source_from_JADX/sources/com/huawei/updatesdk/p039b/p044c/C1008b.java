package com.huawei.updatesdk.p039b.p044c;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import com.huawei.updatesdk.p025a.p026a.C0964a;
import com.huawei.updatesdk.p025a.p034b.p035a.C0985a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.b.c.b */
public class C1008b {

    /* renamed from: a */
    private static final Map<Integer, Class<? extends C1009c>> f1367a = new HashMap();

    /* renamed from: b */
    private static C1009c f1368b;

    /* renamed from: c */
    private static int f1369c = -1;

    static {
        f1367a.put(3, C1007a.class);
        f1367a.put(1, C1011e.class);
        f1367a.put(2, C1012f.class);
        f1367a.put(0, C1010d.class);
    }

    /* renamed from: a */
    private static int m1855a(Context context) {
        if (m1858c(context)) {
            return 1;
        }
        if (m1859d(context)) {
            return 2;
        }
        return m1857b(context) ? 3 : 0;
    }

    /* renamed from: a */
    public static C1009c m1856a() {
        C1009c cVar = f1368b;
        if (cVar != null) {
            return cVar;
        }
        Context a = C0985a.m1757c().mo14892a();
        if (f1369c < 0) {
            f1369c = m1855a(a);
        }
        C0964a.m1667b("DeviceImplFactory", "deviceType: " + f1369c);
        Class cls = f1367a.get(Integer.valueOf(f1369c));
        if (cls == null) {
            f1368b = new C1010d();
            return f1368b;
        }
        try {
            f1368b = (C1009c) cls.newInstance();
        } catch (Throwable unused) {
            f1368b = new C1010d();
            C0964a.m1666a("DeviceImplFactory", "createDeviceInfo error and create default phone deviceinfo");
        }
        return f1368b;
    }

    /* renamed from: b */
    private static boolean m1857b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m1858c(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        C0964a.m1667b("DeviceImplFactory", "UI mode: " + uiModeManager.getCurrentModeType());
        return uiModeManager.getCurrentModeType() == 4;
    }

    /* renamed from: d */
    private static boolean m1859d(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        }
        return false;
    }
}
