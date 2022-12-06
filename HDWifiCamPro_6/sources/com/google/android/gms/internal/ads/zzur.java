package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzur implements zzvm {
    public final /* synthetic */ zzvr zza;
    public final /* synthetic */ zzvf zzb;
    public final /* synthetic */ boolean zzc;

    public /* synthetic */ zzur(zzvr zzvr, zzvf zzvf, boolean z) {
        this.zza = zzvr;
        this.zzb = zzvf;
        this.zzc = z;
    }

    public final List zza(int i, zzcp zzcp, int[] iArr) {
        zzvr zzvr = this.zza;
        zzvf zzvf = this.zzb;
        boolean z = this.zzc;
        zzuq zzuq = new zzuq(zzvr);
        zzfvk zzi = zzfvn.zzi();
        zzcp zzcp2 = zzcp;
        int i2 = 0;
        while (true) {
            int i3 = zzcp2.zzb;
            if (i2 > 0) {
                return zzi.zzg();
            }
            zzi.zze(new zzuz(i, zzcp, i2, zzvf, iArr[i2], z, zzuq));
            i2++;
        }
    }
}
