package com.mbridge.msdk.playercommon.exoplayer2.metadata;

public class MetadataDecoderException extends Exception {
    public MetadataDecoderException(String str) {
        super(str);
    }

    public MetadataDecoderException(String str, Throwable th) {
        super(str, th);
    }
}
