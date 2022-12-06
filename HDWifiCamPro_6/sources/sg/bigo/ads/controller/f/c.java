package sg.bigo.ads.controller.f;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.vungle.warren.model.AdAssetDBAdapter;
import java.util.Map;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.common.utils.s;
import sg.bigo.ads.core.d.a;
import sg.bigo.ads.core.h.e;
import sg.bigo.ads.core.landing.WebViewActivityImpl;

class c extends WebViewActivityImpl {
    private String f;
    private long g = -1;
    private int h = 0;
    private int i;
    private boolean j;
    private boolean k = false;
    private int l;
    private b<?> m;
    private sg.bigo.ads.api.core.c n;
    private int o;
    private a p;
    private boolean r;
    private int s;
    private WebHistoryItem t;

    c(Activity activity) {
        super(activity);
    }

    private void d(int i2) {
        if (!this.j && this.n != null) {
            this.j = true;
            this.l = i2;
            int i3 = 0;
            if (this.b != null) {
                i3 = this.b.getProgress();
            }
            int i4 = i3;
            long j2 = 0;
            if (this.e > 0) {
                j2 = SystemClock.elapsedRealtime() - this.e;
            }
            a.a(this.n, this.d, this.l, i4, j2, e(), this.o, this.s, (Map<String, String>) null);
        }
    }

    private boolean e() {
        a aVar = this.p;
        return aVar != null && aVar.d;
    }

    public final WebView a() {
        a aVar = this.p;
        e eVar = null;
        if (!(aVar == null || !aVar.b() || aVar.f == null)) {
            s.a(aVar.f);
            e eVar2 = aVar.f;
            aVar.f = null;
            eVar = eVar2;
        }
        if (eVar == null) {
            return super.a();
        }
        this.r = true;
        return eVar;
    }

    public final void a(int i2) {
        int i3;
        boolean z = false;
        if (!this.k && (i3 = this.i) > 0 && i3 <= 10000) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.g;
            if (elapsedRealtime > 0 && elapsedRealtime < ((long) i3)) {
                z = true;
            }
        }
        if (!z) {
            super.a(i2);
        }
    }

    public final void a(int i2, String str, String str2) {
        super.a(i2, str, str2);
        d(0);
    }

    public final void a(Intent intent) {
        super.a(intent);
        int intExtra = intent.getIntExtra(AdAssetDBAdapter.AdAssetColumns.COLUMN_AD_ID, -1);
        this.s = intent.getIntExtra("land_way", -1);
        this.m = d.b(intExtra);
        b<?> bVar = this.m;
        if (bVar != null) {
            this.n = bVar.n();
            this.o = this.m.i;
            this.p = this.m.h;
            this.f = this.n.B().d();
            this.i = this.n.b().e();
        }
    }

    public final void a(String str) {
        super.a(str);
        this.k = true;
        d(1);
    }

    public final void a(String str, boolean z) {
        sg.bigo.ads.api.core.c cVar;
        super.a(str, z);
        if (z && (cVar = this.n) != null) {
            a.a(cVar, 1, SystemClock.elapsedRealtime() - this.g, e(), this.o, this.s, (Map<String, String>) null);
        }
        if (this.h == 0) {
            this.d = str;
        }
        this.h++;
    }

    public final void a(sg.bigo.ads.api.core.e eVar) {
        sg.bigo.ads.api.core.c cVar = this.n;
        if (cVar != null) {
            a.a(cVar, 2, eVar);
        }
    }

    public final String b(String str) {
        sg.bigo.ads.api.core.c cVar = this.n;
        return cVar != null ? sg.bigo.ads.core.landing.a.a(cVar.B().g(), this.n.B().h(), str) : super.b(str);
    }

    public final void b() {
        sg.bigo.ads.api.core.c cVar = this.n;
        if (cVar != null) {
            a.a(cVar, 0, 0, e(), this.o, this.s, (Map<String, String>) null);
        }
    }

    public final void c() {
        if (this.c != null) {
            a aVar = this.p;
            if (aVar != null) {
                if (aVar.c == 2 && !o.b(this.p.e)) {
                    this.c.loadDataWithBaseURL(this.d, this.p.e, "text/html", "UTF-8", (String) null);
                    return;
                } else if (this.p.c == 3 && this.r) {
                    this.e = SystemClock.elapsedRealtime();
                    c(this.c.getTitle());
                    if (this.p.d) {
                        if (this.b != null) {
                            this.b.setAlpha(0.0f);
                        }
                        a(this.d);
                        return;
                    }
                    return;
                } else if (this.p.c == 4 && this.r) {
                    this.t = this.c.copyBackForwardList().getCurrentItem();
                }
            }
            sg.bigo.ads.api.core.c cVar = this.n;
            if (cVar != null) {
                this.d = sg.bigo.ads.core.landing.a.a(cVar.B().g(), this.n.B().h(), this.d);
            }
            super.c();
        }
    }

    public final void c(int i2) {
        super.c(i2);
        String str = this.f;
        if (!TextUtils.isEmpty(str)) {
            g.a(new sg.bigo.ads.common.l.b.a(sg.bigo.ads.common.o.a.a(), str), (sg.bigo.ads.common.l.b) null);
        }
        d(this.e < 0 ? 2 : 3);
        sg.bigo.ads.api.core.c cVar = this.n;
        if (cVar != null) {
            a.a(cVar, this.l, SystemClock.elapsedRealtime() - this.g, this.h, i2, e(), this.o, this.s, (Map<String, String>) null);
        }
    }

    public final boolean d() {
        if (this.c == null) {
            return false;
        }
        if (this.t != null) {
            WebBackForwardList copyBackForwardList = this.c.copyBackForwardList();
            int currentIndex = copyBackForwardList.getCurrentIndex();
            if (currentIndex <= 0) {
                return super.d();
            }
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(currentIndex - 1);
            if (itemAtIndex != null) {
                return !TextUtils.equals(this.t.getOriginalUrl(), itemAtIndex.getOriginalUrl()) && !TextUtils.equals(this.t.getUrl(), itemAtIndex.getUrl());
            }
        }
        return super.d();
    }

    public final void n() {
        super.n();
        a aVar = this.p;
        if (aVar != null) {
            aVar.d = false;
            this.p = null;
        }
        b<?> bVar = this.m;
        if (bVar != null) {
            d.c(bVar.hashCode());
            this.m = null;
        }
    }

    public final void p() {
        this.g = SystemClock.elapsedRealtime();
        super.p();
    }
}
