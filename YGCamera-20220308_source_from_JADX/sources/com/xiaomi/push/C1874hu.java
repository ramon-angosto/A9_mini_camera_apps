package com.xiaomi.push;

/* renamed from: com.xiaomi.push.hu */
public enum C1874hu {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a */
    private final int f2878a;

    private C1874hu(int i) {
        this.f2878a = i;
    }

    /* renamed from: a */
    public static C1874hu m3947a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    /* renamed from: a */
    public int mo17807a() {
        return this.f2878a;
    }
}
