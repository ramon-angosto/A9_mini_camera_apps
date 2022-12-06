package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeoj implements zza, zzdkn {
    private zzbc zza;

    public final synchronized void onAdClicked() {
        zzbc zzbc = this.zza;
        if (zzbc != null) {
            try {
                zzbc.zzb();
            } catch (RemoteException e) {
                zze.zzk("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void zza(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final synchronized void zzq() {
        zzbc zzbc = this.zza;
        if (zzbc != null) {
            try {
                zzbc.zzb();
            } catch (RemoteException e) {
                zze.zzk("Remote Exception at onPhysicalClick.", e);
            }
        }
    }
}
