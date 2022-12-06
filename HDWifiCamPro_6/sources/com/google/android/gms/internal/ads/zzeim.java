package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeim implements zzehj {
    private final Context zza;
    private final zzcxz zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbvt zzd;

    public zzeim(Context context, zzcxz zzcxz) {
        this.zza = context;
        this.zzb = zzcxz;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek, zzekr {
        View view;
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgJ)).booleanValue() || !zzfdk.zzai) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfek(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzfzg.zzn(zzfzg.zzi((Object) null), new zzeii(this, view, zzfdk), zzchc.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfek(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfek(e2);
            }
        }
        zzcxd zza2 = this.zzb.zza(new zzczt(zzfdw, zzfdk, zzehf.zza), new zzcxj(view, (zzcmp) null, new zzeij(zzehf), (zzfdl) zzfdk.zzv.get(0)));
        zza2.zzg().zza(view);
        ((zzeix) zzehf.zzc).zzc(zza2.zzh());
        return zza2.zza();
    }

    public final void zzb(zzfdw zzfdw, zzfdk zzfdk, zzehf zzehf) throws zzfek {
        try {
            ((zzbxd) zzehf.zzb).zzp(zzfdk.zzaa);
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzgJ)).booleanValue() || !zzfdk.zzai) {
                ((zzbxd) zzehf.zzb).zzi(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeil(this, zzehf, (zzeik) null), (zzbvq) zzehf.zzc, zzfdw.zza.zza.zze);
            } else {
                ((zzbxd) zzehf.zzb).zzj(zzfdk.zzV, zzfdk.zzw.toString(), zzfdw.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeil(this, zzehf, (zzeik) null), (zzbvq) zzehf.zzc, zzfdw.zza.zza.zze);
            }
        } catch (RemoteException e) {
            throw new zzfek(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzc(View view, zzfdk zzfdk, Object obj) throws Exception {
        return zzfzg.zzi(zzcyq.zza(this.zza, view, zzfdk));
    }
}
