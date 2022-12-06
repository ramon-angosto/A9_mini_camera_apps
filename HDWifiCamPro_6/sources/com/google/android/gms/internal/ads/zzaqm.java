package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaqm implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzaqn zza;

    zzaqm(zzaqn zzaqn) {
        this.zza = zzaqn;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        zzaqn zzaqn = this.zza;
        if (zzaqn.zzc > 0 && currentTimeMillis >= zzaqn.zzc) {
            zzaqn.zzd = currentTimeMillis - zzaqn.zzc;
        }
        this.zza.zze = false;
    }
}
