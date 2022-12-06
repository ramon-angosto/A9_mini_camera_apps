package com.iab.omid.library.adcolony.adsession;

public enum Owner {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE("none");
    
    private final String owner;

    private Owner(String str) {
        this.owner = str;
    }

    public String toString() {
        return this.owner;
    }
}
