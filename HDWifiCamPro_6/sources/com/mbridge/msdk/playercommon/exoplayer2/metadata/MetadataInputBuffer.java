package com.mbridge.msdk.playercommon.exoplayer2.metadata;

import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;

public final class MetadataInputBuffer extends DecoderInputBuffer {
    public long subsampleOffsetUs;

    public MetadataInputBuffer() {
        super(1);
    }
}
