package com.bykv.vk.openvk.component.video.a.d;

import com.bykv.vk.openvk.component.video.a.d.c;

/* compiled from: AbstractMediaPlayer */
public abstract class a implements c {
    protected boolean a = false;
    private c.e b;
    private c.b c;
    private c.a d;
    private c.f e;
    private c.g f;
    private c.C0018c g;
    private c.d h;

    public final void a(c.e eVar) {
        this.b = eVar;
    }

    public final void a(c.b bVar) {
        this.c = bVar;
    }

    public final void a(c.a aVar) {
        this.d = aVar;
    }

    public final void a(c.f fVar) {
        this.e = fVar;
    }

    public final void a(c.C0018c cVar) {
        this.g = cVar;
    }

    public final void a(c.d dVar) {
        this.h = dVar;
    }

    public final void a(c.g gVar) {
        this.f = gVar;
    }

    public void a() {
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            if (this.b != null) {
                this.b.b(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        try {
            if (this.c != null) {
                this.c.a(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i) {
        try {
            if (this.d != null) {
                this.d.a(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        try {
            if (this.e != null) {
                this.e.c(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i, int i2, int i3, int i4) {
        try {
            if (this.f != null) {
                this.f.a(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean a(int i, int i2) {
        try {
            return this.g != null && this.g.a(this, i, i2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean b(int i, int i2) {
        try {
            return this.h != null && this.h.b(this, i, i2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.f.c.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    public void a(boolean z) {
        this.a = z;
    }
}
