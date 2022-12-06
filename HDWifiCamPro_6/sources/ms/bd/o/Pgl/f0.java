package ms.bd.o.Pgl;

import android.content.Context;
import java.lang.reflect.Method;
import ms.bd.o.Pgl.pblb;

final class f0 extends pblb.pgla {
    f0() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        double d;
        Context b = pgla.a().b();
        try {
            Class<?> cls = Class.forName(new String(pblz.a((String) pblk.a(16777217, 0, 0, "f65904", new byte[]{33, 103, 16, 75, 89, 39, 55, 18, 50, 56, 33, 49, 16, 25, 88, 113, 51, 17, 50, 48, 33, 96, 20, 72, 89, 122, 51, 18, 51, 61, 33, 97, 17, 31, 89, 38, 51, 70, 50, 106, 37, 49, 16, 75, 88, 112, 55, 18, 49, 57, 33, 50, 17, 26, 89, 118, 50, 69, 49, 57, 32, 102, 16, 75, 89, 117, 51, 78, 50, 106, 33, 97}))));
            Object newInstance = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{b});
            Method declaredMethod = cls.getDeclaredMethod(new String(pblz.a((String) pblk.a(16777217, 0, 0, "db84f7", new byte[]{35, 55, 29, 21, 14, 116, 51, 18, 62, 50, 35, 53, 28, 18, 15, 113, 49, 20, 63, 49, 32, 48, 29, 70, 14, 119, 49, 22, 62, 54}))), new Class[]{String.class});
            declaredMethod.setAccessible(true);
            Object[] objArr = new Object[1];
            objArr[0] = new String(pblz.a((String) pblk.a(16777217, 0, 0, "fdef88", new byte[]{33, 52, 64, 67, 80, 123, 50, 17, 98, 99, 32, 52, 65, 75, 85, 42, 51, 22, 98, 103, 32, 54, 64, 67, 81, 124, 51, 28, 99, 98, 32, 63})));
            d = ((Double) declaredMethod.invoke(newInstance, objArr)).doubleValue();
        } catch (Throwable unused) {
            d = 0.0d;
        }
        return Integer.toString((int) d);
    }
}
