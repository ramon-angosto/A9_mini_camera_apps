package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzela implements zzehj {
    private final Context zza;
    private final zzduh zzb;

    public zzela(Context context, zzduh zzduh) {
        this.zza = context;
        this.zzb = zzduh;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        zzejg zzejg = new zzejg(zzfdk, (zzbxd) zzehf.zzb, true);
        zzdud zze = this.zzb.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdue(zzejg));
        zzejg.zzb(zze.zzc());
        ((zzeix) zzehf.zzc).zzc(zze.zzn());
        return zze.zzk();
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        try {
            ((zzbxd) zzehf.zzb).zzp(zzfdk.zzaa);
            if (zzfdw.zza.zza.zzo.zza == 3) {
                ((zzbxd) zzehf.zzb).zzn(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekz(this, zzehf, (zzeky) null), (zzbvq) zzehf.zzc);
            } else {
                ((zzbxd) zzehf.zzb).zzo(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekz(this, zzehf, (zzeky) null), (zzbvq) zzehf.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
