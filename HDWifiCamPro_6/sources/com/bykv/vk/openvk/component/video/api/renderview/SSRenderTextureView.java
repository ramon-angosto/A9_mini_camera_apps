package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.f.c;
import com.bykv.vk.openvk.component.video.api.renderview.b;

public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, b {
    private a a;
    private b.a b;

    public SurfaceHolder getHolder() {
        return null;
    }

    public View getView() {
        return this;
    }

    public SSRenderTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(a aVar) {
        this.a = aVar;
        setSurfaceTextureListener(this);
    }

    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
            if (c.c()) {
                c.b("CSJ_VIDEO_TextureView", "rethrow exception for debug & local_test, (TextureView)", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        c.b("CSJ_VIDEO_TextureView", "onSurfaceTextureAvailable: ");
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(surfaceTexture, i, i2);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        c.b("CSJ_VIDEO_TextureView", "onSurfaceTextureSizeChanged: ");
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(surfaceTexture, i, i2);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        c.b("CSJ_VIDEO_TextureView", "onSurfaceTextureDestroyed: ");
        a aVar = this.a;
        if (aVar != null) {
            return aVar.a(surfaceTexture);
        }
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.b(surfaceTexture);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.b = aVar;
    }
}
