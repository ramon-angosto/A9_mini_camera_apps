package com.iab.omid.library.bigosg.b;

public enum h {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    
    private final String i;

    private h(String str) {
        this.i = str;
    }

    public final String toString() {
        return this.i;
    }
}
