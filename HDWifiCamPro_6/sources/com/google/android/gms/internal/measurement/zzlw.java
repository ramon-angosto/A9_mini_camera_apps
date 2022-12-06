package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
final class zzlw {
    private static final Class zza;
    private static final zzml zzb = zzab(false);
    private static final zzml zzc = zzab(true);
    private static final zzml zzd = new zzmn();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzml zzA() {
        return zzc;
    }

    public static zzml zzB() {
        return zzd;
    }

    static Object zzC(int i, List list, zzkg zzkg, Object obj, zzml zzml) {
        if (zzkg == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            Object obj2 = obj;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzkg.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzD(i, intValue, obj2, zzml);
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
            if (!zzkg.zza(intValue2)) {
                obj = zzD(i, intValue2, obj, zzml);
                it.remove();
            }
        }
        return obj;
    }

    static Object zzD(int i, int i2, Object obj, zzml zzml) {
        if (obj == null) {
            obj = zzml.zze();
        }
        zzml.zzf(obj, i, (long) i2);
        return obj;
    }

    static void zzE(zzjp zzjp, Object obj, Object obj2) {
        zzjp.zza(obj2);
        throw null;
    }

    static void zzF(zzml zzml, Object obj, Object obj2) {
        zzml.zzh(obj, zzml.zzd(zzml.zzc(obj), zzml.zzc(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzkc.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzc(i, list, z);
        }
    }

    public static void zzI(int i, List list, zznd zznd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zze(i, list);
        }
    }

    public static void zzJ(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzg(i, list, z);
        }
    }

    public static void zzK(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzj(i, list, z);
        }
    }

    public static void zzL(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzl(i, list, z);
        }
    }

    public static void zzM(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzn(i, list, z);
        }
    }

    public static void zzN(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzp(i, list, z);
        }
    }

    public static void zzO(int i, List list, zznd zznd, zzlu zzlu) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzjk) zznd).zzq(i, list.get(i2), zzlu);
            }
        }
    }

    public static void zzP(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzs(i, list, z);
        }
    }

    public static void zzQ(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzu(i, list, z);
        }
    }

    public static void zzR(int i, List list, zznd zznd, zzlu zzlu) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((zzjk) zznd).zzv(i, list.get(i2), zzlu);
            }
        }
    }

    public static void zzS(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzx(i, list, z);
        }
    }

    public static void zzT(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzz(i, list, z);
        }
    }

    public static void zzU(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzB(i, list, z);
        }
    }

    public static void zzV(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzD(i, list, z);
        }
    }

    public static void zzW(int i, List list, zznd zznd) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzG(i, list);
        }
    }

    public static void zzX(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzI(i, list, z);
        }
    }

    public static void zzY(int i, List list, zznd zznd, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zznd.zzK(i, list, z);
        }
    }

    static boolean zzZ(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    static int zza(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjj.zzA(i << 3) + 1);
    }

    static void zzaa(zzle zzle, Object obj, Object obj2, long j) {
        zzmv.zzs(obj, j, zzle.zzb(zzmv.zzf(obj, j), zzmv.zzf(obj2, j)));
    }

    private static zzml zzab(boolean z) {
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
            return (zzml) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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
        int zzz = size * zzjj.zzz(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzz += zzjj.zzt((zzjb) list.get(i2));
        }
        return zzz;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjj.zzz(i));
    }

    static int zze(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i = 0;
            while (i2 < size) {
                i += zzjj.zzv(zzkd.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjj.zzv(((Integer) list.get(i2)).intValue());
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
        return size * (zzjj.zzA(i << 3) + 4);
    }

    static int zzg(List list) {
        return list.size() * 4;
    }

    static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjj.zzA(i << 3) + 8);
    }

    static int zzi(List list) {
        return list.size() * 8;
    }

    static int zzj(int i, List list, zzlu zzlu) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzjj.zzu(i, (zzlj) list.get(i3), zzlu);
        }
        return i2;
    }

    static int zzk(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjj.zzz(i));
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i = 0;
            while (i2 < size) {
                i += zzjj.zzv(zzkd.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjj.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzm(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjj.zzz(i));
    }

    static int zzn(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            i = 0;
            while (i2 < size) {
                i += zzjj.zzB(zzky.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjj.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, Object obj, zzlu zzlu) {
        if (!(obj instanceof zzkp)) {
            return zzjj.zzA(i << 3) + zzjj.zzx((zzlj) obj, zzlu);
        }
        int zzA = zzjj.zzA(i << 3);
        int zza2 = ((zzkp) obj).zza();
        return zzA + zzjj.zzA(zza2) + zza2;
    }

    static int zzp(int i, List list, zzlu zzlu) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjj.zzz(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzkp) {
                i2 = zzjj.zzw((zzkp) obj);
            } else {
                i2 = zzjj.zzx((zzlj) obj, zzlu);
            }
            zzz += i2;
        }
        return zzz;
    }

    static int zzq(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjj.zzz(i));
    }

    static int zzr(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i = 0;
            while (i2 < size) {
                int zze = zzkd.zze(i2);
                i += zzjj.zzA((zze >> 31) ^ (zze + zze));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzjj.zzA((intValue >> 31) ^ (intValue + intValue));
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
        return zzt(list) + (size * zzjj.zzz(i));
    }

    static int zzt(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            i = 0;
            while (i2 < size) {
                long zza2 = zzky.zza(i2);
                i += zzjj.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzjj.zzB((longValue >> 63) ^ (longValue + longValue));
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
        int zzz = zzjj.zzz(i) * size;
        if (list instanceof zzkr) {
            zzkr zzkr = (zzkr) list;
            while (i4 < size) {
                Object zzf = zzkr.zzf(i4);
                if (zzf instanceof zzjb) {
                    i3 = zzjj.zzt((zzjb) zzf);
                } else {
                    i3 = zzjj.zzy((String) zzf);
                }
                zzz += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzjb) {
                    i2 = zzjj.zzt((zzjb) obj);
                } else {
                    i2 = zzjj.zzy((String) obj);
                }
                zzz += i2;
                i4++;
            }
        }
        return zzz;
    }

    static int zzv(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjj.zzz(i));
    }

    static int zzw(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkd) {
            zzkd zzkd = (zzkd) list;
            i = 0;
            while (i2 < size) {
                i += zzjj.zzA(zzkd.zze(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjj.zzA(((Integer) list.get(i2)).intValue());
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
        return zzy(list) + (size * zzjj.zzz(i));
    }

    static int zzy(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzky) {
            zzky zzky = (zzky) list;
            i = 0;
            while (i2 < size) {
                i += zzjj.zzB(zzky.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzjj.zzB(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzml zzz() {
        return zzb;
    }
}
