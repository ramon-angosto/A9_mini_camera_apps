package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdzq implements zzfzc {
    final /* synthetic */ zzdzs zza;

    zzdzq(zzdzs zzdzs) {
        this.zza = zzdzs;
    }

    public final void zza(Throwable th) {
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (zzt.zzB().elapsedRealtime() - this.zza.zzd));
            this.zza.zze.zze(new Exception());
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        String str = (String) obj;
        synchronized (this) {
            this.zza.zzc = true;
            this.zza.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (zzt.zzB().elapsedRealtime() - this.zza.zzd));
            this.zza.zzi.execute(new zzdzp(this, str));
        }
    }
}
