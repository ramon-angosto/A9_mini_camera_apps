package sg.bigo.ads.api;

import ms.bd.o.Pgl.c;

public final class AdSize {
    public static final AdSize BANNER = new AdSize(320, 50, "320x50");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100");
    public static final AdSize LARGE_RECTANGLE = new AdSize(336, c.COLLECT_MODE_ML_TEEN, "336x280");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(c.COLLECT_MODE_FINANCE, 250, "300x250");
    private final int a;
    private final int b;
    private final String c;

    private AdSize(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.a;
    }
}
