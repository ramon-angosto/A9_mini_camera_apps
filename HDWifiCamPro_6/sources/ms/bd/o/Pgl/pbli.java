package ms.bd.o.Pgl;

import java.lang.reflect.Method;
import ms.bd.o.Pgl.pblb;

final class pbli extends pblb.pgla {
    pbli() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0, "c550a8", new byte[]{113, 56, 75, 10, 77, 60, 46, 21, 106, 100, 96, 56, 79, 64, 16, 58, 103, 23, 42, 113, 103, 56, 82, 69, 16, 13, 68, 58, 97, 116, 101, 56, 84, 79, 106, 46, 103, 55, 107, 110, 102, 50, 94, 80, 110, 61, 111, 2, 109, 100, 119, 37, 103, 64, 95, 63, 116, 17, 118}));
            Method declaredMethod = cls.getDeclaredMethod((String) pblk.a(16777217, 0, 0, "82c1ce", new byte[]{36, 49, 2, 78, 125, 97, 21, 22, 37, 84, 58, 53, 2}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object newInstance = cls.newInstance();
            if (!(newInstance != null ? ((Boolean) declaredMethod.invoke(newInstance, new Object[0])).booleanValue() : false)) {
                return null;
            }
            return (String) pblk.a(16777217, 0, 0, "98838a", new byte[]{38, 63, 92, 114, 20, 115, 40});
        } catch (Throwable unused) {
            String str2 = (String) pblk.a(16777217, 0, 0, "0e0635", new byte[]{38, 102, 69});
            return null;
        }
    }
}
