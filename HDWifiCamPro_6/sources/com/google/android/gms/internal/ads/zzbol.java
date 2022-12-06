package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbol extends zzbno {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zza;

    public zzbol(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzbs zzbs, IObjectWrapper iObjectWrapper) {
        if (zzbs != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzbs.zzi() instanceof zzg) {
                    zzg zzg = (zzg) zzbs.zzi();
                    adManagerAdView.setAdListener(zzg != null ? zzg.zzb() : null);
                }
            } catch (RemoteException e) {
                zzcgp.zzh("", e);
            }
            try {
                if (zzbs.zzj() instanceof zzbce) {
                    zzbce zzbce = (zzbce) zzbs.zzj();
                    if (zzbce != null) {
                        appEventListener = zzbce.zzb();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzcgp.zzh("", e2);
            }
            zzcgi.zza.post(new zzbok(this, adManagerAdView, zzbs));
        }
    }
}
