package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzarq implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzaqe zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzamk zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzarq(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2) {
        this.zzb = zzaqe;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzamk;
        this.zzg = i;
        this.zzh = i2;
    }

    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzk();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzk() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            this.zzf = this.zzb.zzj(this.zzc, this.zzd);
            if (this.zzf == null) {
                return null;
            }
            zza();
            zzaoz zzd2 = this.zzb.zzd();
            if (!(zzd2 == null || (i = this.zzg) == Integer.MIN_VALUE)) {
                zzd2.zzc(this.zzh, i, (System.nanoTime() - nanoTime) / 1000, (String) null, (Exception) null);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
