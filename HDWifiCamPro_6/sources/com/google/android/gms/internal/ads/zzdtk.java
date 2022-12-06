package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdtk implements Callable {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final zzcnb zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public final zzdxq zzd;
    /* access modifiers changed from: private */
    public final zzfir zze;
    /* access modifiers changed from: private */
    public final zzego zzf;
    /* access modifiers changed from: private */
    public final Executor zzg;
    /* access modifiers changed from: private */
    public final zzape zzh;
    /* access modifiers changed from: private */
    public final zzcgv zzi;
    /* access modifiers changed from: private */
    public final zzfkm zzj;

    public zzdtk(Context context, Executor executor, zzape zzape, zzcgv zzcgv, zza zza2, zzcnb zzcnb, zzego zzego, zzfkm zzfkm, zzdxq zzdxq, zzfir zzfir) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzape;
        this.zzi = zzcgv;
        this.zza = zza2;
        this.zzb = zzcnb;
        this.zzf = zzego;
        this.zzj = zzfkm;
        this.zzd = zzdxq;
        this.zze = zzfir;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdtn zzdtn = new zzdtn(this);
        zzdtn.zzh();
        return zzdtn;
    }
}
