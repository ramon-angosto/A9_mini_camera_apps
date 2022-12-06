package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
abstract class zabg {
    private final zabf zaa;

    protected zabg(zabf zabf) {
        this.zaa = zabf;
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();

    public final void zab(zabi zabi) {
        Lock zah;
        zabi.zai.lock();
        try {
            if (zabi.zan != this.zaa) {
                zah = zabi.zai;
            } else {
                zaa();
                zah = zabi.zai;
            }
            zah.unlock();
        } catch (Throwable th) {
            zabi.zai.unlock();
            throw th;
        }
    }
}
