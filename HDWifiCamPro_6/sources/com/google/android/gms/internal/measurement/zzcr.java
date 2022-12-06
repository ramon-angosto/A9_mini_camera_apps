package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzcr extends zzdt {
    final /* synthetic */ Activity zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzee zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcr(zzee zzee, Activity activity, String str, String str2) {
        super(zzee, true);
        this.zzd = zzee;
        this.zza = activity;
        this.zzb = str;
        this.zzc = str2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzd.zzj)).setCurrentScreen(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzh);
    }
}
