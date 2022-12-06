package com.huawei.updatesdk.p025a.p034b.p037c;

import com.huawei.updatesdk.p025a.p034b.p037c.p038c.C0994d;
import com.huawei.updatesdk.service.appmgr.bean.C1054a;
import com.huawei.updatesdk.service.appmgr.bean.C1055b;
import com.huawei.updatesdk.service.appmgr.bean.C1057d;
import com.huawei.updatesdk.service.appmgr.bean.C1059e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.updatesdk.a.b.c.a */
public class C0988a {

    /* renamed from: a */
    private static final Map<String, Class> f1330a = new HashMap();

    static {
        f1330a.put(C1057d.APIMETHOD, C1059e.class);
        f1330a.put(C1054a.APIMETHOD, C1055b.class);
    }

    /* renamed from: a */
    public static C0994d m1770a(String str) {
        Class cls = f1330a.get(str);
        if (cls != null) {
            return (C0994d) cls.newInstance();
        }
        throw new InstantiationException("ResponseBean class not found, method:" + str);
    }
}
