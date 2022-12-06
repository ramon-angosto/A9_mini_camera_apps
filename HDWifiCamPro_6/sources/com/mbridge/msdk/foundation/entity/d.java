package com.mbridge.msdk.foundation.entity;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.authoritycontroller.a;
import java.util.Iterator;
import java.util.List;

/* compiled from: ClickTime */
public final class d {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private String l;
    private int m;
    private int n;
    private String o;
    private int p;
    private String q;
    private int r;

    public d() {
    }

    public d(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, String str9, int i5, int i6, String str10, int i7, int i8, String str11) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i2;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = i3;
        this.k = i4;
        this.l = str9;
        this.m = i5;
        this.n = i6;
        this.o = str10;
        this.p = i7;
        this.q = str11;
        this.r = i8;
    }

    public final void a(int i2) {
        this.p = i2;
    }

    public final void a(String str) {
        this.q = str;
    }

    public final void b(String str) {
        this.l = str;
    }

    public final void b(int i2) {
        this.m = i2;
    }

    public final void c(int i2) {
        this.n = i2;
    }

    public final void c(String str) {
        this.o = str;
    }

    public final void d(int i2) {
        this.k = i2;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void e(int i2) {
        this.f = i2;
    }

    public final void e(String str) {
        this.h = str;
    }

    public final void f(String str) {
        this.i = str;
    }

    public final void f(int i2) {
        this.j = i2;
    }

    public final void g(String str) {
        this.e = str;
    }

    public final void h(String str) {
        this.c = str;
    }

    public final void i(String str) {
        this.d = str;
    }

    public final void j(String str) {
        this.a = str;
    }

    public final void k(String str) {
        this.b = str;
    }

    public static String a(List<d> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            d next = it.next();
            Iterator<d> it2 = it;
            String str = "&link_type=";
            String str2 = "&landing_type=";
            if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                sb.append("rid=" + next.a);
                sb.append("&rid_n=" + next.b);
                sb.append("&network_type=" + next.p);
                sb.append("&network_str=" + next.q);
                sb.append("&cid=" + next.c);
                sb.append("&click_type=" + next.k);
                sb.append("&type=" + next.j);
                sb.append("&click_duration=" + next.d);
                sb.append("&key=2000013");
                sb.append("&unit_id=" + next.l);
                sb.append("&last_url=" + next.e);
                sb.append("&content=" + next.i);
                sb.append("&code=" + next.f);
                sb.append("&exception=" + next.g);
                sb.append("&header=" + next.h);
                sb.append(str2 + next.m);
                sb.append(str + next.n);
                sb.append("&click_time=" + next.o + "\n");
            } else {
                sb.append("rid=" + next.a);
                sb.append("&rid_n=" + next.b);
                sb.append("&cid=" + next.c);
                sb.append("&click_type=" + next.k);
                sb.append("&type=" + next.j);
                sb.append("&click_duration=" + next.d);
                sb.append("&key=2000013");
                sb.append("&unit_id=" + next.l);
                sb.append("&last_url=" + next.e);
                sb.append("&content=" + next.i);
                sb.append("&code=" + next.f);
                sb.append("&exception=" + next.g);
                sb.append("&header=" + next.h);
                sb.append(str2 + next.m);
                sb.append(str + next.n);
                sb.append("&click_time=" + next.o + "\n");
            }
            it = it2;
        }
        return sb.toString();
    }

    public static String a(d dVar) {
        d dVar2 = dVar;
        if (dVar2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = dVar2.e;
        String str2 = "\n";
        String str3 = "&click_time=";
        String str4 = "&link_type=";
        if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            sb.append("rid=" + dVar2.a);
            sb.append("&rid_n=" + dVar2.b);
            sb.append("&network_type=" + dVar2.p);
            sb.append("&network_str=" + dVar2.q);
            sb.append("&click_type=" + dVar2.k);
            sb.append("&type=" + dVar2.j);
            sb.append("&cid=" + dVar2.c);
            sb.append("&click_duration=" + dVar2.d);
            sb.append("&key=2000012");
            sb.append("&unit_id=" + dVar2.l);
            sb.append("&last_url=" + str);
            sb.append("&code=" + dVar2.f);
            sb.append("&exception=" + dVar2.g);
            sb.append("&landing_type=" + dVar2.m);
            sb.append(str4 + dVar2.n);
            sb.append(str3 + dVar2.o + str2);
        } else {
            sb.append("rid=" + dVar2.a);
            sb.append("&rid_n=" + dVar2.b);
            sb.append("&click_type=" + dVar2.k);
            sb.append("&type=" + dVar2.j);
            sb.append("&cid=" + dVar2.c);
            sb.append("&click_duration=" + dVar2.d);
            sb.append("&key=2000012");
            sb.append("&unit_id=" + dVar2.l);
            sb.append("&last_url=" + str);
            sb.append("&code=" + dVar2.f);
            sb.append("&exception=" + dVar2.g);
            sb.append("&landing_type=" + dVar2.m);
            sb.append(str4 + dVar2.n);
            sb.append(str3 + dVar2.o + str2);
        }
        return sb.toString();
    }

    public final String toString() {
        return "ClickTime [campaignId=" + this.c + ", click_duration=" + this.d + ", lastUrl=" + this.e + ", code=" + this.f + ", excepiton=" + this.g + ", header=" + this.h + ", content=" + this.i + ", type=" + this.j + ", click_type=" + this.k + "]";
    }
}
