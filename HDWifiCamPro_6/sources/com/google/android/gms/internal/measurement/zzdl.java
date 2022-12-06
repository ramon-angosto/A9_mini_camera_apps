package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzdl extends zzdt {
    final /* synthetic */ zzbz zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzee zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdl(zzee zzee, zzbz zzbz, int i) {
        super(zzee, true);
        this.zzc = zzee;
        this.zza = zzbz;
        this.zzb = i;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzc.zzj)).getTestFlag(this.zza, this.zzb);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zza.zzd((Bundle) null);
    }
}
