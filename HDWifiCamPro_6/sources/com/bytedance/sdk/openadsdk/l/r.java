package com.bytedance.sdk.openadsdk.l;

import android.os.Build;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: SlotUtils */
public class r {
    public static boolean a(n nVar) {
        int aR;
        if (nVar == null || (aR = nVar.aR()) == 8 || aR == 7 || nVar.G() == null || Build.VERSION.SDK_INT > 27) {
            return false;
        }
        return true;
    }
}
