package com.google.android.gms.internal.ads;

import com.shix.shixipc.viewpager.ImagePagerActivity;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfxa extends zzfvn {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzfxa(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzfsx.zza(i, this.zzc, ImagePagerActivity.INDEX);
        Object obj = this.zza[i + i + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }
}
