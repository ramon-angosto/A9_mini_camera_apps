package com.mbridge.msdk.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.tools.h;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.l;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Setting */
public final class a {
    private int A = 120;
    private String B = "";
    private int C = 1;
    private int D = 1;
    private int E = 1;
    private int F = 0;
    private int G = 1;
    private int H = 0;
    private String I;
    private int J = 30;
    private int K = 5;
    private int L = 0;
    private int M = 0;
    private int N = 9377;
    private int O = 0;
    private int P = 0;
    private int Q = 0;
    private int R = 2;
    private int S = 10;
    private List<Integer> T = new ArrayList();
    private long U;
    private int V;
    private String W = "";
    private String X = "";
    private String Y = "";
    private String Z = "";
    private int a = 0;
    private String aa = "";
    private String ab = "";
    private String ac = "";
    private String ad = "";
    private String ae = "";
    private String af = "";
    private Map<String, C0056a> ag;
    private int ah = 0;
    private b ai;
    private int aj = 0;
    private String ak = "";
    private String al;
    private String am;
    private int an = 0;
    private boolean ao = false;
    private int ap = 120;
    private ArrayList<Integer> aq;
    private HashMap<String, String> ar;
    private int as = 0;
    private int at = 0;
    private String b;
    private int c;
    private long d = 86400;
    private long e;
    private Map<String, String> f;
    private boolean g;
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private int n;
    private int o;
    private long p;
    private int q;
    private int r;
    private String s;
    private int t;
    private List<com.mbridge.msdk.foundation.entity.a> u;
    private boolean v = false;
    private int w = 3;
    private boolean x = true;
    private int y;
    private String z = d.c().c;

    public final void a(int i2) {
        this.y = i2;
    }

    public final int a() {
        return this.y;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> b() {
        return this.u;
    }

    public final String c() {
        return this.B;
    }

    public final int d() {
        return this.A;
    }

    public final void b(int i2) {
        this.A = i2;
    }

    public final int e() {
        return this.a;
    }

    public final void c(int i2) {
        this.a = i2;
    }

    public final void d(int i2) {
        if (i2 > 0) {
            this.S = i2;
        }
    }

    public final int f() {
        return this.S;
    }

    public final void e(int i2) {
        this.O = i2;
    }

    public final int g() {
        return this.O;
    }

    public final void f(int i2) {
        this.P = i2;
    }

    public final int h() {
        return this.P;
    }

    public final void g(int i2) {
        this.Q = i2;
    }

    public final int i() {
        return this.Q;
    }

    public final void h(int i2) {
        this.R = i2;
    }

    public final int j() {
        return this.R;
    }

    public final String k() {
        return this.z;
    }

    public final boolean i(int i2) {
        return this.T.contains(Integer.valueOf(i2));
    }

    public final int l() {
        return this.C;
    }

    public final void j(int i2) {
        this.C = i2;
    }

    public final int m() {
        return this.D;
    }

    public final void k(int i2) {
        this.D = i2;
    }

    public final int n() {
        return this.E;
    }

    public final void l(int i2) {
        this.E = i2;
    }

    public final int o() {
        return this.F;
    }

    public final void m(int i2) {
        this.F = i2;
    }

    public final int p() {
        return this.G;
    }

    public final void n(int i2) {
        this.G = i2;
    }

    public final int q() {
        return this.H;
    }

    public final void o(int i2) {
        this.H = i2;
    }

    public final int r() {
        return this.t;
    }

    public final void p(int i2) {
        this.t = i2;
    }

    public final String s() {
        return this.s;
    }

    public final void a(String str) {
        this.s = str;
    }

    public final int t() {
        return this.r;
    }

    public final int u() {
        return this.q;
    }

    public final long v() {
        if (this.p <= 0) {
            this.p = 7200;
        }
        return this.p;
    }

    public final void a(long j2) {
        this.p = j2;
    }

    public final int w() {
        return this.V;
    }

    public final void q(int i2) {
        this.V = i2;
    }

    public final long x() {
        return this.U;
    }

    public final void b(long j2) {
        this.U = j2;
    }

    public final boolean y() {
        return this.m;
    }

    public final void a(boolean z2) {
        this.m = z2;
    }

    public final long z() {
        return this.l;
    }

    public final boolean A() {
        return this.i;
    }

    public final void b(boolean z2) {
        this.i = z2;
    }

    public final long B() {
        return this.j;
    }

    public final void c(long j2) {
        this.j = j2;
    }

    public final void d(long j2) {
        this.k = j2;
    }

    public final String toString() {
        return " cfc=" + this.c + " getpf=" + this.d + " rurl=" + this.i;
    }

    public final int C() {
        return this.c;
    }

    public final void r(int i2) {
        this.c = i2;
    }

    public final long D() {
        return this.d;
    }

    public static a b(String str) {
        a aVar;
        long j2;
        long j3;
        ArrayList arrayList = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.b = jSONObject.optString("cc");
                aVar.s = jSONObject.optString("mv_wildcard", "mbridge");
                aVar.c = jSONObject.optInt("cfc");
                aVar.d = jSONObject.optLong("getpf");
                aVar.h = jSONObject.optLong("current_time");
                aVar.g = jSONObject.optBoolean("cfb");
                aVar.k = jSONObject.optLong("awct");
                if (jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0) {
                    j2 = 3600;
                } else {
                    j2 = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT);
                }
                aVar.j = j2;
                aVar.i = jSONObject.optBoolean("rurl");
                aVar.l = jSONObject.optLong("uct");
                aVar.m = jSONObject.optBoolean("ujds");
                aVar.n = jSONObject.optInt("n2");
                aVar.o = jSONObject.optInt("n3");
                aVar.t = jSONObject.optInt("is_startup_crashsystem");
                aVar.q = jSONObject.optInt("pcrn");
                if (jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0) {
                    j3 = 7200;
                } else {
                    j3 = jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB);
                }
                aVar.p = j3;
                aVar.q = jSONObject.optInt("pcrn", 100);
                boolean z2 = true;
                aVar.r = jSONObject.optInt("opent", 1);
                aVar.U = jSONObject.optLong("sfct", 1800);
                aVar.D = jSONObject.optInt("upgd", 1);
                aVar.C = jSONObject.optInt("upsrl", 1);
                aVar.E = jSONObject.optInt("updevid", 1);
                aVar.F = jSONObject.optInt("sc", 0);
                aVar.G = jSONObject.optInt("up_tips", 1);
                aVar.H = jSONObject.optInt("iseu", -1);
                aVar.I = jSONObject.optString("jm_unit");
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("atf");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString = optJSONArray.optString(i2);
                            if (x.b(optString)) {
                                JSONObject jSONObject2 = new JSONObject(optString);
                                arrayList.add(new com.mbridge.msdk.foundation.entity.a(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList != null) {
                        aVar.u = arrayList;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                aVar.V = jSONObject.optInt("adct", 259200);
                aVar.W = jSONObject.optString("confirm_title", "");
                aVar.X = jSONObject.optString("confirm_description", "");
                aVar.Y = jSONObject.optString("confirm_t", "");
                aVar.Z = jSONObject.optString("confirm_c_rv", "");
                aVar.aa = jSONObject.optString("confirm_c_play", "");
                aVar.ab = jSONObject.optString("adchoice_icon", "");
                aVar.ad = jSONObject.optString("adchoice_link", "");
                aVar.ac = jSONObject.optString("adchoice_size", "");
                aVar.af = jSONObject.optString("platform_logo", "");
                aVar.ae = jSONObject.optString("platform_name", "");
                aVar.ag = d(jSONObject.optString("cdnate_cfg", ""));
                aVar.a = jSONObject.optInt("atrqt", 0);
                aVar.aj = jSONObject.optInt("iupdid", 0);
                aVar.A = jSONObject.optInt("mcs", 120);
                aVar.B = jSONObject.optString("ab_id", "");
                aVar.ak = jSONObject.optString("omsdkjs_url", "");
                long optLong = jSONObject.optLong("tcto");
                if (optLong == 0) {
                    aVar.e = 10;
                } else {
                    aVar.e = optLong;
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("jt");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        HashMap hashMap = new HashMap();
                        for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i3);
                            hashMap.put(optJSONObject.optString("domain"), optJSONObject.optString("format"));
                        }
                        aVar.f = hashMap;
                    }
                }
                aVar.am = jSONObject.optString("mraid_js");
                aVar.al = jSONObject.optString("web_env_url");
                int optInt = jSONObject.optInt("alrbs", 0);
                if (optInt > 2 || optInt < 0) {
                    optInt = 0;
                }
                aVar.an = optInt;
                aVar.ao = jSONObject.optBoolean("GDPR_area", false);
                aVar.ap = jSONObject.optInt("ct", 120);
                JSONArray optJSONArray3 = jSONObject.optJSONArray("ercd");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        int optInt2 = optJSONArray3.optInt(i4);
                        if (optInt2 != 0) {
                            arrayList2.add(Integer.valueOf(optInt2));
                        }
                    }
                    if (arrayList2.size() > 0) {
                        arrayList2.add(-1);
                        aVar.aq = arrayList2;
                    }
                }
                String optString2 = jSONObject.optString("hst");
                if (!TextUtils.isEmpty(optString2)) {
                    try {
                        JSONObject jSONObject3 = new JSONObject(l.b(optString2));
                        Iterator<String> keys = jSONObject3.keys();
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject3.optString(next)) && !TextUtils.isEmpty(l.b(jSONObject3.optString(next)))) {
                                hashMap2.put(next, jSONObject3.optString(next));
                            }
                        }
                        if (hashMap2.size() > 0) {
                            aVar.ar = hashMap2;
                        }
                    } catch (Exception e3) {
                        q.d("SETTING", e3.getMessage());
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("refactor_switch");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        JSONObject jSONObject4 = optJSONArray4.getJSONObject(i5);
                        Iterator<String> keys2 = jSONObject4.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            if (!TextUtils.isEmpty(next2) && jSONObject4.getBoolean(next2)) {
                                aVar.T.add(Integer.valueOf(Integer.parseInt(next2)));
                            }
                        }
                    }
                }
                try {
                    int optInt3 = jSONObject.optInt("lqcnt", 30);
                    int optInt4 = jSONObject.optInt("lqto", 5);
                    int optInt5 = jSONObject.optInt("lqswt", 0);
                    int optInt6 = jSONObject.optInt("lqtype", 0);
                    aVar.K = optInt4;
                    aVar.J = optInt3;
                    aVar.L = optInt5;
                    aVar.M = optInt6;
                    int parseInt = Integer.parseInt(l.b(jSONObject.optString("lqpt")));
                    if (parseInt > 0 && parseInt < 65535) {
                        aVar.N = parseInt;
                        m.a().a(parseInt);
                    }
                } catch (Exception unused) {
                }
                aVar.as = jSONObject.optInt("wvddt", 0);
                aVar.z = jSONObject.optString("host_setting", d.c().c);
                try {
                    int optInt7 = jSONObject.optInt("l", 3);
                    boolean z3 = jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) == 1;
                    if (jSONObject.optInt("m", 1) != 1) {
                        z2 = false;
                    }
                    aVar.w = optInt7;
                    aVar.v = z3;
                    aVar.x = z2;
                } catch (Exception e4) {
                    q.d("Setting", e4.getMessage());
                }
                aVar.ah = jSONObject.optInt("fbk_swt", 0);
                aVar.ai = b.a(jSONObject.optJSONObject("fbk"));
                try {
                    int optInt8 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.w);
                    int optInt9 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.x);
                    int optInt10 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.y);
                    int optInt11 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.z);
                    if (optInt8 <= 0) {
                        optInt8 = com.mbridge.msdk.foundation.same.a.w;
                    }
                    if (optInt9 <= 0) {
                        optInt9 = com.mbridge.msdk.foundation.same.a.x;
                    }
                    if (optInt10 <= 0) {
                        optInt10 = com.mbridge.msdk.foundation.same.a.y;
                    }
                    if (optInt11 < 0) {
                        optInt11 = com.mbridge.msdk.foundation.same.a.z;
                    }
                    aVar.Q = optInt8;
                    aVar.O = optInt9;
                    aVar.P = optInt10;
                    aVar.R = optInt11;
                    int optInt12 = jSONObject.optInt("max_download_task_size", 0);
                    if (optInt12 < 0) {
                        optInt12 = 0;
                    }
                    aVar.y = optInt12;
                    aVar.d(jSONObject.optInt("max_bitmap_cache_size", 10));
                    return aVar;
                } catch (Exception unused2) {
                    return aVar;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                return aVar;
            }
        } catch (Exception e6) {
            e = e6;
            aVar = null;
            e.printStackTrace();
            return aVar;
        }
    }

    public final long E() {
        return this.h;
    }

    public final long F() {
        return this.e * 1000;
    }

    public final void e(long j2) {
        this.e = j2;
    }

    public static String a(Context context, String str) {
        try {
            a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
            if (b2 == null) {
                return "";
            }
            if (b2.f == null) {
                return "";
            }
            String host = Uri.parse(str).getHost();
            for (Map.Entry<String, String> key : b2.f.entrySet()) {
                String str2 = (String) key.getKey();
                if (!TextUtils.isEmpty(host) && host.contains(str2)) {
                    String str3 = b2.f.get(str2);
                    if (TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    return str3.replace("{gaid}", com.mbridge.msdk.foundation.tools.m.i());
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void c(boolean z2) {
        this.g = z2;
    }

    public final int G() {
        return this.n;
    }

    public final int H() {
        return this.o;
    }

    public final String I() {
        return this.W;
    }

    public final String J() {
        return this.X;
    }

    public final String K() {
        return this.Y;
    }

    public final String L() {
        return this.Z;
    }

    public final String M() {
        return this.aa;
    }

    public final void N() {
        String language = Locale.getDefault().getLanguage();
        boolean z2 = true;
        if (!(!TextUtils.isEmpty(this.W) && !TextUtils.isEmpty(this.X) && !TextUtils.isEmpty(this.Y) && !TextUtils.isEmpty(this.Z))) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.W = "Confirm to close? ";
                this.X = "You will not be rewarded after closing the window";
                this.Y = "Close it";
                this.Z = "Continue";
            } else {
                this.W = "确认关闭？";
                this.X = "关闭后您将不会获得任何奖励噢~ ";
                this.Y = "确认关闭";
                this.Z = "继续观看";
            }
        }
        if (TextUtils.isEmpty(this.W) || TextUtils.isEmpty(this.X) || TextUtils.isEmpty(this.Y) || TextUtils.isEmpty(this.aa)) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.W = "Confirm to close? ";
            this.X = "You will not be rewarded after closing the window";
            this.Y = "Close it";
            this.aa = "Continue";
            return;
        }
        this.W = "确认关闭？";
        this.X = "关闭后您将不会获得任何奖励噢~ ";
        this.Y = "确认关闭";
        this.aa = "继续试玩";
    }

    public final String O() {
        return this.ab;
    }

    public final String P() {
        return this.ac;
    }

    public final String Q() {
        return this.ad;
    }

    public final Map<String, C0056a> R() {
        return this.ag;
    }

    private static Map<String, C0056a> d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                C0056a aVar = new C0056a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                }
                hashMap.put(next, aVar);
            }
            return hashMap;
        } catch (JSONException e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public final int S() {
        return this.J;
    }

    public final int T() {
        return this.K;
    }

    public final int U() {
        return this.L;
    }

    public final int V() {
        return this.M;
    }

    public final boolean W() {
        return this.v;
    }

    public final int X() {
        return this.w;
    }

    public final boolean Y() {
        return this.x;
    }

    public final int Z() {
        return this.ah;
    }

    public final b aa() {
        return this.ai;
    }

    /* compiled from: Setting */
    public static class b {
        private String a;
        private String b;
        private String c;
        private JSONArray d;

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            b bVar = new b();
            Context g = com.mbridge.msdk.foundation.controller.a.e().g();
            bVar.a = jSONObject.optString(CampaignEx.JSON_KEY_TITLE, g.getString(k.a(g, "mbridge_cm_feedback_dialog_title", "string")));
            bVar.b = jSONObject.optString("cancel", g.getString(k.a(g, "mbridge_cm_feedback_dialog_close_close", "string")));
            bVar.c = jSONObject.optString("submit", g.getString(k.a(g, "mbridge_cm_feedback_dialog_close_submit", "string")));
            bVar.d = jSONObject.optJSONArray("content");
            if (bVar.d == null) {
                bVar.d = new JSONArray();
                bVar.d.put(g.getString(k.a(g, "mbridge_cm_feedback_dialog_content_stuck", "string")));
                bVar.d.put(g.getString(k.a(g, "mbridge_cm_feedback_dialog_content_cnr", "string")));
                bVar.d.put(g.getString(k.a(g, "mbridge_cm_feedback_dialog_content_balck_screen", "string")));
                bVar.d.put(g.getString(k.a(g, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return bVar;
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

        public final JSONArray d() {
            return this.d;
        }
    }

    /* renamed from: com.mbridge.msdk.b.a$a  reason: collision with other inner class name */
    /* compiled from: Setting */
    public static class C0056a {
        private List<String> a;
        private List<String> b;
        private List<String> c;
        private List<String> d;

        public final List<String> a() {
            return this.a;
        }

        public final List<String> b() {
            return this.b;
        }

        public final List<String> c() {
            return this.c;
        }

        public final List<String> d() {
            return this.d;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.a = h.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.b = h.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.c = h.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.d = h.a(optJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final String ab() {
        return this.ak;
    }

    public final void c(String str) {
        this.ak = str;
    }

    public final String ac() {
        return this.al;
    }

    public final String ad() {
        return this.am;
    }

    public final int ae() {
        return this.an;
    }

    public final void s(int i2) {
        this.an = i2;
    }

    public final boolean af() {
        return this.ao;
    }

    public final void d(boolean z2) {
        this.ao = z2;
    }

    public final int ag() {
        return this.ap;
    }

    public final void t(int i2) {
        this.ap = i2;
    }

    public final ArrayList<Integer> ah() {
        return this.aq;
    }

    public final HashMap<String, String> ai() {
        return this.ar;
    }

    public final int aj() {
        return this.as;
    }

    public final void u(int i2) {
        this.at = i2;
    }

    public final String ak() {
        return this.b;
    }

    public final String al() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc", this.b);
            jSONObject.put("cfc", this.c);
            jSONObject.put("cfb", this.g);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.j);
            jSONObject.put("awct", this.k);
            jSONObject.put("rurl", this.i);
            jSONObject.put("ujds", this.m);
            jSONObject.put(CampaignEx.JSON_KEY_PLCTB, this.p);
            jSONObject.put("tcto", this.e);
            jSONObject.put("mv_wildcard", this.s);
            jSONObject.put("is_startup_crashsystem", this.t);
            jSONObject.put("sfct", this.U);
            jSONObject.put("pcrn", this.q);
            jSONObject.put("adct", this.V);
            jSONObject.put("atrqt", this.a);
            jSONObject.put("omsdkjs_url", this.ak);
            jSONObject.put("mcs", this.A);
            jSONObject.put("GDPR_area", this.ao);
            jSONObject.put("alrbs", this.an);
            jSONObject.put("ct", this.ap);
            jSONObject.put("isDefault", this.at);
            return jSONObject.toString();
        } catch (Throwable th) {
            q.d("Setting", th.getMessage());
            return null;
        }
    }
}
