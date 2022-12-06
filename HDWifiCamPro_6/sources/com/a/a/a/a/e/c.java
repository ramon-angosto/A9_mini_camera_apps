package com.a.a.a.a.e;

import android.text.TextUtils;
import android.util.Log;

public final class c {
    public static void a(String str) {
        if (com.a.a.a.a.c.a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void a(String str, Exception exc) {
        if ((com.a.a.a.a.c.a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
