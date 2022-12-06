package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeor implements zzddd {
    public final /* synthetic */ zzeof zza;
    public final /* synthetic */ zzbsl zzb;

    public /* synthetic */ zzeor(zzeof zzeof, zzbsl zzbsl) {
        this.zza = zzeof;
        this.zzb = zzbsl;
    }

    public final void zza(zze zze) {
        zzeof zzeof = this.zza;
        zzbsl zzbsl = this.zzb;
        zzeof.zza(zze);
        if (zzbsl != null) {
            try {
                zzbsl.zzf(zze);
            } catch (RemoteException e) {
                zzcgp.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzbsl != null) {
            try {
                zzbsl.zze(zze.zza);
            } catch (RemoteException e2) {
                zzcgp.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
