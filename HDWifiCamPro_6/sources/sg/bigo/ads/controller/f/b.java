package sg.bigo.ads.controller.f;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;
import sg.bigo.ads.a.a;
import sg.bigo.ads.api.core.c;

public final class b implements a.c {
    String a;
    String b;
    String c;
    protected long d = -1;
    private final String e = "ChromeTabStatSession";
    private final String f;
    private final c g;
    private final a h;
    private long i = -1;
    private int j = 0;
    private boolean k;
    private boolean l = false;
    private boolean m = false;
    private int n;

    public b(String str, c cVar, a aVar) {
        this.f = str;
        this.g = cVar;
        this.h = aVar;
    }

    private void a(int i2) {
        int i3 = i2;
        if (!this.k && this.g != null) {
            this.k = true;
            this.n = i3;
            long j2 = 0;
            if (this.d > 0) {
                j2 = SystemClock.elapsedRealtime() - this.d;
            }
            sg.bigo.ads.core.d.a.a(this.g, this.f, this.n, i3 == 1 ? 100 : 0, j2, g(), -1, 2, h());
        }
    }

    private boolean g() {
        a aVar = this.h;
        return aVar != null && aVar.d;
    }

    private Map<String, String> h() {
        if (!this.m && TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.c) && TextUtils.isEmpty(this.b)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = "1";
        if (this.m) {
            hashMap.put("tab_aborted", str);
        }
        if (!TextUtils.isEmpty(this.a)) {
            hashMap.put("chrome_pkg", this.a);
        }
        if (!TextUtils.isEmpty(this.c)) {
            if (!TextUtils.equals(this.a, this.c)) {
                str = MBridgeConstans.ENDCARD_URL_TYPE_PL;
            }
            hashMap.put("is_chrome_def", str);
        }
        if (!TextUtils.isEmpty(this.b)) {
            hashMap.put("chrome_ver", this.b);
        }
        return hashMap;
    }

    public final void a() {
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs shown: " + this.f);
        c cVar = this.g;
        if (cVar != null) {
            sg.bigo.ads.core.d.a.a(cVar, 0, 0, g(), -1, 2, h());
        }
        this.i = SystemClock.elapsedRealtime();
    }

    public final void b() {
        c cVar;
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page started: " + this.f);
        this.d = SystemClock.elapsedRealtime();
        this.j = this.j + 1;
        if (!this.l && (cVar = this.g) != null) {
            this.l = true;
            sg.bigo.ads.core.d.a.a(cVar, 1, SystemClock.elapsedRealtime() - this.i, g(), -1, 2, h());
        }
    }

    public final void c() {
        this.m = true;
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page aborted: " + this.f);
    }

    public final void d() {
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page failed: " + this.f);
        a(0);
    }

    public final void e() {
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs page finished: " + this.f);
        a(1);
    }

    public final void f() {
        int i2 = 3;
        sg.bigo.ads.common.k.a.a(0, 3, "ChromeTabStatSession", "Chrome tabs hidden: " + this.f);
        if (this.d < 0) {
            i2 = 2;
        }
        a(i2);
        c cVar = this.g;
        if (cVar != null) {
            sg.bigo.ads.core.d.a.a(cVar, this.n, SystemClock.elapsedRealtime() - this.i, this.j, 0, g(), -1, 2, h());
        }
    }
}
