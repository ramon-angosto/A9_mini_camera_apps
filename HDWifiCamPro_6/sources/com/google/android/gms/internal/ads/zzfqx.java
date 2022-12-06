package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqx extends zzfro {
    final /* synthetic */ zzfqr zza;
    final /* synthetic */ zzfrf zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfra zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqx(zzfra zzfra, TaskCompletionSource taskCompletionSource, zzfqr zzfqr, zzfrf zzfrf, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfra;
        this.zza = zzfqr;
        this.zzb = zzfrf;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzfrk, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze = this.zzd.zza.zze();
            zzfqr zzfqr = this.zza;
            String zzb2 = this.zzd.zzd;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfqr.zzb());
            bundle.putString("callerPackage", zzb2);
            bundle.putString("appId", zzfqr.zza());
            zze.zze(bundle, new zzfqz(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfra.zzb.zzc(e, "dismiss overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
