package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcww extends zzbdi {
    private final zzcwv zza;
    private final zzbs zzb;
    private final zzezg zzc;
    private boolean zzd = false;

    public zzcww(zzcwv zzcwv, zzbs zzbs, zzezg zzezg) {
        this.zza = zzcwv;
        this.zzb = zzbs;
        this.zzc = zzezg;
    }

    public final zzbs zze() {
        return this.zzb;
    }

    public final zzdh zzf() {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzfQ)).booleanValue()) {
            return null;
        }
        return this.zza.zzl();
    }

    public final void zzg(boolean z) {
        this.zzd = z;
    }

    public final void zzh(zzde zzde) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        zzezg zzezg = this.zzc;
        if (zzezg != null) {
            zzezg.zzp(zzde);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbdq zzbdq) {
        try {
            this.zzc.zzs(zzbdq);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbdq, this.zzd);
        } catch (RemoteException e) {
            zze.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzj(zzbdn zzbdn) {
    }
}
