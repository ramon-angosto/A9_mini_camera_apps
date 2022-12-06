package com.bykv.vk.openvk.component.video.a.d;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.f.c;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AndroidMediaPlayer */
public class b extends a {
    private final MediaPlayer b;
    private final a c;
    private com.bykv.vk.openvk.component.video.a.a.a d;
    private Surface e;
    private final Object f = new Object();
    private volatile boolean g;

    public b() {
        synchronized (this.f) {
            this.b = new MediaPlayer();
        }
        a(this.b);
        try {
            this.b.setAudioStreamType(3);
        } catch (Throwable th) {
            c.c("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.c = new a(this);
        p();
    }

    private void a(MediaPlayer mediaPlayer) {
        Field declaredField;
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 28) {
            try {
                Class<?> cls = Class.forName("android.media.MediaTimeProvider");
                Class<?> cls2 = Class.forName("android.media.SubtitleController");
                Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
                Object newInstance = cls2.getConstructor(new Class[]{Context.class, cls, Class.forName("android.media.SubtitleController$Listener")}).newInstance(new Object[]{com.bykv.vk.openvk.component.video.api.b.a(), null, null});
                declaredField = cls2.getDeclaredField("mHandler");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", new Class[]{cls2, cls3}).invoke(mediaPlayer, new Object[]{newInstance, null});
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "setSubtitleController error: ", th);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f) {
            try {
                if (!this.g && surfaceHolder != null && surfaceHolder.getSurface() != null && this.a) {
                    this.b.setDisplay(surfaceHolder);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(Surface surface) {
        q();
        this.e = surface;
        this.b.setSurface(surface);
    }

    public void a(String str) throws Throwable {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.b.setDataSource(str);
        } else {
            this.b.setDataSource(parse.getPath());
        }
    }

    public void a(FileDescriptor fileDescriptor) throws Throwable {
        this.b.setDataSource(fileDescriptor);
    }

    public synchronized void a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.d = com.bykv.vk.openvk.component.video.a.a.a.a(com.bykv.vk.openvk.component.video.api.b.a(), cVar);
        com.bykv.vk.openvk.component.video.a.a.b.c.a(cVar);
        this.b.setDataSource(this.d);
    }

    private void o() {
        com.bykv.vk.openvk.component.video.a.a.a aVar;
        if (Build.VERSION.SDK_INT >= 23 && (aVar = this.d) != null) {
            try {
                aVar.close();
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
            }
            this.d = null;
        }
    }

    public void e() throws Throwable {
        this.b.start();
    }

    public void f() throws Throwable {
        this.b.stop();
    }

    public void g() throws Throwable {
        this.b.pause();
    }

    public void h() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    public void b(boolean z) throws Throwable {
        this.b.setScreenOnWhilePlaying(z);
    }

    public void a(long j) throws Throwable {
        this.b.seekTo((int) j);
    }

    public long i() {
        try {
            return (long) this.b.getCurrentPosition();
        } catch (Throwable th) {
            c.c("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0;
        }
    }

    public long j() {
        try {
            return (long) this.b.getDuration();
        } catch (Throwable th) {
            c.c("CSJ_VIDEO", "getDuration error: ", th);
            return 0;
        }
    }

    public void k() throws Throwable {
        synchronized (this.f) {
            if (!this.g) {
                this.b.release();
                this.g = true;
                q();
                o();
                a();
                p();
            }
        }
    }

    public void l() throws Throwable {
        try {
            this.b.reset();
        } catch (Throwable th) {
            c.c("CSJ_VIDEO", "reset error: ", th);
        }
        o();
        a();
        p();
    }

    public void c(boolean z) throws Throwable {
        this.b.setLooping(z);
    }

    public void d(boolean z) throws Throwable {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.setVolume(0.0f, 0.0f);
            } else {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
        }
    }

    public int m() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public int n() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    private void p() {
        this.b.setOnPreparedListener(this.c);
        this.b.setOnBufferingUpdateListener(this.c);
        this.b.setOnCompletionListener(this.c);
        this.b.setOnSeekCompleteListener(this.c);
        this.b.setOnVideoSizeChangedListener(this.c);
        this.b.setOnErrorListener(this.c);
        this.b.setOnInfoListener(this.c);
    }

    /* compiled from: AndroidMediaPlayer */
    private static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<b> a;

        public a(b bVar) {
            this.a = new WeakReference<>(bVar);
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                c.b("CSJ_VIDEO", "onInfo: ");
                b bVar = (b) this.a.get();
                if (bVar == null || !bVar.b(i, i2)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                c.b("CSJ_VIDEO", "onError: ", Integer.valueOf(i), Integer.valueOf(i2));
                b bVar = (b) this.a.get();
                if (bVar == null || !bVar.a(i, i2)) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                b bVar = (b) this.a.get();
                if (bVar != null) {
                    bVar.a(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                b bVar = (b) this.a.get();
                if (bVar != null) {
                    bVar.d();
                }
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                b bVar = (b) this.a.get();
                if (bVar != null) {
                    bVar.a(i);
                }
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                b bVar = (b) this.a.get();
                if (bVar != null) {
                    bVar.c();
                }
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                b bVar = (b) this.a.get();
                if (bVar != null) {
                    bVar.b();
                }
            } catch (Throwable th) {
                c.c("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        q();
    }

    private void q() {
        try {
            if (this.e != null) {
                this.e.release();
                this.e = null;
            }
        } catch (Throwable unused) {
        }
    }
}
