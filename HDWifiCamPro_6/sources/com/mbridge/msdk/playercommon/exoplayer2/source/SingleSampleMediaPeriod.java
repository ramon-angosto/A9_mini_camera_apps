package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Loader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private int errorCount;
    /* access modifiers changed from: private */
    public final MediaSourceEventListener.EventDispatcher eventDispatcher;
    final Format format;
    final Loader loader = new Loader("Loader:SingleSampleMediaPeriod");
    boolean loadingFinished;
    boolean loadingSucceeded;
    private final int minLoadableRetryCount;
    boolean notifiedReadingStarted;
    byte[] sampleData;
    int sampleSize;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    private final TrackGroupArray tracks;
    final boolean treatLoadErrorsAsEndOfStream;

    public final void discardBuffer(long j, boolean z) {
    }

    public final long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        return j;
    }

    public final void maybeThrowPrepareError() throws IOException {
    }

    public final void reevaluateBuffer(long j) {
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec2, DataSource.Factory factory, Format format2, long j, int i, MediaSourceEventListener.EventDispatcher eventDispatcher2, boolean z) {
        this.dataSpec = dataSpec2;
        this.dataSourceFactory = factory;
        this.format = format2;
        this.durationUs = j;
        this.minLoadableRetryCount = i;
        this.eventDispatcher = eventDispatcher2;
        this.treatLoadErrorsAsEndOfStream = z;
        this.tracks = new TrackGroupArray(new TrackGroup(format2));
        eventDispatcher2.mediaPeriodCreated();
    }

    public final void release() {
        this.loader.release();
        this.eventDispatcher.mediaPeriodReleased();
    }

    public final void prepare(MediaPeriod.Callback callback, long j) {
        callback.onPrepared(this);
    }

    public final TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < trackSelectionArr.length; i++) {
            if (sampleStreamArr[i] != null && (trackSelectionArr[i] == null || !zArr[i])) {
                this.sampleStreams.remove(sampleStreamArr[i]);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && trackSelectionArr[i] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }

    public final boolean continueLoading(long j) {
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, this.loader.startLoading(new SourceLoadable(this.dataSpec, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount));
        return true;
    }

    public final long readDiscontinuity() {
        if (this.notifiedReadingStarted) {
            return C.TIME_UNSET;
        }
        this.eventDispatcher.readingStarted();
        this.notifiedReadingStarted = true;
        return C.TIME_UNSET;
    }

    public final long getNextLoadPositionUs() {
        return (this.loadingFinished || this.loader.isLoading()) ? Long.MIN_VALUE : 0;
    }

    public final long getBufferedPositionUs() {
        return this.loadingFinished ? Long.MIN_VALUE : 0;
    }

    public final long seekToUs(long j) {
        for (int i = 0; i < this.sampleStreams.size(); i++) {
            this.sampleStreams.get(i).reset();
        }
        return j;
    }

    public final void onLoadCompleted(SourceLoadable sourceLoadable, long j, long j2) {
        this.eventDispatcher.loadCompleted(sourceLoadable.dataSpec, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, j, j2, (long) sourceLoadable.sampleSize);
        this.sampleSize = sourceLoadable.sampleSize;
        this.sampleData = sourceLoadable.sampleData;
        this.loadingFinished = true;
        this.loadingSucceeded = true;
    }

    public final void onLoadCanceled(SourceLoadable sourceLoadable, long j, long j2, boolean z) {
        this.eventDispatcher.loadCanceled(sourceLoadable.dataSpec, 1, -1, (Format) null, 0, (Object) null, 0, this.durationUs, j, j2, (long) sourceLoadable.sampleSize);
    }

    public final int onLoadError(SourceLoadable sourceLoadable, long j, long j2, IOException iOException) {
        this.errorCount++;
        boolean z = this.treatLoadErrorsAsEndOfStream && this.errorCount >= this.minLoadableRetryCount;
        this.eventDispatcher.loadError(sourceLoadable.dataSpec, 1, -1, this.format, 0, (Object) null, 0, this.durationUs, j, j2, (long) sourceLoadable.sampleSize, iOException, z);
        if (!z) {
            return 0;
        }
        this.loadingFinished = true;
        return 2;
    }

    private final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean formatSent;
        private int streamState;

        private SampleStreamImpl() {
        }

        public final void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        public final boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        public final void maybeThrowError() throws IOException {
            if (!SingleSampleMediaPeriod.this.treatLoadErrorsAsEndOfStream) {
                SingleSampleMediaPeriod.this.loader.maybeThrowError();
            }
        }

        public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
            int i = this.streamState;
            if (i == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            } else if (z || i == 0) {
                formatHolder.format = SingleSampleMediaPeriod.this.format;
                this.streamState = 1;
                return -5;
            } else if (!SingleSampleMediaPeriod.this.loadingFinished) {
                return -3;
            } else {
                if (SingleSampleMediaPeriod.this.loadingSucceeded) {
                    decoderInputBuffer.timeUs = 0;
                    decoderInputBuffer.addFlag(1);
                    decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                    decoderInputBuffer.data.put(SingleSampleMediaPeriod.this.sampleData, 0, SingleSampleMediaPeriod.this.sampleSize);
                    sendFormat();
                } else {
                    decoderInputBuffer.addFlag(4);
                }
                this.streamState = 2;
                return -4;
            }
        }

        public final int skipData(long j) {
            if (j <= 0 || this.streamState == 2) {
                return 0;
            }
            this.streamState = 2;
            sendFormat();
            return 1;
        }

        private void sendFormat() {
            if (!this.formatSent) {
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, (Object) null, 0);
                this.formatSent = true;
            }
        }
    }

    static final class SourceLoadable implements Loader.Loadable {
        private final DataSource dataSource;
        public final DataSpec dataSpec;
        /* access modifiers changed from: private */
        public byte[] sampleData;
        /* access modifiers changed from: private */
        public int sampleSize;

        public final void cancelLoad() {
        }

        public SourceLoadable(DataSpec dataSpec2, DataSource dataSource2) {
            this.dataSpec = dataSpec2;
            this.dataSource = dataSource2;
        }

        public final void load() throws IOException, InterruptedException {
            int i = 0;
            this.sampleSize = 0;
            try {
                this.dataSource.open(this.dataSpec);
                while (i != -1) {
                    this.sampleSize += i;
                    if (this.sampleData == null) {
                        this.sampleData = new byte[1024];
                    } else if (this.sampleSize == this.sampleData.length) {
                        this.sampleData = Arrays.copyOf(this.sampleData, this.sampleData.length * 2);
                    }
                    i = this.dataSource.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
                }
            } finally {
                Util.closeQuietly(this.dataSource);
            }
        }
    }
}
