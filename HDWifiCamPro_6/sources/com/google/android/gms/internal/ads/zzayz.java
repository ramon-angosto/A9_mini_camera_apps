package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzayz extends zzazd {
    private final AtomicReference zza;

    public zzayz() {
        this((zzaze) null);
    }

    protected static boolean zza(int i, boolean z) {
        int i2 = i & 3;
        if (i2 == 3) {
            return true;
        }
        if (z) {
            return i2 == 2;
        }
        return false;
    }

    private static int zzh(int i, int i2) {
        if (i == -1) {
            return i2 != -1 ? -1 : 0;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    /* access modifiers changed from: protected */
    public final zzayx[] zzb(zzatc[] zzatcArr, zzayt[] zzaytArr, int[][][] iArr) throws zzasi {
        zzaza zzaza;
        boolean z;
        boolean z2;
        zzaza zzaza2;
        int[] iArr2;
        zzayt zzayt;
        zzays zzays;
        boolean z3;
        int i;
        int i2;
        int i3 = 2;
        zzayx[] zzayxArr = new zzayx[2];
        zzayy zzayy = (zzayy) this.zza.get();
        int i4 = 0;
        boolean z4 = false;
        while (true) {
            int i5 = 1;
            if (i4 >= i3) {
                break;
            }
            if (zzatcArr[i4].zzc() == i3) {
                if (!z4) {
                    zzatc zzatc = zzatcArr[i4];
                    zzayt zzayt2 = zzaytArr[i4];
                    int[][] iArr3 = iArr[i4];
                    int i6 = zzayy.zzd;
                    int i7 = zzayy.zze;
                    int i8 = zzayy.zzf;
                    boolean z5 = zzayy.zzc;
                    boolean z6 = zzayy.zzb;
                    int i9 = zzayy.zzi;
                    int i10 = zzayy.zzj;
                    boolean z7 = zzayy.zzk;
                    boolean z8 = zzayy.zzg;
                    boolean z9 = zzayy.zzh;
                    int i11 = 0;
                    zzays zzays2 = null;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = -1;
                    int i15 = -1;
                    while (i11 < zzayt2.zzb) {
                        zzays zzb = zzayt2.zzb(i11);
                        int i16 = zzb.zza;
                        ArrayList arrayList = new ArrayList(i5);
                        int i17 = 0;
                        while (true) {
                            int i18 = zzb.zza;
                            if (i17 > 0) {
                                break;
                            }
                            arrayList.add(Integer.valueOf(i17));
                            i17++;
                        }
                        int[] iArr4 = iArr3[i11];
                        int i19 = 0;
                        int i20 = i15;
                        zzays zzays3 = zzays2;
                        int i21 = i20;
                        while (true) {
                            int i22 = zzb.zza;
                            if (i19 > 0) {
                                break;
                            }
                            if (zza(iArr4[i19], true)) {
                                zzasw zzb2 = zzb.zzb(i19);
                                if (arrayList.contains(Integer.valueOf(i19))) {
                                    int i23 = zzb2.zzj;
                                    int i24 = zzb2.zzk;
                                    int i25 = zzb2.zzb;
                                    zzays = zzb;
                                    z3 = true;
                                } else {
                                    zzays = zzb;
                                    z3 = false;
                                }
                                if (true != z3) {
                                    zzayt = zzayt2;
                                    i = 1;
                                } else {
                                    zzayt = zzayt2;
                                    i = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza2 = zza(iArr4[i19], false);
                                if (zza2) {
                                    i += 1000;
                                }
                                boolean z10 = i > i13;
                                if (i == i13) {
                                    if (zzb2.zza() != i21) {
                                        i2 = zzh(zzb2.zza(), i21);
                                    } else {
                                        i2 = zzh(zzb2.zzb, i14);
                                    }
                                    z10 = !zza2 || !z3 ? i2 < 0 : i2 > 0;
                                }
                                if (z10) {
                                    i14 = zzb2.zzb;
                                    i21 = zzb2.zza();
                                    i12 = i19;
                                    i13 = i;
                                    zzays3 = zzays;
                                }
                            } else {
                                zzays = zzb;
                                iArr2 = iArr4;
                                zzayt = zzayt2;
                            }
                            i19++;
                            zzb = zzays;
                            zzayt2 = zzayt;
                            iArr4 = iArr2;
                        }
                        zzayt zzayt3 = zzayt2;
                        i11++;
                        i5 = 1;
                        zzays zzays4 = zzays3;
                        i15 = i21;
                        zzays2 = zzays4;
                    }
                    if (zzays2 == null) {
                        zzaza2 = null;
                    } else {
                        zzaza2 = new zzaza(zzays2, i12, 0, (Object) null);
                    }
                    zzayxArr[i4] = zzaza2;
                    z2 = zzaza2 != null;
                } else {
                    z2 = z4;
                }
                int i26 = zzaytArr[i4].zzb;
                z4 = z2;
            }
            i4++;
            i3 = 2;
        }
        int i27 = i3;
        int i28 = 0;
        boolean z11 = false;
        while (i28 < i27) {
            if (zzatcArr[i28].zzc() == 1) {
                if (!z11) {
                    zzayt zzayt4 = zzaytArr[i28];
                    int[][] iArr5 = iArr[i28];
                    String str = zzayy.zza;
                    boolean z12 = zzayy.zzh;
                    boolean z13 = zzayy.zzb;
                    int i29 = 0;
                    int i30 = -1;
                    int i31 = -1;
                    int i32 = 0;
                    while (i29 < zzayt4.zzb) {
                        zzays zzb3 = zzayt4.zzb(i29);
                        int[] iArr6 = iArr5[i29];
                        int i33 = i30;
                        int i34 = 0;
                        while (true) {
                            int i35 = zzb3.zza;
                            if (i34 > 0) {
                                break;
                            }
                            if (zza(iArr6[i34], true)) {
                                zzasw zzb4 = zzb3.zzb(i34);
                                int i36 = iArr6[i34];
                                int i37 = 1 != (zzb4.zzx & 1) ? 1 : i27;
                                if (zza(i36, false)) {
                                    i37 += 1000;
                                }
                                if (i37 > i32) {
                                    i33 = i29;
                                    i31 = i34;
                                    i32 = i37;
                                }
                            }
                            i34++;
                            i27 = 2;
                        }
                        i29++;
                        i30 = i33;
                        i27 = 2;
                    }
                    if (i30 == -1) {
                        z = false;
                        zzaza = null;
                    } else {
                        z = false;
                        zzaza = new zzaza(zzayt4.zzb(i30), i31, 0, (Object) null);
                    }
                    zzayxArr[i28] = zzaza;
                    z11 = zzaza != null ? true : z;
                }
            }
            i28++;
            i27 = 2;
        }
        return zzayxArr;
    }

    public zzayz(zzaze zzaze) {
        this.zza = new AtomicReference(new zzayy());
    }
}
