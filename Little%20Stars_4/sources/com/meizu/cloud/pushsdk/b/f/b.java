package com.meizu.cloud.pushsdk.b.f;

public enum b {
    OFF(0),
    ERROR(1),
    DEBUG(2),
    VERBOSE(3);
    
    private int e;

    private b(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }
}
