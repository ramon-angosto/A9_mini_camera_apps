package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public abstract class zzfhz {
    /* access modifiers changed from: private */
    public static final zzfzp zza = zzfzg.zzi((Object) null);
    /* access modifiers changed from: private */
    public final zzfzq zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzfia zzd;

    public zzfhz(zzfzq zzfzq, ScheduledExecutorService scheduledExecutorService, zzfia zzfia) {
        this.zzb = zzfzq;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfia;
    }

    public final zzfhp zza(Object obj, zzfzp... zzfzpArr) {
        return new zzfhp(this, obj, Arrays.asList(zzfzpArr), (zzfho) null);
    }

    public final zzfhy zzb(Object obj, zzfzp zzfzp) {
        return new zzfhy(this, obj, (String) null, zzfzp, Collections.singletonList(zzfzp), zzfzp, (zzfhx) null);
    }

    /* access modifiers changed from: protected */
    public abstract String zzf(Object obj);
}
