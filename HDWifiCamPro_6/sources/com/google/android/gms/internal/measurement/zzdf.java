package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
final class zzdf extends zzdt {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzbz zzd;
    final /* synthetic */ zzee zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(zzee zzee, String str, String str2, boolean z, zzbz zzbz) {
        super(zzee, true);
        this.zze = zzee;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzbz;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        ((zzcc) Preconditions.checkNotNull(this.zze.zzj)).getUserProperties(this.zza, this.zzb, this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zzd((Bundle) null);
    }
}
