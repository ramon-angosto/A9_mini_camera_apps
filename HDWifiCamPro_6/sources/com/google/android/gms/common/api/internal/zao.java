package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zao implements Runnable {
    final /* synthetic */ zap zaa;
    private final zam zab;

    zao(zap zap, zam zam) {
        this.zaa = zap;
        this.zab = zam;
    }

    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult zab2 = this.zab.zab();
            if (zab2.hasResolution()) {
                this.zaa.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(this.zaa.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab2.getResolution()), this.zab.zaa(), false), 1);
                return;
            }
            zap zap = this.zaa;
            if (zap.zac.getErrorResolutionIntent(zap.getActivity(), zab2.getErrorCode(), (String) null) != null) {
                zap zap2 = this.zaa;
                zap2.zac.zag(zap2.getActivity(), this.zaa.mLifecycleFragment, zab2.getErrorCode(), 2, this.zaa);
            } else if (zab2.getErrorCode() == 18) {
                zap zap3 = this.zaa;
                Dialog zab3 = zap3.zac.zab(zap3.getActivity(), this.zaa);
                zap zap4 = this.zaa;
                zap4.zac.zac(zap4.getActivity().getApplicationContext(), new zan(this, zab3));
            } else {
                this.zaa.zaa(zab2, this.zab.zaa());
            }
        }
    }
}
