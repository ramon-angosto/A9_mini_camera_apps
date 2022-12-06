package com.xiaomi.push.protobuf;

import com.google.protobuf.micro.d;

public final class b {

    public static final class a extends d {
        private boolean a;
        private boolean b = false;
        private boolean c;
        private int d = 0;
        private boolean e;
        private int f = 0;
        private boolean g;
        private int h = 0;
        private int i = -1;

        public static a b(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public int a() {
            int i2 = 0;
            if (d()) {
                i2 = 0 + com.google.protobuf.micro.b.b(1, c());
            }
            if (f()) {
                i2 += com.google.protobuf.micro.b.c(3, e());
            }
            if (h()) {
                i2 += com.google.protobuf.micro.b.c(4, g());
            }
            if (j()) {
                i2 += com.google.protobuf.micro.b.c(5, i());
            }
            this.i = i2;
            return i2;
        }

        public a a(int i2) {
            this.c = true;
            this.d = i2;
            return this;
        }

        public a a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        public void a(com.google.protobuf.micro.b bVar) {
            if (d()) {
                bVar.a(1, c());
            }
            if (f()) {
                bVar.a(3, e());
            }
            if (h()) {
                bVar.a(4, g());
            }
            if (j()) {
                bVar.a(5, i());
            }
        }

        public a b(int i2) {
            this.e = true;
            this.f = i2;
            return this;
        }

        /* renamed from: b */
        public a a(com.google.protobuf.micro.a aVar) {
            while (true) {
                int a2 = aVar.a();
                if (a2 == 0) {
                    return this;
                }
                if (a2 == 8) {
                    a(aVar.d());
                } else if (a2 == 24) {
                    a(aVar.c());
                } else if (a2 == 32) {
                    b(aVar.c());
                } else if (a2 == 40) {
                    c(aVar.c());
                } else if (!a(aVar, a2)) {
                    return this;
                }
            }
        }

        public a c(int i2) {
            this.g = true;
            this.h = i2;
            return this;
        }

        public boolean c() {
            return this.b;
        }

        public boolean d() {
            return this.a;
        }

        public int e() {
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

        public int i() {
            return this.h;
        }

        public boolean j() {
            return this.g;
        }
    }
}
