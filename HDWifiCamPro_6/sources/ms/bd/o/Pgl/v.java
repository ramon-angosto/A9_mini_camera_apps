package ms.bd.o.Pgl;

import android.content.Context;
import android.content.Intent;
import ms.bd.o.Pgl.pblb;

final class v extends pblb.pgla {
    v() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        Context b = pgla.a().b();
        String[] strArr = (String[]) obj;
        if (b == null || str == null || strArr == null || strArr.length % 2 != 0) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.setPackage(b.getPackageName());
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            intent.putExtra(strArr[i2], strArr[i2 + 1]);
        }
        b.sendBroadcast(intent);
        return null;
    }
}
