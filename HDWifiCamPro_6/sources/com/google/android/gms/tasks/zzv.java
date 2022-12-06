package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
final class zzv extends LifecycleCallback {
    private final List<WeakReference<zzq<?>>> zza = new ArrayList();

    private zzv(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    }

    public static zzv zza(Activity activity) {
        LifecycleFragment fragment = getFragment(activity);
        zzv zzv = (zzv) fragment.getCallbackOrNull("TaskOnStopCallback", zzv.class);
        return zzv == null ? new zzv(fragment) : zzv;
    }

    public final void onStop() {
        synchronized (this.zza) {
            for (WeakReference<zzq<?>> weakReference : this.zza) {
                zzq zzq = (zzq) weakReference.get();
                if (zzq != null) {
                    zzq.zzc();
                }
            }
            this.zza.clear();
        }
    }

    public final <T> void zzb(zzq<T> zzq) {
        synchronized (this.zza) {
            this.zza.add(new WeakReference(zzq));
        }
    }
}
