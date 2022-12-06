package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbw;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfdg extends zzfmr {
    final /* synthetic */ zzbw zza;
    final /* synthetic */ zzfdh zzb;

    zzfdg(zzfdh zzfdh, zzbw zzbw) {
        this.zzb = zzfdh;
        this.zza = zzbw;
    }

    public final void zzv() {
        if (this.zzb.zzd != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e) {
                zze.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
