package com.xiaomi.channel.commonutils.network;

public class a implements c {
    private final String a;
    private final String b;

    public a(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
