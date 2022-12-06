package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzdq extends zzdt {
    final /* synthetic */ zzdv zza;
    final /* synthetic */ zzee zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdq(zzee zzee, zzdv zzdv) {
        super(zzee, true);
        this.zzb = zzee;
        this.zza = zzdv;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).unregisterOnMeasurementEventListener(this.zza);
    }
}
