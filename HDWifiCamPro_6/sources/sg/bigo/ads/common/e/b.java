package sg.bigo.ads.common.e;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import sg.bigo.ads.common.a;

public final class b {
    public static a a(Context context) {
        a aVar;
        try {
            aVar = c.a(context, TimeUnit.SECONDS.toMillis(15));
        } catch (Exception e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            aVar = a.a(context);
        }
        return aVar == null ? new a("", true) : aVar;
    }
}
