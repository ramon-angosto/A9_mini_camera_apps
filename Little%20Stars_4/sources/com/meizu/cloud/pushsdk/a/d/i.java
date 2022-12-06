package com.meizu.cloud.pushsdk.a.d;

import com.meizu.cloud.pushsdk.a.d.c;

public class i {
    private final f a;
    private final String b;
    private final c c;
    private final j d;
    private final Object e;

    private i(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public f a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        if ("GET".equals(b())) {
            return 0;
        }
        if ("POST".equals(b())) {
            return 1;
        }
        if ("PUT".equals(b())) {
            return 2;
        }
        if ("DELETE".equals(b())) {
            return 3;
        }
        if ("HEAD".equals(b())) {
            return 4;
        }
        if ("PATCH".equals(b())) {
            return 5;
        }
        return 0;
    }

    public c d() {
        return this.c;
    }

    public String a(String str) {
        return this.c.a(str);
    }

    public j e() {
        return this.d;
    }

    public boolean f() {
        return this.a.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class a {
        /* access modifiers changed from: private */
        public f a;
        /* access modifiers changed from: private */
        public String b = "GET";
        /* access modifiers changed from: private */
        public c.a c = new c.a();
        /* access modifiers changed from: private */
        public j d;
        /* access modifiers changed from: private */
        public Object e;

        public a a(f fVar) {
            if (fVar != null) {
                this.a = fVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                f c2 = f.c(str);
                if (c2 != null) {
                    return a(c2);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a a(c cVar) {
            this.c = cVar.c();
            return this;
        }

        public a a() {
            return a("GET", (j) null);
        }

        public a b() {
            return a("HEAD", (j) null);
        }

        public a a(j jVar) {
            return a("POST", jVar);
        }

        public a b(j jVar) {
            return a("DELETE", jVar);
        }

        public a c(j jVar) {
            return a("PUT", jVar);
        }

        public a d(j jVar) {
            return a("PATCH", jVar);
        }

        public a a(String str, j jVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (jVar != null && !d.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (jVar != null || !d.a(str)) {
                this.b = str;
                this.d = jVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public i c() {
            if (this.a != null) {
                return new i(this);
            }
            throw new IllegalStateException("url == null");
        }
    }
}
