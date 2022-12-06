package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.EmptySampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

final class MediaPeriodHolder {
    private static final String TAG = "MediaPeriodHolder";
    public boolean hasEnabledTracks;
    public MediaPeriodInfo info;
    public final boolean[] mayRetainStreamFlags;
    public final MediaPeriod mediaPeriod;
    private final MediaSource mediaSource;
    public MediaPeriodHolder next;
    private TrackSelectorResult periodTrackSelectorResult;
    public boolean prepared;
    private final RendererCapabilities[] rendererCapabilities;
    public long rendererPositionOffsetUs;
    public final SampleStream[] sampleStreams;
    public TrackGroupArray trackGroups;
    private final TrackSelector trackSelector;
    public TrackSelectorResult trackSelectorResult;
    public final Object uid;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaPeriodHolder(com.mbridge.msdk.playercommon.exoplayer2.RendererCapabilities[] r3, long r4, com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector r6, com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator r7, com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource r8, java.lang.Object r9, com.mbridge.msdk.playercommon.exoplayer2.MediaPeriodInfo r10) {
        /*
            r2 = this;
            r2.<init>()
            r2.rendererCapabilities = r3
            long r0 = r10.startPositionUs
            long r4 = r4 - r0
            r2.rendererPositionOffsetUs = r4
            r2.trackSelector = r6
            r2.mediaSource = r8
            java.lang.Object r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkNotNull(r9)
            r2.uid = r4
            r2.info = r10
            int r4 = r3.length
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[] r4 = new com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[r4]
            r2.sampleStreams = r4
            int r3 = r3.length
            boolean[] r3 = new boolean[r3]
            r2.mayRetainStreamFlags = r3
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource$MediaPeriodId r3 = r10.id
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod r5 = r8.createPeriod(r3, r7)
            long r3 = r10.endPositionUs
            r6 = -9223372036854775808
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x003a
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod r3 = new com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod
            r6 = 1
            r7 = 0
            long r9 = r10.endPositionUs
            r4 = r3
            r4.<init>(r5, r6, r7, r9)
            goto L_0x003b
        L_0x003a:
            r3 = r5
        L_0x003b:
            r2.mediaPeriod = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.MediaPeriodHolder.<init>(com.mbridge.msdk.playercommon.exoplayer2.RendererCapabilities[], long, com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector, com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator, com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource, java.lang.Object, com.mbridge.msdk.playercommon.exoplayer2.MediaPeriodInfo):void");
    }

    public final long toRendererTime(long j) {
        return j + getRendererOffset();
    }

    public final long toPeriodTime(long j) {
        return j - getRendererOffset();
    }

    public final long getRendererOffset() {
        return this.rendererPositionOffsetUs;
    }

    public final boolean isFullyBuffered() {
        return this.prepared && (!this.hasEnabledTracks || this.mediaPeriod.getBufferedPositionUs() == Long.MIN_VALUE);
    }

    public final long getDurationUs() {
        return this.info.durationUs;
    }

    public final long getBufferedPositionUs(boolean z) {
        if (!this.prepared) {
            return this.info.startPositionUs;
        }
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        return (bufferedPositionUs != Long.MIN_VALUE || !z) ? bufferedPositionUs : this.info.durationUs;
    }

    public final long getNextLoadPositionUs() {
        if (!this.prepared) {
            return 0;
        }
        return this.mediaPeriod.getNextLoadPositionUs();
    }

    public final void handlePrepared(float f) throws ExoPlaybackException {
        this.prepared = true;
        this.trackGroups = this.mediaPeriod.getTrackGroups();
        selectTracks(f);
        long applyTrackSelection = applyTrackSelection(this.info.startPositionUs, false);
        this.rendererPositionOffsetUs += this.info.startPositionUs - applyTrackSelection;
        this.info = this.info.copyWithStartPositionUs(applyTrackSelection);
    }

    public final void reevaluateBuffer(long j) {
        if (this.prepared) {
            this.mediaPeriod.reevaluateBuffer(toPeriodTime(j));
        }
    }

    public final void continueLoading(long j) {
        this.mediaPeriod.continueLoading(toPeriodTime(j));
    }

    public final boolean selectTracks(float f) throws ExoPlaybackException {
        TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroups);
        if (selectTracks.isEquivalent(this.periodTrackSelectorResult)) {
            return false;
        }
        this.trackSelectorResult = selectTracks;
        for (TrackSelection trackSelection : this.trackSelectorResult.selections.getAll()) {
            if (trackSelection != null) {
                trackSelection.onPlaybackSpeed(f);
            }
        }
        return true;
    }

    public final long applyTrackSelection(long j, boolean z) {
        return applyTrackSelection(j, z, new boolean[this.rendererCapabilities.length]);
    }

    public final long applyTrackSelection(long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= this.trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.mayRetainStreamFlags;
            if (z || !this.trackSelectorResult.isEquivalent(this.periodTrackSelectorResult, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        disassociateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        updatePeriodTrackSelectorResult(this.trackSelectorResult);
        TrackSelectionArray trackSelectionArray = this.trackSelectorResult.selections;
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArray.getAll(), this.mayRetainStreamFlags, this.sampleStreams, zArr, j);
        associateNoSampleRenderersWithEmptySampleStream(this.sampleStreams);
        this.hasEnabledTracks = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.sampleStreams;
            if (i2 >= sampleStreamArr.length) {
                return selectTracks;
            }
            if (sampleStreamArr[i2] != null) {
                Assertions.checkState(this.trackSelectorResult.isRendererEnabled(i2));
                if (this.rendererCapabilities[i2].getTrackType() != 5) {
                    this.hasEnabledTracks = true;
                }
            } else {
                Assertions.checkState(trackSelectionArray.get(i2) == null);
            }
            i2++;
        }
    }

    public final void release() {
        updatePeriodTrackSelectorResult((TrackSelectorResult) null);
        try {
            if (this.info.endPositionUs != Long.MIN_VALUE) {
                this.mediaSource.releasePeriod(((ClippingMediaPeriod) this.mediaPeriod).mediaPeriod);
            } else {
                this.mediaSource.releasePeriod(this.mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log.e(TAG, "Period release failed.", e);
        }
    }

    private void updatePeriodTrackSelectorResult(TrackSelectorResult trackSelectorResult2) {
        TrackSelectorResult trackSelectorResult3 = this.periodTrackSelectorResult;
        if (trackSelectorResult3 != null) {
            disableTrackSelectionsInResult(trackSelectorResult3);
        }
        this.periodTrackSelectorResult = trackSelectorResult2;
        TrackSelectorResult trackSelectorResult4 = this.periodTrackSelectorResult;
        if (trackSelectorResult4 != null) {
            enableTrackSelectionsInResult(trackSelectorResult4);
        }
    }

    private void enableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult2) {
        for (int i = 0; i < trackSelectorResult2.length; i++) {
            boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i);
            TrackSelection trackSelection = trackSelectorResult2.selections.get(i);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.enable();
            }
        }
    }

    private void disableTrackSelectionsInResult(TrackSelectorResult trackSelectorResult2) {
        for (int i = 0; i < trackSelectorResult2.length; i++) {
            boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i);
            TrackSelection trackSelection = trackSelectorResult2.selections.get(i);
            if (isRendererEnabled && trackSelection != null) {
                trackSelection.disable();
            }
        }
    }

    private void disassociateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i].getTrackType() == 5) {
                    sampleStreamArr[i] = null;
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void associateNoSampleRenderersWithEmptySampleStream(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.rendererCapabilities;
            if (i < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i].getTrackType() == 5 && this.trackSelectorResult.isRendererEnabled(i)) {
                    sampleStreamArr[i] = new EmptySampleStream();
                }
                i++;
            } else {
                return;
            }
        }
    }
}
