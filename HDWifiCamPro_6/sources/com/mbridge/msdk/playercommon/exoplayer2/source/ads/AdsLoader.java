package com.mbridge.msdk.playercommon.exoplayer2.source.ads;

import android.view.ViewGroup;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdsMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import java.io.IOException;

public interface AdsLoader {

    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    void attachPlayer(ExoPlayer exoPlayer, EventListener eventListener, ViewGroup viewGroup);

    void detachPlayer();

    void handlePrepareError(int i, int i2, IOException iOException);

    void release();

    void setSupportedContentTypes(int... iArr);
}
