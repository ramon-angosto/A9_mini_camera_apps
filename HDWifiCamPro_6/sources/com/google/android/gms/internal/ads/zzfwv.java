package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfwv implements Comparator {
    protected zzfwv() {
    }

    public static zzfwv zzb(Comparator comparator) {
        if (comparator instanceof zzfwv) {
            return (zzfwv) comparator;
        }
        return new zzfuz(comparator);
    }

    public static zzfwv zzc() {
        return zzfwt.zza;
    }

    public abstract int compare(Object obj, Object obj2);

    public zzfwv zza() {
        return new zzfxe(this);
    }
}
