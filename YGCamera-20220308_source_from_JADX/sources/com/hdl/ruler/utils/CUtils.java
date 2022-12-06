package com.hdl.ruler.utils;

import android.content.res.Resources;

public class CUtils {
    public static int dip2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }
}
