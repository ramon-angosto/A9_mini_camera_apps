package com.adcolony.sdk;

class e0 {
    static e0 c = new e0(3, true);
    static e0 d = new e0(2, false);
    static e0 e = new e0(2, true);
    static e0 f = new e0(1, false);
    static e0 g = new e0(1, true);
    static e0 h = new e0(0, false);
    static e0 i = new e0(0, true);
    private final int a;
    private final boolean b;

    static class a {
        StringBuilder a = new StringBuilder();

        a() {
        }

        /* access modifiers changed from: package-private */
        public a a(String str) {
            this.a.append(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(Object obj) {
            if (obj != null) {
                this.a.append(obj.toString());
            } else {
                this.a.append("null");
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(int i) {
            this.a.append(i);
            return this;
        }

        /* access modifiers changed from: package-private */
        public void a(e0 e0Var) {
            e0Var.a(this.a.toString());
        }
    }

    static {
        new e0(3, false);
    }

    e0(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        a.b().q().a(this.a, str, this.b);
    }
}
