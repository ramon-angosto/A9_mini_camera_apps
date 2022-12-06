package ms.bd.o.Pgl;

import android.content.Context;
import android.content.pm.Signature;
import ms.bd.o.Pgl.pblb;

final class n extends pblb.pgla {
    n() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        Context b = pgla.a().b();
        Signature[] signatureArr = b.getPackageManager().getPackageInfo(b.getPackageName(), 64).signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        return signatureArr[0].toByteArray();
    }
}
