package com.meizu.cloud.pushsdk.common.b;

import com.meizu.cloud.pushsdk.common.b.e;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import java.util.HashMap;

public class f {
    private static HashMap<String, e.c> a = new HashMap<>();

    public static <T> e.c<T> a(String str) {
        if (a.containsKey(str)) {
            return a.get(str);
        }
        e.c<T> a2 = e.a(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES).b("get").a(new Object[]{str}).a();
        if (a2.a) {
            a.put(str, a2);
        }
        return a2;
    }
}
