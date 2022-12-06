package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzam implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzas zza;

    public /* synthetic */ zzam(zzas zzas) {
        this.zza = zzas;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.zzr();
    }
}
