package com.meizu.cloud.pushsdk.b.b;

public enum a {
    Single(1),
    DefaultGroup(10),
    HeavyGroup(25);
    
    private int d;

    private a(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }
}
