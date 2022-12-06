package com.bykv.vk.openvk.component.video.api.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: IMediaLayout */
public interface b<T> extends com.bykv.vk.openvk.component.video.api.b.a {

    /* compiled from: IMediaLayout */
    public enum a {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn
    }

    void a();

    void a(Drawable drawable);

    void a(T t, WeakReference<Context> weakReference, boolean z);

    void a(boolean z);

    void b();

    View c();
}
