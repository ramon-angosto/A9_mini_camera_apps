package sg.bigo.ads.api.core;

import sg.bigo.ads.api.AdConfig;
import sg.bigo.ads.api.b;
import sg.bigo.ads.common.e;

public final class g {
    public final c a;
    public final sg.bigo.ads.api.a.g b;
    public final AdConfig c;
    public final b d;
    public e e;

    public static class a {
        public e a;
        private final c b;
        private final sg.bigo.ads.api.a.g c;
        private final AdConfig d;
        private final b e;

        public a(c cVar, sg.bigo.ads.api.a.g gVar, AdConfig adConfig, b bVar) {
            this.b = cVar;
            this.c = gVar;
            this.d = adConfig;
            this.e = bVar;
        }

        public final g a() {
            g gVar = new g(this.b, this.c, this.d, this.e, (byte) 0);
            gVar.e = this.a;
            return gVar;
        }
    }

    private g(c cVar, sg.bigo.ads.api.a.g gVar, AdConfig adConfig, b bVar) {
        this.a = cVar;
        this.b = gVar;
        this.c = adConfig;
        this.d = bVar;
    }

    /* synthetic */ g(c cVar, sg.bigo.ads.api.a.g gVar, AdConfig adConfig, b bVar, byte b2) {
        this(cVar, gVar, adConfig, bVar);
    }
}
