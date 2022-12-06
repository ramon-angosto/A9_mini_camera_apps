package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import java.io.IOException;

public final class DeferredMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    public final MediaSource.MediaPeriodId id;
    private PrepareErrorListener listener;
    private MediaPeriod mediaPeriod;
    public final MediaSource mediaSource;
    private boolean notifiedPrepareError;
    private long preparePositionOverrideUs = C.TIME_UNSET;
    private long preparePositionUs;

    public interface PrepareErrorListener {
        void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public DeferredMediaPeriod(MediaSource mediaSource2, MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator2) {
        this.id = mediaPeriodId;
        this.allocator = allocator2;
        this.mediaSource = mediaSource2;
    }

    public final void setPrepareErrorListener(PrepareErrorListener prepareErrorListener) {
        this.listener = prepareErrorListener;
    }

    public final void setDefaultPreparePositionUs(long j) {
        if (this.preparePositionUs == 0 && j != 0) {
            this.preparePositionOverrideUs = j;
            this.preparePositionUs = j;
        }
    }

    public final void createPeriod() {
        this.mediaPeriod = this.mediaSource.createPeriod(this.id, this.allocator);
        if (this.callback != null) {
            this.mediaPeriod.prepare(this, this.preparePositionUs);
        }
    }

    public final void releasePeriod() {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            this.mediaSource.releasePeriod(mediaPeriod2);
        }
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.preparePositionUs = j;
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        if (mediaPeriod2 != null) {
            mediaPeriod2.prepare(this, j);
        }
    }

    public final void maybeThrowPrepareError() throws IOException {
        try {
            if (this.mediaPeriod != null) {
                this.mediaPeriod.maybeThrowPrepareError();
            } else {
                this.mediaSource.maybeThrowSourceInfoRefreshError();
            }
        } catch (IOException e) {
            PrepareErrorListener prepareErrorListener = this.listener;
            if (prepareErrorListener == null) {
                throw e;
            } else if (!this.notifiedPrepareError) {
                this.notifiedPrepareError = true;
                prepareErrorListener.onPrepareError(this.id, e);
            }
        }
    }

    public final TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.preparePositionOverrideUs;
        if (j3 == C.TIME_UNSET || j != 0) {
            j2 = j;
        } else {
            this.preparePositionOverrideUs = C.TIME_UNSET;
            j2 = j3;
        }
        return this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr, zArr2, j2);
    }

    public final void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    public final long readDiscontinuity() {
        return this.mediaPeriod.readDiscontinuity();
    }

    public final long getBufferedPositionUs() {
        return this.mediaPeriod.getBufferedPositionUs();
    }

    public final long seekToUs(long j) {
        return this.mediaPeriod.seekToUs(j);
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, seekParameters);
    }

    public final long getNextLoadPositionUs() {
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public final void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    public final boolean continueLoading(long j) {
        MediaPeriod mediaPeriod2 = this.mediaPeriod;
        return mediaPeriod2 != null && mediaPeriod2.continueLoading(j);
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        this.callback.onContinueLoadingRequested(this);
    }

    public final void onPrepared(MediaPeriod mediaPeriod2) {
        this.callback.onPrepared(this);
    }
}
