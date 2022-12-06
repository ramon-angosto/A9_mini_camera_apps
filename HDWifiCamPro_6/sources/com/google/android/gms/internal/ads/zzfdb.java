package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfdb extends zzcck {
    private final zzfcx zza;
    private final zzfcn zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzfdx zzd;
    private final Context zze;
    private final zzcgv zzf;
    /* access modifiers changed from: private */
    public zzduc zzg;
    private boolean zzh = ((Boolean) zzay.zzc().zzb(zzbjc.zzaA)).booleanValue();

    public zzfdb(String str, zzfcx zzfcx, Context context, zzfcn zzfcn, zzfdx zzfdx, zzcgv zzcgv) {
        this.zzc = str;
        this.zza = zzfcx;
        this.zzb = zzfcn;
        this.zzd = zzfdx;
        this.zze = context;
        this.zzf = zzcgv;
    }

    private final synchronized void zzu(zzl zzl, zzccs zzccs, int i) throws RemoteException {
        boolean z = false;
        if (((Boolean) zzbkq.zzl.zze()).booleanValue()) {
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziM)).booleanValue()) {
                z = true;
            }
        }
        if (this.zzf.zzc < ((Integer) zzay.zzc().zzb(zzbjc.zziN)).intValue() || !z) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        }
        this.zzb.zze(zzccs);
        zzt.zzp();
        if (zzs.zzD(this.zze)) {
            if (zzl.zzs == null) {
                zze.zzg("Failed to load the ad because app ID is missing.");
                this.zzb.zza(zzffe.zzd(4, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
                return;
            }
        }
        if (this.zzg == null) {
            zzfcp zzfcp = new zzfcp((String) null);
            this.zza.zzj(i);
            this.zza.zzb(zzl, this.zzc, zzfcp, new zzfda(this));
        }
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzduc zzduc = this.zzg;
        return zzduc != null ? zzduc.zza() : new Bundle();
    }

    public final zzdh zzc() {
        zzduc zzduc;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzfQ)).booleanValue() && (zzduc = this.zzg) != null) {
            return zzduc.zzl();
        }
        return null;
    }

    public final zzcci zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzduc zzduc = this.zzg;
        if (zzduc != null) {
            return zzduc.zzc();
        }
        return null;
    }

    public final synchronized String zze() throws RemoteException {
        zzduc zzduc = this.zzg;
        if (zzduc == null || zzduc.zzl() == null) {
            return null;
        }
        return zzduc.zzl().zzg();
    }

    public final synchronized void zzf(zzl zzl, zzccs zzccs) throws RemoteException {
        zzu(zzl, zzccs, 2);
    }

    public final synchronized void zzg(zzl zzl, zzccs zzccs) throws RemoteException {
        zzu(zzl, zzccs, 3);
    }

    public final synchronized void zzh(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzh = z;
    }

    public final void zzi(zzdb zzdb) {
        if (zzdb == null) {
            this.zzb.zzb((zzfmr) null);
        } else {
            this.zzb.zzb(new zzfcz(this, zzdb));
        }
    }

    public final void zzj(zzde zzde) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzb.zzc(zzde);
    }

    public final void zzk(zzcco zzcco) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzd(zzcco);
    }

    public final synchronized void zzl(zzccz zzccz) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfdx zzfdx = this.zzd;
        zzfdx.zza = zzccz.zza;
        zzfdx.zzb = zzccz.zzb;
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzh);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzg == null) {
            zze.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzk(zzffe.zzd(9, (String) null, (com.google.android.gms.ads.internal.client.zze) null));
            return;
        }
        this.zzg.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzduc zzduc = this.zzg;
        return zzduc != null && !zzduc.zzf();
    }

    public final void zzp(zzcct zzcct) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzi(zzcct);
    }
}
