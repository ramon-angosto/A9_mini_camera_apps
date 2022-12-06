package sg.bigo.ads.core.f.a;

import android.text.TextUtils;
import java.util.regex.Pattern;

public final class o {
    private static Pattern a = Pattern.compile("((\\d{1,2})|(100))%");
    private static Pattern b = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && a.matcher(str).matches();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && b.matcher(str).matches();
    }

    public static int c(String str) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split(":");
        if (split.length != 3) {
            return -1;
        }
        try {
            return (Integer.parseInt(split[0]) * 60 * 60 * 1000) + (Integer.parseInt(split[1]) * 60 * 1000) + ((int) (Float.parseFloat(split[2]) * 1000.0f));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int d(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str.replace("%", ""));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
