package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcuq implements zzddv {
    private final zzffa zza;

    public zzcuq(zzffa zzffa) {
        this.zza = zzffa;
    }

    public final void zzbq(Context context) {
        try {
            this.zza.zzg();
        } catch (zzfek e) {
            zze.zzk("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    public final void zzbs(Context context) {
        try {
            this.zza.zzs();
        } catch (zzfek e) {
            zze.zzk("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzbt(Context context) {
        try {
            this.zza.zzt();
            if (context != null) {
                this.zza.zzr(context);
            }
        } catch (zzfek e) {
            zze.zzk("Cannot invoke onResume for the mediation adapter.", e);
        }
    }
}
