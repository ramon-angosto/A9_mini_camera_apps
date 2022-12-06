package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdk;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface zzbsf extends IInterface {
    zzdk zzb() throws RemoteException;

    zzbmb zzc() throws RemoteException;

    void zzd() throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbsi zzbsi) throws RemoteException;
}
