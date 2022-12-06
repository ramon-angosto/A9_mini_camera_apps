package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzal implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ AtomicInteger zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;

    public /* synthetic */ zzal(zzas zzas, AtomicInteger atomicInteger, int i, int i2, int i3) {
        this.zza = zzas;
        this.zzb = atomicInteger;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze, dialogInterface, i);
    }
}
