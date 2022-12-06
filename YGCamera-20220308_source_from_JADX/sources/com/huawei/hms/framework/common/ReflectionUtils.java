package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            Logger.m478w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    private static Class<?> getClass(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object getFieldObj(Object obj, String str) {
        String str2;
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Field declaredField = obj.getClass().getDeclaredField(str);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(obj);
        } catch (IllegalAccessException e) {
            e = e;
            str2 = "Exception in getFieldObj :: IllegalAccessException:";
            Logger.m472e(TAG, str2, e);
            return null;
        } catch (IllegalArgumentException e2) {
            e = e2;
            str2 = "Exception in getFieldObj :: IllegalArgumentException:";
            Logger.m472e(TAG, str2, e);
            return null;
        } catch (NoSuchFieldException e3) {
            e = e3;
            str2 = "Exception in getFieldObj :: NoSuchFieldException:";
            Logger.m472e(TAG, str2, e);
            return null;
        } catch (SecurityException e4) {
            e = e4;
            str2 = "not security int method getStaticFieldObj,SecurityException:";
            Logger.m472e(TAG, str2, e);
            return null;
        }
    }

    private static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        String str2;
        if (cls == null || str == null) {
            Logger.m478w(TAG, "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (SecurityException e) {
            e = e;
            str2 = "SecurityException:";
            Logger.m472e(TAG, str2, e);
            return null;
        } catch (NoSuchMethodException e2) {
            e = e2;
            str2 = "NoSuchMethodException:";
            Logger.m472e(TAG, str2, e);
            return null;
        }
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> cls;
        String str3;
        if (str == null || (cls = getClass(str)) == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            final Field declaredField = cls.getDeclaredField(str2);
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(cls);
        } catch (IllegalAccessException e) {
            e = e;
            str3 = "Exception in getFieldObj :: IllegalAccessException:";
            Logger.m472e(TAG, str3, e);
            return null;
        } catch (IllegalArgumentException e2) {
            e = e2;
            str3 = "Exception in getFieldObj :: IllegalArgumentException:";
            Logger.m472e(TAG, str3, e);
            return null;
        } catch (NoSuchFieldException e3) {
            e = e3;
            str3 = "Exception in getFieldObj :: NoSuchFieldException:";
            Logger.m472e(TAG, str3, e);
            return null;
        } catch (SecurityException e4) {
            e = e4;
            str3 = "not security int method getStaticFieldObj,SecurityException:";
            Logger.m472e(TAG, str3, e);
            return null;
        }
    }

    private static Object invoke(Object obj, Method method, Object... objArr) {
        String str;
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e) {
            e = e;
            str = "RuntimeException in invoke:";
            Logger.m472e(TAG, str, e);
            return null;
        } catch (Exception e2) {
            e = e2;
            str = "Exception in invoke:";
            Logger.m472e(TAG, str, e);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke((Object) null, method, objArr);
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                setClassType(clsArr, objArr[i], i);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke((Object) null, method, objArr);
    }

    private static void setClassType(Class<?>[] clsArr, Object obj, int i) {
        if (obj instanceof Integer) {
            clsArr[i] = Integer.TYPE;
        } else if (obj instanceof Long) {
            clsArr[i] = Long.TYPE;
        } else if (obj instanceof Double) {
            clsArr[i] = Double.TYPE;
        } else if (obj instanceof Float) {
            clsArr[i] = Float.TYPE;
        } else if (obj instanceof Boolean) {
            clsArr[i] = Boolean.TYPE;
        } else if (obj instanceof Character) {
            clsArr[i] = Character.TYPE;
        } else if (obj instanceof Byte) {
            clsArr[i] = Byte.TYPE;
        } else if (obj instanceof Void) {
            clsArr[i] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i] = Short.TYPE;
        } else {
            clsArr[i] = obj.getClass();
        }
    }

    private static void tryLoadClass(String str) {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader != null) {
            classLoader.loadClass(str);
            return;
        }
        throw new ClassNotFoundException("not found classloader");
    }
}
