package com.mbridge.msdk.playercommon.exoplayer2;

public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT = new RendererConfiguration(0);
    public final int tunnelingAudioSessionId;

    public RendererConfiguration(int i) {
        this.tunnelingAudioSessionId = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.tunnelingAudioSessionId == ((RendererConfiguration) obj).tunnelingAudioSessionId) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.tunnelingAudioSessionId;
    }
}
