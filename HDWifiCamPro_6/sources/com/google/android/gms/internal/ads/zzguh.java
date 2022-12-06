package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
abstract class zzguh {
    final Unsafe zza;

    zzguh(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(long j);

    public abstract double zzb(Object obj, long j);

    public abstract float zzc(Object obj, long j);

    public abstract void zzd(long j, byte[] bArr, long j2, long j3);

    public abstract void zze(Object obj, long j, boolean z);

    public abstract void zzf(Object obj, long j, byte b);

    public abstract void zzg(Object obj, long j, double d);

    public abstract void zzh(Object obj, long j, float f);

    public abstract boolean zzi(Object obj, long j);

    public final int zzj(Class cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzk(Class cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzl(Object obj, long j) {
        return this.zza.getInt(obj, j);
    }

    public final long zzm(Object obj, long j) {
        return this.zza.getLong(obj, j);
    }

    public final long zzn(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzo(Object obj, long j) {
        return this.zza.getObject(obj, j);
    }

    public final void zzp(Object obj, long j, int i) {
        this.zza.putInt(obj, j, i);
    }

    public final void zzq(Object obj, long j, long j2) {
        this.zza.putLong(obj, j, j2);
    }

    public final void zzr(Object obj, long j, Object obj2) {
        this.zza.putObject(obj, j, obj2);
    }
}
