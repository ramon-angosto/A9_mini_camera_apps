package ms.bd.o.Pgl;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ms.bd.o.Pgl.pblb;

final class a0 extends pblb.pgla {
    a0() {
    }

    /* access modifiers changed from: protected */
    public Object a(int i, long j, String str, Object obj) throws Throwable {
        Throwable b = y0.a().b();
        if (b == null) {
            return null;
        }
        StackTraceElement[] stackTrace = b.getStackTrace();
        if (stackTrace.length < 4) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < 4; i2++) {
            if (stackTrace[i2] != null && !TextUtils.isEmpty(stackTrace[i2].getClassName())) {
                Class<?> cls = Class.forName(stackTrace[i2].getClassName());
                y0 a = y0.a();
                String methodName = stackTrace[i2].getMethodName();
                if (a != null) {
                    ArrayList arrayList2 = new ArrayList();
                    if (!TextUtils.isEmpty(methodName)) {
                        for (Method method : cls.getDeclaredMethods()) {
                            if (method != null && method.getName().equals(methodName)) {
                                arrayList2.add(method);
                            }
                        }
                    }
                    arrayList.addAll(arrayList2);
                } else {
                    throw null;
                }
            }
        }
        return arrayList;
    }
}
