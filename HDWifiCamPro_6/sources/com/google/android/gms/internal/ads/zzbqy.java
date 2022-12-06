package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbqy {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbqu zzc;

    public zzbqy(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(Build.VERSION.SDK_INT >= 21, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbjc.zzc(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzif)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzay.zzc().zzb(zzbjc.zzih)).intValue()) {
            zzcgp.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzaw.zza().zzk(this.zza, new zzbvh(), this.zzb);
        }
    }

    public final void zza() {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzif)).booleanValue()) {
            zzd();
            zzbqu zzbqu = this.zzc;
            if (zzbqu != null) {
                try {
                    zzbqu.zze();
                } catch (RemoteException e) {
                    zzcgp.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbqu zzbqu = this.zzc;
        if (zzbqu == null) {
            return false;
        }
        try {
            zzbqu.zzf(str);
            return true;
        } catch (RemoteException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }
}
