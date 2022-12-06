package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzae extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvk zzb;

    zzae(zzau zzau, Context context, zzbvk zzbvk) {
        this.zza = context;
        this.zzb = zzbvk;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzk(ObjectWrapper.wrap(this.zza), this.zzb, 223104000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbyy) zzcgt.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzad.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 223104000);
        } catch (RemoteException | zzcgs | NullPointerException unused) {
            return null;
        }
    }
}
