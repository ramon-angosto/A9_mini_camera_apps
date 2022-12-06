package com.huawei.android.pushagent.a.b.a;

import com.huawei.android.pushagent.a.b.b;
import com.huawei.android.pushagent.a.b.c;
import com.huawei.android.pushagent.a.b.d;
import com.huawei.android.pushagent.a.b.e;
import com.huawei.android.pushagent.a.b.f;
import com.huawei.android.pushagent.a.b.h;
import com.huawei.android.pushagent.a.b.i;
import com.huawei.android.pushagent.a.b.j;
import com.huawei.android.pushagent.a.b.k;
import com.huawei.android.pushagent.a.b.l;
import com.huawei.android.pushagent.a.b.m;
import com.huawei.android.pushagent.a.b.n;
import com.huawei.android.pushagent.a.b.o;
import com.huawei.android.pushagent.a.b.p;
import com.huawei.android.pushagent.a.b.q;
import java.io.InputStream;
import java.util.HashMap;

public class a {
    private static HashMap a = new HashMap();

    static {
        a.put((byte) -47, f.class);
        a.put((byte) -37, k.class);
        a.put((byte) -45, d.class);
        a.put((byte) -33, i.class);
        a.put((byte) -35, o.class);
        a.put((byte) -41, q.class);
        a.put((byte) -96, l.class);
        a.put((byte) -48, e.class);
        a.put((byte) -38, j.class);
        a.put((byte) -46, c.class);
        a.put((byte) -34, h.class);
        a.put((byte) -36, n.class);
        a.put((byte) -42, p.class);
        a.put((byte) -95, m.class);
        a.put((byte) -92, b.class);
        a.put((byte) -91, b.class);
        a.put((byte) -90, b.class);
        a.put((byte) -89, b.class);
    }

    public static b a(Byte b, InputStream inputStream) throws InstantiationException, IllegalAccessException, Exception {
        if (a.containsKey(b)) {
            b bVar = (b) ((Class) a.get(b)).newInstance();
            if (bVar.a() == -1) {
                bVar.b(b.byteValue());
            }
            b a2 = bVar.a(inputStream);
            if (a2 != null) {
                com.huawei.android.pushagent.c.a.e.a("PushLogAC2705", "after decode msg:" + com.huawei.android.pushagent.c.a.a(a2.a()));
            } else {
                com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "call " + bVar.getClass().getSimpleName() + " decode failed!");
            }
            return a2;
        }
        com.huawei.android.pushagent.c.a.e.d("PushLogAC2705", "cmdId:" + b + " is not exist, all:" + a.keySet());
        throw new InstantiationException("cmdId:" + b + " is not register");
    }
}
