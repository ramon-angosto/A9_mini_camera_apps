package com.mbridge.msdk.playercommon.exoplayer2.decoder;

public abstract class OutputBuffer extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public abstract void release();
}
