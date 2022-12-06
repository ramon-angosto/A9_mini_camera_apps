package com.xiaomi.xmpush.thrift;

public enum c {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    
    private final int c;

    private c(int i) {
        this.c = i;
    }

    public static c a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    public int a() {
        return this.c;
    }
}
