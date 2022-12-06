package com.mbridge.msdk.a.a;

import com.mbridge.msdk.out.PreloadListener;
import java.lang.ref.WeakReference;

/* compiled from: PreloadListenerEx */
public final class a implements PreloadListener {
    WeakReference<PreloadListener> a;
    private boolean b = false;
    private int c = 0;

    public final boolean a() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public a(PreloadListener preloadListener) {
        if (preloadListener != null) {
            this.a = new WeakReference<>(preloadListener);
        }
    }

    public final void onPreloadSucceed() {
        WeakReference<PreloadListener> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((PreloadListener) this.a.get()).onPreloadSucceed();
        }
    }

    public final void onPreloadFaild(String str) {
        WeakReference<PreloadListener> weakReference = this.a;
        if (weakReference != null && weakReference.get() != null) {
            ((PreloadListener) this.a.get()).onPreloadFaild(str);
        }
    }
}
