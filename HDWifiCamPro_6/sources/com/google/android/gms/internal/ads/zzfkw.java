package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public enum zzfkw {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    
    private final String zzg;

    private zzfkw(String str) {
        this.zzg = str;
    }

    public final String toString() {
        return this.zzg;
    }
}
