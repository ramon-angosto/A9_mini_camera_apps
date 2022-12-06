package com.meizu.cloud.pushsdk.common.b;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public abstract class e {
    private static HashMap<String, Class<?>> d = new HashMap<>();
    /* access modifiers changed from: private */
    public static HashMap<Class<?>, HashMap<String, Method>> e = new HashMap<>();
    private static HashMap<String, Field> f = new HashMap<>();
    protected Object[] a;
    protected Class<?>[] b;
    protected String c;

    public abstract <T> c<T> a();

    public static e a(Class<?> cls) {
        return new a(cls);
    }

    public static e a(String str) {
        Class<?> cls = d.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                d.put(str, cls);
            } catch (ClassNotFoundException e2) {
                c.a("Reflector", (Throwable) e2);
            }
        }
        return a(cls);
    }

    /* access modifiers changed from: private */
    public static Class<?>[] c(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:2|3|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return c(r0, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return r0.getDeclaredMethod(r1, r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Method b(java.lang.Class<?> r0, java.lang.String r1, java.lang.Class... r2) throws java.lang.NoSuchMethodException {
        /*
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0005 }
            goto L_0x000e
        L_0x0005:
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x000a }
            goto L_0x000e
        L_0x000a:
            java.lang.reflect.Method r0 = c(r0, r1, r2)
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.common.b.e.b(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private static Method c(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        for (Method method : cls.getMethods()) {
            if (a(method, str, clsArr)) {
                return method;
            }
        }
        for (Method method2 : cls.getDeclaredMethods()) {
            if (a(method2, str, clsArr)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + cls);
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            if (clsArr2[i] != b.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                return false;
            }
        }
        return true;
    }

    public e a(Object[] objArr) {
        this.a = objArr;
        return this;
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    private static class a extends e {
        private Class<?> d;

        public a(Class<?> cls) {
            this.d = cls;
        }

        public <T> c<T> a() {
            c<T> cVar = new c<>();
            if (this.d != null && !TextUtils.isEmpty(this.c)) {
                if (this.a != null && this.a.length > 0 && this.b == null) {
                    this.b = e.c(this.a);
                }
                try {
                    HashMap hashMap = (HashMap) e.e.get(this.d);
                    if (hashMap == null) {
                        hashMap = new HashMap();
                        e.e.put(this.d, hashMap);
                    }
                    Method method = (Method) hashMap.get(this.c);
                    if (method == null) {
                        method = e.b(this.d, this.c, this.b);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        hashMap.put(this.c, method);
                    }
                    cVar.b = method.invoke(this.d, this.a);
                    cVar.a = true;
                } catch (Exception e) {
                    c.a("Reflector", (Throwable) e);
                }
            }
            c.a("Reflector", "[Clz.invoke]:, mMethodName='" + this.c + ", \nmTypes=" + Arrays.toString(this.b) + ", \nmArgs=" + Arrays.toString(this.a) + ", \nresult=" + cVar);
            return cVar;
        }
    }

    public static class c<T> {
        public boolean a = false;
        public T b;

        public String toString() {
            return "Result{ok=" + this.a + ", value=" + this.b + '}';
        }
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (!cls.isPrimitive()) {
            return cls;
        }
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        if (Short.TYPE == cls) {
            return Short.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        return Void.TYPE == cls ? Void.class : cls;
    }

    private static class b {
        private b() {
        }
    }
}
