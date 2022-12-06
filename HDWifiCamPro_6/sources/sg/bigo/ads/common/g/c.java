package sg.bigo.ads.common.g;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.a;

public final class c {
    private static boolean a = true;

    public static a a(Context context) {
        boolean z;
        if (!a) {
            return new a("", true);
        }
        a aVar = null;
        long millis = TimeUnit.SECONDS.toMillis(15);
        try {
            aVar = d.a(context, millis);
            z = true;
        } catch (b unused) {
            z = false;
        }
        if (aVar != null) {
            return aVar;
        }
        try {
            aVar = a.a(context, millis);
        } catch (b unused2) {
            if (!z) {
                a = false;
            }
        }
        return aVar != null ? aVar : new a("", true);
    }
}
