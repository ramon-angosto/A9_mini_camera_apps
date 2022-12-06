package com.ironsource.sdk.g;

public final class a extends f {
    private static String e = "type";
    private static String f = "numOfAdUnits";
    private static String g = "firstCampaignCredits";
    private static String h = "totalNumberCredits";
    private static String i = "productType";
    public String a;
    public String b;
    public boolean c;
    private String j;
    private String k;
    private String l;

    public a(String str) {
        super(str);
        boolean z;
        if (a(e)) {
            this.j = d(e);
        }
        if (a(f)) {
            this.b = d(f);
            z = true;
        } else {
            z = false;
        }
        this.c = z;
        if (a(g)) {
            this.k = d(g);
        }
        if (a(h)) {
            this.l = d(h);
        }
        if (a(i)) {
            this.a = d(i);
        }
    }
}
