package com.mbridge.msdk.playercommon.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.CompositeMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.DeferredMediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdsLoader;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final String TAG = "AdsMediaSource";
    private long[][] adDurationsUs;
    private MediaSource[][] adGroupMediaSources;
    private final MediaSourceFactory adMediaSourceFactory;
    private AdPlaybackState adPlaybackState;
    /* access modifiers changed from: private */
    public final ViewGroup adUiViewGroup;
    /* access modifiers changed from: private */
    public final AdsLoader adsLoader;
    private ComponentListener componentListener;
    private Object contentManifest;
    private final MediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Map<MediaSource, List<DeferredMediaPeriod>> deferredMediaPeriodByAdMediaSource;
    /* access modifiers changed from: private */
    public final Handler eventHandler;
    /* access modifiers changed from: private */
    public final EventListener eventListener;
    /* access modifiers changed from: private */
    public final Handler mainHandler;
    private final Timeline.Period period;

    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(IOException iOException);

        void onAdTapped();

        void onInternalAdLoadError(RuntimeException runtimeException);
    }

    public interface MediaSourceFactory {
        MediaSource createMediaSource(Uri uri);

        int[] getSupportedTypes();
    }

    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        public @interface Type {
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i, exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public final RuntimeException getRuntimeExceptionForUnexpected() {
            Assertions.checkState(this.type == 3);
            return (RuntimeException) getCause();
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader2, ViewGroup viewGroup) {
        this(mediaSource, (MediaSourceFactory) new ExtractorMediaSource.Factory(factory), adsLoader2, viewGroup, (Handler) null, (EventListener) null);
    }

    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader2, ViewGroup viewGroup) {
        this(mediaSource, mediaSourceFactory, adsLoader2, viewGroup, (Handler) null, (EventListener) null);
    }

    public AdsMediaSource(MediaSource mediaSource, DataSource.Factory factory, AdsLoader adsLoader2, ViewGroup viewGroup, Handler handler, EventListener eventListener2) {
        this(mediaSource, (MediaSourceFactory) new ExtractorMediaSource.Factory(factory), adsLoader2, viewGroup, handler, eventListener2);
    }

    public AdsMediaSource(MediaSource mediaSource, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader2, ViewGroup viewGroup, Handler handler, EventListener eventListener2) {
        this.contentMediaSource = mediaSource;
        this.adMediaSourceFactory = mediaSourceFactory;
        this.adsLoader = adsLoader2;
        this.adUiViewGroup = viewGroup;
        this.eventHandler = handler;
        this.eventListener = eventListener2;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.deferredMediaPeriodByAdMediaSource = new HashMap();
        this.period = new Timeline.Period();
        this.adGroupMediaSources = new MediaSource[0][];
        this.adDurationsUs = new long[0][];
        adsLoader2.setSupportedContentTypes(mediaSourceFactory.getSupportedTypes());
    }

    public final void prepareSourceInternal(final ExoPlayer exoPlayer, boolean z) {
        super.prepareSourceInternal(exoPlayer, z);
        Assertions.checkArgument(z);
        final ComponentListener componentListener2 = new ComponentListener();
        this.componentListener = componentListener2;
        prepareChildSource(new MediaSource.MediaPeriodId(0), this.contentMediaSource);
        this.mainHandler.post(new Runnable() {
            public void run() {
                AdsMediaSource.this.adsLoader.attachPlayer(exoPlayer, componentListener2, AdsMediaSource.this.adUiViewGroup);
            }
        });
    }

    public final MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator) {
        if (this.adPlaybackState.adGroupCount <= 0 || !mediaPeriodId.isAd()) {
            DeferredMediaPeriod deferredMediaPeriod = new DeferredMediaPeriod(this.contentMediaSource, mediaPeriodId, allocator);
            deferredMediaPeriod.createPeriod();
            return deferredMediaPeriod;
        }
        int i = mediaPeriodId.adGroupIndex;
        int i2 = mediaPeriodId.adIndexInAdGroup;
        Uri uri = this.adPlaybackState.adGroups[i].uris[i2];
        if (this.adGroupMediaSources[i].length <= i2) {
            MediaSource createMediaSource = this.adMediaSourceFactory.createMediaSource(uri);
            MediaSource[][] mediaSourceArr = this.adGroupMediaSources;
            int length = mediaSourceArr[i].length;
            if (i2 >= length) {
                int i3 = i2 + 1;
                mediaSourceArr[i] = (MediaSource[]) Arrays.copyOf(mediaSourceArr[i], i3);
                long[][] jArr = this.adDurationsUs;
                jArr[i] = Arrays.copyOf(jArr[i], i3);
                Arrays.fill(this.adDurationsUs[i], length, i3, C.TIME_UNSET);
            }
            this.adGroupMediaSources[i][i2] = createMediaSource;
            this.deferredMediaPeriodByAdMediaSource.put(createMediaSource, new ArrayList());
            prepareChildSource(mediaPeriodId, createMediaSource);
        }
        MediaSource mediaSource = this.adGroupMediaSources[i][i2];
        DeferredMediaPeriod deferredMediaPeriod2 = new DeferredMediaPeriod(mediaSource, new MediaSource.MediaPeriodId(0, mediaPeriodId.windowSequenceNumber), allocator);
        deferredMediaPeriod2.setPrepareErrorListener(new AdPrepareErrorListener(uri, i, i2));
        List list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
        if (list == null) {
            deferredMediaPeriod2.createPeriod();
        } else {
            list.add(deferredMediaPeriod2);
        }
        return deferredMediaPeriod2;
    }

    public final void releasePeriod(MediaPeriod mediaPeriod) {
        DeferredMediaPeriod deferredMediaPeriod = (DeferredMediaPeriod) mediaPeriod;
        List list = this.deferredMediaPeriodByAdMediaSource.get(deferredMediaPeriod.mediaSource);
        if (list != null) {
            list.remove(deferredMediaPeriod);
        }
        deferredMediaPeriod.releasePeriod();
    }

    public final void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.componentListener.release();
        this.componentListener = null;
        this.deferredMediaPeriodByAdMediaSource.clear();
        this.contentTimeline = null;
        this.contentManifest = null;
        this.adPlaybackState = null;
        this.adGroupMediaSources = new MediaSource[0][];
        this.adDurationsUs = new long[0][];
        this.mainHandler.post(new Runnable() {
            public void run() {
                AdsMediaSource.this.adsLoader.detachPlayer();
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void onChildSourceInfoRefreshed(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline, Object obj) {
        if (mediaPeriodId.isAd()) {
            onAdSourceInfoRefreshed(mediaSource, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, timeline);
        } else {
            onContentSourceInfoRefreshed(timeline, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    /* access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState2) {
        if (this.adPlaybackState == null) {
            this.adGroupMediaSources = new MediaSource[adPlaybackState2.adGroupCount][];
            Arrays.fill(this.adGroupMediaSources, new MediaSource[0]);
            this.adDurationsUs = new long[adPlaybackState2.adGroupCount][];
            Arrays.fill(this.adDurationsUs, new long[0]);
        }
        this.adPlaybackState = adPlaybackState2;
        maybeUpdateSourceInfo();
    }

    private void onContentSourceInfoRefreshed(Timeline timeline, Object obj) {
        this.contentTimeline = timeline;
        this.contentManifest = obj;
        maybeUpdateSourceInfo();
    }

    private void onAdSourceInfoRefreshed(MediaSource mediaSource, int i, int i2, Timeline timeline) {
        boolean z = true;
        if (timeline.getPeriodCount() != 1) {
            z = false;
        }
        Assertions.checkArgument(z);
        this.adDurationsUs[i][i2] = timeline.getPeriod(0, this.period).getDurationUs();
        if (this.deferredMediaPeriodByAdMediaSource.containsKey(mediaSource)) {
            List list = this.deferredMediaPeriodByAdMediaSource.get(mediaSource);
            for (int i3 = 0; i3 < list.size(); i3++) {
                ((DeferredMediaPeriod) list.get(i3)).createPeriod();
            }
            this.deferredMediaPeriodByAdMediaSource.remove(mediaSource);
        }
        maybeUpdateSourceInfo();
    }

    private void maybeUpdateSourceInfo() {
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 != null && this.contentTimeline != null) {
            this.adPlaybackState = adPlaybackState2.withAdDurationsUs(this.adDurationsUs);
            refreshSourceInfo(this.adPlaybackState.adGroupCount == 0 ? this.contentTimeline : new SinglePeriodAdTimeline(this.contentTimeline, this.adPlaybackState), this.contentManifest);
        }
    }

    private final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler = new Handler();
        /* access modifiers changed from: private */
        public volatile boolean released;

        public ComponentListener() {
        }

        public final void release() {
            this.released = true;
            this.playerHandler.removeCallbacksAndMessages((Object) null);
        }

        public final void onAdPlaybackState(final AdPlaybackState adPlaybackState) {
            if (!this.released) {
                this.playerHandler.post(new Runnable() {
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
                        }
                    }
                });
            }
        }

        public final void onAdClicked() {
            if (!this.released && AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() {
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdClicked();
                        }
                    }
                });
            }
        }

        public final void onAdTapped() {
            if (!this.released && AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                AdsMediaSource.this.eventHandler.post(new Runnable() {
                    public void run() {
                        if (!ComponentListener.this.released) {
                            AdsMediaSource.this.eventListener.onAdTapped();
                        }
                    }
                });
            }
        }

        public final void onAdLoadError(final AdLoadException adLoadException, DataSpec dataSpec) {
            if (!this.released) {
                AdsMediaSource.this.createEventDispatcher((MediaSource.MediaPeriodId) null).loadError(dataSpec, 6, -1, 0, 0, adLoadException, true);
                if (AdsMediaSource.this.eventHandler != null && AdsMediaSource.this.eventListener != null) {
                    AdsMediaSource.this.eventHandler.post(new Runnable() {
                        public void run() {
                            if (ComponentListener.this.released) {
                                return;
                            }
                            if (adLoadException.type == 3) {
                                AdsMediaSource.this.eventListener.onInternalAdLoadError(adLoadException.getRuntimeExceptionForUnexpected());
                            } else {
                                AdsMediaSource.this.eventListener.onAdLoadError(adLoadException);
                            }
                        }
                    });
                }
            }
        }
    }

    private final class AdPrepareErrorListener implements DeferredMediaPeriod.PrepareErrorListener {
        /* access modifiers changed from: private */
        public final int adGroupIndex;
        /* access modifiers changed from: private */
        public final int adIndexInAdGroup;
        private final Uri adUri;

        public AdPrepareErrorListener(Uri uri, int i, int i2) {
            this.adUri = uri;
            this.adGroupIndex = i;
            this.adIndexInAdGroup = i2;
        }

        public final void onPrepareError(MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new DataSpec(this.adUri), 6, -1, 0, 0, AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.mainHandler.post(new Runnable() {
                public void run() {
                    AdsMediaSource.this.adsLoader.handlePrepareError(AdPrepareErrorListener.this.adGroupIndex, AdPrepareErrorListener.this.adIndexInAdGroup, iOException);
                }
            });
        }
    }
}
