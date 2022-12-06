package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zacr implements Runnable {
    final /* synthetic */ zak zaa;
    final /* synthetic */ zact zab;

    zacr(zact zact, zak zak) {
        this.zab = zact;
        this.zaa = zak;
    }

    public final void run() {
        zact.zad(this.zab, this.zaa);
    }
}
