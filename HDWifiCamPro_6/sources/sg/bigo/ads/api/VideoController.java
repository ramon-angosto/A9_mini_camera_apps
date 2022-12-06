package sg.bigo.ads.api;

public interface VideoController {

    public interface VideoLifeCallback {
        void onMuteChange(boolean z);

        void onVideoEnd();

        void onVideoPause();

        void onVideoPlay();

        void onVideoStart();
    }

    public interface a extends VideoLifeCallback {
        void a();

        void b();
    }

    public interface b {
        void a(int i, int i2);
    }

    b getProgressChangeListener();

    VideoLifeCallback getVideoLifeCallback();

    boolean isMuted();

    boolean isPaused();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void play();

    void setProgressChangeListener(b bVar);

    void setVideoLifeCallback(VideoLifeCallback videoLifeCallback);
}
