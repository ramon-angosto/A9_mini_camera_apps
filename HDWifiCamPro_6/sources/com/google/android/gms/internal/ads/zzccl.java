package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzde;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface zzccl extends IInterface {
    Bundle zzb() throws RemoteException;

    zzdh zzc() throws RemoteException;

    zzcci zzd() throws RemoteException;

    String zze() throws RemoteException;

    void zzf(zzl zzl, zzccs zzccs) throws RemoteException;

    void zzg(zzl zzl, zzccs zzccs) throws RemoteException;

    void zzh(boolean z) throws RemoteException;

    void zzi(zzdb zzdb) throws RemoteException;

    void zzj(zzde zzde) throws RemoteException;

    void zzk(zzcco zzcco) throws RemoteException;

    void zzl(zzccz zzccz) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    boolean zzo() throws RemoteException;

    void zzp(zzcct zzcct) throws RemoteException;
}
