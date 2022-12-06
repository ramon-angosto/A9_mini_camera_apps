package com.huawei.android.pushagent.plugin.a;

public enum f {
    LBS("LBS", 1),
    TAG("TAG", 2);
    
    private String c;
    private int d;

    private f(String str, int i) {
        this.c = str;
        this.d = i;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }
}
