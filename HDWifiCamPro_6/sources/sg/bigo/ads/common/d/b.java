package sg.bigo.ads.common.d;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import sg.bigo.ads.common.d.b.e;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.o;

public final class b implements e {
    public final CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<a> c = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<a> d = new CopyOnWriteArrayList<>();
    final a e;
    private final sg.bigo.ads.common.d.a.a f;

    public interface a {
        void a(a aVar);

        void a(a aVar, int i, long j);

        void a(a aVar, String str, long j);
    }

    public b(sg.bigo.ads.common.d.a.a aVar, a aVar2) {
        this.e = aVar2;
        sg.bigo.ads.common.d.b.b.a();
        this.f = aVar;
    }

    private static a a(List<a> list, String str, String str2) {
        if (o.b(str) || o.b(str2)) {
            return null;
        }
        for (a next : list) {
            if (TextUtils.equals(str, next.c) && TextUtils.equals(str2, next.d)) {
                return next;
            }
        }
        return null;
    }

    private static a a(List<a> list, a aVar) {
        int indexOf = list.indexOf(aVar);
        if (indexOf < 0) {
            return null;
        }
        try {
            return list.get(indexOf);
        } catch (Exception e2) {
            a("getExistDownloadInfo e=" + e2.getMessage(), (a) null);
            return null;
        }
    }

    private static a a(List<a> list, boolean z) {
        for (a next : list) {
            boolean z2 = true;
            if (z) {
                int i = 300000;
                if (next.j >= 3) {
                    i = 1800000;
                }
                if (next.k <= 0 || System.currentTimeMillis() - next.k <= ((long) i)) {
                    z2 = false;
                }
            }
            if (z2) {
                return next;
            }
            a("no download info execute.", next);
        }
        return null;
    }

    public static void a(String str, a aVar) {
        String aVar2 = aVar != null ? aVar.toString() : null;
        sg.bigo.ads.common.k.a.a(0, 3, "DownloadManager", str + ", download info = " + aVar2);
    }

    private void a(a aVar) {
        aVar.l = SystemClock.elapsedRealtime();
        a("execute download start", aVar);
        if (sg.bigo.ads.common.utils.e.b(aVar.c, aVar.d)) {
            a("executeDownload use local file", aVar);
            sg.bigo.ads.common.utils.e.c(aVar.c, aVar.d);
            aVar.i = 3;
            aVar.h = sg.bigo.ads.common.utils.e.a(aVar.a(), 1);
            this.a.remove(aVar);
            this.b.add(aVar);
            this.e.a(aVar, 0, 0);
            a();
        } else if (!n.b()) {
            this.a.remove(aVar);
            this.e.a(aVar, "internal storage is not enough", SystemClock.elapsedRealtime() - aVar.l);
            a();
        } else {
            sg.bigo.ads.common.d.b.b.a(aVar);
            sg.bigo.ads.common.d.b.b.a(aVar.a, this);
            a("execute downloader", aVar);
            sg.bigo.ads.common.d.b.b.c(aVar.a);
        }
    }

    private boolean b() {
        return this.a.size() < this.f.a;
    }

    public final a a(String str, String str2) {
        if (o.b(str) || o.b(str2)) {
            return null;
        }
        a a2 = a(this.a, str, str2);
        if (a2 == null) {
            a2 = a(this.b, str, str2);
        }
        if (a2 == null) {
            a2 = a(this.c, str, str2);
        }
        return a2 == null ? a(this.d, str, str2) : a2;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!sg.bigo.ads.common.n.a.c()) {
            a("continue to execute download task", (a) null);
            if (!b()) {
                a("no idle download thread", (a) null);
                return;
            }
            a a2 = a((List<a>) this.c, false);
            if (a2 != null) {
                a("waiting to downloading", a2);
                this.c.remove(a2);
            }
            if (a2 == null && (a2 = a((List<a>) this.d, true)) != null) {
                a("failed to downloading", a2);
                this.d.remove(a2);
            }
            if (a2 != null) {
                this.a.add(a2);
                a(a2);
                return;
            }
            a("no download info execute.", (a) null);
        }
    }

    public final void a(String str) {
        final a a2 = sg.bigo.ads.common.d.b.b.a(str);
        if (a2 == null) {
            a("onStart info is null.", (a) null);
        } else {
            c.a(1, new Runnable() {
                public final void run() {
                    b.this.e.a(a2);
                }
            });
        }
    }

    public final void a(a aVar, boolean z) {
        a("start the download, force=".concat(String.valueOf(z)), aVar);
        if (sg.bigo.ads.common.utils.e.b(aVar.a())) {
            a("downloaded and exist local file", aVar);
            sg.bigo.ads.common.utils.e.c(aVar.c, aVar.d);
            this.e.a(aVar, 0, 0);
        } else if (a((List<a>) this.a, aVar) != null) {
            a("downloading", aVar);
        } else if (this.f.b()) {
            this.e.a(aVar, "Unable to download media file.", 0);
        } else {
            a a2 = a((List<a>) this.c, aVar);
            if (a2 != null) {
                a("waiting", aVar);
                a2.b = aVar.b;
                if (!z && !b()) {
                    a("waiting not executing", aVar);
                    return;
                }
            }
            a a3 = a((List<a>) this.d, aVar);
            if (a3 != null) {
                a("failed", aVar);
                this.d.remove(a3);
                a3.b = aVar.b;
                a3.i = 0;
                aVar = a3;
            }
            if (b() || z) {
                a("execute download", aVar);
                aVar.m = z;
                this.a.add(aVar);
                a(aVar);
                return;
            }
            a("join download waiting queue", aVar);
            this.c.add(aVar);
        }
    }

    public final void b(String str) {
        boolean z;
        final a a2 = sg.bigo.ads.common.d.b.b.a(str);
        if (a2 == null) {
            a("onLoading info is null.", (a) null);
            return;
        }
        if (a2.i != 1) {
            a("onLoading", a2);
            a2.i = 1;
        }
        if (a2.h <= 0 || (a2.f - a2.g) * 100 <= a2.h * 10) {
            z = false;
        } else {
            a2.g = a2.f;
            z = true;
        }
        if (z && a2.c() && sg.bigo.ads.common.p.c.a(sg.bigo.ads.common.b.a.a)) {
            final long elapsedRealtime = SystemClock.elapsedRealtime() - a2.l;
            a("partial download callback", a2);
            c.a(1, new Runnable() {
                public final void run() {
                    b.this.e.a(a2, 2, elapsedRealtime);
                }
            });
        }
    }

    public final void b(final String str, final String str2) {
        c.a(1, new Runnable() {
            public final void run() {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                a a2 = sg.bigo.ads.common.d.b.b.a(str);
                if (a2 != null) {
                    b.a("download failed", a2);
                    a2.i = 4;
                    if (!a2.m) {
                        a2.j++;
                    }
                    a2.k = System.currentTimeMillis();
                    b.this.e.a(a2, str2, elapsedRealtime - a2.l);
                    b.a("download failed update fail count", a2);
                    b.this.a.remove(a2);
                    b.this.d.add(a2);
                    b.a("downloading to failed", a2);
                    b.this.a();
                }
            }
        });
    }

    public final void c(String str) {
        a a2 = sg.bigo.ads.common.d.b.b.a(str);
        if (a2 != null) {
            a2.i = 2;
        }
    }

    public final void d(final String str) {
        c.a(1, new Runnable() {
            public final void run() {
                a a2 = sg.bigo.ads.common.d.b.b.a(str);
                if (a2 != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b.a("download succeed", a2);
                    a2.i = 3;
                    b.this.a.remove(a2);
                    b.this.b.add(a2);
                    b.this.e.a(a2, 1, elapsedRealtime - a2.l);
                    b.a("downloading to downloaded", a2);
                    sg.bigo.ads.common.d.b.b.b(a2.a);
                    b.this.a();
                }
            }
        });
    }
}
