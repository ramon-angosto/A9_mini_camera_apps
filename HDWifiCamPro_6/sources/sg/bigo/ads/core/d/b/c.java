package sg.bigo.ads.core.d.b;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import sg.bigo.ads.common.c.b.b;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.core.d.a.a;

public final class c {
    public Set<b> a = n.a(this.c.a);
    public Set<b> b = n.a(this.c.a);
    private final a c;

    public c(a aVar) {
        this.c = aVar;
        sg.bigo.ads.core.d.c.a.a((Runnable) new Runnable() {
            public final void run() {
                c cVar = c.this;
                long currentTimeMillis = System.currentTimeMillis();
                sg.bigo.ads.common.k.a.a(0, 3, "StatsDbHelper", "clearStatInfo");
                sg.bigo.ads.common.k.a.a(0, 3, "StatsDbHelper", "clearStatInfo count = ".concat(String.valueOf((long) sg.bigo.ads.common.c.a.a.b("tb_stat", "expired_ts < ".concat(String.valueOf(currentTimeMillis)), (String[]) null))));
                cVar.a.addAll(cVar.e());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<b> a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.a);
        for (b remove : this.b) {
            arrayList.remove(remove);
        }
        this.a.clear();
        this.b.addAll(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(List<b> list, boolean z) {
        this.b.removeAll(list);
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(String.valueOf(bVar.a));
            }
            sg.bigo.ads.common.c.c.b.a((List<String>) arrayList);
            return;
        }
        this.a.addAll(list);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(b bVar) {
        this.a.add(bVar);
        sg.bigo.ads.common.k.a.a(0, 3, "StatsDbHelper", "insertStatInfo:" + bVar.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_id", bVar.b);
        contentValues.put("event_info", bVar.c);
        contentValues.put("expired_ts", Long.valueOf(bVar.d));
        contentValues.put("ext", bVar.e);
        contentValues.put("ctime", Long.valueOf(bVar.f == 0 ? System.currentTimeMillis() : bVar.f));
        contentValues.put("mtime", Long.valueOf(bVar.g == 0 ? System.currentTimeMillis() : bVar.g));
        bVar.a = sg.bigo.ads.common.c.a.a.a("tb_stat", contentValues);
    }

    /* access modifiers changed from: package-private */
    public final synchronized int b() {
        return this.a.size();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean c() {
        return this.a.isEmpty();
    }

    public final synchronized void d() {
        if (this.a.isEmpty()) {
            List<b> e = e();
            for (b remove : this.b) {
                e.remove(remove);
            }
            this.a.addAll(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final List<b> e() {
        return sg.bigo.ads.common.c.c.b.a(this.c.a());
    }

    public final synchronized void f() {
        this.b.clear();
        this.a.clear();
    }
}
