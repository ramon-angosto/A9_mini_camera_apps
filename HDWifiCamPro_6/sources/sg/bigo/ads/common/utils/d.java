package sg.bigo.ads.common.utils;

import android.content.Context;

public final class d {
    public static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int a(Context context, int i) {
        return (int) (((double) (a(context) * ((float) i))) + 0.5d);
    }

    public static int b(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
