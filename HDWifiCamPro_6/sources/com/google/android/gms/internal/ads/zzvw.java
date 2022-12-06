package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzvw extends zzvz {
    private zzvv zza;

    /* access modifiers changed from: protected */
    public abstract Pair zzb(zzvv zzvv, int[][][] iArr, int[] iArr2, zzsi zzsi, zzcn zzcn) throws zzha;

    public final zzwa zzn(zzkb[] zzkbArr, zzuh zzuh, zzsi zzsi, zzcn zzcn) throws zzha {
        boolean z;
        int[] iArr;
        zzuh zzuh2 = zzuh;
        int[] iArr2 = new int[3];
        zzcp[][] zzcpArr = new zzcp[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzuh2.zzc;
            zzcpArr[i] = new zzcp[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzkbArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzuh2.zzc) {
            zzcp zzb = zzuh2.zzb(i5);
            int i6 = zzb.zzd;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzkb zzkb = zzkbArr[i8];
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    int i12 = zzb.zzb;
                    if (i10 > 0) {
                        break;
                    }
                    i11 = Math.max(i11, zzkb.zzO(zzb.zzb(i10)) & 7);
                    i10++;
                }
                boolean z3 = iArr2[i8] == 0;
                if (i11 > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = i11;
                } else if (i11 == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = i11;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                int i13 = zzb.zzb;
                iArr = new int[1];
            } else {
                zzkb zzkb2 = zzkbArr[i7];
                int i14 = zzb.zzb;
                int[] iArr5 = new int[1];
                int i15 = 0;
                while (true) {
                    int i16 = zzb.zzb;
                    if (i15 > 0) {
                        break;
                    }
                    iArr5[i15] = zzkb2.zzO(zzb.zzb(i15));
                    i15++;
                }
                iArr = iArr5;
            }
            int i17 = iArr2[i7];
            zzcpArr[i7][i17] = zzb;
            iArr3[i7][i17] = iArr;
            iArr2[i7] = i17 + 1;
            i5++;
            i3 = 2;
        }
        zzuh[] zzuhArr = new zzuh[i3];
        String[] strArr = new String[i3];
        int[] iArr6 = new int[i3];
        int i18 = 0;
        while (i18 < i3) {
            int i19 = iArr2[i18];
            zzuhArr[i18] = new zzuh((zzcp[]) zzen.zzae(zzcpArr[i18], i19));
            iArr3[i18] = (int[][]) zzen.zzae(iArr3[i18], i19);
            strArr[i18] = zzkbArr[i18].zzK();
            iArr6[i18] = zzkbArr[i18].zzb();
            i18++;
            i3 = 2;
        }
        int i20 = i3;
        zzvv zzvv = new zzvv(strArr, iArr6, zzuhArr, iArr4, iArr3, new zzuh((zzcp[]) zzen.zzae(zzcpArr[i20], iArr2[i20])));
        Pair zzb2 = zzb(zzvv, iArr3, iArr4, zzsi, zzcn);
        zzvx[] zzvxArr = (zzvx[]) zzb2.second;
        List[] listArr = new List[zzvxArr.length];
        for (int i21 = 0; i21 < zzvxArr.length; i21++) {
            zzvx zzvx = zzvxArr[i21];
            listArr[i21] = zzvx != null ? zzfvn.zzp(zzvx) : zzfvn.zzo();
        }
        zzfvk zzfvk = new zzfvk();
        for (int i22 = 0; i22 < 2; i22++) {
            zzuh zzd = zzvv.zzd(i22);
            List list = listArr[i22];
            for (int i23 = 0; i23 < zzd.zzc; i23++) {
                zzcp zzb3 = zzd.zzb(i23);
                boolean z4 = zzvv.zza(i22, i23, false) != 0;
                int i24 = zzb3.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                int i25 = 0;
                while (true) {
                    int i26 = zzb3.zzb;
                    if (i25 > 0) {
                        break;
                    }
                    iArr7[i25] = zzvv.zzb(i22, i23, i25) & 7;
                    int i27 = 0;
                    while (true) {
                        if (i27 >= list.size()) {
                            z = false;
                            break;
                        }
                        zzvx zzvx2 = (zzvx) list.get(i27);
                        if (zzvx2.zze().equals(zzb3) && zzvx2.zzb(i25) != -1) {
                            z = true;
                            break;
                        }
                        i27++;
                    }
                    zArr[i25] = z;
                    i25++;
                }
                zzfvk.zze(new zzcx(zzb3, z4, iArr7, zArr));
            }
        }
        zzuh zze = zzvv.zze();
        for (int i28 = 0; i28 < zze.zzc; i28++) {
            zzcp zzb4 = zze.zzb(i28);
            int i29 = zzb4.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            int i30 = zzb4.zzb;
            zzfvk.zze(new zzcx(zzb4, false, iArr8, new boolean[1]));
        }
        return new zzwa((zzkc[]) zzb2.first, (zzvt[]) zzb2.second, new zzcy(zzfvk.zzg()), zzvv);
    }

    public final void zzo(Object obj) {
        this.zza = (zzvv) obj;
    }
}
