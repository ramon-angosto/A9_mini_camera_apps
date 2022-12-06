package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
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

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface zzcc extends IInterface {
    zzbo zzb(IObjectWrapper iObjectWrapper, String str, zzbvk zzbvk, int i) throws RemoteException;

    zzbs zzc(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbvk zzbvk, int i) throws RemoteException;

    zzbs zzd(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbvk zzbvk, int i) throws RemoteException;

    zzbs zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbvk zzbvk, int i) throws RemoteException;

    zzbs zzf(IObjectWrapper iObjectWrapper, zzq zzq, String str, int i) throws RemoteException;

    zzcm zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    zzbmi zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;

    zzbmo zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzbqu zzj(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i, zzbqr zzbqr) throws RemoteException;

    zzbyv zzk(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i) throws RemoteException;

    zzbzc zzl(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzcbv zzm(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i) throws RemoteException;

    zzccl zzn(IObjectWrapper iObjectWrapper, String str, zzbvk zzbvk, int i) throws RemoteException;

    zzcfg zzo(IObjectWrapper iObjectWrapper, zzbvk zzbvk, int i) throws RemoteException;
}
