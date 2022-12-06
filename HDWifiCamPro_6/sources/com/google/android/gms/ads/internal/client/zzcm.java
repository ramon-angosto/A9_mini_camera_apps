package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbvk;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface zzcm extends IInterface {
    float zze() throws RemoteException;

    String zzf() throws RemoteException;

    List zzg() throws RemoteException;

    void zzh(String str) throws RemoteException;

    void zzi() throws RemoteException;

    void zzj() throws RemoteException;

    void zzk(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(zzcy zzcy) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzn(zzbvk zzbvk) throws RemoteException;

    void zzo(boolean z) throws RemoteException;

    void zzp(float f) throws RemoteException;

    void zzq(String str) throws RemoteException;

    void zzr(zzbrx zzbrx) throws RemoteException;

    void zzs(zzez zzez) throws RemoteException;

    boolean zzt() throws RemoteException;
}
