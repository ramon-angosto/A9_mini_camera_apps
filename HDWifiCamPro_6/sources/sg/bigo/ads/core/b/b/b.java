package sg.bigo.ads.core.b.b;

import android.content.ContentValues;
import androidx.work.PeriodicWorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import sg.bigo.ads.common.utils.n;
import sg.bigo.ads.common.utils.o;

public final class b {
    final sg.bigo.ads.core.b.a.a a;
    public Set<sg.bigo.ads.common.c.b.a> b;
    public Set<sg.bigo.ads.common.c.b.a> c;
    long d = 0;
    a e;

    static class a {
        int a;
        int b;
        int c;
        int d;

        private a() {
        }

        static a a() {
            a aVar = new a();
            for (boolean z = true; z; z = false) {
                String str = (String) sg.bigo.ads.common.n.b.b("cb_event_count", "", 3);
                if (o.b(str)) {
                    break;
                }
                String[] split = str.split(",");
                if (split.length != 4) {
                    break;
                }
                try {
                    aVar.a = Integer.parseInt(split[0]);
                    aVar.b = Integer.parseInt(split[1]);
                    aVar.c = Integer.parseInt(split[2]);
                    aVar.d = Integer.parseInt(split[3]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            return aVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return ((this.a + this.b) + this.c) + this.d == 0;
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            sg.bigo.ads.common.n.b.a("cb_event_count", toString(), 3);
        }

        public final String toString() {
            return this.a + "," + this.b + "," + this.c + "," + this.d;
        }
    }

    public b(sg.bigo.ads.core.b.a.a aVar) {
        this.a = aVar;
        this.b = n.a(this.a.a);
        this.c = n.a(this.a.a);
        sg.bigo.ads.core.b.c.b.a((Runnable) new Runnable() {
            public final void run() {
                b bVar = b.this;
                sg.bigo.ads.common.k.a.a(0, 3, "EventDbHelper", "clearEventInfo");
                sg.bigo.ads.common.k.a.a(0, 3, "EventDbHelper", "clearEventInfo count = ".concat(String.valueOf((long) sg.bigo.ads.common.c.a.a.b("tb_event", "ctime < ".concat(String.valueOf(System.currentTimeMillis() - ((long) bVar.a.c))), (String[]) null))));
                bVar.b.addAll(bVar.f());
                bVar.d = ((Long) sg.bigo.ads.common.n.b.b("last_stat_cb_events_time", 0, 1)).longValue();
                if (bVar.d == 0) {
                    bVar.d = System.currentTimeMillis();
                }
                bVar.e = a.a();
                bVar.a();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        a aVar = this.e;
        if (aVar != null && !aVar.b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.d;
            if (currentTimeMillis - j >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                sg.bigo.ads.core.d.a.a(j, this.e.a, this.e.b, this.e.c, this.e.d);
                this.d = currentTimeMillis;
                sg.bigo.ads.common.n.a.a(this.d);
                this.e.c();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(List<sg.bigo.ads.common.c.b.a> list, boolean z) {
        this.c.removeAll(list);
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (sg.bigo.ads.common.c.b.a aVar : list) {
                arrayList.add(String.valueOf(aVar.a));
            }
            sg.bigo.ads.common.c.c.a.a((List<String>) arrayList);
            return;
        }
        this.b.addAll(list);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(sg.bigo.ads.common.c.b.a aVar) {
        this.b.add(aVar);
        sg.bigo.ads.common.k.a.a(0, 3, "EventDbHelper", "insertEventInfo:" + aVar.toString());
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_action", aVar.b);
        contentValues.put("event_info", aVar.c);
        contentValues.put("states", Integer.valueOf(aVar.d));
        contentValues.put("ext", aVar.e);
        contentValues.put("ctime", Long.valueOf(aVar.f == 0 ? System.currentTimeMillis() : aVar.f));
        contentValues.put("mtime", Long.valueOf(aVar.g == 0 ? System.currentTimeMillis() : aVar.g));
        aVar.a = sg.bigo.ads.common.c.a.a.a("tb_event", contentValues);
        a();
        a aVar2 = this.e;
        String str = aVar.b;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1274499742:
                if (str.equals("filled")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3327206:
                if (str.equals("load")) {
                    c2 = 0;
                    break;
                }
                break;
            case 120623625:
                if (str.equals("impression")) {
                    c2 = 2;
                    break;
                }
                break;
            case 860524583:
                if (str.equals("clicked")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            aVar2.a++;
        } else if (c2 == 1) {
            aVar2.b++;
        } else if (c2 == 2) {
            aVar2.c++;
        } else if (c2 == 3) {
            aVar2.d++;
        }
        sg.bigo.ads.common.n.b.a("cb_event_count", aVar2.toString(), 3);
    }

    /* access modifiers changed from: package-private */
    public final synchronized List<sg.bigo.ads.common.c.b.a> b() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.b);
        for (sg.bigo.ads.common.c.b.a remove : this.c) {
            arrayList.remove(remove);
        }
        this.b.clear();
        this.c.addAll(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final synchronized int c() {
        return this.b.size();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean d() {
        return this.b.isEmpty();
    }

    public final synchronized void e() {
        if (this.b.isEmpty()) {
            List<sg.bigo.ads.common.c.b.a> f = f();
            for (sg.bigo.ads.common.c.b.a remove : this.c) {
                f.remove(remove);
            }
            this.b.addAll(f);
        }
    }

    /* access modifiers changed from: package-private */
    public final List<sg.bigo.ads.common.c.b.a> f() {
        return sg.bigo.ads.common.c.c.a.a(this.a.a());
    }

    public final synchronized void g() {
        this.c.clear();
        this.b.clear();
    }
}
