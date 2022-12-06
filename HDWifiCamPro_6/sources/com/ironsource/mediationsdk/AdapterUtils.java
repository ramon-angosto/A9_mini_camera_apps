package com.ironsource.mediationsdk;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

public class AdapterUtils {
    public static final int MIN_TABLET_DP_SIZE = 600;

    public static int dpToPixels(Activity activity, int i) {
        if (activity != null) {
            return (int) TypedValue.applyDimension(1, (float) i, activity.getResources().getDisplayMetrics());
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils dpToPixels - activity is null, returning dpSize", 3);
        return i;
    }

    public static String getScreenSizeParams(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        float min = Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        float f = displayMetrics.xdpi;
        float f2 = displayMetrics.ydpi;
        float f3 = ((float) displayMetrics.widthPixels) / f;
        float f4 = ((float) displayMetrics.heightPixels) / f2;
        double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        int i = activity.getResources().getConfiguration().smallestScreenWidthDp;
        return "smallestWidth = " + min + " diagonalInches = " + sqrt + " smallScreenDpApi =  " + i;
    }

    public static boolean isLargeScreen(Activity activity) {
        if (activity != null) {
            return activity.getResources().getConfiguration().smallestScreenWidthDp >= 600;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils isLargeScreen - activity is null", 3);
        return false;
    }
}
