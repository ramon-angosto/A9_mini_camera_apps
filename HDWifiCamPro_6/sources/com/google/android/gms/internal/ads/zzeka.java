package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeka extends zzbww {
    final /* synthetic */ zzekb zza;
    private final zzehf zzb;

    /* synthetic */ zzeka(zzekb zzekb, zzehf zzehf, zzejz zzejz) {
        this.zza = zzekb;
        this.zzb = zzehf;
    }

    public final void zze(String str) throws RemoteException {
        ((zzeix) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzeix) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(zzbvz zzbvz) throws RemoteException {
        this.zza.zzc = zzbvz;
        ((zzeix) this.zzb.zzc).zzo();
    }
}
