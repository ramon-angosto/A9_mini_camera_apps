package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

interface EbmlReader {
    void init(EbmlReaderOutput ebmlReaderOutput);

    boolean read(ExtractorInput extractorInput) throws IOException, InterruptedException;

    void reset();
}
