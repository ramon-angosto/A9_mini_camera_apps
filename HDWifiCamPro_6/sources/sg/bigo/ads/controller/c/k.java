package sg.bigo.ads.controller.c;

import android.net.Uri;
import android.os.Build;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.api.core.m;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.i;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.f.a.b;
import sg.bigo.ads.core.f.a.p;
import sg.bigo.ads.core.player.a;
import sg.bigo.ads.core.player.a.d;

public final class k extends b implements n {
    protected int A;
    protected n.b B;
    protected n.d C;
    public int D = 0;
    private p E;
    private m F;
    private boolean G = false;
    private String H;
    protected n.a x;
    protected n.a[] y;
    protected n.c z;

    protected k(long j, h hVar, g gVar, JSONObject jSONObject) {
        super(j, hVar, gVar, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject(RewardPlus.ICON);
        if (optJSONObject != null) {
            this.x = new h(optJSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    arrayList.add(new h(optJSONObject2));
                }
            }
            this.y = new h[arrayList.size()];
            this.y = (n.a[]) arrayList.toArray(this.y);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("video");
        if (optJSONObject3 != null) {
            this.z = new o(optJSONObject3);
        }
        this.B = new i(jSONObject);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_play_cfg");
        if (optJSONObject4 != null) {
            this.C = new p(optJSONObject4);
        }
        this.A = jSONObject.optInt("immersive_ad_type", 0);
    }

    private b al() {
        p pVar = this.E;
        if (pVar != null) {
            return pVar.m;
        }
        return null;
    }

    public final n.a Q() {
        return this.x;
    }

    public final n.c R() {
        return this.z;
    }

    public final n.b S() {
        return this.B;
    }

    public final n.d T() {
        return this.C;
    }

    public final String U() {
        return String.valueOf(this.i);
    }

    public final String V() {
        b al = al();
        if (al != null) {
            return al.c;
        }
        return null;
    }

    public final int W() {
        return this.D;
    }

    public final String X() {
        b al = al();
        String str = al != null ? al.e : null;
        if (o.c(str)) {
            return str;
        }
        p pVar = this.E;
        if (pVar != null) {
            return pVar.n;
        }
        return null;
    }

    public final boolean Y() {
        n.d dVar;
        if (Build.VERSION.SDK_INT >= 21 && (dVar = this.C) != null && dVar.a() && dVar.b() < 100) {
            b al = al();
            if (al != null ? MimeTypes.VIDEO_MP4.equals(al.d) : false) {
                return true;
            }
        }
        return false;
    }

    public final String Z() {
        return V();
    }

    public final void a(String str) {
        if (!o.b(str)) {
            this.H = str;
        }
    }

    public final void a(m mVar) {
        this.F = mVar;
    }

    public final void a(p pVar) {
        this.E = pVar;
        p pVar2 = this.E;
        if (pVar2 != null && o.c(pVar2.l)) {
            B().a(this.E.l);
        }
        this.C.a(ag());
    }

    public final String aa() {
        String X = X();
        if (!o.b(X)) {
            return X;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        return sb.toString();
    }

    public final String ab() {
        return i.b();
    }

    public final String ac() {
        return i.b() + File.separator + aa();
    }

    public final boolean ad() {
        return this.g == 2;
    }

    public final String ae() {
        n.a aVar;
        n.a[] aVarArr = this.y;
        if (aVarArr == null || aVarArr.length <= 0 || (aVar = aVarArr[0]) == null) {
            return null;
        }
        return aVar.a();
    }

    public final String af() {
        Pair pair;
        if (Y()) {
            d b = a.a().b();
            String V = V();
            String b2 = i.b();
            String aa = aa();
            File file = new File(b2, aa);
            if (file.exists()) {
                pair = new Pair(Uri.fromFile(file).toString(), 1);
            } else if (b.d.a()) {
                StringBuilder sb = new StringBuilder(V);
                if (V.contains("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                sb.append("path=");
                sb.append(b2);
                sb.append("&");
                sb.append("name=");
                sb.append(aa);
                pair = new Pair(String.format(Locale.US, "http://%s:%d/%s", new Object[]{"127.0.0.1", Integer.valueOf(b.c), o.g(sb.toString())}), 2);
            } else {
                pair = new Pair(V, 3);
            }
            this.D = ((Integer) pair.second).intValue();
            return (String) pair.first;
        }
        this.D = 0;
        return ac();
    }

    public final long ag() {
        p pVar = this.E;
        if (pVar != null) {
            return pVar.r;
        }
        return 0;
    }

    public final m ah() {
        return this.F;
    }

    public final boolean ai() {
        return this.G;
    }

    public final void aj() {
        this.G = true;
    }

    public final String ak() {
        String str;
        if (!o.b(this.H)) {
            return this.H;
        }
        if (ad()) {
            b al = al();
            if (al != null) {
                this.H = al.d;
            }
            if (!o.b(this.H)) {
                return this.H;
            }
            str = V();
        } else {
            str = ae();
        }
        this.H = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return this.H;
    }

    public final boolean b(long j) {
        n.d dVar = this.C;
        return j >= ((long) (dVar != null ? dVar.b() : 50));
    }

    public final String h() {
        p pVar = this.E;
        return (pVar == null || !o.c(pVar.o)) ? super.h() : this.E.o;
    }

    public final String i() {
        p pVar = this.E;
        return (pVar == null || !o.c(pVar.p)) ? super.i() : this.E.p;
    }
}
