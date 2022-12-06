package sg.bigo.ads.core.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.core.a.k;

public final class f implements k.a {
    final Map<m, b> a;
    public j b;
    public a c;
    private volatile boolean d;

    public static class a {
        /* access modifiers changed from: private */
        public static final f a = new f((byte) 0);
    }

    class b implements Runnable {
        private final m b;

        b(m mVar) {
            this.b = mVar;
        }

        public final void run() {
            m mVar = this.b;
            mVar.d = 5;
            e.a(mVar);
            f.this.a.remove(this.b);
            f.a((List<m>) Collections.singletonList(this.b));
        }
    }

    private f() {
        this.a = new ConcurrentHashMap();
        this.d = false;
    }

    /* synthetic */ f(byte b2) {
        this();
    }

    private void a() {
        if (!this.d) {
            this.d = true;
            k.a(sg.bigo.ads.common.b.a.a, (k.a) this, this.c);
        }
    }

    static void a(List<m> list) {
        if (list != null && !list.isEmpty()) {
            n.a().a(list);
        }
    }

    static /* synthetic */ void a(f fVar, m mVar, long j) {
        fVar.a();
        if (!fVar.a.containsKey(mVar)) {
            mVar.h = System.currentTimeMillis() + j;
            b bVar = new b(mVar);
            fVar.a.put(mVar, bVar);
            if (!mVar.a()) {
                l.a(mVar);
            }
            c.a(1, bVar, j);
        }
    }

    public final void a(int i) {
        j jVar = this.b;
        if (jVar != null && i != jVar.a) {
            j jVar2 = this.b;
            jVar2.a = i;
            if (jVar2.a()) {
                a();
            }
        }
    }

    public final void a(String str, long j) {
        sg.bigo.ads.common.k.a.a(0, 3, "AppCheckReport", "Received app installation: " + str + ", firstInstallTime=" + j);
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(0, str, j);
        }
        ArrayList<m> arrayList = new ArrayList<>();
        for (m next : this.a.keySet()) {
            if (TextUtils.equals(str, next.b)) {
                next.d = 4;
                next.e = System.currentTimeMillis();
                next.f = 1;
                next.g = j;
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            for (m mVar : arrayList) {
                c.a((Runnable) this.a.get(mVar));
                this.a.remove(mVar);
            }
            a((List<m>) arrayList);
        }
    }

    public final void a(String str, long j, long j2) {
        sg.bigo.ads.common.k.a.a(0, 3, "AppCheckReport", "Received app replace: " + str + ", firstInstallTime=" + j + ", lastUpdateTime=" + j2);
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(2, str, j2);
        }
    }

    public final void a(final m mVar, final long j) {
        c.a(1, new Runnable() {
            public final void run() {
                f.a(f.this, mVar, j);
            }
        });
    }

    public final void b(String str, long j) {
        sg.bigo.ads.common.k.a.a(0, 3, "AppCheckReport", "Received app remove: " + str + ", uninstallTime=" + j);
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(1, str, j);
        }
    }
}
