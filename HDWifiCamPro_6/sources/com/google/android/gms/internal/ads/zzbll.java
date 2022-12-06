package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbll {
    private final Context zza;

    public zzbll(Context context) {
        this.zza = context;
    }

    public final void zza(zzcam zzcam) {
        try {
            ((zzblm) zzcgt.zzb(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzblk.zza)).zze(zzcam);
        } catch (zzcgs e) {
            zzcgp.zzj("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e.getMessage())));
        } catch (RemoteException e2) {
            zzcgp.zzj("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e2.getMessage())));
        }
    }
}
