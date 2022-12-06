package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* compiled from: TTReflectUtils */
public class w {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> a = a(str);
            if (a != null) {
                return a.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable th) {
            l.a("TTClassLoader", "get method: " + str + ", " + str2, th);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return java.lang.Class.forName(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> a(java.lang.String r2) {
        /*
            r0 = 1
            java.lang.ClassLoader r1 = a()     // Catch:{ ClassNotFoundException -> 0x000a }
            java.lang.Class r2 = java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x000a }
            goto L_0x001b
        L_0x000a:
            java.lang.Class<com.bytedance.sdk.component.utils.w> r1 = com.bytedance.sdk.component.utils.w.class
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0015 }
            java.lang.Class r2 = java.lang.Class.forName(r2, r0, r1)     // Catch:{ ClassNotFoundException -> 0x0015 }
            goto L_0x001b
        L_0x0015:
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.utils.w.a(java.lang.String):java.lang.Class");
    }

    private static ClassLoader a() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? w.class.getClassLoader() : contextClassLoader;
    }
}
