package com.adcolony.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class f0 {
    static final SimpleDateFormat e = new SimpleDateFormat("yyyyMMdd'T'HHmmss.SSSZ", Locale.US);
    /* access modifiers changed from: private */
    public Date a;
    /* access modifiers changed from: private */
    public int b;
    /* access modifiers changed from: private */
    public b0 c;
    protected String d;

    static class a {
        protected f0 a = new f0();

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(int i) {
            int unused = this.a.b = i;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(b0 b0Var) {
            b0 unused = this.a.c = b0Var;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(String str) {
            this.a.d = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public f0 a() {
            if (this.a.a == null) {
                Date unused = this.a.a = new Date(System.currentTimeMillis());
            }
            return this.a;
        }
    }

    f0() {
    }

    /* access modifiers changed from: package-private */
    public String b() {
        int i = this.b;
        if (i == -1) {
            return "Fatal";
        }
        if (i == 0) {
            return "Error";
        }
        if (i == 1) {
            return "Warn";
        }
        if (i != 2) {
            return i != 3 ? "UNKNOWN LOG LEVEL" : "Debug";
        }
        return "Info";
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return e.format(this.a);
    }

    public String toString() {
        return d() + " " + b() + "/" + a().a() + ": " + c();
    }

    /* access modifiers changed from: package-private */
    public b0 a() {
        return this.c;
    }
}
