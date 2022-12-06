package sg.bigo.ads.controller.d;

import java.util.Map;
import sg.bigo.ads.common.f;
import sg.bigo.ads.controller.c;
import sg.bigo.ads.controller.h.i;

public final class e implements f {
    protected final sg.bigo.ads.common.e a;

    public e(sg.bigo.ads.common.e eVar) {
        this.a = eVar;
    }

    public final void a(Map<String, Object> map, final f.a aVar) {
        new i(map, this.a, new c<String>() {
            public final void a(int i, int i2, int i3, String str, Object obj) {
                aVar.a(i2, i3, str);
            }

            public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
                aVar.a((String) null);
            }
        }).b();
    }
}
