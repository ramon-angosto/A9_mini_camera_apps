package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zabd extends zabw {
    private final WeakReference<zabe> zaa;

    zabd(zabe zabe) {
        this.zaa = new WeakReference<>(zabe);
    }

    public final void zaa() {
        zabe zabe = (zabe) this.zaa.get();
        if (zabe != null) {
            zabe.zai(zabe);
        }
    }
}
