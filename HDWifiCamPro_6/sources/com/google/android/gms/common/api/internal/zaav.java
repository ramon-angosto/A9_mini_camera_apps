package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
abstract class zaav implements Runnable {
    final /* synthetic */ zaaw zab;

    /* synthetic */ zaav(zaaw zaaw, zaau zaau) {
        this.zab = zaaw;
    }

    public final void run() {
        Lock zap;
        this.zab.zab.lock();
        try {
            if (Thread.interrupted()) {
                zap = this.zab.zab;
            } else {
                zaa();
                zap = this.zab.zab;
            }
        } catch (RuntimeException e) {
            this.zab.zaa.zam(e);
            zap = this.zab.zab;
        } catch (Throwable th) {
            this.zab.zab.unlock();
            throw th;
        }
        zap.unlock();
    }

    /* access modifiers changed from: protected */
    public abstract void zaa();
}
