package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
public final class zab extends ActivityLifecycleObserver {
    private final WeakReference<zaa> zaa;

    zab(zaa zaa2) {
        this.zaa = new WeakReference<>(zaa2);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        zaa zaa2 = (zaa) this.zaa.get();
        if (zaa2 != null) {
            zaa2.zac(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
