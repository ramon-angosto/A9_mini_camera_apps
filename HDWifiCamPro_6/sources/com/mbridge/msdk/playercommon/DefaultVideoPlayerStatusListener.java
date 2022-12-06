package com.mbridge.msdk.playercommon;

import com.mbridge.msdk.foundation.tools.q;

public class DefaultVideoPlayerStatusListener implements VideoPlayerStatusListener {
    protected static final String TAG = "DefaultVideoPlayerStatusListener";

    public void onPlayStarted(int i) {
        q.a(TAG, "onPlayStarted:" + i);
    }

    public void onPlayCompleted() {
        q.a(TAG, "onPlayCompleted");
    }

    public void onPlayError(String str) {
        q.a(TAG, "onPlayError:" + str);
    }

    public void onPlayProgress(int i, int i2) {
        q.a(TAG, "onPlayProgress:" + i + ",allDuration:" + i2);
    }

    public void onBufferingStart(String str) {
        q.a(TAG, "OnBufferingStart:" + str);
    }

    public void onBufferingEnd() {
        q.a(TAG, "OnBufferingEnd");
    }

    public void onPlaySetDataSourceError(String str) {
        q.a(TAG, "onPlaySetDataSourceError:" + str);
    }

    public void onPlayProgressMS(int i, int i2) {
        q.a(TAG, "onPlayProgressMS:");
    }
}
