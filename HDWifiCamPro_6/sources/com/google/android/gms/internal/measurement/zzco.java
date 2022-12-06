package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzco extends zzdt {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzee zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzco(zzee zzee, String str, String str2, Bundle bundle) {
        super(zzee, true);
        this.zzd = zzee;
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzd.zzj)).clearConditionalUserProperty(this.zza, this.zzb, this.zzc);
    }
}
