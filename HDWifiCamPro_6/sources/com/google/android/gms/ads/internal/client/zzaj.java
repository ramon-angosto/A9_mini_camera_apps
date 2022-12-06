package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzaj extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzau zzd;

    zzaj(zzau zzau, Context context, zzq zzq, String str) {
        this.zzd = zzau;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zza, "search");
        return new zzeq();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzf(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 223104000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zzd.zza.zza(this.zza, this.zzb, this.zzc, (zzbvk) null, 3);
    }
}
