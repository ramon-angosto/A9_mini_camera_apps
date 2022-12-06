package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class SingleSampleMediaSource extends BaseMediaSource {
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final int minLoadableRetryCount;
    private final Timeline timeline;
    private final boolean treatLoadErrorsAsEndOfStream;

    public interface EventListener {
        void onLoadError(int i, IOException iOException);
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    public final void releaseSourceInternal() {
    }

    public static final class Factory {
        private final DataSource.Factory dataSourceFactory;
        private boolean isCreateCalled;
        private int minLoadableRetryCount = 3;
        private Object tag;
        private boolean treatLoadErrorsAsEndOfStream;

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = (DataSource.Factory) Assertions.checkNotNull(factory);
        }

        public final Factory setTag(Object obj) {
            Assertions.checkState(!this.isCreateCalled);
            this.tag = obj;
            return this;
        }

        public final Factory setMinLoadableRetryCount(int i) {
            Assertions.checkState(!this.isCreateCalled);
            this.minLoadableRetryCount = i;
            return this;
        }

        public final Factory setTreatLoadErrorsAsEndOfStream(boolean z) {
            Assertions.checkState(!this.isCreateCalled);
            this.treatLoadErrorsAsEndOfStream = z;
            return this;
        }

        public final SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j) {
            this.isCreateCalled = true;
            return new SingleSampleMediaSource(uri, this.dataSourceFactory, format, j, this.minLoadableRetryCount, this.treatLoadErrorsAsEndOfStream, this.tag);
        }

        public final SingleSampleMediaSource createMediaSource(Uri uri, Format format, long j, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            SingleSampleMediaSource createMediaSource = createMediaSource(uri, format, j);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }
    }

    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j) {
        this(uri, factory, format2, j, 3);
    }

    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j, int i) {
        this(uri, factory, format2, j, i, false, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j, int i, Handler handler, EventListener eventListener, int i2, boolean z) {
        this(uri, factory, format2, j, i, z, (Object) null);
        Handler handler2 = handler;
        EventListener eventListener2 = eventListener;
        if (handler2 == null || eventListener2 == null) {
            return;
        }
        EventListenerWrapper eventListenerWrapper = new EventListenerWrapper(eventListener2, i2);
        addEventListener(handler2, eventListenerWrapper);
    }

    private SingleSampleMediaSource(Uri uri, DataSource.Factory factory, Format format2, long j, int i, boolean z, Object obj) {
        this.dataSourceFactory = factory;
        this.format = format2;
        this.durationUs = j;
        this.minLoadableRetryCount = i;
        this.treatLoadErrorsAsEndOfStream = z;
        this.dataSpec = new DataSpec(uri);
        this.timeline = new SinglePeriodTimeline(j, true, false, obj);
    }

    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z) {
        refreshSourceInfo(this.timeline, (Object) null);
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        Assertions.checkArgument(mediaPeriodId.periodIndex == 0);
        return new SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, this.format, this.durationUs, this.minLoadableRetryCount, createEventDispatcher(mediaPeriodId), this.treatLoadErrorsAsEndOfStream);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).release();
    }

    private static final class EventListenerWrapper extends DefaultMediaSourceEventListener {
        private final EventListener eventListener;
        private final int eventSourceId;

        public EventListenerWrapper(EventListener eventListener2, int i) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener2);
            this.eventSourceId = i;
        }

        public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            this.eventListener.onLoadError(this.eventSourceId, iOException);
        }
    }
}
