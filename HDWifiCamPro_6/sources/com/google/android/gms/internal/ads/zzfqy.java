package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqy extends zzfro {
    final /* synthetic */ zzfrh zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfrf zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzfra zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqy(zzfra zzfra, TaskCompletionSource taskCompletionSource, zzfrh zzfrh, int i, zzfrf zzfrf, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zze = zzfra;
        this.zza = zzfrh;
        this.zzb = i;
        this.zzc = zzfrf;
        this.zzd = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzfrk, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze2 = this.zze.zza.zze();
            zzfrh zzfrh = this.zza;
            String zzb2 = this.zze.zzd;
            int i = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfrh.zzb());
            bundle.putInt("displayMode", i);
            bundle.putString("callerPackage", zzb2);
            bundle.putString("appId", zzfrh.zza());
            zze2.zzg(bundle, new zzfqz(this.zze, this.zzc));
        } catch (RemoteException e) {
            zzfra.zzb.zzc(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(this.zzb), this.zze.zzd);
            this.zzd.trySetException(new RuntimeException(e));
        }
    }
}
