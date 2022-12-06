package com.ironsource.mediationsdk.model;

public final class k {
    public boolean a;
    public boolean b;
    public boolean c;
    public l d;
    public int e;
    public int f;

    public static class a {
        public boolean a = true;
        private boolean b = false;
        private boolean c = false;
        private l d = null;
        private int e = 0;
        private int f = 0;

        public final a a(boolean z, int i) {
            this.c = z;
            this.f = i;
            return this;
        }

        public final a a(boolean z, l lVar, int i) {
            this.b = z;
            if (lVar == null) {
                lVar = l.PER_DAY;
            }
            this.d = lVar;
            this.e = i;
            return this;
        }

        public final k a() {
            return new k(this.a, this.b, this.c, this.d, this.e, this.f, (byte) 0);
        }
    }

    private k(boolean z, boolean z2, boolean z3, l lVar, int i, int i2) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = lVar;
        this.e = i;
        this.f = i2;
    }

    /* synthetic */ k(boolean z, boolean z2, boolean z3, l lVar, int i, int i2, byte b2) {
        this(z, z2, z3, lVar, i, i2);
    }
}
