package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zabo implements Runnable {
    final /* synthetic */ zabp zaa;

    zabo(zabp zabp) {
        this.zaa = zabp;
    }

    public final void run() {
        zabq zabq = this.zaa.zaa;
        zabq.zac.disconnect(String.valueOf(zabq.zac.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
