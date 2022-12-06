package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdrp implements zzfyn {
    public final /* synthetic */ zzfzp zza;

    public /* synthetic */ zzdrp(zzfzp zzfzp) {
        this.zza = zzfzp;
    }

    public final zzfzp zza(Object obj) {
        zzfzp zzfzp = this.zza;
        zzcmp zzcmp = (zzcmp) obj;
        if (zzcmp != null && zzcmp.zzs() != null) {
            return zzfzp;
        }
        throw new zzekr(1, "Retrieve video view in html5 ad response failed.");
    }
}
