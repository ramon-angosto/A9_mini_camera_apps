package com.bytedance.sdk.openadsdk.d;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.l;
import java.lang.reflect.Method;

/* compiled from: BaseHook */
public abstract class a implements c {
    private SparseArray<Method> a;
    private Object b;

    public abstract String a();

    public <T> T a(int i, Object... objArr) {
        Object obj;
        Method method = this.a.get(i);
        if (method == null || (obj = this.b) == null) {
            String a2 = a();
            l.d(a2, "call method " + i + " failed for null ");
            return null;
        }
        try {
            if (obj instanceof Class) {
                return method.invoke((Object) null, objArr);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            String a3 = a();
            l.d(a3, "call method " + i + " failed: " + th.getMessage());
            return null;
        }
    }
}
