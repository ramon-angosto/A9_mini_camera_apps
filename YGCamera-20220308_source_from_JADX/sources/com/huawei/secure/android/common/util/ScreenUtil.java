package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    /* renamed from: t */
    private static final int f1271t = 524288;

    public static void enableScreenshots(Activity activity) {
        m1635b(activity, 8192);
    }

    public static void disableScreenshots(Activity activity) {
        m1634a(activity, 8192);
    }

    /* renamed from: a */
    private static void m1634a(Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.m1614e("", "activity is null");
        } else {
            activity.getWindow().addFlags(i);
        }
    }

    /* renamed from: b */
    private static void m1635b(Activity activity, int i) {
        if (activity == null || activity.isFinishing()) {
            LogsUtil.m1614e("", "activity is null");
        } else {
            activity.getWindow().clearFlags(i);
        }
    }

    public static void hideOverlayWindows(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                Window window = activity.getWindow();
                Method declaredMethod = Class.forName("android.view.Window").getDeclaredMethod("addPrivateFlags", new Class[]{Integer.TYPE});
                AccessController.doPrivileged(new C0951a(declaredMethod));
                declaredMethod.invoke(window, new Object[]{524288});
            } catch (ClassNotFoundException unused) {
                LogsUtil.m1614e(TAG, "hideOverlayWindows ClassNotFoundException");
            } catch (NoSuchMethodException unused2) {
                LogsUtil.m1614e(TAG, "hideOverlayWindows NoSuchMethodException");
            } catch (InvocationTargetException unused3) {
                LogsUtil.m1614e(TAG, "hideOverlayWindows InvocationTargetException");
            } catch (IllegalAccessException unused4) {
                LogsUtil.m1614e(TAG, "hideOverlayWindows IllegalAccessException");
            }
        }
    }

    /* renamed from: com.huawei.secure.android.common.util.ScreenUtil$a */
    private static class C0951a implements PrivilegedAction {

        /* renamed from: u */
        Method f1272u;

        public C0951a(Method method) {
            this.f1272u = method;
        }

        public Object run() {
            Method method = this.f1272u;
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return null;
        }
    }
}
