package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.media.AudioAttributes;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class AudioAttributes {
    public static final AudioAttributes DEFAULT = new Builder().build();
    private android.media.AudioAttributes audioAttributesV21;
    public final int contentType;
    public final int flags;
    public final int usage;

    public static final class Builder {
        private int contentType = 0;
        private int flags = 0;
        private int usage = 1;

        public final Builder setContentType(int i) {
            this.contentType = i;
            return this;
        }

        public final Builder setFlags(int i) {
            this.flags = i;
            return this;
        }

        public final Builder setUsage(int i) {
            this.usage = i;
            return this;
        }

        public final AudioAttributes build() {
            return new AudioAttributes(this.contentType, this.flags, this.usage);
        }
    }

    private AudioAttributes(int i, int i2, int i3) {
        this.contentType = i;
        this.flags = i2;
        this.usage = i3;
    }

    /* access modifiers changed from: package-private */
    public final android.media.AudioAttributes getAudioAttributesV21() {
        if (this.audioAttributesV21 == null) {
            this.audioAttributesV21 = new AudioAttributes.Builder().setContentType(this.contentType).setFlags(this.flags).setUsage(this.usage).build();
        }
        return this.audioAttributesV21;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        if (this.contentType == audioAttributes.contentType && this.flags == audioAttributes.flags && this.usage == audioAttributes.usage) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.contentType) * 31) + this.flags) * 31) + this.usage;
    }
}
