package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j, long j2, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j2;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j == -1) {
            this.dataSize = -1;
            this.durationUs = C.TIME_UNSET;
            return;
        }
        this.dataSize = j - j2;
        this.durationUs = getTimeUs(j);
    }

    public final boolean isSeekable() {
        return this.dataSize != -1;
    }

    public final SeekMap.SeekPoints getSeekPoints(long j) {
        long j2 = this.dataSize;
        if (j2 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.firstFramePosition));
        }
        int i = this.frameSize;
        long constrainValue = Util.constrainValue((((((long) this.bitrate) * j) / 8000000) / ((long) i)) * ((long) i), 0, j2 - ((long) i));
        long j3 = this.firstFramePosition + constrainValue;
        long timeUs = getTimeUs(j3);
        SeekPoint seekPoint = new SeekPoint(timeUs, j3);
        if (timeUs < j) {
            long j4 = this.dataSize;
            int i2 = this.frameSize;
            if (constrainValue != j4 - ((long) i2)) {
                long j5 = j3 + ((long) i2);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j5), j5));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public final long getTimeUs(long j) {
        return ((Math.max(0, j - this.firstFramePosition) * 1000000) * 8) / ((long) this.bitrate);
    }

    public final long getDurationUs() {
        return this.durationUs;
    }
}
