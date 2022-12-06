package com.huawei.updatesdk.p025a.p026a.p031d.p032h;

import android.car.Car;
import android.car.CarInfoManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.updatesdk.p025a.p026a.C0964a;

/* renamed from: com.huawei.updatesdk.a.a.d.h.a */
public class C0976a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Car f1310a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f1311b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f1312c = null;

    /* renamed from: d */
    private static boolean f1313d = false;

    /* renamed from: com.huawei.updatesdk.a.a.d.h.a$a */
    static class C0977a implements ServiceConnection {
        C0977a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                CarInfoManager carInfoManager = (CarInfoManager) C0976a.f1310a.getCarManager("info");
                String unused = C0976a.f1312c = carInfoManager.getManufacturer();
                String unused2 = C0976a.f1311b = carInfoManager.getModel();
                C0964a.m1667b("CarInfoUtil", "car getManufacturer = " + C0976a.f1312c + "  getModel = " + C0976a.f1311b);
            } catch (Throwable th) {
                C0964a.m1666a("CarInfoUtil", "Car not connected in onServiceConnected" + th.toString());
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0964a.m1667b("CarInfoUtil", "onServiceDisconnected");
        }
    }

    /* renamed from: a */
    private static void m1710a(Context context) {
        if (context != null && !f1313d) {
            try {
                f1313d = true;
                f1310a = Car.createCar(context.getApplicationContext(), new C0977a());
                if (f1310a != null) {
                    f1310a.connect();
                }
            } catch (Throwable th) {
                C0964a.m1666a("CarInfoUtil", "Car Service Connect Error" + th.toString());
            }
        }
    }

    /* renamed from: b */
    public static void m1713b(Context context) {
        m1710a(context);
    }

    /* renamed from: d */
    public static String m1715d() {
        return f1312c;
    }

    /* renamed from: e */
    public static String m1716e() {
        return f1311b;
    }
}
