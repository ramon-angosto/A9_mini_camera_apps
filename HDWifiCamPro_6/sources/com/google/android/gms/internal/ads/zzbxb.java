package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzbxb extends zzarz implements zzbxd {
    zzbxb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzdk zze() throws RemoteException {
        Parcel zzbk = zzbk(5, zza());
        zzdk zzb = zzdj.zzb(zzbk.readStrongBinder());
        zzbk.recycle();
        return zzb;
    }

    public final zzbxq zzf() throws RemoteException {
        Parcel zzbk = zzbk(2, zza());
        zzbxq zzbxq = (zzbxq) zzasb.zza(zzbk, zzbxq.CREATOR);
        zzbk.recycle();
        return zzbxq;
    }

    public final zzbxq zzg() throws RemoteException {
        Parcel zzbk = zzbk(3, zza());
        zzbxq zzbxq = (zzbxq) zzasb.zza(zzbk, zzbxq.CREATOR);
        zzbk.recycle();
        return zzbxq;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbxg zzbxg) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zza.writeString(str);
        zzasb.zze(zza, bundle);
        zzasb.zze(zza, bundle2);
        zzasb.zze(zza, zzq);
        zzasb.zzg(zza, zzbxg);
        zzbl(1, zza);
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwr zzbwr, zzbvq zzbvq, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbwr);
        zzasb.zzg(zza, zzbvq);
        zzasb.zze(zza, zzq);
        zzbl(13, zza);
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwr zzbwr, zzbvq zzbvq, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbwr);
        zzasb.zzg(zza, zzbvq);
        zzasb.zze(zza, zzq);
        zzbl(21, zza);
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwu zzbwu, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbwu);
        zzasb.zzg(zza, zzbvq);
        zzbl(14, zza);
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwx zzbwx, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbwx);
        zzasb.zzg(zza, zzbvq);
        zzbl(18, zza);
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwx zzbwx, zzbvq zzbvq, zzbls zzbls) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbwx);
        zzasb.zzg(zza, zzbvq);
        zzasb.zze(zza, zzbls);
        zzbl(22, zza);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbxa zzbxa, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbxa);
        zzasb.zzg(zza, zzbvq);
        zzbl(20, zza);
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbxa zzbxa, zzbvq zzbvq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzasb.zze(zza, zzl);
        zzasb.zzg(zza, iObjectWrapper);
        zzasb.zzg(zza, zzbxa);
        zzasb.zzg(zza, zzbvq);
        zzbl(16, zza);
    }

    public final void zzp(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbl(19, zza);
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        Parcel zzbk = zzbk(15, zza);
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        Parcel zzbk = zzbk(17, zza);
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
