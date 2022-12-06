package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeji implements zzehj {
    private final Context zza;
    private final zzdmh zzb;
    private final zzcgv zzc;
    private final Executor zzd;

    public zzeji(Context context, zzcgv zzcgv, zzdmh zzdmh, Executor executor) {
        this.zza = context;
        this.zzc = zzcgv;
        this.zzb = zzdmh;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        zzdlh zze = this.zzb.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdlk(new zzejh(this, zzehf), (zzcmp) null));
        zze.zzd().zzj(new zzcuq((zzffa) zzehf.zzb), this.zzd);
        ((zzeix) zzehf.zzc).zzc(zze.zzi());
        return zze.zzg();
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        ((zzffa) zzehf.zzb).zzn(this.zza, zzfdw.zza.zza.zzd, zzfdk.zzw.toString(), zzbu.zzl(zzfdk.zzt), (zzbvq) zzehf.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzehf zzehf, boolean z, Context context, zzddn zzddn) throws zzdmo {
        try {
            ((zzffa) zzehf.zzb).zzu(z);
            if (this.zzc.zzc < ((Integer) zzay.zzc().zzb(zzbjc.zzaB)).intValue()) {
                ((zzffa) zzehf.zzb).zzv();
            } else {
                ((zzffa) zzehf.zzb).zzw(context);
            }
        } catch (zzfek e) {
            zze.zzi("Cannot show interstitial.");
            throw new zzdmo(e.getCause());
        }
    }
}
