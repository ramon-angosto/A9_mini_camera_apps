package sg.bigo.ads.core.player;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.iab.omid.library.bigosg.c.f;
import com.iab.omid.library.bigosg.e.d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import sg.bigo.ads.common.l.g;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.c.b;
import sg.bigo.ads.core.e.a.a;
import sg.bigo.ads.core.f.a.l;
import sg.bigo.ads.core.f.a.n;
import sg.bigo.ads.core.f.a.p;

public final class c {
    public final p a;
    public boolean b;
    public boolean c;
    public boolean d;
    public b e;
    public boolean f;
    public boolean g = false;
    private boolean h = false;
    private final a i;
    private final List<Integer> j = new ArrayList(4);
    private final List<Integer> k = new ArrayList(5);

    public c(p pVar, a aVar) {
        this.a = pVar;
        this.i = aVar;
        this.j.add(0);
        this.j.add(25);
        this.j.add(50);
        this.j.add(75);
        this.k.add(2000);
        this.k.add(Integer.valueOf(PathInterpolatorCompat.MAX_NUM_POINTS));
        this.k.add(Integer.valueOf(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS));
        this.k.add(8000);
        this.k.add(10000);
    }

    private static String a(String str) {
        if (o.b(str)) {
            return "";
        }
        String a2 = o.a(str, "[TIMESTAMP]", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()), true);
        StringBuilder sb = new StringBuilder();
        sb.append(((int) (Math.random() * 9.0E7d)) + 10000000);
        return o.a(a2, "[CACHEBUSTING]", sb.toString(), true);
    }

    public static void a(List<n> list) {
        if (list != null) {
            for (n next : list) {
                if (next != null) {
                    String str = next.b;
                    if (o.b(str) || (next.c && !next.d)) {
                        sg.bigo.ads.common.k.a.a(0, "VASTController", "invalidate tracking url or is tracked");
                    } else {
                        g.a(new sg.bigo.ads.common.l.b.a(str), (sg.bigo.ads.common.l.b) null);
                    }
                }
            }
        }
    }

    public static void a(sg.bigo.ads.api.core.n nVar, int i2) {
        sg.bigo.ads.core.d.a.a((sg.bigo.ads.api.core.c) nVar, i2, nVar.V(), nVar.W());
    }

    public final void a() {
        if (!this.h) {
            a((List<? extends n>) this.a.i, "va_cli");
        }
    }

    public final void a(String str, List<n> list) {
        if (list != null) {
            Iterator<n> it = list.iterator();
            while (it.hasNext()) {
                n next = it.next();
                String str2 = next.b;
                if (o.b(str2) || (next.c && !next.d)) {
                    sg.bigo.ads.common.k.a.a(0, "VASTController", "invalidate tracking url or is tracked");
                } else {
                    String a2 = a(str2);
                    String a3 = o.b(a2) ? "" : o.a(a2, "[ERRORCODE]", str, false);
                    next.c = true;
                    if (!o.b(a3)) {
                        this.i.a("va_err", a3, "bigoad");
                        sg.bigo.ads.common.k.a.a(0, 3, "VASTController", "Send track info, action: va_err, url: ".concat(String.valueOf(a3)));
                    }
                }
                it.remove();
            }
        }
    }

    public final void a(n nVar, String str) {
        String str2 = nVar.b;
        if (o.b(str2) || (nVar.c && !nVar.d)) {
            sg.bigo.ads.common.k.a.a(0, "VASTController", "invalidate tracking url or is tracked");
            return;
        }
        String a2 = a(str2);
        nVar.c = true;
        if (!o.b(a2)) {
            this.i.a(str, a2, "bigoad");
            sg.bigo.ads.common.k.a.a(0, 3, "VASTController", "Send track info, action: " + str + ", url: " + a2);
        }
    }

    public final void a(int[] iArr, sg.bigo.ads.api.core.n nVar) {
        b bVar;
        int i2;
        if (iArr != null && iArr.length > 2) {
            int i3 = iArr[0];
            int i4 = iArr[2];
            Iterator<l> it = this.a.b.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (((float) i4) >= next.a) {
                    a((n) next, "va_prog1");
                    it.remove();
                }
            }
            Iterator<sg.bigo.ads.core.f.a.c> it2 = this.a.c.iterator();
            while (it2.hasNext()) {
                sg.bigo.ads.core.f.a.c next2 = it2.next();
                if (i3 >= next2.a) {
                    a((n) next2, "va_prog2");
                    it2.remove();
                }
            }
            Iterator<Integer> it3 = this.k.iterator();
            while (it3.hasNext()) {
                int intValue = it3.next().intValue();
                if (i3 >= intValue) {
                    if (intValue == 2000) {
                        intValue = 11;
                    } else if (intValue == 3000) {
                        intValue = 12;
                    } else if (intValue == 5000) {
                        intValue = 13;
                    } else if (intValue == 8000) {
                        intValue = 14;
                    } else if (intValue == 10000) {
                        intValue = 15;
                    }
                    a(nVar, intValue);
                    it3.remove();
                }
            }
            Iterator<Integer> it4 = this.j.iterator();
            while (it4.hasNext()) {
                int intValue2 = it4.next().intValue();
                if (i4 >= intValue2) {
                    if (intValue2 != 0) {
                        if (intValue2 == 25) {
                            intValue2 = 3;
                            bVar = this.e;
                            if (bVar != null) {
                                i2 = b.C0135b.a;
                            }
                        } else if (intValue2 == 50) {
                            intValue2 = 4;
                            bVar = this.e;
                            if (bVar != null) {
                                i2 = b.C0135b.b;
                            }
                        } else if (intValue2 == 75) {
                            intValue2 = 5;
                            bVar = this.e;
                            if (bVar != null) {
                                i2 = b.C0135b.c;
                            }
                        }
                        bVar.a(i2);
                    } else {
                        b bVar2 = this.e;
                        if (bVar2 != null) {
                            float f2 = (float) this.a.r;
                            float f3 = this.f ? 0.0f : 1.0f;
                            if (bVar2.a != null) {
                                com.iab.omid.library.bigosg.b.a.b bVar3 = bVar2.a;
                                if (f2 > 0.0f) {
                                    com.iab.omid.library.bigosg.b.a.b.a(f3);
                                    d.b(bVar3.a);
                                    JSONObject jSONObject = new JSONObject();
                                    com.iab.omid.library.bigosg.e.b.a(jSONObject, IronSourceConstants.EVENTS_DURATION, Float.valueOf(f2));
                                    com.iab.omid.library.bigosg.e.b.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f3));
                                    com.iab.omid.library.bigosg.e.b.a(jSONObject, "deviceVolume", Float.valueOf(f.a().a));
                                    bVar3.a.c.a("start", jSONObject);
                                    bVar2.b = true;
                                    bVar2.a("video start, duration: " + f2 + ", volume: " + f3);
                                } else {
                                    throw new IllegalArgumentException("Invalid Media duration");
                                }
                            }
                        }
                        intValue2 = 2;
                    }
                    a(nVar, intValue2);
                    it4.remove();
                }
            }
        }
    }

    public final boolean a(List<? extends n> list, String str) {
        Iterator<? extends n> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (str.equals("va_cpn_cli")) {
                this.h = true;
            }
            a((n) it.next(), str);
            it.remove();
            z = true;
        }
        return z;
    }

    public final void b() {
        a((List<? extends n>) this.a.x, "va_cpn_imp");
    }
}
