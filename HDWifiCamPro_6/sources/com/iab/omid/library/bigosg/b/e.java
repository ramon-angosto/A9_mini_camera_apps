package com.iab.omid.library.bigosg.b;

public enum e {
    HTML("html"),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    
    private final String d;

    private e(String str) {
        this.d = str;
    }

    public final String toString() {
        return this.d;
    }
}
