package com.iab.omid.library.bigosg.b.a;

import com.vungle.warren.model.Advertisement;

public enum c {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(Advertisement.KEY_POSTROLL),
    STANDALONE("standalone");
    
    private final String e;

    private c(String str) {
        this.e = str;
    }

    public final String toString() {
        return this.e;
    }
}
