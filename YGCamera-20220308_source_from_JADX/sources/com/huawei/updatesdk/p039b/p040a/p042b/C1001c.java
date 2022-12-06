package com.huawei.updatesdk.p039b.p040a.p042b;

import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.p025a.p026a.p028c.p029a.p030a.C0968a;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.PublicKey;

/* renamed from: com.huawei.updatesdk.b.a.b.c */
class C1001c {

    /* renamed from: com.huawei.updatesdk.b.a.b.c$a */
    static class C1002a {

        /* renamed from: a */
        ArrayMap<String, ArraySet<PublicKey>> f1358a = null;

        /* renamed from: b */
        ArraySet<String> f1359b = null;

        C1002a() {
        }
    }

    /* renamed from: a */
    static C1002a m1828a(File file) {
        C1002a aVar = new C1002a();
        Object b = m1830b(file);
        if (b != null) {
            Object a = m1829a(b, "mKeySetMapping");
            if (a instanceof ArrayMap) {
                aVar.f1358a = (ArrayMap) a;
            }
            Object a2 = m1829a(b, "mUpgradeKeySets");
            if (a2 instanceof ArraySet) {
                aVar.f1359b = (ArraySet) a2;
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static Object m1829a(Object obj, String str) {
        String str2;
        try {
            return Class.forName("android.content.pm.PackageParser$Package").getDeclaredField(str).get(obj);
        } catch (ClassNotFoundException unused) {
            str2 = "can not find class,ClassNotFoundException";
            C0968a.m1683c("KeySetsUtils", str2);
            return null;
        } catch (NoSuchFieldException unused2) {
            str2 = "can not find field,NoSuchFieldException";
            C0968a.m1683c("KeySetsUtils", str2);
            return null;
        } catch (IllegalAccessException unused3) {
            str2 = "can not find field,IllegalAccessException";
            C0968a.m1683c("KeySetsUtils", str2);
            return null;
        } catch (NoSuchFieldError unused4) {
            str2 = "can not find field,NoSuchFieldError";
            C0968a.m1683c("KeySetsUtils", str2);
            return null;
        }
    }

    /* renamed from: b */
    private static Object m1830b(File file) {
        String str;
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            return cls.getDeclaredMethod("parsePackage", new Class[]{File.class, Integer.TYPE}).invoke(cls.newInstance(), new Object[]{file, 0});
        } catch (ClassNotFoundException unused) {
            str = "can not get PackageParser,ClassNotFoundException";
            C0968a.m1683c("KeySetsUtils", str);
            return null;
        } catch (NoSuchMethodException unused2) {
            str = "can not get PackageParser,NoSuchMethodException";
            C0968a.m1683c("KeySetsUtils", str);
            return null;
        } catch (InstantiationException unused3) {
            str = "can not get PackageParser,InstantiationException";
            C0968a.m1683c("KeySetsUtils", str);
            return null;
        } catch (IllegalAccessException unused4) {
            str = "can not get PackageParser,IllegalAccessException";
            C0968a.m1683c("KeySetsUtils", str);
            return null;
        } catch (InvocationTargetException unused5) {
            str = "can not get PackageParser,InvocationTargetException";
            C0968a.m1683c("KeySetsUtils", str);
            return null;
        } catch (Exception e) {
            str = "can not get PackageParser," + e.getMessage();
            C0968a.m1683c("KeySetsUtils", str);
            return null;
        }
    }
}
