package com.bytedance.sdk.openadsdk;

@Deprecated
public interface TTFeedAd extends TTNativeAd {

    @Deprecated
    public interface VideoAdListener {
        @Deprecated
        void onProgressUpdate(long j, long j2);

        @Deprecated
        void onVideoAdComplete(TTFeedAd tTFeedAd);

        @Deprecated
        void onVideoAdContinuePlay(TTFeedAd tTFeedAd);

        @Deprecated
        void onVideoAdPaused(TTFeedAd tTFeedAd);

        @Deprecated
        void onVideoAdStartPlay(TTFeedAd tTFeedAd);

        @Deprecated
        void onVideoError(int i, int i2);

        @Deprecated
        void onVideoLoad(TTFeedAd tTFeedAd);
    }

    @Deprecated
    double currentPlayTime();

    @Deprecated
    double getVideoDuration();

    @Deprecated
    void pause();

    @Deprecated
    void play();

    @Deprecated
    void setVideoAdListener(VideoAdListener videoAdListener);
}
