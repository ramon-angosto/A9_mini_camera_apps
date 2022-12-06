package com.iab.omid.library.bigosg.b;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public enum f {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    
    private final String f;

    private f(String str) {
        this.f = str;
    }

    public final String toString() {
        return this.f;
    }
}
