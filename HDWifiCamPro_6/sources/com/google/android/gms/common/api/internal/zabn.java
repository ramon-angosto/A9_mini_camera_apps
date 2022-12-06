package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zabn implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabq zab;

    zabn(zabq zabq, int i) {
        this.zab = zabq;
        this.zaa = i;
    }

    public final void run() {
        this.zab.zaH(this.zaa);
    }
}
