package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.gp */
public class C1836gp {

    /* renamed from: a */
    private int f2552a;

    /* renamed from: a */
    private String f2553a;

    /* renamed from: a */
    private List<C1826gi> f2554a = null;

    /* renamed from: b */
    private String f2555b;

    /* renamed from: c */
    private String f2556c;

    /* renamed from: d */
    private String f2557d;

    /* renamed from: com.xiaomi.push.gp$a */
    public static class C1837a {

        /* renamed from: a */
        public static final C1837a f2558a = new C1837a("internal-server-error");

        /* renamed from: b */
        public static final C1837a f2559b = new C1837a("forbidden");

        /* renamed from: c */
        public static final C1837a f2560c = new C1837a("bad-request");

        /* renamed from: d */
        public static final C1837a f2561d = new C1837a("conflict");

        /* renamed from: e */
        public static final C1837a f2562e = new C1837a("feature-not-implemented");

        /* renamed from: f */
        public static final C1837a f2563f = new C1837a("gone");

        /* renamed from: g */
        public static final C1837a f2564g = new C1837a("item-not-found");

        /* renamed from: h */
        public static final C1837a f2565h = new C1837a("jid-malformed");

        /* renamed from: i */
        public static final C1837a f2566i = new C1837a("not-acceptable");

        /* renamed from: j */
        public static final C1837a f2567j = new C1837a("not-allowed");

        /* renamed from: k */
        public static final C1837a f2568k = new C1837a("not-authorized");

        /* renamed from: l */
        public static final C1837a f2569l = new C1837a("payment-required");

        /* renamed from: m */
        public static final C1837a f2570m = new C1837a("recipient-unavailable");

        /* renamed from: n */
        public static final C1837a f2571n = new C1837a("redirect");

        /* renamed from: o */
        public static final C1837a f2572o = new C1837a("registration-required");

        /* renamed from: p */
        public static final C1837a f2573p = new C1837a("remote-server-error");

        /* renamed from: q */
        public static final C1837a f2574q = new C1837a("remote-server-not-found");

        /* renamed from: r */
        public static final C1837a f2575r = new C1837a("remote-server-timeout");

        /* renamed from: s */
        public static final C1837a f2576s = new C1837a("resource-constraint");

        /* renamed from: t */
        public static final C1837a f2577t = new C1837a("service-unavailable");

        /* renamed from: u */
        public static final C1837a f2578u = new C1837a("subscription-required");

        /* renamed from: v */
        public static final C1837a f2579v = new C1837a("undefined-condition");

        /* renamed from: w */
        public static final C1837a f2580w = new C1837a("unexpected-request");

        /* renamed from: x */
        public static final C1837a f2581x = new C1837a("request-timeout");
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f2582a;

        public C1837a(String str) {
            this.f2582a = str;
        }

        public String toString() {
            return this.f2582a;
        }
    }

    public C1836gp(int i, String str, String str2, String str3, String str4, List<C1826gi> list) {
        this.f2552a = i;
        this.f2553a = str;
        this.f2556c = str2;
        this.f2555b = str3;
        this.f2557d = str4;
        this.f2554a = list;
    }

    public C1836gp(Bundle bundle) {
        this.f2552a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f2553a = bundle.getString("ext_err_type");
        }
        this.f2555b = bundle.getString("ext_err_cond");
        this.f2556c = bundle.getString("ext_err_reason");
        this.f2557d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f2554a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                C1826gi a = C1826gi.m3706a((Bundle) parcelable);
                if (a != null) {
                    this.f2554a.add(a);
                }
            }
        }
    }

    public C1836gp(C1837a aVar) {
        m3778a(aVar);
        this.f2557d = null;
    }

    /* renamed from: a */
    private void m3778a(C1837a aVar) {
        this.f2555b = aVar.f2582a;
    }

    /* renamed from: a */
    public Bundle mo17742a() {
        Bundle bundle = new Bundle();
        String str = this.f2553a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f2552a);
        String str2 = this.f2556c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f2555b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f2557d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<C1826gi> list = this.f2554a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (C1826gi a : this.f2554a) {
                Bundle a2 = a.mo17691a();
                if (a2 != null) {
                    bundleArr[i] = a2;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a */
    public String m3780a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f2552a);
        sb.append("\"");
        if (this.f2553a != null) {
            sb.append(" type=\"");
            sb.append(this.f2553a);
            sb.append("\"");
        }
        if (this.f2556c != null) {
            sb.append(" reason=\"");
            sb.append(this.f2556c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f2555b != null) {
            sb.append("<");
            sb.append(this.f2555b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f2557d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f2557d);
            sb.append("</text>");
        }
        for (C1831gm d : mo17742a()) {
            sb.append(d.mo17696d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a */
    public synchronized List<C1826gi> m3781a() {
        if (this.f2554a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f2554a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f2555b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f2552a);
        sb.append(")");
        if (this.f2557d != null) {
            sb.append(" ");
            sb.append(this.f2557d);
        }
        return sb.toString();
    }
}
