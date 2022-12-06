package sg.bigo.ads.ad.banner;

import android.os.SystemClock;
import java.util.Map;
import java.util.WeakHashMap;
import sg.bigo.ads.api.Ad;

public final class b {
    private static final Map<C0114b, a> a = new WeakHashMap();

    static final class a {
        final long[] a;

        private a() {
            this.a = new long[9];
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: sg.bigo.ads.ad.banner.b$b  reason: collision with other inner class name */
    public interface C0114b {
    }

    public static <T extends Ad> long a(C0114b bVar, long j) {
        if (j == -1) {
            return -1;
        }
        return j - j(bVar).a[4];
    }

    public static <T extends Ad> void a(C0114b bVar) {
        a(bVar, 0);
    }

    private static <T extends Ad> void a(C0114b bVar, int i) {
        j(bVar).a[i] = SystemClock.elapsedRealtime();
    }

    public static <T extends Ad> void b(C0114b bVar) {
        a(bVar, 1);
    }

    public static <T extends Ad> void c(C0114b bVar) {
        a(bVar, 2);
    }

    public static <T extends Ad> void d(C0114b bVar) {
        a(bVar, 3);
    }

    public static <T extends Ad> void e(C0114b bVar) {
        a(bVar, 4);
    }

    public static <T extends Ad> void f(C0114b bVar) {
        a(bVar, 5);
    }

    public static <T extends Ad> void g(C0114b bVar) {
        a(bVar, 6);
    }

    public static <T extends Ad> void h(C0114b bVar) {
        a.remove(bVar);
    }

    public static <T extends Ad> long i(C0114b bVar) {
        a j = j(bVar);
        return j.a[6] - j.a[4];
    }

    private static <T extends Ad> a j(C0114b bVar) {
        a aVar = a.get(bVar);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a((byte) 0);
        a.put(bVar, aVar2);
        return aVar2;
    }
}
