package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zax implements zabz {
    final /* synthetic */ zaaa zaa;

    /* synthetic */ zax(zaaa zaaa, zaw zaw) {
        this.zaa = zaaa;
    }

    public final void zaa(ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaj = connectionResult;
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public final void zab(Bundle bundle) {
        this.zaa.zam.lock();
        try {
            zaaa.zao(this.zaa, bundle);
            this.zaa.zaj = ConnectionResult.RESULT_SUCCESS;
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public final void zac(int i, boolean z) {
        Lock zaj;
        this.zaa.zam.lock();
        try {
            zaaa zaaa = this.zaa;
            if (!zaaa.zal && zaaa.zak != null) {
                if (zaaa.zak.isSuccess()) {
                    this.zaa.zal = true;
                    this.zaa.zae.onConnectionSuspended(i);
                    zaj = this.zaa.zam;
                    zaj.unlock();
                }
            }
            this.zaa.zal = false;
            zaaa.zan(this.zaa, i, z);
            zaj = this.zaa.zam;
            zaj.unlock();
        } catch (Throwable th) {
            this.zaa.zam.unlock();
            throw th;
        }
    }
}
