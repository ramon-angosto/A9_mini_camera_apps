package com.mbridge.msdk.playercommon.exoplayer2.extractor;

public interface ExtractorOutput {
    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i, int i2);
}
