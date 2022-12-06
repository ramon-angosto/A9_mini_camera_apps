package sg.bigo.ads.controller.d;

import java.util.Map;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.f;
import sg.bigo.ads.controller.c;

public final class b implements f {
    protected final e a;

    public b(e eVar) {
        this.a = eVar;
    }

    public final void a(Map<String, Object> map, final f.a aVar) {
        new sg.bigo.ads.controller.h.e(map, this.a, new c<String>() {
            public final void a(int i, int i2, int i3, String str, Object obj) {
                aVar.a(i2, i3, str);
            }

            public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
                aVar.a((String) obj);
            }
        }).b();
    }
}
