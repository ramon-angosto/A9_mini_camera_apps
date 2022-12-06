package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.push.ec */
public final class C1745ec {

    /* renamed from: com.xiaomi.push.ec$a */
    public static final class C1746a extends C1742e {

        /* renamed from: a */
        private int f2088a = 0;

        /* renamed from: a */
        private List<String> f2089a = Collections.emptyList();

        /* renamed from: a */
        private boolean f2090a;

        /* renamed from: b */
        private int f2091b = 0;

        /* renamed from: b */
        private boolean f2092b;

        /* renamed from: c */
        private int f2093c = -1;

        /* renamed from: c */
        private boolean f2094c = false;

        /* renamed from: d */
        private boolean f2095d;

        /* renamed from: e */
        private boolean f2096e;

        /* renamed from: f */
        private boolean f2097f = false;

        /* renamed from: a */
        public static C1746a m3088a(byte[] bArr) {
            return (C1746a) new C1746a().m3088a(bArr);
        }

        /* renamed from: b */
        public static C1746a m3089b(C1641b bVar) {
            return new C1746a().mo17408a(bVar);
        }

        /* renamed from: a */
        public int mo17407a() {
            if (this.f2093c < 0) {
                mo17413b();
            }
            return this.f2093c;
        }

        /* renamed from: a */
        public C1746a mo17415a(int i) {
            this.f2090a = true;
            this.f2088a = i;
            return this;
        }

        /* renamed from: a */
        public C1746a m3093a(C1641b bVar) {
            while (true) {
                int a = bVar.mo17241a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    mo17415a(bVar.mo17246c());
                } else if (a == 16) {
                    mo17417a(bVar.mo17241a());
                } else if (a == 24) {
                    mo17418b(bVar.mo17244b());
                } else if (a == 32) {
                    mo17419b(bVar.mo17241a());
                } else if (a == 42) {
                    mo17416a(bVar.mo17241a());
                } else if (!mo17412a(bVar, a)) {
                    return this;
                }
            }
        }

        /* renamed from: a */
        public C1746a mo17416a(String str) {
            if (str != null) {
                if (this.f2089a.isEmpty()) {
                    this.f2089a = new ArrayList();
                }
                this.f2089a.add(str);
                return this;
            }
            throw new NullPointerException();
        }

        /* renamed from: a */
        public C1746a mo17417a(boolean z) {
            this.f2092b = true;
            this.f2094c = z;
            return this;
        }

        /* renamed from: a */
        public List<String> m3096a() {
            return this.f2089a;
        }

        /* renamed from: a */
        public void mo17411a(C1675c cVar) {
            if (mo17407a()) {
                cVar.mo17297b(1, mo17420c());
            }
            if (mo17420c()) {
                cVar.mo17287a(2, mo17413b());
            }
            if (mo17421d()) {
                cVar.mo17282a(3, mo17421d());
            }
            if (mo17423f()) {
                cVar.mo17287a(4, mo17422e());
            }
            for (String a : mo17407a()) {
                cVar.mo17286a(5, a);
            }
        }

        /* renamed from: a */
        public boolean m3098a() {
            return this.f2090a;
        }

        /* renamed from: b */
        public int mo17413b() {
            int i = 0;
            int b = mo17407a() ? C1675c.mo17297b(1, mo17420c()) + 0 : 0;
            if (mo17420c()) {
                b += C1675c.mo17287a(2, mo17413b());
            }
            if (mo17421d()) {
                b += C1675c.mo17282a(3, mo17421d());
            }
            if (mo17423f()) {
                b += C1675c.mo17287a(4, mo17422e());
            }
            for (String a : mo17407a()) {
                i += C1675c.mo17291a(a);
            }
            int size = b + i + (mo17407a().size() * 1);
            this.f2093c = size;
            return size;
        }

        /* renamed from: b */
        public C1746a mo17418b(int i) {
            this.f2095d = true;
            this.f2091b = i;
            return this;
        }

        /* renamed from: b */
        public C1746a mo17419b(boolean z) {
            this.f2096e = true;
            this.f2097f = z;
            return this;
        }

        /* renamed from: b */
        public boolean m3102b() {
            return this.f2094c;
        }

        /* renamed from: c */
        public int mo17420c() {
            return this.f2088a;
        }

        /* renamed from: c */
        public boolean m3104c() {
            return this.f2092b;
        }

        /* renamed from: d */
        public int mo17421d() {
            return this.f2091b;
        }

        /* renamed from: d */
        public boolean m3106d() {
            return this.f2095d;
        }

        /* renamed from: e */
        public int mo17422e() {
            return this.f2089a.size();
        }

        /* renamed from: e */
        public boolean m3108e() {
            return this.f2097f;
        }

        /* renamed from: f */
        public boolean mo17423f() {
            return this.f2096e;
        }
    }
}
