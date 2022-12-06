package com.mbridge.msdk.b;

import android.text.TextUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.vungle.warren.model.AdvertisementDBAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UnitSetting */
public final class d {
    private int A;
    private int B;
    private int C;
    private String D = "";
    private int E = 10;
    private int F = 60;
    private String G = "";
    private int H = 1;
    private int I = 100;
    private int J = 0;
    private int K;
    private int L;
    private int a;
    private int b;
    private int c;
    private int d = 30;
    private String e;
    private String f;
    private List<Integer> g;
    private long h;
    private int i = 1;
    private List<Integer> j;
    private int k;
    private int l;
    private int m;
    private int n;
    private String o;
    private int p;
    private int q = 1;
    private int r = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
    private int s;
    private int t;
    private long u;
    private String v;
    private int w;
    private long x;
    private long y;
    private int z = 60;

    public final String a() {
        return this.G;
    }

    public final void a(int i2) {
        this.B = i2;
    }

    public final void b(int i2) {
        this.C = i2;
    }

    public final int b() {
        return this.z;
    }

    public final int c() {
        return this.A;
    }

    public final int d() {
        return this.L;
    }

    public final int e() {
        return this.I;
    }

    public final int f() {
        return this.J;
    }

    public final int g() {
        return this.K;
    }

    public final long h() {
        return this.u;
    }

    public final int i() {
        return this.s;
    }

    public final void c(int i2) {
        this.s = i2;
    }

    public final int j() {
        return this.t;
    }

    public static d k() {
        return new d();
    }

    public final int l() {
        return this.n;
    }

    public final int m() {
        return this.q;
    }

    public final int n() {
        return this.r;
    }

    public final int o() {
        return this.l;
    }

    public final int p() {
        return this.m;
    }

    public final String toString() {
        List<Integer> list = this.g;
        String str = "";
        if (list != null && list.size() > 0) {
            for (Integer num : this.g) {
                str = str + num + ",";
            }
        }
        return "offset = " + this.i + " unitId = " + this.e + " fbPlacementId = " + this.f + str;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final List<Integer> q() {
        return this.g;
    }

    public final List<Integer> r() {
        return this.j;
    }

    public static d b(String str) {
        d dVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            d dVar2 = new d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                dVar2.e = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                dVar2.G = jSONObject.optString("ab_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("adSourceList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                    }
                    dVar2.g = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        arrayList2.add(Integer.valueOf(optJSONArray2.optInt(i3)));
                    }
                    dVar2.j = arrayList2;
                }
                dVar2.k = jSONObject.optInt("tpqn");
                dVar2.l = jSONObject.optInt("aqn");
                dVar2.m = jSONObject.optInt("acn");
                dVar2.n = jSONObject.optInt("wt");
                dVar2.q = jSONObject.optInt("iscasf", 1);
                dVar2.r = jSONObject.optInt("spmxrt", DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
                dVar2.h = jSONObject.optLong("current_time");
                dVar2.i = jSONObject.optInt("offset");
                dVar2.u = jSONObject.optLong("dlct", 3600);
                dVar2.s = jSONObject.optInt("autoplay", 0);
                dVar2.t = jSONObject.optInt("dlnet", 2);
                dVar2.v = jSONObject.optString("no_offer");
                dVar2.w = jSONObject.optInt("cb_type");
                dVar2.x = jSONObject.optLong("clct", 86400);
                dVar2.y = jSONObject.optLong("clcq", 300);
                dVar2.I = jSONObject.optInt(CampaignEx.JSON_KEY_READY_RATE, 100);
                dVar2.J = jSONObject.optInt("cd_rate", 0);
                dVar2.K = jSONObject.optInt("content", 1);
                dVar2.L = jSONObject.optInt("impt", 0);
                dVar2.p = jSONObject.optInt("icon_type", 1);
                dVar2.o = jSONObject.optString("no_ads_url", "");
                dVar2.a = jSONObject.optInt("playclosebtn_tm", -1);
                dVar2.b = jSONObject.optInt("play_ctdown", 0);
                dVar2.c = jSONObject.optInt("close_alert", 0);
                dVar2.d = jSONObject.optInt("intershowlimit", 30);
                dVar2.z = jSONObject.optInt("refreshFq", 60);
                dVar2.A = jSONObject.optInt("closeBtn", 0);
                int optInt = jSONObject.optInt("tmorl", 1);
                if (optInt > 2 || optInt <= 0) {
                    optInt = 1;
                }
                dVar2.H = optInt;
                dVar2.D = jSONObject.optString(PangleConstants.PLACEMENT_ID, "");
                dVar2.E = jSONObject.optInt("ltafemty", 10);
                dVar2.F = jSONObject.optInt("ltorwc", 60);
                return dVar2;
            } catch (Exception e2) {
                e = e2;
                dVar = dVar2;
                e.printStackTrace();
                return dVar;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return dVar;
        }
    }

    public final JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.g != null && this.g.size() > 0) {
                int size = this.g.size();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(this.g.get(i2));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            if (this.j != null && this.j.size() > 0) {
                int size2 = this.j.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < size2; i3++) {
                    jSONArray2.put(this.j.get(i3));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put("tpqn", this.k);
            jSONObject.put("aqn", this.l);
            jSONObject.put("acn", this.m);
            jSONObject.put("wt", this.n);
            jSONObject.put("current_time", this.h);
            jSONObject.put("offset", this.i);
            jSONObject.put("dlct", this.u);
            jSONObject.put("autoplay", this.s);
            jSONObject.put("dlnet", this.t);
            jSONObject.put("no_offer", this.v);
            jSONObject.put("cb_type", this.w);
            jSONObject.put("clct", this.x);
            jSONObject.put("clcq", this.y);
            jSONObject.put(CampaignEx.JSON_KEY_READY_RATE, this.I);
            jSONObject.put("content", this.K);
            jSONObject.put("impt", this.L);
            jSONObject.put("icon_type", this.p);
            jSONObject.put("no_ads_url", this.o);
            jSONObject.put("playclosebtn_tm", this.a);
            jSONObject.put("play_ctdown", this.b);
            jSONObject.put("close_alert", this.c);
            jSONObject.put("closeBtn", this.A);
            jSONObject.put("refreshFq", this.z);
            jSONObject.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_COUNTDOWN, this.C);
            jSONObject.put("allowSkip", this.B);
            jSONObject.put("tmorl", this.H);
            jSONObject.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.e);
            jSONObject.put(PangleConstants.PLACEMENT_ID, this.D);
            jSONObject.put("ltafemty", this.E);
            jSONObject.put("ltorwc", this.F);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final long t() {
        return this.h;
    }

    public final int u() {
        return this.i;
    }

    public static d c(String str) {
        d k2 = k();
        k2.s = 0;
        return k2;
    }

    public static d d(String str) {
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        dVar.i = 1;
        dVar.e = str;
        dVar.g = arrayList;
        dVar.j = arrayList2;
        dVar.k = 1;
        dVar.m = -2;
        dVar.l = -2;
        dVar.n = 5;
        dVar.u = 3600;
        dVar.t = 2;
        dVar.s = 1;
        dVar.I = 100;
        dVar.J = 0;
        dVar.K = 1;
        dVar.L = 0;
        dVar.z = 60;
        dVar.E = 10;
        dVar.F = 60;
        return dVar;
    }

    public static d e(String str) {
        d dVar = new d();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            dVar.g = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            dVar.j = arrayList2;
            dVar.e = str;
            dVar.i = 1;
            dVar.k = 1;
            dVar.m = -2;
            dVar.l = -2;
            dVar.n = 5;
            dVar.u = 3600;
            dVar.t = 2;
            dVar.s = 3;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return dVar;
    }

    public static d f(String str) {
        d dVar = new d();
        try {
            dVar.e = str;
            dVar.i = 1;
            dVar.k = 1;
            dVar.n = 5;
            dVar.m = 1;
            dVar.l = 1;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return dVar;
    }

    public final void g(String str) {
        this.D = str;
    }

    public final int v() {
        return this.E;
    }

    public final int w() {
        return this.F;
    }
}
