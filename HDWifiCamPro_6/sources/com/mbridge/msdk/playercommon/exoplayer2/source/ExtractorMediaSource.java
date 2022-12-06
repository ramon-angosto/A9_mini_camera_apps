package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.DefaultExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdsMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ExtractorMediaSource extends BaseMediaSource implements ExtractorMediaPeriod.Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 1048576;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_LIVE = 6;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_ON_DEMAND = 3;
    public static final int MIN_RETRY_COUNT_DEFAULT_FOR_MEDIA = -1;
    private final int continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource.Factory dataSourceFactory;
    private final ExtractorsFactory extractorsFactory;
    private final int minLoadableRetryCount;
    private final Object tag;
    private long timelineDurationUs;
    private boolean timelineIsSeekable;
    private final Uri uri;

    public interface EventListener {
        void onLoadError(IOException iOException);
    }

    public final void maybeThrowSourceInfoRefreshError() throws IOException {
    }

    public final void releaseSourceInternal() {
    }

    public static final class Factory implements AdsMediaSource.MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes = 1048576;
        private String customCacheKey;
        private final DataSource.Factory dataSourceFactory;
        private ExtractorsFactory extractorsFactory;
        private boolean isCreateCalled;
        private int minLoadableRetryCount = -1;
        private Object tag;

        public final int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory(DataSource.Factory factory) {
            this.dataSourceFactory = factory;
        }

        public final Factory setExtractorsFactory(ExtractorsFactory extractorsFactory2) {
            Assertions.checkState(!this.isCreateCalled);
            this.extractorsFactory = extractorsFactory2;
            return this;
        }

        public final Factory setCustomCacheKey(String str) {
            Assertions.checkState(!this.isCreateCalled);
            this.customCacheKey = str;
            return this;
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

        public final Factory setContinueLoadingCheckIntervalBytes(int i) {
            Assertions.checkState(!this.isCreateCalled);
            this.continueLoadingCheckIntervalBytes = i;
            return this;
        }

        public final ExtractorMediaSource createMediaSource(Uri uri) {
            this.isCreateCalled = true;
            if (this.extractorsFactory == null) {
                this.extractorsFactory = new DefaultExtractorsFactory();
            }
            return new ExtractorMediaSource(uri, this.dataSourceFactory, this.extractorsFactory, this.minLoadableRetryCount, this.customCacheKey, this.continueLoadingCheckIntervalBytes, this.tag);
        }

        public final ExtractorMediaSource createMediaSource(Uri uri, Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            ExtractorMediaSource createMediaSource = createMediaSource(uri);
            if (!(handler == null || mediaSourceEventListener == null)) {
                createMediaSource.addEventListener(handler, mediaSourceEventListener);
            }
            return createMediaSource;
        }
    }

    public ExtractorMediaSource(Uri uri2, DataSource.Factory factory, ExtractorsFactory extractorsFactory2, Handler handler, EventListener eventListener) {
        this(uri2, factory, extractorsFactory2, handler, eventListener, (String) null);
    }

    public ExtractorMediaSource(Uri uri2, DataSource.Factory factory, ExtractorsFactory extractorsFactory2, Handler handler, EventListener eventListener, String str) {
        this(uri2, factory, extractorsFactory2, -1, handler, eventListener, str, 1048576);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExtractorMediaSource(Uri uri2, DataSource.Factory factory, ExtractorsFactory extractorsFactory2, int i, Handler handler, EventListener eventListener, String str, int i2) {
        this(uri2, factory, extractorsFactory2, i, str, i2, (Object) null);
        Handler handler2 = handler;
        EventListener eventListener2 = eventListener;
        if (eventListener2 == null || handler2 == null) {
            return;
        }
        EventListenerWrapper eventListenerWrapper = new EventListenerWrapper(eventListener2);
        addEventListener(handler, eventListenerWrapper);
    }

    private ExtractorMediaSource(Uri uri2, DataSource.Factory factory, ExtractorsFactory extractorsFactory2, int i, String str, int i2, Object obj) {
        this.uri = uri2;
        this.dataSourceFactory = factory;
        this.extractorsFactory = extractorsFactory2;
        this.minLoadableRetryCount = i;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i2;
        this.timelineDurationUs = C.TIME_UNSET;
        this.tag = obj;
    }

    public final void prepareSourceInternal(ExoPlayer exoPlayer, boolean z) {
        notifySourceInfoRefreshed(this.timelineDurationUs, false);
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        Assertions.checkArgument(mediaPeriodId.periodIndex == 0);
        return new ExtractorMediaPeriod(this.uri, this.dataSourceFactory.createDataSource(), this.extractorsFactory.createExtractors(), this.minLoadableRetryCount, createEventDispatcher(mediaPeriodId), this, allocator, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        ((ExtractorMediaPeriod) mediaPeriod).release();
    }

    public final void onSourceInfoRefreshed(long j, boolean z) {
        if (j == C.TIME_UNSET) {
            j = this.timelineDurationUs;
        }
        if (this.timelineDurationUs != j || this.timelineIsSeekable != z) {
            notifySourceInfoRefreshed(j, z);
        }
    }

    private void notifySourceInfoRefreshed(long j, boolean z) {
        this.timelineDurationUs = j;
        this.timelineIsSeekable = z;
        refreshSourceInfo(new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.tag), (Object) null);
    }

    private static final class EventListenerWrapper extends DefaultMediaSourceEventListener {
        private final EventListener eventListener;

        public EventListenerWrapper(EventListener eventListener2) {
            this.eventListener = (EventListener) Assertions.checkNotNull(eventListener2);
        }

        public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            this.eventListener.onLoadError(iOException);
        }
    }
}
