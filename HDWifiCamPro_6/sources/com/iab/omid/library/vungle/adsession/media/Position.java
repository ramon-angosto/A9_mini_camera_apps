package com.iab.omid.library.vungle.adsession.media;

import com.vungle.warren.model.Advertisement;

public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL(Advertisement.KEY_POSTROLL),
    STANDALONE("standalone");
    
    private final String position;

    private Position(String str) {
        this.position = str;
    }

    public String toString() {
        return this.position;
    }
}
