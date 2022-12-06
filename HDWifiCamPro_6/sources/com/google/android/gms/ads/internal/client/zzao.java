package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzao extends zzav {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzau zzb;

    zzao(zzau zzau, Context context) {
        this.zzb = zzau;
        this.zza = context;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzau.zzs(this.zza, "mobile_ads_settings");
        return new zzes();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzcc zzcc) throws RemoteException {
        return zzcc.zzg(ObjectWrapper.wrap(this.zza), 223104000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbjc.zzc(this.zza);
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzis)).booleanValue()) {
            return this.zzb.zzc.zza(this.zza);
        }
        try {
            IBinder zze = ((zzcn) zzcgt.zzb(this.zza, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzan.zza)).zze(ObjectWrapper.wrap(this.zza), 223104000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return queryLocalInterface instanceof zzcm ? (zzcm) queryLocalInterface : new zzck(zze);
        } catch (RemoteException | zzcgs | NullPointerException e) {
            this.zzb.zzh = zzcaf.zza(this.zza);
            this.zzb.zzh.zzd(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
