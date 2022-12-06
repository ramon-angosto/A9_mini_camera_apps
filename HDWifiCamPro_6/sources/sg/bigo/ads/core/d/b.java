package sg.bigo.ads.core.d;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.d.a.a;

public final class b {
    private static final b d = new b();
    public a a;
    public sg.bigo.ads.core.d.b.b b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    private b() {
    }

    public static b a() {
        return d;
    }

    public final void a(String str, Map<String, String> map) {
        String valueOf;
        String str2;
        String concat;
        if (!sg.bigo.ads.common.n.a.c()) {
            if (!this.c.get()) {
                concat = "please execute initStatic first";
            } else {
                if (o.b(str) || map == null) {
                    valueOf = String.valueOf(str);
                    str2 = "eventId is empty or events is null, eventId =";
                } else if (!this.a.a(str)) {
                    valueOf = String.valueOf(str);
                    str2 = "not hit report eventId=";
                } else {
                    sg.bigo.ads.core.d.b.b bVar = this.b;
                    if (bVar != null) {
                        bVar.a(str, map);
                        return;
                    }
                    return;
                }
                concat = str2.concat(valueOf);
            }
            sg.bigo.ads.common.k.a.a(0, "Stats", concat);
        }
    }
}
