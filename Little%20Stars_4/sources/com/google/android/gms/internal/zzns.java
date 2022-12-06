package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import java.util.Set;

public final class zzns extends zznv<zzb> {
    private int zzalM;
    private boolean zzalN;

    private void zza(ConnectionResult connectionResult) {
        int i = 0;
        while (true) {
            ArrayMap arrayMap = null;
            if (i < arrayMap.size()) {
                zza((zznq) arrayMap.keyAt(i), connectionResult);
                i++;
            } else {
                return;
            }
        }
    }

    public void zza(zznq<?> zznq, ConnectionResult connectionResult) {
        ArrayMap arrayMap = null;
        synchronized (arrayMap) {
            arrayMap.put(zznq, connectionResult);
            this.zzalM--;
            if (!connectionResult.isSuccess()) {
                this.zzalN = true;
            }
            if (this.zzalM == 0) {
                Status status = this.zzalN ? new Status(13) : Status.zzalw;
                zzb(arrayMap.size() == 1 ? new zza(status, arrayMap) : new zzb(status, arrayMap));
            }
        }
    }

    public Set<zznq<?>> zzrC() {
        ArrayMap arrayMap = null;
        return arrayMap.keySet();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzw */
    public zzb zzc(Status status) {
        zzb zza;
        ArrayMap arrayMap = null;
        synchronized (arrayMap) {
            zza(new ConnectionResult(8));
            zza = arrayMap.size() == 1 ? new zza(status, arrayMap) : new zzb(status, arrayMap);
        }
        return zza;
    }
}
