package com.bytedance.sdk.component.adexpress.dynamic.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DynamicLayoutBrickValue */
public class f {
    private String A;
    private String B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private double I;
    private int J;
    private boolean K;
    private int L;
    private boolean M;
    private int N;
    private String O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private String T;
    private int U;
    private boolean V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private float a;
    private int aa;
    private int ab;
    private String ac;
    private int ad;
    private int ae;
    private int af;
    private List<a> ag;
    private int ah;
    private int ai;
    private int aj;
    private int ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private int ao;
    private boolean ap;
    private int aq;
    private JSONObject ar;
    private JSONObject as;
    private JSONObject at;
    private int au;
    private String av;
    private float b;
    private float c;
    private float d;
    private boolean e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private double k;
    private double l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.b(jSONObject.optString("adType", "embeded"));
        fVar.n(jSONObject.optString("clickArea", VisionDataDBAdapter.VisionDataColumns.COLUMN_CREATIVE));
        fVar.o(jSONObject.optString("clickTigger", CampaignEx.JSON_NATIVE_VIDEO_CLICK));
        fVar.c(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        fVar.d(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, TtmlNode.LEFT));
        fVar.e(jSONObject.optString(TtmlNode.ATTR_TTS_COLOR, "#999999"));
        fVar.f(jSONObject.optString("bgColor", "transparent"));
        fVar.g(jSONObject.optString("bgImgUrl", ""));
        fVar.h(jSONObject.optString("borderColor", "#000000"));
        fVar.i(jSONObject.optString("borderStyle", "solid"));
        fVar.j(jSONObject.optString("heightMode", "auto"));
        fVar.k(jSONObject.optString("widthMode", "fixed"));
        fVar.l(jSONObject.optString("interactText", ""));
        fVar.m(jSONObject.optString("interactType", ""));
        fVar.a(jSONObject.optInt("interactSlideDirection", -1));
        fVar.p(jSONObject.optString("justifyHorizontal", "space-around"));
        fVar.q(jSONObject.optString("justifyVertical", "flex-start"));
        fVar.a(jSONObject.optDouble("timingStart"));
        fVar.b(jSONObject.optDouble("timingEnd"));
        fVar.d((float) jSONObject.optDouble("width", 0.0d));
        fVar.c((float) jSONObject.optDouble("height", 0.0d));
        fVar.a((float) jSONObject.optDouble("borderRadius", 0.0d));
        fVar.b((float) jSONObject.optDouble("borderSize", 0.0d));
        fVar.a(jSONObject.optBoolean("interactValidate", false));
        fVar.i((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d));
        fVar.e((float) jSONObject.optDouble("paddingBottom", 0.0d));
        fVar.f((float) jSONObject.optDouble("paddingLeft", 0.0d));
        fVar.g((float) jSONObject.optDouble("paddingRight", 0.0d));
        fVar.h((float) jSONObject.optDouble("paddingTop", 0.0d));
        fVar.b(jSONObject.optBoolean("lineFeed", false));
        fVar.c(jSONObject.optInt("lineCount", 0));
        fVar.c(jSONObject.optDouble("lineHeight", 1.2d));
        fVar.h(jSONObject.optInt("letterSpacing", 0));
        fVar.c(jSONObject.optBoolean("isDataFixed", false));
        fVar.i(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        fVar.d(jSONObject.optBoolean("lineLimit"));
        fVar.j(jSONObject.optInt("position"));
        fVar.r(jSONObject.optString("align"));
        fVar.e(jSONObject.optBoolean("useLeft"));
        fVar.f(jSONObject.optBoolean("useRight"));
        fVar.g(jSONObject.optBoolean("useTop"));
        fVar.h(jSONObject.optBoolean("useBottom"));
        fVar.s(jSONObject.optString(DataSchemeDataSource.SCHEME_DATA));
        fVar.f(jSONObject.optInt("marginLeft"));
        fVar.g(jSONObject.optInt("marginRight"));
        fVar.d(jSONObject.optInt("marginTop"));
        fVar.e(jSONObject.optInt("marginBottom"));
        fVar.k(jSONObject.optInt("tagMaxCount"));
        fVar.i(jSONObject.optBoolean("allowTextFlow"));
        fVar.l(jSONObject.optInt("textFlowType"));
        fVar.m(jSONObject.optInt("textFlowDuration"));
        fVar.n(jSONObject.optInt(TtmlNode.LEFT));
        fVar.o(jSONObject.optInt(TtmlNode.RIGHT));
        fVar.p(jSONObject.optInt("top"));
        fVar.q(jSONObject.optInt("bottom"));
        fVar.t(jSONObject.optString("alignItems", "flex-start"));
        fVar.r(jSONObject.optInt("zIndex"));
        fVar.t(jSONObject.optInt("interactVisibleTime"));
        fVar.s(jSONObject.optInt("interactHiddenTime"));
        fVar.a(jSONObject.optString("bgGradient"));
        fVar.u(jSONObject.optInt("areaType"));
        fVar.v(jSONObject.optInt("interactSlideThreshold", 0));
        fVar.y(jSONObject.optInt("interactBottomDistance", 120));
        fVar.m(jSONObject.optBoolean("openPlayableLandingPage", false));
        fVar.b(jSONObject.optJSONObject("video"));
        fVar.c(jSONObject.optJSONObject("image"));
        fVar.w(jSONObject.optInt("borderShadowExtent"));
        fVar.j(jSONObject.optBoolean("bgGauseBlur"));
        fVar.x(jSONObject.optInt("bgGauseBlurRadius"));
        fVar.k(jSONObject.optBoolean("showTimeProgress", false));
        fVar.l(jSONObject.optBoolean("showPlayButton", false));
        fVar.b(jSONObject.optInt("bgColorCg", 0));
        fVar.d(jSONObject.optJSONObject("interactI18n"));
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("animations");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.d(jSONObject2.optString("animationType"));
                    aVar.a(jSONObject2.optDouble("animationDuration"));
                    aVar.b(jSONObject2.optDouble("animationScaleX"));
                    aVar.c(jSONObject2.optDouble("animationScaleY"));
                    aVar.e(jSONObject2.optString("animationTimeFunction"));
                    aVar.d(jSONObject2.optDouble("animationDelay"));
                    aVar.f(jSONObject2.optInt("animationIterationCount"));
                    aVar.f(jSONObject2.optString("animationDirection"));
                    aVar.e(jSONObject2.optDouble("animationInterval"));
                    aVar.a(jSONObject2.optInt("animationBorderWidth"));
                    aVar.a(jSONObject2.optLong("key"));
                    aVar.b(jSONObject2.optInt("animationEffectWidth"));
                    aVar.c(jSONObject2.optInt("animationSwing", 1));
                    aVar.d(jSONObject2.optInt("animationTranslateX"));
                    aVar.e(jSONObject2.optInt("animationTranslateY"));
                    aVar.c(jSONObject2.optString("animationRippleBackgroundColor"));
                    aVar.b(jSONObject2.optString("animationScaleDirection"));
                    aVar.g(jSONObject2.optInt("animationFadeStart"));
                    aVar.h(jSONObject2.optInt("animationFadeEnd"));
                    aVar.a(jSONObject2.optString("animationRubInDirection"));
                    if (fVar.m() > 0.0d) {
                        aVar.d(aVar.n() + fVar.m());
                    }
                    arrayList.add(aVar);
                }
                fVar.a((List<a>) arrayList);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fVar;
    }

    public JSONObject a() {
        return this.at;
    }

    public int b() {
        return this.au;
    }

    public void a(int i2) {
        this.au = i2;
    }

    public int c() {
        return this.aq;
    }

    public void b(int i2) {
        this.aq = i2;
    }

    public String d() {
        return this.av;
    }

    public void a(String str) {
        this.av = str;
    }

    public float e() {
        return this.a;
    }

    public void a(float f2) {
        this.a = f2;
    }

    public float f() {
        return this.b;
    }

    public void b(float f2) {
        this.b = f2;
    }

    public void c(float f2) {
        this.c = f2;
    }

    public void d(float f2) {
        this.d = f2;
    }

    public boolean g() {
        return this.e;
    }

    public void a(boolean z2) {
        this.e = z2;
    }

    public float h() {
        return this.f;
    }

    public void e(float f2) {
        this.f = f2;
    }

    public float i() {
        return this.g;
    }

    public void f(float f2) {
        this.g = f2;
    }

    public float j() {
        return this.h;
    }

    public void g(float f2) {
        this.h = f2;
    }

    public float k() {
        return this.i;
    }

    public void h(float f2) {
        this.i = f2;
    }

    public float l() {
        return this.j;
    }

    public void i(float f2) {
        this.j = f2;
    }

    public double m() {
        return this.k;
    }

    public void a(double d2) {
        this.k = d2;
    }

    public double n() {
        return this.l;
    }

    public void b(double d2) {
        this.l = d2;
    }

    public void b(String str) {
        this.m = str;
    }

    public void c(String str) {
        this.n = str;
    }

    public String o() {
        return this.o;
    }

    public void d(String str) {
        this.o = str;
    }

    public String p() {
        return this.p;
    }

    public void e(String str) {
        this.p = str;
    }

    public String q() {
        return this.q;
    }

    public void f(String str) {
        this.q = str;
    }

    public void g(String str) {
        this.r = str;
    }

    public String r() {
        return this.r;
    }

    public String s() {
        return this.s;
    }

    public void h(String str) {
        this.s = str;
    }

    public void i(String str) {
        this.t = str;
    }

    public String t() {
        return this.u;
    }

    public void j(String str) {
        this.u = str;
    }

    public String u() {
        return this.v;
    }

    public void k(String str) {
        this.v = str;
    }

    public String v() {
        return this.w;
    }

    public void l(String str) {
        this.w = str;
    }

    public String w() {
        return this.x;
    }

    public void m(String str) {
        this.x = str;
    }

    public String x() {
        return this.y;
    }

    public void n(String str) {
        this.y = str;
    }

    public String y() {
        return this.z;
    }

    public void o(String str) {
        this.z = str;
    }

    public String z() {
        return this.A;
    }

    public void p(String str) {
        this.A = str;
    }

    public String A() {
        return this.B;
    }

    public void q(String str) {
        this.B = str;
    }

    public boolean B() {
        return this.C;
    }

    public void b(boolean z2) {
        this.C = z2;
    }

    public void c(int i2) {
        this.D = i2;
    }

    public int C() {
        return this.D;
    }

    public int D() {
        return this.E;
    }

    public void d(int i2) {
        this.E = i2;
    }

    public int E() {
        return this.F;
    }

    public void e(int i2) {
        this.F = i2;
    }

    public int F() {
        return this.G;
    }

    public void f(int i2) {
        this.G = i2;
    }

    public int G() {
        return this.H;
    }

    public void g(int i2) {
        this.H = i2;
    }

    public double H() {
        return this.I;
    }

    public void c(double d2) {
        this.I = d2;
    }

    public int I() {
        return this.J;
    }

    public void h(int i2) {
        this.J = i2;
    }

    public boolean J() {
        return this.K;
    }

    public void c(boolean z2) {
        this.K = z2;
    }

    public int K() {
        return this.L;
    }

    public void i(int i2) {
        this.L = i2;
    }

    public boolean L() {
        return this.M;
    }

    public void d(boolean z2) {
        this.M = z2;
    }

    public int M() {
        return this.N;
    }

    public void j(int i2) {
        this.N = i2;
    }

    public String N() {
        return this.O;
    }

    public void r(String str) {
        this.O = str;
    }

    public boolean O() {
        return this.P;
    }

    public void e(boolean z2) {
        this.P = z2;
    }

    public boolean P() {
        return this.Q;
    }

    public void f(boolean z2) {
        this.Q = z2;
    }

    public boolean Q() {
        return this.R;
    }

    public void g(boolean z2) {
        this.R = z2;
    }

    public boolean R() {
        return this.S;
    }

    public void h(boolean z2) {
        this.S = z2;
    }

    public String S() {
        return this.T;
    }

    public void s(String str) {
        this.T = str;
    }

    public int T() {
        return this.U;
    }

    public void k(int i2) {
        this.U = i2;
    }

    public boolean U() {
        return this.V;
    }

    public void i(boolean z2) {
        this.V = z2;
    }

    public int V() {
        return this.W;
    }

    public void l(int i2) {
        this.W = i2;
    }

    public int W() {
        return this.X;
    }

    public void m(int i2) {
        this.X = i2;
    }

    public int X() {
        return this.Y;
    }

    public void n(int i2) {
        this.Y = i2;
    }

    public int Y() {
        return this.Z;
    }

    public void o(int i2) {
        this.Z = i2;
    }

    public int Z() {
        return this.aa;
    }

    public void p(int i2) {
        this.aa = i2;
    }

    public int aa() {
        return this.ab;
    }

    public void q(int i2) {
        this.ab = i2;
    }

    public String ab() {
        return this.ac;
    }

    public void t(String str) {
        this.ac = str;
    }

    public int ac() {
        return this.ad;
    }

    public void r(int i2) {
        this.ad = i2;
    }

    public int ad() {
        return this.ae;
    }

    public void s(int i2) {
        this.ae = i2;
    }

    public int ae() {
        return this.af;
    }

    public void t(int i2) {
        this.af = i2;
    }

    public List<a> af() {
        return this.ag;
    }

    public void a(List<a> list) {
        this.ag = list;
    }

    public int ag() {
        return this.ah;
    }

    public void u(int i2) {
        this.ah = i2;
    }

    public int ah() {
        return this.ai;
    }

    public void v(int i2) {
        this.ai = i2;
    }

    public int ai() {
        return this.aj;
    }

    public void w(int i2) {
        this.aj = i2;
    }

    public boolean aj() {
        return this.al;
    }

    public void j(boolean z2) {
        this.al = z2;
    }

    public int ak() {
        return this.ak;
    }

    public void x(int i2) {
        this.ak = i2;
    }

    public boolean al() {
        return this.am;
    }

    public void k(boolean z2) {
        this.am = z2;
    }

    public boolean am() {
        return this.an;
    }

    public void l(boolean z2) {
        this.an = z2;
    }

    public int an() {
        return this.ao;
    }

    public void y(int i2) {
        this.ao = i2;
    }

    public boolean ao() {
        return this.ap;
    }

    public void m(boolean z2) {
        this.ap = z2;
    }

    public void b(JSONObject jSONObject) {
        this.ar = jSONObject;
    }

    public void c(JSONObject jSONObject) {
        this.as = jSONObject;
    }

    public void d(JSONObject jSONObject) {
        this.at = jSONObject;
    }

    public void ap() {
        a(this, this.ar);
    }

    public void aq() {
        a(this, this.as);
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (fVar != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                char c2 = 65535;
                switch (next.hashCode()) {
                    case -1965619659:
                        if (next.equals("clickArea")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1885934767:
                        if (next.equals("bgImgUrl")) {
                            c2 = 8;
                            break;
                        }
                        break;
                    case -1822062213:
                        if (next.equals("lineCount")) {
                            c2 = 30;
                            break;
                        }
                        break;
                    case -1821293778:
                        if (next.equals("openPlayableLandingPage")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1813937113:
                        if (next.equals("lineLimit")) {
                            c2 = '#';
                            break;
                        }
                        break;
                    case -1501175880:
                        if (next.equals("paddingLeft")) {
                            c2 = 26;
                            break;
                        }
                        break;
                    case -1422965251:
                        if (next.equals("adType")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1383228885:
                        if (next.equals("bottom")) {
                            c2 = '6';
                            break;
                        }
                        break;
                    case -1224696685:
                        if (next.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (next.equals("height")) {
                            c2 = 20;
                            break;
                        }
                        break;
                    case -1065511464:
                        if (next.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -1063257157:
                        if (next.equals("alignItems")) {
                            c2 = '7';
                            break;
                        }
                        break;
                    case -1046708884:
                        if (next.equals("interactValidate")) {
                            c2 = 23;
                            break;
                        }
                        break;
                    case -1044792121:
                        if (next.equals("marginTop")) {
                            c2 = '-';
                            break;
                        }
                        break;
                    case -1019884910:
                        if (next.equals("useBottom")) {
                            c2 = ')';
                            break;
                        }
                        break;
                    case -912366651:
                        if (next.equals("tagMaxCount")) {
                            c2 = '/';
                            break;
                        }
                        break;
                    case -848877971:
                        if (next.equals("interactHiddenTime")) {
                            c2 = ':';
                            break;
                        }
                        break;
                    case -836058546:
                        if (next.equals("useTop")) {
                            c2 = '(';
                            break;
                        }
                        break;
                    case -734428249:
                        if (next.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                            c2 = Typography.quote;
                            break;
                        }
                        break;
                    case -731417480:
                        if (next.equals("zIndex")) {
                            c2 = '8';
                            break;
                        }
                        break;
                    case -709393864:
                        if (next.equals("timingStart")) {
                            c2 = 17;
                            break;
                        }
                        break;
                    case -515807685:
                        if (next.equals("lineHeight")) {
                            c2 = 31;
                            break;
                        }
                        break;
                    case -321658193:
                        if (next.equals("textFlowDuration")) {
                            c2 = '2';
                            break;
                        }
                        break;
                    case -295409451:
                        if (next.equals("useRight")) {
                            c2 = '\'';
                            break;
                        }
                        break;
                    case -289173127:
                        if (next.equals("marginBottom")) {
                            c2 = '.';
                            break;
                        }
                        break;
                    case -204859874:
                        if (next.equals("bgColor")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -148259282:
                        if (next.equals("useLeft")) {
                            c2 = Typography.amp;
                            break;
                        }
                        break;
                    case -51738487:
                        if (next.equals("widthMode")) {
                            c2 = 12;
                            break;
                        }
                        break;
                    case 115029:
                        if (next.equals("top")) {
                            c2 = '5';
                            break;
                        }
                        break;
                    case 3076010:
                        if (next.equals(DataSchemeDataSource.SCHEME_DATA)) {
                            c2 = '*';
                            break;
                        }
                        break;
                    case 3317767:
                        if (next.equals(TtmlNode.LEFT)) {
                            c2 = '3';
                            break;
                        }
                        break;
                    case 90130308:
                        if (next.equals("paddingTop")) {
                            c2 = 28;
                            break;
                        }
                        break;
                    case 92903173:
                        if (next.equals("align")) {
                            c2 = '%';
                            break;
                        }
                        break;
                    case 94842723:
                        if (next.equals(TtmlNode.ATTR_TTS_COLOR)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 108511772:
                        if (next.equals(TtmlNode.RIGHT)) {
                            c2 = '4';
                            break;
                        }
                        break;
                    case 113126854:
                        if (next.equals("width")) {
                            c2 = 19;
                            break;
                        }
                        break;
                    case 164611121:
                        if (next.equals("timingEnd")) {
                            c2 = 18;
                            break;
                        }
                        break;
                    case 202355100:
                        if (next.equals("paddingBottom")) {
                            c2 = 25;
                            break;
                        }
                        break;
                    case 247204452:
                        if (next.equals("allowTextFlow")) {
                            c2 = '0';
                            break;
                        }
                        break;
                    case 365601008:
                        if (next.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                            c2 = 24;
                            break;
                        }
                        break;
                    case 428975654:
                        if (next.equals("justifyVertical")) {
                            c2 = 16;
                            break;
                        }
                        break;
                    case 439444041:
                        if (next.equals("interactVisibleTime")) {
                            c2 = '9';
                            break;
                        }
                        break;
                    case 713848971:
                        if (next.equals("paddingRight")) {
                            c2 = 27;
                            break;
                        }
                        break;
                    case 722830999:
                        if (next.equals("borderColor")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case 737768677:
                        if (next.equals("borderStyle")) {
                            c2 = 10;
                            break;
                        }
                        break;
                    case 747804969:
                        if (next.equals("position")) {
                            c2 = Typography.dollar;
                            break;
                        }
                        break;
                    case 791643104:
                        if (next.equals("isDataFixed")) {
                            c2 = '!';
                            break;
                        }
                        break;
                    case 975087886:
                        if (next.equals("marginRight")) {
                            c2 = ',';
                            break;
                        }
                        break;
                    case 1110826708:
                        if (next.equals("justifyHorizontal")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case 1188229042:
                        if (next.equals("lineFeed")) {
                            c2 = 29;
                            break;
                        }
                        break;
                    case 1332036739:
                        if (next.equals("interactText")) {
                            c2 = 13;
                            break;
                        }
                        break;
                    case 1332055696:
                        if (next.equals("interactType")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case 1349188574:
                        if (next.equals("borderRadius")) {
                            c2 = 21;
                            break;
                        }
                        break;
                    case 1360828714:
                        if (next.equals("clickTigger")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1490178922:
                        if (next.equals("heightMode")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 1761274325:
                        if (next.equals("textFlowType")) {
                            c2 = '1';
                            break;
                        }
                        break;
                    case 1824903757:
                        if (next.equals("borderSize")) {
                            c2 = 22;
                            break;
                        }
                        break;
                    case 1970934485:
                        if (next.equals("marginLeft")) {
                            c2 = '+';
                            break;
                        }
                        break;
                    case 2111078717:
                        if (next.equals("letterSpacing")) {
                            c2 = ' ';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        fVar.m(jSONObject.optBoolean(next));
                        break;
                    case 1:
                        fVar.b(jSONObject.optString(next));
                        break;
                    case 2:
                        fVar.n(jSONObject.optString(next));
                        break;
                    case 3:
                        fVar.o(jSONObject.optString(next));
                        break;
                    case 4:
                        fVar.c(jSONObject.optString(next));
                        break;
                    case 5:
                        fVar.d(jSONObject.optString(next));
                        break;
                    case 6:
                        fVar.e(jSONObject.optString(next));
                        break;
                    case 7:
                        fVar.f(jSONObject.optString(next));
                        break;
                    case 8:
                        fVar.g(jSONObject.optString(next));
                        break;
                    case 9:
                        fVar.h(jSONObject.optString(next));
                        break;
                    case 10:
                        fVar.i(jSONObject.optString(next));
                        break;
                    case 11:
                        fVar.j(jSONObject.optString(next));
                        break;
                    case 12:
                        fVar.k(jSONObject.optString(next));
                        break;
                    case 13:
                        fVar.l(jSONObject.optString(next));
                        break;
                    case 14:
                        fVar.m(jSONObject.optString(next));
                        break;
                    case 15:
                        fVar.p(jSONObject.optString(next));
                        break;
                    case 16:
                        fVar.q(jSONObject.optString(next));
                        break;
                    case 17:
                        fVar.a(jSONObject.optDouble(next));
                        break;
                    case 18:
                        fVar.b(jSONObject.optDouble(next));
                        break;
                    case 19:
                        fVar.d((float) jSONObject.optDouble(next));
                        break;
                    case 20:
                        fVar.c((float) jSONObject.optDouble(next));
                        break;
                    case 21:
                        fVar.a((float) jSONObject.optDouble(next));
                        break;
                    case 22:
                        fVar.b((float) jSONObject.optDouble(next));
                        break;
                    case 23:
                        fVar.a(jSONObject.optBoolean(next));
                        break;
                    case 24:
                        fVar.i((float) jSONObject.optDouble(next));
                        break;
                    case 25:
                        fVar.e((float) jSONObject.optDouble(next));
                        break;
                    case 26:
                        fVar.f((float) jSONObject.optDouble(next));
                        break;
                    case 27:
                        fVar.g((float) jSONObject.optDouble(next));
                        break;
                    case 28:
                        fVar.h((float) jSONObject.optDouble(next));
                        break;
                    case 29:
                        fVar.b(jSONObject.optBoolean(next));
                        break;
                    case 30:
                        fVar.c(jSONObject.optInt(next));
                        break;
                    case 31:
                        fVar.c(jSONObject.optDouble(next));
                        break;
                    case ' ':
                        fVar.h(jSONObject.optInt(next));
                        break;
                    case '!':
                        fVar.c(jSONObject.optBoolean(next));
                        break;
                    case '\"':
                        fVar.i(jSONObject.optInt(next));
                        break;
                    case '#':
                        fVar.d(jSONObject.optBoolean(next));
                        break;
                    case '$':
                        fVar.j(jSONObject.optInt(next));
                        break;
                    case '%':
                        fVar.r(jSONObject.optString(next));
                        break;
                    case '&':
                        fVar.e(jSONObject.optBoolean(next));
                        break;
                    case '\'':
                        fVar.f(jSONObject.optBoolean(next));
                        break;
                    case '(':
                        fVar.g(jSONObject.optBoolean(next));
                        break;
                    case ')':
                        fVar.h(jSONObject.optBoolean(next));
                        break;
                    case '*':
                        fVar.s(jSONObject.optString(next));
                        break;
                    case '+':
                        fVar.f(jSONObject.optInt(next));
                        break;
                    case ',':
                        fVar.g(jSONObject.optInt(next));
                        break;
                    case '-':
                        fVar.d(jSONObject.optInt(next));
                        break;
                    case '.':
                        fVar.e(jSONObject.optInt(next));
                        break;
                    case '/':
                        fVar.k(jSONObject.optInt(next));
                        break;
                    case '0':
                        fVar.i(jSONObject.optBoolean(next));
                        break;
                    case '1':
                        fVar.l(jSONObject.optInt(next));
                        break;
                    case '2':
                        fVar.m(jSONObject.optInt(next));
                        break;
                    case '3':
                        fVar.n(jSONObject.optInt(next));
                        break;
                    case '4':
                        fVar.o(jSONObject.optInt(next));
                        break;
                    case '5':
                        fVar.p(jSONObject.optInt(next));
                        break;
                    case '6':
                        fVar.q(jSONObject.optInt(next));
                        break;
                    case '7':
                        fVar.t(jSONObject.optString(next));
                        break;
                    case '8':
                        fVar.r(jSONObject.optInt(next));
                        break;
                    case '9':
                        fVar.t(jSONObject.optInt(next));
                        break;
                    case ':':
                        fVar.s(jSONObject.optInt(next));
                        break;
                }
            }
        }
    }
}
