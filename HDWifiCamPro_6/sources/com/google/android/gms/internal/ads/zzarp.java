package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzarp {
    protected static final String zza = zzarp.class.getSimpleName();
    private final zzaqe zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzarp(zzaqe zzaqe, String str, String str2, Class... clsArr) {
        this.zzb = zzaqe;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        this.zzb.zzk().submit(new zzaro(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzarp zzarp) {
        CountDownLatch countDownLatch;
        try {
            zzaqe zzaqe = zzarp.zzb;
            Class loadClass = zzaqe.zzi().loadClass(zzarp.zzc(zzaqe.zzu(), zzarp.zzc));
            if (loadClass == null) {
                countDownLatch = zzarp.zzg;
            } else {
                zzarp.zze = loadClass.getMethod(zzarp.zzc(zzarp.zzb.zzu(), zzarp.zzd), zzarp.zzf);
                if (zzarp.zze == null) {
                    countDownLatch = zzarp.zzg;
                }
                countDownLatch = zzarp.zzg;
            }
        } catch (zzapj | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzarp.zzg;
        } catch (Throwable th) {
            zzarp.zzg.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzapj, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
