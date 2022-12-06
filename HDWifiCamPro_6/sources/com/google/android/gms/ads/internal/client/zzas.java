package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzas extends zzav {
    final /* synthetic */ View zza;
    final /* synthetic */ HashMap zzb;
    final /* synthetic */ HashMap zzc;
    final /* synthetic */ zzau zzd;

    zzas(zzau zzau, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzd = zzau;
        this.zza = view;
        this.zzb = hashMap;
        this.zzc = hashMap2;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zza.getContext(), "native_ad_view_holder_delegate");
        return new zzeu();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzi(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbjc.zzc(this.zza.getContext());
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzis)).booleanValue()) {
            return this.zzd.zzg.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            return zzbmn.zze(((zzbmr) zzcgt.zzb(this.zza.getContext(), "com.google.android.gms.ads.ChimeraNativeAdViewHolderDelegateCreatorImpl", zzar.zza)).zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc)));
        } catch (RemoteException | zzcgs | NullPointerException e) {
            this.zzd.zzh = zzcaf.zza(this.zza.getContext());
            this.zzd.zzh.zzd(e, "ClientApiBroker.createNativeAdViewHolderDelegate");
            return null;
        }
    }
}
