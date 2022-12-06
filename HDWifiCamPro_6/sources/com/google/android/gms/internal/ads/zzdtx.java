package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdtx extends VideoController.VideoLifecycleCallbacks {
    private final zzdoq zza;

    public zzdtx(zzdoq zzdoq) {
        this.zza = zzdoq;
    }

    private static zzdn zza(zzdoq zzdoq) {
        zzdk zzj = zzdoq.zzj();
        if (zzj == null) {
            return null;
        }
        try {
            return zzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzdn zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zze();
            } catch (RemoteException e) {
                zze.zzk("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzdn zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzg();
            } catch (RemoteException e) {
                zze.zzk("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoStart() {
        zzdn zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzi();
            } catch (RemoteException e) {
                zze.zzk("Unable to call onVideoEnd()", e);
            }
        }
    }
}
