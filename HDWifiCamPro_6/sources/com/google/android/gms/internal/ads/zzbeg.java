package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbeg implements Runnable {
    public final /* synthetic */ zzbej zza;
    public final /* synthetic */ zzbea zzb;
    public final /* synthetic */ zzbeb zzc;
    public final /* synthetic */ zzchh zzd;

    public /* synthetic */ zzbeg(zzbej zzbej, zzbea zzbea, zzbeb zzbeb, zzchh zzchh) {
        this.zza = zzbej;
        this.zzb = zzbea;
        this.zzc = zzbeb;
        this.zzd = zzchh;
    }

    public final void run() {
        zzbdy zzbdy;
        zzbej zzbej = this.zza;
        zzbea zzbea = this.zzb;
        zzbeb zzbeb = this.zzc;
        zzchh zzchh = this.zzd;
        try {
            zzbed zzq = zzbea.zzq();
            if (zzbea.zzp()) {
                zzbdy = zzq.zzg(zzbeb);
            } else {
                zzbdy = zzq.zzf(zzbeb);
            }
            if (!zzbdy.zze()) {
                zzchh.zze(new RuntimeException("No entry contents."));
                zzbel.zze(zzbej.zzc);
                return;
            }
            zzbei zzbei = new zzbei(zzbej, zzbdy.zzc(), 1);
            int read = zzbei.read();
            if (read != -1) {
                zzbei.unread(read);
                zzchh.zzd(zzben.zzb(zzbei, zzbdy.zzd(), zzbdy.zzg(), zzbdy.zza(), zzbdy.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zze.zzh("Unable to obtain a cache service instance.", e);
            zzchh.zze(e);
            zzbel.zze(zzbej.zzc);
        }
    }
}
