package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.internal.zzga;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzcx extends zzdt {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zzee zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcx(zzee zzee, String str, String str2, Context context, Bundle bundle) {
        super(zzee, true);
        this.zze = zzee;
        this.zza = str;
        this.zzb = str2;
        this.zzc = context;
        this.zzd = bundle;
    }

    public final void zza() {
        String str;
        String str2;
        String str3;
        try {
            if (zzee.zzV(this.zza, this.zzb)) {
                String str4 = this.zzb;
                str2 = this.zza;
                str = str4;
                str3 = this.zze.zzd;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            Preconditions.checkNotNull(this.zzc);
            zzee zzee = this.zze;
            zzee.zzj = zzee.zzf(this.zzc, true);
            if (this.zze.zzj == null) {
                Log.w(this.zze.zzd, "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(this.zzc, "com.google.android.gms.measurement.dynamite");
            int remoteVersion = DynamiteModule.getRemoteVersion(this.zzc, "com.google.android.gms.measurement.dynamite");
            ((zzcc) Preconditions.checkNotNull(this.zze.zzj)).initialize(ObjectWrapper.wrap(this.zzc), new zzcl(61000, (long) Math.max(localVersion, remoteVersion), remoteVersion < localVersion, str3, str2, str, this.zzd, zzga.zza(this.zzc)), this.zzh);
        } catch (Exception e) {
            this.zze.zzS(e, true, false);
        }
    }
}
