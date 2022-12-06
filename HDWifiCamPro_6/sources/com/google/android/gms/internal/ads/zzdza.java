package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdza extends zzbe {
    final /* synthetic */ zzdyu zza;
    final /* synthetic */ zzdzb zzb;

    zzdza(zzdzb zzdzb, zzdyu zzdyu) {
        this.zzb = zzdzb;
        this.zza = zzdyu;
    }

    public final void zzc() throws RemoteException {
        this.zza.zzb(this.zzb.zza);
    }

    public final void zzd() throws RemoteException {
        this.zza.zzc(this.zzb.zza);
    }

    public final void zze(int i) throws RemoteException {
        this.zza.zzd(this.zzb.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        this.zza.zzd(this.zzb.zza, zze.zza);
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi() throws RemoteException {
        this.zza.zze(this.zzb.zza);
    }

    public final void zzj() throws RemoteException {
        this.zza.zzg(this.zzb.zza);
    }
}
