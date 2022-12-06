package com.huawei.android.pushagent.a.a.a;

import com.huawei.android.pushagent.a.a.b;
import com.huawei.android.pushagent.c.a.e;
import java.io.InputStream;
import java.util.HashMap;

public class a {
    private static HashMap a = new HashMap();

    static {
        a.put((byte) 1, com.huawei.android.pushagent.a.a.a.class);
        a.put((byte) 2, b.class);
    }

    public static b a(Byte b, InputStream inputStream) throws InstantiationException, IllegalAccessException, Exception {
        if (a.containsKey(b)) {
            b bVar = (b) ((Class) a.get(b)).newInstance();
            b a2 = bVar.a(inputStream);
            if (a2 != null) {
                e.b("PushLogAC2705", "after decode msg:" + a2);
            } else {
                e.d("PushLogAC2705", "call " + bVar.getClass().getSimpleName() + " decode failed!");
            }
            return a2;
        }
        e.d("PushLogAC2705", "cmdId:" + b + " is not exist, all:" + a.keySet());
        throw new InstantiationException("cmdId:" + b + " is not register");
    }
}
