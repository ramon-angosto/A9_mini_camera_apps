package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdzh implements Runnable {
    public final /* synthetic */ zzdzs zza;
    public final /* synthetic */ zzchh zzb;

    public /* synthetic */ zzdzh(zzdzs zzdzs, zzchh zzchh) {
        this.zza = zzdzs;
        this.zzb = zzchh;
    }

    public final void run() {
        zzchh zzchh = this.zzb;
        String zzc = zzt.zzo().zzh().zzh().zzc();
        if (!TextUtils.isEmpty(zzc)) {
            zzchh.zzd(zzc);
        } else {
            zzchh.zze(new Exception());
        }
    }
}
