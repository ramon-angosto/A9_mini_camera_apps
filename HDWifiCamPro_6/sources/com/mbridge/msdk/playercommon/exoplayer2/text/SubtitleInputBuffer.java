package com.mbridge.msdk.playercommon.exoplayer2.text;

import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;

public class SubtitleInputBuffer extends DecoderInputBuffer {
    public long subsampleOffsetUs;

    public SubtitleInputBuffer() {
        super(1);
    }
}
