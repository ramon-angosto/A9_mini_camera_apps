package com.bykv.vk.openvk.component.video.a.d;

import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;

/* compiled from: IMediaPlayer */
public interface c {

    /* compiled from: IMediaPlayer */
    public interface a {
        void a(c cVar, int i);
    }

    /* compiled from: IMediaPlayer */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: com.bykv.vk.openvk.component.video.a.d.c$c  reason: collision with other inner class name */
    /* compiled from: IMediaPlayer */
    public interface C0018c {
        boolean a(c cVar, int i, int i2);
    }

    /* compiled from: IMediaPlayer */
    public interface d {
        boolean b(c cVar, int i, int i2);
    }

    /* compiled from: IMediaPlayer */
    public interface e {
        void b(c cVar);
    }

    /* compiled from: IMediaPlayer */
    public interface f {
        void c(c cVar);
    }

    /* compiled from: IMediaPlayer */
    public interface g {
        void a(c cVar, int i, int i2, int i3, int i4);
    }

    void a(long j) throws Throwable;

    void a(Surface surface) throws Throwable;

    void a(SurfaceHolder surfaceHolder) throws Throwable;

    void a(a aVar);

    void a(b bVar);

    void a(C0018c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(com.bykv.vk.openvk.component.video.api.c.c cVar);

    void a(FileDescriptor fileDescriptor) throws Throwable;

    void a(String str) throws Throwable;

    void a(boolean z);

    void b(boolean z) throws Throwable;

    void c(boolean z) throws Throwable;

    void d(boolean z) throws Throwable;

    void e() throws Throwable;

    void f() throws Throwable;

    void g() throws Throwable;

    void h();

    long i() throws Throwable;

    long j() throws Throwable;

    void k() throws Throwable;

    void l() throws Throwable;

    int m();

    int n();
}
