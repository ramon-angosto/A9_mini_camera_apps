package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzarn extends zzarq {
    private final View zzi;

    public zzarn(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2, View view) {
        super(zzaqe, "xcWDoPM3ZfO4P10VSUmZKRTMvsXPXnglJL31bwAJBgJGdSUy2IQG17s4MILOncV2", "9rXsTdb/WXYONX554dN5CJ2eqpcy9gFPMPi8uAjaHTA=", zzamk, i, 57);
        this.zzi = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzay.zzc().zzb(zzbjc.zzcD);
            Boolean bool2 = (Boolean) zzay.zzc().zzb(zzbjc.zziC);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzaqi zzaqi = new zzaqi((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool, bool2}));
            zzamy zza = zzamz.zza();
            zza.zzb(zzaqi.zza.longValue());
            zza.zzd(zzaqi.zzb.longValue());
            zza.zze(zzaqi.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzaqi.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzaqi.zzd.longValue());
            }
            this.zze.zzY((zzamz) zza.zzam());
        }
    }
}
