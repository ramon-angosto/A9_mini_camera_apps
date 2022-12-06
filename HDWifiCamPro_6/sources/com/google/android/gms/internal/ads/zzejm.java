package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzejm implements zzehj {
    private final Context zza;
    private final zzdmh zzb;

    public zzejm(Context context, zzdmh zzdmh) {
        this.zza = context;
        this.zzb = zzdmh;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        zzejg zzejg = new zzejg(zzfdk, (zzbxd) zzehf.zzb, false);
        zzdlh zze = this.zzb.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdlk(zzejg, (zzcmp) null));
        zzejg.zzb(zze.zzc());
        ((zzeix) zzehf.zzc).zzc(zze.zzh());
        return zze.zzg();
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        try {
            ((zzbxd) zzehf.zzb).zzp(zzfdk.zzaa);
            ((zzbxd) zzehf.zzb).zzk(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejl(this, zzehf, (zzejk) null), (zzbvq) zzehf.zzc);
        } catch (RemoteException e) {
            throw new zzfek(e);
        }
    }
}
