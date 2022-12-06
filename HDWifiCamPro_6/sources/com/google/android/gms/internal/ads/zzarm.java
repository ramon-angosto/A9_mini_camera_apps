package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzarm extends zzarq {
    public zzarm(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2) {
        super(zzaqe, "6CWPidOWJZFxRWI8V7yi3OiMbOhIWZX/jTayTGRwqCM0W8dtKHQOPe60TuQicfhG", "gYPijpNio6OwLgbzbH6IuWSNtvp7bCV5UMbKZJCVNdg=", zzamk, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzaf(3);
        boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
        synchronized (this.zze) {
            if (booleanValue) {
                this.zze.zzaf(2);
            } else {
                this.zze.zzaf(1);
            }
        }
    }
}
