package com.mbridge.msdk.playercommon.exoplayer2.source;

public interface CompositeSequenceableLoaderFactory {
    SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader... sequenceableLoaderArr);
}
