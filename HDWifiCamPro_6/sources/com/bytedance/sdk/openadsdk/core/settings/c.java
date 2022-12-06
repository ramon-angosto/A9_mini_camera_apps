package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* compiled from: AppSetIdAndScope */
public class c {
    public static Object a;
    /* access modifiers changed from: private */
    public static volatile String b;
    /* access modifiers changed from: private */
    public static volatile String c;
    private static String d;
    private static Boolean e;

    /* compiled from: AppSetIdAndScope */
    private static class a implements InvocationHandler {
        private a() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!method.getName().equals("onSuccess")) {
                return null;
            }
            try {
                Object invoke = w.a("com.google.android.gms.tasks.Task", "getResult", new Class[0]).invoke(c.a, new Object[0]);
                Method a = w.a("com.google.android.gms.appset.AppSetIdInfo", "getScope", new Class[0]);
                Method a2 = w.a("com.google.android.gms.appset.AppSetIdInfo", "getId", new Class[0]);
                Object invoke2 = a.invoke(invoke, new Object[0]);
                Object invoke3 = a2.invoke(invoke, new Object[0]);
                if (invoke2 instanceof Integer) {
                    String unused = c.b = Integer.toString(((Integer) invoke2).intValue());
                }
                if (!(invoke3 instanceof String)) {
                    return null;
                }
                String unused2 = c.c = (String) invoke3;
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    private static void d() {
        try {
            Context a2 = m.a();
            Method a3 = w.a("com.google.android.gms.appset.AppSet", "getClient", Context.class);
            if (a3 != null) {
                a3.setAccessible(true);
                Object invoke = a3.invoke((Object) null, new Object[]{a2});
                Method a4 = w.a("com.google.android.gms.appset.AppSetIdClient", "getAppSetIdInfo", new Class[0]);
                if (a4 != null) {
                    e = true;
                    a = a4.invoke(invoke, new Object[0]);
                    Class<?> cls = Class.forName("com.google.android.gms.tasks.Task");
                    Class<?> cls2 = Class.forName("com.google.android.gms.tasks.OnSuccessListener");
                    Method declaredMethod = cls.getDeclaredMethod("addOnSuccessListener", new Class[]{cls2});
                    if (declaredMethod != null) {
                        declaredMethod.setAccessible(true);
                        a aVar = new a();
                        Object newProxyInstance = Proxy.newProxyInstance(aVar.getClass().getClassLoader(), new Class[]{cls2}, aVar);
                        if (newProxyInstance != null) {
                            declaredMethod.invoke(a, new Object[]{newProxyInstance});
                            return;
                        }
                        return;
                    }
                    return;
                }
                e = false;
            }
        } catch (Exception e2) {
            l.c("AppSetIdAndScope", e2.getMessage());
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        Boolean bool = e;
        if (bool != null && !bool.booleanValue()) {
            return "";
        }
        d();
        return b;
    }

    public static String b() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        Boolean bool = e;
        if (bool != null && !bool.booleanValue()) {
            return "";
        }
        if (TextUtils.isEmpty(c)) {
            d();
        }
        return c;
    }

    public static String c() {
        if (TextUtils.isEmpty(d)) {
            d = m.a().getPackageManager().getInstallerPackageName(y.e());
        }
        if (d == null) {
            d = "";
        }
        return d;
    }
}
