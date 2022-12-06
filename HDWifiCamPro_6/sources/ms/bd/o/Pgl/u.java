package ms.bd.o.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import ms.bd.o.Pgl.pblb;

final class u extends pblb.pgla {
    u() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        Context b = pgla.a().b();
        String[] split = str.split((String) pblk.a(16777217, 0, 0, "cea70a", new byte[]{78, 123}));
        String str2 = split[0];
        String str3 = split[1];
        SharedPreferences.Editor edit = b.getSharedPreferences(str2, 0).edit();
        edit.putString(str3, (String) obj);
        edit.commit();
        return null;
    }
}
