package sg.bigo.ads.common.i;

import java.lang.reflect.Constructor;

public final class a {
    public static <T> T a(String str, Class<T> cls) {
        try {
            Constructor<? extends U> declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor((Class[]) null);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Exception unused) {
            sg.bigo.ads.common.k.a.a(0, 5, "ReflectionHelper", "Cannot find class: ".concat(String.valueOf(str)));
            return null;
        }
    }
}
