package com.google.android.gms.internal.ads;

import com.shix.shixipc.viewpager.ImagePagerActivity;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfww extends zzfvn {
    static final zzfvn zza = new zzfww(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzfww(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzfsx.zza(i, this.zzc, ImagePagerActivity.INDEX);
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
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
