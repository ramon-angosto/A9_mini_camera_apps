package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public class zzjf {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* synthetic */ zzjf(zzje zzje) {
        int i = zzb;
    }

    public static int zzb(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzc(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }
}
