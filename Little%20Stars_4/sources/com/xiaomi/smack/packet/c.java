package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smack.util.g;

public class c extends d {
    private String c = null;
    private String d = null;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i = false;
    private String j;
    private String k = "";
    private String l = "";
    private String m = "";
    private String n = "";
    private boolean o = false;

    public c() {
    }

    public c(Bundle bundle) {
        super(bundle);
        this.c = bundle.getString("ext_msg_type");
        this.e = bundle.getString("ext_msg_lang");
        this.d = bundle.getString("ext_msg_thread");
        this.f = bundle.getString("ext_msg_sub");
        this.g = bundle.getString("ext_msg_body");
        this.h = bundle.getString("ext_body_encode");
        this.j = bundle.getString("ext_msg_appid");
        this.i = bundle.getBoolean("ext_msg_trans", false);
        this.o = bundle.getBoolean("ext_msg_encrypt", false);
        this.k = bundle.getString("ext_msg_seq");
        this.l = bundle.getString("ext_msg_mseq");
        this.m = bundle.getString("ext_msg_fseq");
        this.n = bundle.getString("ext_msg_status");
    }

    public String a() {
        h p;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (t() != null) {
            sb.append(" xmlns=\"");
            sb.append(t());
            sb.append("\"");
        }
        if (this.e != null) {
            sb.append(" xml:lang=\"");
            sb.append(i());
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" id=\"");
            sb.append(k());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" to=\"");
            sb.append(g.a(m()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" seq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" mseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" fseq=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(h())) {
            sb.append(" status=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (n() != null) {
            sb.append(" from=\"");
            sb.append(g.a(n()));
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" chid=\"");
            sb.append(g.a(l()));
            sb.append("\"");
        }
        if (this.i) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.j)) {
            sb.append(" appid=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(" type=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        if (this.o) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.f != null) {
            sb.append("<subject>");
            sb.append(g.a(this.f));
            sb.append("</subject>");
        }
        if (this.g != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.h)) {
                sb.append(" encode=\"");
                sb.append(this.h);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(g.a(this.g));
            sb.append("</body>");
        }
        if (this.d != null) {
            sb.append("<thread>");
            sb.append(this.d);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.c) && (p = p()) != null) {
            sb.append(p.d());
        }
        sb.append(s());
        sb.append("</message>");
        return sb.toString();
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(String str, String str2) {
        this.g = str;
        this.h = str2;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.k = str;
    }

    public void b(boolean z) {
        this.o = z;
    }

    public Bundle c() {
        Bundle c2 = super.c();
        if (!TextUtils.isEmpty(this.c)) {
            c2.putString("ext_msg_type", this.c);
        }
        String str = this.e;
        if (str != null) {
            c2.putString("ext_msg_lang", str);
        }
        String str2 = this.f;
        if (str2 != null) {
            c2.putString("ext_msg_sub", str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            c2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.h)) {
            c2.putString("ext_body_encode", this.h);
        }
        String str4 = this.d;
        if (str4 != null) {
            c2.putString("ext_msg_thread", str4);
        }
        String str5 = this.j;
        if (str5 != null) {
            c2.putString("ext_msg_appid", str5);
        }
        if (this.i) {
            c2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.k)) {
            c2.putString("ext_msg_seq", this.k);
        }
        if (!TextUtils.isEmpty(this.l)) {
            c2.putString("ext_msg_mseq", this.l);
        }
        if (!TextUtils.isEmpty(this.m)) {
            c2.putString("ext_msg_fseq", this.m);
        }
        if (this.o) {
            c2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.n)) {
            c2.putString("ext_msg_status", this.n);
        }
        return c2;
    }

    public void c(String str) {
        this.l = str;
    }

    public String d() {
        return this.j;
    }

    public void d(String str) {
        this.m = str;
    }

    public String e() {
        return this.k;
    }

    public void e(String str) {
        this.n = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!super.equals(cVar)) {
            return false;
        }
        String str = this.g;
        if (str == null ? cVar.g != null : !str.equals(cVar.g)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? cVar.e != null : !str2.equals(cVar.e)) {
            return false;
        }
        String str3 = this.f;
        if (str3 == null ? cVar.f != null : !str3.equals(cVar.f)) {
            return false;
        }
        String str4 = this.d;
        if (str4 == null ? cVar.d == null : str4.equals(cVar.d)) {
            return this.c == cVar.c;
        }
        return false;
    }

    public String f() {
        return this.l;
    }

    public void f(String str) {
        this.c = str;
    }

    public String g() {
        return this.m;
    }

    public void g(String str) {
        this.f = str;
    }

    public String h() {
        return this.n;
    }

    public void h(String str) {
        this.g = str;
    }

    public int hashCode() {
        String str = this.c;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public String i() {
        return this.e;
    }

    public void i(String str) {
        this.d = str;
    }

    public void j(String str) {
        this.e = str;
    }
}
