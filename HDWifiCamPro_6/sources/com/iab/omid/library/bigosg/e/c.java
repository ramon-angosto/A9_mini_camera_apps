package com.iab.omid.library.bigosg.e;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.bigosg.a;

public final class c {
    public static void a(String str) {
        if (a.a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void a(String str, Exception exc) {
        if (a.a.booleanValue()) {
            TextUtils.isEmpty(str);
        }
        Log.e("OMIDLIB", str, exc);
    }
}
