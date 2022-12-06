package com.adcolony.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

class n0 {
    private final int a;
    private final List<a> b = new ArrayList();

    static class a {
        private final String a;
        private final String b;
        private final int c;
        /* access modifiers changed from: private */
        public final String[] d;
        /* access modifiers changed from: private */
        public final String[] e;
        private final List<b> f = new ArrayList();
        private final List<c> g = new ArrayList();
        private final d h;
        private final Map<String, String> i;

        a(f1 f1Var) throws JSONException {
            this.a = f1Var.e("stream");
            this.b = f1Var.e("table_name");
            this.c = f1Var.a("max_rows", 10000);
            e1 l = f1Var.l("event_types");
            this.d = l != null ? c0.a(l) : new String[0];
            e1 l2 = f1Var.l("request_types");
            this.e = l2 != null ? c0.a(l2) : new String[0];
            for (f1 bVar : c0.b(f1Var.c("columns"))) {
                this.f.add(new b(bVar));
            }
            for (f1 cVar : c0.b(f1Var.c("indexes"))) {
                this.g.add(new c(cVar, this.b));
            }
            f1 n = f1Var.n("ttl");
            this.h = n != null ? new d(n) : null;
            this.i = f1Var.m("queries").f();
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public String d() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public Map<String, String> e() {
            return this.i;
        }

        /* access modifiers changed from: package-private */
        public String f() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public d g() {
            return this.h;
        }

        /* access modifiers changed from: package-private */
        public List<b> a() {
            return this.f;
        }

        /* access modifiers changed from: package-private */
        public List<c> b() {
            return this.g;
        }
    }

    static class b {
        private final String a;
        private final String b;
        private final Object c;

        b(f1 f1Var) throws JSONException {
            this.a = f1Var.e("name");
            this.b = f1Var.e("type");
            this.c = f1Var.o("default");
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public String c() {
            return this.b;
        }
    }

    static class c {
        private final String a;
        private final String[] b;

        c(f1 f1Var, String str) throws JSONException {
            this.a = str + "_" + f1Var.e("name");
            this.b = c0.a(f1Var.c("columns"));
        }

        /* access modifiers changed from: package-private */
        public String[] a() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.a;
        }
    }

    static class d {
        private final long a;
        private final String b;

        d(f1 f1Var) throws JSONException {
            this.a = f1Var.d("seconds");
            this.b = f1Var.e("column");
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public long b() {
            return this.a;
        }
    }

    n0(f1 f1Var) throws JSONException {
        this.a = f1Var.b("version");
        for (f1 aVar : c0.b(f1Var.c("streams"))) {
            this.b.add(new a(aVar));
        }
    }

    static n0 a(f1 f1Var) {
        try {
            return new n0(f1Var);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public List<a> a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public a a(String str) {
        if (str.isEmpty()) {
            return null;
        }
        for (a next : this.b) {
            int i = 0;
            for (String equals : next.d) {
                if (str.equals(equals)) {
                    return next;
                }
            }
            String[] b2 = next.e;
            int length = b2.length;
            while (true) {
                if (i < length) {
                    if (str.equals(b2[i])) {
                        return next;
                    }
                    i++;
                }
            }
        }
        return null;
    }
}
