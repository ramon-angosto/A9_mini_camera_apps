package com.google.android.gms.internal.ads;

import com.shix.shixipc.viewpager.ImagePagerActivity;
import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfwx extends zzfvn {
    final /* synthetic */ zzfwy zza;

    zzfwx(zzfwy zzfwy) {
        this.zza = zzfwy;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzfsx.zza(i, this.zza.zzc, ImagePagerActivity.INDEX);
        zzfwy zzfwy = this.zza;
        int i2 = i + i;
        Object obj = zzfwy.zzb[i2];
        obj.getClass();
        Object obj2 = zzfwy.zzb[i2 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
