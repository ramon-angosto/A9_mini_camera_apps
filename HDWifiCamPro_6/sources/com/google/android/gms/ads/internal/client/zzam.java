package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzam extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbvk zzc;
    final /* synthetic */ zzau zzd;

    zzam(zzau zzau, Context context, String str, zzbvk zzbvk) {
        this.zzd = zzau;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbvk;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zza, "native_ad");
        return new zzeo();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 223104000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbjc.zzc(this.zza);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzis)).booleanValue()) {
            return this.zzd.zzb.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            IBinder zze = ((zzbp) zzcgt.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzal.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 223104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzbo ? (zzbo) queryLocalInterface : new zzbm(zze);
        } catch (RemoteException | zzcgs | NullPointerException e) {
            this.zzd.zzh = zzcaf.zza(this.zza);
            this.zzd.zzh.zzd(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
