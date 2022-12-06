package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

/* compiled from: VideoReportData */
public final class m {
    public static int a = 1;
    public static int b;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private int H = 0;
    private int I;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private String h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r = 0;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public final String a() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String b() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final String c() {
        return this.e;
    }

    public final void c(String str) {
        this.e = URLEncoder.encode(str);
    }

    public final String d() {
        return this.F;
    }

    public final void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.F = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String e() {
        return this.E;
    }

    public final void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.E = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String f() {
        return this.D;
    }

    public final void f(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.D = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final String g() {
        return this.C;
    }

    public final void g(String str) {
        this.C = str;
    }

    public final String h() {
        return this.G;
    }

    public final void h(String str) {
        this.G = str;
    }

    public final String i() {
        return this.w;
    }

    public final void i(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.w = URLEncoder.encode(str, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public final void j(String str) {
        this.y = str;
    }

    public final void a(int i2) {
        this.H = i2;
    }

    public final int j() {
        return this.I;
    }

    public final void b(int i2) {
        this.I = i2;
    }

    public m(String str, int i2, int i3, int i4, int i5, String str2, String str3, int i6, String str4, int i7, String str5) {
        this.f = str;
        this.g = i2;
        this.h = str5;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.m = str3;
        this.o = i6;
        this.p = str4;
        this.q = (long) i7;
    }

    public m() {
    }

    public m(String str, int i2, String str2, String str3, String str4) {
        this.f = str;
        this.h = str4;
        this.g = i2;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.m = str3;
    }

    public m(String str, int i2, int i3, String str2, int i4, String str3, int i5, String str4) {
        this.f = str;
        this.g = i2;
        this.h = str4;
        this.k = i3;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.l = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        this.o = i4;
        this.p = str3;
        this.q = (long) i5;
    }

    public m(Context context, CampaignEx campaignEx, int i2, String str, long j2, int i3) {
        if (i3 == 1) {
            this.f = "2000022";
        } else if (i3 == 287 || i3 == 94) {
            this.f = "2000022";
        } else if (i3 == 95) {
            this.f = "2000025";
        }
        this.g = com.mbridge.msdk.foundation.tools.m.n(context);
        this.h = com.mbridge.msdk.foundation.tools.m.a(context, this.g);
        this.k = campaignEx.getVideoLength();
        try {
            this.l = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.o = i2;
        this.p = str;
        this.q = j2 == 0 ? (long) campaignEx.getVideoSize() : j2;
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7) {
        this.f = str;
        this.z = str2;
        this.x = str3;
        this.A = str4;
        this.u = str5;
        this.v = str6;
        this.g = i2;
        this.h = str7;
    }

    public m(String str) {
        this.B = str;
    }

    public m(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f = str;
        this.o = i2;
        this.p = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.D = URLEncoder.encode(str3, "utf-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.v = str4;
        this.u = str5;
        this.m = str6;
        this.C = str7;
        if (Integer.valueOf(str2).intValue() > a.m) {
            this.o = 2;
        }
    }

    public m(String str, String str2, String str3, String str4, String str5, int i2) {
        this.f = str;
        this.v = str2;
        this.s = str3;
        this.t = str4;
        this.u = str5;
        this.g = i2;
    }

    public m(String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6) {
        this.f = str;
        this.v = str2;
        this.s = str3;
        this.t = str4;
        this.u = str5;
        this.g = i2;
        this.m = str6;
        this.n = i3;
    }

    public final String k() {
        return this.s;
    }

    public final void k(String str) {
        this.s = str;
    }

    public final String l() {
        return this.t;
    }

    public final void l(String str) {
        this.t = str;
    }

    public final String m() {
        return this.u;
    }

    public final void m(String str) {
        this.u = str;
    }

    public final String n() {
        return this.v;
    }

    public final void n(String str) {
        this.v = str;
    }

    public final String o() {
        return this.f;
    }

    public final void o(String str) {
        this.f = str;
    }

    public final int p() {
        return this.j;
    }

    public final int q() {
        return this.k;
    }

    public final String r() {
        return this.l;
    }

    public final String s() {
        return this.m;
    }

    public final void p(String str) {
        this.m = str;
    }

    public final String t() {
        return this.p;
    }

    public final void q(String str) {
        this.p = str;
    }

    public final long u() {
        return this.q;
    }

    public final int v() {
        return this.g;
    }

    public final void c(int i2) {
        this.g = i2;
    }

    public final String w() {
        return this.h;
    }

    public final void r(String str) {
        this.h = str;
    }

    public final int x() {
        return this.i;
    }

    public final int y() {
        return this.o;
    }

    public final void d(int i2) {
        this.o = i2;
    }

    public static String a(List<m> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (m next : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("network_type=" + next.g + "&");
                stringBuffer.append("network_str=" + next.h + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("video_url=" + next.E + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("offer_url=");
                sb.append(next.l);
                stringBuffer.append(sb.toString());
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("video_url=" + next.E + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("offer_url=");
                sb2.append(next.l);
                stringBuffer.append(sb2.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String b(List<m> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<m> it = list.iterator();
        while (it.hasNext()) {
            m next = it.next();
            Iterator<m> it2 = it;
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("network_type=" + next.g + "&");
                stringBuffer.append("network_str=" + next.h + "&");
                stringBuffer.append("result=" + next.o + "&");
                stringBuffer.append("duration=" + next.p + "&");
                stringBuffer.append("video_size=" + next.q + "&");
                stringBuffer.append("video_length=" + next.k + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("video_url=" + next.E + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                stringBuffer.append("offer_url=" + next.l + "&");
            } else {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("result=" + next.o + "&");
                stringBuffer.append("duration=" + next.p + "&");
                stringBuffer.append("video_size=" + next.q + "&");
                stringBuffer.append("video_length=" + next.k + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("video_url=" + next.E + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                stringBuffer.append("offer_url=" + next.l + "&");
            }
            if (next.c != null) {
                stringBuffer.append("resource_type=" + next.c + "&");
            }
            if (next.e != null) {
                stringBuffer.append("creative=" + next.e + "&");
            }
            stringBuffer.append("\n");
            it = it2;
        }
        return stringBuffer.toString();
    }

    public static String a(m mVar) {
        if (mVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + mVar.f + "&");
        stringBuffer.append("cid=" + mVar.v + "&");
        stringBuffer.append("unit_id=" + mVar.u + "&");
        stringBuffer.append("network_type=" + mVar.g + "&");
        stringBuffer.append("rid=" + mVar.s + "&");
        stringBuffer.append("rid_n=" + mVar.t + "&");
        StringBuilder sb = new StringBuilder();
        sb.append("reason=");
        sb.append(mVar.m);
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String b(m mVar) {
        if (mVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + mVar.f + "&");
        stringBuffer.append("cid=" + mVar.v + "&");
        stringBuffer.append("unit_id=" + mVar.u + "&");
        stringBuffer.append("network_type=" + mVar.g + "&");
        stringBuffer.append("mraid_type=" + mVar.H + "&");
        stringBuffer.append("rid_n=" + mVar.t + "&");
        StringBuilder sb = new StringBuilder();
        sb.append("rid=");
        sb.append(mVar.s);
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String c(m mVar) {
        if (mVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + mVar.f + "&");
        stringBuffer.append("result=" + mVar.o + "&");
        stringBuffer.append("duration=" + mVar.p + "&");
        stringBuffer.append("cid=" + mVar.v + "&");
        stringBuffer.append("reason=" + mVar.m + "&");
        stringBuffer.append("ad_type=" + mVar.G + "&");
        stringBuffer.append("unit_id=" + mVar.u + "&");
        stringBuffer.append("devid=" + mVar.d + "&");
        stringBuffer.append("mraid_type=" + mVar.H + "&");
        stringBuffer.append("network_type=" + mVar.g + "&");
        if (!TextUtils.isEmpty(mVar.D)) {
            stringBuffer.append("endcard_url=" + mVar.D + "&");
        }
        if (!TextUtils.isEmpty(mVar.C)) {
            stringBuffer.append("type=" + mVar.C + "&");
        }
        if (mVar.c != null) {
            stringBuffer.append("resource_type=" + mVar.c + "&");
        }
        stringBuffer.append("rid_n=" + mVar.t + "&");
        StringBuilder sb = new StringBuilder();
        sb.append("rid=");
        sb.append(mVar.s);
        stringBuffer.append(sb.toString());
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    public static String d(m mVar) {
        if (mVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + mVar.f + "&");
        stringBuffer.append("result=" + mVar.o + "&");
        stringBuffer.append("duration=" + mVar.p + "&");
        stringBuffer.append("cid=" + mVar.v + "&");
        stringBuffer.append("unit_id=" + mVar.u + "&");
        stringBuffer.append("reason=" + mVar.m + "&");
        stringBuffer.append("ad_type=" + mVar.G + "&");
        stringBuffer.append("rid=" + mVar.s + "&");
        stringBuffer.append("rid_n=" + mVar.t + "&");
        stringBuffer.append("network_type=" + mVar.g + "&");
        stringBuffer.append("mraid_type=" + mVar.H + "&");
        stringBuffer.append("devid=" + mVar.d + "&");
        if (mVar.c != null) {
            stringBuffer.append("resource_type=" + mVar.c + "&");
        }
        if (!TextUtils.isEmpty(mVar.D)) {
            stringBuffer.append("endcard_url=" + mVar.D + "&");
        }
        stringBuffer.append("type=" + mVar.C);
        return stringBuffer.toString();
    }

    public static String c(List<m> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (m next : list) {
            stringBuffer.append("key=" + next.f + "&");
            stringBuffer.append("result=" + next.o + "&");
            stringBuffer.append("duration=" + next.p + "&");
            stringBuffer.append("endcard_url=" + next.D + "&");
            stringBuffer.append("cid=" + next.v + "&");
            stringBuffer.append("unit_id=" + next.u + "&");
            stringBuffer.append("reason=" + next.m + "&");
            stringBuffer.append("ad_type=" + next.G + "&");
            stringBuffer.append("rid=" + next.s + "&");
            stringBuffer.append("rid_n=" + next.t + "&");
            stringBuffer.append("type=" + next.C + "&");
            StringBuilder sb = new StringBuilder();
            sb.append("adspace_t=");
            sb.append(next.I);
            stringBuffer.append(sb.toString());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static String d(List<m> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (m next : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("network_type=" + next.g + "&");
                stringBuffer.append("result=" + next.o + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("template_url=" + next.w + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("result=" + next.o + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("template_url=" + next.w + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(List<m> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (m next : list) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("network_type=" + next.g + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("image_url=" + next.F + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                stringBuffer.append("\n");
            } else {
                stringBuffer.append("key=" + next.f + "&");
                stringBuffer.append("cid=" + next.v + "&");
                stringBuffer.append("image_url=" + next.F + "&");
                stringBuffer.append("reason=" + next.m + "&");
                stringBuffer.append("rid=" + next.s + "&");
                stringBuffer.append("rid_n=" + next.t + "&");
                stringBuffer.append("unit_id=" + next.u + "&");
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String e(m mVar) {
        if (mVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + mVar.f + "&");
                stringBuffer.append("error=" + u.c(mVar.y) + "&");
                stringBuffer.append("template_url=" + u.c(mVar.w) + "&");
                stringBuffer.append("unit_id=" + u.c(mVar.u) + "&");
                stringBuffer.append("cid=" + u.c(mVar.v) + "&");
                stringBuffer.append("network_str=" + mVar.h + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("network_type=");
                sb.append(mVar.g);
                stringBuffer.append(sb.toString());
            } else {
                stringBuffer.append("key=" + mVar.f + "&");
                stringBuffer.append("error=" + u.c(mVar.y) + "&");
                stringBuffer.append("template_url=" + u.c(mVar.w) + "&");
                stringBuffer.append("unit_id=" + u.c(mVar.u) + "&");
                stringBuffer.append("cid=" + u.c(mVar.v) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String f(m mVar) {
        if (mVar == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                stringBuffer.append("key=" + mVar.f + "&");
                stringBuffer.append("event=" + u.c(mVar.z) + "&");
                stringBuffer.append("template=" + u.c(mVar.x) + "&");
                stringBuffer.append("layout=" + u.c(mVar.A) + "&");
                stringBuffer.append("unit_id=" + u.c(mVar.u) + "&");
                stringBuffer.append("cid=" + u.c(mVar.v) + "&");
                stringBuffer.append("network_str=" + mVar.h + "&");
                StringBuilder sb = new StringBuilder();
                sb.append("network_type=");
                sb.append(mVar.g);
                stringBuffer.append(sb.toString());
            } else {
                stringBuffer.append("key=" + mVar.f + "&");
                stringBuffer.append("event=" + u.c(mVar.z) + "&");
                stringBuffer.append("template=" + u.c(mVar.x) + "&");
                stringBuffer.append("layout=" + u.c(mVar.A) + "&");
                stringBuffer.append("unit_id=" + u.c(mVar.u) + "&");
                stringBuffer.append("cid=" + u.c(mVar.v) + "&");
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String f(List<m> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (m mVar : list) {
                stringBuffer.append(mVar.B);
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            q.a("VideoReportData", th.getMessage(), th);
            return null;
        }
    }

    public static String g(m mVar) {
        if (mVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + mVar.f + "&");
        stringBuffer.append("cid=" + mVar.v + "&");
        stringBuffer.append("rid=" + mVar.s + "&");
        stringBuffer.append("rid_n=" + mVar.t + "&");
        stringBuffer.append("unit_id=" + mVar.u + "&");
        stringBuffer.append("network_type=" + mVar.g + "&");
        stringBuffer.append("mraid_type=" + mVar.H + "&");
        stringBuffer.append("platform=1");
        return stringBuffer.toString();
    }

    public static String h(m mVar) {
        if (mVar == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=" + mVar.f + "&");
        stringBuffer.append("cid=" + mVar.v + "&");
        stringBuffer.append("rid=" + mVar.s + "&");
        stringBuffer.append("rid_n=" + mVar.t + "&");
        stringBuffer.append("unit_id=" + mVar.u + "&");
        stringBuffer.append("reason=" + mVar.m + "&");
        stringBuffer.append("case=" + mVar.n + "&");
        StringBuilder sb = new StringBuilder();
        sb.append("network_type=");
        sb.append(mVar.g);
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public final String toString() {
        return "RewardReportData [key=" + this.f + ", networkType=" + this.g + ", isCompleteView=" + this.i + ", watchedMillis=" + this.j + ", videoLength=" + this.k + ", offerUrl=" + this.l + ", reason=" + this.m + ", result=" + this.o + ", duration=" + this.p + ", videoSize=" + this.q + "]";
    }
}
