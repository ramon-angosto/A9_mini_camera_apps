package sg.bigo.ads.common.utils;

public final class r {
    private static boolean a = false;
    private static boolean b = true;

    public static void a(String str) {
        if (a) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a() {
        return false;
    }

    public static boolean b() {
        return a;
    }
}
