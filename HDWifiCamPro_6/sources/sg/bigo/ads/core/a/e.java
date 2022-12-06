package sg.bigo.ads.core.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import sg.bigo.ads.common.f.c;

public final class e {
    final a a;

    public interface a {
        void a(List<m> list, List<m> list2, long j);
    }

    class b implements Runnable {
        private final LinkedList<m> b;
        private final long c;
        private final List<m> d;
        private final List<m> e;

        private b(List<m> list, long j) {
            this.c = j;
            this.b = new LinkedList<>(list);
            this.d = new ArrayList();
            this.e = new ArrayList();
        }

        /* synthetic */ b(e eVar, List list, long j, byte b2) {
            this(list, j);
        }

        public final void run() {
            List<m> list;
            m poll = this.b.poll();
            if (poll == null) {
                e eVar = e.this;
                List<m> list2 = this.d;
                List<m> list3 = this.e;
                long currentTimeMillis = System.currentTimeMillis();
                if (eVar.a != null) {
                    eVar.a.a(list2, list3, currentTimeMillis);
                    return;
                }
                return;
            }
            if (System.currentTimeMillis() - poll.i <= this.c) {
                poll.d = 0;
                e.a(poll);
                list = this.d;
            } else {
                list = this.e;
            }
            list.add(poll);
            c.a(1, this, 100);
        }
    }

    public e(a aVar) {
        this.a = aVar;
    }

    public static void a(m mVar) {
        mVar.e = System.currentTimeMillis();
        mVar.f = sg.bigo.ads.common.utils.b.d(sg.bigo.ads.common.b.a.a, mVar.b);
        if (mVar.f == 1) {
            mVar.g = sg.bigo.ads.common.utils.b.e(sg.bigo.ads.common.b.a.a, mVar.b);
        }
        sg.bigo.ads.common.k.a.a(0, 3, "AppCheckReport", "Check: " + mVar.b);
    }
}
