package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzbvc implements Runnable {
    public final /* synthetic */ zzbvd zza;
    public final /* synthetic */ Context zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbvc(zzbvd zzbvd, Context context, String str) {
        this.zza = zzbvd;
        this.zzb = context;
        this.zzc = str;
    }

    public final void run() {
        Context context = this.zzb;
        String str = this.zzc;
        zzbjc.zzc(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzay.zzc().zzb(zzbjc.zzaf)).booleanValue());
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzam)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        try {
            ((zzcoj) zzcgt.zzb(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzbvb.zza)).zze(ObjectWrapper.wrap(context), new zzbva(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzcgs | NullPointerException e) {
            zzcgp.zzl("#007 Could not call remote method.", e);
        }
    }
}
