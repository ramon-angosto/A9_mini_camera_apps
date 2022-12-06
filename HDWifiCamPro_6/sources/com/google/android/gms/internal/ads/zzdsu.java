package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdsu extends zzbmx {
    private final Context zza;
    private final zzdoq zzb;
    private zzdpq zzc;
    /* access modifiers changed from: private */
    public zzdol zzd;

    public zzdsu(Context context, zzdoq zzdoq, zzdpq zzdpq, zzdol zzdol) {
        this.zza = context;
        this.zzb = zzdoq;
        this.zzc = zzdpq;
        this.zzd = zzdol;
    }

    public final zzdk zze() {
        return this.zzb.zzj();
    }

    public final zzbmb zzf() throws RemoteException {
        return this.zzd.zza().zza();
    }

    public final zzbme zzg(String str) {
        return (zzbme) this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzi() {
        return this.zzb.zzy();
    }

    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    public final List zzk() {
        SimpleArrayMap zzh = this.zzb.zzh();
        SimpleArrayMap zzi = this.zzb.zzi();
        String[] strArr = new String[(zzh.size() + zzi.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzh.size()) {
            strArr[i3] = (String) zzh.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzi.size()) {
            strArr[i3] = (String) zzi.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final void zzl() {
        zzdol zzdol = this.zzd;
        if (zzdol != null) {
            zzdol.zzV();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzm() {
        String zzA = this.zzb.zzA();
        if ("Google".equals(zzA)) {
            zze.zzj("Illegal argument specified for omid partner name.");
        } else if (TextUtils.isEmpty(zzA)) {
            zze.zzj("Not starting OMID session. OM partner name has not been configured.");
        } else {
            zzdol zzdol = this.zzd;
            if (zzdol != null) {
                zzdol.zzq(zzA, false);
            }
        }
    }

    public final void zzn(String str) {
        zzdol zzdol = this.zzd;
        if (zzdol != null) {
            zzdol.zzy(str);
        }
    }

    public final void zzo() {
        zzdol zzdol = this.zzd;
        if (zzdol != null) {
            zzdol.zzB();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdol zzdol;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzu() != null && (zzdol = this.zzd) != null) {
            zzdol.zzC((View) unwrap);
        }
    }

    public final boolean zzq() {
        zzdol zzdol = this.zzd;
        if ((zzdol == null || zzdol.zzO()) && this.zzb.zzq() != null && this.zzb.zzr() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdpq zzdpq;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdpq = this.zzc) == null || !zzdpq.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzr().zzaq(new zzdst(this));
        return true;
    }

    public final boolean zzs() {
        IObjectWrapper zzu = this.zzb.zzu();
        if (zzu != null) {
            zzt.zzA().zzd(zzu);
            if (this.zzb.zzq() == null) {
                return true;
            }
            this.zzb.zzq().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zze.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
