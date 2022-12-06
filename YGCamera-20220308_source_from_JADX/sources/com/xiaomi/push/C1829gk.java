package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.gk */
public class C1829gk extends C1830gl {

    /* renamed from: a */
    private boolean f2505a = false;

    /* renamed from: b */
    private String f2506b = null;

    /* renamed from: b */
    private boolean f2507b = false;

    /* renamed from: c */
    private String f2508c = null;

    /* renamed from: d */
    private String f2509d;

    /* renamed from: e */
    private String f2510e;

    /* renamed from: f */
    private String f2511f;

    /* renamed from: g */
    private String f2512g;

    /* renamed from: h */
    private String f2513h;

    /* renamed from: i */
    private String f2514i = "";

    /* renamed from: j */
    private String f2515j = "";

    /* renamed from: k */
    private String f2516k = "";

    /* renamed from: l */
    private String f2517l = "";

    public C1829gk() {
    }

    public C1829gk(Bundle bundle) {
        super(bundle);
        this.f2506b = bundle.getString("ext_msg_type");
        this.f2509d = bundle.getString("ext_msg_lang");
        this.f2508c = bundle.getString("ext_msg_thread");
        this.f2510e = bundle.getString("ext_msg_sub");
        this.f2511f = bundle.getString("ext_msg_body");
        this.f2512g = bundle.getString("ext_body_encode");
        this.f2513h = bundle.getString("ext_msg_appid");
        this.f2505a = bundle.getBoolean("ext_msg_trans", false);
        this.f2507b = bundle.getBoolean("ext_msg_encrypt", false);
        this.f2514i = bundle.getString("ext_msg_seq");
        this.f2515j = bundle.getString("ext_msg_mseq");
        this.f2516k = bundle.getString("ext_msg_fseq");
        this.f2517l = bundle.getString("ext_msg_status");
    }

    /* renamed from: a */
    public Bundle mo17698a() {
        Bundle a = super.mo17698a();
        if (!TextUtils.isEmpty(this.f2506b)) {
            a.putString("ext_msg_type", this.f2506b);
        }
        String str = this.f2509d;
        if (str != null) {
            a.putString("ext_msg_lang", str);
        }
        String str2 = this.f2510e;
        if (str2 != null) {
            a.putString("ext_msg_sub", str2);
        }
        String str3 = this.f2511f;
        if (str3 != null) {
            a.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f2512g)) {
            a.putString("ext_body_encode", this.f2512g);
        }
        String str4 = this.f2508c;
        if (str4 != null) {
            a.putString("ext_msg_thread", str4);
        }
        String str5 = this.f2513h;
        if (str5 != null) {
            a.putString("ext_msg_appid", str5);
        }
        if (this.f2505a) {
            a.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f2514i)) {
            a.putString("ext_msg_seq", this.f2514i);
        }
        if (!TextUtils.isEmpty(this.f2515j)) {
            a.putString("ext_msg_mseq", this.f2515j);
        }
        if (!TextUtils.isEmpty(this.f2516k)) {
            a.putString("ext_msg_fseq", this.f2516k);
        }
        if (this.f2507b) {
            a.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.f2517l)) {
            a.putString("ext_msg_status", this.f2517l);
        }
        return a;
    }

    /* renamed from: a */
    public String m3726a() {
        C1836gp a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (mo17737p() != null) {
            sb.append(" xmlns=\"");
            sb.append(mo17737p());
            sb.append("\"");
        }
        if (this.f2509d != null) {
            sb.append(" xml:lang=\"");
            sb.append(mo17719h());
            sb.append("\"");
        }
        if (mo17726j() != null) {
            sb.append(" id=\"");
            sb.append(mo17726j());
            sb.append("\"");
        }
        if (mo17729l() != null) {
            sb.append(" to=\"");
            sb.append(C1844gw.m3801a(mo17729l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(mo17710d())) {
            sb.append(" seq=\"");
            sb.append(mo17710d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(mo17712e())) {
            sb.append(" mseq=\"");
            sb.append(mo17712e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(mo17715f())) {
            sb.append(" fseq=\"");
            sb.append(mo17715f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(mo17717g())) {
            sb.append(" status=\"");
            sb.append(mo17717g());
            sb.append("\"");
        }
        if (mo17731m() != null) {
            sb.append(" from=\"");
            sb.append(C1844gw.m3801a(mo17731m()));
            sb.append("\"");
        }
        if (mo17727k() != null) {
            sb.append(" chid=\"");
            sb.append(C1844gw.m3801a(mo17727k()));
            sb.append("\"");
        }
        if (this.f2505a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f2513h)) {
            sb.append(" appid=\"");
            sb.append(mo17708c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.f2506b)) {
            sb.append(" type=\"");
            sb.append(this.f2506b);
            sb.append("\"");
        }
        if (this.f2507b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f2510e != null) {
            sb.append("<subject>");
            sb.append(C1844gw.m3801a(this.f2510e));
            sb.append("</subject>");
        }
        if (this.f2511f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.f2512g)) {
                sb.append(" encode=\"");
                sb.append(this.f2512g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(C1844gw.m3801a(this.f2511f));
            sb.append("</body>");
        }
        if (this.f2508c != null) {
            sb.append("<thread>");
            sb.append(this.f2508c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f2506b) && (a = mo17698a()) != null) {
            sb.append(a.mo17742a());
        }
        sb.append(mo17735o());
        sb.append("</message>");
        return sb.toString();
    }

    /* renamed from: a */
    public void mo17703a(String str) {
        this.f2513h = str;
    }

    /* renamed from: a */
    public void mo17704a(String str, String str2) {
        this.f2511f = str;
        this.f2512g = str2;
    }

    /* renamed from: a */
    public void mo17705a(boolean z) {
        this.f2505a = z;
    }

    /* renamed from: b */
    public String mo17701b() {
        return this.f2506b;
    }

    /* renamed from: b */
    public void mo17706b(String str) {
        this.f2514i = str;
    }

    /* renamed from: b */
    public void mo17707b(boolean z) {
        this.f2507b = z;
    }

    /* renamed from: c */
    public String mo17708c() {
        return this.f2513h;
    }

    /* renamed from: c */
    public void mo17709c(String str) {
        this.f2515j = str;
    }

    /* renamed from: d */
    public String mo17710d() {
        return this.f2514i;
    }

    /* renamed from: d */
    public void mo17711d(String str) {
        this.f2516k = str;
    }

    /* renamed from: e */
    public String mo17712e() {
        return this.f2515j;
    }

    /* renamed from: e */
    public void mo17713e(String str) {
        this.f2517l = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1829gk gkVar = (C1829gk) obj;
        if (!super.equals(gkVar)) {
            return false;
        }
        String str = this.f2511f;
        if (str == null ? gkVar.f2511f != null : !str.equals(gkVar.f2511f)) {
            return false;
        }
        String str2 = this.f2509d;
        if (str2 == null ? gkVar.f2509d != null : !str2.equals(gkVar.f2509d)) {
            return false;
        }
        String str3 = this.f2510e;
        if (str3 == null ? gkVar.f2510e != null : !str3.equals(gkVar.f2510e)) {
            return false;
        }
        String str4 = this.f2508c;
        if (str4 == null ? gkVar.f2508c == null : str4.equals(gkVar.f2508c)) {
            return this.f2506b == gkVar.f2506b;
        }
        return false;
    }

    /* renamed from: f */
    public String mo17715f() {
        return this.f2516k;
    }

    /* renamed from: f */
    public void mo17716f(String str) {
        this.f2506b = str;
    }

    /* renamed from: g */
    public String mo17717g() {
        return this.f2517l;
    }

    /* renamed from: g */
    public void mo17718g(String str) {
        this.f2510e = str;
    }

    /* renamed from: h */
    public String mo17719h() {
        return this.f2509d;
    }

    /* renamed from: h */
    public void mo17720h(String str) {
        this.f2511f = str;
    }

    public int hashCode() {
        String str = this.f2506b;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f2511f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2508c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f2509d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f2510e;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    /* renamed from: i */
    public void mo17722i(String str) {
        this.f2508c = str;
    }

    /* renamed from: j */
    public void mo17723j(String str) {
        this.f2509d = str;
    }
}
