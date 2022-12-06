package sg.bigo.ads.core.h;

import android.text.TextUtils;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.common.d.c;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.n.b;

public final class a extends c {
    private static final a e = new a();
    private final String f = e.a.i();

    private a() {
        boolean a = e.a.h().a(0);
        if (a) {
            sg.bigo.ads.common.f.c.a(1, new Runnable() {
                public final void run() {
                    a.a(a.this);
                }
            });
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.j()) {
            aVar.a = aVar.i();
            if (!TextUtils.isEmpty(aVar.a)) {
                sg.bigo.ads.common.k.a.a("BannerJsManager", "Fetch banner js from file successfully.");
                aVar.b = true;
            }
        }
        aVar.g();
    }

    public static a k() {
        return e;
    }

    public final String a() {
        return "BannerJsManager";
    }

    public final void a(String str) {
        b.a("sp_banner_js_downloaded_url", str, 3);
    }

    public final boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.equals(str, str2);
    }

    public final String b() {
        return i.f();
    }

    public final boolean b(String str) {
        return true;
    }

    public final String c() {
        return "banner_insert_js.js";
    }

    public final String d() {
        return null;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return (String) b.b("sp_banner_js_downloaded_url", "", 3);
    }
}
