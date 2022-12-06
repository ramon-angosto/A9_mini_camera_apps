package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.MediaClock;
import com.mbridge.msdk.playercommon.exoplayer2.util.StandaloneMediaClock;

final class DefaultMediaClock implements MediaClock {
    private final PlaybackParameterListener listener;
    private MediaClock rendererClock;
    private Renderer rendererClockSource;
    private final StandaloneMediaClock standaloneMediaClock;

    public interface PlaybackParameterListener {
        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);
    }

    public DefaultMediaClock(PlaybackParameterListener playbackParameterListener, Clock clock) {
        this.listener = playbackParameterListener;
        this.standaloneMediaClock = new StandaloneMediaClock(clock);
    }

    public final void start() {
        this.standaloneMediaClock.start();
    }

    public final void stop() {
        this.standaloneMediaClock.stop();
    }

    public final void resetPosition(long j) {
        this.standaloneMediaClock.resetPosition(j);
    }

    public final void onRendererEnabled(Renderer renderer) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaClock mediaClock2 = renderer.getMediaClock();
        if (mediaClock2 != null && mediaClock2 != (mediaClock = this.rendererClock)) {
            if (mediaClock == null) {
                this.rendererClock = mediaClock2;
                this.rendererClockSource = renderer;
                this.rendererClock.setPlaybackParameters(this.standaloneMediaClock.getPlaybackParameters());
                ensureSynced();
                return;
            }
            throw ExoPlaybackException.createForUnexpected(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public final void onRendererDisabled(Renderer renderer) {
        if (renderer == this.rendererClockSource) {
            this.rendererClock = null;
            this.rendererClockSource = null;
        }
    }

    public final long syncAndGetPositionUs() {
        if (!isUsingRendererClock()) {
            return this.standaloneMediaClock.getPositionUs();
        }
        ensureSynced();
        return this.rendererClock.getPositionUs();
    }

    public final long getPositionUs() {
        if (isUsingRendererClock()) {
            return this.rendererClock.getPositionUs();
        }
        return this.standaloneMediaClock.getPositionUs();
    }

    public final PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            playbackParameters = mediaClock.setPlaybackParameters(playbackParameters);
        }
        this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
        this.listener.onPlaybackParametersChanged(playbackParameters);
        return playbackParameters;
    }

    public final PlaybackParameters getPlaybackParameters() {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            return mediaClock.getPlaybackParameters();
        }
        return this.standaloneMediaClock.getPlaybackParameters();
    }

    private void ensureSynced() {
        this.standaloneMediaClock.resetPosition(this.rendererClock.getPositionUs());
        PlaybackParameters playbackParameters = this.rendererClock.getPlaybackParameters();
        if (!playbackParameters.equals(this.standaloneMediaClock.getPlaybackParameters())) {
            this.standaloneMediaClock.setPlaybackParameters(playbackParameters);
            this.listener.onPlaybackParametersChanged(playbackParameters);
        }
    }

    private boolean isUsingRendererClock() {
        Renderer renderer = this.rendererClockSource;
        return renderer != null && !renderer.isEnded() && (this.rendererClockSource.isReady() || !this.rendererClockSource.hasReadStreamToEnd());
    }
}
