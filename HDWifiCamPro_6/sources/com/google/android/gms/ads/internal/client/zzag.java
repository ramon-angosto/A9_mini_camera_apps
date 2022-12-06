package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzbrb;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzag extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvk zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzag(zzau zzau, Context context, zzbvk zzbvk, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbvk;
        this.zzc = onH5AdsEventListener;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        return new zzbrb();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzj(ObjectWrapper.wrap(this.zza), this.zzb, 223104000, new zzbqo(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbqx) zzcgt.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzaf.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 223104000, new zzbqo(this.zzc));
        } catch (RemoteException | zzcgs | NullPointerException unused) {
            return null;
        }
    }
}
