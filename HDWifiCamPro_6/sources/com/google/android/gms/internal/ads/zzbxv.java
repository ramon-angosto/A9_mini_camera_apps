package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbxv implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbxx zza;

    zzbxv(zzbxx zzbxx) {
        this.zza = zzbxx;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent zzb = this.zza.zzb();
        zzt.zzp();
        zzs.zzJ(this.zza.zzb, zzb);
    }
}
