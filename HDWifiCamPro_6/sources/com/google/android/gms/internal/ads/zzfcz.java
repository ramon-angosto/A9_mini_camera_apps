package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfcz extends zzfmr {
    final /* synthetic */ zzdb zza;
    final /* synthetic */ zzfdb zzb;

    zzfcz(zzfdb zzfdb, zzdb zzdb) {
        this.zzb = zzfdb;
        this.zza = zzdb;
    }

    public final void zzv() {
        if (this.zzb.zzg != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zze.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
