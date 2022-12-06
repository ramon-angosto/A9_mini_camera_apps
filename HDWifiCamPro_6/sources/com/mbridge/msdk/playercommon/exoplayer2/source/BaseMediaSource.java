package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseMediaSource implements MediaSource {
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
    private Object manifest;
    private ExoPlayer player;
    private final ArrayList<MediaSource.SourceInfoRefreshListener> sourceInfoListeners = new ArrayList<>(1);
    private Timeline timeline;

    /* access modifiers changed from: protected */
    public abstract void prepareSourceInternal(ExoPlayer exoPlayer, boolean z);

    /* access modifiers changed from: protected */
    public abstract void releaseSourceInternal();

    /* access modifiers changed from: protected */
    public final void refreshSourceInfo(Timeline timeline2, Object obj) {
        this.timeline = timeline2;
        this.manifest = obj;
        Iterator<MediaSource.SourceInfoRefreshListener> it = this.sourceInfoListeners.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, timeline2, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId, 0);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        Assertions.checkArgument(mediaPeriodId != null);
        return this.eventDispatcher.withParameters(0, mediaPeriodId, j);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        return this.eventDispatcher.withParameters(i, mediaPeriodId, j);
    }

    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    public final void prepareSource(ExoPlayer exoPlayer, boolean z, MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        ExoPlayer exoPlayer2 = this.player;
        Assertions.checkArgument(exoPlayer2 == null || exoPlayer2 == exoPlayer);
        this.sourceInfoListeners.add(sourceInfoRefreshListener);
        if (this.player == null) {
            this.player = exoPlayer;
            prepareSourceInternal(exoPlayer, z);
            return;
        }
        Timeline timeline2 = this.timeline;
        if (timeline2 != null) {
            sourceInfoRefreshListener.onSourceInfoRefreshed(this, timeline2, this.manifest);
        }
    }

    public final void releaseSource(MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        this.sourceInfoListeners.remove(sourceInfoRefreshListener);
        if (this.sourceInfoListeners.isEmpty()) {
            this.player = null;
            this.timeline = null;
            this.manifest = null;
            releaseSourceInternal();
        }
    }
}
