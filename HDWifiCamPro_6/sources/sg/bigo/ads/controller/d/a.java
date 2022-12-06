package sg.bigo.ads.controller.d;

import java.util.Map;
import sg.bigo.ads.common.e;
import sg.bigo.ads.common.f;
import sg.bigo.ads.controller.h.c;

public final class a implements f {
    protected final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    public final void a(Map<String, Object> map, final f.a aVar) {
        new c(map, this.a, new sg.bigo.ads.controller.c<String>() {
            public final void a(int i, int i2, int i3, String str, Object obj) {
                aVar.a(i2, i3, str);
            }

            public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
                aVar.a((String) obj);
            }
        }).b();
    }
}
