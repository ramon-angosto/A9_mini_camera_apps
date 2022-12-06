package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzw;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeqn implements zzevd {
    private final zzw zza;
    private final zzcgv zzb;
    private final boolean zzc;

    public zzeqn(zzw zzw, zzcgv zzcgv, boolean z) {
        this.zza = zzw;
        this.zzb = zzcgv;
        this.zzc = z;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) zzay.zzc().zzb(zzbjc.zzeq)).intValue()) {
            bundle.putString("app_open_version", "2");
        }
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzer)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        zzw zzw = this.zza;
        if (zzw != null) {
            int i = zzw.zza;
            if (i == 1) {
                bundle.putString("avo", TtmlNode.TAG_P);
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
