package com.mbridge.msdk.mbsignalcommon.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Mapping */
public final class a {
    private static C0069a a;

    /* renamed from: com.mbridge.msdk.mbsignalcommon.c.a$a  reason: collision with other inner class name */
    /* compiled from: Mapping */
    public interface C0069a {
        boolean a(b.C0070a aVar);
    }

    /* compiled from: Mapping */
    public static abstract class b {

        /* renamed from: com.mbridge.msdk.mbsignalcommon.c.a$b$a  reason: collision with other inner class name */
        /* compiled from: Mapping */
        public static class C0070a extends Throwable {
            private Class<?> a;
            private String b;

            public C0070a(String str) {
                super(str);
            }

            public C0070a(Exception exc) {
                super(exc);
            }

            public final String toString() {
                if (getCause() == null) {
                    return super.toString();
                }
                return getClass().getName() + ": " + getCause();
            }

            public final void a(Class<?> cls) {
                this.a = cls;
            }

            public final void a(String str) {
                this.b = str;
            }
        }
    }

    /* compiled from: Mapping */
    public static class d {
        protected final Method a;

        public final Object a(Object obj, Object... objArr) throws IllegalArgumentException, InvocationTargetException {
            try {
                return this.a.invoke(obj, objArr);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        d(Class<?> cls, String str, Class<?>[] clsArr, int i) throws b.C0070a {
            Method method = null;
            Class<? super Object> cls2 = cls;
            if (cls == null) {
                this.a = null;
                return;
            }
            while (true) {
                if (cls2 == Object.class) {
                    break;
                }
                try {
                    method = cls2.getDeclaredMethod(str, clsArr);
                    break;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (SecurityException e2) {
                    try {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        b.C0070a aVar = new b.C0070a(e3);
                        aVar.a(cls2);
                        aVar.a(str);
                        a.b(aVar);
                    } catch (Throwable th) {
                        this.a = null;
                        throw th;
                    }
                }
                cls2 = cls2.getSuperclass();
            }
            if (i > 0 && (method.getModifiers() & i) != i) {
                a.b(new b.C0070a(method + " does not match modifiers: " + i));
            }
            method.setAccessible(true);
            this.a = method;
        }

        public final Method a() {
            return this.a;
        }
    }

    /* compiled from: Mapping */
    public static class c<C> {
        protected Class<C> a;

        public final d a(String str, Class<?>... clsArr) throws b.C0070a {
            return new d(this.a, str, clsArr, 0);
        }

        public c(Class<C> cls) {
            this.a = cls;
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0070a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e) {
            b(new b.C0070a(e));
            return new c<>((Class) null);
        }
    }

    /* access modifiers changed from: private */
    public static void b(b.C0070a aVar) throws b.C0070a {
        C0069a aVar2 = a;
        if (aVar2 == null || !aVar2.a(aVar)) {
            throw aVar;
        }
    }
}
