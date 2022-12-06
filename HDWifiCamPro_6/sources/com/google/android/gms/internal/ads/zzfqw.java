package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfqw extends zzfro {
    final /* synthetic */ zzfrc zza;
    final /* synthetic */ zzfrf zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfra zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfqw(zzfra zzfra, TaskCompletionSource taskCompletionSource, zzfrc zzfrc, zzfrf zzfrf, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zzd = zzfra;
        this.zza = zzfrc;
        this.zzb = zzfrf;
        this.zzc = taskCompletionSource2;
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [com.google.android.gms.internal.ads.zzfrk, android.os.IInterface] */
    /* access modifiers changed from: protected */
    public final void zza() {
        try {
            ? zze = this.zzd.zza.zze();
            zzfra zzfra = this.zzd;
            String zzb2 = zzfra.zzd;
            zzfrc zzfrc = this.zza;
            String zzb3 = zzfra.zzd;
            Bundle bundle = new Bundle();
            bundle.putBinder("windowToken", zzfrc.zze());
            bundle.putString("adFieldEnifd", zzfrc.zzf());
            bundle.putInt("layoutGravity", zzfrc.zzc());
            bundle.putFloat("layoutVerticalMargin", zzfrc.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("windowWidthPx", zzfrc.zzd());
            bundle.putBoolean("stableSessionToken", false);
            bundle.putString("callerPackage", zzb3);
            if (zzfrc.zzg() != null) {
                bundle.putString("appId", zzfrc.zzg());
            }
            zze.zzf(zzb2, bundle, new zzfqz(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfra.zzb.zzc(e, "show overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
