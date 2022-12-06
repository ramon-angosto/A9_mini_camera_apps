package ms.bd.o.Pgl;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import java.io.Closeable;
import java.io.File;
import ms.bd.o.Pgl.pblb;

public final class pblj {
    public static void a() {
        pblb.a(65537, (pblb.pgla) new pblc());
        pblb.a(65538, (pblb.pgla) new pbld());
        pblb.a(65539, (pblb.pgla) new pble());
        pblb.a((int) InputDeviceCompat.SOURCE_TRACKBALL, (pblb.pgla) new pblf());
        pblb.a(65541, (pblb.pgla) new pblg());
        pblb.a(65542, (pblb.pgla) new pblh());
        pblb.a(65543, (pblb.pgla) new pbli());
        pblb.pgla pbla = pbly.b() ? new pbla() : new pblp();
        pblb.a(196609, pbla);
        pblb.a(196610, pbla);
        pblb.a(196611, pbla);
        pblm pbln = pbly.a() ? new pbln() : new pbll();
        pblm.a(pbln);
        pblb.a(131073, (pblb.pgla) pbln);
        pblb.a(131074, (pblb.pgla) pbln);
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context, String str, String str2) {
        String str3 = str;
        String str4 = str2;
        try {
            String[] list = context.getAssets().list(str3);
            if (list.length > 0) {
                new File(str4).mkdirs();
                for (String str5 : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str3);
                    sb.append((String) pblk.a(16777217, 0, 0, "706181", new byte[]{105}));
                    sb.append(str5);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str4);
                    sb3.append((String) pblk.a(16777217, 0, 0, "f9c19e", new byte[]{56}));
                    sb3.append(str5);
                    b(context, sb2, sb3.toString());
                }
                return true;
            }
            throw null;
        } catch (Exception unused) {
            String str6 = (String) pblk.a(16777217, 0, 0, "ab003d", new byte[]{115, 97, 69});
            return false;
        } catch (Throwable th) {
            Throwable th2 = th;
            pblz.a((Closeable) null);
            pblz.a((Closeable) null);
            throw th2;
        }
    }
}
