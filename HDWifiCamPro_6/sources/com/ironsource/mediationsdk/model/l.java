package com.ironsource.mediationsdk.model;

public enum l {
    PER_DAY("d"),
    PER_HOUR("h");
    
    public String c;

    private l(String str) {
        this.c = str;
    }

    public final String toString() {
        return this.c;
    }
}
