package com.xiaomi.push;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.bj */
public class C1656bj {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f1873a = new HashMap();

    /* renamed from: com.xiaomi.push.bj$a */
    public static class C1657a<T> {

        /* renamed from: a */
        public final Class<? extends T> f1874a;

        /* renamed from: a */
        public final T f1875a;
    }

    static {
        f1873a.put(Boolean.class, Boolean.TYPE);
        f1873a.put(Byte.class, Byte.TYPE);
        f1873a.put(Character.class, Character.TYPE);
        f1873a.put(Short.class, Short.TYPE);
        f1873a.put(Integer.class, Integer.TYPE);
        f1873a.put(Float.class, Float.TYPE);
        f1873a.put(Long.class, Long.TYPE);
        f1873a.put(Double.class, Double.TYPE);
        f1873a.put(Boolean.TYPE, Boolean.TYPE);
        f1873a.put(Byte.TYPE, Byte.TYPE);
        f1873a.put(Character.TYPE, Character.TYPE);
        f1873a.put(Short.TYPE, Short.TYPE);
        f1873a.put(Integer.TYPE, Integer.TYPE);
        f1873a.put(Float.TYPE, Float.TYPE);
        f1873a.put(Long.TYPE, Long.TYPE);
        f1873a.put(Double.TYPE, Double.TYPE);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T m2693a(java.lang.Class<? extends java.lang.Object> r2, java.lang.Object r3, java.lang.String r4) {
        /*
            r0 = 0
        L_0x0001:
            r1 = 1
            if (r0 != 0) goto L_0x0019
            java.lang.reflect.Field r0 = r2.getDeclaredField(r4)     // Catch:{ NoSuchFieldException -> 0x000c }
            r0.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x000c }
            goto L_0x0010
        L_0x000c:
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0010:
            if (r2 == 0) goto L_0x0013
            goto L_0x0001
        L_0x0013:
            java.lang.NoSuchFieldException r2 = new java.lang.NoSuchFieldException
            r2.<init>()
            throw r2
        L_0x0019:
            r0.setAccessible(r1)
            java.lang.Object r2 = r0.get(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C1656bj.m2693a(java.lang.Class, java.lang.Object, java.lang.String):java.lang.Object");
    }

    /* renamed from: a */
    public static <T> T m2694a(Class<? extends Object> cls, String str) {
        try {
            return m2693a(cls, (Object) null, str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call getStaticField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(cls != null ? cls.getSimpleName() : "");
            sb.append(", ");
            sb.append(e);
            Log.w("JavaCalls", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m2695a(Class<?> cls, String str, Object... objArr) {
        return m2700a(cls, str, (Class<?>[]) m2704a(objArr)).invoke((Object) null, m2704a(objArr));
    }

    /* renamed from: a */
    public static <T> T m2696a(Object obj, String str) {
        try {
            return m2693a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getField '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m2697a(Object obj, String str, Object... objArr) {
        try {
            return m2706b(obj, str, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m2698a(String str, String str2) {
        try {
            return m2693a((Class<? extends Object>) C2087u.m5373a((Context) null, str), (Object) null, str2);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m2699a(String str, String str2, Object... objArr) {
        try {
            return m2695a(C2087u.m5373a((Context) null, str), str2, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str + ", " + e);
            return null;
        }
    }

    /* renamed from: a */
    private static Method m2700a(Class<?> cls, String str, Class<?>... clsArr) {
        Method a = m2701a(cls.getDeclaredMethods(), str, clsArr);
        if (a != null) {
            a.setAccessible(true);
            return a;
        } else if (cls.getSuperclass() != null) {
            return m2700a((Class<?>) cls.getSuperclass(), str, clsArr);
        } else {
            throw new NoSuchMethodException();
        }
    }

    /* renamed from: a */
    private static Method m2701a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && m2703a((Class<?>[]) method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    /* renamed from: a */
    public static void m2702a(Object obj, String str, Object obj2) {
        try {
            m2707b(obj, str, obj2);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call setField '" + str + "' in " + obj + ", " + e);
        }
    }

    /* renamed from: a */
    private static boolean m2703a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr2[i] != null && !clsArr[i].isAssignableFrom(clsArr2[i]) && (!f1873a.containsKey(clsArr[i]) || !f1873a.get(clsArr[i]).equals(f1873a.get(clsArr2[i])))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static Class<?>[] m2704a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            C1657a aVar = objArr[i];
            if (aVar == null || !(aVar instanceof C1657a)) {
                clsArr[i] = aVar == null ? null : aVar.getClass();
            } else {
                clsArr[i] = aVar.f1874a;
            }
        }
        return clsArr;
    }

    /* renamed from: a */
    private static Object[] m2705a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            C1657a aVar = objArr[i];
            if (aVar == null || !(aVar instanceof C1657a)) {
                objArr2[i] = aVar;
            } else {
                objArr2[i] = aVar.f1875a;
            }
        }
        return objArr2;
    }

    /* renamed from: b */
    public static <T> T m2706b(Object obj, String str, Object... objArr) {
        return m2700a(obj.getClass(), str, (Class<?>[]) m2704a(objArr)).invoke(obj, m2704a(objArr));
    }

    /* renamed from: b */
    public static void m2707b(Object obj, String str, Object obj2) {
        Class cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                continue;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }
}
