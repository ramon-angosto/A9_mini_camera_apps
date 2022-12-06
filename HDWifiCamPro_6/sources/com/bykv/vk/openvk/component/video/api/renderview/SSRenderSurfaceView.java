package com.bykv.vk.openvk.component.video.api.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.f.c;
import com.bykv.vk.openvk.component.video.api.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {
    private static final ArrayList<c> c = new ArrayList<>();
    private WeakReference<a> a;
    private c b;
    private b.a d;

    public View getView() {
        return this;
    }

    public SSRenderSurfaceView(Context context) {
        super(context);
        c.b("CSJ_VIDEO_SurfaceView", "SSRenderSurfaceView: ");
        a();
    }

    private void a() {
        this.b = new c(this);
        c.add(this.b);
    }

    public void a(a aVar) {
        this.a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it = c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next != null && next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.b);
    }

    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            ((a) this.a.get()).a(surfaceHolder);
        }
        c.b("CSJ_VIDEO_SurfaceView", "surfaceCreated: ");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        c.b("CSJ_VIDEO_SurfaceView", "surfaceChanged: ");
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((a) this.a.get()).a(surfaceHolder, i, i2, i3);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        c.b("CSJ_VIDEO_SurfaceView", "surfaceDestroyed: ");
        WeakReference<a> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((a) this.a.get()).b(surfaceHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.d = aVar;
    }
}
