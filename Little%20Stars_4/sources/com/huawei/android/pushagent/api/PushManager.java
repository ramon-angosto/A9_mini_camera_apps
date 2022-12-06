package com.huawei.android.pushagent.api;

import android.content.Context;
import com.huawei.android.pushagent.c.e;

public class PushManager extends com.huawei.android.pushagent.PushManager {

    public enum PushFeature {
        LOCATION_BASED_MESSAGE
    }

    public static void enableFeature(Context context, PushFeature pushFeature, boolean z) {
        if (z) {
            e.a(context, "", 30, 1);
        } else {
            e.a(context, 1);
        }
    }
}
