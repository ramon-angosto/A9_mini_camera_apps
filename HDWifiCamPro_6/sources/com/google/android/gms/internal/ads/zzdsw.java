package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzcu;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsw extends zzboa {
    private final String zza;
    private final zzdol zzb;
    private final zzdoq zzc;

    public zzdsw(String str, zzdol zzdol, zzdoq zzdoq) {
        this.zza = str;
        this.zzb = zzdol;
        this.zzc = zzdoq;
    }

    public final void zzA() {
        this.zzb.zzA();
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        this.zzb.zzE(bundle);
    }

    public final void zzC() {
        this.zzb.zzG();
    }

    public final void zzD(zzcq zzcq) throws RemoteException {
        this.zzb.zzH(zzcq);
    }

    public final void zzE(zzde zzde) throws RemoteException {
        this.zzb.zzI(zzde);
    }

    public final void zzF(zzbny zzbny) throws RemoteException {
        this.zzb.zzJ(zzbny);
    }

    public final boolean zzG() {
        return this.zzb.zzN();
    }

    public final boolean zzH() throws RemoteException {
        return !this.zzc.zzF().isEmpty() && this.zzc.zzk() != null;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        return this.zzb.zzQ(bundle);
    }

    public final double zze() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzf() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdh zzg() throws RemoteException {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzfQ)).booleanValue()) {
            return null;
        }
        return this.zzb.zzl();
    }

    public final zzdk zzh() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzblw zzi() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbmb zzj() throws RemoteException {
        return this.zzb.zza().zza();
    }

    public final zzbme zzk() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzl() throws RemoteException {
        return this.zzc.zzt();
    }

    public final IObjectWrapper zzm() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzv();
    }

    public final String zzo() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzp() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzq() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzr() throws RemoteException {
        return this.zza;
    }

    public final String zzs() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzt() throws RemoteException {
        return this.zzc.zzC();
    }

    public final List zzu() throws RemoteException {
        return this.zzc.zzE();
    }

    public final List zzv() throws RemoteException {
        if (zzH()) {
            return this.zzc.zzF();
        }
        return Collections.emptyList();
    }

    public final void zzw() throws RemoteException {
        this.zzb.zzk();
    }

    public final void zzx() throws RemoteException {
        this.zzb.zzV();
    }

    public final void zzy(zzcu zzcu) throws RemoteException {
        this.zzb.zzw(zzcu);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        this.zzb.zzz(bundle);
    }
}
