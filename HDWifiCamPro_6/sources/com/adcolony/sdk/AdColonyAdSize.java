package com.adcolony.sdk;

import ms.bd.o.Pgl.c;

public class AdColonyAdSize {
    public static final AdColonyAdSize BANNER = new AdColonyAdSize(320, 50);
    public static final AdColonyAdSize LEADERBOARD = new AdColonyAdSize(728, 90);
    public static final AdColonyAdSize MEDIUM_RECTANGLE = new AdColonyAdSize(c.COLLECT_MODE_FINANCE, 250);
    public static final AdColonyAdSize SKYSCRAPER = new AdColonyAdSize(160, 600);
    int a;
    int b;

    public AdColonyAdSize(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.a;
    }
}
