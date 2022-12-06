package com.google.android.gms.internal.ads;

import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfvn extends zzfvi implements List, RandomAccess {
    private static final zzfxn zza = new zzfvl(zzfww.zza, 0);

    zzfvn() {
    }

    public static zzfvk zzi() {
        return new zzfvk(4);
    }

    static zzfvn zzj(Object[] objArr) {
        return zzk(objArr, objArr.length);
    }

    static zzfvn zzk(Object[] objArr, int i) {
        if (i == 0) {
            return zzfww.zza;
        }
        return new zzfww(objArr, i);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfvn zzl(java.lang.Iterable r0) {
        /*
            if (r0 == 0) goto L_0x0007
            com.google.android.gms.internal.ads.zzfvn r0 = zzm(r0)
            return r0
        L_0x0007:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvn.zzl(java.lang.Iterable):com.google.android.gms.internal.ads.zzfvn");
    }

    public static zzfvn zzm(Collection collection) {
        if (collection instanceof zzfvi) {
            zzfvn zzd = ((zzfvi) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzk(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzfwu.zzb(array2, length);
        return zzk(array2, length);
    }

    public static zzfvn zzn(Object[] objArr) {
        if (objArr.length == 0) {
            return zzfww.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzfwu.zzb(objArr2, length);
        return zzk(objArr2, length);
    }

    public static zzfvn zzo() {
        return zzfww.zza;
    }

    public static zzfvn zzp(Object obj) {
        Object[] objArr = {obj};
        zzfwu.zzb(objArr, 1);
        return zzk(objArr, 1);
    }

    public static zzfvn zzq(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzfwu.zzb(objArr, 2);
        return zzk(objArr, 2);
    }

    public static zzfvn zzr(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {"2011", "1009", "3010"};
        zzfwu.zzb(objArr, 3);
        return zzk(objArr, 3);
    }

    public static zzfvn zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzfwu.zzb(objArr, 5);
        return zzk(objArr, 5);
    }

    public static zzfvn zzt(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {"3010", "3008", "1005", "1009", "2011", "2007"};
        zzfwu.zzb(objArr, 6);
        return zzk(objArr, 6);
    }

    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(@javax.annotation.CheckForNull java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r7 != r6) goto L_0x0006
        L_0x0004:
            r1 = r0
            goto L_0x005c
        L_0x0006:
            boolean r2 = r7 instanceof java.util.List
            if (r2 != 0) goto L_0x000b
            goto L_0x005c
        L_0x000b:
            java.util.List r7 = (java.util.List) r7
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0018
            goto L_0x005c
        L_0x0018:
            boolean r3 = r7 instanceof java.util.RandomAccess
            if (r3 == 0) goto L_0x0031
            r3 = r1
        L_0x001d:
            if (r3 >= r2) goto L_0x0004
            java.lang.Object r4 = r6.get(r3)
            java.lang.Object r5 = r7.get(r3)
            boolean r4 = com.google.android.gms.internal.ads.zzfss.zza(r4, r5)
            if (r4 != 0) goto L_0x002e
            goto L_0x005c
        L_0x002e:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x0031:
            java.util.Iterator r2 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L_0x0039:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0055
            boolean r3 = r7.hasNext()
            if (r3 != 0) goto L_0x0046
            goto L_0x005c
        L_0x0046:
            java.lang.Object r3 = r2.next()
            java.lang.Object r4 = r7.next()
            boolean r3 = com.google.android.gms.internal.ads.zzfss.zza(r3, r4)
            if (r3 != 0) goto L_0x0039
            goto L_0x005c
        L_0x0055:
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x005c
            goto L_0x0004
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvn.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final zzfvn zzd() {
        return this;
    }

    public final zzfxm zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzfvn subList(int i, int i2) {
        zzfsx.zzg(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzfww.zza;
        }
        return new zzfvm(this, i, i3);
    }

    /* renamed from: zzu */
    public final zzfxn listIterator(int i) {
        zzfsx.zzb(i, size(), ImagePagerActivity.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzfvl(this, i);
    }
}
