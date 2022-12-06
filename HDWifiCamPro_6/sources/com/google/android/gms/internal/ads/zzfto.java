package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzfto {
    @CheckForNull
    private static final Object zza = zzb();
    @CheckForNull
    private static final Method zzb;
    @CheckForNull
    private static final Method zzc;

    static {
        Method method;
        Method method2 = null;
        if (zza == null) {
            method = null;
        } else {
            method = zzc("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        zzb = method;
        Object obj = zza;
        if (obj != null) {
            method2 = zzd(obj);
        }
        zzc = method2;
    }

    public static String zza(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @CheckForNull
    private static Object zzb() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    private static Method zzc(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    private static Method zzd(Object obj) {
        try {
            Method zzc2 = zzc("getStackTraceDepth", Throwable.class);
            if (zzc2 == null) {
                return null;
            }
            zzc2.invoke(obj, new Object[]{new Throwable()});
            return zzc2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }
}
