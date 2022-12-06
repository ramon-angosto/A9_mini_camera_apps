package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbf {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze = 0;

    /* synthetic */ zzbf(zzbd zzbd, zzbe zzbe) {
        int size = zzbd.zzb.size();
        this.zza = (String[]) zzbd.zza.toArray(new String[size]);
        this.zzb = zzc(zzbd.zzb);
        this.zzc = zzc(zzbd.zzc);
        this.zzd = new int[size];
    }

    private static final double[] zzc(List list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public final List zza() {
        ArrayList arrayList = new ArrayList(this.zza.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zza;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzc[i];
            double d2 = this.zzb[i];
            int i2 = this.zzd[i];
            arrayList.add(new zzbc(str, d, d2, ((double) i2) / ((double) this.zze), i2));
            i++;
        }
    }

    public final void zzb(double d) {
        this.zze++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i < dArr.length) {
                double d2 = dArr[i];
                if (d2 <= d && d < this.zzb[i]) {
                    int[] iArr = this.zzd;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= d2) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
