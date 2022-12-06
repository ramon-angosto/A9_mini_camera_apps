package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: DomainSameTool */
public class g {
    private static String a = "DomainSameTool";

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            if (resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            q.a(a, th.getMessage(), th);
            return false;
        }
    }
}
