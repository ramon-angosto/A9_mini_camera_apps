package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaz;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeeg implements zzfzc {
    final /* synthetic */ zzcay zza;

    zzeeg(zzeek zzeek, zzcay zzcay) {
        this.zza = zzcay;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zze(zzaz.zza(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
