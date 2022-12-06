package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzari extends zzarq {
    private final StackTraceElement[] zzi;

    public zzari(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzaqe, "d2tnKFzXPwiZyQGi+81r0jKuUmc/wF2bs8mf3rZLUgisIeswnimQDm/skPYjpEo4", "e/DvqiTz4SkFtBEBn/3V8Pr2h2slHO4xuLOBAItCJ4w=", zzamk, i, 45);
        this.zzi = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Object obj = this.zzi;
        if (obj != null) {
            int i = 1;
            zzapw zzapw = new zzapw((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzF(zzapw.zza.longValue());
                if (zzapw.zzb.booleanValue()) {
                    zzamk zzamk = this.zze;
                    if (true != zzapw.zzc.booleanValue()) {
                        i = 2;
                    }
                    zzamk.zzac(i);
                } else {
                    this.zze.zzac(3);
                }
            }
        }
    }
}
