package ms.bd.o.Pgl;

import java.util.Locale;
import ms.bd.o.Pgl.pblb;

final class j0 extends pblb.pgla {
    j0() {
    }

    public Object a(int i, long j, String str, Object obj) throws Throwable {
        String str2;
        try {
            Locale locale = pgla.a().b().getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder();
            sb.append(language);
            sb.append((String) pblk.a(16777217, 0, 0, "4a3a24", new byte[]{26}));
            sb.append(country);
            str2 = sb.toString();
        } catch (Throwable unused) {
            str2 = null;
        }
        return z0.a(str2);
    }
}
