package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.mbridge.msdk.b.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.tools.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: RequestUrlUtil */
public final class d {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public boolean n;
    public ArrayList<String> o;
    private final String p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* compiled from: RequestUrlUtil */
    private static class a {
        /* access modifiers changed from: private */
        public static final d a = new d();
    }

    public final boolean a() {
        try {
            if (this.o == null || this.m > this.o.size() - 1) {
                if (this.n) {
                    this.m = 0;
                }
                return false;
            }
            this.c = this.o.get(this.m);
            e();
            return true;
        } catch (Throwable th) {
            q.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    public final boolean b() {
        return this.q;
    }

    private d() {
        this.p = "RequestUrlUtil";
        this.q = true;
        this.r = "https://{}hb.rayjump.com";
        this.a = "https://analytics.rayjump.com";
        this.b = "https://net.rayjump.com";
        this.c = "https://configure.rayjump.com";
        this.s = "/bid";
        this.t = "/load";
        this.u = "/openapi/ad/v3";
        this.v = "/openapi/ad/v4";
        this.w = "/openapi/ad/v5";
        this.x = "/setting";
        this.y = "/sdk/customid";
        this.z = "/rewardsetting";
        this.d = this.r + this.s;
        this.e = this.r + this.t;
        this.f = this.b + this.u;
        this.g = this.b + this.v;
        this.h = this.b + this.w;
        this.i = this.c + this.x;
        this.j = this.c + this.y;
        this.k = this.c + this.z;
        this.l = "https://d1tru86qrby720.cloudfront.net/hostsetting";
        this.m = 0;
        this.n = false;
        this.o = new ArrayList<>(Arrays.asList(new String[]{"https://configure.rayjump.com", "https://policy.rayjump.com", "https://lazy.rayjump.com", "https://check.rayjump.com"}));
    }

    public static d c() {
        return a.a;
    }

    public final String a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return a(true, split[1]);
                }
            }
        } catch (Exception e2) {
            q.d("RequestUrlUtil", e2.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return a.a.q ? this.h : this.f;
        }
        return a(true, "");
    }

    public final String a(boolean z2, String str) {
        if (!z2) {
            return this.d.replace("{}", "");
        }
        if (!this.e.contains("{}") || TextUtils.isEmpty(str)) {
            return this.e.replace("{}", "");
        }
        String str2 = this.e;
        return str2.replace("{}", str + "-");
    }

    public final void d() {
        HashMap<String, String> ai;
        com.mbridge.msdk.b.a b2 = b.a().b(com.mbridge.msdk.foundation.controller.a.e().h());
        if (b2 != null) {
            this.q = !b2.i(2);
            if (b2.ai() != null && b2.ai().size() > 0 && (ai = b2.ai()) != null && ai.size() > 0) {
                if (ai.containsKey("v") && !TextUtils.isEmpty(ai.get("v")) && b(ai.get("v"))) {
                    this.b = ai.get("v");
                    this.f = this.b + this.u;
                    this.g = this.b + this.v;
                    this.h = this.b + this.w;
                }
                if (ai.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(ai.get(CampaignEx.JSON_KEY_HB)) && b(ai.get(CampaignEx.JSON_KEY_HB))) {
                    this.r = ai.get(CampaignEx.JSON_KEY_HB);
                    this.d = this.r + this.s;
                    this.e = this.r + this.t;
                }
                if (ai.containsKey("lg") && !TextUtils.isEmpty(ai.get("lg"))) {
                    String str = ai.get("lg");
                    if (b(str)) {
                        this.a = str;
                    } else if (!TextUtils.isEmpty(str)) {
                        m.a().a(str);
                    }
                }
            }
        }
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]".trim()).matcher(str.trim()).matches();
    }

    public final void e() {
        this.i = this.c + this.x;
        this.j = this.c + this.y;
        this.k = this.c + this.z;
    }
}
