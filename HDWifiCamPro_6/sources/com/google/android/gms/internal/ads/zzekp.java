package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzekp {
    private final zzfeu zza;
    private final zzdvi zzb;
    private final zzdxq zzc;
    private final zzfir zzd;

    public zzekp(zzfeu zzfeu, zzdvi zzdvi, zzdxq zzdxq, zzfir zzfir) {
        this.zza = zzfeu;
        this.zzb = zzdvi;
        this.zzc = zzdxq;
        this.zzd = zzfir;
    }

    public final void zza(zzfdn zzfdn, zzfdk zzfdk, int i, @Nullable zzehg zzehg, long j) {
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhs)).booleanValue()) {
            zzfiq zzb2 = zzfiq.zzb("adapter_status");
            zzb2.zzg(zzfdn);
            zzb2.zzf(zzfdk);
            zzb2.zza("adapter_l", String.valueOf(j));
            zzb2.zza("sc", Integer.toString(i));
            if (zzehg != null) {
                zzb2.zza("arec", Integer.toString(zzehg.zzb().zza));
                String zza2 = this.zza.zza(zzehg.getMessage());
                if (zza2 != null) {
                    zzb2.zza("areec", zza2);
                }
            }
            zzdvh zzb3 = this.zzb.zzb(zzfdk.zzu);
            if (zzb3 != null) {
                zzb2.zza("ancn", zzb3.zza);
                zzbxq zzbxq = zzb3.zzb;
                if (zzbxq != null) {
                    zzb2.zza("adapter_v", zzbxq.toString());
                }
                zzbxq zzbxq2 = zzb3.zzc;
                if (zzbxq2 != null) {
                    zzb2.zza("adapter_sv", zzbxq2.toString());
                }
            }
            this.zzd.zzb(zzb2);
            return;
        }
        zzdxp zza3 = this.zzc.zza();
        zza3.zze(zzfdn);
        zza3.zzd(zzfdk);
        zza3.zzb("action", "adapter_status");
        zza3.zzb("adapter_l", String.valueOf(j));
        zza3.zzb("sc", Integer.toString(i));
        if (zzehg != null) {
            zza3.zzb("arec", Integer.toString(zzehg.zzb().zza));
            String zza4 = this.zza.zza(zzehg.getMessage());
            if (zza4 != null) {
                zza3.zzb("areec", zza4);
            }
        }
        zzdvh zzb4 = this.zzb.zzb(zzfdk.zzu);
        if (zzb4 != null) {
            zza3.zzb("ancn", zzb4.zza);
            zzbxq zzbxq3 = zzb4.zzb;
            if (zzbxq3 != null) {
                zza3.zzb("adapter_v", zzbxq3.toString());
            }
            zzbxq zzbxq4 = zzb4.zzc;
            if (zzbxq4 != null) {
                zza3.zzb("adapter_sv", zzbxq4.toString());
            }
        }
        zza3.zzg();
    }
}
