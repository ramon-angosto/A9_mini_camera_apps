package com.iab.omid.library.adcolony.adsession;

public enum AdSessionContextType {
    HTML("html"),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    
    private final String typeString;

    private AdSessionContextType(String str) {
        this.typeString = str;
    }

    public String toString() {
        return this.typeString;
    }
}
