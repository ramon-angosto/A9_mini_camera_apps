package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzcco;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzcct;
import com.google.android.gms.internal.ads.zzccz;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzew extends zzcck {
    private static void zzr(zzccs zzccs) {
        zzcgp.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcgi.zza.post(new zzev(zzccs));
    }

    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    public final zzdh zzc() {
        return null;
    }

    public final zzcci zzd() {
        return null;
    }

    public final String zze() throws RemoteException {
        return "";
    }

    public final void zzf(zzl zzl, zzccs zzccs) throws RemoteException {
        zzr(zzccs);
    }

    public final void zzg(zzl zzl, zzccs zzccs) throws RemoteException {
        zzr(zzccs);
    }

    public final void zzh(boolean z) {
    }

    public final void zzi(zzdb zzdb) throws RemoteException {
    }

    public final void zzj(zzde zzde) {
    }

    public final void zzk(zzcco zzcco) throws RemoteException {
    }

    public final void zzl(zzccz zzccz) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }

    public final boolean zzo() throws RemoteException {
        return false;
    }

    public final void zzp(zzcct zzcct) throws RemoteException {
    }
}
