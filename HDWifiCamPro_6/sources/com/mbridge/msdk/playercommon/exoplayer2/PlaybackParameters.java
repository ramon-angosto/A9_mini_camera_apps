package com.mbridge.msdk.playercommon.exoplayer2;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    public PlaybackParameters(float f) {
        this(f, 1.0f, false);
    }

    public PlaybackParameters(float f, float f2) {
        this(f, f2, false);
    }

    public PlaybackParameters(float f, float f2, boolean z) {
        boolean z2 = true;
        Assertions.checkArgument(f > 0.0f);
        Assertions.checkArgument(f2 <= 0.0f ? false : z2);
        this.speed = f;
        this.pitch = f2;
        this.skipSilence = z;
        this.scaledUsPerMs = Math.round(f * 1000.0f);
    }

    public final long getMediaTimeUsForPlayoutTimeMs(long j) {
        return j * ((long) this.scaledUsPerMs);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch && this.skipSilence == playbackParameters.skipSilence) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch)) * 31) + (this.skipSilence ? 1 : 0);
    }
}
