package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaak implements Runnable {
    final /* synthetic */ zaaw zaa;

    zaak(zaaw zaaw) {
        this.zaa = zaaw;
    }

    public final void run() {
        zaaw zaaw = this.zaa;
        zaaw.zad.cancelAvailabilityErrorNotifications(zaaw.zac);
    }
}
