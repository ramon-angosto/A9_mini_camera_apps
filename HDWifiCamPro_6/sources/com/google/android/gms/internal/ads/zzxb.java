package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzxb {
    private static final Comparator zza = zzwx.zza;
    private static final Comparator zzb = zzwy.zza;
    private final ArrayList zzc = new ArrayList();
    private final zzxa[] zzd = new zzxa[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzxb(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = ((float) this.zzg) * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzxa zzxa = (zzxa) this.zzc.get(i2);
            i += zzxa.zzb;
            if (((float) i) >= f2) {
                return zzxa.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzxa) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzxa zzxa;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzxa[] zzxaArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzxa = zzxaArr[i3];
        } else {
            zzxa = new zzxa((zzwz) null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzxa.zza = i4;
        zzxa.zzb = i;
        zzxa.zzc = f;
        this.zzc.add(zzxa);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 > 2000) {
                int i6 = i5 - 2000;
                zzxa zzxa2 = (zzxa) this.zzc.get(0);
                int i7 = zzxa2.zzb;
                if (i7 <= i6) {
                    this.zzg -= i7;
                    this.zzc.remove(0);
                    int i8 = this.zzh;
                    if (i8 < 5) {
                        zzxa[] zzxaArr2 = this.zzd;
                        this.zzh = i8 + 1;
                        zzxaArr2[i8] = zzxa2;
                    }
                } else {
                    zzxa2.zzb = i7 - i6;
                    this.zzg -= i6;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
