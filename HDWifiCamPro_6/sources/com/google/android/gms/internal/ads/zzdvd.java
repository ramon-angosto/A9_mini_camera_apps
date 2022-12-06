package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdvd implements zzddv {
    private final zzcmp zza;

    zzdvd(zzcmp zzcmp) {
        this.zza = zzcmp;
    }

    public final void zzbq(Context context) {
        zzcmp zzcmp = this.zza;
        if (zzcmp != null) {
            zzcmp.destroy();
        }
    }

    public final void zzbs(Context context) {
        zzcmp zzcmp = this.zza;
        if (zzcmp != null) {
            zzcmp.onPause();
        }
    }

    public final void zzbt(Context context) {
        zzcmp zzcmp = this.zza;
        if (zzcmp != null) {
            zzcmp.onResume();
        }
    }
}
