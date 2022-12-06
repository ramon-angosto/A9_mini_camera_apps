package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public abstract class zzfpi implements Closeable {
    public static zzfpu zza() {
        return new zzfpu();
    }

    public static zzfpu zzb(int i, zzfpt zzfpt) {
        return new zzfpu(new zzfpg(i), zzfph.zza, zzfpt);
    }

    public static zzfpu zzc(zzftn<Integer> zzftn, zzftn<Integer> zzftn2, zzfpt zzfpt) {
        return new zzfpu(zzftn, zzftn2, zzfpt);
    }

    static /* synthetic */ Integer zze() {
        return -1;
    }
}
