package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import com.mbridge.msdk.foundation.same.report.d;
import com.mbridge.msdk.foundation.tools.m;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory;
import com.mbridge.msdk.playercommon.exoplayer2.LoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.RenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VideoFeedsPlayer implements Player.EventListener {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final String TAG = "VideoFeedsPlayer";
    /* access modifiers changed from: private */
    public SimpleExoPlayer exoPlayer;
    private boolean isStart = false;
    private int mBufferTime = 5;
    private Timer mBufferTimeoutTimer;
    /* access modifiers changed from: private */
    public long mCurrentPosition;
    /* access modifiers changed from: private */
    public View mFullScreenLoadingView;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    /* access modifiers changed from: private */
    public boolean mHasPrepare = false;
    /* access modifiers changed from: private */
    public volatile VideoPlayerStatusListener mInnerVFPLisener;
    /* access modifiers changed from: private */
    public boolean mIsBuffering = false;
    /* access modifiers changed from: private */
    public boolean mIsComplete = false;
    private boolean mIsFrontDesk = true;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsPlaying = false;
    private boolean mIsSilent;
    /* access modifiers changed from: private */
    public WeakReference<View> mLoadingView;
    private Object mLock = new Object();
    /* access modifiers changed from: private */
    public volatile VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private SurfaceHolder mSurfaceHolder;
    private MediaSource mediaSource;
    private Runnable playProgressRunnable = new Runnable() {
        public void run() {
            long j;
            try {
                if (VideoFeedsPlayer.this.exoPlayer != null && VideoFeedsPlayer.this.exoPlayerIsPlaying()) {
                    long unused = VideoFeedsPlayer.this.mCurrentPosition = VideoFeedsPlayer.this.exoPlayer.getCurrentPosition();
                    float access$100 = (float) (VideoFeedsPlayer.this.mCurrentPosition % 1000);
                    int round = Math.round(((float) VideoFeedsPlayer.this.mCurrentPosition) / 1000.0f);
                    if (VideoFeedsPlayer.this.exoPlayer == null || VideoFeedsPlayer.this.exoPlayer.getDuration() <= 0) {
                        j = 0;
                    } else {
                        j = VideoFeedsPlayer.this.exoPlayer.getDuration() / 1000;
                        if (access$100 > 0.0f && access$100 < 500.0f) {
                            round++;
                        }
                    }
                    if (round >= 0 && j > 0 && ((long) round) < 1 + j) {
                        VideoFeedsPlayer.this.postOnPlayProgressOnMainThread(round, (int) j);
                    }
                    boolean unused2 = VideoFeedsPlayer.this.mIsComplete = false;
                    if (!VideoFeedsPlayer.this.mIsBuffering) {
                        VideoFeedsPlayer.this.hideLoading();
                    }
                    VideoFeedsPlayer.this.mHandler.postDelayed(this, 1000);
                }
            } catch (Exception e) {
                q.d(VideoFeedsPlayer.TAG, e.getMessage());
            }
        }
    };

    public void onBufferingUpdate(int i) {
    }

    public void onLoadingChanged(boolean z) {
    }

    public void onPositionDiscontinuity(int i) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public void onTimelineChanged(Timeline timeline, Object obj, int i) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public boolean initPlayer(Context context, View view, String str, VideoPlayerStatusListener videoPlayerStatusListener) {
        if (view == null) {
            try {
                q.b(TAG, "loadingView is NULL");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            } catch (Throwable th) {
                q.d(TAG, th.getMessage());
                postOnPlayErrorOnMainThread(th.toString());
                return false;
            }
        } else {
            this.mOutterVFListener = videoPlayerStatusListener;
            this.mLoadingView = new WeakReference<>(view);
            this.exoPlayer = ExoPlayerFactory.newSimpleInstance((RenderersFactory) new DefaultRenderersFactory(context), (TrackSelector) new DefaultTrackSelector(), (LoadControl) new DefaultLoadControl());
            this.mediaSource = new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(context, "MBridge_ExoPlayer")).createMediaSource(Uri.parse(str));
            this.exoPlayer.setRepeatMode(0);
            this.exoPlayer.prepare(this.mediaSource);
            this.exoPlayer.addListener(this);
            return true;
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        try {
            this.exoPlayer.getVideoComponent().setVideoSurfaceHolder(surfaceHolder);
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
        }
    }

    public void play(String str, int i) {
        try {
            synchronized (this.mLock) {
                if (i > 0) {
                    this.mCurrentPosition = (long) i;
                }
                if (TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                showLoading();
                setDataSource();
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void play(String str, SurfaceHolder surfaceHolder) {
        try {
            synchronized (this.mLock) {
                if (TextUtils.isEmpty(str)) {
                    postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                    return;
                }
                this.mPlayUrl = str;
                this.mHasPrepare = false;
                this.mIsFrontDesk = true;
                this.mSurfaceHolder = surfaceHolder;
                showLoading();
                setDataSource();
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void cancelBufferTimeoutTimer() {
        try {
            if (this.mBufferTimeoutTimer != null) {
                this.mBufferTimeoutTimer.cancel();
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void startBufferIngTimer(final String str) {
        if (this.mIsNeedBufferingTimeout) {
            cancelBufferTimeoutTimer();
            this.mBufferTimeoutTimer = new Timer();
            this.mBufferTimeoutTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        if (!VideoFeedsPlayer.this.mHasPrepare || VideoFeedsPlayer.this.mIsBuffering) {
                            VideoFeedsPlayer.this.postOnBufferingStarOnMainThread(str);
                        }
                    } catch (Exception e) {
                        q.d(VideoFeedsPlayer.TAG, e.getMessage());
                    }
                }
            }, (long) (this.mBufferTime * 1000));
        }
    }

    public void initBufferIngParam(int i) {
        if (i > 0) {
            this.mBufferTime = i;
        }
        this.mIsNeedBufferingTimeout = true;
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0;
            hideLoading();
            postOnPlayCompletedOnMainThread();
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void onPrepared() {
        try {
            if (!this.mIsFrontDesk) {
                q.d(TAG, "At background, Do not process");
            } else if (this.mIsFrontDesk) {
                hideLoading();
                this.mHasPrepare = true;
                if (this.exoPlayer != null) {
                    this.mIsPlaying = true;
                    if (!this.isStart) {
                        postOnPlayStartOnMainThread(this.exoPlayer.getDuration() / 1000);
                        q.b(TAG, "onPlayStarted()，getCurrentPosition:" + this.exoPlayer.getCurrentPosition());
                        this.isStart = true;
                    }
                }
                postOnBufferinEndOnMainThread();
                startPlayProgressTimer();
                q.b(TAG, "onPrepare mCurrentPosition:" + this.mCurrentPosition + " onPrepare mHasPrepare：" + this.mHasPrepare);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void showLoading() {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                            VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(0);
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void hideLoading() {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (!(VideoFeedsPlayer.this.mLoadingView == null || VideoFeedsPlayer.this.mLoadingView.get() == null)) {
                            ((View) VideoFeedsPlayer.this.mLoadingView.get()).setVisibility(8);
                        }
                        if (VideoFeedsPlayer.this.mFullScreenLoadingView != null) {
                            VideoFeedsPlayer.this.mFullScreenLoadingView.setVisibility(8);
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(final int i, final int i2) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayProgress(i, i2);
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayProgress(i, i2);
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(final String str) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onBufferingStart(str);
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingStart(str);
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onBufferingEnd();
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onBufferingEnd();
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayStartOnMainThread(final long j) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        int i = (int) j;
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayStarted(i);
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayStarted(i);
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayErrorOnMainThread(final String str) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayError(str);
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayError(str);
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
            d.a(94, this.mPlayUrl, str);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(final String str) {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        if (VideoFeedsPlayer.this.mOutterVFListener != null) {
                            try {
                                VideoFeedsPlayer.this.mOutterVFListener.onPlayCompleted();
                            } catch (Exception e) {
                                q.d(VideoFeedsPlayer.TAG, e.getMessage());
                            }
                        }
                        if (VideoFeedsPlayer.this.mInnerVFPLisener != null) {
                            try {
                                VideoFeedsPlayer.this.mInnerVFPLisener.onPlayCompleted();
                            } catch (Exception e2) {
                                q.d(VideoFeedsPlayer.TAG, e2.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && exoPlayerIsPlaying()) {
                q.b(TAG, "pause isPalying:" + exoPlayerIsPlaying() + " mIsPlaying:" + this.mIsPlaying);
                hideLoading();
                this.exoPlayer.setPlayWhenReady(false);
                this.mIsPlaying = false;
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void prepare() {
        try {
            if (!this.mHasPrepare && this.exoPlayer != null) {
                this.exoPlayer.prepare(this.mediaSource);
                this.mHasPrepare = true;
                this.mIsPlaying = false;
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && exoPlayerIsPlaying()) {
                hideLoading();
                this.exoPlayer.stop();
                this.mHasPrepare = false;
                this.mIsPlaying = false;
                this.mIsComplete = true;
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void start(boolean z) {
        try {
            if (this.mHasPrepare && this.exoPlayer != null && !exoPlayerIsPlaying()) {
                showLoading();
                play();
                this.mIsPlaying = true;
                if (z) {
                    startPlayProgressTimer();
                }
                q.b(TAG, "start");
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void start(int i) {
        try {
            if (!this.mHasPrepare || this.exoPlayer == null || exoPlayerIsPlaying()) {
                return;
            }
            if (i > 0) {
                this.exoPlayer.seekTo((long) i);
                play();
                return;
            }
            play();
            this.mIsPlaying = true;
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void justSeekTo(int i) {
        try {
            this.mCurrentPosition = (long) i;
            if (this.mHasPrepare) {
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void seekTo(int i) {
        long j = (long) i;
        try {
            this.mCurrentPosition = j;
            if (this.mHasPrepare && this.exoPlayer != null) {
                this.exoPlayer.seekTo(j);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void setDataSource() {
        try {
            if (this.exoPlayer != null) {
                if (this.mSurfaceHolder != null) {
                    setDisplay(this.mSurfaceHolder);
                }
                this.mHasPrepare = false;
                this.exoPlayer.prepare(this.mediaSource);
                this.exoPlayer.setPlayWhenReady(true);
                startBufferIngTimer(PlayerErrorConstant.PREPARE_TIMEOUT);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
            postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.ILLEGAL_VIDEO_ADDRESS);
        }
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void releasePlayer() {
        try {
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.removeListener(this);
                this.exoPlayer.release();
                this.mInnerVFPLisener = null;
                this.mOutterVFListener = null;
            }
            hideLoading();
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void closeSound() {
        try {
            if (this.exoPlayer != null) {
                this.exoPlayer.setVolume(0.0f);
                this.mIsSilent = true;
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void openSound() {
        try {
            if (this.exoPlayer != null) {
                this.exoPlayer.setVolume(1.0f);
                this.mIsSilent = false;
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public boolean isPlayIng() {
        try {
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
            return false;
        }
    }

    public boolean onError(int i, String str) {
        try {
            hideLoading();
            if (!this.mIsFrontDesk && "MIX 3".equalsIgnoreCase(m.a()) && m.c().equalsIgnoreCase("Xiaomi")) {
                return true;
            }
            this.mHasPrepare = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void setIsFrontDesk(boolean z) {
        try {
            this.mIsFrontDesk = z;
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public void setIsComplete(boolean z) {
        this.mIsComplete = z;
    }

    public void setFullScreenLoadingView(View view) {
        if (view != null) {
            try {
                this.mFullScreenLoadingView = view;
            } catch (Exception e) {
                q.d(TAG, e.getMessage());
            }
        }
    }

    public boolean fullScreenLoadingViewisVisible() {
        try {
            if (this.mFullScreenLoadingView == null || this.mFullScreenLoadingView.getVisibility() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return false;
        }
    }

    public boolean halfLoadingViewisVisible() {
        try {
            if (this.mLoadingView == null || this.mLoadingView.get() == null || ((View) this.mLoadingView.get()).getVisibility() != 0) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return false;
        }
    }

    public boolean isSilent() {
        return this.mIsSilent;
    }

    public int getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer == null) {
            return 0;
        }
        simpleExoPlayer.getDuration();
        return 0;
    }

    public void setVolume(float f, float f2) {
        try {
            if (this.exoPlayer != null) {
                this.exoPlayer.setVolume(f2);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void setPlaybackParams(float f) {
        try {
            if (exoPlayerIsPlaying()) {
                this.exoPlayer.setPlaybackParameters(new PlaybackParameters(f));
                return;
            }
            this.exoPlayer.setPlaybackParameters(new PlaybackParameters(f));
            this.exoPlayer.stop();
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public boolean exoPlayerIsPlaying() {
        return this.exoPlayer.getPlaybackState() == 3 && this.exoPlayer.getPlayWhenReady();
    }

    public void play() {
        this.exoPlayer.setPlayWhenReady(true);
    }

    public void onPlayerStateChanged(boolean z, int i) {
        q.d(TAG, "onPlaybackStateChanged : " + i);
        if (i == 1) {
            q.d(TAG, "onPlaybackStateChanged : IDLE");
        } else if (i == 2) {
            q.d(TAG, "onPlaybackStateChanged : Buffering");
            this.mIsBuffering = true;
            showLoading();
            startBufferIngTimer(PlayerErrorConstant.PLAYERING_TIMEOUT);
        } else if (i == 3) {
            q.d(TAG, "onPlaybackStateChanged : READY");
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
        } else if (i == 4) {
            q.d(TAG, "onPlaybackStateChanged : Ended : PLAY ENDED");
            cancelPlayProgressTimer();
            onCompletion();
        }
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        String str;
        if (exoPlaybackException != null) {
            int i = exoPlaybackException.type;
            if (i == 0) {
                str = "Play error, because have a SourceException.";
            } else if (i == 1) {
                str = "Play error, because have a RendererException.";
            } else if (i == 2) {
                str = "Play error, because have a UnexpectedException.";
            }
            if (exoPlaybackException.getCause() != null && !TextUtils.isEmpty(exoPlaybackException.getCause().getMessage())) {
                str = exoPlaybackException.getCause().getMessage();
            }
            q.d(TAG, "onPlayerError : " + str);
            onError(exoPlaybackException.type, str);
        }
        str = "Play error and ExoPlayer have not message.";
        str = exoPlaybackException.getCause().getMessage();
        q.d(TAG, "onPlayerError : " + str);
        onError(exoPlaybackException.type, str);
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        q.d(TAG, "onPlaybackParametersChanged : " + playbackParameters.speed);
    }
}
