package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfvc {
    /* access modifiers changed from: private */
    public static final zzfvc zza = new zzfva();
    /* access modifiers changed from: private */
    public static final zzfvc zzb = new zzfvb(-1);
    /* access modifiers changed from: private */
    public static final zzfvc zzc = new zzfvb(1);

    /* synthetic */ zzfvc(zzfva zzfva) {
    }

    public static zzfvc zzj() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfvc zzb(int i, int i2);

    public abstract zzfvc zzc(Object obj, Object obj2, Comparator comparator);

    public abstract zzfvc zzd(boolean z, boolean z2);

    public abstract zzfvc zze(boolean z, boolean z2);
}
