package sg.bigo.ads.controller.d;

import java.util.Map;
import sg.bigo.ads.api.a.d;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.f;
import sg.bigo.ads.controller.h.g;

public final class c implements f {
    protected final e a;
    protected final d b;

    public c(e eVar, d dVar) {
        this.a = eVar;
        this.b = dVar;
    }

    public final void a(Map<String, Object> map, final f.a aVar) {
        new g(this.b.k(), map, this.a, new sg.bigo.ads.controller.c<String>() {
            public final void a(int i, int i2, int i3, String str, Object obj) {
                aVar.a(i2, i3, str);
            }

            public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
                aVar.a((String) obj);
            }
        }).b();
    }
}
