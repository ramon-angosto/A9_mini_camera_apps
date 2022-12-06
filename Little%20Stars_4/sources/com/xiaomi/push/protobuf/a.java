package com.xiaomi.push.protobuf;

import com.google.protobuf.micro.b;
import com.google.protobuf.micro.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a {

    /* renamed from: com.xiaomi.push.protobuf.a$a  reason: collision with other inner class name */
    public static final class C0052a extends d {
        private boolean a;
        private int b = 0;
        private boolean c;
        private boolean d = false;
        private boolean e;
        private int f = 0;
        private boolean g;
        private boolean h = false;
        private List<String> i = Collections.emptyList();
        private int j = -1;

        public static C0052a b(byte[] bArr) {
            return (C0052a) new C0052a().a(bArr);
        }

        public static C0052a c(com.google.protobuf.micro.a aVar) {
            return new C0052a().a(aVar);
        }

        public int a() {
            int i2 = 0;
            int d2 = d() ? b.d(1, c()) + 0 : 0;
            if (f()) {
                d2 += b.b(2, e());
            }
            if (h()) {
                d2 += b.c(3, g());
            }
            if (j()) {
                d2 += b.b(4, i());
            }
            for (String b2 : k()) {
                i2 += b.b(b2);
            }
            int size = d2 + i2 + (k().size() * 1);
            this.j = size;
            return size;
        }

        public C0052a a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        public C0052a a(String str) {
            if (str != null) {
                if (this.i.isEmpty()) {
                    this.i = new ArrayList();
                }
                this.i.add(str);
                return this;
            }
            throw new NullPointerException();
        }

        public C0052a a(boolean z) {
            this.c = true;
            this.d = z;
            return this;
        }

        public void a(b bVar) {
            if (d()) {
                bVar.b(1, c());
            }
            if (f()) {
                bVar.a(2, e());
            }
            if (h()) {
                bVar.a(3, g());
            }
            if (j()) {
                bVar.a(4, i());
            }
            for (String a2 : k()) {
                bVar.a(5, a2);
            }
        }

        public C0052a b(int i2) {
            this.e = true;
            this.f = i2;
            return this;
        }

        /* renamed from: b */
        public C0052a a(com.google.protobuf.micro.a aVar) {
            while (true) {
                int a2 = aVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(aVar.f());
                } else if (a2 == 16) {
                    a(aVar.d());
                } else if (a2 == 24) {
                    b(aVar.c());
                } else if (a2 == 32) {
                    b(aVar.d());
                } else if (a2 == 42) {
                    a(aVar.e());
                } else if (!a(aVar, a2)) {
                    return this;
                }
            }
        }

        public C0052a b(boolean z) {
            this.g = true;
            this.h = z;
            return this;
        }

        public int c() {
            return this.b;
        }

        public boolean d() {
            return this.a;
        }

        public boolean e() {
            return this.d;
        }

        public boolean f() {
            return this.c;
        }

        public int g() {
            return this.f;
        }

        public boolean h() {
            return this.e;
        }

        public boolean i() {
            return this.h;
        }

        public boolean j() {
            return this.g;
        }

        public List<String> k() {
            return this.i;
        }

        public int l() {
            return this.i.size();
        }
    }
}
