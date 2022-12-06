package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzbwe implements InitializationCompleteCallback {
    final /* synthetic */ zzbru zza;

    zzbwe(zzbwj zzbwj, zzbru zzbru) {
        this.zza = zzbru;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }
}
