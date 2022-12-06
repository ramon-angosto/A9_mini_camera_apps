package sg.bigo.ads.controller.h;

import java.util.Map;
import sg.bigo.ads.common.e;
import sg.bigo.ads.controller.c;
import sg.bigo.ads.controller.h.a;

public abstract class d extends a {
    private final c<String> g;
    private final Map<String, Object> h;

    public d(Map<String, Object> map, e eVar, c<String> cVar) {
        super(eVar);
        this.g = cVar;
        this.h = map;
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
    public void a(a.C0132a aVar) {
        for (String next : this.h.keySet()) {
            aVar.a(next, this.h.get(next));
        }
    }
}
