package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzekb implements zzehj {
    private final Context zza;
    private final zzdnd zzb;
    /* access modifiers changed from: private */
    public zzbvz zzc;
    private final zzcgv zzd;

    public zzekb(Context context, zzdnd zzdnd, zzcgv zzcgv) {
        this.zza = context;
        this.zzb = zzdnd;
        this.zzd = zzcgv;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        if (zzfdw.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdoq zzs = zzdoq.zzs(this.zzc);
            if (zzfdw.zza.zza.zzg.contains(Integer.toString(zzs.zzc()))) {
                zzdos zze = this.zzb.zze(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzdpc(zzs), new zzdqq((zzbvw) null, (zzbvv) null, this.zzc, (byte[]) null));
                ((zzeix) zzehf.zzc).zzc(zze.zzh());
                return zze.zza();
            }
            throw new zzekr(1, "No corresponding native ad listener");
        }
        throw new zzekr(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        try {
            ((zzbxd) zzehf.zzb).zzp(zzfdk.zzaa);
            if (this.zzd.zzc < ((Integer) zzay.zzc().zzb(zzbjc.zzbv)).intValue()) {
                ((zzbxd) zzehf.zzb).zzl(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeka(this, zzehf, (zzejz) null), (zzbvq) zzehf.zzc);
            } else {
                ((zzbxd) zzehf.zzb).zzm(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeka(this, zzehf, (zzejz) null), (zzbvq) zzehf.zzc, zzfdw.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzfek(e);
        }
    }
}
