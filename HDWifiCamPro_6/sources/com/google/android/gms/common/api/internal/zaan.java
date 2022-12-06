package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zaan extends zabg {
    final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaan(zaao zaao, zabf zabf, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabf);
        this.zaa = connectionProgressReportCallbacks;
    }

    public final void zaa() {
        this.zaa.onReportServiceBinding(new ConnectionResult(16, (PendingIntent) null));
    }
}
