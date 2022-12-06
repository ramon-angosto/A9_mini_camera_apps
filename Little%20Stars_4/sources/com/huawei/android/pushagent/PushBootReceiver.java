package com.huawei.android.pushagent;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;

public class PushBootReceiver extends PushEventReceiver {
    public void onReceive(Context context, Intent intent) {
        int q = a.q(context);
        e.a("PushLogAC2705", "voteState:" + q);
        if (2 == q) {
            a.a(context, false);
        } else {
            super.onReceive(context, intent);
        }
    }
}
