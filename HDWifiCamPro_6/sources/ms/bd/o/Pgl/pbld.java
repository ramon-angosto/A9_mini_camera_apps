package ms.bd.o.Pgl;

import android.content.Context;
import ms.bd.o.Pgl.pblb;

final class pbld extends pblb.pgla {
    pbld() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        Context b = pgla.a().b();
        return b != null ? b.getPackageName() : "";
    }
}
