package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

public final class EmptySampleStream implements SampleStream {
    public final boolean isReady() {
        return true;
    }

    public final void maybeThrowError() throws IOException {
    }

    public final int skipData(long j) {
        return 0;
    }

    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
