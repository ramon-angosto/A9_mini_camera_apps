package com.bykv.vk.openvk.component.video.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.c.c;

/* compiled from: IVideoPlayer */
public interface a {

    /* renamed from: com.bykv.vk.openvk.component.video.api.a$a  reason: collision with other inner class name */
    /* compiled from: IVideoPlayer */
    public interface C0020a {
        void a(a aVar);

        void a(a aVar, int i);

        void a(a aVar, int i, int i2);

        void a(a aVar, int i, int i2, int i3);

        void a(a aVar, long j);

        void a(a aVar, long j, long j2);

        void a(a aVar, com.bykv.vk.openvk.component.video.api.c.a aVar2);

        void a(a aVar, boolean z);

        void b(a aVar);

        void b(a aVar, int i);

        void c(a aVar);

        void d(a aVar);

        void e(a aVar);
    }

    void a();

    void a(long j);

    void a(SurfaceTexture surfaceTexture);

    void a(SurfaceHolder surfaceHolder);

    void a(C0020a aVar);

    void a(c cVar);

    void a(boolean z);

    void a(boolean z, long j, boolean z2);

    void b();

    void b(boolean z);

    void c();

    void d();

    boolean e();

    SurfaceHolder f();

    SurfaceTexture g();

    boolean h();

    boolean i();

    int j();

    int k();

    boolean l();

    boolean m();

    boolean n();

    long o();

    int p();

    long q();
}
