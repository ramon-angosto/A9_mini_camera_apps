package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdzr extends zzbrt {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfjj zzd;
    final /* synthetic */ zzchh zze;
    final /* synthetic */ zzdzs zzf;

    zzdzr(zzdzs zzdzs, Object obj, String str, long j, zzfjj zzfjj, zzchh zzchh) {
        this.zzf = zzdzs;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfjj;
        this.zze = zzchh;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
            this.zzf.zzo.zzb(this.zzb, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
            zzfjw zze2 = this.zzf.zzp;
            zzfjj zzfjj = this.zzd;
            zzfjj.zze(false);
            zze2.zzb(zzfjj.zzj());
            this.zze.zzd(false);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfjw zze2 = this.zzf.zzp;
            zzfjj zzfjj = this.zzd;
            zzfjj.zze(true);
            zze2.zzb(zzfjj.zzj());
            this.zze.zzd(true);
        }
    }
}
