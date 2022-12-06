package com.mbridge.msdk.foundation.same.b;

import android.util.Log;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: MBridgeDirManager */
public final class e {
    private static e c;
    private b a;
    private ArrayList<a> b = new ArrayList<>();

    private e(b bVar) {
        this.a = bVar;
    }

    public static synchronized void a(b bVar) {
        synchronized (e.class) {
            if (c == null) {
                c = new e(bVar);
            }
        }
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (c == null && com.mbridge.msdk.foundation.controller.a.e().g() != null) {
                s.a(com.mbridge.msdk.foundation.controller.a.e().g());
            }
            if (c == null) {
                Log.e("MBridgeDirManager", "mDirectoryManager == null");
            }
            eVar = c;
        }
        return eVar;
    }

    public static File a(c cVar) {
        try {
            if (a() == null || a().b == null || a().b.size() <= 0) {
                return null;
            }
            Iterator<a> it = a().b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a.equals(cVar)) {
                    return next.b;
                }
            }
            return null;
        } catch (Throwable th) {
            q.a("MBridgeDirManager", th.getMessage(), th);
            return null;
        }
    }

    public static String b(c cVar) {
        File a2 = a(cVar);
        if (a2 != null) {
            return a2.getAbsolutePath();
        }
        return null;
    }

    public final boolean b() {
        return a(this.a.a());
    }

    private boolean a(a aVar) {
        String str;
        a c2 = aVar.c();
        if (c2 == null) {
            str = aVar.b();
        } else {
            File a2 = a(c2.a());
            if (a2 == null) {
                return false;
            }
            str = a2.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(str);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.b.add(new a(aVar.a(), file));
        List<a> d = aVar.d();
        if (d != null) {
            for (a a3 : d) {
                if (!a(a3)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* compiled from: MBridgeDirManager */
    private static final class a {
        public c a;
        public File b;

        public a(c cVar, File file) {
            this.a = cVar;
            this.b = file;
        }
    }
}
