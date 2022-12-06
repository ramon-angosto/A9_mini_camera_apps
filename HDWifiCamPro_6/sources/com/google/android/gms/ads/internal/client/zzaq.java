package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzaq extends zzav {
    final /* synthetic */ FrameLayout zza;
    final /* synthetic */ FrameLayout zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ zzau zzd;

    zzaq(zzau zzau, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzd = zzau;
        this.zza = frameLayout;
        this.zzb = frameLayout2;
        this.zzc = context;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zzc, "native_ad_view_delegate");
        return new zzet();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzh(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbjc.zzc(this.zzc);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzis)).booleanValue()) {
            return this.zzd.zzd.zza(this.zzc, this.zza, this.zzb);
        }
        try {
            return zzbmh.zzbB(((zzbml) zzcgt.zzb(this.zzc, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", zzap.zza)).zze(ObjectWrapper.wrap(this.zzc), ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), 223104000));
        } catch (RemoteException | zzcgs | NullPointerException e) {
            this.zzd.zzh = zzcaf.zza(this.zzc);
            this.zzd.zzh.zzd(e, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }
}
