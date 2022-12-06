package sg.bigo.ads.core.f.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class a {
    final List<C0139a> a = new ArrayList();
    public final List<C0139a> b = new ArrayList();

    /* renamed from: sg.bigo.ads.core.f.a.a$a  reason: collision with other inner class name */
    public static final class C0139a {
        public final String a;
        public final String b;
        public final int c;
        public final int d;
        public final String e;

        public C0139a(String str, int i, int i2, String str2, String str3) {
            this.b = str;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.a = str3;
        }

        public final boolean a() {
            return !TextUtils.isEmpty(this.b);
        }

        public final boolean b() {
            return "image/jpeg".equalsIgnoreCase(this.e) || "image/png".equalsIgnoreCase(this.e);
        }

        public final boolean c() {
            return "image/gif".equalsIgnoreCase(this.e);
        }
    }

    public static C0139a a(List<C0139a> list) {
        if (list == null) {
            return null;
        }
        for (C0139a next : list) {
            if (next != null) {
                return next;
            }
        }
        return null;
    }

    public final C0139a a() {
        return a(this.a);
    }
}
