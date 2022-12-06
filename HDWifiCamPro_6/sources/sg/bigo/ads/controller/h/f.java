package sg.bigo.ads.controller.h;

import java.util.Map;
import sg.bigo.ads.b;
import sg.bigo.ads.common.e;
import sg.bigo.ads.controller.c;
import sg.bigo.ads.controller.h.a;

public final class f extends a {
    private final c<String> g;

    public f(e eVar, long j, c<String> cVar) {
        super(eVar, j);
        this.g = cVar;
    }

    /* access modifiers changed from: protected */
    public final void a(int i, int i2, String str) {
        this.g.a(a(), i, i2, str, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, Map<String, Object> map) {
        this.g.a(a(), str);
    }

    /* access modifiers changed from: protected */
    public final void a(a.C0132a aVar) {
    }

    /* access modifiers changed from: protected */
    public final String c() {
        return b.b();
    }
}
