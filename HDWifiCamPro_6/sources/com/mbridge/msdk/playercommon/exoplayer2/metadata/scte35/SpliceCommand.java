package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;

public abstract class SpliceCommand implements Metadata.Entry {
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SCTE-35 splice command: type=" + getClass().getSimpleName();
    }
}
