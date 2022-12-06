package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzaa;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class zzov {
    private final Set<zzou<?>> zzaox = Collections.newSetFromMap(new WeakHashMap());

    public void release() {
        for (zzou<?> clear : this.zzaox) {
            clear.clear();
        }
        this.zzaox.clear();
    }

    public <L> zzou<L> zza(@NonNull L l, Looper looper) {
        zzaa.zzb(l, (Object) "Listener must not be null");
        zzaa.zzb(looper, (Object) "Looper must not be null");
        zzou<L> zzou = new zzou<>(looper, l);
        this.zzaox.add(zzou);
        return zzou;
    }
}
