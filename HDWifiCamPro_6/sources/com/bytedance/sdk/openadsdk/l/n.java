package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import com.bytedance.sdk.component.utils.v;

/* compiled from: PAGNetworkTools */
public class n {
    public static String a(Context context) {
        int a = v.a(context, 0);
        if (a == 2) {
            return "2g";
        }
        if (a == 3) {
            return "3g";
        }
        if (a == 4) {
            return "wifi";
        }
        if (a != 5) {
            return a != 6 ? "mobile" : "5g";
        }
        return "4g";
    }
}
