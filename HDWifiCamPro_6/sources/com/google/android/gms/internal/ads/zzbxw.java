package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbxw implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbxx zza;

    zzbxw(zzbxx zzbxx) {
        this.zza = zzbxx;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzg("Operation denied by user.");
    }
}
