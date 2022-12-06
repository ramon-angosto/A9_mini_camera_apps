package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzad implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzad(zzas zzas, String str) {
        this.zza = zzas;
        this.zzb = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzi(this.zzb, dialogInterface, i);
    }
}
