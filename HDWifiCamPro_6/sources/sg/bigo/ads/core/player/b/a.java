package sg.bigo.ads.core.player.b;

import android.media.MediaPlayer;
import android.os.SystemClock;
import java.io.IOException;
import sg.bigo.ads.common.f.c;
import sg.bigo.ads.common.utils.o;

public final class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    MediaPlayer a = new MediaPlayer();
    /* access modifiers changed from: package-private */
    public C0147a b;
    /* access modifiers changed from: package-private */
    public int c = 0;
    boolean d;
    boolean e;
    /* access modifiers changed from: package-private */
    public final Runnable f = new Runnable() {
        public final void run() {
            if (a.this.b != null) {
                a.this.b.e();
            }
            if (a.this.c != 3 && a.this.c != 4 && a.this.c != 5) {
                c.a(2, a.this.f, 500);
            }
        }
    };
    private long g;
    private boolean h = false;

    /* renamed from: sg.bigo.ads.core.player.b.a$a  reason: collision with other inner class name */
    public interface C0147a {
        void a();

        void a(MediaPlayer mediaPlayer);

        boolean a(int i);

        boolean a(int i, int i2);

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    public a() {
        this.a.setOnCompletionListener(this);
        this.a.setOnErrorListener(this);
        this.a.setOnInfoListener(this);
        this.a.setOnPreparedListener(this);
        this.a.setOnVideoSizeChangedListener(this);
        this.a.setOnBufferingUpdateListener(this);
    }

    /* access modifiers changed from: private */
    public boolean b(String str) {
        try {
            if (!this.e) {
                sg.bigo.ads.common.k.a.b("MediaPlayerWrapper", "Surface is not available, setDataSource cancel");
                return false;
            }
            sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "player setDataSource, path = ".concat(String.valueOf(str)));
            this.a.reset();
            this.a.setDataSource(str);
            return true;
        } catch (IOException | IllegalArgumentException | IllegalStateException | SecurityException unused) {
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "Player setDataSource failed");
            C0147a aVar = this.b;
            if (aVar != null) {
                aVar.a(1, -1004);
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean g() {
        try {
            sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "prepareAsync");
            this.g = SystemClock.elapsedRealtime();
            this.a.prepareAsync();
            return true;
        } catch (IllegalStateException unused) {
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "Player prepareAsync failed");
            return false;
        }
    }

    public final void a(final String str) {
        if (o.b(str)) {
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "invalidate file path, set data source failed");
        } else {
            c.a(1, new Runnable() {
                public final void run() {
                    if (a.this.b(str)) {
                        boolean unused = a.this.g();
                    }
                }
            });
        }
    }

    public final boolean a() {
        try {
            if (this.d) {
                if (this.e) {
                    if (this.a.isPlaying()) {
                        sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "startAd but is playing, return.");
                        return true;
                    }
                    this.a.start();
                    if (!this.h) {
                        this.h = true;
                        if (this.b != null) {
                            this.b.a();
                        }
                    }
                    this.c = 2;
                    sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "startAd play called ");
                    c.a(this.f);
                    c.a(2, this.f);
                    if (this.b != null) {
                        this.b.b();
                    }
                    return true;
                }
            }
            sg.bigo.ads.common.k.a.b("MediaPlayerWrapper", "Surface is not available or player unprepared, do start play cancel");
            return false;
        } catch (IllegalStateException e2) {
            sg.bigo.ads.common.k.a.a(1, "MediaPlayerWrapper", "Failed to play video: " + e2.getMessage());
            return false;
        }
    }

    public final boolean a(int i) {
        try {
            sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "seekTo : ".concat(String.valueOf(i)));
            this.a.seekTo(i);
            return true;
        } catch (IllegalStateException e2) {
            sg.bigo.ads.common.k.a.a(1, "MediaPlayerWrapper", "The video failed to seek:" + e2.getMessage());
            return false;
        }
    }

    public final boolean a(boolean z) {
        if (!z) {
            try {
                this.a.setVolume(1.0f, 1.0f);
            } catch (IllegalStateException e2) {
                sg.bigo.ads.common.k.a.a(1, "MediaPlayerWrapper", "The video failed to set volume: " + e2.getMessage());
            }
        } else {
            this.a.setVolume(0.0f, 0.0f);
        }
        return z;
    }

    public final boolean b() {
        try {
            this.a.pause();
            c.a(this.f);
            this.c = 3;
            sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "pauseAd play");
            if (this.b != null) {
                this.b.c();
            }
            return true;
        } catch (IllegalStateException e2) {
            sg.bigo.ads.common.k.a.a(1, "MediaPlayerWrapper", "Failed to pause video: " + e2.getMessage());
            return false;
        }
    }

    public final int c() {
        try {
            if (this.d) {
                return this.a.getCurrentPosition();
            }
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "getCurrentPosition failed，not initialize or release already");
            return 0;
        } catch (IllegalStateException unused) {
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "getCurrentPosition IllegalStateException");
            return 0;
        }
    }

    public final boolean d() {
        try {
            this.a.stop();
            c.a(this.f);
            this.c = 4;
            sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "stop play");
            if (this.b != null) {
                this.b.d();
            }
            return true;
        } catch (IllegalStateException e2) {
            sg.bigo.ads.common.k.a.a(1, "MediaPlayerWrapper", "Failed to stop video: " + e2.getMessage());
            return false;
        }
    }

    public final void e() {
        try {
            this.a.release();
            c.a(this.f);
        } catch (IllegalStateException unused) {
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "player release IllegalStateException");
        }
        this.c = 0;
        this.d = false;
        sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "player release called");
    }

    public final int f() {
        try {
            if (this.d) {
                return this.a.getDuration();
            }
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "getDuration failed，not initialize or release already");
            return 0;
        } catch (IllegalStateException unused) {
            sg.bigo.ads.common.k.a.a(0, "MediaPlayerWrapper", "getDuration IllegalStateException");
            return 0;
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "onBufferingUpdate percent = ".concat(String.valueOf(i)));
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        c.a(this.f);
        C0147a aVar = this.b;
        if (aVar != null) {
            this.c = 5;
            aVar.f();
        }
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        C0147a aVar = this.b;
        if (aVar != null) {
            return aVar.a(i, i2);
        }
        c.a(this.f);
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        C0147a aVar = this.b;
        if (aVar != null) {
            return aVar.a(i);
        }
        return false;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        if (!this.e) {
            sg.bigo.ads.common.k.a.b("MediaPlayerWrapper", "Surface is not available, do prepare cancel");
            return;
        }
        this.c = 1;
        this.d = true;
        sg.bigo.ads.common.k.a.a(0, 3, "MediaPlayerWrapper", "onPrepared called cost = " + (SystemClock.elapsedRealtime() - this.g));
        C0147a aVar = this.b;
        if (aVar != null) {
            aVar.a(mediaPlayer);
        }
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        C0147a aVar = this.b;
        if (aVar != null) {
            aVar.g();
        }
    }
}
