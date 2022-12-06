package com.google.android.gms.internal.common;

import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
public abstract class zzag<E> extends zzac<E> implements List<E>, RandomAccess {
    private static final zzak<Object> zza = new zzae(zzai.zza, 0);

    zzag() {
    }

    static <E> zzag<E> zzi(Object[] objArr, int i) {
        if (i == 0) {
            return zzai.zza;
        }
        return new zzai(objArr, i);
    }

    public static <E> zzag<E> zzj(Iterable<? extends E> iterable) {
        if (iterable == null) {
            throw null;
        } else if (iterable instanceof Collection) {
            return zzk((Collection) iterable);
        } else {
            Iterator<? extends E> it = iterable.iterator();
            if (!it.hasNext()) {
                return zzai.zza;
            }
            Object next = it.next();
            if (!it.hasNext()) {
                return zzm(next);
            }
            zzad zzad = new zzad(4);
            zzad.zzb(next);
            zzad.zzc(it);
            zzad.zzc = true;
            return zzi(zzad.zza, zzad.zzb);
        }
    }

    public static <E> zzag<E> zzk(Collection<? extends E> collection) {
        if (collection instanceof zzac) {
            zzag<E> zzd = ((zzac) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzah.zza(array2, length);
        return zzi(array2, length);
    }

    public static <E> zzag<E> zzl() {
        return zzai.zza;
    }

    public static <E> zzag<E> zzm(E e) {
        Object[] objArr = {e};
        zzah.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static <E> zzag<E> zzn(E e, E e2) {
        Object[] objArr = {e, e2};
        zzah.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
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
            boolean r4 = com.google.android.gms.internal.common.zzr.zza(r4, r5)
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
            boolean r3 = com.google.android.gms.internal.common.zzr.zza(r3, r4)
            if (r3 != 0) goto L_0x0039
            goto L_0x005c
        L_0x0055:
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L_0x005c
            goto L_0x0004
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.common.zzag.equals(java.lang.Object):boolean");
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
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Deprecated
    public final zzag<E> zzd() {
        return this;
    }

    public final zzaj<E> zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzag<E> subList(int i, int i2) {
        zzs.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzai.zza;
        }
        return new zzaf(this, i, i3);
    }

    /* renamed from: zzo */
    public final zzak<E> listIterator(int i) {
        zzs.zzb(i, size(), ImagePagerActivity.INDEX);
        if (isEmpty()) {
            return zza;
        }
        return new zzae(this, i);
    }
}
