package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.c.a;

public class PushProxyReceiver extends PushEventReceiver {
    private static String a = "PushLogAC2705";

    public void onReceive(Context context, Intent intent) {
        if (a.a(context)) {
            super.onReceive(context, intent);
        } else {
            e.a(a, "app push is closed, need not to process intent");
        }
    }
}
