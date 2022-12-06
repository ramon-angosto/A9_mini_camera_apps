package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdzm implements Runnable {
    public final /* synthetic */ zzdzs zza;
    public final /* synthetic */ zzbrx zzb;

    public /* synthetic */ zzdzm(zzdzs zzdzs, zzbrx zzbrx) {
        this.zza = zzdzs;
        this.zzb = zzbrx;
    }

    public final void run() {
        zzdzs zzdzs = this.zza;
        try {
            this.zzb.zzb(zzdzs.zzg());
        } catch (RemoteException e) {
            zzcgp.zzh("", e);
        }
    }
}
