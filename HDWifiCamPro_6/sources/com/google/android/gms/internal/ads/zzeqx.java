package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeqx implements zzevd {
    final String zza;
    final int zzb;

    public zzeqx(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.zza) && this.zzb != -1) {
            Bundle zza2 = zzfeq.zza(bundle, "pii");
            bundle.putBundle("pii", zza2);
            zza2.putString("pvid", this.zza);
            zza2.putInt("pvid_s", this.zzb);
        }
    }
}
