package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaa extends LifecycleCallback {
    private List<Runnable> zaa = new ArrayList();

    private zaa(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    static /* bridge */ /* synthetic */ zaa zaa(Activity activity) {
        zaa zaa2;
        synchronized (activity) {
            LifecycleFragment fragment = getFragment(activity);
            zaa2 = (zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
            if (zaa2 == null) {
                zaa2 = new zaa(fragment);
            }
        }
        return zaa2;
    }

    /* access modifiers changed from: private */
    public final synchronized void zac(Runnable runnable) {
        this.zaa.add(runnable);
    }

    public final void onStop() {
        List<Runnable> list;
        synchronized (this) {
            list = this.zaa;
            this.zaa = new ArrayList();
        }
        for (Runnable run : list) {
            run.run();
        }
    }
}
