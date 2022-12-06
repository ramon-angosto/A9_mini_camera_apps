package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlm<T> implements zzlu<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmv.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkx zzm;
    private final zzml zzn;
    private final zzjp zzo;
    private final zzlo zzp;
    private final zzle zzq;

    private zzlm(int[] iArr, Object[] objArr, int i, int i2, zzlj zzlj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlo zzlo, zzkx zzkx, zzml zzml, zzjp zzjp, zzle zzle, byte[] bArr) {
        zzlj zzlj2 = zzlj;
        zzjp zzjp2 = zzjp;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzjp2 != null && zzjp2.zzc(zzlj)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlo;
        this.zzm = zzkx;
        this.zzn = zzml;
        this.zzo = zzjp2;
        this.zzg = zzlj2;
        this.zzq = zzle;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzmv.zzf(obj, j)).longValue();
    }

    private final zzkg zzD(int i) {
        int i2 = i / 3;
        return (zzkg) this.zzd[i2 + i2 + 1];
    }

    private final zzlu zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlu zzlu = (zzlu) this.zzd[i3];
        if (zzlu != null) {
            return zzlu;
        }
        zzlu zzb2 = zzlr.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzb2;
        return zzb2;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long zzB = (long) (zzB(i) & 1048575);
        if (zzO(obj2, i)) {
            Object zzf2 = zzmv.zzf(obj, zzB);
            Object zzf3 = zzmv.zzf(obj2, zzB);
            if (zzf2 != null && zzf3 != null) {
                zzmv.zzs(obj, zzB, zzkk.zzg(zzf2, zzf3));
                zzJ(obj, i);
            } else if (zzf3 != null) {
                zzmv.zzs(obj, zzB, zzf3);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int zzB = zzB(i);
        int i2 = this.zzc[i];
        long j = (long) (zzB & 1048575);
        if (zzR(obj2, i2, i)) {
            Object zzf2 = zzR(obj, i2, i) ? zzmv.zzf(obj, j) : null;
            Object zzf3 = zzmv.zzf(obj2, j);
            if (zzf2 != null && zzf3 != null) {
                zzmv.zzs(obj, j, zzkk.zzg(zzf2, zzf3));
                zzK(obj, i2, i);
            } else if (zzf3 != null) {
                zzmv.zzs(obj, j, zzf3);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (1048575 & zzy);
        if (j != 1048575) {
            zzmv.zzq(obj, j, (1 << (zzy >>> 20)) | zzmv.zzc(obj, j));
        }
    }

    private final void zzK(Object obj, int i, int i2) {
        zzmv.zzq(obj, (long) (zzy(i2) & 1048575), i);
    }

    private final void zzL(Object obj, zznd zznd) throws IOException {
        int i;
        int i2;
        Object obj2 = obj;
        zznd zznd2 = zznd;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i3 = 1048575;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int zzB = zzB(i4);
                int[] iArr = this.zzc;
                int i6 = iArr[i4];
                int zzA = zzA(zzB);
                if (zzA <= 17) {
                    int i7 = iArr[i4 + 2];
                    i = i7 & 1048575;
                    if (i != i3) {
                        i5 = unsafe.getInt(obj2, (long) i);
                    } else {
                        i = i3;
                    }
                    i2 = 1 << (i7 >>> 20);
                } else {
                    i = i3;
                    i2 = 0;
                }
                long j = (long) (zzB & 1048575);
                switch (zzA) {
                    case 0:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzf(i6, zzmv.zza(obj2, j));
                            break;
                        }
                    case 1:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzo(i6, zzmv.zzb(obj2, j));
                            break;
                        }
                    case 2:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzt(i6, unsafe.getLong(obj2, j));
                            break;
                        }
                    case 3:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzJ(i6, unsafe.getLong(obj2, j));
                            break;
                        }
                    case 4:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzr(i6, unsafe.getInt(obj2, j));
                            break;
                        }
                    case 5:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzm(i6, unsafe.getLong(obj2, j));
                            break;
                        }
                    case 6:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzk(i6, unsafe.getInt(obj2, j));
                            break;
                        }
                    case 7:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzb(i6, zzmv.zzw(obj2, j));
                            break;
                        }
                    case 8:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zzT(i6, unsafe.getObject(obj2, j), zznd2);
                            break;
                        }
                    case 9:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzv(i6, unsafe.getObject(obj2, j), zzE(i4));
                            break;
                        }
                    case 10:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzd(i6, (zzjb) unsafe.getObject(obj2, j));
                            break;
                        }
                    case 11:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzH(i6, unsafe.getInt(obj2, j));
                            break;
                        }
                    case 12:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzi(i6, unsafe.getInt(obj2, j));
                            break;
                        }
                    case 13:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzw(i6, unsafe.getInt(obj2, j));
                            break;
                        }
                    case 14:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzy(i6, unsafe.getLong(obj2, j));
                            break;
                        }
                    case 15:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzA(i6, unsafe.getInt(obj2, j));
                            break;
                        }
                    case 16:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzC(i6, unsafe.getLong(obj2, j));
                            break;
                        }
                    case 17:
                        if ((i2 & i5) == 0) {
                            break;
                        } else {
                            zznd2.zzq(i6, unsafe.getObject(obj2, j), zzE(i4));
                            break;
                        }
                    case 18:
                        zzlw.zzJ(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 19:
                        zzlw.zzN(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 20:
                        zzlw.zzQ(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 21:
                        zzlw.zzY(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 22:
                        zzlw.zzP(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 23:
                        zzlw.zzM(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 24:
                        zzlw.zzL(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 25:
                        zzlw.zzH(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 26:
                        zzlw.zzW(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2);
                        break;
                    case 27:
                        zzlw.zzR(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, zzE(i4));
                        break;
                    case 28:
                        zzlw.zzI(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2);
                        break;
                    case 29:
                        zzlw.zzX(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 30:
                        zzlw.zzK(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 31:
                        zzlw.zzS(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 32:
                        zzlw.zzT(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 33:
                        zzlw.zzU(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 34:
                        zzlw.zzV(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, false);
                        break;
                    case 35:
                        zzlw.zzJ(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 36:
                        zzlw.zzN(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 37:
                        zzlw.zzQ(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 38:
                        zzlw.zzY(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 39:
                        zzlw.zzP(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 40:
                        zzlw.zzM(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 41:
                        zzlw.zzL(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 42:
                        zzlw.zzH(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 43:
                        zzlw.zzX(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 44:
                        zzlw.zzK(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 45:
                        zzlw.zzS(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 46:
                        zzlw.zzT(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 47:
                        zzlw.zzU(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 48:
                        zzlw.zzV(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, true);
                        break;
                    case 49:
                        zzlw.zzO(this.zzc[i4], (List) unsafe.getObject(obj2, j), zznd2, zzE(i4));
                        break;
                    case 50:
                        zzM(zznd2, i6, unsafe.getObject(obj2, j), i4);
                        break;
                    case 51:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzf(i6, zzn(obj2, j));
                            break;
                        }
                    case 52:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzo(i6, zzo(obj2, j));
                            break;
                        }
                    case 53:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzt(i6, zzC(obj2, j));
                            break;
                        }
                    case 54:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzJ(i6, zzC(obj2, j));
                            break;
                        }
                    case 55:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzr(i6, zzr(obj2, j));
                            break;
                        }
                    case 56:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzm(i6, zzC(obj2, j));
                            break;
                        }
                    case 57:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzk(i6, zzr(obj2, j));
                            break;
                        }
                    case 58:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzb(i6, zzS(obj2, j));
                            break;
                        }
                    case 59:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zzT(i6, unsafe.getObject(obj2, j), zznd2);
                            break;
                        }
                    case 60:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzv(i6, unsafe.getObject(obj2, j), zzE(i4));
                            break;
                        }
                    case 61:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzd(i6, (zzjb) unsafe.getObject(obj2, j));
                            break;
                        }
                    case 62:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzH(i6, zzr(obj2, j));
                            break;
                        }
                    case 63:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzi(i6, zzr(obj2, j));
                            break;
                        }
                    case 64:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzw(i6, zzr(obj2, j));
                            break;
                        }
                    case 65:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzy(i6, zzC(obj2, j));
                            break;
                        }
                    case 66:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzA(i6, zzr(obj2, j));
                            break;
                        }
                    case 67:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzC(i6, zzC(obj2, j));
                            break;
                        }
                    case 68:
                        if (!zzR(obj2, i6, i4)) {
                            break;
                        } else {
                            zznd2.zzq(i6, unsafe.getObject(obj2, j), zzE(i4));
                            break;
                        }
                }
                i4 += 3;
                i3 = i;
            }
            zzml zzml = this.zzn;
            zzml.zzi(zzml.zzc(obj2), zznd2);
            return;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    private final void zzM(zznd zznd, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlc zzlc = (zzlc) zzF(i2);
            throw null;
        }
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        return zzO(obj, i) == zzO(obj2, i);
    }

    private final boolean zzO(Object obj, int i) {
        int zzy = zzy(i);
        long j = (long) (zzy & 1048575);
        if (j != 1048575) {
            return (zzmv.zzc(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzB = zzB(i);
        long j2 = (long) (zzB & 1048575);
        switch (zzA(zzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmv.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmv.zzb(obj, j2)) != 0;
            case 2:
                return zzmv.zzd(obj, j2) != 0;
            case 3:
                return zzmv.zzd(obj, j2) != 0;
            case 4:
                return zzmv.zzc(obj, j2) != 0;
            case 5:
                return zzmv.zzd(obj, j2) != 0;
            case 6:
                return zzmv.zzc(obj, j2) != 0;
            case 7:
                return zzmv.zzw(obj, j2);
            case 8:
                Object zzf2 = zzmv.zzf(obj, j2);
                if (zzf2 instanceof String) {
                    return !((String) zzf2).isEmpty();
                }
                if (zzf2 instanceof zzjb) {
                    return !zzjb.zzb.equals(zzf2);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmv.zzf(obj, j2) != null;
            case 10:
                return !zzjb.zzb.equals(zzmv.zzf(obj, j2));
            case 11:
                return zzmv.zzc(obj, j2) != 0;
            case 12:
                return zzmv.zzc(obj, j2) != 0;
            case 13:
                return zzmv.zzc(obj, j2) != 0;
            case 14:
                return zzmv.zzd(obj, j2) != 0;
            case 15:
                return zzmv.zzc(obj, j2) != 0;
            case 16:
                return zzmv.zzd(obj, j2) != 0;
            case 17:
                return zzmv.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzP(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzQ(Object obj, int i, zzlu zzlu) {
        return zzlu.zzk(zzmv.zzf(obj, (long) (i & 1048575)));
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzmv.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzmv.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zznd zznd) throws IOException {
        if (obj instanceof String) {
            zznd.zzF(i, (String) obj);
        } else {
            zznd.zzd(i, (zzjb) obj);
        }
    }

    static zzmm zzd(Object obj) {
        zzkc zzkc = (zzkc) obj;
        zzmm zzmm = zzkc.zzc;
        if (zzmm != zzmm.zzc()) {
            return zzmm;
        }
        zzmm zze2 = zzmm.zze();
        zzkc.zzc = zze2;
        return zze2;
    }

    static zzlm zzl(Class cls, zzlg zzlg, zzlo zzlo, zzkx zzkx, zzml zzml, zzjp zzjp, zzle zzle) {
        if (zzlg instanceof zzlt) {
            return zzm((zzlt) zzlg, zzlo, zzkx, zzml, zzjp, zzle);
        }
        zzmi zzmi = (zzmi) zzlg;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0386  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzlm zzm(com.google.android.gms.internal.measurement.zzlt r34, com.google.android.gms.internal.measurement.zzlo r35, com.google.android.gms.internal.measurement.zzkx r36, com.google.android.gms.internal.measurement.zzml r37, com.google.android.gms.internal.measurement.zzjp r38, com.google.android.gms.internal.measurement.zzle r39) {
        /*
            int r0 = r34.zzc()
            r1 = 0
            r3 = 2
            if (r0 != r3) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r1
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r3 = r0.length()
            char r4 = r0.charAt(r1)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0059
            int[] r6 = zza
            r8 = r1
            r12 = r8
            r13 = r12
            r16 = r13
            r17 = r16
            r15 = r4
            r14 = r6
            r4 = r17
            r6 = r4
            goto L_0x0171
        L_0x0059:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0078
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0065:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0075
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0065
        L_0x0075:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0078:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0097
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0084:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0094
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0084
        L_0x0094:
            int r8 = r8 << r9
            r6 = r6 | r8
            goto L_0x0098
        L_0x0097:
            r11 = r8
        L_0x0098:
            int r8 = r11 + 1
            char r9 = r0.charAt(r11)
            if (r9 < r5) goto L_0x00b7
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a4:
            int r12 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r11
            r9 = r9 | r8
            int r11 = r11 + 13
            r8 = r12
            goto L_0x00a4
        L_0x00b4:
            int r8 = r8 << r11
            r8 = r8 | r9
            goto L_0x00b9
        L_0x00b7:
            r12 = r8
            r8 = r9
        L_0x00b9:
            int r9 = r12 + 1
            char r11 = r0.charAt(r12)
            if (r11 < r5) goto L_0x00d9
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c5:
            int r13 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d5
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r12
            r11 = r11 | r9
            int r12 = r12 + 13
            r9 = r13
            goto L_0x00c5
        L_0x00d5:
            int r9 = r9 << r12
            r9 = r9 | r11
            r11 = r9
            goto L_0x00da
        L_0x00d9:
            r13 = r9
        L_0x00da:
            int r9 = r13 + 1
            char r12 = r0.charAt(r13)
            if (r12 < r5) goto L_0x00fa
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e6:
            int r14 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00f6
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r13
            r12 = r12 | r9
            int r13 = r13 + 13
            r9 = r14
            goto L_0x00e6
        L_0x00f6:
            int r9 = r9 << r13
            r9 = r9 | r12
            r12 = r9
            goto L_0x00fb
        L_0x00fa:
            r14 = r9
        L_0x00fb:
            int r9 = r14 + 1
            char r13 = r0.charAt(r14)
            if (r13 < r5) goto L_0x011b
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x0107:
            int r15 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x0117
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r14
            r13 = r13 | r9
            int r14 = r14 + 13
            r9 = r15
            goto L_0x0107
        L_0x0117:
            int r9 = r9 << r14
            r9 = r9 | r13
            r13 = r9
            goto L_0x011c
        L_0x011b:
            r15 = r9
        L_0x011c:
            int r9 = r15 + 1
            char r14 = r0.charAt(r15)
            if (r14 < r5) goto L_0x013d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0128:
            int r16 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x0139
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r15
            r14 = r14 | r9
            int r15 = r15 + 13
            r9 = r16
            goto L_0x0128
        L_0x0139:
            int r9 = r9 << r15
            r14 = r14 | r9
            r9 = r16
        L_0x013d:
            int r15 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x0160
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0149:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x015b
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r9 = r9 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0149
        L_0x015b:
            int r15 = r15 << r16
            r9 = r9 | r15
            r15 = r17
        L_0x0160:
            int r16 = r9 + r13
            int r14 = r16 + r14
            int[] r14 = new int[r14]
            int r16 = r4 + r4
            int r6 = r16 + r6
            r16 = r8
            r17 = r11
            r8 = r4
            r4 = r13
            r13 = r9
        L_0x0171:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r11 = r34.zze()
            com.google.android.gms.internal.measurement.zzlj r18 = r34.zza()
            java.lang.Class r1 = r18.getClass()
            int r7 = r12 * 3
            int[] r7 = new int[r7]
            int r12 = r12 + r12
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r21 = r13 + r4
            r20 = r6
            r22 = r13
            r23 = r21
            r4 = 0
            r6 = 0
        L_0x0190:
            if (r15 >= r3) goto L_0x03d1
            int r24 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x01c0
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r33 = r24
            r24 = r15
            r15 = r33
        L_0x01a4:
            int r26 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x01b7
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r25
            r24 = r24 | r15
            int r25 = r25 + 13
            r15 = r26
            goto L_0x01a4
        L_0x01b7:
            int r15 = r15 << r25
            r15 = r24 | r15
            r24 = r15
            r15 = r26
            goto L_0x01c6
        L_0x01c0:
            r33 = r24
            r24 = r15
            r15 = r33
        L_0x01c6:
            int r25 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x01f2
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r33 = r25
            r25 = r15
            r15 = r33
        L_0x01d8:
            int r27 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x01eb
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r26
            r25 = r25 | r15
            int r26 = r26 + 13
            r15 = r27
            goto L_0x01d8
        L_0x01eb:
            int r15 = r15 << r26
            r15 = r25 | r15
            r2 = r27
            goto L_0x01f4
        L_0x01f2:
            r2 = r25
        L_0x01f4:
            r5 = r15 & 255(0xff, float:3.57E-43)
            r27 = r3
            r3 = r15 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0201
            int r3 = r6 + 1
            r14[r6] = r4
            r6 = r3
        L_0x0201:
            r3 = 51
            if (r5 < r3) goto L_0x02a7
            int r3 = r2 + 1
            char r2 = r0.charAt(r2)
            r28 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r3) goto L_0x0238
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
            r33 = r28
            r28 = r2
            r2 = r33
        L_0x021c:
            int r32 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r3) goto L_0x0232
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r31
            r28 = r28 | r2
            int r31 = r31 + 13
            r2 = r32
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x021c
        L_0x0232:
            int r2 = r2 << r31
            r2 = r28 | r2
            r28 = r32
        L_0x0238:
            int r3 = r5 + -51
            r31 = r6
            r6 = 9
            if (r3 == r6) goto L_0x025c
            r6 = 17
            if (r3 != r6) goto L_0x0245
            goto L_0x025c
        L_0x0245:
            r6 = 12
            if (r3 != r6) goto L_0x0259
            if (r10 != 0) goto L_0x0259
            int r3 = r4 / 3
            int r6 = r20 + 1
            int r3 = r3 + r3
            r25 = 1
            int r3 = r3 + 1
            r20 = r11[r20]
            r12[r3] = r20
            goto L_0x0269
        L_0x0259:
            r6 = r20
            goto L_0x0269
        L_0x025c:
            int r3 = r4 / 3
            int r6 = r20 + 1
            int r3 = r3 + r3
            r25 = 1
            int r3 = r3 + 1
            r20 = r11[r20]
            r12[r3] = r20
        L_0x0269:
            int r2 = r2 + r2
            r3 = r11[r2]
            r20 = r6
            boolean r6 = r3 instanceof java.lang.reflect.Field
            if (r6 == 0) goto L_0x0275
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            goto L_0x027d
        L_0x0275:
            java.lang.String r3 = (java.lang.String) r3
            java.lang.reflect.Field r3 = zzG(r1, r3)
            r11[r2] = r3
        L_0x027d:
            r32 = r7
            long r6 = r9.objectFieldOffset(r3)
            int r3 = (int) r6
            int r2 = r2 + 1
            r6 = r11[r2]
            boolean r7 = r6 instanceof java.lang.reflect.Field
            if (r7 == 0) goto L_0x028f
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x0297
        L_0x028f:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zzG(r1, r6)
            r11[r2] = r6
        L_0x0297:
            long r6 = r9.objectFieldOffset(r6)
            int r2 = (int) r6
            r30 = r0
            r29 = r2
            r0 = r28
            r2 = 0
            r25 = 1
            goto L_0x039d
        L_0x02a7:
            r31 = r6
            r32 = r7
            int r3 = r20 + 1
            r6 = r11[r20]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zzG(r1, r6)
            r7 = 9
            if (r5 == r7) goto L_0x031a
            r7 = 17
            if (r5 != r7) goto L_0x02be
            goto L_0x031a
        L_0x02be:
            r7 = 27
            if (r5 == r7) goto L_0x030c
            r7 = 49
            if (r5 != r7) goto L_0x02c7
            goto L_0x030c
        L_0x02c7:
            r7 = 12
            if (r5 == r7) goto L_0x02f9
            r7 = 30
            if (r5 == r7) goto L_0x02f9
            r7 = 44
            if (r5 != r7) goto L_0x02d4
            goto L_0x02f9
        L_0x02d4:
            r7 = 50
            if (r5 != r7) goto L_0x0309
            int r7 = r22 + 1
            r14[r22] = r4
            int r22 = r4 / 3
            int r22 = r22 + r22
            int r28 = r3 + 1
            r3 = r11[r3]
            r12[r22] = r3
            r3 = r15 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x02f4
            int r3 = r28 + 1
            int r22 = r22 + 1
            r28 = r11[r28]
            r12[r22] = r28
            r28 = r3
        L_0x02f4:
            r22 = r7
            r25 = 1
            goto L_0x0329
        L_0x02f9:
            if (r10 != 0) goto L_0x0309
            int r7 = r4 / 3
            int r28 = r3 + 1
            int r7 = r7 + r7
            r25 = 1
            int r7 = r7 + 1
            r3 = r11[r3]
            r12[r7] = r3
            goto L_0x0329
        L_0x0309:
            r25 = 1
            goto L_0x0327
        L_0x030c:
            r25 = 1
            int r7 = r4 / 3
            int r28 = r3 + 1
            int r7 = r7 + r7
            int r7 = r7 + 1
            r3 = r11[r3]
            r12[r7] = r3
            goto L_0x0329
        L_0x031a:
            r25 = 1
            int r7 = r4 / 3
            int r7 = r7 + r7
            int r7 = r7 + 1
            java.lang.Class r28 = r6.getType()
            r12[r7] = r28
        L_0x0327:
            r28 = r3
        L_0x0329:
            long r6 = r9.objectFieldOffset(r6)
            int r3 = (int) r6
            r6 = r15 & 4096(0x1000, float:5.74E-42)
            r7 = 4096(0x1000, float:5.74E-42)
            if (r6 != r7) goto L_0x0386
            r6 = 17
            if (r5 > r6) goto L_0x0386
            int r6 = r2 + 1
            char r2 = r0.charAt(r2)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r7) goto L_0x035d
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x0347:
            int r29 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r7) goto L_0x0359
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r26
            r2 = r2 | r6
            int r26 = r26 + 13
            r6 = r29
            goto L_0x0347
        L_0x0359:
            int r6 = r6 << r26
            r2 = r2 | r6
            goto L_0x035f
        L_0x035d:
            r29 = r6
        L_0x035f:
            int r6 = r8 + r8
            int r26 = r2 / 32
            int r6 = r6 + r26
            r7 = r11[r6]
            r30 = r0
            boolean r0 = r7 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0370
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0378
        L_0x0370:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzG(r1, r7)
            r11[r6] = r7
        L_0x0378:
            long r6 = r9.objectFieldOffset(r7)
            int r0 = (int) r6
            int r2 = r2 % 32
            r33 = r29
            r29 = r0
            r0 = r33
            goto L_0x038d
        L_0x0386:
            r30 = r0
            r0 = r2
            r2 = 0
            r29 = 1048575(0xfffff, float:1.469367E-39)
        L_0x038d:
            r6 = 18
            if (r5 < r6) goto L_0x039b
            r6 = 49
            if (r5 > r6) goto L_0x039b
            int r6 = r23 + 1
            r14[r23] = r3
            r23 = r6
        L_0x039b:
            r20 = r28
        L_0x039d:
            int r6 = r4 + 1
            r32[r4] = r24
            int r4 = r6 + 1
            r7 = r15 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x03aa
            r7 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03ab
        L_0x03aa:
            r7 = 0
        L_0x03ab:
            r15 = r15 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x03b2
            r15 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03b3
        L_0x03b2:
            r15 = 0
        L_0x03b3:
            r7 = r7 | r15
            int r5 = r5 << 20
            r5 = r5 | r7
            r3 = r3 | r5
            r32[r6] = r3
            int r3 = r4 + 1
            int r2 = r2 << 20
            r2 = r2 | r29
            r32[r4] = r2
            r15 = r0
            r4 = r3
            r3 = r27
            r0 = r30
            r6 = r31
            r7 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0190
        L_0x03d1:
            r32 = r7
            com.google.android.gms.internal.measurement.zzlm r0 = new com.google.android.gms.internal.measurement.zzlm
            r4 = r0
            com.google.android.gms.internal.measurement.zzlj r9 = r34.zza()
            r11 = 0
            r20 = 0
            r5 = r32
            r6 = r12
            r7 = r16
            r8 = r17
            r12 = r14
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzm(com.google.android.gms.internal.measurement.zzlt, com.google.android.gms.internal.measurement.zzlo, com.google.android.gms.internal.measurement.zzkx, com.google.android.gms.internal.measurement.zzml, com.google.android.gms.internal.measurement.zzjp, com.google.android.gms.internal.measurement.zzle):com.google.android.gms.internal.measurement.zzlm");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzmv.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzmv.zzf(obj, j)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x030a, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x030b, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x030c, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x034a, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037e, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0489, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0504, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0505, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x052e, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x053c, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x054b, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x054f, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ef, code lost:
        r4 = r4 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019c, code lost:
        r6 = r6 + (r9 + r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01ac, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bc, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = zzb
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r3
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000d:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0556
            int r9 = r0.zzB(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzA(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0036
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r3
            int r10 = r10 >>> 20
            int r10 = r14 << r10
            if (r13 == r8) goto L_0x0037
            long r7 = (long) r13
            int r7 = r2.getInt(r1, r7)
            r8 = r13
            goto L_0x0037
        L_0x0036:
            r10 = 0
        L_0x0037:
            r9 = r9 & r3
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0540;
                case 1: goto L_0x0531;
                case 2: goto L_0x051b;
                case 3: goto L_0x0507;
                case 4: goto L_0x04f1;
                case 5: goto L_0x04e5;
                case 6: goto L_0x04d9;
                case 7: goto L_0x04cb;
                case 8: goto L_0x04a0;
                case 9: goto L_0x048d;
                case 10: goto L_0x0470;
                case 11: goto L_0x045b;
                case 12: goto L_0x0446;
                case 13: goto L_0x0439;
                case 14: goto L_0x042c;
                case 15: goto L_0x0412;
                case 16: goto L_0x03f8;
                case 17: goto L_0x03e4;
                case 18: goto L_0x03d6;
                case 19: goto L_0x03ca;
                case 20: goto L_0x03be;
                case 21: goto L_0x03b2;
                case 22: goto L_0x03a6;
                case 23: goto L_0x039a;
                case 24: goto L_0x038e;
                case 25: goto L_0x0382;
                case 26: goto L_0x0374;
                case 27: goto L_0x0365;
                case 28: goto L_0x035a;
                case 29: goto L_0x034e;
                case 30: goto L_0x033f;
                case 31: goto L_0x0333;
                case 32: goto L_0x0327;
                case 33: goto L_0x031b;
                case 34: goto L_0x030f;
                case 35: goto L_0x02f6;
                case 36: goto L_0x02e1;
                case 37: goto L_0x02cc;
                case 38: goto L_0x02b7;
                case 39: goto L_0x02a2;
                case 40: goto L_0x028d;
                case 41: goto L_0x0277;
                case 42: goto L_0x0261;
                case 43: goto L_0x024b;
                case 44: goto L_0x0235;
                case 45: goto L_0x021f;
                case 46: goto L_0x0209;
                case 47: goto L_0x01f3;
                case 48: goto L_0x01dd;
                case 49: goto L_0x01cd;
                case 50: goto L_0x01c0;
                case 51: goto L_0x01b0;
                case 52: goto L_0x01a0;
                case 53: goto L_0x0188;
                case 54: goto L_0x0173;
                case 55: goto L_0x015d;
                case 56: goto L_0x0150;
                case 57: goto L_0x0143;
                case 58: goto L_0x0134;
                case 59: goto L_0x0107;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00d5;
                case 62: goto L_0x00bf;
                case 63: goto L_0x00a9;
                case 64: goto L_0x009b;
                case 65: goto L_0x008d;
                case 66: goto L_0x0072;
                case 67: goto L_0x0056;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x037f
        L_0x0040:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlj r3 = (com.google.android.gms.internal.measurement.zzlj) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzu(r11, r3, r4)
            goto L_0x037e
        L_0x0056:
            boolean r10 = r0.zzR(r1, r11, r5)
            if (r10 == 0) goto L_0x037f
            long r3 = zzC(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjj.zzA(r10)
            long r11 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x037f
        L_0x0072:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030b
        L_0x008d:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01bc
        L_0x009b:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01ac
        L_0x00a9:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
            goto L_0x030b
        L_0x00bf:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030b
        L_0x00d5:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x00ef:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x030c
        L_0x00f3:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlu r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzo(r11, r3, r4)
            goto L_0x037e
        L_0x0107:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r4 == 0) goto L_0x0126
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x00ef
        L_0x0126:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzy(r3)
            goto L_0x030b
        L_0x0134:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            int r3 = r3 + r14
            goto L_0x037e
        L_0x0143:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01ac
        L_0x0150:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x01bc
        L_0x015d:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            int r3 = zzr(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
            goto L_0x030b
        L_0x0173:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            goto L_0x019c
        L_0x0188:
            boolean r9 = r0.zzR(r1, r11, r5)
            if (r9 == 0) goto L_0x037f
            long r3 = zzC(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
        L_0x019c:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x037f
        L_0x01a0:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x01ac:
            int r3 = r3 + 4
            goto L_0x037e
        L_0x01b0:
            boolean r3 = r0.zzR(r1, r11, r5)
            if (r3 == 0) goto L_0x037f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x01bc:
            int r3 = r3 + 8
            goto L_0x037e
        L_0x01c0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.zzF(r5)
            com.google.android.gms.internal.measurement.zzle.zza(r11, r3, r4)
            goto L_0x037f
        L_0x01cd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzj(r11, r3, r4)
            goto L_0x037e
        L_0x01dd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzt(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x01f3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzr(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x0209:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzi(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x021f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzg(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x0235:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zze(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x024b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzw(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x0261:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzb(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x0277:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzg(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x028d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzi(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x02a2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzl(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x02b7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzy(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x02cc:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzn(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x02e1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzg(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x030a
        L_0x02f6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzi(r3)
            if (r3 <= 0) goto L_0x037f
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzz(r11)
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x030a:
            int r4 = r4 + r9
        L_0x030b:
            int r4 = r4 + r3
        L_0x030c:
            int r6 = r6 + r4
            goto L_0x037f
        L_0x030f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzs(r11, r3, r9)
            goto L_0x034a
        L_0x031b:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzq(r11, r3, r9)
            goto L_0x034a
        L_0x0327:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzh(r11, r3, r9)
            goto L_0x034a
        L_0x0333:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzf(r11, r3, r9)
            goto L_0x034a
        L_0x033f:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzd(r11, r3, r9)
        L_0x034a:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x054f
        L_0x034e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzv(r11, r3, r9)
            goto L_0x037e
        L_0x035a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzc(r11, r3)
            goto L_0x037e
        L_0x0365:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzp(r11, r3, r4)
            goto L_0x037e
        L_0x0374:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzu(r11, r3)
        L_0x037e:
            int r6 = r6 + r3
        L_0x037f:
            r12 = 0
            goto L_0x054f
        L_0x0382:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzlw.zza(r11, r3, r12)
            goto L_0x03e1
        L_0x038e:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzf(r11, r3, r12)
            goto L_0x03e1
        L_0x039a:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzh(r11, r3, r12)
            goto L_0x03e1
        L_0x03a6:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzk(r11, r3, r12)
            goto L_0x03e1
        L_0x03b2:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzx(r11, r3, r12)
            goto L_0x03e1
        L_0x03be:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzm(r11, r3, r12)
            goto L_0x03e1
        L_0x03ca:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzf(r11, r3, r12)
            goto L_0x03e1
        L_0x03d6:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzh(r11, r3, r12)
        L_0x03e1:
            int r6 = r6 + r3
            goto L_0x054f
        L_0x03e4:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlj r3 = (com.google.android.gms.internal.measurement.zzlj) r3
            com.google.android.gms.internal.measurement.zzlu r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzu(r11, r3, r4)
            goto L_0x03e1
        L_0x03f8:
            r12 = 0
            r10 = r10 & r7
            if (r10 == 0) goto L_0x054f
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            int r10 = com.google.android.gms.internal.measurement.zzjj.zzA(r10)
            long r14 = r3 + r3
            long r3 = r3 >> r9
            long r3 = r3 ^ r14
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            int r10 = r10 + r3
            int r6 = r6 + r10
            goto L_0x054f
        L_0x0412:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r9 = r3 + r3
            int r3 = r3 >> 31
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0504
        L_0x042c:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x054b
        L_0x0439:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x053c
        L_0x0446:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
            goto L_0x0504
        L_0x045b:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0504
        L_0x0470:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x0489:
            int r9 = r9 + r3
            int r4 = r4 + r9
            goto L_0x0505
        L_0x048d:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzlu r4 = r0.zzE(r5)
            int r3 = com.google.android.gms.internal.measurement.zzlw.zzo(r11, r3, r4)
            goto L_0x03e1
        L_0x04a0:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r4 == 0) goto L_0x04be
            com.google.android.gms.internal.measurement.zzjb r3 = (com.google.android.gms.internal.measurement.zzjb) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x0489
        L_0x04be:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzy(r3)
            goto L_0x0504
        L_0x04cb:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            int r3 = r3 + r14
            goto L_0x03e1
        L_0x04d9:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x053c
        L_0x04e5:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
            goto L_0x054b
        L_0x04f1:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzv(r3)
        L_0x0504:
            int r4 = r4 + r3
        L_0x0505:
            int r6 = r6 + r4
            goto L_0x054f
        L_0x0507:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
            goto L_0x052e
        L_0x051b:
            r12 = 0
            r9 = r7 & r10
            if (r9 == 0) goto L_0x054f
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzjj.zzA(r9)
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzB(r3)
        L_0x052e:
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x054f
        L_0x0531:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x053c:
            int r3 = r3 + 4
            goto L_0x03e1
        L_0x0540:
            r12 = 0
            r3 = r7 & r10
            if (r3 == 0) goto L_0x054f
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzjj.zzA(r3)
        L_0x054b:
            int r3 = r3 + 8
            goto L_0x03e1
        L_0x054f:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000d
        L_0x0556:
            com.google.android.gms.internal.measurement.zzml r2 = r0.zzn
            java.lang.Object r3 = r2.zzc(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x0566
            return r6
        L_0x0566:
            com.google.android.gms.internal.measurement.zzjp r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzp(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(java.lang.Object r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzB(r2)
            int r5 = zzA(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.measurement.zzju r4 = com.google.android.gms.internal.measurement.zzju.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.measurement.zzju r4 = com.google.android.gms.internal.measurement.zzju.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlj r4 = (com.google.android.gms.internal.measurement.zzlj) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzR(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzC(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzC(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzR(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.lang.Object r5 = r11.zzF(r2)
            com.google.android.gms.internal.measurement.zzle.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzz(r6)
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlj r4 = (com.google.android.gms.internal.measurement.zzlj) r4
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzO(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.measurement.zzmv.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzlu r5 = r11.zzE(r2)
            int r4 = com.google.android.gms.internal.measurement.zzlw.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzjb
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.measurement.zzjb r4 = (com.google.android.gms.internal.measurement.zzjb) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.measurement.zzjj.zzA(r5)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmv.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.measurement.zzmv.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzjj.zzA(r6)
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzO(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzjj.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.measurement.zzml r0 = r11.zzn
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzq(java.lang.Object):int");
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzmv.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzio zzio) throws IOException {
        Unsafe unsafe = zzb;
        Object zzF = zzF(i3);
        Object object2 = unsafe.getObject(obj, j);
        if (!((zzld) object2).zze()) {
            zzld zzb2 = zzld.zza().zzb();
            zzle.zzb(zzb2, object2);
            unsafe.putObject(obj, j, zzb2);
        }
        zzlc zzlc = (zzlc) zzF;
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzio zzio) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        int i12 = i5;
        long j2 = j;
        int i13 = i8;
        zzio zzio2 = zzio;
        Unsafe unsafe = zzb;
        long j3 = (long) (this.zzc[i13 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzip.zzn(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 52:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzip.zzb(bArr, i))));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 53:
            case 54:
                if (i12 == 0) {
                    int zzm2 = zzip.zzm(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzio2.zzb));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i12 == 0) {
                    int zzj2 = zzip.zzj(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzio2.zza));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i12 == 1) {
                    unsafe.putObject(obj2, j2, Long.valueOf(zzip.zzn(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 8;
                }
                break;
            case 57:
            case 64:
                if (i12 == 5) {
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzip.zzb(bArr, i)));
                    unsafe.putInt(obj2, j3, i11);
                    return i9 + 4;
                }
                break;
            case 58:
                if (i12 == 0) {
                    int zzm3 = zzip.zzm(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Boolean.valueOf(zzio2.zzb != 0));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm3;
                }
                break;
            case 59:
                if (i12 == 2) {
                    int zzj3 = zzip.zzj(bArr2, i9, zzio2);
                    int i14 = zzio2.zza;
                    if (i14 == 0) {
                        unsafe.putObject(obj2, j2, "");
                    } else if ((i6 & 536870912) == 0 || zzna.zzf(bArr2, zzj3, zzj3 + i14)) {
                        unsafe.putObject(obj2, j2, new String(bArr2, zzj3, i14, zzkk.zzb));
                        zzj3 += i14;
                    } else {
                        throw zzkm.zzc();
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzj3;
                }
                break;
            case 60:
                if (i12 == 2) {
                    int zzd2 = zzip.zzd(zzE(i13), bArr2, i9, i2, zzio2);
                    Object object2 = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j2, zzio2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkk.zzg(object2, zzio2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzd2;
                }
                break;
            case 61:
                if (i12 == 2) {
                    int zza2 = zzip.zza(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, zzio2.zzc);
                    unsafe.putInt(obj2, j3, i11);
                    return zza2;
                }
                break;
            case 63:
                if (i12 == 0) {
                    int zzj4 = zzip.zzj(bArr2, i9, zzio2);
                    int i15 = zzio2.zza;
                    zzkg zzD = zzD(i13);
                    if (zzD == null || zzD.zza(i15)) {
                        unsafe.putObject(obj2, j2, Integer.valueOf(i15));
                        unsafe.putInt(obj2, j3, i11);
                    } else {
                        zzd(obj).zzh(i10, Long.valueOf((long) i15));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i12 == 0) {
                    int zzj5 = zzip.zzj(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Integer.valueOf(zzjf.zzb(zzio2.zza)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzj5;
                }
                break;
            case 67:
                if (i12 == 0) {
                    int zzm4 = zzip.zzm(bArr2, i9, zzio2);
                    unsafe.putObject(obj2, j2, Long.valueOf(zzjf.zzc(zzio2.zzb)));
                    unsafe.putInt(obj2, j3, i11);
                    return zzm4;
                }
                break;
            case 68:
                if (i12 == 3) {
                    int zzc2 = zzip.zzc(zzE(i13), bArr, i, i2, (i10 & -8) | 4, zzio);
                    Object object3 = unsafe.getInt(obj2, j3) == i11 ? unsafe.getObject(obj2, j2) : null;
                    if (object3 == null) {
                        unsafe.putObject(obj2, j2, zzio2.zzc);
                    } else {
                        unsafe.putObject(obj2, j2, zzkk.zzg(object3, zzio2.zzc));
                    }
                    unsafe.putInt(obj2, j3, i11);
                    return zzc2;
                }
                break;
        }
        return i9;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02ee, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0321, code lost:
        if (r0 != r15) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0344, code lost:
        if (r0 != r15) goto L_0x02d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0222, code lost:
        r6 = r6 | r23;
        r2 = r7;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0226, code lost:
        r7 = r19;
        r1 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x022c, code lost:
        r2 = r5;
        r28 = r10;
        r23 = -1;
        r29 = r19;
        r19 = r7;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02d6, code lost:
        if (r0 != r15) goto L_0x02d8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzu(java.lang.Object r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.measurement.zzio r36) throws java.io.IOException {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r34
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x036e
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.measurement.zzip.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzx(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzw(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r10) goto L_0x004d
            r2 = r4
            r20 = r5
            r28 = r9
            r23 = r10
            r19 = r16
            goto L_0x0347
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r10 = zzA(r1)
            r34 = r5
            r5 = r1 & r8
            r19 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0239
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x008a
            r20 = r2
            if (r7 == r5) goto L_0x007e
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0080
        L_0x007e:
            r7 = r19
        L_0x0080:
            if (r0 == r5) goto L_0x0087
            long r1 = (long) r0
            int r6 = r7.getInt(r14, r1)
        L_0x0087:
            r2 = r7
            r7 = r0
            goto L_0x008e
        L_0x008a:
            r20 = r2
            r2 = r19
        L_0x008e:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x0208;
                case 1: goto L_0x01ee;
                case 2: goto L_0x01ce;
                case 3: goto L_0x01ce;
                case 4: goto L_0x01b7;
                case 5: goto L_0x0199;
                case 6: goto L_0x0183;
                case 7: goto L_0x0163;
                case 8: goto L_0x0141;
                case 9: goto L_0x0115;
                case 10: goto L_0x00fe;
                case 11: goto L_0x01b7;
                case 12: goto L_0x00e8;
                case 13: goto L_0x0183;
                case 14: goto L_0x0199;
                case 15: goto L_0x00ce;
                case 16: goto L_0x009e;
                default: goto L_0x0092;
            }
        L_0x0092:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
        L_0x009b:
            r5 = r4
            goto L_0x022c
        L_0x009e:
            if (r3 != 0) goto L_0x00c4
            int r10 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r21 = com.google.android.gms.internal.measurement.zzjf.zzc(r0)
            r0 = r2
            r1 = r32
            r4 = r2
            r19 = r7
            r7 = r20
            r2 = r8
            r20 = r34
            r8 = r4
            r25 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r8
            r0 = r10
            goto L_0x0226
        L_0x00c4:
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            r10 = r2
            goto L_0x009b
        L_0x00ce:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            if (r3 != 0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzjf.zzb(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x0222
        L_0x00e8:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            if (r3 != 0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0222
        L_0x00fe:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r0 = 2
            r20 = r34
            if (r3 != r0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzip.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0222
        L_0x0115:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r0 = 2
            r20 = r34
            if (r3 != r0) goto L_0x009b
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r7)
            int r0 = com.google.android.gms.internal.measurement.zzip.zzd(r0, r12, r4, r13, r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0136
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0222
        L_0x0136:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkk.zzg(r1, r2)
            r10.putObject(r14, r8, r1)
            goto L_0x0222
        L_0x0141:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r0 = 2
            r20 = r34
            if (r3 != r0) goto L_0x009b
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0158
            int r0 = com.google.android.gms.internal.measurement.zzip.zzg(r12, r4, r11)
            goto L_0x015c
        L_0x0158:
            int r0 = com.google.android.gms.internal.measurement.zzip.zzh(r12, r4, r11)
        L_0x015c:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0222
        L_0x0163:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            if (r3 != 0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x017c
            r1 = 1
            goto L_0x017e
        L_0x017c:
            r1 = r16
        L_0x017e:
            com.google.android.gms.internal.measurement.zzmv.zzm(r14, r8, r1)
            goto L_0x0222
        L_0x0183:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            if (r3 != r0) goto L_0x009b
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0222
        L_0x0199:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r0 = 1
            r20 = r34
            if (r3 != r0) goto L_0x009b
            long r21 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r4)
            r0 = r10
            r1 = r32
            r2 = r8
            r8 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0222
        L_0x01b7:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            r5 = r4
            if (r3 != 0) goto L_0x022c
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r5, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0222
        L_0x01ce:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            r5 = r4
            if (r3 != 0) goto L_0x022c
            int r17 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r32
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            r0 = r17
            goto L_0x0226
        L_0x01ee:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r20 = r34
            r5 = r4
            if (r3 != r0) goto L_0x022c
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r5)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmv.zzp(r14, r8, r0)
            int r0 = r5 + 4
            goto L_0x0222
        L_0x0208:
            r10 = r2
            r25 = r5
            r19 = r7
            r7 = r20
            r0 = 1
            r20 = r34
            r5 = r4
            if (r3 != r0) goto L_0x022c
            long r0 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r5)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmv.zzo(r14, r8, r0)
            int r0 = r5 + 8
        L_0x0222:
            r6 = r6 | r23
            r2 = r7
            r9 = r10
        L_0x0226:
            r7 = r19
            r1 = r20
            goto L_0x0286
        L_0x022c:
            r2 = r5
            r28 = r10
            r23 = -1
            r29 = r19
            r19 = r7
            r7 = r29
            goto L_0x0347
        L_0x0239:
            r20 = r34
            r5 = r4
            r4 = r19
            r25 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r7
            r7 = r2
            r0 = 27
            if (r10 != r0) goto L_0x0298
            r0 = 2
            if (r3 != r0) goto L_0x028b
            java.lang.Object r0 = r4.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzkj r0 = (com.google.android.gms.internal.measurement.zzkj) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0268
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0260
            r1 = 10
            goto L_0x0261
        L_0x0260:
            int r1 = r1 + r1
        L_0x0261:
            com.google.android.gms.internal.measurement.zzkj r0 = r0.zzd(r1)
            r4.putObject(r14, r8, r0)
        L_0x0268:
            r8 = r0
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r7)
            r1 = r17
            r2 = r33
            r3 = r5
            r23 = r4
            r4 = r35
            r5 = r8
            r8 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.measurement.zzip.zze(r0, r1, r2, r3, r4, r5, r6)
            r2 = r7
            r6 = r8
            r7 = r19
            r1 = r20
            r9 = r23
        L_0x0286:
            r8 = r25
            r10 = -1
            goto L_0x0019
        L_0x028b:
            r28 = r4
            r15 = r5
            r26 = r6
            r27 = r19
            r23 = -1
            r19 = r7
            goto L_0x0324
        L_0x0298:
            r23 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02f0
            r1 = r21
            long r1 = (long) r1
            r0 = r31
            r21 = r1
            r1 = r32
            r2 = r33
            r4 = r3
            r3 = r5
            r34 = r4
            r4 = r35
            r15 = r5
            r5 = r17
            r26 = r6
            r6 = r20
            r27 = r19
            r19 = r7
            r7 = r34
            r29 = r8
            r9 = r25
            r24 = r29
            r8 = r19
            r18 = r10
            r28 = r23
            r23 = -1
            r9 = r21
            r11 = r18
            r12 = r24
            r14 = r36
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02ee
        L_0x02d8:
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r2 = r19
            r1 = r20
            r10 = r23
            r6 = r26
            r7 = r27
            goto L_0x0367
        L_0x02ee:
            r2 = r0
            goto L_0x0325
        L_0x02f0:
            r34 = r3
            r15 = r5
            r26 = r6
            r24 = r8
            r18 = r10
            r27 = r19
            r1 = r21
            r28 = r23
            r23 = -1
            r19 = r7
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x032a
            r7 = r34
            r0 = 2
            if (r7 != r0) goto L_0x0324
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r19
            r6 = r24
            r8 = r36
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02ee
            goto L_0x02d8
        L_0x0324:
            r2 = r15
        L_0x0325:
            r6 = r26
            r7 = r27
            goto L_0x0347
        L_0x032a:
            r7 = r34
            r0 = r31
            r8 = r1
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r17
            r6 = r20
            r10 = r24
            r12 = r19
            r13 = r36
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02ee
            goto L_0x02d8
        L_0x0347:
            com.google.android.gms.internal.measurement.zzmm r4 = zzd(r32)
            r0 = r17
            r1 = r33
            r3 = r35
            r5 = r36
            int r0 = com.google.android.gms.internal.measurement.zzip.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r2 = r19
            r1 = r20
            r10 = r23
        L_0x0367:
            r9 = r28
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x036e:
            r26 = r6
            r1 = r8
            r28 = r9
            if (r7 == r1) goto L_0x037f
            long r1 = (long) r7
            r3 = r32
            r6 = r26
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x037f:
            r1 = r35
            if (r0 != r1) goto L_0x0384
            return r0
        L_0x0384:
            com.google.android.gms.internal.measurement.zzkm r0 = com.google.android.gms.internal.measurement.zzkm.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzu(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzio):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0452 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d1  */
    private final int zzv(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzio r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzkj r11 = (com.google.android.gms.internal.measurement.zzkj) r11
            boolean r12 = r11.zzc()
            if (r12 != 0) goto L_0x0034
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002a
            r12 = 10
            goto L_0x002b
        L_0x002a:
            int r12 = r12 + r12
        L_0x002b:
            com.google.android.gms.internal.measurement.zzkj r11 = r11.zzd(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0034:
            r9 = 5
            r12 = 0
            r10 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e3;
                case 19: goto L_0x0396;
                case 20: goto L_0x0353;
                case 21: goto L_0x0353;
                case 22: goto L_0x0338;
                case 23: goto L_0x02f7;
                case 24: goto L_0x02b6;
                case 25: goto L_0x025c;
                case 26: goto L_0x01a9;
                case 27: goto L_0x018e;
                case 28: goto L_0x0134;
                case 29: goto L_0x0338;
                case 30: goto L_0x00fc;
                case 31: goto L_0x02b6;
                case 32: goto L_0x02f7;
                case 33: goto L_0x00ad;
                case 34: goto L_0x005e;
                case 35: goto L_0x03e3;
                case 36: goto L_0x0396;
                case 37: goto L_0x0353;
                case 38: goto L_0x0353;
                case 39: goto L_0x0338;
                case 40: goto L_0x02f7;
                case 41: goto L_0x02b6;
                case 42: goto L_0x025c;
                case 43: goto L_0x0338;
                case 44: goto L_0x00fc;
                case 45: goto L_0x02b6;
                case 46: goto L_0x02f7;
                case 47: goto L_0x00ad;
                case 48: goto L_0x005e;
                default: goto L_0x003c;
            }
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x0451
            com.google.android.gms.internal.measurement.zzlu r1 = r15.zzE(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzip.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x005e:
            if (r6 != r14) goto L_0x0082
            com.google.android.gms.internal.measurement.zzky r11 = (com.google.android.gms.internal.measurement.zzky) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0069:
            if (r1 >= r2) goto L_0x0079
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjf.zzc(r4)
            r11.zzg(r4)
            goto L_0x0069
        L_0x0079:
            if (r1 != r2) goto L_0x007d
            goto L_0x0452
        L_0x007d:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0082:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.measurement.zzky r11 = (com.google.android.gms.internal.measurement.zzky) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjf.zzc(r8)
            r11.zzg(r8)
        L_0x0093:
            if (r1 >= r5) goto L_0x00ac
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009e
            goto L_0x00ac
        L_0x009e:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzjf.zzc(r8)
            r11.zzg(r8)
            goto L_0x0093
        L_0x00ac:
            return r1
        L_0x00ad:
            if (r6 != r14) goto L_0x00d1
            com.google.android.gms.internal.measurement.zzkd r11 = (com.google.android.gms.internal.measurement.zzkd) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b8:
            if (r1 >= r2) goto L_0x00c8
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjf.zzb(r4)
            r11.zzh(r4)
            goto L_0x00b8
        L_0x00c8:
            if (r1 != r2) goto L_0x00cc
            goto L_0x0452
        L_0x00cc:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x00d1:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.measurement.zzkd r11 = (com.google.android.gms.internal.measurement.zzkd) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjf.zzb(r4)
            r11.zzh(r4)
        L_0x00e2:
            if (r1 >= r5) goto L_0x00fb
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00ed
            goto L_0x00fb
        L_0x00ed:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzjf.zzb(r4)
            r11.zzh(r4)
            goto L_0x00e2
        L_0x00fb:
            return r1
        L_0x00fc:
            if (r6 != r14) goto L_0x0103
            int r2 = com.google.android.gms.internal.measurement.zzip.zzf(r3, r4, r11, r7)
            goto L_0x0114
        L_0x0103:
            if (r6 != 0) goto L_0x0451
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r11
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzip.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0114:
            com.google.android.gms.internal.measurement.zzkc r1 = (com.google.android.gms.internal.measurement.zzkc) r1
            com.google.android.gms.internal.measurement.zzmm r3 = r1.zzc
            com.google.android.gms.internal.measurement.zzmm r4 = com.google.android.gms.internal.measurement.zzmm.zzc()
            if (r3 != r4) goto L_0x011f
            r3 = 0
        L_0x011f:
            com.google.android.gms.internal.measurement.zzkg r4 = r15.zzD(r8)
            com.google.android.gms.internal.measurement.zzml r5 = r0.zzn
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzlw.zzC(r6, r11, r4, r3, r5)
            if (r3 != 0) goto L_0x012f
            goto L_0x027d
        L_0x012f:
            com.google.android.gms.internal.measurement.zzmm r3 = (com.google.android.gms.internal.measurement.zzmm) r3
            r1.zzc = r3
            return r2
        L_0x0134:
            if (r6 != r14) goto L_0x0451
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0189
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0184
            if (r4 != 0) goto L_0x014a
            com.google.android.gms.internal.measurement.zzjb r4 = com.google.android.gms.internal.measurement.zzjb.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x014a:
            com.google.android.gms.internal.measurement.zzjb r6 = com.google.android.gms.internal.measurement.zzjb.zzl(r3, r1, r4)
            r11.add(r6)
        L_0x0151:
            int r1 = r1 + r4
        L_0x0152:
            if (r1 >= r5) goto L_0x0183
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015d
            goto L_0x0183
        L_0x015d:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0179
            if (r4 != 0) goto L_0x0171
            com.google.android.gms.internal.measurement.zzjb r4 = com.google.android.gms.internal.measurement.zzjb.zzb
            r11.add(r4)
            goto L_0x0152
        L_0x0171:
            com.google.android.gms.internal.measurement.zzjb r6 = com.google.android.gms.internal.measurement.zzjb.zzl(r3, r1, r4)
            r11.add(r6)
            goto L_0x0151
        L_0x0179:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x017e:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x0183:
            return r1
        L_0x0184:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0189:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x018e:
            if (r6 == r14) goto L_0x0192
            goto L_0x0451
        L_0x0192:
            com.google.android.gms.internal.measurement.zzlu r1 = r15.zzE(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r11
            r27 = r29
            int r1 = com.google.android.gms.internal.measurement.zzip.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a9:
            if (r6 != r14) goto L_0x0451
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fc
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f7
            if (r4 != 0) goto L_0x01c4
            r11.add(r6)
            goto L_0x01cf
        L_0x01c4:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkk.zzb
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
        L_0x01ce:
            int r1 = r1 + r4
        L_0x01cf:
            if (r1 >= r5) goto L_0x0452
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0452
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f2
            if (r4 != 0) goto L_0x01e7
            r11.add(r6)
            goto L_0x01cf
        L_0x01e7:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzkk.zzb
            r8.<init>(r3, r1, r4, r9)
            r11.add(r8)
            goto L_0x01ce
        L_0x01f2:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x01f7:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x01fc:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0257
            if (r4 != 0) goto L_0x020a
            r11.add(r6)
            goto L_0x021d
        L_0x020a:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzna.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0252
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkk.zzb
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
        L_0x021c:
            r1 = r8
        L_0x021d:
            if (r1 >= r5) goto L_0x0452
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0452
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024d
            if (r4 != 0) goto L_0x0235
            r11.add(r6)
            goto L_0x021d
        L_0x0235:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zzna.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0248
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzkk.zzb
            r9.<init>(r3, r1, r4, r10)
            r11.add(r9)
            goto L_0x021c
        L_0x0248:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzc()
            throw r1
        L_0x024d:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x0252:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzc()
            throw r1
        L_0x0257:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzd()
            throw r1
        L_0x025c:
            r1 = 0
            if (r6 != r14) goto L_0x0285
            com.google.android.gms.internal.measurement.zziq r11 = (com.google.android.gms.internal.measurement.zziq) r11
            int r2 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0268:
            if (r2 >= r4) goto L_0x027b
            int r2 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0276
            r5 = r10
            goto L_0x0277
        L_0x0276:
            r5 = r1
        L_0x0277:
            r11.zze(r5)
            goto L_0x0268
        L_0x027b:
            if (r2 != r4) goto L_0x0280
        L_0x027d:
            r1 = r2
            goto L_0x0452
        L_0x0280:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0285:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.measurement.zziq r11 = (com.google.android.gms.internal.measurement.zziq) r11
            int r4 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0295
            r6 = r10
            goto L_0x0296
        L_0x0295:
            r6 = r1
        L_0x0296:
            r11.zze(r6)
        L_0x0299:
            if (r4 >= r5) goto L_0x02b5
            int r6 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a4
            goto L_0x02b5
        L_0x02a4:
            int r4 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x02b0
            r6 = r10
            goto L_0x02b1
        L_0x02b0:
            r6 = r1
        L_0x02b1:
            r11.zze(r6)
            goto L_0x0299
        L_0x02b5:
            return r4
        L_0x02b6:
            if (r6 != r14) goto L_0x02d6
            com.google.android.gms.internal.measurement.zzkd r11 = (com.google.android.gms.internal.measurement.zzkd) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02c1:
            if (r1 >= r2) goto L_0x02cd
            int r4 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r1)
            r11.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02c1
        L_0x02cd:
            if (r1 != r2) goto L_0x02d1
            goto L_0x0452
        L_0x02d1:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x02d6:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.measurement.zzkd r11 = (com.google.android.gms.internal.measurement.zzkd) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r17, r18)
            r11.zzh(r1)
        L_0x02e1:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f6
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ee
            goto L_0x02f6
        L_0x02ee:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r4)
            r11.zzh(r1)
            goto L_0x02e1
        L_0x02f6:
            return r1
        L_0x02f7:
            if (r6 != r14) goto L_0x0317
            com.google.android.gms.internal.measurement.zzky r11 = (com.google.android.gms.internal.measurement.zzky) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0302:
            if (r1 >= r2) goto L_0x030e
            long r4 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r1)
            r11.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0302
        L_0x030e:
            if (r1 != r2) goto L_0x0312
            goto L_0x0452
        L_0x0312:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0317:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.measurement.zzky r11 = (com.google.android.gms.internal.measurement.zzky) r11
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r17, r18)
            r11.zzg(r8)
        L_0x0322:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0337
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032f
            goto L_0x0337
        L_0x032f:
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r4)
            r11.zzg(r8)
            goto L_0x0322
        L_0x0337:
            return r1
        L_0x0338:
            if (r6 != r14) goto L_0x0340
            int r1 = com.google.android.gms.internal.measurement.zzip.zzf(r3, r4, r11, r7)
            goto L_0x0452
        L_0x0340:
            if (r6 == 0) goto L_0x0344
            goto L_0x0451
        L_0x0344:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r11
            r25 = r29
            int r1 = com.google.android.gms.internal.measurement.zzip.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0353:
            if (r6 != r14) goto L_0x0373
            com.google.android.gms.internal.measurement.zzky r11 = (com.google.android.gms.internal.measurement.zzky) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035e:
            if (r1 >= r2) goto L_0x036a
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r11.zzg(r4)
            goto L_0x035e
        L_0x036a:
            if (r1 != r2) goto L_0x036e
            goto L_0x0452
        L_0x036e:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0373:
            if (r6 != 0) goto L_0x0451
            com.google.android.gms.internal.measurement.zzky r11 = (com.google.android.gms.internal.measurement.zzky) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r11.zzg(r8)
        L_0x0380:
            if (r1 >= r5) goto L_0x0395
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x038b
            goto L_0x0395
        L_0x038b:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r11.zzg(r8)
            goto L_0x0380
        L_0x0395:
            return r1
        L_0x0396:
            if (r6 != r14) goto L_0x03ba
            com.google.android.gms.internal.measurement.zzjv r11 = (com.google.android.gms.internal.measurement.zzjv) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a1:
            if (r1 >= r2) goto L_0x03b1
            int r4 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r11.zze(r4)
            int r1 = r1 + 4
            goto L_0x03a1
        L_0x03b1:
            if (r1 != r2) goto L_0x03b5
            goto L_0x0452
        L_0x03b5:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x03ba:
            if (r6 != r9) goto L_0x0451
            com.google.android.gms.internal.measurement.zzjv r11 = (com.google.android.gms.internal.measurement.zzjv) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zze(r1)
        L_0x03c9:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e2
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d6
            goto L_0x03e2
        L_0x03d6:
            int r1 = com.google.android.gms.internal.measurement.zzip.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r11.zze(r1)
            goto L_0x03c9
        L_0x03e2:
            return r1
        L_0x03e3:
            if (r6 != r14) goto L_0x0406
            com.google.android.gms.internal.measurement.zzjl r11 = (com.google.android.gms.internal.measurement.zzjl) r11
            int r1 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ee:
            if (r1 >= r2) goto L_0x03fe
            long r4 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r11.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ee
        L_0x03fe:
            if (r1 != r2) goto L_0x0401
            goto L_0x0452
        L_0x0401:
            com.google.android.gms.internal.measurement.zzkm r1 = com.google.android.gms.internal.measurement.zzkm.zzf()
            throw r1
        L_0x0406:
            if (r6 != r10) goto L_0x0451
            com.google.android.gms.internal.measurement.zzjl r11 = (com.google.android.gms.internal.measurement.zzjl) r11
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zze(r8)
        L_0x0415:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042e
            int r4 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0422
            goto L_0x042e
        L_0x0422:
            long r8 = com.google.android.gms.internal.measurement.zzip.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r11.zze(r8)
            goto L_0x0415
        L_0x042e:
            return r1
        L_0x042f:
            if (r4 >= r5) goto L_0x0450
            int r8 = com.google.android.gms.internal.measurement.zzip.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x043a
            goto L_0x0450
        L_0x043a:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.measurement.zzip.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x042f
        L_0x0450:
            return r4
        L_0x0451:
            r1 = r4
        L_0x0452:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzv(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzio):int");
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzB(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzA(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzS(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzr(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzC(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzo(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzR(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzmv.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzmv.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzmv.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzkk.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzml r0 = r8.zzn
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.measurement.zzjp r0 = r8.zzo
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x037e, code lost:
        if (r0 != r15) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x039a, code lost:
        r6 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03c6, code lost:
        if (r0 != r15) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03e6, code lost:
        if (r0 != r15) goto L_0x0380;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0167, code lost:
        r5 = r6 | r25;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016b, code lost:
        r3 = r8;
        r1 = r11;
        r6 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01a2, code lost:
        r21 = r3;
        r13 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0205, code lost:
        r5 = r6 | r25;
        r3 = r2;
        r1 = r11;
        r6 = r27;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x020d, code lost:
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0211, code lost:
        r13 = r2;
        r21 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0214, code lost:
        r18 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b5, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b7, code lost:
        r5 = r6 | r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02b9, code lost:
        r2 = r32;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bd, code lost:
        r3 = r13;
        r1 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02d4, code lost:
        r21 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02d6, code lost:
        r22 = r6;
        r28 = r10;
        r7 = r18;
        r2 = r21;
        r6 = r34;
        r21 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzio r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            r17 = 0
            if (r0 >= r13) goto L_0x045b
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002d
            int r0 = com.google.android.gms.internal.measurement.zzip.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002e
        L_0x002d:
            r4 = r0
        L_0x002e:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r2) goto L_0x003b
            int r3 = r3 / r8
            int r2 = r15.zzx(r0, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzw(r0)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0053
            r32 = r0
            r2 = r1
            r19 = r3
            r7 = r4
            r22 = r5
            r27 = r6
            r28 = r10
            r6 = r11
            r21 = r16
            goto L_0x03e9
        L_0x0053:
            int[] r3 = r15.zzc
            int r20 = r2 + 1
            r8 = r3[r20]
            int r11 = zzA(r8)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r8 & r18
            r21 = r1
            long r0 = (long) r0
            r22 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02e4
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r25 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x008d
            r18 = r4
            if (r6 == r3) goto L_0x0084
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0084:
            long r3 = (long) r0
            int r3 = r10.getInt(r14, r3)
            r27 = r0
            r6 = r3
            goto L_0x0092
        L_0x008d:
            r18 = r4
            r27 = r6
            r6 = r5
        L_0x0092:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x029c;
                case 1: goto L_0x0280;
                case 2: goto L_0x0259;
                case 3: goto L_0x0259;
                case 4: goto L_0x0240;
                case 5: goto L_0x0218;
                case 6: goto L_0x01ed;
                case 7: goto L_0x01cb;
                case 8: goto L_0x01a7;
                case 9: goto L_0x0171;
                case 10: goto L_0x014d;
                case 11: goto L_0x0240;
                case 12: goto L_0x0116;
                case 13: goto L_0x01ed;
                case 14: goto L_0x0218;
                case 15: goto L_0x00f8;
                case 16: goto L_0x00c5;
                default: goto L_0x0096;
            }
        L_0x0096:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r0 = 3
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x02d4
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r13)
            int r1 = r32 << 3
            r7 = r1 | 4
            r1 = r31
            r2 = r11
            r3 = r33
            r11 = r4
            r4 = r7
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r25
            if (r1 != 0) goto L_0x02c2
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r11, r1)
            goto L_0x02cf
        L_0x00c5:
            if (r7 != 0) goto L_0x00ee
            r3 = r21
            int r7 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.measurement.zzjf.zzc(r0)
            r11 = r20
            r0 = r10
            r1 = r30
            r8 = r2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r22
            r32 = r11
            r11 = r18
            r0.putLong(r1, r2, r4)
            r5 = r6 | r25
            r2 = r32
            r0 = r7
            goto L_0x016b
        L_0x00ee:
            r32 = r20
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r2
            goto L_0x02d6
        L_0x00f8:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x01a2
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzjf.zzb(r1)
            r4 = r22
            r10.putInt(r14, r4, r1)
            goto L_0x0167
        L_0x0116:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x01a2
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r3, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzkg r2 = r15.zzD(r8)
            if (r2 == 0) goto L_0x0149
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0139
            goto L_0x0149
        L_0x0139:
            com.google.android.gms.internal.measurement.zzmm r2 = zzd(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r2 = r32
            r5 = r6
            goto L_0x016b
        L_0x0149:
            r10.putInt(r14, r4, r1)
            goto L_0x0167
        L_0x014d:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x01a2
            int r0 = com.google.android.gms.internal.measurement.zzip.zza(r12, r3, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
        L_0x0167:
            r5 = r6 | r25
            r2 = r32
        L_0x016b:
            r3 = r8
            r1 = r11
            r6 = r27
            goto L_0x020d
        L_0x0171:
            r8 = r2
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x01a2
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r8)
            int r0 = com.google.android.gms.internal.measurement.zzip.zzd(r0, r12, r3, r13, r9)
            r1 = r6 & r25
            if (r1 != 0) goto L_0x0194
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0167
        L_0x0194:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkk.zzg(r1, r2)
            r10.putObject(r14, r4, r1)
            goto L_0x0167
        L_0x01a2:
            r21 = r3
            r13 = r8
            goto L_0x0214
        L_0x01a7:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r0 = 2
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x0211
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r8
            if (r0 != 0) goto L_0x01c1
            int r0 = com.google.android.gms.internal.measurement.zzip.zzg(r12, r3, r9)
            goto L_0x01c5
        L_0x01c1:
            int r0 = com.google.android.gms.internal.measurement.zzip.zzh(r12, r3, r9)
        L_0x01c5:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0205
        L_0x01cb:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0211
            int r0 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r3, r9)
            long r7 = r9.zzb
            r17 = 0
            int r3 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x01e7
            goto L_0x01e9
        L_0x01e7:
            r1 = r16
        L_0x01e9:
            com.google.android.gms.internal.measurement.zzmv.zzm(r14, r4, r1)
            goto L_0x0205
        L_0x01ed:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x0211
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x0205:
            r5 = r6 | r25
            r3 = r2
            r1 = r11
            r6 = r27
            r2 = r32
        L_0x020d:
            r11 = r34
            goto L_0x001a
        L_0x0211:
            r13 = r2
            r21 = r3
        L_0x0214:
            r18 = r11
            goto L_0x02d6
        L_0x0218:
            r11 = r18
            r32 = r20
            r3 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x0239
            long r7 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r3)
            r0 = r10
            r1 = r30
            r13 = r2
            r18 = r11
            r11 = r3
            r2 = r4
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x02b5
        L_0x0239:
            r13 = r2
            r18 = r11
            r21 = r3
            goto L_0x02d6
        L_0x0240:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x02d4
            int r0 = com.google.android.gms.internal.measurement.zzip.zzj(r12, r11, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x02b7
        L_0x0259:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x02d4
            int r7 = com.google.android.gms.internal.measurement.zzip.zzm(r12, r11, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r30
            r21 = r2
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            r5 = r6 | r25
            r2 = r32
            r11 = r34
            r0 = r7
            goto L_0x02bd
        L_0x0280:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x02d4
            int r0 = com.google.android.gms.internal.measurement.zzip.zzb(r12, r11)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zzmv.zzp(r14, r4, r0)
            int r0 = r11 + 4
            goto L_0x02b7
        L_0x029c:
            r13 = r2
            r32 = r20
            r11 = r21
            r4 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x02d4
            long r0 = com.google.android.gms.internal.measurement.zzip.zzn(r12, r11)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zzmv.zzo(r14, r4, r0)
        L_0x02b5:
            int r0 = r11 + 8
        L_0x02b7:
            r5 = r6 | r25
        L_0x02b9:
            r2 = r32
            r11 = r34
        L_0x02bd:
            r3 = r13
            r1 = r18
            goto L_0x0336
        L_0x02c2:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkk.zzg(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x02cf:
            r5 = r6 | r25
            r12 = r31
            goto L_0x02b9
        L_0x02d4:
            r21 = r11
        L_0x02d6:
            r22 = r6
            r28 = r10
            r7 = r18
            r2 = r21
            r6 = r34
            r21 = r13
            goto L_0x03e9
        L_0x02e4:
            r13 = r2
            r18 = r4
            r3 = r11
            r4 = r20
            r11 = r22
            r19 = -1
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r0 = 27
            if (r3 != r0) goto L_0x034a
            r0 = 2
            if (r7 != r0) goto L_0x033c
            java.lang.Object r0 = r10.getObject(r14, r11)
            com.google.android.gms.internal.measurement.zzkj r0 = (com.google.android.gms.internal.measurement.zzkj) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0315
            int r1 = r0.size()
            if (r1 != 0) goto L_0x030d
            r1 = 10
            goto L_0x030e
        L_0x030d:
            int r1 = r1 + r1
        L_0x030e:
            com.google.android.gms.internal.measurement.zzkj r0 = r0.zzd(r1)
            r10.putObject(r14, r11, r0)
        L_0x0315:
            r7 = r0
            com.google.android.gms.internal.measurement.zzlu r0 = r15.zzE(r13)
            r1 = r18
            r2 = r31
            r3 = r21
            r8 = r4
            r4 = r33
            r22 = r5
            r5 = r7
            r27 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r31
            r11 = r34
            r2 = r8
            r3 = r13
            r5 = r22
        L_0x0336:
            r6 = r27
            r13 = r33
            goto L_0x001a
        L_0x033c:
            r22 = r5
            r27 = r6
            r32 = r4
            r28 = r10
            r15 = r21
            r21 = r13
            goto L_0x03c9
        L_0x034a:
            r22 = r5
            r27 = r6
            r6 = r4
            r0 = 49
            if (r3 > r0) goto L_0x039e
            long r4 = (long) r8
            r0 = r29
            r1 = r30
            r2 = r31
            r8 = r3
            r3 = r21
            r23 = r4
            r4 = r33
            r5 = r18
            r32 = r6
            r20 = r8
            r8 = r13
            r28 = r10
            r9 = r23
            r25 = r11
            r15 = r21
            r12 = r34
            r11 = r20
            r21 = r13
            r12 = r25
            r14 = r35
            int r0 = r0.zzv(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x039a
        L_0x0380:
            r15 = r29
            r14 = r30
            r12 = r31
            r2 = r32
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r18
            r3 = r21
            r5 = r22
            r6 = r27
            r10 = r28
            goto L_0x001a
        L_0x039a:
            r6 = r34
            r2 = r0
            goto L_0x03cc
        L_0x039e:
            r20 = r3
            r32 = r6
            r28 = r10
            r25 = r11
            r15 = r21
            r21 = r13
            r0 = 50
            r9 = r20
            if (r9 != r0) goto L_0x03cf
            r0 = 2
            if (r7 != r0) goto L_0x03c9
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r21
            r6 = r25
            r8 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x039a
            goto L_0x0380
        L_0x03c9:
            r6 = r34
            r2 = r15
        L_0x03cc:
            r7 = r18
            goto L_0x03e9
        L_0x03cf:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r32
            r10 = r25
            r12 = r21
            r13 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x039a
            goto L_0x0380
        L_0x03e9:
            if (r7 != r6) goto L_0x03fa
            if (r6 == 0) goto L_0x03fa
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r29
            r11 = r30
            r1 = r22
            r0 = r27
            goto L_0x046d
        L_0x03fa:
            r8 = r29
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0433
            r9 = r35
            com.google.android.gms.internal.measurement.zzjo r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzjo r1 = com.google.android.gms.internal.measurement.zzjo.zza()
            if (r0 == r1) goto L_0x042e
            com.google.android.gms.internal.measurement.zzlj r0 = r8.zzg
            com.google.android.gms.internal.measurement.zzjo r1 = r9.zzd
            r10 = r32
            com.google.android.gms.internal.measurement.zzka r0 = r1.zzc(r0, r10)
            if (r0 != 0) goto L_0x0428
            com.google.android.gms.internal.measurement.zzmm r4 = zzd(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zzi(r0, r1, r2, r3, r4, r5)
            r11 = r30
            goto L_0x0448
        L_0x0428:
            r11 = r30
            r0 = r11
            com.google.android.gms.internal.measurement.zzjz r0 = (com.google.android.gms.internal.measurement.zzjz) r0
            throw r17
        L_0x042e:
            r11 = r30
            r10 = r32
            goto L_0x0439
        L_0x0433:
            r11 = r30
            r10 = r32
            r9 = r35
        L_0x0439:
            com.google.android.gms.internal.measurement.zzmm r4 = zzd(r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzip.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0448:
            r12 = r31
            r13 = r33
            r1 = r7
            r15 = r8
            r2 = r10
            r14 = r11
            r3 = r21
            r5 = r22
            r10 = r28
            r11 = r6
            r6 = r27
            goto L_0x001a
        L_0x045b:
            r22 = r5
            r27 = r6
            r28 = r10
            r6 = r11
            r11 = r14
            r8 = r15
            r2 = r0
            r7 = r1
            r1 = r22
            r0 = r27
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x046d:
            if (r0 == r3) goto L_0x0475
            long r4 = (long) r0
            r0 = r28
            r0.putInt(r11, r4, r1)
        L_0x0475:
            int r0 = r8.zzk
        L_0x0477:
            int r1 = r8.zzl
            if (r0 >= r1) goto L_0x04a2
            int[] r1 = r8.zzj
            r1 = r1[r0]
            int[] r4 = r8.zzc
            r4 = r4[r1]
            int r4 = r8.zzB(r1)
            r4 = r4 & r3
            long r4 = (long) r4
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r11, r4)
            if (r4 != 0) goto L_0x0490
            goto L_0x0496
        L_0x0490:
            com.google.android.gms.internal.measurement.zzkg r5 = r8.zzD(r1)
            if (r5 != 0) goto L_0x0499
        L_0x0496:
            int r0 = r0 + 1
            goto L_0x0477
        L_0x0499:
            com.google.android.gms.internal.measurement.zzld r4 = (com.google.android.gms.internal.measurement.zzld) r4
            java.lang.Object r0 = r8.zzF(r1)
            com.google.android.gms.internal.measurement.zzlc r0 = (com.google.android.gms.internal.measurement.zzlc) r0
            throw r17
        L_0x04a2:
            if (r6 != 0) goto L_0x04ae
            r0 = r33
            if (r2 != r0) goto L_0x04a9
            goto L_0x04b4
        L_0x04a9:
            com.google.android.gms.internal.measurement.zzkm r0 = com.google.android.gms.internal.measurement.zzkm.zze()
            throw r0
        L_0x04ae:
            r0 = r33
            if (r2 > r0) goto L_0x04b5
            if (r7 != r6) goto L_0x04b5
        L_0x04b4:
            return r2
        L_0x04b5:
            com.google.android.gms.internal.measurement.zzkm r0 = com.google.android.gms.internal.measurement.zzkm.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlm.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzio):int");
    }

    public final Object zze() {
        return ((zzkc) this.zzg).zzl(4, (Object) null, (Object) null);
    }

    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long zzB = (long) (zzB(this.zzj[i2]) & 1048575);
            Object zzf2 = zzmv.zzf(obj, zzB);
            if (zzf2 != null) {
                ((zzld) zzf2).zzc();
                zzmv.zzs(obj, zzB, zzf2);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, (long) this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    public final void zzg(Object obj, Object obj2) {
        if (obj2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzB = zzB(i);
                long j = (long) (1048575 & zzB);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzo(obj, j, zzmv.zza(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzp(obj, j, zzmv.zzb(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzm(obj, j, zzmv.zzw(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 9:
                        zzH(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzq(obj, j, zzmv.zzc(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzO(obj2, i)) {
                            break;
                        } else {
                            zzmv.zzr(obj, j, zzmv.zzd(obj2, j));
                            zzJ(obj, i);
                            break;
                        }
                    case 17:
                        zzH(obj, obj2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzm.zzb(obj, obj2, j);
                        break;
                    case 50:
                        zzlw.zzaa(this.zzq, obj, obj2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzR(obj2, i2, i)) {
                            break;
                        } else {
                            zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                            zzK(obj, i2, i);
                            break;
                        }
                    case 60:
                        zzI(obj, obj2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zzR(obj2, i2, i)) {
                            break;
                        } else {
                            zzmv.zzs(obj, j, zzmv.zzf(obj2, j));
                            zzK(obj, i2, i);
                            break;
                        }
                    case 68:
                        zzI(obj, obj2, i);
                        break;
                }
            }
            zzlw.zzF(this.zzn, obj, obj2);
            if (this.zzh) {
                zzlw.zzE(this.zzo, obj, obj2);
                return;
            }
            return;
        }
        throw null;
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzio zzio) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zzio);
        } else {
            zzc(obj, bArr, i, i2, 0, zzio);
        }
    }

    public final void zzi(Object obj, zznd zznd) throws IOException {
        if (!this.zzi) {
            zzL(obj, zznd);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzB = zzB(i);
                int i2 = this.zzc[i];
                switch (zzA(zzB)) {
                    case 0:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzf(i2, zzmv.zza(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzo(i2, zzmv.zzb(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzt(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzJ(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzr(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzm(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzk(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzb(i2, zzmv.zzw(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zzT(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                            break;
                        }
                    case 9:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzv(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 10:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzd(i2, (zzjb) zzmv.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzH(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzi(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzw(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzy(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzA(i2, zzmv.zzc(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzC(i2, zzmv.zzd(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzO(obj, i)) {
                            break;
                        } else {
                            zznd.zzq(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 18:
                        zzlw.zzJ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 19:
                        zzlw.zzN(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 20:
                        zzlw.zzQ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 21:
                        zzlw.zzY(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 22:
                        zzlw.zzP(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 23:
                        zzlw.zzM(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 24:
                        zzlw.zzL(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 25:
                        zzlw.zzH(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 26:
                        zzlw.zzW(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                        break;
                    case 27:
                        zzlw.zzR(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, zzE(i));
                        break;
                    case 28:
                        zzlw.zzI(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                        break;
                    case 29:
                        zzlw.zzX(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 30:
                        zzlw.zzK(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 31:
                        zzlw.zzS(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 32:
                        zzlw.zzT(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 33:
                        zzlw.zzU(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 34:
                        zzlw.zzV(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, false);
                        break;
                    case 35:
                        zzlw.zzJ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 36:
                        zzlw.zzN(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 37:
                        zzlw.zzQ(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 38:
                        zzlw.zzY(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 39:
                        zzlw.zzP(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 40:
                        zzlw.zzM(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 41:
                        zzlw.zzL(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 42:
                        zzlw.zzH(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 43:
                        zzlw.zzX(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 44:
                        zzlw.zzK(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 45:
                        zzlw.zzS(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 46:
                        zzlw.zzT(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 47:
                        zzlw.zzU(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 48:
                        zzlw.zzV(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, true);
                        break;
                    case 49:
                        zzlw.zzO(i2, (List) zzmv.zzf(obj, (long) (zzB & 1048575)), zznd, zzE(i));
                        break;
                    case 50:
                        zzM(zznd, i2, zzmv.zzf(obj, (long) (zzB & 1048575)), i);
                        break;
                    case 51:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzf(i2, zzn(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzo(i2, zzo(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzt(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzJ(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzr(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzm(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzk(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzb(i2, zzS(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zzT(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zznd);
                            break;
                        }
                    case 60:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzv(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                    case 61:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzd(i2, (zzjb) zzmv.zzf(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzH(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzi(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzw(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzy(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzA(i2, zzr(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzC(i2, zzC(obj, (long) (zzB & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzR(obj, i2, i)) {
                            break;
                        } else {
                            zznd.zzq(i2, zzmv.zzf(obj, (long) (zzB & 1048575)), zzE(i));
                            break;
                        }
                }
            }
            zzml zzml = this.zzn;
            zzml.zzi(zzml.zzc(obj), zznd);
        } else {
            this.zzo.zza(obj);
            throw null;
        }
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int zzB = zzB(i);
            long j = (long) (zzB & 1048575);
            switch (zzA(zzB)) {
                case 0:
                    if (zzN(obj, obj2, i) && Double.doubleToLongBits(zzmv.zza(obj, j)) == Double.doubleToLongBits(zzmv.zza(obj2, j))) {
                        continue;
                    }
                case 1:
                    if (zzN(obj, obj2, i) && Float.floatToIntBits(zzmv.zzb(obj, j)) == Float.floatToIntBits(zzmv.zzb(obj2, j))) {
                        continue;
                    }
                case 2:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 3:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 4:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 5:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 6:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 7:
                    if (zzN(obj, obj2, i) && zzmv.zzw(obj, j) == zzmv.zzw(obj2, j)) {
                        continue;
                    }
                case 8:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 9:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 10:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 11:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 12:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 13:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 14:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 15:
                    if (zzN(obj, obj2, i) && zzmv.zzc(obj, j) == zzmv.zzc(obj2, j)) {
                        continue;
                    }
                case 16:
                    if (zzN(obj, obj2, i) && zzmv.zzd(obj, j) == zzmv.zzd(obj2, j)) {
                        continue;
                    }
                case 17:
                    if (zzN(obj, obj2, i) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z = zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j));
                    break;
                case 50:
                    z = zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzy = (long) (zzy(i) & 1048575);
                    if (zzmv.zzc(obj, zzy) == zzmv.zzc(obj2, zzy) && zzlw.zzZ(zzmv.zzf(obj, j), zzmv.zzf(obj2, j))) {
                        continue;
                    }
            }
            if (!z) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i;
        int i2;
        Object obj2 = obj;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.zzk) {
            int i6 = this.zzj[i5];
            int i7 = this.zzc[i6];
            int zzB = zzB(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                i = i9 != 1048575 ? zzb.getInt(obj2, (long) i9) : i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if ((268435456 & zzB) != 0 && !zzP(obj, i6, i2, i, i10)) {
                return false;
            }
            int zzA = zzA(zzB);
            if (zzA != 9 && zzA != 17) {
                if (zzA != 27) {
                    if (zzA == 60 || zzA == 68) {
                        if (zzR(obj2, i7, i6) && !zzQ(obj2, zzB, zzE(i6))) {
                            return false;
                        }
                    } else if (zzA != 49) {
                        if (zzA == 50 && !((zzld) zzmv.zzf(obj2, (long) (zzB & 1048575))).isEmpty()) {
                            zzlc zzlc = (zzlc) zzF(i6);
                            throw null;
                        }
                    }
                }
                List list = (List) zzmv.zzf(obj2, (long) (zzB & 1048575));
                if (!list.isEmpty()) {
                    zzlu zzE = zzE(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!zzE.zzk(list.get(i11))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzP(obj, i6, i2, i, i10) && !zzQ(obj2, zzB, zzE(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }
}
