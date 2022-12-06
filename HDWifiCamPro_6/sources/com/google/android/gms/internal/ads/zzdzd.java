package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdzd extends zzccr {
    final /* synthetic */ zzdzf zza;

    zzdzd(zzdzf zzdzf) {
        this.zza = zzdzf;
    }

    public final void zze(int i) throws RemoteException {
        zzdzf zzdzf = this.zza;
        zzdzf.zzb.zzm(zzdzf.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        zzdzf zzdzf = this.zza;
        zzdzf.zzb.zzm(zzdzf.zza, zze.zza);
    }

    public final void zzg() throws RemoteException {
        zzdzf zzdzf = this.zza;
        zzdzf.zzb.zzp(zzdzf.zza);
    }
}
