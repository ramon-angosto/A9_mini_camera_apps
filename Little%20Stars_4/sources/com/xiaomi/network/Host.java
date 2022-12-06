package com.xiaomi.network;

import java.net.InetSocketAddress;

public final class Host {
    private String a;
    private int b;

    public Host(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static Host a(String str, int i) {
        String str2;
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
        } else {
            str2 = str;
        }
        return new Host(str2, i);
    }

    public static InetSocketAddress b(String str, int i) {
        Host a2 = a(str, i);
        return new InetSocketAddress(a2.b(), a2.a());
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        if (this.b <= 0) {
            return this.a;
        }
        return this.a + ":" + this.b;
    }
}
