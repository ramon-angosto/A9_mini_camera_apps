package sg.bigo.ads.api;

import java.util.Map;
import sg.bigo.ads.api.core.d;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.common.utils.o;

public abstract class b {
    public final String a;
    public int b;
    public a c;

    public static class a implements h {
        public String a;
        public String b;
        public String c;
        public String d;
        public long e;

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }
    }

    public b(String str) {
        this.a = str;
    }

    public d a() {
        if (o.b(this.a)) {
            return new d(1001, 10001, "Ad slot id cannot be null.");
        }
        return null;
    }

    public abstract int b();

    public Map<String, Object> c() {
        return null;
    }

    public final long d() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.e;
        }
        return 0;
    }
}
