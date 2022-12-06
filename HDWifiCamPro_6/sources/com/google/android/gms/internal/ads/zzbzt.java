package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzdr;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbzt {
    private static zzcfg zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final zzdr zzd;

    public zzbzt(Context context, AdFormat adFormat, zzdr zzdr) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzdr;
    }

    public static zzcfg zza(Context context) {
        zzcfg zzcfg;
        synchronized (zzbzt.class) {
            if (zza == null) {
                zza = zzaw.zza().zzq(context, new zzbvh());
            }
            zzcfg = zza;
        }
        return zzcfg;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzl zzl;
        zzcfg zza2 = zza(this.zzb);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzb);
        zzdr zzdr = this.zzd;
        if (zzdr == null) {
            zzl = new zzm().zza();
        } else {
            zzl = zzp.zza.zza(this.zzb, zzdr);
        }
        try {
            zza2.zze(wrap, new zzcfk((String) null, this.zzc.name(), (zzq) null, zzl), new zzbzs(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
