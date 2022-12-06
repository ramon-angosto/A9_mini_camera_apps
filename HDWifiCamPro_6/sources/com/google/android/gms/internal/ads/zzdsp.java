package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsp extends zzbms {
    private final String zza;
    private final zzdol zzb;
    private final zzdoq zzc;

    public zzdsp(String str, zzdol zzdol, zzdoq zzdoq) {
        this.zza = str;
        this.zzb = zzdol;
        this.zzc = zzdoq;
    }

    public final double zzb() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzc() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdk zzd() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzblw zze() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbme zzf() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return this.zzc.zzt();
    }

    public final IObjectWrapper zzh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzk() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzl() throws RemoteException {
        return this.zza;
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzC();
    }

    public final List zzo() throws RemoteException {
        return this.zzc.zzE();
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzV();
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        this.zzb.zzz(bundle);
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzE(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzQ(bundle);
    }
}
