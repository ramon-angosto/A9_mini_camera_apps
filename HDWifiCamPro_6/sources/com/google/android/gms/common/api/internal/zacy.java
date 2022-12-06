package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.0.0 */
final class zacy implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zada zab;

    zacy(zada zada, Result result) {
        this.zab = zada;
        this.zaa = result;
    }

    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            BasePendingResult.zaa.set(true);
            PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa);
            zada zada = this.zab;
            zada.zah.sendMessage(zada.zah.obtainMessage(0, onSuccess));
            BasePendingResult.zaa.set(false);
            zada.zan(this.zaa);
            googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (RuntimeException e) {
            zada zada2 = this.zab;
            zada2.zah.sendMessage(zada2.zah.obtainMessage(1, e));
            BasePendingResult.zaa.set(false);
            zada.zan(this.zaa);
            googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(false);
            zada.zan(this.zaa);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.zab);
            }
            throw th;
        }
        googleApiClient.zap(this.zab);
    }
}
