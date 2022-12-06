package com.iab.omid.library.bigosg.b;

public enum i {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String d;

    private i(String str) {
        this.d = str;
    }

    public final String toString() {
        return this.d;
    }
}
