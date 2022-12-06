package com.xiaomi.xmpush.thrift;

public enum j {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    
    private final int d;

    private j(int i) {
        this.d = i;
    }

    public static j a(int i) {
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

    public int a() {
        return this.d;
    }
}
