package sg.bigo.ads.common.d.b;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.common.d.a;

public final class b {
    public static a a(String str) {
        a c = i.c(str);
        if (c != null) {
            return c.b;
        }
        return null;
    }

    public static void a() {
        g.a();
    }

    public static <T> void a(T t) {
        if (t != null) {
            if (t.getClass() == a.class) {
                a((a) t);
            } else if (t instanceof List) {
                List<a> list = (List) t;
                if (list.size() <= 0 || list.get(0).getClass() != a.class) {
                    sg.bigo.ads.common.k.a.a(0, "DownloadHandler", "argument of collect is only Downloader");
                    return;
                }
                for (a a : list) {
                    a(a);
                }
            } else {
                sg.bigo.ads.common.k.a.a(0, "DownloadHandler", "argument is only Downloader or List ");
            }
        }
    }

    public static void a(String str, e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        f a = f.a();
        if (a.a.containsKey(str)) {
            copyOnWriteArrayList = a.a.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
            }
        } else {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        if (!copyOnWriteArrayList.contains(eVar)) {
            copyOnWriteArrayList.add(eVar);
            a.a.put(str, copyOnWriteArrayList);
        }
    }

    private static void a(a aVar) {
        a c = i.c(aVar.a);
        if (c != null) {
            if (c.b.equals(aVar)) {
                c.b(aVar.f);
                c.a(aVar.h);
                c.e = h.a;
                f.a().a(aVar.a);
                return;
            }
            b(aVar.a);
        }
        a aVar2 = new a(aVar);
        aVar2.c = new d(aVar2);
        aVar2.e = h.a;
        i.b(aVar2);
    }

    public static void b() {
        for (a a : i.b()) {
            i.a(a);
        }
        i.a();
    }

    public static <T> void b(T t) {
        if (t != null) {
            if (t.getClass() == String.class) {
                i.b((String) t);
            } else {
                sg.bigo.ads.common.k.a.a(0, "DownloadHandler", "argument is only String or List ");
            }
        }
    }

    public static <T> void c(T t) {
        if (t != null) {
            if (t.getClass() == String.class) {
                i.a((String) t);
            } else {
                sg.bigo.ads.common.k.a.a(0, "DownloadHandler", "argument is only String or List ");
            }
        }
    }
}
