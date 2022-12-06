package com.mbridge.msdk.playercommon.exoplayer2.metadata;

public interface MetadataDecoder {
    Metadata decode(MetadataInputBuffer metadataInputBuffer) throws MetadataDecoderException;
}
