package sg.bigo.ads.core.d;

import android.text.TextUtils;
import com.adcolony.sdk.AdColonyAppOptions;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.ui.JavascriptBridge;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import sg.bigo.ads.api.a.e;
import sg.bigo.ads.api.a.g;
import sg.bigo.ads.api.core.c;
import sg.bigo.ads.api.core.h;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.api.core.m;
import sg.bigo.ads.api.core.n;
import sg.bigo.ads.common.utils.j;
import sg.bigo.ads.common.utils.o;
import sg.bigo.ads.core.d.b.d;

public final class a {
    private static int a(i iVar) {
        i.a S = iVar.S();
        if (S == null || !S.a() || !iVar.W()) {
            return 0;
        }
        return j.a((T[]) S.b()) ? 1 : 2;
    }

    public static Map<String, String> a(Map<String, String> map, h hVar) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (hVar == null) {
            return map;
        }
        map.put("session_id", hVar.a());
        map.put("gps_country", hVar.b());
        map.put("sim_country", hVar.c());
        map.put("system_country", hVar.d());
        return map;
    }

    public static Map<String, String> a(g gVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("slot", gVar.k());
        hashMap.put("config_id", String.valueOf(e.a.c()));
        hashMap.put("placement_id", gVar.m());
        hashMap.put("strategy_id", gVar.a());
        hashMap.put("ad_type", String.valueOf(gVar.b()));
        hashMap.put("abflags", o.a(e.a.d(), gVar.n()));
        hashMap.put("auc_mode", String.valueOf(gVar.u()));
        return hashMap;
    }

    public static Map<String, String> a(c cVar, String str, String str2, int i) {
        m ah;
        Map<String, String> b = b(cVar);
        b.put("show_proportion", str);
        b.put("ad_size", str2);
        b.put("render_style", String.valueOf(i));
        if ((cVar instanceof n) && (ah = ((n) cVar).ah()) != null) {
            b.put("creative_size", o.a("%1$d*%2$d", Integer.valueOf(ah.a), Integer.valueOf(ah.b)));
        }
        return b;
    }

    private static Map<String, String> a(c cVar, boolean z, int i, int i2, Map<String, String> map) {
        Map<String, String> b = b(cVar);
        c.b B = cVar.B();
        b.put("preload_t", String.valueOf(B.e()));
        b.put("preload_scene", String.valueOf(B.j()));
        b.put("preload_ready", z ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL);
        b.put("land_way", String.valueOf(i2));
        b.put("click_index", String.valueOf(i));
        b.put("close_limit", String.valueOf(cVar.b().e()));
        if (map != null) {
            b.putAll(map);
        }
        return b;
    }

    public static void a(int i, int i2, String str, int i3) {
        d dVar = new d("06002002");
        dVar.a("rslt", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        dVar.a("e_code", i);
        dVar.a("s_code", i2);
        dVar.a(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
        dVar.a("src", i3);
        a(dVar);
    }

    public static void a(long j, int i, int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put(CampaignEx.JSON_KEY_ST_TS, String.valueOf(j));
        hashMap.put("load_num", String.valueOf(i));
        hashMap.put("fill_num", String.valueOf(i2));
        hashMap.put("imp_num", String.valueOf(i3));
        hashMap.put("click_num", String.valueOf(i4));
        a("06002039", (Map<String, String>) hashMap);
    }

    public static void a(String str, Map<String, String> map) {
        d dVar = new d(str);
        dVar.a(map);
        a(dVar);
    }

    public static void a(String str, boolean z, long j, int i, String str2, int i2, int i3, String str3, String str4, String str5) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("rslt", z ? "1" : MBridgeConstans.ENDCARD_URL_TYPE_PL);
        hashMap.put("cost", String.valueOf(j));
        hashMap.put("res_code", String.valueOf(i));
        hashMap.put("res_msg", String.valueOf(str2));
        hashMap.put("in_fg", String.valueOf(i2));
        hashMap.put("size", String.valueOf(i3));
        c(hashMap);
        hashMap.put("gps_country", str3);
        hashMap.put("sim_country", str4);
        hashMap.put("system_country", str5);
        a("06002015", (Map<String, String>) hashMap);
    }

    public static void a(Map<String, String> map) {
        a("06002013", map);
    }

    public static void a(c cVar) {
        a("06002022", b(cVar));
    }

    public static void a(c cVar, int i, int i2) {
        Map<String, String> b = b(cVar);
        b.put("page_style", String.valueOf(i));
        b.put("page_source", String.valueOf(i2));
        a("06002041", b);
    }

    public static void a(c cVar, int i, int i2, String str) {
        Map hashMap = cVar == null ? new HashMap() : b(cVar);
        hashMap.put("e_code", String.valueOf(i));
        hashMap.put("s_code", String.valueOf(i2));
        hashMap.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
        a("06002035", (Map<String, String>) hashMap);
    }

    public static void a(c cVar, int i, long j) {
        Map<String, String> b = b(cVar);
        b.put("close_source", String.valueOf(i));
        b.put(IronSourceConstants.EVENTS_DURATION, String.valueOf(j));
        a("06002023", b);
    }

    public static void a(c cVar, int i, long j, int i2, int i3, boolean z, int i4, int i5, Map<String, String> map) {
        Map<String, String> a = a(cVar, z, i4, i5, map);
        a.put("rslt", String.valueOf(i));
        a.put(IronSourceConstants.EVENTS_DURATION, String.valueOf(j));
        a.put("num", String.valueOf(i2));
        a.put("close_pos", String.valueOf(i3));
        a("06002028", a);
    }

    public static void a(c cVar, int i, long j, String str, int i2, String str2, String str3) {
        Map<String, String> b = b(cVar);
        b.put("slot", String.valueOf(cVar.a()));
        b.put("rslt", String.valueOf(i));
        b.put("cost", String.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            b.put("url", str);
        }
        if (i2 > 0) {
            b.put("cnt", String.valueOf(i2));
        }
        if (!TextUtils.isEmpty(str2)) {
            b.put("material_type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            b.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str3);
        }
        a("06002042", b);
    }

    public static void a(c cVar, int i, long j, boolean z, int i2, int i3, Map<String, String> map) {
        Map<String, String> a = a(cVar, z, i2, i3, map);
        a.put("status", String.valueOf(i));
        a.put("cost", String.valueOf(j));
        a("06002024", a);
    }

    public static void a(c cVar, int i, String str, int i2) {
        Map<String, String> b = b(cVar);
        b.put("video_stat", String.valueOf(i));
        b.put("video_url", str);
        b.put("path_t", String.valueOf(i2));
        if (cVar instanceof n) {
            n nVar = (n) cVar;
            b.put("video_duration", String.valueOf(nVar.ag()));
            m ah = nVar.ah();
            if (ah != null) {
                b.put("video_actual_duration", String.valueOf(ah.c));
            }
        }
        a("06002017", b);
    }

    public static void a(c cVar, int i, sg.bigo.ads.api.core.e eVar) {
        Map<String, String> b = b(cVar);
        b.put("open_way_gp", String.valueOf(i));
        b.put("open_rslt_gp", String.valueOf(eVar.b));
        b.put("deep_rslt", String.valueOf(eVar.c));
        b.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, eVar.d);
        if (eVar.e != null) {
            b.put("pkg_name", eVar.e.a);
            b.put("pkg_version", eVar.e.b);
            b.put("pkg_install_time", String.valueOf(eVar.e.c));
        }
        a("06002034", b);
    }

    public static void a(c cVar, long j, int i, String str) {
        Map<String, String> b = b(cVar);
        b.put("rslt", MBridgeConstans.ENDCARD_URL_TYPE_PL);
        b.put("cost", String.valueOf(j));
        b.put("e_code", String.valueOf(i));
        b.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
        if (cVar instanceof n) {
            n nVar = (n) cVar;
            b.put("material_type", nVar.ad() ? "2" : "1");
            b.put("media_type", nVar.ak());
        }
        a("06002008", b);
    }

    public static void a(c cVar, String str, int i, int i2, long j, boolean z, int i3, int i4, Map<String, String> map) {
        Map<String, String> a = a(cVar, z, i3, i4, map);
        a.put("load_progress", String.valueOf(i2));
        a.put("load_cost", String.valueOf(j));
        a.put("url", str);
        a.put("rslt", String.valueOf(i));
        a("06002027", a);
    }

    public static void a(c cVar, String str, int i, long j, long j2, int i2, int i3, String str2, boolean z) {
        Map<String, String> b = b(cVar);
        String str3 = "1";
        b.put("rslt", str3);
        b.put("url", str);
        b.put("source", String.valueOf(i));
        b.put("cost", String.valueOf(j));
        b.put("size", String.valueOf(j2));
        b.put("dl_opt", String.valueOf(i2));
        b.put("material_type", String.valueOf(i3));
        b.put("media_type", str2);
        if (!z) {
            str3 = MBridgeConstans.ENDCARD_URL_TYPE_PL;
        }
        b.put("from_breakpoint", str3);
        a("06002018", b);
    }

    public static void a(c cVar, String str, long j, int i, Map<String, String> map) {
        Map<String, String> b = b(cVar);
        b.put("action", str);
        b.put("cost", String.valueOf(j));
        b.put("rslt", String.valueOf(i));
        if (map != null) {
            b.putAll(map);
        }
        a("06002025", b);
    }

    public static void a(c cVar, String str, String str2, long j, long j2, int i, String str3, boolean z) {
        Map<String, String> b = b(cVar);
        String str4 = MBridgeConstans.ENDCARD_URL_TYPE_PL;
        b.put("rslt", str4);
        b.put("url", str);
        b.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str2);
        b.put("cost", String.valueOf(j));
        b.put("size", String.valueOf(j2));
        b.put("material_type", String.valueOf(i));
        b.put("media_type", str3);
        if (z) {
            str4 = "1";
        }
        b.put("from_breakpoint", str4);
        a("06002018", b);
    }

    public static void a(d dVar) {
        Map<String, String> map = dVar.a;
        if (o.b(map.get("session_id"))) {
            map.put("session_id", UUID.randomUUID().toString());
        }
        b.a().a(dVar.b, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> b(sg.bigo.ads.api.core.c r7) {
        /*
            sg.bigo.ads.api.a.g r0 = r7.b()
            java.util.Map r1 = a((sg.bigo.ads.api.a.g) r0)
            java.lang.String r2 = r7.k()
            java.lang.String r3 = "dsp"
            r1.put(r3, r2)
            java.lang.String r2 = r7.g()
            java.lang.String r3 = "ad_id"
            r1.put(r3, r2)
            java.lang.String r2 = r7.o()
            java.lang.String r3 = "creative_id"
            r1.put(r3, r2)
            long r2 = r7.n()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "sid"
            r1.put(r3, r2)
            java.lang.String r2 = r7.p()
            java.lang.String r3 = "series_id"
            r1.put(r3, r2)
            int r2 = r7.l()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "adx_type"
            r1.put(r3, r2)
            boolean r2 = r7 instanceof sg.bigo.ads.api.core.i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x006a
            r2 = r7
            sg.bigo.ads.api.core.i r2 = (sg.bigo.ads.api.core.i) r2
            boolean r5 = r2.U()
            if (r5 == 0) goto L_0x0058
            java.lang.String r5 = "1"
            goto L_0x005a
        L_0x0058:
            java.lang.String r5 = "0"
        L_0x005a:
            java.lang.String r6 = "banner_type"
            r1.put(r6, r5)
            int r2 = a((sg.bigo.ads.api.core.i) r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = "banner_preload"
            goto L_0x009e
        L_0x006a:
            boolean r2 = r7 instanceof sg.bigo.ads.api.core.n
            if (r2 == 0) goto L_0x00a1
            r2 = r7
            sg.bigo.ads.api.core.n r2 = (sg.bigo.ads.api.core.n) r2
            int r5 = r2.l()
            if (r5 == r4) goto L_0x0094
            if (r5 == r3) goto L_0x007a
            goto L_0x00a1
        L_0x007a:
            sg.bigo.ads.api.core.n$d r5 = r2.T()
            if (r5 == 0) goto L_0x008c
            sg.bigo.ads.api.core.n$d r2 = r2.T()
            boolean r2 = r2.c()
            if (r2 == 0) goto L_0x008c
            r2 = r4
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = "video_type"
            goto L_0x009e
        L_0x0094:
            int r2 = r0.d()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = "native_filled_type"
        L_0x009e:
            r1.put(r5, r2)
        L_0x00a1:
            java.lang.String r2 = r7.A()
            java.lang.String r5 = "mapping_slot"
            r1.put(r5, r2)
            java.lang.String r2 = r7.w()
            java.lang.String r5 = "enc_price"
            r1.put(r5, r2)
            java.lang.String r2 = r7.x()
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x00cc
            java.lang.String r5 = "abflags"
            java.lang.Object r6 = r1.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r2 = sg.bigo.ads.common.utils.o.a((java.lang.String) r6, (java.lang.String) r2)
            r1.put(r5, r2)
        L_0x00cc:
            int r0 = r0.b()
            boolean r0 = sg.bigo.ads.api.core.b.b(r0)
            if (r0 == 0) goto L_0x00df
            java.lang.String r0 = r7.G()
            java.lang.String r2 = "style_id"
            r1.put(r2, r0)
        L_0x00df:
            int r0 = r7.I()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "is_playable"
            r1.put(r2, r0)
            int r0 = r7.I()
            if (r0 == r4) goto L_0x00f8
            int r0 = r7.I()
            if (r0 != r3) goto L_0x0105
        L_0x00f8:
            int r0 = r7.J()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "companion_type"
            r1.put(r2, r0)
        L_0x0105:
            int r0 = r7.d()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "style_source"
            r1.put(r2, r0)
            int r0 = r7.O()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "auc_mode"
            r1.put(r2, r0)
            sg.bigo.ads.api.core.h r7 = r7.E()
            a((java.util.Map<java.lang.String, java.lang.String>) r1, (sg.bigo.ads.api.core.h) r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.d.a.b(sg.bigo.ads.api.core.c):java.util.Map");
    }

    public static void b(Map<String, String> map) {
        a("06002014", map);
    }

    public static void b(c cVar, String str, String str2, int i) {
        a("06002043", a(cVar, str, str2, i));
    }

    public static void c(Map<String, String> map) {
        int a = sg.bigo.ads.common.n.a.a();
        int b = sg.bigo.ads.common.n.a.b();
        if (a != 0 || b != 0) {
            String str = "";
            String str2 = a == 1 ? AdColonyAppOptions.GDPR : str;
            if (b == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                if (str2.length() != 0) {
                    str = "&";
                }
                sb.append(str);
                sb.append(AdColonyAppOptions.CCPA);
                str2 = sb.toString();
            }
            map.put(JavascriptBridge.MraidHandler.PRIVACY_ACTION, str2);
            map.put("consent", "1");
        }
    }
}
