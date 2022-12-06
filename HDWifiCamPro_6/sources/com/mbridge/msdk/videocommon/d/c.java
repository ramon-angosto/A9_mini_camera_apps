package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.videocommon.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardUnitSetting */
public final class c {
    private static g H;
    public static String a;
    private int A = 70;
    private int B = 0;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int F;
    private int G = 20;
    private int I;
    private int J = 0;
    private int K = 1;
    private String L = "";
    private int M = 1;
    private String N = "";
    private int O = 1;
    private String P = "Virtual Item";
    private String Q = "";
    private int R = 0;
    private int S = 1;
    private int T = 60;
    private String b;
    private String c;
    private List<b> d;
    private long e;
    private int f = -1;
    private int g = 0;
    private int h = 0;
    private int i = 1;
    private int j = 1;
    private int k = 1;
    private int l = 1;
    private int m = 5;
    private int n = 1;
    private int o = 3;
    private int p = 80;
    private int q = 100;
    private int r = 0;
    private double s = 1.0d;
    private int t = -1;
    private ArrayList<Integer> u;
    private int v = 3;
    private int w = 1;
    private int x = 10;
    private int y = 60;
    private int z = 0;

    public final int a() {
        return this.x;
    }

    public final int b() {
        return this.y;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.u = arrayList;
    }

    public final int c() {
        return this.z;
    }

    public final void a(int i2) {
        this.z = i2;
    }

    public final int d() {
        return this.B;
    }

    public final void b(int i2) {
        this.B = i2;
    }

    public final int e() {
        return this.C;
    }

    public final void c(int i2) {
        this.C = i2;
    }

    public final int f() {
        return this.D;
    }

    public final void d(int i2) {
        this.D = i2;
    }

    public final int g() {
        return this.E;
    }

    public final void e(int i2) {
        this.E = i2;
    }

    public final int h() {
        return this.f;
    }

    public final int i() {
        return this.h;
    }

    public final String j() {
        return this.Q;
    }

    public final int k() {
        return this.M;
    }

    private void y(int i2) {
        if (i2 <= 0) {
            this.M = 1;
        } else {
            this.M = i2;
        }
    }

    public final String l() {
        return this.P;
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.P = this.L;
        } else {
            this.P = str;
        }
    }

    public final int m() {
        return this.G;
    }

    public final int n() {
        return this.F;
    }

    public final void f(int i2) {
        this.F = i2;
    }

    public final int o() {
        return this.I;
    }

    public final void g(int i2) {
        this.I = i2;
    }

    public final void h(int i2) {
        this.o = i2;
    }

    public final void i(int i2) {
        this.p = i2;
    }

    public final int p() {
        return this.q;
    }

    public final void j(int i2) {
        this.q = i2;
    }

    public final int q() {
        return this.r;
    }

    public final void k(int i2) {
        this.r = i2;
    }

    public final int r() {
        return this.j;
    }

    public final void l(int i2) {
        this.j = i2;
    }

    public final int s() {
        return this.k;
    }

    public final void m(int i2) {
        this.k = i2;
    }

    public final void n(int i2) {
        this.l = i2;
    }

    public final int t() {
        return this.m;
    }

    public final void o(int i2) {
        this.m = i2;
    }

    public final int u() {
        return this.n;
    }

    public final void p(int i2) {
        this.n = i2;
    }

    public final void q(int i2) {
        this.i = i2;
    }

    public final long v() {
        return this.e;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final List<b> w() {
        return this.d;
    }

    public final void a(List<b> list) {
        this.d = list;
    }

    public final int x() {
        return this.w;
    }

    public final void r(int i2) {
        this.w = i2;
    }

    public final boolean s(int i2) {
        ArrayList<Integer> arrayList = this.u;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.u.contains(Integer.valueOf(i2));
    }

    public final String y() {
        return this.c;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final int z() {
        return this.v;
    }

    public final void t(int i2) {
        this.v = i2;
    }

    public final Queue<Integer> A() {
        LinkedList linkedList;
        Exception e2;
        try {
            if (this.d == null || this.d.size() <= 0) {
                return null;
            }
            linkedList = new LinkedList();
            int i2 = 0;
            while (i2 < this.d.size()) {
                try {
                    linkedList.add(Integer.valueOf(this.d.get(i2).b()));
                    i2++;
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return linkedList;
                }
            }
            return linkedList;
        } catch (Exception e4) {
            Exception exc = e4;
            linkedList = null;
            e2 = exc;
            e2.printStackTrace();
            return linkedList;
        }
    }

    public final void u(int i2) {
        this.R = i2;
    }

    public final int B() {
        return this.S;
    }

    public final void v(int i2) {
        this.S = i2;
    }

    public final int C() {
        return this.T;
    }

    public final void w(int i2) {
        this.T = i2;
    }

    public static c c(String str) {
        JSONObject optJSONObject;
        if (H == null) {
            H = g.a(a.e().g());
        }
        c cVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String optString = optJSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                c cVar2 = new c();
                try {
                    List<b> a2 = b.a(optJSONObject.optJSONArray("adSourceList"));
                    cVar2.b = optString;
                    cVar2.d = a2;
                    cVar2.i = optJSONObject.optInt("callbackType");
                    int optInt = optJSONObject.optInt("aqn", 1);
                    if (optInt <= 0) {
                        optInt = 1;
                    }
                    cVar2.j = optInt;
                    int optInt2 = optJSONObject.optInt("acn", 1);
                    if (optInt2 < 0) {
                        optInt2 = 1;
                    }
                    cVar2.k = optInt2;
                    cVar2.l = optJSONObject.optInt("vcn", 5);
                    cVar2.m = optJSONObject.optInt("offset", 5);
                    cVar2.n = optJSONObject.optInt("dlnet", 1);
                    cVar2.I = optJSONObject.optInt("endscreen_type", 2);
                    cVar2.o = optJSONObject.optInt("tv_start", 3);
                    cVar2.p = optJSONObject.optInt("tv_end", 80);
                    cVar2.q = optJSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                    cVar2.r = optJSONObject.optInt("cd_rate", 0);
                    cVar2.e = jSONObject.optLong("current_time");
                    cVar2.z = optJSONObject.optInt("orientation", 0);
                    cVar2.B = optJSONObject.optInt("daily_play_cap", 0);
                    cVar2.C = optJSONObject.optInt("video_skip_time", -1);
                    cVar2.D = optJSONObject.optInt("video_skip_result", 2);
                    cVar2.E = optJSONObject.optInt("video_interactive_type", -1);
                    cVar2.F = optJSONObject.optInt("close_button_delay", 1);
                    cVar2.f = optJSONObject.optInt("playclosebtn_tm", -1);
                    cVar2.g = optJSONObject.optInt("play_ctdown", 0);
                    cVar2.h = optJSONObject.optInt("close_alert", 0);
                    cVar2.G = optJSONObject.optInt("rdrct", 20);
                    cVar2.A = optJSONObject.optInt("load_global_timeout", 70);
                    cVar2.t = optJSONObject.optInt("rfpv", -1);
                    cVar2.s = optJSONObject.optDouble("vdcmp", 1.0d);
                    a = optJSONObject.optString("atzu");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("atl_type");
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    if (optJSONArray2 != null) {
                        int i2 = 0;
                        while (i2 < optJSONArray2.length()) {
                            try {
                                arrayList.add(Integer.valueOf(optJSONArray2.getInt(i2)));
                                i2++;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    cVar2.u = arrayList;
                    int optInt3 = optJSONObject.optInt("atl_dyt", 0);
                    if (optInt3 <= 0) {
                        optInt3 = 3;
                    }
                    cVar2.v = optInt3;
                    int optInt4 = optJSONObject.optInt("tmorl", 1);
                    if (optInt4 > 2 || optInt4 <= 0) {
                        optInt4 = 1;
                    }
                    cVar2.w = optInt4;
                    cVar2.c = optJSONObject.optString(PangleConstants.PLACEMENT_ID);
                    cVar2.x = optJSONObject.optInt("ltafemty", 10);
                    cVar2.y = optJSONObject.optInt("ltorwc", 60);
                    cVar2.Q = optJSONObject.optString("ab_id");
                    cVar2.J = optJSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                    cVar2.K = optJSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                    cVar2.L = optJSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                    cVar2.y(optJSONObject.optInt(RewardPlus.AMOUNT, 1));
                    cVar2.N = optJSONObject.optString(RewardPlus.ICON, "");
                    cVar2.O = optJSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                    cVar2.d(optJSONObject.optString("name", "Virtual Item"));
                    cVar2.S = optJSONObject.optInt("video_error_rule", 1);
                    cVar2.T = optJSONObject.optInt("loadtmo", 60);
                    return cVar2;
                } catch (Exception e3) {
                    e = e3;
                    cVar = cVar2;
                    e.printStackTrace();
                    return cVar;
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return cVar;
            }
        }
        return cVar;
    }

    public final JSONObject D() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.b);
            jSONObject.put("callbackType", this.i);
            if (this.d != null && this.d.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (b next : this.d) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", next.a());
                    jSONObject2.put("timeout", next.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.j);
            jSONObject.put("acn", this.k);
            jSONObject.put("vcn", this.l);
            jSONObject.put("offset", this.m);
            jSONObject.put("dlnet", this.n);
            jSONObject.put("tv_start", this.o);
            jSONObject.put("tv_end", this.p);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.q);
            jSONObject.put("endscreen_type", this.I);
            jSONObject.put("daily_play_cap", this.B);
            jSONObject.put("video_skip_time", this.C);
            jSONObject.put("video_skip_result", this.D);
            jSONObject.put("video_interactive_type", this.E);
            jSONObject.put("orientation", this.z);
            jSONObject.put("close_button_delay", this.F);
            jSONObject.put("playclosebtn_tm", this.f);
            jSONObject.put("play_ctdown", this.g);
            jSONObject.put("close_alert", this.h);
            jSONObject.put("rfpv", this.t);
            jSONObject.put("vdcmp", this.s);
            JSONArray jSONArray2 = new JSONArray();
            if (this.u != null) {
                if (this.u.size() > 0) {
                    Iterator<Integer> it = this.u.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put("atl_type", jSONArray2);
            }
            jSONObject.put("atl_dyt", this.v);
            jSONObject.put("tmorl", this.w);
            jSONObject.put(PangleConstants.PLACEMENT_ID, this.c);
            jSONObject.put("ltafemty", this.x);
            jSONObject.put("ltorwc", this.y);
            jSONObject.put(RewardPlus.AMOUNT_MAX, this.J);
            jSONObject.put(RewardPlus.CALLBACK_RULE, this.K);
            jSONObject.put(RewardPlus.VIRTUAL_CURRENCY, this.L);
            jSONObject.put(RewardPlus.AMOUNT, this.M);
            jSONObject.put(RewardPlus.ICON, this.N);
            jSONObject.put(RewardPlus.CURRENCY_ID, this.O);
            jSONObject.put("name", this.P);
            jSONObject.put("isDefault", this.R);
            jSONObject.put("video_error_rule", this.S);
            jSONObject.put("loadtmo", this.T);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static c a(JSONObject jSONObject) {
        c cVar;
        if (jSONObject == null) {
            return null;
        }
        try {
            cVar = new c();
            try {
                cVar.d = b.a(jSONObject.optJSONArray("adSourceList"));
                cVar.i = jSONObject.optInt("callbackType");
                int optInt = jSONObject.optInt("aqn", 1);
                if (optInt <= 0) {
                    optInt = 1;
                }
                cVar.j = optInt;
                int optInt2 = jSONObject.optInt("acn", 1);
                if (optInt2 < 0) {
                    optInt2 = 1;
                }
                cVar.k = optInt2;
                cVar.l = jSONObject.optInt("vcn", 5);
                cVar.m = jSONObject.optInt("offset", 5);
                cVar.n = jSONObject.optInt("dlnet", 2);
                cVar.I = jSONObject.optInt("endscreen_type", 2);
                cVar.o = jSONObject.optInt("tv_start", 3);
                cVar.p = jSONObject.optInt("tv_end", 80);
                cVar.q = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                cVar.e = jSONObject.optLong("current_time");
                cVar.z = jSONObject.optInt("orientation", 0);
                cVar.B = jSONObject.optInt("daily_play_cap", 0);
                cVar.C = jSONObject.optInt("video_skip_time", -1);
                cVar.D = jSONObject.optInt("video_skip_result", 2);
                cVar.E = jSONObject.optInt("video_interactive_type", -1);
                cVar.F = jSONObject.optInt("close_button_delay", 1);
                cVar.f = jSONObject.optInt("playclosebtn_tm", -1);
                cVar.g = jSONObject.optInt("play_ctdown", 0);
                cVar.h = jSONObject.optInt("close_alert", 0);
                cVar.G = jSONObject.optInt("rdrct", 20);
                cVar.t = jSONObject.optInt("rfpv", -1);
                cVar.s = jSONObject.optDouble("vdcmp", 1.0d);
                cVar.A = jSONObject.optInt("load_global_timeout", 70);
                JSONArray optJSONArray = jSONObject.optJSONArray("atl_type");
                ArrayList<Integer> arrayList = new ArrayList<>();
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        try {
                            arrayList.add(Integer.valueOf(optJSONArray.getInt(i2)));
                            i2++;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    arrayList.add(4);
                    arrayList.add(6);
                }
                cVar.u = arrayList;
                cVar.v = jSONObject.optInt("atl_dyt", 3);
                int optInt3 = jSONObject.optInt("tmorl", 1);
                if (optInt3 > 2 || optInt3 <= 0) {
                    optInt3 = 1;
                }
                cVar.w = optInt3;
                cVar.c = jSONObject.optString(PangleConstants.PLACEMENT_ID);
                cVar.x = jSONObject.optInt("ltafemty", 10);
                cVar.y = jSONObject.optInt("ltorwc", 60);
                cVar.Q = jSONObject.optString("ab_id");
                cVar.J = jSONObject.optInt(RewardPlus.AMOUNT_MAX, 0);
                cVar.K = jSONObject.optInt(RewardPlus.CALLBACK_RULE, 1);
                cVar.L = jSONObject.optString(RewardPlus.VIRTUAL_CURRENCY, "");
                cVar.y(jSONObject.optInt(RewardPlus.AMOUNT, 1));
                cVar.N = jSONObject.optString(RewardPlus.ICON, "");
                cVar.O = jSONObject.optInt(RewardPlus.CURRENCY_ID, 1);
                cVar.d(jSONObject.optString("name", "Virtual Item"));
                cVar.S = jSONObject.optInt("video_error_rule", 1);
                cVar.T = jSONObject.optInt("loadtmo", 60);
                return cVar;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e4) {
            e = e4;
            cVar = null;
            e.printStackTrace();
            return cVar;
        }
    }

    public final int E() {
        return this.A;
    }

    public final void x(int i2) {
        this.A = i2;
    }
}
