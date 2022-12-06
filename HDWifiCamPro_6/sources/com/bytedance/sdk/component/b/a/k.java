package com.bytedance.sdk.component.b.a;

import androidx.browser.trusted.sharing.ShareTarget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Request */
public abstract class k {
    public i a;

    public abstract Object a();

    public abstract f b();

    public abstract String c();

    public abstract Map<String, List<String>> d();

    public abstract a e();

    public l f() {
        return null;
    }

    public void a(i iVar) {
        this.a = iVar;
    }

    public a g() {
        return new a(this);
    }

    /* compiled from: Request */
    public static class a {
        a a;
        Map<String, List<String>> b;
        f c;
        String d;
        Object e;
        l f;

        public a() {
            this.b = new HashMap();
        }

        public a a(a aVar) {
            this.a = aVar;
            return this;
        }

        a(k kVar) {
            this.c = kVar.b();
            this.d = kVar.c();
            this.b = kVar.d();
            this.e = kVar.a();
            this.f = kVar.f();
            this.a = kVar.e();
        }

        public a a(Object obj) {
            this.e = obj;
            return this;
        }

        public a a(String str) {
            return a(f.c(str));
        }

        public a a(f fVar) {
            this.c = fVar;
            return this;
        }

        public a a(String str, String str2) {
            return b(str, str2);
        }

        public a b(String str, String str2) {
            if (!this.b.containsKey(str)) {
                this.b.put(str, new ArrayList());
            }
            this.b.get(str).add(str2);
            return this;
        }

        public a a() {
            return a(ShareTarget.METHOD_GET, (l) null);
        }

        private a a(String str, l lVar) {
            this.d = str;
            this.f = lVar;
            return this;
        }

        public a a(l lVar) {
            return a(ShareTarget.METHOD_POST, lVar);
        }

        public k b() {
            return new k() {
                public String toString() {
                    return "";
                }

                public Object a() {
                    return a.this.e;
                }

                public f b() {
                    return a.this.c;
                }

                public String c() {
                    return a.this.d;
                }

                public Map d() {
                    return a.this.b;
                }

                public a e() {
                    return a.this.a;
                }

                public l f() {
                    return a.this.f;
                }
            };
        }
    }
}
