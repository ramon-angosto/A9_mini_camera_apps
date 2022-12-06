package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzcs extends zzdt {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzee zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcs(zzee zzee, Boolean bool) {
        super(zzee, true);
        this.zzb = zzee;
        this.zza = bool;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        if (this.zza != null) {
            ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).setMeasurementEnabled(this.zza.booleanValue(), this.zzh);
        } else {
            ((zzcc) Preconditions.checkNotNull(this.zzb.zzj)).clearMeasurementEnabled(this.zzh);
        }
    }
}
