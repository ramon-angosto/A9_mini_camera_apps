package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface zzbxd extends IInterface {
    zzdk zze() throws RemoteException;

    zzbxq zzf() throws RemoteException;

    zzbxq zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbxg zzbxg) throws RemoteException;

    void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwr zzbwr, zzbvq zzbvq, zzq zzq) throws RemoteException;

    void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwr zzbwr, zzbvq zzbvq, zzq zzq) throws RemoteException;

    void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwu zzbwu, zzbvq zzbvq) throws RemoteException;

    void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwx zzbwx, zzbvq zzbvq) throws RemoteException;

    void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbwx zzbwx, zzbvq zzbvq, zzbls zzbls) throws RemoteException;

    void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbxa zzbxa, zzbvq zzbvq) throws RemoteException;

    void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbxa zzbxa, zzbvq zzbvq) throws RemoteException;

    void zzp(String str) throws RemoteException;

    boolean zzq(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;
}
