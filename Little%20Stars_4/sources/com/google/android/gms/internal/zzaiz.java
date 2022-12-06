package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class zzaiz {
    private static final AtomicReference<zzaiz> zzbSU = new AtomicReference<>();

    zzaiz(Context context) {
    }

    @Nullable
    public static zzaiz zzUw() {
        return zzbSU.get();
    }

    public static zzaiz zzbA(Context context) {
        zzbSU.compareAndSet((Object) null, new zzaiz(context));
        return zzbSU.get();
    }

    public Set<String> zzUx() {
        return Collections.emptySet();
    }

    public void zzf(@NonNull FirebaseApp firebaseApp) {
    }
}
