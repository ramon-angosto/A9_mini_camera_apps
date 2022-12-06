package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbu;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzejx implements zzehj {
    private final Context zza;
    private final zzdnd zzb;
    private final Executor zzc;

    public zzejx(Context context, zzdnd zzdnd, Executor executor) {
        this.zza = context;
        this.zzb = zzdnd;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfdw zzfdw, int i) {
        return zzfdw.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        zzdoq zzdoq;
        zzbvv zzB = ((zzffa) zzehf.zzb).zzB();
        zzbvw zzC = ((zzffa) zzehf.zzb).zzC();
        zzbvz zzd = ((zzffa) zzehf.zzb).zzd();
        if (zzd != null && zzc(zzfdw, 6)) {
            zzdoq = zzdoq.zzs(zzd);
        } else if (zzB != null && zzc(zzfdw, 6)) {
            zzdoq = zzdoq.zzad(zzB);
        } else if (zzB != null && zzc(zzfdw, 2)) {
            zzdoq = zzdoq.zzab(zzB);
        } else if (zzC != null && zzc(zzfdw, 6)) {
            zzdoq = zzdoq.zzae(zzC);
        } else if (zzC == null || !zzc(zzfdw, 1)) {
            throw new zzekr(1, "No native ad mappers");
        } else {
            zzdoq = zzdoq.zzac(zzC);
        }
        if (zzfdw.zza.zza.zzg.contains(Integer.toString(zzdoq.zzc()))) {
            zzdos zze = this.zzb.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdpc(zzdoq), new zzdqq(zzC, zzB, zzd, (byte[]) null));
            ((zzeix) zzehf.zzc).zzc(zze.zzi());
            zze.zzd().zzj(new zzcuq((zzffa) zzehf.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzekr(1, "No corresponding native ad listener");
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        zzfef zzfef = zzfdw.zza.zza;
        ((zzffa) zzehf.zzb).zzo(this.zza, zzfdw.zza.zza.zzd, zzfdk.zzw.toString(), zzbu.zzl(zzfdk.zzt), (zzbvq) zzehf.zzc, zzfef.zzi, zzfef.zzg);
    }
}
