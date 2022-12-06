package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaab implements PendingResult.StatusListener {
    final /* synthetic */ BasePendingResult zaa;
    final /* synthetic */ zaad zab;

    zaab(zaad zaad, BasePendingResult basePendingResult) {
        this.zab = zaad;
        this.zaa = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
