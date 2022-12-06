package sg.bigo.ads.common.l;

import sg.bigo.ads.common.l.b.c;
import sg.bigo.ads.common.l.c.c;

public abstract class b<Req extends c, Res extends sg.bigo.ads.common.l.c.c> {
    public static b<sg.bigo.ads.common.l.b.c, sg.bigo.ads.common.l.c.a> c = new a();

    static class a<Req extends sg.bigo.ads.common.l.b.c> extends b<Req, sg.bigo.ads.common.l.c.a> {
        Req a;
        sg.bigo.ads.common.l.c.a b;
        h d;

        a() {
        }

        public final /* bridge */ /* synthetic */ sg.bigo.ads.common.l.c.c a(sg.bigo.ads.common.l.c.a aVar) {
            return aVar;
        }

        public final /* bridge */ /* synthetic */ void a(sg.bigo.ads.common.l.b.c cVar, sg.bigo.ads.common.l.c.c cVar2) {
            this.a = cVar;
            this.b = (sg.bigo.ads.common.l.c.a) cVar2;
        }

        public final void a(Req req, h hVar) {
            this.a = req;
            this.d = hVar;
        }
    }

    public abstract Res a(sg.bigo.ads.common.l.c.a aVar);

    public void a(Req req) {
    }

    public void a(Req req, String str, int i) {
    }

    public abstract void a(Req req, Res res);

    public abstract void a(Req req, h hVar);

    public boolean a(Req req, int i) {
        return i >= 200 && i < 300;
    }
}
