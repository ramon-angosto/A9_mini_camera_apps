package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzccx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzat extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbvk zzc;
    final /* synthetic */ zzau zzd;

    zzat(zzau zzau, Context context, String str, zzbvk zzbvk) {
        this.zzd = zzau;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbvk;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zza, "rewarded");
        return new zzew();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzn(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 223104000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzccx.zza(this.zza, this.zzb, this.zzc);
    }
}
