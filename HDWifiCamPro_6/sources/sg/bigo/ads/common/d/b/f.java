package sg.bigo.ads.common.d.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

final class f {
    private static f b = new f();
    HashMap<String, CopyOnWriteArrayList<e>> a = new HashMap<>();

    /* renamed from: sg.bigo.ads.common.d.b.f$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[h.a().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0031 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        static {
            /*
                int[] r0 = sg.bigo.ads.common.d.b.h.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                r0 = 1
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = sg.bigo.ads.common.d.b.h.a     // Catch:{ NoSuchFieldError -> 0x0011 }
                int r2 = r2 - r0
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0011 }
            L_0x0011:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = sg.bigo.ads.common.d.b.h.b     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r2 = r2 - r0
                r3 = 2
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = sg.bigo.ads.common.d.b.h.c     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2 - r0
                r3 = 3
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = sg.bigo.ads.common.d.b.h.d     // Catch:{ NoSuchFieldError -> 0x0029 }
                int r2 = r2 - r0
                r3 = 4
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = sg.bigo.ads.common.d.b.h.e     // Catch:{ NoSuchFieldError -> 0x0031 }
                int r2 = r2 - r0
                r3 = 5
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r2 = sg.bigo.ads.common.d.b.h.f     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r2 = r2 - r0
                r3 = 6
                r1[r2] = r3     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0041 }
                int r2 = sg.bigo.ads.common.d.b.h.g     // Catch:{ NoSuchFieldError -> 0x0041 }
                int r2 = r2 - r0
                r0 = 7
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0041 }
            L_0x0041:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.d.b.f.AnonymousClass1.<clinit>():void");
        }
    }

    f() {
    }

    protected static f a() {
        return b;
    }

    private void a(String str, e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.a.containsKey(str) && (copyOnWriteArrayList = this.a.get(str)) != null && copyOnWriteArrayList.contains(eVar)) {
            copyOnWriteArrayList.remove(eVar);
        }
    }

    private void a(a aVar, CopyOnWriteArrayList<e> copyOnWriteArrayList) {
        switch (AnonymousClass1.a[aVar.e - 1]) {
            case 1:
                Iterator<e> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    it.next();
                }
                return;
            case 2:
                Iterator<e> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
                return;
            case 3:
                Iterator<e> it3 = copyOnWriteArrayList.iterator();
                while (it3.hasNext()) {
                    it3.next().a(aVar.a);
                }
                return;
            case 4:
                Iterator<e> it4 = copyOnWriteArrayList.iterator();
                while (it4.hasNext()) {
                    String str = aVar.a;
                    j.a(aVar.d);
                    it4.next().b(str);
                }
                return;
            case 5:
                Iterator<e> it5 = copyOnWriteArrayList.iterator();
                while (it5.hasNext()) {
                    it5.next().c(aVar.a);
                }
                return;
            case 6:
                Iterator<e> it6 = copyOnWriteArrayList.iterator();
                while (it6.hasNext()) {
                    e next = it6.next();
                    next.d(aVar.a);
                    a(aVar.a, next);
                }
                return;
            case 7:
                Iterator<e> it7 = copyOnWriteArrayList.iterator();
                while (it7.hasNext()) {
                    e next2 = it7.next();
                    next2.b(aVar.a, aVar.f);
                    a(aVar.a, next2);
                }
                return;
            default:
                return;
        }
    }

    public final void a(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        a c;
        if (this.a.containsKey(str) && (copyOnWriteArrayList = this.a.get(str)) != null && (c = i.c(str)) != null) {
            a(c, (CopyOnWriteArrayList<e>) copyOnWriteArrayList);
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str) {
        if (this.a.containsKey(str) && this.a.get(str) != null) {
            this.a.get(str).clear();
        }
    }
}
