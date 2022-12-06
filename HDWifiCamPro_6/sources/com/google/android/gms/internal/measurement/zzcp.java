package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzcp extends zzdt {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbz zzc;
    final /* synthetic */ zzee zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcp(zzee zzee, String str, String str2, zzbz zzbz) {
        super(zzee, true);
        this.zzd = zzee;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzd.zzj)).getConditionalUserProperties(this.zza, this.zzb, this.zzc);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zzd((Bundle) null);
    }
}
