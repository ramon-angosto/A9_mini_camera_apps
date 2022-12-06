package object.p2pipcam.utils;

import android.app.Activity;
import android.os.Vibrator;

public class VibratorUtil {
    public static void Vibrate(Activity activity, long j) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(j);
    }

    public static void Vibrate(Activity activity, long[] jArr, boolean z) {
        ((Vibrator) activity.getSystemService("vibrator")).vibrate(jArr, z ? 1 : -1);
    }
}
