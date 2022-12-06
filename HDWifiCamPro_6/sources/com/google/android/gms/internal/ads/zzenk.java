package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbf;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzl;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzenk extends zzbk {
    private final zzeoq zza;

    public zzenk(Context context, zzcom zzcom, zzfed zzfed, zzdpb zzdpb, zzbf zzbf) {
        zzeos zzeos = new zzeos(zzdpb, zzcom.zzx());
        zzeos.zze(zzbf);
        this.zza = new zzeoq(new zzepc(zzcom, context, zzeos, zzfed), zzfed.zzI());
    }

    public final synchronized String zze() {
        return this.zza.zza();
    }

    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    public final void zzg(zzl zzl) throws RemoteException {
        this.zza.zzd(zzl, 1);
    }

    public final synchronized void zzh(zzl zzl, int i) throws RemoteException {
        this.zza.zzd(zzl, i);
    }

    public final synchronized boolean zzi() throws RemoteException {
        return this.zza.zze();
    }
}
