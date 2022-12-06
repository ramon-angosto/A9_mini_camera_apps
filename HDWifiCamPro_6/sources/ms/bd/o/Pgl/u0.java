package ms.bd.o.Pgl;

import android.content.Context;
import android.util.DisplayMetrics;

public class u0 {
    private static int a;

    public static String a(Context context) {
        if (context != null) {
            try {
                new DisplayMetrics();
                a = context.getResources().getDisplayMetrics().densityDpi;
            } catch (Throwable unused) {
            }
        }
        return "" + a;
    }
}
