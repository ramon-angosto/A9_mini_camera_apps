package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzgtj {
    private static final Class zza;
    private static final zzgty zzb = zzab(false);
    private static final zzgty zzc = zzab(true);
    private static final zzgty zzd = new zzgua();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgty zzA() {
        return zzc;
    }

    public static zzgty zzB() {
        return zzd;
    }

    static Object zzC(int i, List list, zzgri zzgri, Object obj, zzgty zzgty) {
        if (zzgri == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            Object obj2 = obj;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzgri.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzD(i, intValue, obj2, zzgty);
                }
            }
            if (i2 == size) {
                return obj2;
            }
            list.subList(i2, size).clear();
            return obj2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!zzgri.zza(intValue2)) {
                obj = zzD(i, intValue2, obj, zzgty);
                it.remove();
            }
        }
        return obj;
    }

    static Object zzD(int i, int i2, Object obj, zzgty zzgty) {
        if (obj == null) {
            obj = zzgty.zzf();
        }
        zzgty.zzl(obj, i, (long) i2);
        return obj;
    }

    static void zzE(zzgqr zzgqr, Object obj, Object obj2) {
        zzgqr.zza(obj2);
        throw null;
    }

    static void zzF(zzgty zzgty, Object obj, Object obj2) {
        zzgty.zzo(obj, zzgty.zze(zzgty.zzd(obj), zzgty.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzgre.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzH(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    static void zzI(zzgsj zzgsj, Object obj, Object obj2, long j) {
        zzgui.zzv(obj, j, zzgsj.zzc(zzgui.zzh(obj, j), zzgui.zzh(obj2, j)));
    }

    public static void zzJ(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzc(i, list, z);
        }
    }

    public static void zzK(int i, List list, zzgqm zzgqm) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zze(i, list);
        }
    }

    public static void zzL(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzg(i, list, z);
        }
    }

    public static void zzM(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzj(i, list, z);
        }
    }

    public static void zzN(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzl(i, list, z);
        }
    }

    public static void zzO(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzn(i, list, z);
        }
    }

    public static void zzP(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzp(i, list, z);
        }
    }

    public static void zzQ(int i, List list, zzgqm zzgqm, zzgth zzgth) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgqm.zzq(i, list.get(i2), zzgth);
            }
        }
    }

    public static void zzR(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzs(i, list, z);
        }
    }

    public static void zzS(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzu(i, list, z);
        }
    }

    public static void zzT(int i, List list, zzgqm zzgqm, zzgth zzgth) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgqm.zzv(i, list.get(i2), zzgth);
            }
        }
    }

    public static void zzU(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzx(i, list, z);
        }
    }

    public static void zzV(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzz(i, list, z);
        }
    }

    public static void zzW(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzB(i, list, z);
        }
    }

    public static void zzX(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzD(i, list, z);
        }
    }

    public static void zzY(int i, List list, zzgqm zzgqm) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzG(i, list);
        }
    }

    public static void zzZ(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzI(i, list, z);
        }
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgql.zzE(i << 3) + 1);
    }

    public static void zzaa(int i, List list, zzgqm zzgqm, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgqm.zzK(i, list, z);
        }
    }

    private static zzgty zzab(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgty) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    static int zzb(List list) {
        return list.size();
    }

    static int zzc(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzD = size * zzgql.zzD(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzD += zzgql.zzw((zzgpw) list.get(i2));
        }
        return zzD;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzgql.zzD(i));
    }

    static int zze(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgrf) {
            zzgrf zzgrf = (zzgrf) list;
            i = 0;
            while (i2 < size) {
                i += zzgql.zzy(zzgrf.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgql.zzy(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgql.zzE(i << 3) + 4);
    }

    static int zzg(List list) {
        return list.size() * 4;
    }

    static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgql.zzE(i << 3) + 8);
    }

    static int zzi(List list) {
        return list.size() * 8;
    }

    static int zzj(int i, List list, zzgth zzgth) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgql.zzx(i, (zzgso) list.get(i3), zzgth);
        }
        return i2;
    }

    static int zzk(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzgql.zzD(i));
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgrf) {
            zzgrf zzgrf = (zzgrf) list;
            i = 0;
            while (i2 < size) {
                i += zzgql.zzy(zzgrf.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgql.zzy(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzgql.zzD(i));
    }

    static int zzn(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgsd) {
            zzgsd zzgsd = (zzgsd) list;
            i = 0;
            while (i2 < size) {
                i += zzgql.zzF(zzgsd.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgql.zzF(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, Object obj, zzgth zzgth) {
        if (!(obj instanceof zzgru)) {
            return zzgql.zzE(i << 3) + zzgql.zzA((zzgso) obj, zzgth);
        }
        int zzE = zzgql.zzE(i << 3);
        int zza2 = ((zzgru) obj).zza();
        return zzE + zzgql.zzE(zza2) + zza2;
    }

    static int zzp(int i, List list, zzgth zzgth) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzD = zzgql.zzD(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgru) {
                i2 = zzgql.zzz((zzgru) obj);
            } else {
                i2 = zzgql.zzA((zzgso) obj, zzgth);
            }
            zzD += i2;
        }
        return zzD;
    }

    static int zzq(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzgql.zzD(i));
    }

    static int zzr(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgrf) {
            zzgrf zzgrf = (zzgrf) list;
            i = 0;
            while (i2 < size) {
                int zze = zzgrf.zze(i2);
                i += zzgql.zzE((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzgql.zzE((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzgql.zzD(i));
    }

    static int zzt(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgsd) {
            zzgsd zzgsd = (zzgsd) list;
            i = 0;
            while (i2 < size) {
                long zze = zzgsd.zze(i2);
                i += zzgql.zzF((zze >> 63) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzgql.zzF((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzD = zzgql.zzD(i) * size;
        if (list instanceof zzgrw) {
            zzgrw zzgrw = (zzgrw) list;
            while (i4 < size) {
                Object zzf = zzgrw.zzf(i4);
                if (zzf instanceof zzgpw) {
                    i3 = zzgql.zzw((zzgpw) zzf);
                } else {
                    i3 = zzgql.zzC((String) zzf);
                }
                zzD += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgpw) {
                    i2 = zzgql.zzw((zzgpw) obj);
                } else {
                    i2 = zzgql.zzC((String) obj);
                }
                zzD += i2;
                i4++;
            }
        }
        return zzD;
    }

    static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzgql.zzD(i));
    }

    static int zzw(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgrf) {
            zzgrf zzgrf = (zzgrf) list;
            i = 0;
            while (i2 < size) {
                i += zzgql.zzE(zzgrf.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgql.zzE(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzx(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzgql.zzD(i));
    }

    static int zzy(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgsd) {
            zzgsd zzgsd = (zzgsd) list;
            i = 0;
            while (i2 < size) {
                i += zzgql.zzF(zzgsd.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgql.zzF(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzgty zzz() {
        return zzb;
    }
}
