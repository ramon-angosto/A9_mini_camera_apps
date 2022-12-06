package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    long startUs;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod2, boolean z, long j, long j2) {
        this.mediaPeriod = mediaPeriod2;
        this.pendingInitialDiscontinuityPositionUs = z ? j : C.TIME_UNSET;
        this.startUs = j;
        this.endUs = j2;
    }

    public final void updateClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
    }

    public final void prepare(MediaPeriod.Callback callback2, long j) {
        this.callback = callback2;
        this.mediaPeriod.prepare(this, j);
    }

    public final void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    public final TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        if (r2 > r4) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long selectTracks(com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection[] r13, boolean[] r14, com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = new com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[r2]
            r0.sampleStreams = r2
            int r2 = r1.length
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[] r9 = new com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[r2]
            r10 = 0
            r2 = r10
        L_0x000c:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L_0x0025
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r3 = r0.sampleStreams
            r4 = r1[r2]
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r4 = (com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream) r4
            r3[r2] = r4
            r4 = r3[r2]
            if (r4 == 0) goto L_0x0020
            r3 = r3[r2]
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream r11 = r3.childStream
        L_0x0020:
            r9[r2] = r11
            int r2 = r2 + 1
            goto L_0x000c
        L_0x0025:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod r2 = r0.mediaPeriod
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.selectTracks(r3, r4, r5, r6, r7)
            boolean r4 = r12.isPendingInitialDiscontinuity()
            if (r4 == 0) goto L_0x0047
            long r4 = r0.startUs
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0047
            r6 = r13
            boolean r4 = shouldKeepInitialDiscontinuity(r4, r13)
            if (r4 == 0) goto L_0x0047
            r4 = r2
            goto L_0x004c
        L_0x0047:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x004c:
            r0.pendingInitialDiscontinuityPositionUs = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x0067
            long r4 = r0.startUs
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0065
            long r4 = r0.endUs
            r6 = -9223372036854775808
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0067
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r4 = r10
            goto L_0x0068
        L_0x0067:
            r4 = 1
        L_0x0068:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r4)
        L_0x006b:
            int r4 = r1.length
            if (r10 >= r4) goto L_0x0099
            r4 = r9[r10]
            if (r4 != 0) goto L_0x0077
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.sampleStreams
            r4[r10] = r11
            goto L_0x0090
        L_0x0077:
            r4 = r1[r10]
            if (r4 == 0) goto L_0x0085
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.sampleStreams
            r4 = r4[r10]
            com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream r4 = r4.childStream
            r5 = r9[r10]
            if (r4 == r5) goto L_0x0090
        L_0x0085:
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.sampleStreams
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r5 = new com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream
            r6 = r9[r10]
            r5.<init>(r6)
            r4[r10] = r5
        L_0x0090:
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.sampleStreams
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L_0x006b
        L_0x0099:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.selectTracks(com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection[], boolean[], com.mbridge.msdk.playercommon.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    public final void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    public final void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    public final long readDiscontinuity() {
        if (isPendingInitialDiscontinuity()) {
            long j = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = C.TIME_UNSET;
            long readDiscontinuity = readDiscontinuity();
            return readDiscontinuity != C.TIME_UNSET ? readDiscontinuity : j;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z = true;
        Assertions.checkState(readDiscontinuity2 >= this.startUs);
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && readDiscontinuity2 > j2) {
            z = false;
        }
        Assertions.checkState(z);
        return readDiscontinuity2;
    }

    public final long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (r0 > r6) goto L_0x0035;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long seekToUs(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.pendingInitialDiscontinuityPositionUs = r0
            com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r5.sampleStreams
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.clearSentEos()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod r0 = r5.mediaPeriod
            long r0 = r0.seekToUs(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0034
            long r6 = r5.startUs
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0035
            long r6 = r5.endUs
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0034
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0035
        L_0x0034:
            r2 = 1
        L_0x0035:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.source.ClippingMediaPeriod.seekToUs(long):long");
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.startUs;
        if (j == j2) {
            return j2;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, clipSeekParameters(j, seekParameters));
    }

    public final long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.endUs;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    public final boolean continueLoading(long j) {
        return this.mediaPeriod.continueLoading(j);
    }

    public final void onPrepared(MediaPeriod mediaPeriod2) {
        this.callback.onPrepared(this);
    }

    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod2) {
        this.callback.onContinueLoadingRequested(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != C.TIME_UNSET;
    }

    private SeekParameters clipSeekParameters(long j, SeekParameters seekParameters) {
        long constrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0, j - this.startUs);
        long j2 = seekParameters.toleranceAfterUs;
        long j3 = this.endUs;
        long constrainValue2 = Util.constrainValue(j2, 0, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        if (constrainValue == seekParameters.toleranceBeforeUs && constrainValue2 == seekParameters.toleranceAfterUs) {
            return seekParameters;
        }
        return new SeekParameters(constrainValue, constrainValue2);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j, TrackSelection[] trackSelectionArr) {
        if (j != 0) {
            for (TrackSelection trackSelection : trackSelectionArr) {
                if (trackSelection != null && !MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public final void clearSentEos() {
            this.sentEos = false;
        }

        public final boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        public final void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.childStream.readData(formatHolder, decoderInputBuffer, z);
            if (readData == -5) {
                Format format = formatHolder.format;
                if (!(format.encoderDelay == 0 && format.encoderPadding == 0)) {
                    int i = 0;
                    int i2 = ClippingMediaPeriod.this.startUs != 0 ? 0 : format.encoderDelay;
                    if (ClippingMediaPeriod.this.endUs == Long.MIN_VALUE) {
                        i = format.encoderPadding;
                    }
                    formatHolder.format = format.copyWithGaplessInfo(i2, i);
                }
                return -5;
            } else if (ClippingMediaPeriod.this.endUs == Long.MIN_VALUE || ((readData != -4 || decoderInputBuffer.timeUs < ClippingMediaPeriod.this.endUs) && (readData != -3 || ClippingMediaPeriod.this.getBufferedPositionUs() != Long.MIN_VALUE))) {
                return readData;
            } else {
                decoderInputBuffer.clear();
                decoderInputBuffer.setFlags(4);
                this.sentEos = true;
                return -4;
            }
        }

        public final int skipData(long j) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j);
        }
    }
}
