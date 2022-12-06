package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbvk;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzck extends zzarz implements zzcm {
    zzck(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final float zze() throws RemoteException {
        Parcel zzbk = zzbk(7, zza());
        float readFloat = zzbk.readFloat();
        zzbk.recycle();
        return readFloat;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbk = zzbk(9, zza());
        String readString = zzbk.readString();
        zzbk.recycle();
        return readString;
    }

    public final List zzg() throws RemoteException {
        Parcel zzbk = zzbk(13, zza());
        ArrayList<zzbrq> createTypedArrayList = zzbk.createTypedArrayList(zzbrq.CREATOR);
        zzbk.recycle();
        return createTypedArrayList;
    }

    public final void zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbl(10, zza);
    }

    public final void zzi() throws RemoteException {
        zzbl(15, zza());
    }

    public final void zzj() throws RemoteException {
        zzbl(1, zza());
    }

    public final void zzk(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zzasb.zzg(zza, iObjectWrapper);
        zzbl(6, zza);
    }

    public final void zzl(zzcy zzcy) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzcy);
        zzbl(16, zza);
    }

    public final void zzm(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, iObjectWrapper);
        zza.writeString(str);
        zzbl(5, zza);
    }

    public final void zzn(zzbvk zzbvk) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbvk);
        zzbl(11, zza);
    }

    public final void zzo(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzd(zza, z);
        zzbl(4, zza);
    }

    public final void zzp(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzbl(2, zza);
    }

    public final void zzq(String str) throws RemoteException {
        throw null;
    }

    public final void zzr(zzbrx zzbrx) throws RemoteException {
        Parcel zza = zza();
        zzasb.zzg(zza, zzbrx);
        zzbl(12, zza);
    }

    public final void zzs(zzez zzez) throws RemoteException {
        Parcel zza = zza();
        zzasb.zze(zza, zzez);
        zzbl(14, zza);
    }

    public final boolean zzt() throws RemoteException {
        Parcel zzbk = zzbk(8, zza());
        boolean zzh = zzasb.zzh(zzbk);
        zzbk.recycle();
        return zzh;
    }
}
