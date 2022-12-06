package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzbo;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcm;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzae;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbjc;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbqr;
import com.google.android.gms.internal.ads.zzbqu;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzbyv;
import com.google.android.gms.internal.ads.zzbzc;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcom;
import com.google.android.gms.internal.ads.zzdpk;
import com.google.android.gms.internal.ads.zzdpm;
import com.google.android.gms.internal.ads.zzdyy;
import com.google.android.gms.internal.ads.zzenj;
import com.google.android.gms.internal.ads.zzeyi;
import com.google.android.gms.internal.ads.zzeyj;
import com.google.android.gms.internal.ads.zzezw;
import com.google.android.gms.internal.ads.zzfbp;
import com.google.android.gms.internal.ads.zzfdd;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class ClientApi extends zzcb {
    public final zzbo zzb(IObjectWrapper iObjectWrapper, String str, zzbvk zzbvk, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzenj(zzcom.zza(context, zzbvk, i), context, str);
    }

    public final zzbs zzc(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbvk zzbvk, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeyi zzr = zzcom.zza(context, zzbvk, i).zzr();
        zzr.zza(str);
        zzr.zzb(context);
        zzeyj zzc = zzr.zzc();
        if (i >= ((Integer) zzay.zzc().zzb(zzbjc.zzeq)).intValue()) {
            return zzc.zzb();
        }
        return zzc.zza();
    }

    public final zzbs zzd(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbvk zzbvk, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezw zzs = zzcom.zza(context, zzbvk, i).zzs();
        zzs.zzc(context);
        zzs.zza(zzq);
        zzs.zzb(str);
        return zzs.zzd().zza();
    }

    public final zzbs zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbvk zzbvk, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbp zzt = zzcom.zza(context, zzbvk, i).zzt();
        zzt.zzc(context);
        zzt.zza(zzq);
        zzt.zzb(str);
        return zzt.zzd().zza();
    }

    public final zzbs zzf(IObjectWrapper iObjectWrapper, zzq zzq, String str, int i) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzq, str, new zzcgv(223104000, i, true, false));
    }

    public final zzcm zzg(IObjectWrapper iObjectWrapper, int i) {
        return zzcom.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), (zzbvk) null, i).zzb();
    }

    public final zzbmi zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdpm((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 223104000);
    }

    public final zzbmo zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdpk((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbqu zzj(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i, zzbqr zzbqr) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdyy zzj = zzcom.zza(context, zzbvk, i).zzj();
        zzj.zzb(context);
        zzj.zza(zzbqr);
        return zzj.zzc().zzd();
    }

    public final zzbyv zzk(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i) {
        return zzcom.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvk, i).zzl();
    }

    public final zzbzc zzl(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzt(activity);
        }
        int i = zza.zzk;
        if (i == 1) {
            return new zzs(activity);
        }
        if (i == 2) {
            return new zzae(activity);
        }
        if (i == 3) {
            return new zzaf(activity);
        }
        if (i != 4) {
            return i != 5 ? new zzt(activity) : new zzac(activity);
        }
        return new zzy(activity, zza);
    }

    public final zzcbv zzm(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfdd zzu = zzcom.zza(context, zzbvk, i).zzu();
        zzu.zzb(context);
        return zzu.zzc().zzb();
    }

    public final zzccl zzn(IObjectWrapper iObjectWrapper, String str, zzbvk zzbvk, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfdd zzu = zzcom.zza(context, zzbvk, i).zzu();
        zzu.zzb(context);
        zzu.zza(str);
        return zzu.zzc().zza();
    }

    public final zzcfg zzo(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i) {
        return zzcom.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbvk, i).zzo();
    }
}
