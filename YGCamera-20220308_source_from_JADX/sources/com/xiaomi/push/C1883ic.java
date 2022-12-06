package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ic */
public enum C1883ic {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a */
    private final int f3047a;

    private C1883ic(int i) {
        this.f3047a = i;
    }

    /* renamed from: a */
    public static C1883ic m4077a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }

    /* renamed from: a */
    public int mo17910a() {
        return this.f3047a;
    }
}
