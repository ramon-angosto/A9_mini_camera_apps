package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdcd implements zzdeo, zzddv {
    private final Context zza;
    private final zzfdk zzb;
    private final zzbzh zzc;

    public zzdcd(Context context, zzfdk zzfdk, zzbzh zzbzh, byte[] bArr) {
        this.zza = context;
        this.zzb = zzfdk;
        this.zzc = zzbzh;
    }

    public final void zzbq(Context context) {
    }

    public final void zzbs(Context context) {
    }

    public final void zzbt(Context context) {
    }

    public final void zzn() {
        zzbzi zzbzi = this.zzb.zzae;
        if (zzbzi != null && zzbzi.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzae.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzae.zzb);
            }
        }
    }
}
