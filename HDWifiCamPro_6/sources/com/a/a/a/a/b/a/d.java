package com.a.a.a.a.b.a;

import com.vungle.warren.model.Advertisement;

public enum d {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(Advertisement.KEY_POSTROLL),
    STANDALONE("standalone");
    
    private final String e;

    private d(String str) {
        this.e = str;
    }

    public String toString() {
        return this.e;
    }
}
