package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;

public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = C.TIME_UNSET;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        setFirstSampleTimestampUs(j);
    }

    public final synchronized void setFirstSampleTimestampUs(long j) {
        Assertions.checkState(this.lastSampleTimestampUs == C.TIME_UNSET);
        this.firstSampleTimestampUs = j;
    }

    public final long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public final long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            return this.timestampOffsetUs + this.lastSampleTimestampUs;
        }
        long j = this.firstSampleTimestampUs;
        return j != Long.MAX_VALUE ? j : C.TIME_UNSET;
    }

    public final long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0;
        }
        return this.lastSampleTimestampUs == C.TIME_UNSET ? C.TIME_UNSET : this.timestampOffsetUs;
    }

    public final void reset() {
        this.lastSampleTimestampUs = C.TIME_UNSET;
    }

    public final long adjustTsTimestamp(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            long usToPts = usToPts(this.lastSampleTimestampUs);
            long j2 = (4294967296L + usToPts) / MAX_PTS_PLUS_ONE;
            long j3 = ((j2 - 1) * MAX_PTS_PLUS_ONE) + j;
            j += j2 * MAX_PTS_PLUS_ONE;
            if (Math.abs(j3 - usToPts) < Math.abs(j - usToPts)) {
                j = j3;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public final long adjustSampleTimestamp(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            this.lastSampleTimestampUs = j;
        } else {
            long j2 = this.firstSampleTimestampUs;
            if (j2 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j2 - j;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = j;
                notifyAll();
            }
        }
        return j + this.timestampOffsetUs;
    }

    public final synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestampUs == C.TIME_UNSET) {
            wait();
        }
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToPts(long j) {
        return (j * 90000) / 1000000;
    }
}
