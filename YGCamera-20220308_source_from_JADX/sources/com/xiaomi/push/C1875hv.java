package com.xiaomi.push;

/* renamed from: com.xiaomi.push.hv */
public enum C1875hv {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: a */
    private final int f2884a;

    private C1875hv(int i) {
        this.f2884a = i;
    }

    /* renamed from: a */
    public static C1875hv m3949a(int i) {
        if (i == 1) {
            return INT;
        }
        if (i == 2) {
            return LONG;
        }
        if (i == 3) {
            return STRING;
        }
        if (i != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
