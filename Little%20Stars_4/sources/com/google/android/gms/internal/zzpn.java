package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzpo;

public final class zzpn implements zzpm {

    private static class zza extends zzpk {
        private final zznt.zzb<Status> zzasz;

        public zza(zznt.zzb<Status> zzb) {
            this.zzasz = zzb;
        }

        public void zzck(int i) throws RemoteException {
            this.zzasz.setResult(new Status(i));
        }
    }

    public PendingResult<Status> zzf(GoogleApiClient googleApiClient) {
        return googleApiClient.zzd(new zzpo.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpp zzpp) throws RemoteException {
                ((zzpr) zzpp.zztm()).zza(new zza(this));
            }
        });
    }
}
