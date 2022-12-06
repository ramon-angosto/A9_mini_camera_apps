package com.bykv.vk.openvk.component.video.api.renderview;

import android.view.SurfaceHolder;
import android.view.View;

/* compiled from: IRenderView */
public interface b {

    /* compiled from: IRenderView */
    public interface a {
        void a(int i);
    }

    void a(int i, int i2);

    void a(a aVar);

    SurfaceHolder getHolder();

    View getView();

    void setVisibility(int i);
}
