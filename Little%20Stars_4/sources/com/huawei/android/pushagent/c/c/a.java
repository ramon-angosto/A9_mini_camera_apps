package com.huawei.android.pushagent.c.c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.h;

public class a {
    private static String a = "PushLogAC2705";

    public static boolean a(Context context) {
        boolean a2 = new h(context, "canStartPush").a("startPush");
        String str = a;
        e.a(str, "get canStartPush Value is " + a2);
        return a2;
    }
}
