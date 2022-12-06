package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzun extends zzup {
    private final zzwh zzd;
    private final zzfvn zze;
    private final zzde zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzun(zzcp zzcp, int[] iArr, int i, zzwh zzwh, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzde zzde) {
        super(zzcp, iArr, 0);
        zzcp zzcp2 = zzcp;
        int[] iArr2 = iArr;
        this.zzd = zzwh;
        this.zze = zzfvn.zzm(list);
        this.zzf = zzde;
    }

    static /* bridge */ /* synthetic */ zzfvn zzf(zzvs[] zzvsArr) {
        int i;
        int i2;
        double d;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 2;
            i2 = 1;
            if (i4 >= 2) {
                break;
            }
            zzvs zzvs = zzvsArr[i4];
            if (zzvs == null || zzvs.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfvk zzi = zzfvn.zzi();
                zzi.zze(new zzul(0, 0));
                arrayList.add(zzi);
            }
            i4++;
        }
        long[][] jArr = new long[2][];
        for (int i5 = 0; i5 < 2; i5++) {
            zzvs zzvs2 = zzvsArr[i5];
            if (zzvs2 == null) {
                jArr[i5] = new long[0];
            } else {
                jArr[i5] = new long[zzvs2.zzb.length];
                int i6 = 0;
                while (true) {
                    int[] iArr = zzvs2.zzb;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    jArr[i5][i6] = (long) zzvs2.zza.zzb(iArr[i6]).zzi;
                    i6++;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr2 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr3 = jArr[i7];
            jArr2[i7] = jArr3.length == 0 ? 0 : jArr3[0];
        }
        zzg(arrayList, jArr2);
        zzfvy zza = zzfwq.zzc(zzfwv.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < i) {
            int length = jArr[i8].length;
            if (length > i2) {
                double[] dArr = new double[length];
                int i9 = i3;
                while (true) {
                    long[] jArr4 = jArr[i8];
                    double d2 = 0.0d;
                    if (i9 >= jArr4.length) {
                        break;
                    }
                    long j = jArr4[i9];
                    if (j != -1) {
                        d2 = Math.log((double) j);
                    }
                    dArr[i9] = d2;
                    i9++;
                }
                double d3 = dArr[dArr.length - 1] - dArr[i3];
                int i10 = i3;
                while (i10 < dArr.length - 1) {
                    int i11 = i10 + 1;
                    double d4 = (dArr[i10] + dArr[i11]) * 0.5d;
                    if (d3 == 0.0d) {
                        d = 1.0d;
                    } else {
                        d = (d4 - dArr[i3]) / d3;
                    }
                    zza.zzs(Double.valueOf(d), Integer.valueOf(i8));
                    i10 = i11;
                    i3 = 0;
                }
            }
            i8++;
            i3 = 0;
            i = 2;
            i2 = 1;
        }
        zzfvn zzm = zzfvn.zzm(zza.zzt());
        for (int i12 = 0; i12 < zzm.size(); i12++) {
            int intValue = ((Integer) zzm.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr2[intValue] = jArr[intValue][i13];
            zzg(arrayList, jArr2);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j2 = jArr2[i14];
                jArr2[i14] = j2 + j2;
            }
        }
        zzg(arrayList, jArr2);
        zzfvk zzi2 = zzfvn.zzi();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfvk zzfvk = (zzfvk) arrayList.get(i15);
            zzi2.zze(zzfvk == null ? zzfvn.zzo() : zzfvk.zzg());
        }
        return zzi2.zzg();
    }

    private static void zzg(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfvk zzfvk = (zzfvk) list.get(i2);
            if (zzfvk != null) {
                zzfvk.zze(new zzul(j, jArr[i2]));
            }
        }
    }
}
