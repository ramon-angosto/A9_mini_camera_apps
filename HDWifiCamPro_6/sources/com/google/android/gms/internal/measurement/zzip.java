package com.google.android.gms.internal.measurement;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzip {
    static int zza(byte[] bArr, int i, zzio zzio) throws zzkm {
        int zzj = zzj(bArr, i, zzio);
        int i2 = zzio.zza;
        if (i2 < 0) {
            throw zzkm.zzd();
        } else if (i2 > bArr.length - zzj) {
            throw zzkm.zzf();
        } else if (i2 == 0) {
            zzio.zzc = zzjb.zzb;
            return zzj;
        } else {
            zzio.zzc = zzjb.zzl(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzb(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static int zzc(zzlu zzlu, byte[] bArr, int i, int i2, int i3, zzio zzio) throws IOException {
        zzlm zzlm = (zzlm) zzlu;
        Object zze = zzlm.zze();
        int zzc = zzlm.zzc(zze, bArr, i, i2, i3, zzio);
        zzlm.zzf(zze);
        zzio.zzc = zze;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zzd(com.google.android.gms.internal.measurement.zzlu r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.zzio r10) throws java.io.IOException {
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
            r0.zzh(r1, r2, r3, r4, r5)
            r6.zzf(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzkm r6 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzip.zzd(com.google.android.gms.internal.measurement.zzlu, byte[], int, int, com.google.android.gms.internal.measurement.zzio):int");
    }

    static int zze(zzlu zzlu, int i, byte[] bArr, int i2, int i3, zzkj zzkj, zzio zzio) throws IOException {
        int zzd = zzd(zzlu, bArr, i2, i3, zzio);
        zzkj.add(zzio.zzc);
        while (zzd < i3) {
            int zzj = zzj(bArr, zzd, zzio);
            if (i != zzio.zza) {
                break;
            }
            zzd = zzd(zzlu, bArr, zzj, i3, zzio);
            zzkj.add(zzio.zzc);
        }
        return zzd;
    }

    static int zzf(byte[] bArr, int i, zzkj zzkj, zzio zzio) throws IOException {
        zzkd zzkd = (zzkd) zzkj;
        int zzj = zzj(bArr, i, zzio);
        int i2 = zzio.zza + zzj;
        while (zzj < i2) {
            zzj = zzj(bArr, zzj, zzio);
            zzkd.zzh(zzio.zza);
        }
        if (zzj == i2) {
            return zzj;
        }
        throw zzkm.zzf();
    }

    static int zzg(byte[] bArr, int i, zzio zzio) throws zzkm {
        int zzj = zzj(bArr, i, zzio);
        int i2 = zzio.zza;
        if (i2 < 0) {
            throw zzkm.zzd();
        } else if (i2 == 0) {
            zzio.zzc = "";
            return zzj;
        } else {
            zzio.zzc = new String(bArr, zzj, i2, zzkk.zzb);
            return zzj + i2;
        }
    }

    static int zzh(byte[] bArr, int i, zzio zzio) throws zzkm {
        int zzj = zzj(bArr, i, zzio);
        int i2 = zzio.zza;
        if (i2 < 0) {
            throw zzkm.zzd();
        } else if (i2 == 0) {
            zzio.zzc = "";
            return zzj;
        } else {
            zzio.zzc = zzna.zzd(bArr, zzj, i2);
            return zzj + i2;
        }
    }

    static int zzi(int i, byte[] bArr, int i2, int i3, zzmm zzmm, zzio zzio) throws zzkm {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzm = zzm(bArr, i2, zzio);
                zzmm.zzh(i, Long.valueOf(zzio.zzb));
                return zzm;
            } else if (i4 == 1) {
                zzmm.zzh(i, Long.valueOf(zzn(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zzj = zzj(bArr, i2, zzio);
                int i5 = zzio.zza;
                if (i5 < 0) {
                    throw zzkm.zzd();
                } else if (i5 <= bArr.length - zzj) {
                    if (i5 == 0) {
                        zzmm.zzh(i, zzjb.zzb);
                    } else {
                        zzmm.zzh(i, zzjb.zzl(bArr, zzj, i5));
                    }
                    return zzj + i5;
                } else {
                    throw zzkm.zzf();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzmm zze = zzmm.zze();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i2, zzio);
                    int i8 = zzio.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zzj2;
                        break;
                    }
                    i7 = i8;
                    i2 = zzi(i8, bArr, zzj2, i3, zze, zzio);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzkm.zze();
                }
                zzmm.zzh(i, zze);
                return i2;
            } else if (i4 == 5) {
                zzmm.zzh(i, Integer.valueOf(zzb(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzkm.zzb();
            }
        } else {
            throw zzkm.zzb();
        }
    }

    static int zzj(byte[] bArr, int i, zzio zzio) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzk(b, bArr, i2, zzio);
        }
        zzio.zza = b;
        return i2;
    }

    static int zzk(int i, byte[] bArr, int i2, zzio zzio) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzio.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzio.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzio.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzio.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzio.zza = i11;
                return i12;
            }
        }
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzkj zzkj, zzio zzio) {
        zzkd zzkd = (zzkd) zzkj;
        int zzj = zzj(bArr, i2, zzio);
        zzkd.zzh(zzio.zza);
        while (zzj < i3) {
            int zzj2 = zzj(bArr, zzj, zzio);
            if (i != zzio.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzio);
            zzkd.zzh(zzio.zza);
        }
        return zzj;
    }

    static int zzm(byte[] bArr, int i, zzio zzio) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzio.zzb = j;
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
        zzio.zzb = j2;
        return i3;
    }

    static long zzn(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
