package com.google.android.gms.internal.common;

import com.shix.shixipc.viewpager.ImagePagerActivity;

/* compiled from: com.google.android.gms:play-services-basement@@18.0.0 */
final class zzai<E> extends zzag<E> {
    static final zzag<Object> zza = new zzai(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzai(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final E get(int i) {
        zzs.zza(i, this.zzc, ImagePagerActivity.INDEX);
        E e = this.zzb[i];
        e.getClass();
        return e;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzg() {
        return this.zzb;
    }
}
