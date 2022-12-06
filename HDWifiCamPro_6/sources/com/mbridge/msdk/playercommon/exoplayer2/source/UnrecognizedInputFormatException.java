package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;

public class UnrecognizedInputFormatException extends ParserException {
    public final Uri uri;

    public UnrecognizedInputFormatException(String str, Uri uri2) {
        super(str);
        this.uri = uri2;
    }
}
