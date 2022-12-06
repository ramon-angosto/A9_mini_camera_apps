package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;
    public final Track track;

    public TrackSampleTable(Track track2, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        boolean z = true;
        Assertions.checkArgument(iArr.length == jArr2.length);
        Assertions.checkArgument(jArr.length == jArr2.length);
        Assertions.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.track = track2;
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i;
        this.timestampsUs = jArr2;
        this.flags = iArr2;
        this.durationUs = j;
        this.sampleCount = jArr.length;
    }

    public final int getIndexOfEarlierOrEqualSynchronizationSample(long j) {
        for (int binarySearchFloor = Util.binarySearchFloor(this.timestampsUs, j, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
            if ((this.flags[binarySearchFloor] & 1) != 0) {
                return binarySearchFloor;
            }
        }
        return -1;
    }

    public final int getIndexOfLaterOrEqualSynchronizationSample(long j) {
        for (int binarySearchCeil = Util.binarySearchCeil(this.timestampsUs, j, true, false); binarySearchCeil < this.timestampsUs.length; binarySearchCeil++) {
            if ((this.flags[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
