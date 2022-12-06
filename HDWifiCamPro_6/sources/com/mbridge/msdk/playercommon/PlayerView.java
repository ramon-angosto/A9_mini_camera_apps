package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.b.b;
import com.mbridge.msdk.foundation.tools.k;
import com.mbridge.msdk.foundation.tools.q;

public class PlayerView extends LinearLayout {
    public static final String TAG = "PlayerView";
    /* access modifiers changed from: private */
    public boolean isBTVideo = false;
    /* access modifiers changed from: private */
    public boolean isBTVideoPlaying = false;
    private boolean mInitState = false;
    /* access modifiers changed from: private */
    public boolean mIsCovered = false;
    /* access modifiers changed from: private */
    public boolean mIsFirstCreateHolder = true;
    /* access modifiers changed from: private */
    public boolean mIsNeedToRepeatPrepare = false;
    /* access modifiers changed from: private */
    public boolean mIsSurfaceHolderDestoryed = false;
    private LinearLayout mLlSurContainer;
    private LinearLayout mLoadingView;
    private String mPlayUrl;
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder;
    /* access modifiers changed from: private */
    public VideoFeedsPlayer mVideoFeedsPlayer;

    public PlayerView(Context context) {
        super(context);
        init();
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setIsBTVideo(boolean z) {
        this.isBTVideo = z;
    }

    public void setIsBTVideoPlaying(boolean z) {
        this.isBTVideoPlaying = z;
    }

    private void init() {
        try {
            initView();
            initPlayer();
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void initPlayer() {
        this.mVideoFeedsPlayer = new VideoFeedsPlayer();
    }

    public void addSurfaceView() {
        try {
            q.b(TAG, "addSurfaceView");
            SurfaceView surfaceView = new SurfaceView(getContext().getApplicationContext());
            this.mSurfaceHolder = surfaceView.getHolder();
            this.mSurfaceHolder.setType(3);
            this.mSurfaceHolder.setKeepScreenOn(true);
            this.mSurfaceHolder.addCallback(new MySurfaceHoldeCallback());
            this.mLlSurContainer.addView(surfaceView, -1, -1);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void removeSurface() {
        try {
            q.b(TAG, "removeSurface");
            this.mLlSurContainer.removeAllViews();
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(k.a(getContext(), "mbridge_playercommon_player_view", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        if (inflate != null) {
            this.mLlSurContainer = (LinearLayout) inflate.findViewById(k.a(getContext(), "mbridge_playercommon_ll_sur_container", "id"));
            this.mLoadingView = (LinearLayout) inflate.findViewById(k.a(getContext(), "mbridge_playercommon_ll_loading", "id"));
            addSurfaceView();
            addView(inflate, -1, -1);
        }
    }

    public boolean initVFPData(String str, String str2, VideoPlayerStatusListener videoPlayerStatusListener) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mPlayUrl = str;
        this.mVideoFeedsPlayer.initPlayer(getContext(), this.mLoadingView, str, videoPlayerStatusListener);
        this.mInitState = true;
        return true;
    }

    public boolean playVideo(int i) {
        try {
            if (this.mVideoFeedsPlayer == null || !this.mInitState) {
                return false;
            }
            this.mVideoFeedsPlayer.play(this.mPlayUrl, i);
            this.mIsNeedToRepeatPrepare = false;
            return true;
        } catch (Throwable th) {
            q.a(TAG, th.getMessage(), th);
            return false;
        }
    }

    public boolean playVideo() {
        return playVideo(0);
    }

    public void onPause() {
        try {
            pause();
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.setIsFrontDesk(false);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.pause();
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void resumeStart() {
        try {
            start(true);
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void setDataSource() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.showLoading();
                this.mVideoFeedsPlayer.setDataSource();
                this.mIsNeedToRepeatPrepare = false;
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void start(boolean z) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.start(z);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void prepare() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.prepare();
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void start(int i) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.start(i);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void justSeekTo(int i) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.justSeekTo(i);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void seekTo(int i) {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.seekTo(i);
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void stop() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.stop();
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void openSound() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.openSound();
        }
    }

    public void closeSound() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.closeSound();
        }
    }

    public void setDesk(boolean z) {
        this.mVideoFeedsPlayer.setIsFrontDesk(z);
    }

    public void onResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer != null && !this.mIsFirstCreateHolder && !this.mIsSurfaceHolderDestoryed && !isComplete()) {
                if (this.mVideoFeedsPlayer.hasPrepare()) {
                    resumeStart();
                } else {
                    playVideo(0);
                }
            }
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public void coverUnlockResume() {
        try {
            this.mVideoFeedsPlayer.setIsFrontDesk(true);
            if (this.mVideoFeedsPlayer != null) {
                if (this.mVideoFeedsPlayer.hasPrepare()) {
                    if (!this.mIsNeedToRepeatPrepare) {
                        start(true);
                        return;
                    }
                }
                playVideo(0);
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public void release() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                this.mVideoFeedsPlayer.releasePlayer();
            }
            if (this.mSurfaceHolder != null) {
                this.mSurfaceHolder.getSurface().release();
            }
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
        }
    }

    public int getCurPosition() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                return this.mVideoFeedsPlayer.getCurPosition();
            }
            return 0;
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
            return 0;
        }
    }

    public int getDuration() {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            return videoFeedsPlayer.getDuration();
        }
        return 0;
    }

    private class MySurfaceHoldeCallback implements SurfaceHolder.Callback {
        private MySurfaceHoldeCallback() {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            try {
                if (!(PlayerView.this.mVideoFeedsPlayer == null || surfaceHolder == null)) {
                    SurfaceHolder unused = PlayerView.this.mSurfaceHolder = surfaceHolder;
                    PlayerView.this.mVideoFeedsPlayer.setDisplay(surfaceHolder);
                }
                boolean unused2 = PlayerView.this.mIsFirstCreateHolder = false;
            } catch (Exception e) {
                q.d(PlayerView.TAG, e.getMessage());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            try {
                boolean unused = PlayerView.this.mIsSurfaceHolderDestoryed = true;
                boolean unused2 = PlayerView.this.mIsNeedToRepeatPrepare = true;
                PlayerView.this.mVideoFeedsPlayer.pause();
            } catch (Exception e) {
                q.d(PlayerView.TAG, e.getMessage());
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            try {
                if (PlayerView.this.mIsSurfaceHolderDestoryed && !PlayerView.this.mIsCovered && !PlayerView.this.isComplete() && !PlayerView.this.isBTVideo && !b.c) {
                    if (PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                        PlayerView.this.resumeStart();
                    } else {
                        PlayerView.this.playVideo(0);
                    }
                    if (PlayerView.this.isBTVideo) {
                        if (PlayerView.this.isBTVideoPlaying) {
                            if (!PlayerView.this.mVideoFeedsPlayer.hasPrepare()) {
                                PlayerView.this.mVideoFeedsPlayer.prepare();
                            }
                            PlayerView.this.mVideoFeedsPlayer.start(false);
                        } else {
                            PlayerView.this.pause();
                        }
                    }
                }
                boolean unused = PlayerView.this.mIsSurfaceHolderDestoryed = false;
            } catch (Exception e) {
                q.d(PlayerView.TAG, e.getMessage());
            }
        }
    }

    public boolean isComplete() {
        try {
            return this.mVideoFeedsPlayer != null && this.mVideoFeedsPlayer.isComplete();
        } catch (Throwable th) {
            q.a(TAG, th.getMessage(), th);
            return false;
        }
    }

    public void initBufferIngParam(int i) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.initBufferIngParam(i);
        }
    }

    public boolean isPlayIng() {
        try {
            if (this.mVideoFeedsPlayer != null) {
                return this.mVideoFeedsPlayer.isPlayIng();
            }
            return false;
        } catch (Throwable th) {
            q.d(TAG, th.getMessage());
            return false;
        }
    }

    public void setIsCovered(boolean z) {
        try {
            this.mIsCovered = z;
        } catch (Exception e) {
            q.d(TAG, e.getMessage());
        }
    }

    public boolean isSilent() {
        return this.mVideoFeedsPlayer.isSilent();
    }

    public void setVolume(float f, float f2) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setVolume(f, f2);
        }
    }

    public void setPlaybackParams(float f) {
        VideoFeedsPlayer videoFeedsPlayer = this.mVideoFeedsPlayer;
        if (videoFeedsPlayer != null) {
            videoFeedsPlayer.setPlaybackParams(f);
        }
    }
}
