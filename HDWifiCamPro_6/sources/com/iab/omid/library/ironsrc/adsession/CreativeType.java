package com.iab.omid.library.ironsrc.adsession;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public enum CreativeType {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    
    private final String creativeType;

    private CreativeType(String str) {
        this.creativeType = str;
    }

    public final String toString() {
        return this.creativeType;
    }
}
