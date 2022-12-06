package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgpj {
    static int zza(byte[] bArr, int i, zzgpi zzgpi) throws zzgrq {
        int zzj = zzj(bArr, i, zzgpi);
        int i2 = zzgpi.zza;
        if (i2 < 0) {
            throw zzgrq.zzf();
        } else if (i2 > bArr.length - zzj) {
            throw zzgrq.zzj();
        } else if (i2 == 0) {
            zzgpi.zzc = zzgpw.zzb;
            return zzj;
        } else {
            zzgpi.zzc = zzgpw.zzw(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static int zzc(zzgth zzgth, byte[] bArr, int i, int i2, int i3, zzgpi zzgpi) throws IOException {
        zzgsr zzgsr = (zzgsr) zzgth;
        Object zze = zzgsr.zze();
        int zzc = zzgsr.zzc(zze, bArr, i, i2, i3, zzgpi);
        zzgsr.zzf(zze);
        zzgpi.zzc = zze;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.ads.zzgth r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzgpi r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zzk(r8, r7, r0, r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zze()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zzi(r1, r2, r3, r4, r5)
            r6.zzf(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzgrq r6 = com.google.android.gms.internal.ads.zzgrq.zzj()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgpj.zzd(com.google.android.gms.internal.ads.zzgth, byte[], int, int, com.google.android.gms.internal.ads.zzgpi):int");
    }

    static int zze(zzgth zzgth, int i, byte[] bArr, int i2, int i3, zzgrn zzgrn, zzgpi zzgpi) throws IOException {
        int zzd = zzd(zzgth, bArr, i2, i3, zzgpi);
        zzgrn.add(zzgpi.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzgpi);
            if (i != zzgpi.zza) {
                break;
            }
            zzd = zzd(zzgth, bArr, zzj, i3, zzgpi);
            zzgrn.add(zzgpi.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzgrn zzgrn, zzgpi zzgpi) throws IOException {
        zzgrf zzgrf = (zzgrf) zzgrn;
        int zzj = zzj(bArr, i, zzgpi);
        int i2 = zzgpi.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzgpi);
            zzgrf.zzh(zzgpi.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzgrq.zzj();
    }

    static int zzg(byte[] bArr, int i, zzgpi zzgpi) throws zzgrq {
        int zzj = zzj(bArr, i, zzgpi);
        int i2 = zzgpi.zza;
        if (i2 < 0) {
            throw zzgrq.zzf();
        } else if (i2 == 0) {
            zzgpi.zzc = "";
            return zzj;
        } else {
            zzgpi.zzc = new String(bArr, zzj, i2, zzgro.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzgpi zzgpi) throws zzgrq {
        int zzj = zzj(bArr, i, zzgpi);
        int i2 = zzgpi.zza;
        if (i2 < 0) {
            throw zzgrq.zzf();
        } else if (i2 == 0) {
            zzgpi.zzc = "";
            return zzj;
        } else {
            zzgpi.zzc = zzgun.zzh(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzgtz zzgtz, zzgpi zzgpi) throws zzgrq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzgpi);
                zzgtz.zzh(i, Long.valueOf(zzgpi.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzgtz.zzh(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzgpi);
                int i5 = zzgpi.zza;
                if (i5 < 0) {
                    throw zzgrq.zzf();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzgtz.zzh(i, zzgpw.zzb);
                    } else {
                        zzgtz.zzh(i, zzgpw.zzw(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzgrq.zzj();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzgtz zze = zzgtz.zze();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzgpi);
                    int i8 = zzgpi.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zze, zzgpi);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzgrq.zzg();
                }
                zzgtz.zzh(i, zze);
                return i2;
            } else if (i4 == 5) {
                zzgtz.zzh(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzgrq.zzc();
            }
        } else {
            throw zzgrq.zzc();
        }
    }

    static int zzj(byte[] bArr, int i, zzgpi zzgpi) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzgpi);
        }
        zzgpi.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzgpi zzgpi) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzgpi.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzgpi.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgpi.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgpi.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzgpi.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzgrn zzgrn, zzgpi zzgpi) {
        zzgrf zzgrf = (zzgrf) zzgrn;
        int zzj = zzj(bArr, i2, zzgpi);
        zzgrf.zzh(zzgpi.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzgpi);
            if (i != zzgpi.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzgpi);
            zzgrf.zzh(zzgpi.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzgpi zzgpi) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzgpi.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzgpi.zzb = j2;
        return i3;
    }

    static long zzn(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
