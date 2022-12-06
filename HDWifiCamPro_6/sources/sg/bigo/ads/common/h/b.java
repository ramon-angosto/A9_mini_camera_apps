package sg.bigo.ads.common.h;

import android.util.LruCache;
import sg.bigo.ads.common.utils.n;

public final class b {
    public final LruCache<String, sg.bigo.ads.common.b> a;
    private final int b;

    public static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);
    }

    private b() {
        this.b = n.c(sg.bigo.ads.common.b.a.a);
        sg.bigo.ads.common.k.a.a(0, 3, "BitmapCacheManager", "Total cache size: " + this.b);
        this.a = new LruCache<String, sg.bigo.ads.common.b>(this.b) {
            /* access modifiers changed from: protected */
            public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                return ((sg.bigo.ads.common.b) obj2).a.getByteCount();
            }
        };
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    public final sg.bigo.ads.common.b a(String str) {
        return this.a.get(str);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, sg.bigo.ads.common.b bVar) {
        if (!bVar.a.isRecycled()) {
            this.a.put(str, bVar);
            sg.bigo.ads.common.k.a.a(0, 3, "BitmapCacheManager", "The left cache size: " + (this.b - this.a.size()));
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str) {
        this.a.remove(str);
    }
}
