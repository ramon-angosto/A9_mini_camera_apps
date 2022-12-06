package sg.bigo.ads.controller.e;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class e {
    private static final e b = new e();
    final Map<String, a> a = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public boolean c = false;

    public class a {
        final AtomicInteger a = new AtomicInteger(0);
        final AtomicInteger b = new AtomicInteger(0);
        final AtomicInteger c = new AtomicInteger(0);

        public a() {
        }
    }

    public static e a() {
        return b;
    }

    public final a a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "null";
        }
        a aVar = this.a.get(str);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        this.a.put(str, aVar2);
        return aVar2;
    }

    public final void a(boolean z) {
        this.c = z;
        if (z) {
            for (Map.Entry<String, a> value : this.a.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.c.set(0);
                }
            }
        }
    }
}
