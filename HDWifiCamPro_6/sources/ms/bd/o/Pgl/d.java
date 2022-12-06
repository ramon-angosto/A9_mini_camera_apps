package ms.bd.o.Pgl;

import java.io.File;
import ms.bd.o.Pgl.pblb;

final class d extends pblb.pgla {
    d() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        File file = new File(pgla.a().b().getFilesDir(), (String) pblk.a(16777217, 0, 0, "d556c6", new byte[]{59, 58, 85, 70, 93, 53, 102}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
