package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzuv implements zzvm {
    public final /* synthetic */ zzvf zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzuv(zzvf zzvf, String str) {
        this.zza = zzvf;
        this.zzb = str;
    }

    public final List zza(int i, zzcp zzcp, int[] iArr) {
        zzvf zzvf = this.zza;
        String str = this.zzb;
        int i2 = zzvr.zzb;
        zzfvk zzi = zzfvn.zzi();
        int i3 = 0;
        while (true) {
            int i4 = zzcp.zzb;
            if (i3 > 0) {
                return zzi.zzg();
            }
            zzi.zze(new zzvl(i, zzcp, i3, zzvf, iArr[i3], str));
            i3++;
        }
    }
}
