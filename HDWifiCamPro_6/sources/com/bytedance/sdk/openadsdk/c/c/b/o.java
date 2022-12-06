package com.bytedance.sdk.openadsdk.c.c.b;

import com.bykv.vk.openvk.component.video.api.c.c;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: VideoLogHelperModel */
public class o {
    private long a;
    private String b;
    private int c;
    private c d;
    private n e;

    public o(long j, String str, int i, c cVar, n nVar) {
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = cVar;
        this.e = nVar;
    }

    public long a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public c d() {
        return this.d;
    }

    public n e() {
        return this.e;
    }

    /* compiled from: VideoLogHelperModel */
    public static class a {
        private long a = 0;
        private long b = 0;
        private long c = 0;
        private boolean d = false;
        private int e = 0;
        private int f = 0;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l = false;

        public long a() {
            return this.a;
        }

        public void a(long j2) {
            this.a = j2;
        }

        public long b() {
            return this.b;
        }

        public void b(long j2) {
            this.b = j2;
        }

        public long c() {
            return this.c;
        }

        public void c(long j2) {
            this.c = j2;
        }

        public int d() {
            return this.e;
        }

        public void a(int i2) {
            this.e = i2;
        }

        public int e() {
            return this.f;
        }

        public void b(int i2) {
            this.f = i2;
        }

        public int f() {
            return this.g;
        }

        public void c(int i2) {
            this.g = i2;
        }

        public int g() {
            return this.h;
        }

        public void d(int i2) {
            this.h = i2;
        }

        public int h() {
            long j2 = this.c;
            if (j2 <= 0) {
                return 0;
            }
            return Math.min((int) ((this.a * 100) / j2), 100);
        }

        public int i() {
            return this.i;
        }

        public void e(int i2) {
            this.i = i2;
        }

        public int j() {
            return this.j;
        }

        public int k() {
            return this.k;
        }

        public void f(int i2) {
            this.k = i2;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.d;
        }

        public void a(boolean z) {
            this.d = z;
        }
    }
}
