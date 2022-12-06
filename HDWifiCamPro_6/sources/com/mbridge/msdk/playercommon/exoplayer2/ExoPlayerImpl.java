package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

final class ExoPlayerImpl implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArraySet<Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private int pendingOperationAcks;
    private final ArrayDeque<PlaybackInfoUpdate> pendingPlaybackInfoUpdates;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private ExoPlaybackException playbackError;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public final Player.TextComponent getTextComponent() {
        return null;
    }

    public final Player.VideoComponent getVideoComponent() {
        return null;
    }

    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector2, LoadControl loadControl, Clock clock) {
        Renderer[] rendererArr2 = rendererArr;
        Log.i(TAG, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "]");
        Assertions.checkState(rendererArr2.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector2);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new CopyOnWriteArraySet<>();
        this.emptyTrackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr2.length], new TrackSelection[rendererArr2.length], (Object) null);
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.eventHandler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, 0, TrackGroupArray.EMPTY, this.emptyTrackSelectorResult);
        this.pendingPlaybackInfoUpdates = new ArrayDeque<>();
        this.internalPlayer = new ExoPlayerImplInternal(rendererArr, trackSelector2, this.emptyTrackSelectorResult, loadControl, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, this.eventHandler, this, clock);
        this.internalPlayerHandler = new Handler(this.internalPlayer.getPlaybackLooper());
    }

    public final Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public final void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    public final void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    public final int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    public final ExoPlaybackException getPlaybackError() {
        return this.playbackError;
    }

    public final void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    public final void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        this.playbackError = null;
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z, z2, 2);
        this.hasPendingPrepare = true;
        this.pendingOperationAcks++;
        this.internalPlayer.prepare(mediaSource, z, z2);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    public final void setPlayWhenReady(boolean z) {
        if (this.playWhenReady != z) {
            this.playWhenReady = z;
            this.internalPlayer.setPlayWhenReady(z);
            updatePlaybackInfo(this.playbackInfo, false, 4, 1, false, true);
        }
    }

    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    public final void setRepeatMode(int i) {
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.internalPlayer.setRepeatMode(i);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i);
            }
        }
    }

    public final int getRepeatMode() {
        return this.repeatMode;
    }

    public final void setShuffleModeEnabled(boolean z) {
        if (this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            this.internalPlayer.setShuffleModeEnabled(z);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z);
            }
        }
    }

    public final boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public final boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    public final void seekToDefaultPosition(int i) {
        seekTo(i, C.TIME_UNSET);
    }

    public final void seekTo(long j) {
        seekTo(getCurrentWindowIndex(), j);
    }

    public final void seekTo(int i, long j) {
        Timeline timeline = this.playbackInfo.timeline;
        if (i < 0 || (!timeline.isEmpty() && i >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i, j);
        }
        this.hasPendingSeek = true;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w(TAG, "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            return;
        }
        this.maskingWindowIndex = i;
        if (timeline.isEmpty()) {
            this.maskingWindowPositionMs = j == C.TIME_UNSET ? 0 : j;
            this.maskingPeriodIndex = 0;
        } else {
            long defaultPositionUs = j == C.TIME_UNSET ? timeline.getWindow(i, this.window).getDefaultPositionUs() : C.msToUs(j);
            Pair<Integer, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i, defaultPositionUs);
            this.maskingWindowPositionMs = C.usToMs(defaultPositionUs);
            this.maskingPeriodIndex = ((Integer) periodPosition.first).intValue();
        }
        this.internalPlayer.seekTo(timeline, i, C.msToUs(j));
        Iterator<Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(1);
        }
    }

    public final void setPlaybackParameters(PlaybackParameters playbackParameters2) {
        if (playbackParameters2 == null) {
            playbackParameters2 = PlaybackParameters.DEFAULT;
        }
        this.internalPlayer.setPlaybackParameters(playbackParameters2);
    }

    public final PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    public final void setSeekParameters(SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        this.internalPlayer.setSeekParameters(seekParameters);
    }

    public final Object getCurrentTag() {
        int currentWindowIndex = getCurrentWindowIndex();
        if (currentWindowIndex > this.playbackInfo.timeline.getWindowCount()) {
            return null;
        }
        return this.playbackInfo.timeline.getWindow(currentWindowIndex, this.window, true).tag;
    }

    public final void stop() {
        stop(false);
    }

    public final void stop(boolean z) {
        if (z) {
            this.playbackError = null;
        }
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z, z, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(z);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    public final void release() {
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + ExoPlayerLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages((Object) null);
    }

    public final void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send();
        }
    }

    public final PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    public final void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            arrayList.add(createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send());
        }
        boolean z = false;
        for (PlayerMessage playerMessage : arrayList) {
            boolean z2 = z;
            boolean z3 = true;
            while (z3) {
                try {
                    playerMessage.blockUntilDelivered();
                    z3 = false;
                } catch (InterruptedException unused) {
                    z2 = true;
                } catch (TimeoutException e) {
                    q.d(TAG, e.getMessage());
                }
            }
            z = z2;
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        return this.playbackInfo.periodId.periodIndex;
    }

    public final int getCurrentWindowIndex() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        return this.playbackInfo.timeline.getPeriod(this.playbackInfo.periodId.periodIndex, this.period).windowIndex;
    }

    public final int getNextWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getNextWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    public final int getPreviousWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getPreviousWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    public final long getDuration() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return C.TIME_UNSET;
        }
        if (!isPlayingAd()) {
            return timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public final long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.positionUs);
    }

    public final long getBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.bufferedPositionUs);
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    public final boolean isCurrentWindowDynamic() {
        Timeline timeline = this.playbackInfo.timeline;
        return !timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    public final boolean isCurrentWindowSeekable() {
        Timeline timeline = this.playbackInfo.timeline;
        return !timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    public final boolean isPlayingAd() {
        return !shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    public final int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public final int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public final long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        this.playbackInfo.timeline.getPeriod(this.playbackInfo.periodId.periodIndex, this.period);
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.contentPositionUs);
    }

    public final int getRendererCount() {
        return this.renderers.length;
    }

    public final int getRendererType(int i) {
        return this.renderers[i].getTrackType();
    }

    public final TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    public final TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    public final Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    public final Object getCurrentManifest() {
        return this.playbackInfo.manifest;
    }

    /* access modifiers changed from: package-private */
    public final void handleEvent(Message message) {
        int i = message.what;
        boolean z = true;
        if (i == 0) {
            PlaybackInfo playbackInfo2 = (PlaybackInfo) message.obj;
            int i2 = message.arg1;
            if (message.arg2 == -1) {
                z = false;
            }
            handlePlaybackInfo(playbackInfo2, i2, z, message.arg2);
        } else if (i == 1) {
            PlaybackParameters playbackParameters2 = (PlaybackParameters) message.obj;
            if (!this.playbackParameters.equals(playbackParameters2)) {
                this.playbackParameters = playbackParameters2;
                Iterator<Player.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onPlaybackParametersChanged(playbackParameters2);
                }
            }
        } else if (i == 2) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
            this.playbackError = exoPlaybackException;
            Iterator<Player.EventListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onPlayerError(exoPlaybackException);
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo2, int i, boolean z, int i2) {
        this.pendingOperationAcks -= i;
        if (this.pendingOperationAcks == 0) {
            if (playbackInfo2.startPositionUs == C.TIME_UNSET) {
                playbackInfo2 = playbackInfo2.fromNewPosition(playbackInfo2.periodId, 0, playbackInfo2.contentPositionUs);
            }
            PlaybackInfo playbackInfo3 = playbackInfo2;
            if ((!this.playbackInfo.timeline.isEmpty() || this.hasPendingPrepare) && playbackInfo3.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0;
            }
            int i3 = this.hasPendingPrepare ? 0 : 2;
            boolean z2 = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            updatePlaybackInfo(playbackInfo3, z, i2, i3, z2, false);
        }
    }

    private PlaybackInfo getResetPlaybackInfo(boolean z, boolean z2, int i) {
        if (z) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0;
        } else {
            this.maskingWindowIndex = getCurrentWindowIndex();
            this.maskingPeriodIndex = getCurrentPeriodIndex();
            this.maskingWindowPositionMs = getCurrentPosition();
        }
        return new PlaybackInfo(z2 ? Timeline.EMPTY : this.playbackInfo.timeline, z2 ? null : this.playbackInfo.manifest, this.playbackInfo.periodId, this.playbackInfo.startPositionUs, this.playbackInfo.contentPositionUs, i, false, z2 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, z2 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult);
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, boolean z, int i, int i2, boolean z2, boolean z3) {
        boolean z4 = !this.pendingPlaybackInfoUpdates.isEmpty();
        this.pendingPlaybackInfoUpdates.addLast(new PlaybackInfoUpdate(playbackInfo2, this.playbackInfo, this.listeners, this.trackSelector, z, i, i2, z2, this.playWhenReady, z3));
        this.playbackInfo = playbackInfo2;
        if (!z4) {
            while (!this.pendingPlaybackInfoUpdates.isEmpty()) {
                this.pendingPlaybackInfoUpdates.peekFirst().notifyListeners();
                this.pendingPlaybackInfoUpdates.removeFirst();
            }
        }
    }

    private long playbackInfoPositionUsToWindowPositionMs(long j) {
        long usToMs = C.usToMs(j);
        if (this.playbackInfo.periodId.isAd()) {
            return usToMs;
        }
        this.playbackInfo.timeline.getPeriod(this.playbackInfo.periodId.periodIndex, this.period);
        return usToMs + this.period.getPositionInWindowMs();
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    private static final class PlaybackInfoUpdate {
        private final boolean isLoadingChanged;
        private final Set<Player.EventListener> listeners;
        private final boolean playWhenReady;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateOrPlayWhenReadyChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineOrManifestChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, Set<Player.EventListener> set, TrackSelector trackSelector2, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4) {
            this.playbackInfo = playbackInfo2;
            this.listeners = set;
            this.trackSelector = trackSelector2;
            this.positionDiscontinuity = z;
            this.positionDiscontinuityReason = i;
            this.timelineChangeReason = i2;
            this.seekProcessed = z2;
            this.playWhenReady = z3;
            boolean z5 = false;
            this.playbackStateOrPlayWhenReadyChanged = z4 || playbackInfo3.playbackState != playbackInfo2.playbackState;
            this.timelineOrManifestChanged = (playbackInfo3.timeline == playbackInfo2.timeline && playbackInfo3.manifest == playbackInfo2.manifest) ? false : true;
            this.isLoadingChanged = playbackInfo3.isLoading != playbackInfo2.isLoading;
            this.trackSelectorResultChanged = playbackInfo3.trackSelectorResult != playbackInfo2.trackSelectorResult ? true : z5;
        }

        public final void notifyListeners() {
            if (this.timelineOrManifestChanged || this.timelineChangeReason == 0) {
                for (Player.EventListener onTimelineChanged : this.listeners) {
                    onTimelineChanged.onTimelineChanged(this.playbackInfo.timeline, this.playbackInfo.manifest, this.timelineChangeReason);
                }
            }
            if (this.positionDiscontinuity) {
                for (Player.EventListener onPositionDiscontinuity : this.listeners) {
                    onPositionDiscontinuity.onPositionDiscontinuity(this.positionDiscontinuityReason);
                }
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                for (Player.EventListener onTracksChanged : this.listeners) {
                    onTracksChanged.onTracksChanged(this.playbackInfo.trackGroups, this.playbackInfo.trackSelectorResult.selections);
                }
            }
            if (this.isLoadingChanged) {
                for (Player.EventListener onLoadingChanged : this.listeners) {
                    onLoadingChanged.onLoadingChanged(this.playbackInfo.isLoading);
                }
            }
            if (this.playbackStateOrPlayWhenReadyChanged) {
                for (Player.EventListener onPlayerStateChanged : this.listeners) {
                    onPlayerStateChanged.onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
                }
            }
            if (this.seekProcessed) {
                for (Player.EventListener onSeekProcessed : this.listeners) {
                    onSeekProcessed.onSeekProcessed();
                }
            }
        }
    }
}
