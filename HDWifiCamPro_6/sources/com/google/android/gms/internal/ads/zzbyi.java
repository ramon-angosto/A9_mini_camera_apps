package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbyi implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbmy zza;

    public zzbyi(zzbmy zzbmy) {
        this.zza = zzbmy;
        try {
            zzbmy.zzm();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzp(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzs();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
            return false;
        }
    }
}
