package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbvk;
import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzes extends zzcl {
    private zzbrx zza;

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzbrx zzbrx = this.zza;
        if (zzbrx != null) {
            try {
                zzbrx.zzb(Collections.emptyList());
            } catch (RemoteException e) {
                zzcgp.zzk("Could not notify onComplete event.", e);
            }
        }
    }

    public final float zze() throws RemoteException {
        return 1.0f;
    }

    public final String zzf() {
        return "";
    }

    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzh(String str) throws RemoteException {
    }

    public final void zzi() {
    }

    public final void zzj() throws RemoteException {
        zzcgp.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzcgi.zza.post(new zzer(this));
    }

    public final void zzk(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzl(zzcy zzcy) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzn(zzbvk zzbvk) throws RemoteException {
    }

    public final void zzo(boolean z) throws RemoteException {
    }

    public final void zzp(float f) throws RemoteException {
    }

    public final void zzq(String str) throws RemoteException {
    }

    public final void zzr(zzbrx zzbrx) throws RemoteException {
        this.zza = zzbrx;
    }

    public final void zzs(zzez zzez) throws RemoteException {
    }

    public final boolean zzt() throws RemoteException {
        return false;
    }
}
