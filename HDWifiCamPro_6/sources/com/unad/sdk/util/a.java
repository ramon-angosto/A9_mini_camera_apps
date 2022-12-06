package com.unad.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: DisplayUtil */
public class a {
    public static final int a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
