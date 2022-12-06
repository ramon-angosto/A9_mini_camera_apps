package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzare extends zzarq {
    public zzare(zzaqe zzaqe, String str, String str2, zzamk zzamk, int i, int i2) {
        super(zzaqe, "vkfQoQl1Rxr7/uvSSRcOrQI31A6S/KAPW33nf5P0hYbuVy6BLjHzjUB4OEnneXoS", "SfaCE2ReDSQ3+KDKcvA6SSrX7nuWYsM/FN3ZFmlH0dA=", zzamk, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzay.zzc().zzb(zzbjc.zzck)).booleanValue();
        zzapl zzapl = new zzapl((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zze) {
            this.zze.zzj(zzapl.zza);
            this.zze.zzC(zzapl.zzb);
        }
    }
}
