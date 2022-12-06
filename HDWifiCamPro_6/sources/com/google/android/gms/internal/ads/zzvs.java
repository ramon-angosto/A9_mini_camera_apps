package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzvs {
    public final zzcp zza;
    public final int[] zzb;

    public zzvs(zzcp zzcp, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzdw.zzc("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzcp;
        this.zzb = iArr;
    }
}
