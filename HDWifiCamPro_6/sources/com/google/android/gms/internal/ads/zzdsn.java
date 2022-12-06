package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsn extends zzbse implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzblp {
    private View zza;
    private zzdk zzb;
    private zzdol zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdsn(zzdol zzdol, zzdoq zzdoq) {
        this.zza = zzdoq.zzf();
        this.zzb = zzdoq.zzj();
        this.zzc = zzdol;
        if (zzdoq.zzr() != null) {
            zzdoq.zzr().zzao(this);
        }
    }

    private final void zzg() {
        View view;
        zzdol zzdol = this.zzc;
        if (zzdol != null && (view = this.zza) != null) {
            zzdol.zzv(view, Collections.emptyMap(), Collections.emptyMap(), zzdol.zzP(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbsi zzbsi, int i) {
        try {
            zzbsi.zze(i);
        } catch (RemoteException e) {
            zze.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzdk zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zze.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbmb zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zze.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdol zzdol = this.zzc;
        if (zzdol == null || zzdol.zza() == null) {
            return null;
        }
        return zzdol.zza().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdol zzdol = this.zzc;
        if (zzdol != null) {
            zzdol.zzV();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdsm(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbsi zzbsi) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zze.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbsi, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            zze.zzg("Instream internal error: ".concat(view == null ? "can not get video view." : "can not get video controller."));
            zzi(zzbsi, 0);
        } else if (this.zze) {
            zze.zzg("Instream ad should not be used again.");
            zzi(zzbsi, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzt.zzx();
            zzchp.zza(this.zza, this);
            zzt.zzx();
            zzchp.zzb(this.zza, this);
            zzg();
            try {
                zzbsi.zzf();
            } catch (RemoteException e) {
                zze.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
