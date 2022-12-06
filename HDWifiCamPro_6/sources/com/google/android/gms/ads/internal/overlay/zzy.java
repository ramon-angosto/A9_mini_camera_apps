package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbzb;
import com.google.android.gms.internal.ads.zzdkn;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzy extends zzbzb {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzy(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzo zzo = this.zza.zzc;
            if (zzo != null) {
                zzo.zzf(4);
            }
            this.zzd = true;
        }
    }

    public final boolean zzE() throws RemoteException {
        return false;
    }

    public final void zzg(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void zzh() throws RemoteException {
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzk(Bundle bundle) {
        zzo zzo;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhC)).booleanValue()) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zza zza2 = adOverlayInfoParcel.zzb;
                if (zza2 != null) {
                    zza2.onAdClicked();
                }
                zzdkn zzdkn = this.zza.zzy;
                if (zzdkn != null) {
                    zzdkn.zzq();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzo = this.zza.zzc) == null)) {
                    zzo.zzb();
                }
            }
            zzt.zzh();
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzl() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzn() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbr();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzo() throws RemoteException {
    }

    public final void zzp() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zzbK();
        }
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzr() throws RemoteException {
    }

    public final void zzs() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzt() throws RemoteException {
        zzo zzo = this.zza.zzc;
        if (zzo != null) {
            zzo.zze();
        }
    }

    public final void zzv() throws RemoteException {
    }
}
