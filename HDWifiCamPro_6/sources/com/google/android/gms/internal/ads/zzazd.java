package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzazd extends zzazh {
    private final SparseArray zza = new SparseArray();
    private final SparseBooleanArray zzb = new SparseBooleanArray();
    private zzazb zzc;

    /* access modifiers changed from: protected */
    public abstract zzayx[] zzb(zzatc[] zzatcArr, zzayt[] zzaytArr, int[][][] iArr) throws zzasi;

    public final zzazi zzc(zzatc[] zzatcArr, zzayt zzayt) throws zzasi {
        zzazc zzazc;
        int[] iArr;
        int i;
        int i2;
        zzatc[] zzatcArr2 = zzatcArr;
        zzayt zzayt2 = zzayt;
        int i3 = 3;
        int[] iArr2 = new int[3];
        zzays[][] zzaysArr = new zzays[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = zzayt2.zzb;
            zzaysArr[i4] = new zzays[i5];
            iArr3[i4] = new int[i5][];
        }
        int[] iArr4 = new int[2];
        for (int i6 = 0; i6 < 2; i6++) {
            zzatcArr2[i6].zze();
            iArr4[i6] = 4;
        }
        int i7 = 0;
        while (i7 < zzayt2.zzb) {
            zzays zzb2 = zzayt2.zzb(i7);
            int i8 = 2;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i9 >= 2) {
                    break;
                }
                zzatc zzatc = zzatcArr2[i9];
                i = i8;
                i2 = i10;
                int i11 = 0;
                while (true) {
                    int i12 = zzb2.zza;
                    if (i11 > 0) {
                        break;
                    }
                    int zzG = zzatc.zzG(zzb2.zzb(i11)) & i3;
                    if (zzG > i2) {
                        if (zzG == i3) {
                            i8 = i9;
                            break;
                        }
                        i = i9;
                        i2 = zzG;
                    }
                    i11++;
                }
                i9++;
                i10 = i2;
                i8 = i;
            }
            if (i8 == 2) {
                int i13 = zzb2.zza;
                iArr = new int[1];
            } else {
                zzatc zzatc2 = zzatcArr2[i8];
                int i14 = zzb2.zza;
                int[] iArr5 = new int[1];
                int i15 = 0;
                while (true) {
                    int i16 = zzb2.zza;
                    if (i15 > 0) {
                        break;
                    }
                    iArr5[i15] = zzatc2.zzG(zzb2.zzb(i15));
                    i15++;
                }
                iArr = iArr5;
            }
            int i17 = iArr2[i8];
            zzaysArr[i8][i17] = zzb2;
            iArr3[i8][i17] = iArr;
            iArr2[i8] = i17 + 1;
            i7++;
            i3 = 3;
        }
        zzayt[] zzaytArr = new zzayt[2];
        int[] iArr6 = new int[2];
        for (int i18 = 0; i18 < 2; i18++) {
            int i19 = iArr2[i18];
            zzaytArr[i18] = new zzayt((zzays[]) Arrays.copyOf(zzaysArr[i18], i19));
            iArr3[i18] = (int[][]) Arrays.copyOf(iArr3[i18], i19);
            iArr6[i18] = zzatcArr2[i18].zzc();
        }
        zzayt zzayt3 = new zzayt((zzays[]) Arrays.copyOf(zzaysArr[2], iArr2[2]));
        zzayx[] zzb3 = zzb(zzatcArr2, zzaytArr, iArr3);
        for (int i20 = 0; i20 < 2; i20++) {
            if (this.zzb.get(i20)) {
                zzb3[i20] = null;
            } else {
                zzayt zzayt4 = zzaytArr[i20];
                Map map = (Map) this.zza.get(i20);
                if (map == null) {
                    zzazc = null;
                } else {
                    zzazc = (zzazc) map.get(zzayt4);
                }
                if (zzazc != null) {
                    throw null;
                }
            }
        }
        zzazb zzazb = new zzazb(iArr6, zzaytArr, iArr4, iArr3, zzayt3);
        zzatd[] zzatdArr = new zzatd[2];
        for (int i21 = 0; i21 < 2; i21++) {
            zzatdArr[i21] = zzb3[i21] != null ? zzatd.zza : null;
        }
        return new zzazi(zzayt2, new zzazf(zzb3, (byte[]) null), zzazb, zzatdArr);
    }

    public final void zzd(Object obj) {
        this.zzc = (zzazb) obj;
    }

    public final void zze(int i, boolean z) {
        if (this.zzb.get(i) != z) {
            this.zzb.put(i, z);
            zzg();
        }
    }
}
