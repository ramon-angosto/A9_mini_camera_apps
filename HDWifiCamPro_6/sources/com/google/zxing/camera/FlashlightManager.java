package com.google.zxing.camera;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class FlashlightManager {
    private static final String TAG = FlashlightManager.class.getSimpleName();
    private static final Object iHardwareService = getHardwareService();
    private static final Method setFlashEnabledMethod = getSetFlashEnabledMethod(iHardwareService);

    static {
        if (iHardwareService == null) {
            Log.v(TAG, "This device does supports control of a flashlight");
        } else {
            Log.v(TAG, "This device does not support control of a flashlight");
        }
    }

    private FlashlightManager() {
    }

    static void enableFlashlight() {
        setFlashlight(false);
    }

    static void disableFlashlight() {
        setFlashlight(false);
    }

    private static Object getHardwareService() {
        Method maybeGetMethod;
        Object invoke;
        Class<?> maybeForName;
        Method maybeGetMethod2;
        Class<?> maybeForName2 = maybeForName("android.os.ServiceManager");
        if (maybeForName2 == null || (maybeGetMethod = maybeGetMethod(maybeForName2, "getService", String.class)) == null || (invoke = invoke(maybeGetMethod, (Object) null, "hardware")) == null || (maybeForName = maybeForName("android.os.IHardwareService$Stub")) == null || (maybeGetMethod2 = maybeGetMethod(maybeForName, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return invoke(maybeGetMethod2, (Object) null, invoke);
    }

    private static Method getSetFlashEnabledMethod(Object obj) {
        if (obj == null) {
            return null;
        }
        return maybeGetMethod(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    private static Class<?> maybeForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e) {
            String str2 = TAG;
            Log.w(str2, "Unexpected error while finding class " + str, e);
            return null;
        }
    }

    private static Method maybeGetMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e) {
            String str2 = TAG;
            Log.w(str2, "Unexpected error while finding method " + str, e);
            return null;
        }
    }

    private static Object invoke(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            String str = TAG;
            Log.w(str, "Unexpected error while invoking " + method, e);
            return null;
        } catch (InvocationTargetException e2) {
            String str2 = TAG;
            Log.w(str2, "Unexpected error while invoking " + method, e2.getCause());
            return null;
        } catch (RuntimeException e3) {
            String str3 = TAG;
            Log.w(str3, "Unexpected error while invoking " + method, e3);
            return null;
        }
    }

    private static void setFlashlight(boolean z) {
        Object obj = iHardwareService;
        if (obj != null) {
            invoke(setFlashEnabledMethod, obj, Boolean.valueOf(z));
        }
    }
}
