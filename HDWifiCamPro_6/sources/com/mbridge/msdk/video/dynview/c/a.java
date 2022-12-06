package com.mbridge.msdk.video.dynview.c;

/* compiled from: CusError */
public enum a {
    NOT_FOUND_VIEWOPTION(-1, "ViewOption is null"),
    NOT_FOUND_CONTEXT(-2, "Context is null"),
    NOT_FOUND_LAYOUTNAME(-3, "layout xml name is null"),
    CAMPAIGNEX_IS_NULL(-4, "Campaign size only one");
    
    private int e;
    private String f;

    private a(int i, String str) {
        this.e = i;
        this.f = str;
    }

    public final int a() {
        return this.e;
    }

    public final String b() {
        return this.f;
    }
}
