package com.xiaomi.channel.commonutils.misc;

public class a {
    public static final boolean a = true;
    public static final boolean b = (a);
    public static final boolean c = false;
    public static final boolean d = false;
    public static boolean e = false;
    public static final boolean f = false;
    public static final boolean g = false;
    private static int h;

    static {
        h = 1;
        h = 1;
    }

    public static void a(int i) {
        h = i;
    }

    public static boolean a() {
        return h == 2;
    }

    public static boolean b() {
        return h == 3;
    }

    public static int c() {
        return h;
    }
}
