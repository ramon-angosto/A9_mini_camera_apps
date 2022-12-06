package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzcv extends zzdt {
    final /* synthetic */ zzee zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcv(zzee zzee) {
        super(zzee, true);
        this.zza = zzee;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zza.zzj)).resetAnalyticsData(this.zzh);
    }
}
