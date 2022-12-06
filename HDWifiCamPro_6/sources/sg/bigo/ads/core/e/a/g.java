package sg.bigo.ads.core.e.a;

import android.text.TextUtils;
import java.util.Map;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.k.a;
import sg.bigo.ads.core.e.a;

public class g {
    /* access modifiers changed from: private */
    public static final String b = g.class.getSimpleName();
    int a = 0;
    private final Map<String, String> c;
    /* access modifiers changed from: private */
    public final o d;
    /* access modifiers changed from: private */
    public final String e;
    /* access modifiers changed from: private */
    public final String f;
    private final String g;
    private final int[] h = {0, 30000, 300000};

    private g(Map<String, String> map, o oVar, String str, String str2, String str3) {
        this.c = map;
        this.d = oVar;
        this.e = str;
        this.f = str2;
        this.g = str3;
    }

    public static g a(Map<String, String> map, o oVar, String str, String str2, String str3) {
        return new g(map, oVar, str, str2, str3);
    }

    /* access modifiers changed from: private */
    public static String b(String str) {
        if (str == null || str.length() < 40) {
            return str;
        }
        return str.substring(0, 20) + "..." + str.substring(str.length() - 10);
    }

    /* access modifiers changed from: private */
    public void b() {
        String str = b;
        a.a(0, 3, str, "Vast tracker request start, action: " + this.e + ", url: " + b(this.f));
        sg.bigo.ads.core.e.a.a(this.e, this.f, this.g, false, this.a, this.c, new a.C0138a() {
            public final void a() {
                String a2 = g.b;
                sg.bigo.ads.common.k.a.a(0, 3, a2, "Vast tracker request error, action: " + g.this.e + ", url: " + g.b(g.this.f));
                g.e(g.this);
            }

            public final boolean a(int i) {
                return g.this.d != null && g.this.d.a(i);
            }

            public final void b() {
                String a2 = g.b;
                sg.bigo.ads.common.k.a.a(0, 3, a2, "Vast tracker request success, action: " + g.this.e + ", url: " + g.b(g.this.f));
            }
        });
    }

    static /* synthetic */ void e(g gVar) {
        if (TextUtils.equals("va_show", gVar.e) || TextUtils.equals("va_cli", gVar.e) || TextUtils.equals("va_cpn_imp", gVar.e) || TextUtils.equals("va_cpn_cli", gVar.e)) {
            gVar.a++;
            gVar.a(gVar.a);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        if (i >= 3) {
            String str = b;
            sg.bigo.ads.common.k.a.a(0, 3, str, "Vast tracker retry time exceed, action: " + this.e + ", url: " + b(this.f));
            return;
        }
        int[] iArr = this.h;
        int i2 = iArr[i % iArr.length];
        if (i2 <= 0) {
            b();
            return;
        }
        String str2 = b;
        sg.bigo.ads.common.k.a.a(0, 3, str2, "Vast tracker retry after " + i2 + " ms, action: " + this.e + ", url: " + b(this.f));
        c.a(1, new Runnable() {
            public final void run() {
                g.this.b();
            }
        }, (long) i2);
    }
}
