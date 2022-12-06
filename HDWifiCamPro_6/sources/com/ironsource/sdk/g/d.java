package com.ironsource.sdk.g;

public class d {
    private boolean a;
    private boolean b;
    private boolean c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int[] l;

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }

        public static int[] a() {
            return (int[]) d.clone();
        }
    }

    public enum b {
        None,
        Loaded,
        Ready,
        Failed
    }

    public enum c {
        Web,
        Native
    }

    /* renamed from: com.ironsource.sdk.g.d$d  reason: collision with other inner class name */
    public enum C0096d {
        MODE_0(0),
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);
        
        public int d;

        private C0096d(int i) {
            this.d = i;
        }
    }

    public enum e {
        Banner,
        OfferWall,
        Interstitial,
        OfferWallCredits,
        RewardedVideo,
        None
    }

    public d() {
    }

    public d(boolean z, boolean z2, boolean z3, String str, String str2, int i2, int i3, int i4, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = str;
        this.e = str2;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = iArr;
        this.j = iArr2;
        this.k = iArr3;
        this.l = iArr4;
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public int[] i() {
        return this.i;
    }

    public int[] j() {
        return this.j;
    }

    public int[] k() {
        return this.k;
    }

    public int[] l() {
        return this.l;
    }
}
