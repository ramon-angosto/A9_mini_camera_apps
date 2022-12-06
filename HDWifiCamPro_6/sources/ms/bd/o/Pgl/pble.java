package ms.bd.o.Pgl;

import java.io.File;
import ms.bd.o.Pgl.pblb;

final class pble extends pblb.pgla {
    pble() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        File file = new File(pgla.a().b().getFilesDir(), (String) pblk.a(16777217, 0, 0, "304015", new byte[]{108, 63, 84, 64, 15, 54, 49}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
